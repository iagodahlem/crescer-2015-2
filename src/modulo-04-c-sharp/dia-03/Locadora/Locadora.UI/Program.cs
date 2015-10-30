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
            // Constantes para operações
            const string cadastrar = "c";
            const string pesquisar = "p";
            const string editar = "e";
            const string exportar = "x";
            const string sair = "q";
            string operacao;

            while (true)
            {
                Console.Clear();

                // Menu
                var menu = new Menu();

                // Operações
                Console.WriteLine("Digite a letra correspondente com a operação que deseja realizar: {0}C - Cadastrar novo jogo {0}P - Pesquisar jogo pelo nome", Environment.NewLine);
                operacao = Console.ReadLine();
                var operacoes = new Operacao();

                switch (operacao)
                {
                    case cadastrar:
                        {
                            operacoes.Cadastrar();
                            break;
                        }

                    case pesquisar:
                        {
                            operacoes.Pesquisar();
                            break;
                        }

                    case editar:
                        {
                            break;
                        }

                    case exportar:
                        {
                            break;
                        }

                    case sair:
                        {
                            goto sair;
                        }

                    default:
                        {
                            Console.WriteLine(Mensagens.OPERACAO_INVALIDA);
                            break;
                        }
                    sair:
                    break;
                }
            }
        }
    }
}
