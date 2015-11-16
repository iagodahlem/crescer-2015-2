using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            //TODO: ajustar testes
            //Jogo jogoA = new Jogo(id: 1, Cliente.Id: null);
            //Jogo jogoB = new Jogo(id: 1, cliente.Id: null);

            //Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.LocarPara(new Cliente(id: 1));

            Assert.AreEqual(1, jogo.Cliente.Id);
        }
    }
}
