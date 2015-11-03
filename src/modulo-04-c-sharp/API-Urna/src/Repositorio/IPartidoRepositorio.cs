using Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    interface IPartidoRepositorio : IRepositorio<Partido>
    {
        Partido BuscarPorId(int id);
        List<Partido> BuscarPorNome(string nome);
        bool BuscarPorSlogan(string slogan);
        bool Editar(int id, Partido p);
    }
}
