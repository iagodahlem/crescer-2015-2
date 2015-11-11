using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
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

        [HttpGet]
        public ActionResult Manter(int id = -1)
        {
            bool edicao = id > 0;

            if (edicao)
            {
                var jogo = repositorio.BuscarPorId(id);
                var jogoManterModel = new JogoManterModel()
                {
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
            return View(new JogoManterModel());
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(JogoManterModel jogo)
        {
            bool validaCampos = ModelState.IsValid;

            if (validaCampos)
            {
                bool edicao = jogo.Id > 0;

                var novoJogo = new Jogo()
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria,
                    Descricao = jogo.Descricao,
                    Selo = jogo.Selo,
                    URLImagem = jogo.Imagem,
                    URLVideo = jogo.Video
                };

                if (edicao)
                {
                    repositorio.Atualizar(novoJogo);
                }
                else
                {
                    repositorio.Criar(novoJogo);
                }
                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Manter", jogo);
            }
        }
    }
}