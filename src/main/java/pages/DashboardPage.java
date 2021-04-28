
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage {
    
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    private By navDashboardLocator = By.linkText("Dashboard");
    private By navSignaturesLocator = By.linkText("Signatures");
    private By navCategoriesLocator = By.linkText("Categories");
    private By navRegionsLocator = By.linkText("Regions");
    private By navPortalsLocator = By.linkText("Portals");
    private By navRSourcesLocator = By.linkText("Sources");
    private By navDropDown = By.className("dropdown-toggle");
    private By panelHeadingDahsboard = By.className("panel-heading");
    private By linkBrzeVesti = By.linkText("Brze Vesti");
    
    public void displayNavDashboard() {
        driver.findElement(navDashboardLocator).isDisplayed();
    }
    
    public void selectedNavDashoards() {
        driver.findElement(navDashboardLocator).isSelected();
    }
    
    public void clickOnNavDashboard() {
        driver.findElement(navDashboardLocator).click();
    }
    public void clickOnSignatures() {
        driver.findElement(navSignaturesLocator).click();
    }
    public void clickOnNavCategories() {
        driver.findElement(navCategoriesLocator).click();
    }
    public void clickOnNavRegions() {
        driver.findElement(navRegionsLocator).click();
    }
    public void clickOnNavPortal() {
        driver.findElement(navPortalsLocator).click();
    }
    public void clickOnNavSources() {
        driver.findElement(navRSourcesLocator).click();
    }
    public void clickOnNavDropDown() {
        driver.findElement(navDropDown).click();
    }
    public void clickOnNavBrzeVesti() {
        driver.findElement(linkBrzeVesti).click();
               
    }
     public String getPanelHeadingDashboardText (){
        return driver.findElement(panelHeadingDahsboard).getText();
    }
    
    
}
