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

    @Given("Eu digitei um usuario e senha validos")
    public void digitado_um_usuario_e_senha_validos() {
        login.enterUsername("admin");
        login.enterPassword("admin");
    }

    @When("Eu clico no botao de login escrito Sign in")
    public void click_no_botao_de_login() {
        login.clickLoginButton();
    }

    @Then("Eu devo ser redirecionado para dentro da plataforma")
    public void checa_redirecionamento_apos_login() {
        Assert.assertTrue(login.getUrlAtual().contains("/desafioqa/inicio"));

    }

}
