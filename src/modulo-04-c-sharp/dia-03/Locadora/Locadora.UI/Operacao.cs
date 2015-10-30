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

        // Variaveis para utilização nos métodos
        string nome;
        double preco;
        Categoria categoria;

        // Operação Cadastro de Novo Jogo
        public void Cadastrar()
        {
            Console.WriteLine(Mensagens.DIGITAR_NOME_JOGO);
            nome = Console.ReadLine();

            Console.WriteLine(Mensagens.DIGITAR_PRECO_JOGO);
            preco = Console.Read();

            Console.WriteLine(Mensagens.DIGITAR_CATEGORIA_JOGO);
            categoria = VerificaCategoria(Console.Read());

            baseDeDados.CadastrarJogo(nome, preco, categoria);
        }

        public void Pesquisar()
        {
            Console.WriteLine(Mensagens.DIGITAR_NOME_JOGO_PESQUISA);
            nome = Console.ReadLine();
            var listaJogos = baseDeDados.PesquisaJogoPorNome(nome);
            foreach (var jogo in listaJogos)
            {
                Console.WriteLine("ID: {0}", jogo.Id);
                Console.WriteLine("Nome: {0}", jogo.Nome);
                Console.WriteLine("Preco: {0}", jogo.Preco);
                Console.WriteLine("Categoria: {0}", jogo.Categoria);
            }
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
    }
}
