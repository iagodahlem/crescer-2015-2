using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Dominio;

namespace UrnaTeste
{
    [TestClass]
    public class CargoTeste
    {
        [TestMethod]
        public void InsereCargoNoBanco()
        {
            // arrange
            var cargo = new Cargo(1, "Deputado", 'A');
            int quantidadeEsperada = 3;

            // act
            Services.CargoService.Inserir(cargo);
            int quantidadeObtida = Repositorio.CargoRepositorio.GetQuantidadeDeCargos();

            //assert
            Assert.AreEqual(quantidadeEsperada, quantidadeObtida);
        }

        [TestMethod]
        public void NãoInsereCargoNoBancoComNomeJáExistente()
        {
            // arrange
            var cargo = new Cargo(2, "Deputado", 'A');
            int quantidadeEsperada = 3;

            // act
            Services.CargoService.Inserir(cargo);
            int quantidadeObtida = Repositorio.CargoRepositorio.GetQuantidadeDeCargos();

            //assert
            Assert.AreEqual(quantidadeEsperada, quantidadeObtida);
        }
    }
}
