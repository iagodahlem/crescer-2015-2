using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace LocadoraTestes
{
    [TestClass]
    public class TestesBaseDeDados
    {
        [TestMethod]
        public void BaseDeDadosRecebeNovoJogoEQuantidadeEh21()
        {
            // arrange
            BaseDeDados baseDeDados = new BaseDeDados();
            int quantidadeEsperada = 21;

            // act
            baseDeDados.CadastrarJogoTeste("Harry Potter X", 100, Categoria.AVENTURA);
            int quantidadeObtida = baseDeDados.GetQuantidadeDeJogos();

            // assert
            Assert.AreEqual(quantidadeEsperada, quantidadeObtida);
        }

        [TestMethod]
        public void BaseDeDadosRecebeDoisJogosEQuantidadeÉ22()
        {
            // arrange
            BaseDeDados baseDeDados = new BaseDeDados();
            int quantidadeEsperada = 22;

            // act
            baseDeDados.CadastrarJogoTeste("Harry Potter X", 100, Categoria.AVENTURA);
            baseDeDados.CadastrarJogoTeste("Harry Potter 30", 100, Categoria.AVENTURA);
            int quantidadeObtida = baseDeDados.GetQuantidadeDeJogos();

            // assert
            Assert.AreEqual(quantidadeEsperada, quantidadeObtida);
        }

        [TestMethod]
        public void NovoJogoCadastradoERecebeOIdSeguinteAoElementoAnterior()
        {
            // arrange
            var baseDeDados = new BaseDeDados();
            int idEsperado = 21;

            // act
            baseDeDados.CadastrarJogoTeste("GTA V", 100, Categoria.AVENTURA);
            int idObtido = baseDeDados.GetIdJogo();

            // assert
            Assert.AreEqual(idEsperado, idObtido);
        }

        [TestMethod]
        public void DoisJogosCadastradosERecebeOIdSeguinteAoElementoAnterior()
        {
            // arrange
            var baseDeDados = new BaseDeDados();
            int idEsperado = 22;

            // act
            baseDeDados.CadastrarJogoTeste("GTA V", 100, Categoria.AVENTURA);
            baseDeDados.CadastrarJogoTeste("GTA X", 100, Categoria.AVENTURA);
            int idObtido = baseDeDados.GetIdJogo();

            // assert
            Assert.AreEqual(idEsperado, idObtido);
        }

        [TestMethod]
        public void PesquisaJogoERetornaNomeCorreto()
        {
            // arrange
            var baseDeDados = new BaseDeDados();
            var jogoEsperado = new Jogo(1 ,"Top Gear", 20, Categoria.CORRIDA);
            string nomeEsperado = jogoEsperado.Nome;
            double precoEsperado = jogoEsperado.Preco;

            // act
            var jogoObtido = baseDeDados.PesquisaJogoPorNome("Top Gear");
            string nomeObtido = jogoObtido[0].Nome;

            // assert
            Assert.AreEqual(nomeEsperado, nomeObtido);
        }

        [TestMethod]
        public void PesquisaJogoERetornaPrecoCorreto()
        {
            // arrange
            var baseDeDados = new BaseDeDados();
            var jogoEsperado = new Jogo(1, "Top Gear", 20, Categoria.CORRIDA);
            double precoEsperado = jogoEsperado.Preco;

            // act
            var jogoObtido = baseDeDados.PesquisaJogoPorNome("Top Gear");
            double precoObtido = jogoObtido[0].Preco;

            // assert
            Assert.AreEqual(precoEsperado, precoObtido);
        }
    }
}
