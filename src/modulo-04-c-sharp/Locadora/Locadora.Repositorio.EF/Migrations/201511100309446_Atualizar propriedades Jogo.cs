namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AtualizarpropriedadesJogo : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Jogo", "URLImagem", c => c.String());
            AddColumn("dbo.Jogo", "URLVideo", c => c.String());
            DropColumn("dbo.Jogo", "Imagem");
            DropColumn("dbo.Jogo", "Video");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "MyProperty", c => c.Int());
            AddColumn("dbo.Jogo", "Video", c => c.String());
            AddColumn("dbo.Jogo", "Imagem", c => c.String());
            DropColumn("dbo.Jogo", "URLVideo");
            DropColumn("dbo.Jogo", "URLImagem");
        }
    }
}
