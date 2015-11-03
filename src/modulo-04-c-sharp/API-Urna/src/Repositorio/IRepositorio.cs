using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    interface IRepositorio<T>
    {
        void Inserir(T t);

        void Excluir(T t);
    }
}

