
Feature: Testes de Clientes dentro da plataforma
  Background:
    Given Faço login e estou na pagina de clientes da plataforma

  Scenario: Incluindo um novo cliente
    Given Que estou na pagina inicial da plataforma com a url "/desafioqa/inicio"
    And Eu coloco o mouse em cima do icone escrito "QA"
    And Eu coloco o mouse em cima item escrito "Clientes"
    Then Eu clico na opção de incluir cliente
    And Eu preencho o campo nome do cliente com:
      | nome        | cpf            | ativo | saldo |
      | Miles Morales | 740.125.693-25 | true  | 2000  |
    Then Eu clico em salvar cliente