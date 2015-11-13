using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IClienteRepositorio
    {
        Cliente BuscarPorId(int id);
        Cliente BuscarUnicoClientePorNome(string nome);
        IList<Cliente> BuscarPorNome(string nome);
        IList<Cliente> BuscarTodos();
        int BuscarTotalDeLocacoes(Cliente cliente);
    }
}
