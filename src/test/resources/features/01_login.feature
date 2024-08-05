@Grupo1
Feature: Testes pagina de Login do desafio
  Background:
    Given Estou na pagina de login do desafio

  Scenario: Login com sucesso com credenciais validas
    Given Eu digito o login válido "admin" e a senha "admin"
    When Eu clico no botão de login escrito Sign in
    Then Eu verifico se a URL contém o redirecionamento correto "/desafioqa/inicio"

  Scenario Outline: Login sem sucesso com credenciais invalidas
    Given Eu digito o login invalido: "<usuario>" e senha: "<senha>"
    When Eu clico no botão de login escrito Sign in
    Then Eu recebo a messagem de erro: "<messagem_de_erro>"

    Examples:
      | usuario       | senha         | messagem_de_erro      |
      | teste         | teste         | Credenciais inválidas |
      | admin         | 123           | Credenciais inválidas |
      | admin         | teste         | Credenciais inválidas |
      | administrador | administrador | Credenciais inválidas |

  Scenario: Verificando se pagina de forgot password existe
    Given Clicando no botao de Forgot Password
    Then Sou direcionado para pagina de recuperar senha

  Scenario: Verificando checkbox lembrar
    Given Eu digito o login válido "admin" e a senha "admin"
    When Eu clico no botão de login escrito Sign in
    Then Eu verifico se a URL contém o redirecionamento correto "/desafioqa/inicio"
    When Eu clico em Sair
    Then Eu verifico se a URL contém o redirecionamento correto "/desafioqa/login"
    And Eu verifico se os dados de login "admin" e senha "admin" foram lembrados