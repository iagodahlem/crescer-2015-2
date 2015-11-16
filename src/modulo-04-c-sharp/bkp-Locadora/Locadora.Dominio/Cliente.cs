namespace Locadora.Dominio
{
    public class Cliente : EntidadeBase
    {
        public string Nome { get; set; }

        public Cliente()
        {

        }

        public Cliente(int id)
        {
            this.Id = id;
        }
    }
}
