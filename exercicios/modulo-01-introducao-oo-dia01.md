# Projeto CRESCER CWI

### Índice de exercícios

1. [Atirar flecha](#atirar-flecha)
2. [Evitando perda de flechas](#evitando-perda-de-flechas)
3. [E a resposta para tudo é...](#e-a-resposta-para-tudo-é)
4. [Sempre tem como melhorar](#sempre-tem-como-melhorar)

## Exercício 1

### Atirar Flecha

Criar atributo `experiencia` e aumentá-la a cada chamada de `atirarFlecha()`.

## Exercício 2

### Evitando perda de flechas

Alterar a classe `Elfo` para garantir que a única forma de um `Elfo` perder flechas é quando atire uma flecha.

## Exercício 3

### E a resposta para tudo é...

Alterar a classe `Elfo` para que todo `Elfo` criado sem informar quantidade flechas ganhe 42 flechas (valor *default*).

## Exercício 4

#### Sempre tem como melhorar

Analise a implementação abaixo. Caso ela possua erros ou redundâncias, corrija-os.

```Java
public atirarFlechaRefactory(this.flechas, this.experiencia){
    if(boolean acertar == true){
        flechas--;
        experiencia++;
    }else{
        flechas--;
    }
}
```