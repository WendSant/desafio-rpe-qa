package stepsdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;

import java.time.Duration;

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
        login.enterUsername(user);
        login.enterPassword(password);
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
        login.enterUsername(user);
        login.enterPassword(password);
    }

    @Then("Eu recebo a messagem de erro: {string}")
    public void recebo_mensagem_de_login_invalido(String msg_erro) {
        Assert.assertEquals(msg_erro, login.getAlertaCredenciaisInvalidas());
    }


}
