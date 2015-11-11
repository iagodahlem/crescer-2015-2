using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.Repositorio.EF.Mapping
{
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
}
