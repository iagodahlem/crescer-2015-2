using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Authorize]
    public class RelatorioController : Controller
    {
        public IJogoRepositorio repositorio = new Locadora.Repositorio.EF.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nomeJogo)
        {
            var relatorioModel = new RelatorioModel();

            var metodoBusca = string.IsNullOrEmpty(nomeJogo) ? repositorio.BuscarTodos() : repositorio.BuscarPorNome(nomeJogo);

            foreach (var jogo in metodoBusca)
            {
                var jogoModel = new JogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria.ToString(),
                    Selo = jogo.Selo.ToString()
                };
                relatorioModel.ListaJogos.Add(jogoModel);
            }

            if (relatorioModel.ListaJogos.Count() != 0)
            {
                relatorioModel.QuantidadeTotal = relatorioModel.ListaJogos.Count();
                relatorioModel.ValorMedio = relatorioModel.ListaJogos.Sum(valorMedio => valorMedio.Preco);
                relatorioModel.JogoMaisCaro = relatorioModel.ListaJogos.Max(maisCaro => maisCaro.Preco);
                relatorioModel.JogoMaisBarato = relatorioModel.ListaJogos.Min(maisBarato => maisBarato.Preco);

                return View(relatorioModel);
            }

            else
            {
                ViewBag.Mensagem = "Nenhum jogo corresponde com a sua pesquisa. Por favor, tente novamente.";

                return View();
            }
        }

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
    }
}