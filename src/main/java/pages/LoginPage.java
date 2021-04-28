/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author mac
 */
public class LoginPage {
    private WebDriver driver;
    private By emailFieldLocator = By.name("email");
    private By passwordFieldLocator = By.name("password");
    private By loginButtonLocator = By.className("btn-primary");
    
    
     public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    
    
    public void enterEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
        
    }
    
    public void enterPassword (String password){
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
            
    public void clickOnLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }
    
    
}

