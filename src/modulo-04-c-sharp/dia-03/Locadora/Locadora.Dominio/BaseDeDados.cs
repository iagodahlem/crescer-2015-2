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
        public const string EnderecoBase = @"C:\Users\iagodahlem\Desktop\arquivos\game_store.xml";
        public XElement XmlJogos { get; private set; }

        // Construtor
        public BaseDeDados()
        {
            XmlJogos = XElement.Load(EnderecoBase);
        }

        // Método para retornar a quantidade de Jogos na Base xml
        public int GetQuantidadeDeJogos()
        {
            return XmlJogos.Elements("jogo").Count();
        }

        // Método para Cadastrar novo Jogo conformes os parametros no arquivo xml
        public void CadastrarJogo(string nome, double preco, Categoria categoria)
        {
            // Variavel que retorna o ultimo id existente no arquivo xml
            int id = XmlJogos.Elements("jogo").Count() + 1;

            // Forma meio gambiarrenta, mas funcionou, ficou tão linda que vou deixa-la comentado
            /*
            int id;
            var ids = new List<int>();
            foreach (XElement jogo in XmlJogos.Elements("jogo"))
            {
                id = (int)jogo.FirstAttribute;
                ids.Add(id);
            }
            id = ids.Last() + 1;
            */

            // Monta novo jogo a ser adicionado
            var novoJogo = new XElement("jogo", new XAttribute("id", id), new XElement("nome", nome), new XElement("preco", preco), new XElement("categoria", categoria));

            // Adiciona novo jogo ao arquivo
            XmlJogos.Add(novoJogo);

            // Salva arquivo
            XmlJogos.Save(EnderecoBase);
        }

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

        // Método identico ao anterior porem não salva o arquivo, utilizada apenas para testes
        public void CadastrarJogoTeste(string nome, double preco, Categoria categoria)
        {
            int id = XmlJogos.Elements("jogo").Count() + 1;
            var novoJogo = new XElement("jogo", new XAttribute("id", id), new XElement("nome", nome), new XElement("preco", preco), new XElement("categoria", categoria));
            XmlJogos.Add(novoJogo);
        }
    }
}
