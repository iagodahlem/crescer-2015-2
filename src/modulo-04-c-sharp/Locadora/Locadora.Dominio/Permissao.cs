using System.Collections.Generic;

namespace Locadora.Dominio
{
    public class Permissao : EntidadeBase
    {
        public const string ADMIN = "ADMIN";

        public string Nome { get; private set; }
        public ICollection<Usuario> Usuarios { get; private set; }

        public Permissao(string nome)
        {
            this.Nome = nome;
        }

        private Permissao() { }

        public override bool Equals(object obj)
        {
            if (obj != null)
            {
                Permissao permissaoComp = obj as Permissao;

                return permissaoComp.Id == this.Id
                       && permissaoComp.Nome == this.Nome
                       && permissaoComp.Usuarios == this.Usuarios;
            }

            return false;
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
