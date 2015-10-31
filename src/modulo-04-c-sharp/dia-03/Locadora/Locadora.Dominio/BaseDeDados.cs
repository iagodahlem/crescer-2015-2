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
        private const string ENDERECO_RELATORIO = @"C:\Users\iagodahlem\Desktop\arquivos\relatorio.txt";
        private XElement XmlJogos { get; set; }
        private List<Jogo> ListaJogos { get; set; }
        private int Id { get; set; }
        private string NomeJogo { get; set; }
        private double Preco { get; set; }
        private string Categoria { get; set; }

        // Construtor
        public BaseDeDados()
        {
            XmlJogos = XElement.Load(ENDERECO_BASE);
            ListaJogos = new List<Jogo>();
            CarregaListaJogos();
        }

        // foreach que percorre a base Xml, cria instancias de Jogo
        private List<Jogo> CarregaListaJogos()
        {
            foreach (XElement jogo in XmlJogos.Elements("jogo"))
            {
                Id = (int)jogo.Attribute("id");
                NomeJogo = (string)jogo.Element("nome");
                Preco = (double)jogo.Element("preco");
                Categoria = (string)jogo.Element("categoria");

                ListaJogos.Add(new Jogo(Id, NomeJogo, Preco, (Categoria)Enum.Parse(typeof(Categoria), Categoria)));
            }
            return ListaJogos;
        }

        // Método para retornar a quantidade de Jogos na Base xml
        public int GetQuantidadeDeJogos()
        {
            return XmlJogos.Elements("jogo").Count();
        }

        // Método para retornar o Id do ultimo jogo
        public int GetIdJogo()
        {
            int id;
            var ids = new List<int>();

            foreach (XElement jogo in XmlJogos.Elements("jogo"))
            {
                id = (int)jogo.FirstAttribute;
                ids.Add(id);
            }
            id = ids.Last();

            return id;
        }

        // Método para Cadastrar novo Jogo conformes os parametros no arquivo xml
        public void CadastrarJogo(string nome, double preco, Categoria categoria)
        {
            // Variavel que retorna o ultimo id existente no arquivo xml
            int id = XmlJogos.Elements("jogo").Count() + 1;

            // Monta novo jogo a ser adicionado
            var novoJogo = new XElement("jogo", new XAttribute("id", id), new XElement("nome", nome), new XElement("preco", preco), new XElement("categoria", categoria));

            // Adiciona novo jogo ao arquivo
            XmlJogos.Add(novoJogo);

            // Salva arquivo
            XmlJogos.Save(ENDERECO_BASE);
        }

        // Método identico ao anterior porem não salva o arquivo, utilizada apenas para testes
        public void CadastrarJogoTeste(string nome, double preco, Categoria categoria)
        {
            int id = XmlJogos.Elements("jogo").Count() + 1;
            var novoJogo = new XElement("jogo", new XAttribute("id", id), new XElement("nome", nome), new XElement("preco", preco), new XElement("categoria", categoria));
            XmlJogos.Add(novoJogo);
        }

        // Método para pesquisar um jogo pelo nome
        public List<Jogo> PesquisaJogoPorNome(string nome)
        {
            var listaFiltrada = ListaJogos.Where(nomeDoJogo => nomeDoJogo.Nome.Contains(nome)).ToList();
            return listaFiltrada;
        }

        public void EditarJogo(int id, string nome, string categoria)
        {
            // Retorna jogo pesquisado pelo Id
            //var jogoASerEditado = XmlJogos.Elements("jogo").Where(idJogo => idJogo.Attribute("id").Equals(id));
            //jogoASerEditado.Element("nome").Value = nome;
            //jogo.Element("Categoria").Value = nome;
        }

        public void ExportarRelatorio()
        {
            //string relatorio;

            //File.AppendAllText(ENDERECO_RELATORIO, relatorio);
        }
    }
}
