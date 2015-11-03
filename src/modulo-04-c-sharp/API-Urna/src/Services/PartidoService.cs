using Dominio;
using Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class PartidoService
    {
        private PartidoRepositorio repositorio = new PartidoRepositorio();
        public void Editar(int id, Partido p)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (repositorio.BuscarPorNome(p.Nome).Count == 0 || repositorio.BuscarPorSlogan(p.Slogan) == false)
                {
                    repositorio.Editar(id, p);
                }
            }

        }

        public void Inserir(Partido p)
        {
            if (!Eleicao.IniciarEleicao)
            {
                if (repositorio.BuscarPorNome(p.Nome).Count == 0 || repositorio.BuscarPorSlogan(p.Slogan) == false)
                {
                    repositorio.Inserir(p);
                }
            }

        }
        public void Excluir(Partido p)
        {
            if (!Eleicao.IniciarEleicao)
            {
                repositorio.Excluir(p);
            }
        }
    }
}