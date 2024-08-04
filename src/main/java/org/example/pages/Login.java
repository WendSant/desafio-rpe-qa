package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    private WebDriver driver;

    private By usernameInputElement = By.name("username");
    private By passwordInputElement = By.name("password");
    private By loginButtonElement = By.xpath("//*[@id=\"login-form\"]/footer/button");
    private By forgottenPasswordLinkElement = By.linkText("Forgot password?");
    private By invalidLoginAlert = By.xpath("//*[@id=\"login-form\"]/fieldset/section[1]/font/label");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement emailInput = driver.findElement(usernameInputElement);
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputElement);
        passwordInput.sendKeys(password);
    }

    public void cliqueLoginButton() {
        WebElement loginInput = driver.findElement(loginButtonElement);
        loginInput.click();
    }

    public String getUrlAtual(){
        return driver.getCurrentUrl();
    }

    public String getAlertaCredenciaisInvalidas(){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginAlert));
        WebElement alertaCredenciaisInvalidas = driver.findElement(invalidLoginAlert);
        return alertaCredenciaisInvalidas.getText();
    }

}
