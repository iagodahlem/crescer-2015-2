using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Login()
        {
            return View();
        }

        public ActionResult Logar(string email, string senha)
        {
            if (email == "iago" && senha == "123")
            {
                FormsAuthentication.SetAuthCookie(email, true);
            }
            return RedirectToAction("Index", "Home");
        }
    }
}