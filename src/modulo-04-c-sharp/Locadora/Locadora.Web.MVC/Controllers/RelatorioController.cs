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

        public ActionResult JogosDisponiveis()
        {
            var relatorioModel = new RelatorioModel();

            foreach (var jogo in repositorio.BuscarTodos())
            {
                var jogoModel = new JogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria.ToString()
                };
                relatorioModel.ListaJogos.Add(jogoModel);
            }

            relatorioModel.QuantidadeTotal = relatorioModel.ListaJogos.Count();

            return View(relatorioModel);
        }
    }
}