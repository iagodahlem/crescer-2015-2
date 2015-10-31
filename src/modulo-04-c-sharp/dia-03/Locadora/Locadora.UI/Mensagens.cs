using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI
{
    public class Mensagens
    {
        // Menu
        public const string TITULO = "LOCADORA DE JOGOS";
        public const string MENSAGEM_OPERACOES = "Digite a letra correspondente com a operação que deseja realizar: ";
        public const string TIPOS_OPERACAO = "C - CADASTRAR NOVO JOGO | P - PESQUISAR JOGO PELO NOME";
        public const string VOLTAR_MENU = "Pressione qualquer tecla para voltar ao menu inicial...";

        // Erros
        public const string OPERACAO_INVALIDA = "Operação solicitada inválida. Por favor, tente novamente digitando uma operação existente.";

        // Operação Cadastro
        public const string DIGITAR_NOME_JOGO = "Digite o nome do jogo: ";
        public const string DIGITAR_PRECO_JOGO = "Digite o preço do jogo: ";
        public const string DIGITAR_CATEGORIA_JOGO = "Escolha a categoria do jogo: (0 para RPG, 1 para CORRIDA, 2 para AVENTURA, 3 para LUTA, 4 para ESPORTE)";

        // Operação Pesquisa
        public const string DIGITAR_NOME_JOGO_PESQUISA = "Digite o nome do jogo que deseja pesquisar: ";
    }
}
