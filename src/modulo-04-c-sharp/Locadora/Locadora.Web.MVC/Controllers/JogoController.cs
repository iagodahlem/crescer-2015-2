using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Authorize]
    public class JogoController : Controller
    {
        public IJogoRepositorio repositorio = Modulos.CriarJogoRepositorio();

        [HttpGet]
        public ActionResult JogoDetalhes(int id)
        {
            var jogoDetalhes = repositorio.BuscarPorId(id);
            var jogoModel = new JogoModel()
            {
                Nome = jogoDetalhes.Nome,
                Categoria = jogoDetalhes.Categoria.ToString(),
                Preco = jogoDetalhes.Preco,
                Descricao = jogoDetalhes.Descricao,
                Selo = jogoDetalhes.Selo.ToString(),
                Imagem = jogoDetalhes.URLImagem,
                Video = jogoDetalhes.URLVideo
            };

            return View(jogoModel);
        }

        [HttpGet]
        [Autorizador(Roles = Permissao.ADMIN)]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var jogo = repositorio.BuscarPorId((int) id);
                var jogoManterModel = new JogoManterModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria,
                    Descricao = jogo.Descricao,
                    Selo = jogo.Selo,
                    Imagem = jogo.URLImagem,
                    Video = jogo.URLVideo
                };
                return View(jogoManterModel);
            }
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        [Autorizador(Roles = Permissao.ADMIN)]
        public ActionResult Salvar(JogoManterModel jogoManter)
        {
            bool validaCampos = ModelState.IsValid;

            if (validaCampos)
            {
                bool isEdicao = jogoManter.Id != null;

                if (isEdicao)
                {
                    var jogo = new Jogo((int) jogoManter.Id)
                    {
                        Nome = jogoManter.Nome,
                        Preco = jogoManter.Preco,
                        Categoria = jogoManter.Categoria,
                        Descricao = jogoManter.Descricao,
                        Selo = jogoManter.Selo,
                        URLImagem = jogoManter.Imagem,
                        URLVideo = jogoManter.Video
                    };
                    repositorio.Atualizar(jogo);
                    TempData["Mensagem"] = "Jogo editado com sucesso.";
                }
                else
                {
                    var jogo = new Jogo()
                    {
                        Nome = jogoManter.Nome,
                        Preco = jogoManter.Preco,
                        Categoria = jogoManter.Categoria,
                        Descricao = jogoManter.Descricao,
                        Selo = jogoManter.Selo,
                        URLImagem = jogoManter.Imagem,
                        URLVideo = jogoManter.Video
                    };
                    repositorio.Criar(jogo);
                    TempData["Mensagem"] = "Jogo cadastrado com sucesso.";

                }
                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Manter", jogoManter);
            }
        }
    }
}