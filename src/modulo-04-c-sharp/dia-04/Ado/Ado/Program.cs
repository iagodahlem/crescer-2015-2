using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Ado
{
    class Program
    {
        /*
            CONEXÃO A BANCO DE DADOS

            Conexão
            Comando
        */

        static void Main(string[] args)
        {
            // Faz conexão monta comando de leitura
            string connectionString = ConfigurationManager.ConnectionStrings["CursoSQL"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comand = connection.CreateCommand();
                comand.CommandText = "Select * from ";

                connection.Open();

                IDataReader reader = comand.ExecuteReader();

                while (reader.Read())
                {
                    string nome = reader["Nome"].ToString();
                }

                transacao.Complete();

                connection.Close();
            }
            
            // Faz conexão e monta comando UPDATE
            /*
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            IDbConnection connection = new SqlConnection(connectionString);

            IDbCommand comand = connection.CreateCommand();

            string nome = "' or 1=1 --";

            comand.CommandText = 
                "UPDATE Candidato SET NomeCompleto = @paramNome WHERE IDCandidato = 1";

            IDbDataParameter parameter = comand.CreateParameter();
            parameter.ParameterName = "paramNome";
            parameter.Value = nome;

            comand.Parameters.Add(parameter);

            int afetados = comand.ExecuteNonQuery();

            connection.Open();

            connection.Close();
            */
        }


    }
}
