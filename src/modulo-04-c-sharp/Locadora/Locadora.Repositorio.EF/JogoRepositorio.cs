using Locadora.Dominio.Repositorio;
using System.Collections.Generic;
using System.Linq;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : RepositorioBase, IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            using (var db = CriarBanco())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = CriarBanco())
            {
                return db.Jogo.Find(id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = CriarBanco())
            {
                return db.Jogo.Where(jogo => jogo.Nome == nome).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = CriarBanco())
            {
                return db.Jogo.Where(jogo => jogo.Id != 0).ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = CriarBanco())
            {
                var novoJogo = new Jogo()
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria,
                    Descricao = jogo.Descricao,
                    Selo = jogo.Selo,
                    Imagem = jogo.Imagem,
                    Video = jogo.Video
                };

                db.Entry(novoJogo).State = System.Data.Entity.EntityState.Added;

                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var db = CriarBanco())
            {
                var jogo = db.Jogo.Find(id);

                db.Entry(jogo).State = System.Data.Entity.EntityState.Deleted;

                return db.SaveChanges();
            }
        }
    }
}
