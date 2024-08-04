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
    public void click_no_botao_de_login() {
        login.clickLoginButton();
    }

    @Then("Eu verifico se a URL contem o redirecionamento correto {string}")
    public void checa_redirecionamento_apos_login(String url) {
        Assert.assertTrue(login.getUrlAtual().contains(url));

    }

}
