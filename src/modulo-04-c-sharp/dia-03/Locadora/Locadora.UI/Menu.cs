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
            LinhaMeio();
            LinhaInferior();
        }

        void LinhaSuperior()
        {
            for (int i = 0; i < 81; i++)
            {
                Console.Write("*");
            }
        }

        void LinhaMeio()
        {
            for (int i = 0; i < 31; i++)
            {
                Console.Write(" ");
            }

            Console.Write(Mensagens.TITULO);

            for (int i = 0; i < 30; i++)
            {
                Console.Write(" ");
            }
        }

        void LinhaInferior()
        {
            for (int i = -1; i < 80; i++)
            {
                Console.Write("*");
            }

            Console.WriteLine();
        }
    }
}
