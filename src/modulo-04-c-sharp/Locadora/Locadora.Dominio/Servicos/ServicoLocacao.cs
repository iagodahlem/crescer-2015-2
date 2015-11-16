using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoLocacao
    {
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

        public decimal CalcularValorTotal(DateTime dataDeEntrega, decimal valorLocacao)
        {
            if (dataDeEntrega < DateTime.Now)
            {
                TimeSpan TempoTotalDiferente = dataDeEntrega - DateTime.Now;
                double TotalDeDiasAtrasado = Math.Abs(TempoTotalDiferente.TotalDays);
                return valorLocacao += (Convert.ToDecimal((Math.Round(TotalDeDiasAtrasado) * 5)));
            }
            return valorLocacao;
        }
    }
}
