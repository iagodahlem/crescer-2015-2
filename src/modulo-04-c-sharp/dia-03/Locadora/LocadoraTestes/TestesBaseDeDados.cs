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
    }
}
