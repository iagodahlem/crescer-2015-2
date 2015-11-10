﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public abstract class RepositorioBase
    {
        internal BancoDeDados CriarBanco()
        {
            return new BancoDeDados();
        }
    }
}
