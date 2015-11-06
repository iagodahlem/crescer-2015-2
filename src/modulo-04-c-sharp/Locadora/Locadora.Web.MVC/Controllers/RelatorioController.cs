using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        public IJogoRepositorio repositorio = new Locadora.Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis(string nomeJogo) // if pra chamar método
        {
            var relatorioModel = new RelatorioModel();

            foreach (var jogo in repositorio.BuscarTodos())
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

            relatorioModel.QuantidadeTotal = relatorioModel.ListaJogos.Count();

            return View(relatorioModel);
        }

        public ActionResult JogoDetalhes(int id)
        {
            var jogoModel = new JogoDetalhesModel()
            {
                Id = repositorio.BuscarPorId(id).Id,
                Nome = repositorio.BuscarPorId(id).Nome,
                Categoria = repositorio.BuscarPorId(id).Categoria.ToString(),
                Preco = repositorio.BuscarPorId(id).Preco,
                Descricao = repositorio.BuscarPorId(id).Descricao,
                Selo = repositorio.BuscarPorId(id).Selo.ToString(),
                Imagem = repositorio.BuscarPorId(id).Imagem,
                Video = repositorio.BuscarPorId(id).Video
            };
            
            return View(jogoModel);
        }
    }
}