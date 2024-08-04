package stepsdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;

public class LoginStepDefs {

    private WebDriver driver;
    private Login login;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    // ----- Inicio Login com sucesso com credenciais validas -----
    @Given("Estou na pagina de login do desafio")
    public void pagina_de_login_do_desafio() {
        driver.get("http://provaqa.prc.rpe.tech:9080/desafioqa/login");
        login = new Login(driver);

    }

    @Given("Digitando o login valido: {string} e senha: {string}")
    public void digitado_um_usuario_e_senha_validos(String user, String password) {
        login.digitandoUsername(user);
        login.digitandoPassword(password);
    }

    @When("Eu clico no botao de login escrito Sign in")
    public void clique_no_botao_de_login() {
        login.cliqueLoginButton();
    }

    @Then("Eu verifico se a URL contem o redirecionamento correto {string}")
    public void checa_redirecionamento_apos_login(String url) {
        Assert.assertTrue(login.getUrlAtual().contains(url));

    }
    // ----- Fim Login com sucesso com credenciais validas -----

    // ----- Inicio Login sem sucesso com credenciais invalidas -----
    @Given("Digitando o login invalido: {string} e senha: {string}")
    public void digitado_um_usuario_e_senha_invalidos(String user, String password) {
        login.digitandoUsername(user);
        login.digitandoPassword(password);
    }

    @Then("Eu recebo a messagem de erro: {string}")
    public void recebo_mensagem_de_login_invalido(String msg_erro) {
        Assert.assertEquals(msg_erro, login.getAlertaCredenciaisInvalidas());
    }
    // ----- Fim Login sem sucesso com credenciais invalidas -----


    // ----- Inicio Validando se pagina de forgot password existe -----

    @Given("Clicando no botao de Forgot Password")
    public void cloque_no_botao_forgot_password() {
        login.cliqueNoLinkForgotPassword();
    }

    @Then("Sou direcionado para pagina de recuperar senha")
    public void direcionado_para_recuperar_senha() {
        Assert.assertFalse(login.getUrlAtual().contains("/desafioqa/login"));

    }
    // ----- Fim Validando se pagina de forgot password existe -----


    // ----- INICIO Validando funcionamento do checkbox Lembrar -----
    @Then("Eu clico em Sair")
    public void clico_em_sair() {
       login.cliqueSairButton();
    }

    @Then("Eu verifico se os dados de login {string} e senha: {string} foram lembrados")
    public void verifico_se_os_dados_de_login_foram_lembrados(String username, String password) {
        Assert.assertFalse(
                login.verificaUsernameVazio().contains(username) &&
                        login.verificaUsernameVazio().contains(password),"Os dados não foram lembrados corretamente"


        );
    }
    // ----- FIM Validando funcionamento do checkbox Lembrar -----
}
