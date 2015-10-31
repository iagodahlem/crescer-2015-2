using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Menu
    {   
        public Menu()
        {
            LinhaSuperior();
            Espaco();
            LinhaMeio();
            Espaco();
            Espaco();
            MensagensOperacao();
            Espaco();
            LinhaInferior();
            Operacoes();
        }

        void LinhaSuperior()
        {
            for (int i = 0; i < 80; i++)
            {
                Console.Write("*");
            }
        }

        void Espaco()
        {
            Console.Write("*");
            for (int i = 0; i < 78; i++)
            {
                Console.Write(" ");
            }
            Console.Write("*");
        }

        void LinhaMeio()
        {
            Console.Write("*");
            for (int i = 0; i < 31; i++)
            {
                Console.Write(" ");
            }

            Console.Write(Mensagens.TITULO);

            for (int i = 0; i < 30; i++)
            {
                Console.Write(" ");
            }
            Console.Write("*");
        }

        void LinhaInferior()
        {
            for (int i = 0; i < 80; i++)
            {
                Console.Write("*");
            }
            Console.WriteLine();
        }

        void MensagensOperacao()
        {
            int tamanhoDeUmaLinha = 78;
            int centralizar = (tamanhoDeUmaLinha - Mensagens.TIPOS_OPERACAO.Length) / 2;

            Console.Write("*");
            for (int i = 0; i < centralizar; i++)
            {
                Console.Write(" ");
            }

            Console.Write(Mensagens.TIPOS_OPERACAO);

            for (int i = 0; i < centralizar; i++)
            {
                Console.Write(" ");
            }
            Console.Write("*");
        }

        void Operacoes()
        {
            
            for (int i = 0; i < 7; i++)
            {
                Console.Write(" ");
            }

            Console.Write(Mensagens.MENSAGEM_OPERACOES);

            for (int i = 0; i < 7; i++)
            {
                Console.Write(" ");
            }
        }
    }
}
