
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SignaturesPage {
    
    private WebDriver driver;
    private Select select;

    public SignaturesPage(Select select) {
        this.select = select;
    }
   

    public SignaturesPage(WebDriver driver) {
        this.driver = driver;
    }
    
    private By portalDropDownLocator = By.id("newsProcessorSignaturePortalSelect");
    private By signatureDropDownLocator = By.id("newsProcessorSignatureStatusSelect");
    private By categoryDropDownLocator = By.id("newsProcessorSignatureCategorySelect");
    private By firstDeleteButton = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[1]/td[6]/div/button[3]");
    private By lastDeleteButton = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[last()]/td[6]/div/button[3]");
    private By thirdRowApproveButton = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[3]/td[6]/div/button[1]");
    private By seventhRowApproveButton = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[7]/td[6]/div/button[1]");
    private By seventhRowTitleLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[7]/td[3]");
    private By confirmApproveButton = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div/div[3]/button[2]");
    private By panelHeadingSignaturePage = By.className("panel-heading");
    private By categoryConfirmLocator = By.id("newsProcessorSignatureCategoryApprove");
    private By closeApproveButtonLocator = By.xpath("//*[@id=\"newsProcessorSignatureApproveDialog\"]/div/div/div[3]/button[1]");
    private By alertSuccessLocator = By.className("alert-success");
    private By thirdRowNewsSignature = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[3]/td[3]");
    private By confirmDeleteLocator = By.xpath("//*[@id=\"newsProcessorSignatureDeleteDialog\"]/div/div/div[3]/button[2]");
    private By closeDeleteButtonLocator = By.xpath("//*[@id=\"newsProcessorSignatureDeleteDialog\"]/div/div/div[3]/button[1]");
    private By statusThirdSignatureLocator = By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[3]/td[5]/span");
    //private Select portalSelect = By.id("newsProcessorSignaturePortalSelect");
    
    public void clickOnFirstDeleteButton() {
        driver.findElement(firstDeleteButton).click();
    }
    public void clickOnLastDeleteButton() {
        driver.findElement(lastDeleteButton).click();
    }
    
    public void clickOnThirdApproveButton() {
        driver.findElement(thirdRowApproveButton).click();
    }
    
    public void clickOnConfirmApproveButton() {
        driver.findElement(confirmApproveButton).click();
    }
    
    public  void portalSelectViaDropDown(int index) {
      driver.findElement(portalDropDownLocator);
      select.selectByIndex(index); 
    }
    
    
    public  void signatureSelectViaDropDown(int index) {
      driver.findElement(signatureDropDownLocator);
      select.selectByIndex(index); 
    }
     
    public  void categorySelectViaDropDown(int index) {
      driver.findElement(categoryDropDownLocator);
      select.selectByIndex(index); 
    }
      
    public  void categoryApproveViaDropDown(int index) {
      driver.findElement(categoryConfirmLocator);
      select.selectByIndex(index);
     
    }
    
    public String getCategoryApproveText () {
        return driver.findElement(categoryConfirmLocator).getText();
    }
    
    public String getPanelHeadingText () {
        return driver.findElement(panelHeadingSignaturePage).getText();
    }
      
    public void clickOnThirdAppoveButton() {
        driver.findElement(thirdRowApproveButton).click();
      }
      
    public void clickOnCloseApproveButton() {
        driver.findElement(closeApproveButtonLocator).click();
      }
      
    public String getAllertSuccessMessage (){
        return driver.findElement(alertSuccessLocator).getText();
    } 
      
    public String getThirdRowNewsSignatureText (){
        return driver.findElement(thirdRowNewsSignature).getText();
    } 
    
    public void clickOnDeleteConfirmationButton() {
        driver.findElement(confirmDeleteLocator).click();
    }
    
    public void clickOnCloseDeleteButton() {
        driver.findElement(closeDeleteButtonLocator).click();
    }
    
     public String getThirdSignatureStatustext (){
        return driver.findElement(statusThirdSignatureLocator).getText();
    } 
     
     public void clickOnSeventhApproveButton() {
         driver.findElement(seventhRowApproveButton).click();
     }
     
     public String getSeventhRowTitleText() {
         return driver.findElement(seventhRowTitleLocator).getText();
     }
}
