using Dominio;
using Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    class CandidatoService
    {
        public static void Inserir(Candidato c)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (c.NomeCompleto == "" || c.NomeCompleto == null || c.NomePopular == "" || c.NomePopular == null)
                    return;

                if (CandidatoRepositorio.PesquisarPorNomePopular(c.NomePopular) != null)
                    return;

                if (CandidatoRepositorio.PesquisarPorRegistro(c.RegistroTRE) != null)
                    return;

                if (CandidatoRepositorio.PesquisarPorNumero(c.Numero) != null)
                    return;

                Cargo cargo = CargoRepositorio.PesquisarPorID(c.IDCargo);

                if (cargo != null)
                {
                    if (cargo.Nome != "Prefeito")
                        CandidatoRepositorio.Inserir(c);
                    else
                    {
                        IList<Candidato> lista = CandidatoRepositorio.PesquisarPorPartido(c.IDPartido);

                        foreach (var candidato in lista)
                        {
                            if (candidato.IDPartido == c.IDPartido)
                                return;
                        }

                        CandidatoRepositorio.Inserir(c);
                    }
                }
            }
        }

        public static void Excluir(Candidato c)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (c.NomeCompleto.ToUpper() != "VOTO NULO" && c.NomeCompleto.ToUpper() != "VOTO BRANCO")
                    return;

                if (c.NomePopular.ToUpper() != "VOTO NULO" && c.NomePopular.ToUpper() != "VOTO BRANCO")
                    return;

                CandidatoRepositorio.Excluir(c.IDCandidato);
            }
        }

        public static void Editar(int id, Candidato c)
        {
            if (!Eleicao.IniciarEleicao)
            {

                if (c.NomeCompleto == "" || c.NomeCompleto == null || c.NomePopular == "" || c.NomePopular == null)
                    return;

                if (CandidatoRepositorio.PesquisarPorNomePopular(c.NomePopular) != null)
                    return;

                if (CandidatoRepositorio.PesquisarPorRegistro(c.RegistroTRE) != null)
                    return;

                if (CandidatoRepositorio.PesquisarPorNumero(c.Numero) != null)
                    return;

                Cargo cargo = CargoRepositorio.PesquisarPorID(c.IDCargo);

                if (cargo != null)
                {
                    if (cargo.Nome != "Prefeito")
                        CandidatoRepositorio.Editar(id, c);
                    else
                    {
                        IList<Candidato> lista = CandidatoRepositorio.PesquisarPorPartido(c.IDPartido);

                        foreach (var candidato in lista)
                        {
                            if (candidato.IDCargo == c.IDCargo && candidato.IDCandidato != id)
                                return;
                        }

                        CandidatoRepositorio.Editar(id, c);
                    }
                }
            }
        }
    }
}
