using Locadora.Dominio;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA_CODE_FIRST")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
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
            Property(p => p.Imagem).IsOptional();
            Property(p => p.Video).IsOptional();

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
}
