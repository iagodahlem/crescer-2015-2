using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Authorize]
    public class LocacaoController : Controller
    {
        public IJogoRepositorio repositorioJogo = Modulos.CriarJogoRepositorio();
        public IClienteRepositorio repositorioCliente = Modulos.CriarClienteRepositorio();
        public ServicoLocacao servicoLocacao = Modulos.CriarServicoLocacao();

        [HttpGet]
        public ActionResult Locar(int id)
        {
            var jogo = repositorioJogo.BuscarPorId(id);
            var jogoModel = new JogoLocacaoModel()
            {
                Nome = jogo.Nome,
                DataEntrega = servicoLocacao.DataPrevistaParaEntrega(jogo.Selo),
                Valor = servicoLocacao.ValorJogo(jogo.Selo),
                Selo = jogo.Selo,
                Imagem = jogo.URLImagem,
            };

            return View(jogoModel);
        }

        [HttpPost]
        public ActionResult ConcluirLocacao(int id, string NomeCliente)
        {
            Cliente cliente = repositorioCliente.BuscarUnicoClientePorNome(NomeCliente);
            int totalLocacoes = repositorioCliente.BuscarTotalDeLocacoes(cliente);
            if (totalLocacoes > 3)
            {
                TempData["Mensagem"] = "Jabulani";
                return View("Locar");
            }

            var jogoASerLocado = repositorioJogo.BuscarPorId(id);
            jogoASerLocado.LocarPara(cliente);
            jogoASerLocado.IdCliente = cliente.Id;
            jogoASerLocado.DataEntrega = servicoLocacao.DataPrevistaParaEntrega(jogoASerLocado.Selo);
            jogoASerLocado.Valor = servicoLocacao.ValorJogo(jogoASerLocado.Selo);

            repositorioJogo.Atualizar(jogoASerLocado);

            TempData["Mensagem"] = "Jogo alugado com sucesso.";
            return RedirectToAction("JogosDisponiveis", "Relatorio", null);
        }

        public ActionResult Devolucao()
        {
            var jogoRelatorioModel = new RelatorioModel();
            var metodoBusca = repositorioJogo.BuscarLocados();

            foreach (var jogo in metodoBusca)
            {
                var jogoModel = new JogoLocacaoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Selo = jogo.Selo,
                    DataEntrega = (DateTime)jogo.DataEntrega,
                    Valor = (decimal)jogo.Valor
                };
                jogoRelatorioModel.ListaJogosLocacao.Add(jogoModel);
            }

            return View(jogoRelatorioModel);
        }

        public ActionResult ConcluirDevolucao(int id)
        {
            var jogo = repositorioJogo.BuscarPorId(id);
            jogo.LocarPara(null);
            jogo.DataEntrega = null;
            jogo.IdCliente = null;
            jogo.Valor = null;
            jogo.Cliente = null;

            repositorioJogo.Atualizar(jogo);

            return RedirectToAction("Devolucao");
        }
    }
}