using DbExtensions;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace Repositorio
{
    public class VotoRepositorio
    {
        public string connectionString = @"Server=NOTEBOOK\SQLCWI;Database=Urna_local;Trusted_Connection=True;";

        public Dictionary<string, int> BuscarEstatisticas()
        {
            Dictionary<string, int> VotosPCandidato = new Dictionary<string, int>();
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT IDCandidato, COUNT(1) as QtdVotos FROM Voto group by IDCandidato";
                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    VotosPCandidato.Add(reader["IDCandidato"].ToString(), Convert.ToInt32(reader["QtdVotos"]));
                }
                connection.Close();
            }
            return VotosPCandidato;
        }

        public bool VerficarSeJaVotou(string cpf)
        {
            bool votou = true;
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT Votou FROM Eleitor WHERE CPF = @paramCpf";
                comando.AddParameter("paramCpf", cpf);

                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                if (reader.Read())
                {
                    votou = reader["Votou"].ToString() == "S";

                    connection.Close();
                }
            }
            return votou;
        }

        public bool RegistrarVoto(string cpf, int num)
        {
            if (VerficarSeJaVotou(cpf))
            {
                return false;
            }
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                string IdCandidato = "";

                IDbCommand buscarIDCandidato = connection.CreateCommand();
                buscarIDCandidato.CommandText = "SELECT IDCandidato FROM Candidato WHERE Numero = @paramNumero";
                buscarIDCandidato.AddParameter("paramNumero", num);

                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "INSERT INTO Voto (IDCandidato) VALUES(@paramId)";
                comando.AddParameter("paramCpf", cpf);

                IDbCommand atualizarEleitor = connection.CreateCommand();
                atualizarEleitor.CommandText = "UPDATE Eleitor SET Votou = @paramVoto WHERE CPF = @paramCpf";
                atualizarEleitor.AddParameter("paramCpf", cpf);
                atualizarEleitor.AddParameter("paramVoto", 'S');

                connection.Open();
                IDataReader reader = buscarIDCandidato.ExecuteReader();
                if (reader.Read())
                {
                    IdCandidato = reader["IDCandidato"].ToString();
                }
                reader.Close();
                comando.AddParameter("paramId", IdCandidato);
                comando.ExecuteNonQuery();
                atualizarEleitor.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
            return true;
        }
    }
}
