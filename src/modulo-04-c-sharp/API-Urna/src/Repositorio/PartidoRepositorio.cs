using DbExtensions;
using Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Repositorio
{
    public class PartidoRepositorio
    {
        public string connectionString = @"Server=NOTEBOOK\SQLCWI;Database=Urna_local;Trusted_Connection=True;";
        public Partido BuscarPorId(int id)
        {
            Partido partidoEncontrado = null;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT * FROM Partido WHERE IDPartido = @paramId";
                comando.AddParameter("paramId", id);
                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                if (reader.Read())
                {
                    int idDb = Convert.ToInt32(reader["IDPartido"]);
                    string nome = reader["Nome"].ToString();
                    string slogan = reader["Slogan"].ToString();
                    string sigla = reader["Sigla"].ToString();
                    partidoEncontrado = new Partido(nome, slogan, sigla) { IDPartido = idDb };
                    connection.Close();
                }
            }
            return partidoEncontrado;
        }

        public List<Partido> BuscarPorNome(string nome)
        {
            List<Partido> partidosEncontrados = new List<Partido>();
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT * FROM Partido WHERE Nome = @paramNome";
                comando.AddParameter("paramNome", nome);
                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    int idDb = Convert.ToInt32(reader["IDPartido"]);
                    string nomeDb = reader["Nome"].ToString();
                    string slogan = reader["Slogan"].ToString();
                    string sigla = reader["Sigla"].ToString();
                    partidosEncontrados.Add(new Partido(nome, slogan, sigla) { IDPartido = idDb });

                }
                connection.Close();
            }
            return partidosEncontrados;
        }

        public bool BuscarPorSlogan(string slogan)
        {

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT * FROM Partido WHERE Slogan = @paramSlogan";
                comando.AddParameter("paramSlogan", slogan);
                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                if (reader.Read())
                {
                    connection.Close();
                    return true;
                }

            }
            return false;
        }

        public void Editar(int id, Partido p)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = ("UPDATE Partido SET Nome =@paramNome, Slogan = @paramSlogan,"
                    + "Sigla = @paramSigla WHERE IDPartido = @paramId");
                comando.AddParameter("paramId", p.IDPartido);
                comando.AddParameter("paramNome", p.Nome);
                comando.AddParameter("paramSlogan", p.Slogan);
                comando.AddParameter("paramSigla", p.Sigla);
                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public void Excluir(Partido p)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = ("DELETE FROM Partido WHERE IDPartido = @paramId");
                comando.AddParameter("paramId", p.IDPartido);
                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public void Inserir(Partido p)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = ("INSERT INTO Partido (Nome,Slogan,Sigla)  VALUES(@paramNome,@paramSlogan,@paramSigla)");
                comando.AddParameter("paramNome", p.Nome);
                comando.AddParameter("paramSlogan", p.Slogan);
                comando.AddParameter("paramSigla", p.Sigla);
                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }
    }
}