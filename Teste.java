import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Teste {

    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://demodirectory.com.br/");
        driver.manage().window().maximize();
    }
    @Test
    public void CriarAnuncioTest(){
        driver.findElement(By.xpath("//span[text()='Papéis do Site']")).click();
        driver.findElement(By.linkText("Administrador")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("sitemgr@demodirectory.com");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("abc123");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
        driver.findElement(By.linkText("Conteúdo")).click();
        driver.findElement(By.linkText("Anúncios")).click();
        driver.findElement(By.linkText("Adicionar anúncio")).click();

       WebElement element = driver.findElement(By.id("listingLevel"));
       Select option = new Select(element);
       option.selectByVisibleText("Diamante");

       WebElement element1 = driver.findElement(By.id("listingTemplate"));
       Select combo = new Select(element1);
       combo.selectByVisibleText("Empresa");


       driver.findElement(By.id("name")).sendKeys("Cucumber");
       driver.findElement(By.id("browse-categories")).click();
       driver.findElement(By.xpath("//input[@class='form-control category-search']")).sendKeys("Bares");

       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/a[@class='addCategory']")));
       driver.findElement(By.xpath("//div/a[@class='addCategory']")).click();
       driver.findElement(By.xpath("//button[@class='btn btn-primary action-save']")).click();


    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
