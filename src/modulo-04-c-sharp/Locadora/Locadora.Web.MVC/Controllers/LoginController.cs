using Locadora.Dominio;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginModel loginModel)
        {
            if (ModelState.IsValid)
            {
                ServicoAutenticacao servicoAutenticacao = Modulos.CriarServicoAutenticacao();

                Usuario usuarioAutenticado = servicoAutenticacao.BuscarPorAutenticacao(loginModel.Email, loginModel.Password);

                if (usuarioAutenticado != null)
                {
                    ControleDeSessao.CriarSessaoDeUsuario(usuarioAutenticado);
                    return RedirectToAction("Index", "Home");
                }
            }

            ModelState.AddModelError("INVALID_LOGIN", "Usuário ou senha inválidos.");
            return View("Index", loginModel);
        }

        public void Sair()
        {
            ControleDeSessao.Encerrar();
        }

    }
}