using DbExtensions;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using Dominio;
using System.Transactions;

namespace Repositorio
{
    public class CargoRepositorio
    {
        public static string connectionString = @"Server=WIN-8-DEV\SQLEXPRESS;Database=Urna_local;User Id=sa;Password=Crescer$5;";

        public static void Inserir(Cargo cargo)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramNomeCargo", cargo.Nome);
                comando.AddParameter("paramSituacaoCargo", cargo.Situacao);

                comando.CommandText = "INSERT INTO Cargo (Nome, Situacao) VALUES (@paramNomeCargo, @paramSituacaoCargo)";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static void Editar(int id, Cargo cargo)
        {
            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramIDCargo", cargo.IDCargo);
                comando.AddParameter("paramNome", cargo.Nome);

                comando.CommandText = "UPDATE Cargo SET Nome = @paramCargoNome WHERE IDCargo = @paramIDCargo";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static void InativarCargo(int idCargo, Cargo cargo)
        {
            //string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramIDCargo", cargo.IDCargo);

                comando.CommandText = "UPDATE Cargo SET Situacao = 'I' WHERE IDCargo = @paramIDCargo";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static void AtivarCargo(int idCargo, Cargo cargo)
        {
            //string connectionString = ConfigurationManager.ConnectionStrings["URNA"].ConnectionString;

            using (TransactionScope transacao = new TransactionScope())
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramIDCargo", cargo.IDCargo);

                comando.CommandText = "UPDATE Cargo SET Situacao = 'A' WHERE IDCargo = @paramIDCargo";

                connection.Open();
                comando.ExecuteNonQuery();
                transacao.Complete();
                connection.Close();
            }
        }

        public static Cargo PesquisarPorID(int idCargo)
        {
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();

                comando.AddParameter("paramIDCargo", idCargo);
                comando.CommandText = "SELECT Nome, Situacao FROM Cargo WHERE IDCargo == @paramIDCargo";

                string nome;
                char situacao;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    nome = reader["Nome"].ToString();
                    situacao = Convert.ToChar(reader["Situacao"]);
                    return new Cargo(idCargo, nome, situacao);
                }

                return null;
            }
        }

        public static Cargo PesquisarPorNome(string nome)
        {
            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramNome", nome);
                comando.CommandText = "SELECT IDCargo, Nome, Situacao FROM Cargo WHERE Nome == @paramNome";

                int idCargo;
                char situacao;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    situacao = Convert.ToChar(reader["Situacao"]);
                    return new Cargo(idCargo, nome, situacao);
                }
            }

            return null;
        }

        public static List<Cargo> PesquisarPorSituacao(char situacao)
        {
            var listaCargos = new List<Cargo>();

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.AddParameter("paramSituacai", situacao);
                comando.CommandText = "SELECT IDCargo, Nome, Situacao FROM Cargo WHERE Situacao == @paramSituacao";

                int idCargo;
                string nome;

                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    idCargo = Convert.ToInt32(reader["IDCargo"]);
                    nome = reader["Nome"].ToString();
                    listaCargos.Add(new Cargo(idCargo, nome, situacao));
                }
            }

            return listaCargos;
        }

        public static int GetQuantidadeDeCargos()
        {
            int quantidade = 0;

            using (IDbConnection connection = new SqlConnection(connectionString))
            {
                IDbCommand comando = connection.CreateCommand();
                comando.CommandText = "SELECT COUNT(1) as Quantidade FROM Cargo;";

                connection.Open();
                IDataReader reader = comando.ExecuteReader();
                while (reader.Read())
                {
                    quantidade = Convert.ToInt32(reader["Quantidade"]);
                }
                connection.Close();
            }
            return quantidade;
        }
    }
}
