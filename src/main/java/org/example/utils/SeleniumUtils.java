package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumUtils {

    private WebDriver driver;
    private Actions actions;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void movendoParaOElemento(By elemento) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
        actions.moveToElement(element).perform();
    }


    public void clicandoEmAlgumElemento(By elemento) {
        WebElement element = driver.findElement(elemento);
        element.click();
    }

    public void digitandoEmAlgumElemento(By elemento, String text) {
        WebElement element = driver.findElement(elemento);
        element.sendKeys(text);
    }
}


