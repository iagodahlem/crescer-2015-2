using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {
        public const string ENDERECO_BASE = @"C:\Users\iagodahlem\Desktop\arquivos\game_store.xml";
        public XElement XmlJogos { get; set; }

        // Construtor
        public BaseDeDados()
        {
            XmlJogos = XElement.Load(ENDERECO_BASE);
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
            // Variaveis para utilização
            var listaJogos = new List<Jogo>();
            int id;
            string nomeJogo;
            double preco;
            string categoria;

            // foreach que percorre a base Xml, cria instancias de Jogo, adicionando-as a uma lista, sendo filtrada posteriormente
            foreach (XElement jogo in XmlJogos.Elements("jogo"))
            {
                id = (int)jogo.Attribute("id");
                nomeJogo = (string)jogo.Element("nome");
                preco = (double)jogo.Element("preco");
                categoria = (string)jogo.Element("categoria");

                listaJogos.Add(new Jogo(id, nomeJogo, preco, (Categoria)Enum.Parse(typeof(Categoria), categoria)));
            }
            return listaJogos.Where(nomeDoJogo => nomeDoJogo.Nome.Contains(nome)).ToList();
        }

        public void EditarJogo(string nome, double preco, Categoria categoria)
        {

        }
    }
}
