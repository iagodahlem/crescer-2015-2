using Locadora.Dominio;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        //TODO: criar pasta mapping 
        //TODO: Separar maps em classes distintas 

        public BancoDeDados() : base("LOCADORA_CODE_FIRST")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    public class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(k => k.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(250);
            Property(p => p.Preco).IsRequired().HasPrecision(19, 2);
            Property(p => p.Categoria).IsRequired().HasColumnName("IdCategoria");
            Property(p => p.Descricao).IsRequired();
            Property(p => p.Selo).IsRequired().HasColumnName("IdSelo");
            Property(p => p.URLImagem).IsOptional();
            Property(p => p.URLVideo).IsOptional();

            HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
        }
    }

    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(k => k.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(250);
        }
    }

    public class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");
            HasKey(u => u.Id);

            Property(u => u.NomeCompleto).IsRequired().HasMaxLength(200);
            Property(u => u.Email).IsRequired().HasMaxLength(200);
            Property(u => u.Senha).IsRequired().HasMaxLength(200);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                                      .Map(m => 
                                      {
                                          m.ToTable("Usuario_Permissao");
                                          m.MapLeftKey("IdUsuario");
                                          m.MapRightKey("IdPermissao");
                                      });
        }
    }

    public class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");
            HasKey(u => u.Id);

            Property(u => u.Nome).IsRequired().HasMaxLength(50);
        }
    }
}
