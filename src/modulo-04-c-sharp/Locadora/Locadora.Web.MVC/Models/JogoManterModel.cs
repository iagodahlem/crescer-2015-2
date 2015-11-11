using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Web.MVC.Models
{
    public class JogoManterModel
    {
        public int? Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        [DisplayName("Preço")]
        public decimal Preco { get; set; }

        [Required]
        public Categoria Categoria { get; set; }

        [Required]
        [DisplayName("Descrição")]
        public string Descricao { get; set; }

        [Required]
        public Selo Selo { get; set; }

        [DisplayName("URL Imagem")]
        public string Imagem { get; set; }

        [DisplayName("URL Video")]
        public string Video { get; set; }
    }
}
