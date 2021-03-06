﻿using Locadora.Dominio.Repositorio;
using System.Collections.Generic;
using System.Linq;
using Locadora.Dominio;
using System;

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

        public IList<Jogo> BuscarLocados()
        {
            using (var db = CriarBanco())
            {
                return db.Jogo.Where(jogo => jogo.Cliente != null).ToList();
            }
        }

        public IList<Jogo> BuscarNaoLocados()
        {
            using (var db = CriarBanco())
            {
                return db.Jogo.Where(jogo => jogo.Cliente == null).ToList();
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
                return db.Jogo.Where(jogo => jogo.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = CriarBanco())
            {
                return db.Jogo.Select(jogo => jogo).ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = CriarBanco())
            {
                db.Entry(jogo).State = System.Data.Entity.EntityState.Added;

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
