using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class JogoDetalhesModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public Categoria Categoria { get; set; }
        public string Descricao { get; set; }
        public Selo Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }
    }
}
