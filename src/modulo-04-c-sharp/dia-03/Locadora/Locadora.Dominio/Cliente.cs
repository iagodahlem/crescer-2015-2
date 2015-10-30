using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Cliente
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        public Cliente(string nome)
        {
            Id += 1;
            this.Nome = nome;
        }
    }
}
