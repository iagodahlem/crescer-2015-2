using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public decimal Preco { get; private set; }
        public Categoria Categoria { get; private set; }

        public Jogo(int id, string nome, decimal preco, Categoria categoria)
        {
            Id = id;
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }

        public override bool Equals(object obj)
        {
            Jogo comparando = (Jogo)obj;
            return Id == comparando.Id && Nome == comparando.Nome
                && Preco == comparando.Preco && Categoria == comparando.Categoria;
        }
    }
}
