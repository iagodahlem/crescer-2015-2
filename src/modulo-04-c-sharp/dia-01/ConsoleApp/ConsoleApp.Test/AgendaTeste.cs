using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Test
{
    // Data Notation
    [TestClass]
    public class AgendaTeste
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato ("Iaaago", 12345678);

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaRecebeDoisContatos()
        {
            var agenda = new Agenda();
            var contato1 = new Contato ("Iaaago", 12345678);
            var contato2 = new Contato("Iaaago", 12345678);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);

            Assert.AreEqual(agenda.QuantidadeContatos, 2);
        }

        [TestMethod]
        public void AgendaRecebe3ContatosERemoveUmPeloNumero()
        {
            var agenda = new Agenda();
            var contato1 = new Contato("Darth", 214365);
            var contato2 = new Contato("Vader", 91927766);
            var contato3 = new Contato("Lorde Vader", 11111);
            
            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);

            agenda.RemoverContatoPorNumero(91927766);

            Assert.AreEqual(agenda.QuantidadeContatos, 2);
        }
    }
}
