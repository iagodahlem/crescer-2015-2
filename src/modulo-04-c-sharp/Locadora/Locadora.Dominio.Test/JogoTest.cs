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
            var cliente = new Cliente();

            var jogoA = new Jogo(id: 1, cliente: cliente);
            var jogoB = new Jogo(id: 1, cliente: cliente);

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            var jogo = new Jogo();

            jogo.LocarPara(new Cliente(id: 1));

            Assert.AreEqual(1, jogo.Cliente.Id);
        }

        [TestMethod]
        public void JogoRecebeImagemNull()
        {
            var jogo = new Jogo(id: 1);
            string imagemObtida = jogo.URLImagem;

            string resultadoEsperado = null;

            Assert.AreEqual(imagemObtida, resultadoEsperado);
        }

        [TestMethod]
        public void JogoRecebeImagemEsperada()
        {
            var jogo = new Jogo()
            {
                URLImagem = "ibagem do batman"
            };
            string imagemObtida = jogo.URLImagem;

            string imagemEsperada = "ibagem do batman";

            Assert.AreEqual(imagemObtida, imagemEsperada);
        }

        [TestMethod]
        public void JogoRecebeVideoNull()
        {
            var jogo = new Jogo(id: 1);
            string videoObtido = jogo.URLVideo;

            string resultadoEsperado = null;

            Assert.AreEqual(videoObtido, resultadoEsperado);
        }

        [TestMethod]
        public void JogoRecebeVideoEsperada()
        {
            var jogo = new Jogo()
            {
                URLImagem = "video secret dos iluminati"
            };
            string videoObtido = jogo.URLImagem;

            string videoEsperado = "video secret dos iluminati";

            Assert.AreEqual(videoObtido, videoEsperado);
        }
    }
}
