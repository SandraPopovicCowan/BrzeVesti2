
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CategoriesPage {
    
    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;

 

    public CategoriesPage(Actions actions) {
        this.actions = actions;
    }

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By addCategoryButton = By.className("pull-right");
    private By panelHeadingCategoriesLocator = By.className("panel-heading");
    //private By categoriesTablLocator = By.id("categoriesTable");
    private By lastCategoriesTableDeleteButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[last()]/td[5]/div/button[2]");
    private By twentiethCategoriesTableDeleteButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[5]/div/button[2]");
    private By twentiethCategoriesTableDisableButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[5]/div/button[1]");
    private By twenthiethCategotyTitle = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[3]");
    private By lastCategoriesTableDisableButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[last()]/td[5]/div/button[1]");
    private By twentiethCategoriesTableEditButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[5]/div/a");
    private By lastCategoriesTableEditButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[last()]/td[5]/div/a");
    //private By firstCategoriesTableReorderButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[1]/td[1]/span");
    //private By lastCategoriesTableReorderButton = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[last()]/td[1]/span");
    private By dragElementLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[1]/span");
    private By dropElementLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[30]/td[1]/span");
    private By deleteConfirmationButtonLocator = By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]");
    private By twentiethCategoryTitleLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[3]");
    private By lastCategoryTitleLocator = By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[last()]/td[3]");
    private By alertSuccessLocator = By.className("alert-success");
            
   
    
    
    public void clickOnAddCategoryButton() {
        driver.findElement(addCategoryButton).click();
    }
    
    public String getPanelHeadingCategoriesText (){
        return driver.findElement(panelHeadingCategoriesLocator).getText();
    }
    
    public void clickOnLastCategoriesTableDeleteButton() {
        driver.findElement(lastCategoriesTableDeleteButton).click();
    }
    public void clickOn20thCategoriesTableDeleteButton() {
        driver.findElement(twentiethCategoriesTableDeleteButton).click();
    }
    
    public void clickOn20thCategoriesTableDisableButton() {
        driver.findElement(twentiethCategoriesTableDisableButton).click();
                
    }
    public void clickOnLastCategoriesTableDisableButton() {
        driver.findElement(lastCategoriesTableDisableButton).click();
    }
    
    public void clickOn20thCategoriesEditButton() {
        driver.findElement(twentiethCategoriesTableEditButton).click();
    }
    
    
    public void clickOnLastCategoriesEditButton() {
        driver.findElement(lastCategoriesTableEditButton).click();
    }
    public void clickOnDeleteConfirmationButton() {
        driver.findElement(deleteConfirmationButtonLocator).click();
    }
    
     public String get20thCategoryTitle (){
        return driver.findElement(twentiethCategoryTitleLocator).getText();
    } 
     
    public String getLastCategoryTitle (){
        return driver.findElement(lastCategoryTitleLocator).getText();
    } 
    
     public String getAllertSuccessMessage (){
        return driver.findElement(alertSuccessLocator).getText();
    } 
     
     public String get20thCategoryTitleText() {
         return driver.findElement(twenthiethCategotyTitle).getText();
     }
    
     public void displayAddCategoryButton() {
         driver.findElement(addCategoryButton).isDisplayed();
     }
//    public void clickDragAndDrop() {
//       driver.findElement(dragElementLocator).click();
//       actions.dragAndDrop(dragElementLocator, dropElementLocator).build().perform();
//    }
    
    
    
}
    

