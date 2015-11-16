using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }
        public decimal? Valor { get; set; } = null;
        public DateTime? DataEntrega { get; set; } = null;
        public Categoria Categoria { get; set; }
        public string Descricao { get; set; }
        public Selo Selo { get; set; }
        public string URLImagem { get; set; } = null;
        public string URLVideo { get; set; } = null;
        public Cliente Cliente { get; set; }
        public int? IdCliente { get; set; }

        public Jogo()
        {

        }

        public Jogo(int id, Cliente cliente = null)
        {
            this.Id = id;
            this.Cliente = cliente;
        }

        public void LocarPara(/*int idCliente,*/ Cliente cliente)
        {
            //this.IdCliente = idCliente;
            this.Cliente = cliente;
            this.DataEntrega = DataPrevistaParaEntrega(this.Selo);
            this.Valor = ValorJogo(this.Selo);
        }

        public DateTime DataPrevistaParaEntrega(Selo selo)
        {
            int diasParaEntrega = 0;
            DateTime dataEntrega = DateTime.Now;

            switch (selo)
            {
                case Selo.OURO:
                    diasParaEntrega = 1;
                    break;

                case Selo.PRATA:
                    diasParaEntrega = 2;
                    break;

                case Selo.BRONZE:
                    diasParaEntrega = 3;
                    break;
            }

            return dataEntrega.AddDays(diasParaEntrega);
        }

        public decimal ValorJogo(Selo selo)
        {
            decimal valor = 0.00M;
            switch (selo)
            {
                case Selo.OURO:
                    valor = 15.00M;
                    break;

                case Selo.PRATA:
                    valor = 10.00M;
                    break;

                case Selo.BRONZE:
                    valor = 5.00M;
                    break;
            }

            return valor;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);
            builder.AppendLine("Descricão: " + this.Descricao);
            builder.AppendLine("Selo: " + this.Selo);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Descricao == jogoComp.Descricao
                    && this.Selo == jogoComp.Selo
                    && this.URLImagem == jogoComp.URLImagem
                    && this.URLVideo == jogoComp.URLVideo
                    && this.Cliente == jogoComp.Cliente;
            }

            return false;
        }
    }
}
