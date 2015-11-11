using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF.Repositorios
{
    public class UsuarioRepositorio : RepositorioBase, IUsuarioRepositorio
    {
        public Usuario BuscaPorEmail(string email)
        {
            using (var db = CriarBanco())
            {
                return db.Usuario.Include("Permissoes").FirstOrDefault(usuario => usuario.Email == email);
            }
        }
    }
}
