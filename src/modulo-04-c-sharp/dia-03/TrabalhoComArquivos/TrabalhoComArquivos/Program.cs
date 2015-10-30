using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace TrabalhoComArquivos
{
    class Program
    {
        static void Main(string[] args)
        {
            // String Format

            double salario = 10;
            string meuSalario = String.Format("Meu salario é: {0}", salario);

            Console.WriteLine(DateTime.Now);

            Console.WriteLine(DateTime.Now.ToString("dd-MM-yyyy"));

            var salario2 = "15.000,00";
            var mensagem = $"Meu salário é {salario2}";

            // String.Format(“{0:C}”, variavelDinheiro);
        }

        // Pattern
        string dataSalario = String.Format("Minha data de pagamento é: {0:dd-MM-yyyy}", DateTime.Now);

        /*
        static void Main(string[] args)
        {
            // XML
            string caminhoArquivo = @"C:\Users\iagodahlem\Desktop\arquivos\jogos.xml";

            XElement xmlJogos = XElement.Load(caminhoArquivo);

            foreach (XElement jogo in xmlJogos.Elements("jogo"))
            {

            }
        }
        */

        /*
        static void Main(string[] args)
        {
            // Stream - para arquivos grandes e pesados

            string caminhoArquivo = @"C:\Users\iagodahlem\Desktop\arquivos\meu-arquivo.txt";

            // Recebe caminho e um bool apend - FALSE não sobrescreve o arquivo, TRUE sobrescreve
            // var writer = new StreamWriter(caminhoArquivo, false);
            var writer = new StreamWriter(caminhoArquivo, true);
            writer.WriteLine("didi must die");
            writer.Close();

            // var reader = new StreamReader(caminhoArquivo);
            // var leitura = reader.ReadToEnd();

            // Limpar arquivos e variaveis em memoria
            // reader.Dispose();

            // Tratamento de erro

            // Using 
            using (var reader = new StreamReader(caminhoArquivo))
            {
                reader.ReadLine();
            }

            try
            {
                
            }
            catch (Exception)
            {

                throw;
            }
            finally
            {
                if (reader != null)
                {
                    reader.Dispose();
                }
            }

            Console.Read();
        }
        */
        
        /*
        static void Main(string[] args)
        {
            // Arquivos .txt simples e de pequenos tamanho

            string caminhoArquivo = @"C:\Users\iagodahlem\Desktop\arquivos\meu-arquivo.txt";
            string textoDoArquivo = "didi must die";

            // Inseri textos no arquivo informado
            // File.AppendAllText(caminhoArquivo, textoDoArquivo);

            // Le todoas as linhas no arquivo e retorna um array com uma linha em cada posição
            // string[] linhas = File.ReadAllLines(caminhoArquivo);

            // Retorna uma string contendo todas as linhas utilizando quebra de linha
            // string texto = File.ReadAllText(caminhoArquivo);

            // Retonar um array de bytes com o tamanho do arquivo
            // byte[] arquivo = File.ReadAllBytes(caminhoArquivo);

            // Indica a quebra de linha do sistema
            // string newLine = Environment.NewLine;

            Console.Read();
        }
        */
    }
}
