using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio
{
    public class Eleitor
    {
        public int IdEleitor { get; set; }
        public string Nome { get; set; }
        public long TituloEleitoral { get; set; }
        public string RG { get; set; }
        public string CPF { get; set; }
        public DateTime DataNascimento { get; set; }
        public int ZonaEleitoral { get; set; }
        public string Secao { get; set; }
        public char Situacao { get; set; }
        public char Votou { get; set; }
    }
}
