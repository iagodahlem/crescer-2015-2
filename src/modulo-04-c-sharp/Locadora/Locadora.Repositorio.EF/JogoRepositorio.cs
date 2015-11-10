using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            throw new NotImplementedException();
        }

        public Jogo BuscarPorId(int id)
        {
            throw new NotImplementedException();
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            throw new NotImplementedException();
        }

        public IList<Jogo> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public int Criar(Jogo jogo)
        {
            throw new NotImplementedException();
        }

        public int Excluir(int id)
        {
            throw new NotImplementedException();
        }
    }
}
