# Sistema de Biblioteca - POO 2026.1

Sistema de gerenciamento de biblioteca desenvolvido em Java como parte do Exercício 2 da disciplina de Programação Orientada a Objetos.

## Classes

- **Livro** - Representa um livro com atributos como nome, autor, categoria, ano de publicação, editora, idioma e quantidade de páginas
- **Biblioteca** - Gerencia uma lista de livros
- **Main** - Programa principal com menu interativo

## Funcionalidades

- Adicionar livro
- Pesquisar livro
- Remover livro
- Emprestar livro
- Devolver livro

## Tratamento de Exceções

- `LivroJaExisteException` - Lançada ao tentar adicionar um livro já cadastrado
- `LivroNaoEncontradoException` - Lançada ao buscar, remover ou emprestar um livro inexistente

## Tecnologias

- Java 21
- Maven