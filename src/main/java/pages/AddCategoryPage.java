
package pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddCategoryPage {
    private WebDriver driver;

    public AddCategoryPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By titleField = By.className("form-control");
    private By saveButton = By.id("save-category-button");
    private By backButton = By.id("back-button");
    private By panelHeading = By.className("panel-heading");
    
    
    public void clickOnBackButton(){
        driver.findElement(backButton).click();
         }
    
    public void clickOnSaveButton(){
            driver.findElement(saveButton).click();
        }
    
    public void clickOnTitleField() {
        driver.findElement(titleField).click();
    }
    String title = "Sandra" + new Random().nextInt(1000);
    public void enterTitle (String title) {
        driver.findElement(titleField).sendKeys(title);
       
    }
    
    public String getPanelHeadingText (){
        return driver.findElement(panelHeading).getText();
    }
    
    
}
