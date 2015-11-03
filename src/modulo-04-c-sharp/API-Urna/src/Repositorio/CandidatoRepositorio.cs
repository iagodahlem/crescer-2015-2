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
    public class CandidatoRepositorio
    {
        public static void Inserir(Candidato c)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramNomeCompleto", c.NomeCompleto);
                comando.AddParameter("paramNomePopular", c.NomePopular);
                comando.AddParameter("paramDataNascimento", c.DataNascimento.Date);
                comando.AddParameter("paramRegistroTRE", c.RegistroTRE);
                comando.AddParameter("paramIDPartido", c.IDPartido);
                comando.AddParameter("paramNumero", c.Numero);
                comando.AddParameter("paramIDCargo", c.IDCargo);
                comando.AddParameter("paramExibe", c.Exibe);

                comando.CommandText = "Insert into Candidato (NomeCompleto, NomePopular, DataNascimento, RegistroTRE, IDPartido, Numero, IDCargo, Exibe)" +
                                      "values (@paramNomeCompleto, @paramNomePopular, @paramDataNascimento, @paramRegistroTRE, @paramIDPartido, @paramNumero, @paramIDCargo, @paramExibe)";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static void Excluir(int idCandidato)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramIDCandidato", idCandidato);
                comando.CommandText = "Delete from Candidato where IDCandidato == @paramIDCandidato";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static void Editar(int id, Candidato c)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramIDCandidato", c.IDCandidato);
                comando.AddParameter("paramNomeCompleto", c.NomeCompleto);
                comando.AddParameter("paramNomePopular", c.NomePopular);
                comando.AddParameter("paramDataNascimento", c.DataNascimento.Date);
                comando.AddParameter("paramRegistroTRE", c.RegistroTRE);
                comando.AddParameter("paramIDPartido", c.IDPartido);
                comando.AddParameter("paramNumero", c.Numero);
                comando.AddParameter("paramIDCargo", c.IDCargo);
                comando.AddParameter("paramExibe", c.Exibe);

                comando.CommandText = "Update into Candidato set NomeCompleto=@paramNomeCompleto, NomePopular=@paramNomePopular, DataNascimento=@paramDataNascimento," +
                    "RegistroTRE=@paramRegistroTRE, IDPartido=@paramIDPartido, Numero=@paramNumero, IDCargo=@paramIDCargo, Exibe=@paramExibe where IDCandidato == @paramIDCandidato";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static IList<Candidato> PesquisarPorPartido(int idPartido)
        {
            IList<Candidato> listaCandidatos = new List<Candidato>();

            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramIDPartido", idPartido);
                comando.CommandText = "Select IDCandidato, NomeCompleto, NomePopular, DataNascimento, RegistroTRE, Numero, IDCargo, Exibe from Candidato where IDPartido == @paramIDPartido";

                int idCandidato;
                string nomeCompleto;
                string nomePopular;
                DateTime dataNascimento;
                string registroTRE;
                int numero;
                int idCargo;
                bool exibe;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCandidato = Convert.ToInt32(reader["IDCandidato"]);
                    nomeCompleto = reader["NomeCompleto"].ToString();
                    nomePopular = reader["NomePopular"].ToString();
                    dataNascimento = Convert.ToDateTime(reader["DataNascimento"]);
                    registroTRE = reader["RegistroTRE"].ToString();
                    numero = Convert.ToInt32(reader["Numero"]);
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    exibe = Convert.ToBoolean(reader["Exibe"]);

                    listaCandidatos.Add(new Candidato(idCandidato, nomeCompleto, nomePopular, dataNascimento, registroTRE, idPartido, numero, idCargo, exibe));
                }

                return listaCandidatos;
            }
        }

        public static Candidato PesquisarPorNumero(int numero)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramNumero", numero);
                comando.CommandText = "Select IDCandidato, NomeCompleto, NomePopular, DataNascimento, RegistroTRE, IDPartido, IDCargo, Exibe from Candidato where Numero == @paramNumero";

                int idCandidato;
                string nomeCompleto;
                string nomePopular;
                DateTime dataNascimento;
                string registroTRE;
                int idPartido;
                int idCargo;
                bool exibe;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCandidato = Convert.ToInt32(reader["IDCandidato"]);
                    nomeCompleto = reader["NomeCompleto"].ToString();
                    nomePopular = reader["NomePopular"].ToString();
                    dataNascimento = Convert.ToDateTime(reader["DataNascimento"]);
                    registroTRE = reader["RegistroTRE"].ToString();
                    idPartido = Convert.ToInt32(reader["IDPartido"]);
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    exibe = Convert.ToBoolean(reader["Exibe"]);

                    return new Candidato(idCandidato, nomeCompleto, nomePopular, dataNascimento, registroTRE, idPartido, numero, idCargo, exibe);
                }

                return null;
            }
        }

        public static Candidato PesquisarPorRegistro(string registro)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramRegistroTRE", registro);
                comando.CommandText = "Select IDCandidato, NomeCompleto, NomePopular, DataNascimento, IDPartido, Numero, IDCargo, Exibe from Candidato where RegistroTRE == @paramRegistroTRE";

                int idCandidato;
                string nomeCompleto;
                string nomePopular;
                DateTime dataNascimento;
                int idPartido;
                int numero;
                int idCargo;
                bool exibe;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCandidato = Convert.ToInt32(reader["IDCandidato"]);
                    nomeCompleto = reader["NomeCompleto"].ToString();
                    nomePopular = reader["NomePopular"].ToString();
                    dataNascimento = Convert.ToDateTime(reader["DataNascimento"]);
                    numero = Convert.ToInt32(reader["Numero"]);
                    idPartido = Convert.ToInt32(reader["IDPartido"]);
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    exibe = Convert.ToBoolean(reader["Exibe"]);

                    return new Candidato(idCandidato, nomeCompleto, nomePopular, dataNascimento, registro, idPartido, numero, idCargo, exibe);
                }

                return null;
            }
        }

        public static Candidato PesquisarPorNomePopular(string nomePopular)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramNomePopular", nomePopular);
                comando.CommandText = "Select IDCandidato, NomeCompleto, DataNascimento, RegistroTRE, IDPartido, Numero, IDCargo, Exibe from Candidato where NomePopular == @paramNomePopular";

                int idCandidato;
                string nomeCompleto;
                DateTime dataNascimento;
                string registro;
                int idPartido;
                int numero;
                int idCargo;
                bool exibe;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCandidato = Convert.ToInt32(reader["IDCandidato"]);
                    nomeCompleto = reader["NomeCompleto"].ToString();
                    registro = reader["RegistroTRE"].ToString();
                    dataNascimento = Convert.ToDateTime(reader["DataNascimento"]);
                    numero = Convert.ToInt32(reader["Numero"]);
                    idPartido = Convert.ToInt32(reader["IDPartido"]);
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    exibe = Convert.ToBoolean(reader["Exibe"]);

                    return new Candidato(idCandidato, nomeCompleto, nomePopular, dataNascimento, registro, idPartido, numero, idCargo, exibe);
                }

                return null;
            }
        }

        public static IList<Candidato> ListarCandidatos()
        {
            IList<Candidato> listaCandidatos = new List<Candidato>();

            string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.CommandText = "Select IDCandidato, NomeCompleto, NomePopular, DataNascimento, RegistroTRE, IDPartido, Numero, IDCargo, Exibe from Candidato";

                int idCandidato;
                string nomeCompleto;
                string nomePopular;
                DateTime dataNascimento;
                string registroTRE;
                int idPartido;
                int numero;
                int idCargo;
                bool exibe;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCandidato = Convert.ToInt32(reader["IDCandidato"]);
                    nomeCompleto = reader["NomeCompleto"].ToString();
                    nomePopular = reader["NomePopular"].ToString();
                    dataNascimento = Convert.ToDateTime(reader["DataNascimento"]);
                    idPartido = Convert.ToInt32(reader["IDPartido"]);
                    registroTRE = reader["RegistroTRE"].ToString();
                    numero = Convert.ToInt32(reader["Numero"]);
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    exibe = Convert.ToBoolean(reader["Exibe"]);

                    listaCandidatos.Add(new Candidato(idCandidato, nomeCompleto, nomePopular, dataNascimento, registroTRE, idPartido, numero, idCargo, exibe));
                }

                return listaCandidatos;
            }
        }
    }
}

