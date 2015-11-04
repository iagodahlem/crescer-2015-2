using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio;

namespace Locadora.MVC.Controllers
{
    public class IndexController : Controller
    {
        // GET: Index
        public ActionResult Index()
        {
            return View("Index");
        }

        public ActionResult ListaJogos()
        {
            var baseDeDados = new BaseDeDados();
            ViewBag.ListaJogos = baseDeDados.ListaJogos;
            return View("ListaJogos");
        }
    }
}