using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.EF;
using Locadora.Repositorio.EF.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Helpers
{
    public class Modulos
    {
        public static IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }

        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }
    }
}
