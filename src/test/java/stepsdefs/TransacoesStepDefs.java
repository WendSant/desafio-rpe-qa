package stepsdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.Clientes;
import org.example.pages.Login;
import org.example.pages.Transacoes;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TransacoesStepDefs {

    private WebDriver driver;
    private Login login;
    private Transacoes transacoes;
    private Clientes clientes;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 800));
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("Faço login e estou na pagina de transações da plataforma")
    public void entrando_na_pagina_transacao_da_plataforma() {
        driver.get("http://provaqa.prc.rpe.tech:9080/desafioqa/login");
        login = new Login(driver);
        transacoes = new Transacoes(driver);
        clientes = new Clientes(driver);

        login.digitandoUsername("admin");
        login.digitandoPassword("admin");
        login.cliqueLoginButton();
    }

    @Given("Eu estou na pagina de transacao com a url {string}")
    public void pagina_de_login_do_desafio(String url) {
        Assert.assertTrue(login.getUrlAtual().contains(url));
    }

    @And("Eu navego até o icone de \"QA\"")
    public void mouse_em_cima_do_icone_escrito_qa() {
        clientes.movendoOMouseParaOIconeQA();
    }

    @Then("Eu navego até a opção de transações")
    public void navego_ate_transacao() {
        transacoes.movendoOMouseParaOItemTransacoes();
    }

    @And("Eu clico em Incluir")
    public void clico_em_incluir() {
        transacoes.cliqueEmIncluirTransacao();
    }

    @And("Eu escolho o cliente {string}")
    public void escolho_o_cliente(String cliente) {
        transacoes.escolherClienteTransacao(cliente);
    }

    @And("Eu preencho o campo de valor da transação com {string}")
    public void preencho_o_campo_de_transacao_com(String valor) {
        transacoes.preencherCampoValorTransacao(valor);
    }

    @Then("Eu clico em Salvar Transação")
    public void clico_em_salvar() {
        transacoes.cliqueEmSalvarTransacao();
    }

    @And("Eu Verifico se a transação foi feita")
    public void verifico_a_transacao_foi_feita() {
        Assert.assertTrue(transacoes.verificaAlertaSucessoTransacao());
    }
}
