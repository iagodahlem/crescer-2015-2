namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Remover_Preco : DbMigration
    {
        public override void Up()
        {
            DropColumn("dbo.Jogo", "Preco");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "Preco", c => c.Decimal(nullable: false, precision: 19, scale: 2));
        }
    }
}
