using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace DbFuncionariosTestes
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void BaseDeDadosOrdenaFuncionariosPorCategoria()
        {
            // arrange
            var baseDeDados = new BaseDeDados();

            // act
            var listaObtida = baseDeDados.OrdenadosPorCategoria();

            // assert
            //Assert.AreEqual();
        }
    }
}
