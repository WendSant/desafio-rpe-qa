@Grupo2
Feature: Testes de Clientes dentro da plataforma
  Background:
    Given Faço login e estou na pagina de clientes da plataforma

  Scenario: Incluindo um novo cliente
    Given Eu estou na pagina da plataforma com a url "/desafioqa/inicio"
    And Eu coloco o mouse em cima do icone escrito "QA"
    And Eu coloco o mouse em cima item escrito "Clientes"
    Then Eu clico na opção de incluir cliente
    And Eu preencho o campo nome do cliente com:
      | nome        | cpf            | ativo | saldo |
      | Miles Morales | 740.125.693-25 | true  | 2000  |
    Then Eu clico em salvar cliente
    And Eu verifico o alerta de criação

  Scenario: Incluindo um novo cliente com status de inativado
    Given Eu estou na pagina da plataforma com a url "/desafioqa/inicio"
    And Eu coloco o mouse em cima do icone escrito "QA"
    And Eu coloco o mouse em cima item escrito "Clientes"
    Then Eu clico na opção de incluir cliente
    And Eu preencho o campo nome do cliente com:
      | nome         | cpf            | ativo | saldo |
      | Peter Parker | 316.189.592-47 | false | 20000 |
    Then Eu clico em salvar cliente
    And Eu verifico o alerta de criação

  Scenario: Validando o botão limpar campos na tela de incluir clientes
    Given Eu estou na pagina da plataforma com a url "/desafioqa/inicio"
    And Eu coloco o mouse em cima do icone escrito "QA"
    And Eu coloco o mouse em cima item escrito "Clientes"
    Then Eu clico na opção de incluir cliente
    And Eu preencho o campo nome do cliente com:
      | nome    | cpf            | ativo | saldo |
      | Tio Ben | 024.393.620-69 | true  | 250     |
    When Eu clico em limpar
    Then Os campos devem estar vazios

  Scenario: Validando o botão cancelar na tela de incluir clientes
    Given Eu estou na pagina da plataforma com a url "/desafioqa/inicio"
    And Eu coloco o mouse em cima do icone escrito "QA"
    And Eu coloco o mouse em cima item escrito "Clientes"
    Then Eu clico na opção de incluir cliente
    And Eu preencho o campo nome do cliente com:
      | nome            | cpf            | ativo | saldo  |
      | Andrew Garfield | 924.663.038-68 | true  | 300000 |
    When Eu clico em cancelar
    Then Eu estou na pagina da plataforma com a url "/desafioqa/listarCliente"