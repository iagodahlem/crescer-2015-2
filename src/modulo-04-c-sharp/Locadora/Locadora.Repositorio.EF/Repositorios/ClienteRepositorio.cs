using Locadora.Dominio.Repositorio;
using System.Collections.Generic;
using System.Linq;
using Locadora.Dominio;
using System;

namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio : RepositorioBase, IClienteRepositorio
    {
        public Cliente BuscarPorId(int id)
        {
            using (var db = CriarBanco())
            {
                return db.Cliente.Find(id);
            }
        }

        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var db = CriarBanco())
            {
                return db.Cliente.Where(cliente => cliente.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Cliente> BuscarTodos()
        {
            using (var db = CriarBanco())
            {
                return db.Cliente.Select(cliente => cliente).ToList();
            }
        }

        public int BuscarTotalDeLocacoes(Cliente cliente)
        {
            using (var db = CriarBanco())
            {
                int totalLocacao;
                totalLocacao = db.Jogo.Count(j => j.Cliente.Id == cliente.Id);
                return totalLocacao;
            }
        }

        public Cliente BuscarUnicoClientePorNome(string nome)
        {
            using (var db = CriarBanco())
            {
                return db.Cliente.Where(cliente => cliente.Nome == nome).FirstOrDefault();
            }
        }
    }
}
