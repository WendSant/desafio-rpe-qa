Feature: Testes pagina de Login do desafio
  Background:
    Given Estou na pagina de login do desafio

  Scenario: Login com sucesso com credenciais validas
    Given Digitando o login valido: "admin" e senha: "admin"
    When Eu clico no botao de login escrito Sign in
    Then Eu verifico se a URL contem o redirecionamento correto "/desafioqa/inicio"

