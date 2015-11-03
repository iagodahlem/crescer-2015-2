using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio
{
    public class Cargo
    {
        public int IDCargo { get; private set; }
        public string Nome { get; private set; }
        public char Situacao { get; private set; }

        public Cargo(int idCargo, string nome, char situacao)
        {
            IDCargo = idCargo;
            Nome = nome;
            Situacao = situacao;
        }
    }
}
