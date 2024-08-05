package org.example.pages;

import org.example.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Transacoes {

    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    private By transacoesItem = By.cssSelector("a[title='Transações']");;
    private By incluirTransacaoItem = By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[2]/ul/li[1]/a");
    private By selectNomesClientes = By.id("cliente");
    private By campoValorTransacao = By.id("valorTransacao");
    private By botaoSalvarTransacao = By.id("botaoSalvar");
    private By alertaSucessoTransacao = By.id("alertMessage");
    public Transacoes(WebDriver driver) {
        this.driver = driver;
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void movendoOMouseParaOItemTransacoes(){
        seleniumUtils.movendoParaOElemento(transacoesItem);
    }

    public void cliqueEmIncluirTransacao(){
        seleniumUtils.clicandoEmAlgumElemento(incluirTransacaoItem);
    }

    public void escolherClienteTransacao(String nome){
        WebElement selectNomeWebElement = driver.findElement(selectNomesClientes);
        Select selectNome = new Select(selectNomeWebElement);
        selectNome.selectByVisibleText(nome);
    }

    public void preencherCampoValorTransacao(String valor){
        seleniumUtils.digitandoEmAlgumElemento(campoValorTransacao, valor);
    }

    public void cliqueEmSalvarTransacao(){
        seleniumUtils.clicandoEmAlgumElemento(botaoSalvarTransacao);
    }

    public boolean verificaAlertaSucessoTransacao(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alertaTransacao = wait.until(ExpectedConditions.visibilityOfElementLocated(alertaSucessoTransacao));
        return alertaTransacao.isDisplayed();
    }

}
