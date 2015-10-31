using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ado
{
    public class Cargo
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Situacao { get; set; }

        public Cargo(string nome, string situacao)
        {

        }
    }
}
