using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> ListaJogos { get; set; }
        public int QuantidadeTotal { get; set; }
        public decimal ValorMedio { get; set; }
        public decimal JogoMaisCaro { get; set; }
        public decimal JogoMaisBarato { get; set; }

        public RelatorioModel()
        {
            ListaJogos = new List<JogoModel>();
        }
    }
}
