﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dominio
{
    public class Partido
    {
        public int IDPartido { get; set; }
        public string Nome { get; set; }
        public string Slogan { get; set; }
        public string Sigla { get; set; }

        public Partido(string nome, string slogan, string sigla)
        {
            Nome = nome;
            Slogan = slogan;
            Sigla = sigla;
        }
    }
}
