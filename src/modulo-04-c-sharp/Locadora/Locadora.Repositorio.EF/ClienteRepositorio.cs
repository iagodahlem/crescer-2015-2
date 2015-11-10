using Locadora.Dominio.Repositorio;
using System.Collections.Generic;
using System.Linq;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio : RepositorioBase, IClienteRepositorio
    {
        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var db = CriarBanco())
            {
                return db.Cliente.Where(cliente => cliente.Nome == nome).ToList();
            }
        }
    }
}
