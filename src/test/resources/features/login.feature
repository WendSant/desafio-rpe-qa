Feature: Testes pagina de Login do desafio
  Background:
    Given Estou na pagina de login do desafio

  Scenario: Login com sucesso com credenciais validas
    Given Digitando o login valido: "admin" e senha: "admin"
    When Eu clico no botao de login escrito Sign in
    Then Eu verifico se a URL contem o redirecionamento correto "/desafioqa/inicio"

  Scenario Outline: Login sem sucesso com credenciais invalidas
    Given Digitando o login invalido: "<usuario>" e senha: "<senha>"
    When Eu clico no botao de login escrito Sign in
    Then Eu recebo a messagem de erro: "<messagem_de_erro>"

    Examples:
      | usuario       | senha         | messagem_de_erro      |
      | teste         | teste         | Credenciais inválidas |
      | admin         | 123           | Credenciais inválidas |
      | admin         | teste         | Credenciais inválidas |
      | administrador | administrador | Credenciais inválidas |
