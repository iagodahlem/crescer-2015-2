namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Adicionarvaloredatanojogo : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "Valor", c => c.Decimal(precision: 19, scale: 2));
            AddColumn("dbo.Jogo", "DataEntrega", c => c.DateTime());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Jogo", "DataEntrega");
            DropColumn("dbo.Jogo", "Valor");
        }
    }
}
