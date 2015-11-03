using Dominio;
using Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class EleitorService
    {
        private EleitorRepositorio repositorio = new EleitorRepositorio();

        public void Editar(int id, Eleitor t)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (repositorio.BuscarPorId(id) != null)
                {
                    repositorio.Editar(id, t);
                }
            }
        }

        public void Inserir(Eleitor t)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (repositorio.BuscarPorRg(t.RG) == null && repositorio.BuscarPorCpf(t.CPF) == null)
                {
                    repositorio.Inserir(t);
                }
            }

        }
        public void Excluir(Eleitor e)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (repositorio.BuscarPorId(e.IdEleitor) != null)
                {
                    repositorio.Excluir(e);
                }
            }

        }
    }
}
