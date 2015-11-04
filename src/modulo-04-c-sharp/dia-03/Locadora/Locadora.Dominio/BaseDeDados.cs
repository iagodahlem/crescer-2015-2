using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {
        private const string ENDERECO_BASE = @"C:\Users\iagodahlem\Desktop\arquivos\game_store.xml";
        private const string ENDERECO_BASE_TESTE = @"C:\Users\iagodahlem\Desktop\arquivos\game_store_teste.xml";
        private XElement XmlJogos { get; set; }
        public Jogo Jogo { get; set; }
        private List<Jogo> ListaJogos { get; set; } = new List<Jogo>();

        public BaseDeDados()
        {
            CarregaBase(ENDERECO_BASE);
            CarregaListaJogos();
            //ListaJogos = new List<Jogo>();
        }

        public void CadastrarJogo(string nome, decimal preco, Categoria categoria)
        {
            int id = GetIdUltimoJogo() + 1;

            var novoJogo = new Jogo(id, nome, preco, categoria);

            var jogoXElement = ConverterJogoParaXElement(novoJogo);

            XmlJogos.Add(jogoXElement);

            SalvaArquivo(ENDERECO_BASE);
        }

        public void CadastrarJogoTeste(string nome, decimal preco, Categoria categoria)
        {
            int id = GetIdUltimoJogo() + 1;

            var novoJogo = new Jogo(id, nome, preco, categoria);

            var jogoXElement = ConverterJogoParaXElement(novoJogo);

            XmlJogos.Add(jogoXElement);
        }

        public List<Jogo> PesquisaJogoPorNome(string nome)
        {
            var listaFiltrada = ListaJogos.Where(nomeDoJogo => nomeDoJogo.Nome.Contains(nome)).ToList();

            return listaFiltrada;
        }

        public List<Jogo> PesquisaJogoPorId(int idPesquisa)
        {
            var jogo = ListaJogos.Where(id => id.Id == idPesquisa).ToList();
            return jogo;
        }

        public void EditarJogo(int id, string nome, decimal preco, string categoria)
        {
            var jogoASerEditado = PesquisaJogoPorId(id);
            var jogoXElement = ConverterJogoParaXElement(jogoASerEditado[0]);

            jogoXElement.Element("nome").SetValue(nome);
            jogoXElement.Element("preco").SetValue(preco);
            jogoXElement.Element("categoria").SetValue(categoria);

            SalvaArquivo(ENDERECO_BASE_TESTE);
        }

        public void ExportarRelatorio()
        {
            
        }

        public int GetQuantidadeDeJogos()
        {
            return XmlJogos.Elements("jogo").Count();
        }

        public int GetIdUltimoJogo()
        {
            CarregaListaJogos();
            int idUltimoJogo = ListaJogos.Last().Id;

            return idUltimoJogo;
        }

        private void CarregaBase(string enderecoBase)
        {
            XmlJogos = XElement.Load(enderecoBase);
        }

        private void SalvaArquivo(string enderecoArquivo)
        {
            XmlJogos.Save(enderecoArquivo);
        }

        private List<Jogo> CarregaListaJogos()
        {
            foreach (XElement jogo in XmlJogos.Elements("jogo"))
            {
                int id = (int)jogo.Attribute("id");
                string nomeJogo = (string)jogo.Element("nome");
                decimal preco = (decimal)jogo.Element("preco");
                string categoria = (string)jogo.Element("categoria");

                ListaJogos.Add(new Jogo(id, nomeJogo, preco, (Categoria)Enum.Parse(typeof(Categoria), categoria)));
            }

            return ListaJogos;
        }

        private XElement ConverterJogoParaXElement(Jogo jogo)
        {
            var xElementJogo = new XElement("jogo",
                new XAttribute("id", jogo.Id),
                new XElement("nome", jogo.Nome),
                new XElement("preco", jogo.Preco),
                new XElement("categoria", jogo.Categoria));

            return xElementJogo;
        }
    }
}
