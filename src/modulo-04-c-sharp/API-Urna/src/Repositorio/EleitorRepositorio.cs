using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio;
using System.Transactions;
using System.Data.SqlClient;
using System.Data;
using DbExtensions;

namespace Repositorio
{
    public class EleitorRepositorio
    {
        public string connectionString = @"Server=NOTEBOOK\SQLCWI;Database=Urna_local;Trusted_Connection=True;";

        public Eleitor BuscarPorCpf(string cpf)
        {
            Eleitor eleitorEncontrado = null;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT IDEleitor,Nome,TituloEleitoral,RG,CPF,DataNascimento,ZonaEleitoral,"
                                     + "Secao,Situacao,Votou FROM Eleitor WHERE CPF = @paramCpf";
                comando.AddParameter("paramCpf", cpf);

                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                if (reader.Read())
                {

                    eleitorEncontrado = new Eleitor()
                    {
                        IdEleitor = Convert.ToInt32(reader["IDEleitor"]),
                        Nome = reader["Nome"].ToString(),
                        TituloEleitoral = Convert.ToInt64(reader["TituloEleitoral"]),
                        RG = reader["RG"].ToString(),
                        CPF = reader["CPF"].ToString(),
                        DataNascimento = Convert.ToDateTime(reader["DataNascimento"]),
                        ZonaEleitoral = Convert.ToInt32(reader["ZonaEleitoral"]),
                        Secao = reader["Secao"].ToString(),
                        Situacao = Convert.ToChar(reader["Situacao"]),
                        Votou = Convert.ToChar(reader["Votou"])
                    };
                    connection.Close();
                }
            }
            return eleitorEncontrado;
        }

        public Eleitor BuscarPorId(int id)
        {
            Eleitor eleitorEncontrado = null;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT IDEleitor,Nome,TituloEleitoral,RG,CPF,DataNascimento,ZonaEleitoral,"
                                     + "Secao,Situacao,Votou FROM Eleitor WHERE IDEleitor = @paramId";
                comando.AddParameter("paramId", id);

                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                if (reader.Read())
                {

                    eleitorEncontrado = new Eleitor()
                    {
                        IdEleitor = Convert.ToInt32(reader["IDEleitor"]),
                        Nome = reader["Nome"].ToString(),
                        TituloEleitoral = Convert.ToInt64(reader["TituloEleitoral"]),
                        RG = reader["RG"].ToString(),
                        CPF = reader["CPF"].ToString(),
                        DataNascimento = Convert.ToDateTime(reader["DataNascimento"]),
                        ZonaEleitoral = Convert.ToInt32(reader["ZonaEleitoral"]),
                        Secao = reader["Secao"].ToString(),
                        Situacao = Convert.ToChar(reader["Situacao"]),
                        Votou = Convert.ToChar(reader["Votou"])
                    };
                    connection.Close();
                }
            }
            return eleitorEncontrado;
        }

        public Eleitor BuscarPorRg(string rg)
        {
            Eleitor eleitorEncontrado = null;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT IDEleitor,Nome,TituloEleitoral,RG,CPF,DataNascimento,ZonaEleitoral,"
                                     + "Secao,Situacao,Votou FROM Eleitor WHERE RG = @paramRg";
                comando.AddParameter("paramRg", rg);

                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                if (reader.Read())
                {

                    eleitorEncontrado = new Eleitor()
                    {
                        IdEleitor = Convert.ToInt32(reader["IDEleitor"]),
                        Nome = reader["Nome"].ToString(),
                        TituloEleitoral = Convert.ToInt64(reader["TituloEleitoral"]),
                        RG = reader["RG"].ToString(),
                        CPF = reader["CPF"].ToString(),
                        DataNascimento = Convert.ToDateTime(reader["DataNascimento"]),
                        ZonaEleitoral = Convert.ToInt32(reader["ZonaEleitoral"]),
                        Secao = reader["Secao"].ToString(),
                        Situacao = Convert.ToChar(reader["Situacao"]),
                        Votou = Convert.ToChar(reader["Votou"])
                    };
                    connection.Close();
                }
            }
            return eleitorEncontrado;
        }

        public void Editar(int id, Eleitor e)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "UPDATE Eleitor SET Nome = @paramNome, TituloEleitoral = @paramTitulo,"
                    + "RG = @paramRg, CPF = @paramCpf, DataNascimento = @paramData, ZonaEleitoral = @paramZona,"
                    + "Secao = @paramSecao, Situacao = @paramSit, Votou = @paramVotou WHERE IDEleitor = @paramId";
                comando.AddParameter("paramId", id);
                comando.AddParameter("paramNome", e.Nome);
                comando.AddParameter("paramTitulo", e.TituloEleitoral);
                comando.AddParameter("paramRg", e.RG);
                comando.AddParameter("paramCpf", e.CPF);
                comando.AddParameter("paramData", e.DataNascimento);
                comando.AddParameter("paramZona", e.ZonaEleitoral);
                comando.AddParameter("paramSecao", e.Secao);
                comando.AddParameter("paramSit", e.Situacao);
                comando.AddParameter("paramVotou", e.Votou);

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();

            }
        }

        public void Excluir(Eleitor t)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "DELETE FROM Eleitor WHERE IDEleitor = @paramId";
                comando.AddParameter("paramId", t.IdEleitor);
                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public void Inserir(Eleitor e)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "INSERT INTO Eleitor (Nome,TituloEleitoral,RG,CPF,DataNascimento,ZonaEleitoral,Secao,Situacao,Votou)"
                + "VALUES (@paramNome,@paramTitulo,@paramRg,@paramCpf,@paramData,@paramZona,@paramSecao,@paramSit,@paramVotou)";
                comando.AddParameter("paramNome", e.Nome);
                comando.AddParameter("paramTitulo", e.TituloEleitoral);
                comando.AddParameter("paramRg", e.RG);
                comando.AddParameter("paramCpf", e.CPF);
                comando.AddParameter("paramData", e.DataNascimento);
                comando.AddParameter("paramZona", e.ZonaEleitoral);
                comando.AddParameter("paramSecao", e.Secao);
                comando.AddParameter("paramSit", e.Situacao);
                comando.AddParameter("paramVotou", e.Votou);
                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }
    }
}