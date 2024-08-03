package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private WebDriver driver;

    private By usernameInputElement = By.name("username");
    private By passwordInputElement = By.name("password");
    private By loginButtonElement = By.xpath("//input[@type='submit']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String email) {
        WebElement emailInput = driver.findElement(usernameInputElement);
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputElement);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginInput = driver.findElement(loginButtonElement);
        loginInput.click();
    }

}
