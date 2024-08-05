package stepsdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Clientes;
import org.example.pages.Login;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

public class ClientesStepDefs {

    private WebDriver driver;
    private Login login;
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

    @Given("Faço login e estou na pagina de clientes da plataforma")
    public void entrando_na_pagina_inicial_da_plataforma() {
        driver.get("http://provaqa.prc.rpe.tech:9080/desafioqa/login");
        login = new Login(driver);
        clientes = new Clientes(driver);
        login.digitandoUsername("admin");
        login.digitandoPassword("admin");
        login.cliqueLoginButton();
    }

    @Given("Eu estou na pagina da plataforma com a url {string}")
    public void pagina_de_login_do_desafio(String url) {
        Assert.assertTrue(login.getUrlAtual().contains(url));
    }

    @And("Eu coloco o mouse em cima do icone escrito \"QA\"")
    public void mouse_em_cima_do_icone_escrito_qa() {
        clientes.movendoOMouseParaOIconeQA();
    }

    @And("Eu coloco o mouse em cima item escrito \"Clientes\"")
    public void mouse_em_cima_do_item_escrito_clientes() {
        clientes.movendoOMouseParaOItemClientes();
    }

    @Then("Eu clico na opção de incluir cliente")
    public void clique_em_incluir_clientes(){
        clientes.clique_em_incluir_clientes();
    }

    @And("Eu preencho o campo nome do cliente com:")
    public void preencher_campos_do_cliente(DataTable dataTable){
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            String nome = row.get("nome");
            String cpf = row.get("cpf");
            String status =row.get("ativo");
            String saldo = row.get("saldo");

            clientes.preencher_todos_os_campos_cliente(nome, cpf, status, saldo);
        }
    }

    @Then("Eu clico em salvar cliente")
    public void cliqueSalvarCliente(){
        clientes.clicar_em_salvar_cliente();
    }

    @And("Eu verifico o alerta de criação")
    public void verifica_criacao(){
        Assert.assertTrue(clientes.verificaAlertaCriarCliente());
    }

    @When("Eu clico em limpar")
    public void cliqueLimparCampos(){
        clientes.clicar_em_limpar_campos();
    }

    @Then("Os campos devem estar vazios")
    public void validar_campos_vazios(){
        Assert.assertTrue(clientes.verificaValorNomeCliente().isEmpty());
    }

    @When("Eu clico em cancelar")
    public void cliqueCancelar(){
        clientes.clicar_em_cancelar_incluir_cliente();
    }
}
