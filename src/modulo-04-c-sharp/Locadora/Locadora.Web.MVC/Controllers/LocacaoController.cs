﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Authorize]
    public class LocacaoController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
    }
}