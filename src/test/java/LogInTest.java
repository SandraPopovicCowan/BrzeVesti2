

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
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;


public class LogInTest {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
   
    
    
    public LogInTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver,5);
     
    }
    
    @AfterClass
    public static void tearDownClass() {
       // driver.close();
    }
    
    @Before
    public void setUp() {
    driver.get("http://bvtest.school.cubes.rs/login");
    
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testValidLogin() {
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();  
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        String expectedResult = "Dashboard";
        String actualResult = driver.findElement(By.className("panel-heading")).getText();
        
        assertTrue("Panel heading is not correct.", expectedResult.equals(actualResult));
        
        WebElement navDropdown = driver.findElement(By.className("dropdown-toggle"));
        navDropdown.click();
        WebElement  logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();
    }
    
    @Test
    public void testEmtyFieldLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        String expectedEmailMessage = "The email field is required.";
        String actualEmailMaessage = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong")).getText();
        
        assertTrue("Help message is not correct.", expectedEmailMessage.equals(actualEmailMaessage));
        
        String expectedPasswordMessage = "The password field is required.";
        String actualPasswordMessage = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[2]/div/span/strong")).getText();
        
       // String EmailMessage = wait.until(EmailMessage.isDisplayed(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong"));
        
        
        assertTrue("Help message is not correct.", expectedPasswordMessage.equals(actualPasswordMessage));
        
        
    }
    
    
    @Test
    public void testInvalidEmailInvalidPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa123@cubes.rs");
        loginPage.enterPassword("cubesqa123");
        loginPage.clickOnLoginButton();
    
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
       
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        String expectedInvalidEmailMessage = "These credentials do not match our records.";
        String actualIvalidEmailMaessage = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong")).getText();
        
        assertTrue("Help message is not correct.", expectedInvalidEmailMessage.equals(actualIvalidEmailMaessage));
        
       
    }
    
    @Test
    public void testInvalidEmailValidPasswordLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa123@cubes.rs");
        loginPage.enterPassword("cubesqa");
        loginPage.clickOnLoginButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
       
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        String expectedInvalidEmailMessage = "These credentials do not match our records.";
        String actualIvalidEmailMaessage = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong")).getText();
        
        assertTrue("Help message is not correct.", expectedInvalidEmailMessage.equals(actualIvalidEmailMaessage));
    }
    
     @Test
    public void testValidEmailInvalidPasswordLogin() {
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("qa@cubes.rs");
        loginPage.enterPassword("cubesqa123");
        loginPage.clickOnLoginButton(); 
        
        String expectedUrl = "http://bvtest.school.cubes.rs/login";
        String actualUrl = driver.getCurrentUrl();
       
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        String expectedInvalidEmailMessage = "These credentials do not match our records.";
        String actualIvalidEmailMaessage = driver.findElement(By.xpath("//*[@id=\"app-layout\"]/div/div/div/div/div[2]/form/div[1]/div/span/strong")).getText();
        
        assertTrue("Help message is not correct.", expectedInvalidEmailMessage.equals(actualIvalidEmailMaessage));
 
    }
}
