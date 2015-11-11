using System.ComponentModel.DataAnnotations;

namespace Locadora.Web.MVC.Models
{
    public class LoginModel
    {
        [Required]
        [StringLength(200)]
        public string Email { get; set; }

        [Required]
        [StringLength(200)]
        public string Password { get; set; }
    }
}
