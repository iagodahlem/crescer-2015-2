using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using System.Collections.Generic;
using System.Linq;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class ClienteController : Controller
    {
        public JsonResult ClientesAutocomplete(string term)
        {
            IList<Cliente> clientesEncontrados = null;
            IClienteRepositorio clienteRepositorio = Modulos.CriarClienteRepositorio();

            if (string.IsNullOrEmpty(term))
            {
                clientesEncontrados = clienteRepositorio.BuscarTodos();
            }
            else
            {
                clientesEncontrados = clienteRepositorio.BuscarPorNome(term);
            }

            var json = clientesEncontrados.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}