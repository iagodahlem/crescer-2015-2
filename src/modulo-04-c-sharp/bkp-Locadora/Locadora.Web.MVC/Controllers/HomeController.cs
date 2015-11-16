using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
    }
}