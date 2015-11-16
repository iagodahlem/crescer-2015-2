﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApplication1.Models
{
    public class UsuarioLogado
    {
        public string Usuario { get; private set; }

        public string[] Permissoes { get; private set; }

        public UsuarioLogado(string usuario, string[] permissoes)
        {
            this.Usuario = usuario;
            this.Permissoes = permissoes;
        }
    }
}