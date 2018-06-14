# Prova de Recuperação -- 1º Trimestre

## Tecnologias de Programação

**João Eduardo Montandon**

**Núcleo de Tecnologia da Informação**

**Valor: 30 pontos**

**Integrantes: 3 alunos**

## Lista de Produtos

Você deverá desenvolver um aplicativo que irá gerenciar a lista de produtos que serão comprados no supermercado. Seu aplicativo deverá suportar as seguintes operações:

1. Cadastro de Produto
1. Listagem de Produtos
1. Exclusão de Produtos
1. Busca de Produto

### O Modelo de dados do Produto

O usuário deverá fornecer as seguintes informações a respeito do produto:

* Nome do produto
* Valor
* Categoria (Limpeza, Alimentação, Higiene, Vestuário)
* Foto do produto


### Cadastro de Produto

Os dados deverão ser armazenados localmente. Para os dados básicos (nome, valor e categoria), os dados deverão ser armazenados em banco de dados. Já a foto recomenda-se que seja armazenada localmente como arquivo e seu nome seja gravado no banco de dados junto com as demais informações.

### Listagem de Produtos

O aplicativo deverá listar os produtos que foram cadastrados até o momento. Para isso, você deverá implementar um componente de listagem customizada que exibirá a foto do produto a esquerda, deixando o restante do espaço para os demais dados (nome, valor e categoria).

### Exclusão de Produtos

Implemente um evento na lista de forma que se o usuário pressionar por um longo tempo um item da lista, o mesmo seja excluído. Um dialog deverá ser exibido pedindo a confirmação da exclusão, antes da efetivação do mesmo.

### Busca de Produto

Você deverá implementar um método de filtragem que permita ao usuário fazer a busca por nome ou categoria de produto. Essa busca deverá ser feita, obrigatóriamente, por meio do componente `SearchView`.

### Internacionalização

Implemente os mecanismos de internacionalização necessários para que o aplicativo seja disponibilizado em duas línguas: português e inglês.  

## Entrega

O projeto deverá ser entregue através de um pull request deste repositório até o dia 21/06/2018, às 23h59.

Além do projeto, o grupo deverá entregar um pequeno relatório indicando o que foi implementado, o que está faltando, e quem foi o responsável por implementar qual parte do sistema. 

## Avaliação

O projeto será avaliado com base nos seguintes critérios:

* Distribuição das tarefas
* Implementação das funcionalidades requisitadas
* Organização e modularização do projeto
* Organização do código e boas práticas de programação

