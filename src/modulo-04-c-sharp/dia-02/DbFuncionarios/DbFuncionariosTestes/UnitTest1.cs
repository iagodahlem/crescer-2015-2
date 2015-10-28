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
            var baseDeDados = new BaseDeDados();

            baseDeDados.OrdenadosPorCategoria();

            Assert;
        }
    }
}
