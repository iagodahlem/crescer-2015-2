namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                        Preco = c.Decimal(nullable: false, precision: 19, scale: 2),
                        IdCategoria = c.Int(nullable: false),
                        Descricao = c.String(nullable: false),
                        IdSelo = c.Int(nullable: false),
                        URLImagem = c.String(),
                        URLVideo = c.String(),
                        IdClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdClienteLocacao)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdCategoria)
                .Index(t => t.IdSelo);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CriarSelos();

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            CriarCategorias();
        }

        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");

            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropIndex("dbo.Jogo", new[] { "IdCategoria" });
            DropIndex("dbo.Jogo", new[] { "IdSelo" });

            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
            DropTable("dbo.Selo");
        }

        private void CriarSelos()
        {
            Sql("INSERT INTO Selo (Id, Nome) VALUES (1, 'Ouro')");
            Sql("INSERT INTO Selo (Id, Nome) VALUES (2, 'Prata')");
            Sql("INSERT INTO Selo (Id, Nome) VALUES (3, 'Bronze')");
        }

        private void CriarCategorias()
        {
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (1, 'RPG')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (2, 'Corrida')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (3, 'Aventura')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (4, 'Luta')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (5, 'Esporte')");
        }
    }
}
