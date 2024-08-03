Feature: Testes endpoint /resources
  Background:
    Given Estou na pagina de login do desafio

  Scenario: Login com sucesso com credenciais validas
    Given Eu digitei um usuario e senha validos
    When Eu clico no botao de login escrito Sign in
    Then Eu devo ser redirecionado para dentro da plataforma