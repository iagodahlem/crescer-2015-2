using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio
{
    public class Candidato
    {
        public int IDCandidato { get; private set; }
        public string NomeCompleto { get; private set; }
        public string NomePopular { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public string RegistroTRE { get; private set; }
        public int IDPartido { get; private set; }
        public int Numero { get; private set; }
        public int IDCargo { get; private set; }
        public bool Exibe { get; private set; }

        public Candidato(int idCandidato, string nomeCompleto, string nomePopular, DateTime dataNascimento, string registroTRE,
                         int idPartido, int numero, int idCargo, bool exibe)
        {
            IDCandidato = idCandidato;
            NomeCompleto = nomeCompleto;
            NomePopular = nomePopular;
            DataNascimento = dataNascimento;
            RegistroTRE = registroTRE;
            IDPartido = idPartido;
            Numero = numero;
            IDCargo = idCargo;
            Exibe = exibe;
        }
    }
}
