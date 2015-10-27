using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Contato
    {
        // Propriedade Nome com método get public e set private
        public string Nome { get; private set; }
        // Propriedade Numero com método get public e set private
        public int Numero { get; private set; }

        // Construtor de Contato
        public Contato(string nome, int numero)
        {
            this.Nome = nome;
            this.Numero = numero;
        }

        // Propriedade automaticas do VS
        /*
        public string Nome { get; set; }
        public int Numero { get; set; }
        */

        // Propriedade feito na mão
        // Utilizado quando precisa se fazer um tratamento
        /*
        private string nome;
        private int numero;

        public string Nome
        {
            get { return nome;  }
            set { nome = value;  }
        }
        */

        // Métodos estilo Java
        /*
        public string GetNome()
        {
            return this.nome;
        }

        public void SetNome(string nome)
        {
            this.nome = nome;
        }
        */
    }
}
