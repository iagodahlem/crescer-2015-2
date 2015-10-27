using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {
            var agenda = new Agenda();
            var operacao = "";
            var valida = true;

            while (true)
            {
                Console.Clear();

                // HEADER
                for (int i = 0; i < 81; i++)
                {
                    Console.Write("*");
                }

                for (int i = 0; i < 30; i++)
                {
                    Console.Write(" ");
                }

                Console.Write("AGENDA DE CONTATOS");

                for (int i = 0; i < 30; i++)
                {
                    Console.Write(" ");
                }

                for (int i = -1; i < 80; i++)
                {
                    Console.Write("*");
                }

                Console.WriteLine();

                Console.WriteLine("Digite a letra referente a sua respectiva operação para realiza-lá");
                Console.WriteLine("(digite Q para sair)");
                Console.WriteLine("L - Listar Contatos | O - Listar Contatos Ordenados | A - Adicionar Contato");
                Console.WriteLine("R - Remover Contato pelo Nome | N - Remover Contato pelo Numero");
                operacao = Console.ReadLine();

                valida = operacao != null || operacao == "l" || operacao == "o" || operacao == "a" || operacao == "r" || operacao == "n" || operacao == "q" ? true : false;

                if (valida)
                {
                    if (operacao == "l")
                    {
                        Console.WriteLine("Nome : Numero");

                        Console.WriteLine(agenda.ListarContatos());
                        Console.ReadLine();
                    }

                    if (operacao == "o")
                    {

                    }

                    if (operacao == "a")
                    {
                        var nome = "";
                        var numero = 0;

                        Console.WriteLine("Digite o nome do contato: ");
                        nome = Console.ReadLine();
                        Console.WriteLine("Digite o número do contato: ");
                        numero = Console.Read();
                        agenda.AdicionarContato(new Contato(nome, numero));
                    }

                    if (operacao == "r")
                    {
                        var nome = "";

                        Console.WriteLine("Digite o nome do contato a ser removido: ");
                        nome = Console.ReadLine();
                        agenda.RemoverContatosPorNome(nome);
                    }

                    if (operacao == "n")
                    {
                        var numero = 0;

                        Console.WriteLine("Digite o número do contato a ser removido: ");
                        numero = Console.Read();
                        agenda.RemoverContatoPorNumero(numero);
                    }

                    if (operacao == "q")
                    {
                        break;
                    }
                }
            }
        }
    }
}
