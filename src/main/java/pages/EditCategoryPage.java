
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EditCategoryPage {
    
    private WebDriver driver;

    public EditCategoryPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By titleFieldLocator = By.id("title");
    private By backButtonLocator = By.id("back-button");
    private By saveButtonLocator = By.name("save-category-button");
    private By panelHeadingLocator = By.className("panel-heading");
    
    public void clickOnTitleField() {
        driver.findElement(titleFieldLocator).click();
    }
    
    public void clearTitleField() {
        driver.findElement(titleFieldLocator).clear();
    }
 
    public void enterNewCategoryTitle(String title) {
        driver.findElement(titleFieldLocator).sendKeys(title);
        
    }
    
    public void clickOnSaveButton() {
        driver.findElement(saveButtonLocator).click();
    }
    
    public void clickOnBackButton() {
        driver.findElement(backButtonLocator).click();
    }
    
    
     public String getPanelHeadingText (){
        return driver.findElement(panelHeadingLocator).getText();
    }
    
    
}
