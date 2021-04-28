/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AddCategoryPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.CategoriesPage;
import pages.EditCategoryPage;

/**
 *
 * @author mac
 */
public class CategoriesTest2 {
    
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static CategoriesPage categoriesPage;
    
    public CategoriesTest2() {
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
        dashboardPage.clickOnNavCategories();
        categoriesPage = new CategoriesPage(driver);
 
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
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        
        
        String expectedTitlePanel = "Categories";
       
        
        String actualTitlePanel = categoriesPage.getPanelHeadingCategoriesText();
        
        assertTrue("Panel title not correct", actualTitlePanel.startsWith(expectedTitlePanel));
        
          
        boolean addCategoryButtonIsDisplayed = driver.findElement(By.className("pull-right")).isDisplayed();
        
        //boolean addCategoryButtonDisplayed = categoriesPage.displayAddCategoryButton(); ne radi sa POM

        System.out.println("Add category button is displayed:"+addCategoryButtonIsDisplayed);
        
        boolean categoriesTableIsDisplayed = driver.findElement(By.id("categoriesTable")).isDisplayed();
        System.out.println("Categories table is displayed:" +categoriesTableIsDisplayed);
    }
    
    
     @Test
     public void AddNewcategory() {
         
        JavascriptExecutor js = (JavascriptExecutor) driver;  
   
        categoriesPage.clickOnAddCategoryButton();
       
        AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
        
        
        addCategoryPage.clickOnTitleField();
               
        String title = "Sandra" + new Random().nextInt(1000);
        addCategoryPage.enterTitle(title);
        
        addCategoryPage.clickOnSaveButton();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));
        

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        String lastCategory = driver.findElement(By.xpath("//table[@id='categoriesTable']//tr[last()]//td[3]")).getText();
        
        assertTrue("New category not added", lastCategory.equals(title));
        
     
        String expectedResult = "Category \"" +title + "\" has been successfully saved!";
        String actualResult = driver.findElement(By.className("alert-success")).getText();
        
        assertTrue("Alert message is not correct", expectedResult.equals(actualResult));
 
     
     }
     
     @Test
     public void testCancelAddingNewCategory (){
         
   
        categoriesPage.clickOnAddCategoryButton();
        
        AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
        addCategoryPage.clickOnBackButton();
        
      
        
        String expectedResult = "http://bvtest.school.cubes.rs/admin/categories";
        String actualResult = driver.getCurrentUrl();
        
        assertTrue("Back button did not take us to the expected URL", expectedResult.equals(actualResult));

         
     }
  
     @Test
     public void delete20thCategory() {
         
        
        String categoryDeletedTitle = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[3]")).getText();
        categoriesPage.clickOn20thCategoriesTableDeleteButton();
        
        //wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        
        categoriesPage.clickOnDeleteConfirmationButton();

        String categoryTitleAfterDeleting = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[3]")).getText();
        
        
        assertFalse("Category not deleted", categoryDeletedTitle.equals(categoryTitleAfterDeleting));
        
        String title = categoriesPage.get20thCategoryTitle();
        String expectedResult = "Category \"" +title + "\" has been successfully deleted!";
        String actualResult = categoriesPage.getAllertSuccessMessage();
        
        assertTrue("Alert message is not correct", expectedResult.equals(actualResult));
  
     }
     
     @Test 
      public void edit20thCategoryName() {
          
        
        
        String categoryOldName = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[20]/td[3]")).getText(); 
        System.out.println(categoryOldName);
          
        categoriesPage.clickOn20thCategoriesEditButton();
        
          
        EditCategoryPage editCategoryPage = new EditCategoryPage(driver);
        
        editCategoryPage.clickOnTitleField();
        editCategoryPage.clearTitleField();
    
      
        String title = "Edited" + new Random().nextInt(1000);
        editCategoryPage.enterNewCategoryTitle(title);
        System.out.println(title);
        
        editCategoryPage.clickOnSaveButton();
       
        
        assertFalse("Category name not changed", categoryOldName.equals(title));
          
         
        String expectedResult = "Category \"" +title + "\" has been successfully saved!";
        String actualResult = categoriesPage.getAllertSuccessMessage();
        
        assertTrue("Alert message is not correct", expectedResult.equals(actualResult));
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
       
        
        assertTrue("URL does not match", expectedUrl.equals(actualUrl));

     }
     
}
//10 test caseva minimum, u google sheet se napise manuelno 10 caseva, ne mora biti po scenarijima i da se onda automatizuje;
//da li su TC dobro napisani;
//kod koda je najbitnije da li testovi rade;
//propitivanje elemenata, manulni test da se procita i da se podeli kod zooma i iskomentarise i objasni;
//pitanja -,  odemo na sajt i pitamo sta je adres bar da li je domen ili nesto drugo, da se pojasni
//sta je admin panel ako se radi test case za admin panel
//opsta tehnicka pismenost, status kodovi, HTTL protocol, response
//automatski deo se ne gleda da li je kod savrsen, ali pitace da se prodje kroz kod
//objasniti metodu
//podrazumeva se da se zna (JAVA) sta su metode, sta je klasa, sta je objekat klase, sta metoda radi, pomocu ove metode na ovoj stranici pomocu ovog lokatora nalazimo tu ti tu stvar
//id locator je atribut elementa koji oznacava taj element, obnoviti elemente HTML-a
