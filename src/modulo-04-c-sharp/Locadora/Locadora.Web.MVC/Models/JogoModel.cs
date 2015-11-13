using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public Categoria Categoria { get; set; }
        public Selo Selo { get; set; }
    }
}