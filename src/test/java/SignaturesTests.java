

import java.util.concurrent.TimeUnit;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignaturesPage;
import org.openqa.selenium.support.ui.Select;


public class SignaturesTests {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static SignaturesPage signaturesPage;
    private static Select select;
    
    public SignaturesTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
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
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnSignatures();
        signaturesPage = new SignaturesPage(driver);
        
        
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
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/signatures";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        
        String expectedTitlePanel = "Signatures";
       
        
        String actualTitlePanel = signaturesPage.getPanelHeadingText();
        
        assertTrue("Panel title not correct", actualTitlePanel.startsWith(expectedTitlePanel));
        
        if(driver.findElement(By.id("newsProcessorSignaturePortalSelect"))!= null){
        System.out.println("Element is Present");}   
        else{

        System.out.println("Element is Absent");

        }
        
        if(driver.findElement(By.id("newsProcessorSignatureStatusSelect"))!= null){
        System.out.println("Element is Present");}   
        else{

        System.out.println("Element is Absent");

        }
        
        if(driver.findElement(By.id("newsProcessorSignatureCategorySelect"))!= null){
        System.out.println("Element is Present");}   
        else{

        System.out.println("Element is Absent");

        }
   
    }
    
    @Test
    public void testDeleteLastSignature() {
        
        String signatureTitleToBeDeleted = driver.findElement(By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[last()]/td[3]")).getText();
        System.out.println(signatureTitleToBeDeleted);
        signaturesPage.clickOnLastDeleteButton();
        
        //wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        signaturesPage.clickOnDeleteConfirmationButton();
        String signatureTitleAfterDeleting = driver.findElement(By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[last()]/td[3]")).getText();
        System.out.println(signatureTitleAfterDeleting);
        
        
        assertFalse("Category not deleted", signatureTitleToBeDeleted.equals(signatureTitleAfterDeleting));
     
  
        }
        
    

    @Test
    
    public void testCancelDeleteLastSignature(){
        
        String signatureTitleToBeDeleted = driver.findElement(By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[last()]/td[3]")).getText();
        System.out.println(signatureTitleToBeDeleted);
        signaturesPage.clickOnLastDeleteButton();
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        signaturesPage.clickOnCloseDeleteButton();
        
        String signatureLastTitle = driver.findElement(By.xpath("//*[@id=\"newsProcessorSignatureTable\"]/tbody/tr[last()]/td[3]")).getText();
        System.out.println(signatureLastTitle);
        
        assertTrue("Calcel delete failed!", signatureTitleToBeDeleted.equals(signatureLastTitle));
  
        
    }
    
    
    @Test
    
    public void testCancelApproveThirdSignature(){
        
        
        String statusOfThirdSignature = signaturesPage.getThirdSignatureStatustext();
        System.out.println(statusOfThirdSignature);
        
        signaturesPage.clickOnThirdAppoveButton();
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        signaturesPage.clickOnCloseApproveButton();
        
        String newStatusOfThirdSignature = signaturesPage.getThirdSignatureStatustext();
        System.out.println(statusOfThirdSignature);
        
        assertTrue("Signature approved.",statusOfThirdSignature.equals(newStatusOfThirdSignature));
   
    }

 
    @Test
    
    public void testApproveSeventhNewsUncategorised(){
        
        signaturesPage.clickOnSeventhApproveButton();
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        signaturesPage.clickOnConfirmApproveButton();
        String title = signaturesPage.getSeventhRowTitleText();
        String expectedAllert = "News processor signature\"" + title + "\"has been approved as uncategorized";
        String actualAllert = signaturesPage.getAllertSuccessMessage();
        
        
        assertTrue("Signature not approved", expectedAllert.equals(actualAllert));
 
    }

    
     @Test
     
    public void testApproveThirdNewsInCategoryB92() {
        
        signaturesPage.clickOnThirdAppoveButton();
        
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        signaturesPage.categoryApproveViaDropDown("B92");
        
        signaturesPage.clickOnConfirmApproveButton();
     
        //String elementFound = signaturesPage.getAllertSuccessMessage();
        //assertTrue("elementFound");
        
        
        String message1 = signaturesPage.getThirdRowNewsSignatureText();
        String message2 = signaturesPage.getCategoryApproveText();
        
        String expectedAllertMessage = "News processor signature \"" + message1 + "\" has been approved with category \"" + message2 +"\"";
        String actualAllertMessage = signaturesPage.getAllertSuccessMessage();
      
        
       
        assertTrue("Alert message is not correct", expectedAllertMessage.equals(actualAllertMessage));
        
  
        
    
    }
}
