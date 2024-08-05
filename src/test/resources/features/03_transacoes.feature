@Grupo3
Feature: Testes de Clientes dentro da plataforma
  Background:
    Given Faço login e estou na pagina de transações da plataforma

  Scenario: Incluindo nova transação
    Given Eu estou na pagina de transacao com a url "/desafioqa/inicio"
    And Eu navego até o icone de "QA"
    Then Eu navego até a opção de transações
    And Eu clico em Incluir
    Then Eu estou na pagina de transacao com a url "/desafioqa/incluirVenda"
    And Eu escolho o cliente "Miles Morales"
    And Eu preencho o campo de valor da transação com "29"
    Then Eu clico em Salvar Transação
    And Eu Verifico se a transação foi feita





