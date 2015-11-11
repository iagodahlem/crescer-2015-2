﻿using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        public IJogoRepositorio repositorio = Modulos.CriarJogoRepositorio();

        public ActionResult Manter(int id)
        {
            return View();
        }

        public ActionResult Salvar(JogoModel jogo)
        {
            return View();
        }
    }
}