using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class JogoLocacaoModel
    {
        public int? Id { get; set; }
        public string Nome { get; set; }
        public DateTime DataEntrega { get; set; }
        public decimal Valor { get; set; }
        public Selo Selo { get; set; }
        public string Imagem { get; set; }
        public string NomeCliente { get; set; }
    }
}
