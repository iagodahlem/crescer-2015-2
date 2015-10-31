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
        public double Preco { get; private set; }
        public Categoria Categoria { get; private set; }

        public Jogo(int id, string nome, double preco, Categoria categoria)
        {
            Id = id;
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }

        public override string ToString()
        {
            string jogoEmLinha;
            string espaco = " ";

            string espacoID = " ";
            for (int i = 0; i < 5; i++)
            {
                espacoID += espaco;
            }

            string espacoNome = " ";
            for (int i = 0; i < 20; i++)
            {
                espacoNome += espaco;
            }

            string espacoPreco = " ";
            for (int i = 0; i < 20; i++)
            {
                espacoPreco += espaco;
            }

            jogoEmLinha = String.Format("{1} {2} {3} {4} {5} {6} {7}", Id, espacoID, Nome, espacoNome, Preco, espacoPreco, Categoria);
            return jogoEmLinha;
        }
    }
}
