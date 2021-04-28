/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DashboardPage;
import pages.LoginPage;

/**
 *
 * @author mac
 */
public class DashboartTest {
    
    private static WebDriver driver;
    private static DashboardPage dashboardPage;

    
    public DashboartTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        driver = new ChromeDriver();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        driver.quit();
    }
    
    @Before
    public void setUp() {
        driver.get("http://bvtest.school.cubes.rs/login");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        dashboardPage = new DashboardPage (driver);
    }
    
    @After
    public void tearDown() {
        logout(); 
    }
    
    private void logout(){
        WebElement navDropdown = driver.findElement(By.className("dropdown-toggle"));
        navDropdown.click();
        
        WebElement  logoutButton = driver.findElement(By.linkText("Logout"));
           logoutButton.click();

    }
           
           
    @Test
    
  
    public void testElementsPresent() {
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        
        String expectedTitlePanel = "Dashboard";
        System.out.println(expectedTitlePanel);
       
        
        String actualTitlePanel = dashboardPage.getPanelHeadingDashboardText();
        System.out.println(actualTitlePanel);
        
        assertTrue("Panel title not correct", actualTitlePanel.startsWith(expectedTitlePanel));
        
        
        boolean navDashboardButtonIsDisplayed = driver.findElement(By.linkText("Dashboard")).isDisplayed();

        System.out.println("Dashboard navigation element displayed is :"+navDashboardButtonIsDisplayed);
        
        boolean navSignaturesButtonIsDisplayed = driver.findElement(By.linkText("Signatures")).isDisplayed();

        System.out.println("Signatures navigation element displayed is :"+navSignaturesButtonIsDisplayed);
        
        boolean navCategoriesButtonIsDisplayed = driver.findElement(By.linkText("Categories")).isDisplayed();

        System.out.println("Categories navigation element displayed is :"+navCategoriesButtonIsDisplayed);
        
        boolean navRegionsButtonIsDisplayed = driver.findElement(By.linkText("Regions")).isDisplayed();

        System.out.println("Regions navigation element displayed is :"+navRegionsButtonIsDisplayed);
        
        boolean navPortalsButtonIsDisplayed = driver.findElement(By.linkText("Portals")).isDisplayed();

        System.out.println("Portals navigation element displayed is :"+navPortalsButtonIsDisplayed);
        
        boolean navSourcesButtonIsDisplayed = driver.findElement(By.linkText("Sources")).isDisplayed();

        System.out.println("Sources navigation element displayed is :"+navSourcesButtonIsDisplayed);
        
       
        
        
    
}
@Test

public void testNavigationSignaturesButtonsAEnabled() {
    
        boolean navSignateresButtonEnabled = driver.findElement(By.linkText("Signatures")).isEnabled();
        
        if (navSignateresButtonEnabled==true)
              {
                     // click on the search button
                    dashboardPage.clickOnSignatures();
              }
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
}

@Test

public void testNavigationCategoriesButtonsAEnabled() {
    
        boolean navCategoriesButtonEnabled = driver.findElement(By.linkText("Categories")).isEnabled();
        
        if (navCategoriesButtonEnabled==true)
              {
                     // click on the search button
                    dashboardPage.clickOnNavCategories();
              }
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
}

@Test

public void testNavigationSourcesButtonsAEnabled() {
    
        boolean navSourcesButtonEnabled = driver.findElement(By.linkText("Sources")).isEnabled();
        
        if (navSourcesButtonEnabled==true)
              {
                     // click on the search button
                    dashboardPage.clickOnNavSources();
              }
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/sources";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
}

}
