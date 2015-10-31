using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            var operacao = new Operacao();

            while (true)
            {
                Console.Clear();

                // Menu
                var menu = new Menu();

                // Seleciona o operação executando-a
                operacao.SelecionaOperacao();
            }
        }
    }
}
