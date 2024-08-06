# Documentação e Testes da plataforma

## Descrição
Repositorio contem a documentação e a aplicação com alguns testes automatizados.

## Requisitos e dependencias do projeto:

- **Java OpenJDK 11**
- **Maven 3.9.8**
- **Selenium 1.7.32**
- **Cucumber 6.11.0**
- **TestNG 7.7.0**

## Casos de testes implementados:
### Cenário: Login
- **Login com sucesso com credenciais validas**
- **Login sem sucesso com credenciais invalidas**
- **Verificando se pagina de forgot password existe**
- **Verificando checkbox lembrar**
### Cenário: Clientes
- **Incluindo um novo cliente**
- **Incluindo um novo cliente com status de inativado**
- **Validando o botão limpar campos na tela de incluir clientes**
- **Validando o botão cancelar na tela de incluir clientes**
### Cenário: Transação
- **Incluindo nova transação**

## Passo a Passo

### Clone o repositorio
```sh
git clone https://github.com/WendSant/desafio-rpe-qa.git
```
### Entre no repositorio
```sh
cd desafio-rpe-qa
```
### Instale as dependencias e rode os testes
```sh
mvn clean install
```
O cucumber esta configurado para fazer o publish, recomendo ver o resultado dos testes pelo link disponibilizado do proprio cucumber.
