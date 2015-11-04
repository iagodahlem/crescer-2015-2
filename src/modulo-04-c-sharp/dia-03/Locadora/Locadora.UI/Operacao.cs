using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    public class Operacao
    {
        // Base
        BaseDeDados baseDeDados = new BaseDeDados();

        // Constantes para operações
        string operacao;
        const string cadastrar = "c";
        const string pesquisar = "p";
        const string editar = "e";
        const string exportar = "x";
        const string sair = "q";

        // Variaveis para utilização nos métodos
        string nome;
        decimal preco;
        Categoria categoria;

        // Método para selecionar Operação a ser executada
        public void SelecionaOperacao()
        {
            // Operações
            operacao = Console.ReadLine();

            switch (operacao)
            {
                case cadastrar:
                    {
                        Cadastrar();
                        break;
                    }

                case pesquisar:
                    {
                        Pesquisar();
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
                        OperacaoInvalida();
                        break;
                    }
                    sair:
                    break;
            }
        }

        // Operação Cadastro de Novo Jogo
        public void Cadastrar()
        {
            Console.Clear();

            Console.WriteLine(Mensagens.DIGITAR_NOME_JOGO);
            nome = Console.ReadLine();
            Console.Clear();

            Console.WriteLine(Mensagens.DIGITAR_PRECO_JOGO);
            preco = Console.Read();
            Console.Clear();

            Console.WriteLine(Mensagens.DIGITAR_CATEGORIA_JOGO);
            categoria = VerificaCategoria(Console.Read());
            Console.Clear();

            baseDeDados.CadastrarJogo(nome, preco, categoria);

            Console.WriteLine(Environment.NewLine + Mensagens.VOLTAR_MENU);

            Console.Read();
        }

        public Categoria VerificaCategoria(int categoriaValor)
        {
            Categoria resultadoCategoria = Categoria.RPG;
            if (categoriaValor == 0)
            {
                resultadoCategoria = Categoria.RPG;
            }
            if (categoriaValor == 1)
            {
                resultadoCategoria = Categoria.CORRIDA;
            }
            if (categoriaValor == 2)
            {
                resultadoCategoria = Categoria.AVENTURA;
            }
            if (categoriaValor == 3)
            {
                resultadoCategoria = Categoria.LUTA;
            }
            if (categoriaValor == 4)
            {
                resultadoCategoria = Categoria.ESPORTE;
            }
            return resultadoCategoria;
        }

        public void Pesquisar()
        {
            Console.Clear();

            Console.WriteLine(Mensagens.DIGITAR_NOME_JOGO_PESQUISA);
            nome = Console.ReadLine();

            Console.Clear();

            var listaJogos = baseDeDados.PesquisaJogoPorNome(nome);
            foreach (var jogo in listaJogos)
            {
                Console.WriteLine("ID: {0}", jogo.Id);
                Console.WriteLine("Nome: {0}", jogo.Nome);
                Console.WriteLine("Preco: {0}", jogo.Preco);
                Console.WriteLine("Categoria: {0}", jogo.Categoria);
            }

            Console.WriteLine(Environment.NewLine + Mensagens.VOLTAR_MENU);

            Console.Read();
        }

        public void OperacaoInvalida()
        {
            Console.Clear();
            Console.WriteLine(Mensagens.OPERACAO_INVALIDA);
            Console.WriteLine(Environment.NewLine + Mensagens.VOLTAR_MENU);
            Console.Read();
        }
    }
}
