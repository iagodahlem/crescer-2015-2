using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace LocadoraTestes
{
    [TestClass]
    public class TestesBaseDeDados
    {
        [TestMethod]
        public void BaseDeDadosRecebeNovoJogoEQuantidadeÉ21()
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
        public void UmJogoCadastradoERecebeOIdSeguinteAoElementoAnterior()
        {
            // arrange
            var baseDeDados = new BaseDeDados();
            int idEsperado = 21;

            // act
            baseDeDados.CadastrarJogoTeste("GTA V", 100, Categoria.AVENTURA);
            int idObtido = baseDeDados.GetIdUltimoJogo();

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
            int idObtido = baseDeDados.GetIdUltimoJogo();

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
            decimal precoEsperado = jogoEsperado.Preco;

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
            decimal precoEsperado = jogoEsperado.Preco;

            // act
            var jogoObtido = baseDeDados.PesquisaJogoPorNome("Top Gear");
            decimal precoObtido = jogoObtido[0].Preco;

            // assert
            Assert.AreEqual(precoEsperado, precoObtido);
        }

        [TestMethod]
        public void EditarJogo()
        {
            // arrange
            var baseDeDados = new BaseDeDados();
            var jogoEsperado = new Jogo(1, "Chrono Trigger Editado", 60, Categoria.RPG);

            // act
            baseDeDados.EditarJogo(1, "Chrono Trigger Editado", 60, "RPG");
            var jogoEditado = baseDeDados.PesquisaJogoPorId(1);

            // assert
            Assert.AreEqual(jogoEsperado.Nome, jogoEditado[0].Nome);
        }
    }
}
