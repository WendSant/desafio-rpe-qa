package org.example.pages;

import org.example.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Clientes {

    private WebDriver driver;
    private SeleniumUtils seleniumUtils;

    private By menuIcon = By.cssSelector("a[title='QA']");
    private By clientesItem = By.cssSelector("a[title='Clientes']");;
    private By incluirItem = By.xpath("//*[@id=\"left-panel\"]/nav/ul[2]/li/ul/li[1]/ul/li[1]/a");
    private By campoNomeClienteItem = By.id("nome");
    private By campoCPFClienteItem = By.id("cpf");
    private By selectStatusClienteItem = By.id("status");
    private By camposaldoClienteItem = By.id("saldoCliente");
    private By botaoSalvarCliente = By.id("botaoSalvar");

    public Clientes(WebDriver driver) {
        this.driver = driver;
        this.seleniumUtils = new SeleniumUtils(driver);
    }

    public void movendoOMouseParaOIconeQA() {
        seleniumUtils.movendoParaOElemento(menuIcon);
    }

    public void movendoOMouseParaOItemClientes(){
        seleniumUtils.movendoParaOElemento(clientesItem);
    }

    public void clique_em_incluir_clientes(){
        seleniumUtils.clicandoEmAlgumElemento(incluirItem);
    }

    public void preencher_todos_os_campos_cliente(String nmCliente, String cpfCliente,String status,String saldoCliente){
        digitar_no_campo_nome_cliente(nmCliente);
        digitar_no_campo_cpf_cliente(cpfCliente);
        escolher_status_cliente(status);
        digitar_no_campo_saldo_cliente(saldoCliente);
    }

    public void digitar_no_campo_nome_cliente(String nmCliente){
        seleniumUtils.digitandoEmAlgumElemento(campoNomeClienteItem, nmCliente);
    }

    public void digitar_no_campo_cpf_cliente(String cpfCliente){
        seleniumUtils.digitandoEmAlgumElemento(campoCPFClienteItem, cpfCliente);

    }

    public void digitar_no_campo_saldo_cliente(String saldoCliente){
        seleniumUtils.digitandoEmAlgumElemento(camposaldoClienteItem, saldoCliente);
    }

    public void escolher_status_cliente(String status){
        WebElement selectStatusWebElement = driver.findElement(selectStatusClienteItem);
        Select selectStatus = new Select(selectStatusWebElement);
        selectStatus.selectByValue(status);
    }

    public void clicar_em_salvar_cliente(){
        seleniumUtils.clicandoEmAlgumElemento(botaoSalvarCliente);
    }
}
