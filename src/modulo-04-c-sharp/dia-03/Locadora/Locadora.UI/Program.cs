using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.UI
{
    class Program
    {
        static void Main(string[] args)
        {
            BaseDeDados basee = new BaseDeDados();
            //basee.CadastrarJogo("nome do jogo", 30, Categoria.AVENTURA);

            foreach (XElement jogo in basee.XmlJogos.Elements("jogo"))
            {
                Console.WriteLine(jogo);
            }

            Console.Read();
        }
    }
}
