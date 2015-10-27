using System;
using System.Collections.Generic;

namespace ConsoleApp
{
    public class Agenda
    {
        // Lista de Contatos
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; } }

        // Construtor
        /*
        public Agenda()
        {

        }
        */

        // Método
        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        public void RemoverContatosPorNome(string nomeContato)
        {
            var indicesASeremremovidos = new List<Contato>();

            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                    indicesASeremremovidos.Add(contatos[i]);

                foreach (var contato in indicesASeremremovidos)
                {
                    contatos.Remove(contato);
                }
            }
            /*
            foreach (var contato in contatos)
            {
                if (contato.Nome == nomeContato)
                {
                    contatos.Remove(contato);
                    break;
                }
            }
            */
        }

        // Método para remover Contato pelo Numero
        public void RemoverContatoPorNumero(int numeroContato)
        {
            foreach (var contato in contatos)
            {
                if (contato.Numero == numeroContato)
                {
                    contatos.Remove(contato);
                    break;
                }
            }
        }

        public string ListarContatos()
        {
            string lista = "";
            foreach (var contato in contatos)
            {
                lista += (contato.Nome + "-" + contato.Numero + "\n");
            }
            return lista;
        }

        public string ListarContatosOrdenadosPorNome()
        {
            string listaOrdenada = "";
            foreach (var contato in contatos)
            {
                listaOrdenada += (contato.Nome + "-" + contato.Numero + "\n");
            }
            return listaOrdenada;
        }
    }
}
