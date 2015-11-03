using Dominio;
using Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class CargoService
    {
        public static void Inserir(Cargo cargo)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (cargo.Nome != null && cargo.Situacao != '\0')
                {
                    bool validaNome = CargoRepositorio.PesquisarPorNome(cargo.Nome) != null ? false : true;
                    if (validaNome)
                    {
                        CargoRepositorio.Inserir(cargo);
                    }
                }
            }
        }

        public static void Editar(int id, Cargo cargo)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (CargoRepositorio.PesquisarPorID(id) != null)
                {
                    if (cargo.Nome != null && CargoRepositorio.PesquisarPorNome(cargo.Nome) == null)
                    {
                        CargoRepositorio.Editar(id, cargo);
                    }
                }
            }
        }

        public static void InativarCargo(int id, Cargo cargo)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (CargoRepositorio.PesquisarPorID(id) != null)
                {
                    if (cargo.Situacao != 'I')
                    {
                        CargoRepositorio.InativarCargo(id, cargo);
                    }
                }
            }
        }

        public static void AtivarCargo(int id, Cargo cargo)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (CargoRepositorio.PesquisarPorID(id) != null)
                {
                    if (cargo.Situacao != 'A')
                    {
                        CargoRepositorio.AtivarCargo(id, cargo);
                    }
                }
            }
        }
    }
}
