package practicos.selenium.practico12.testNG;

import faker.FakerData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class testNg {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass()
    {

    }

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
    }

    @BeforeTest
    public void beforeTestMethod()
    {

    }

    @Test (priority = 0)
    public void VerifyTitlePage()
    {
        String expectedTitle = "Facebook - Log In or Sign Up";
        driver.findElement(By.xpath("//button[@title='Aceptar todas']")).click();
        driver.findElement(By.xpath("//a[@title='English (US)']")).click();
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @Test (priority = 1)
    public void logInKO() throws InterruptedException {
        String expected="Credenciales incorrectas\n" +
                "Nombre de usuario o contraseña no válidos";
        driver.findElement(By.xpath("//button[@title='Aceptar todas']")).click();
        FakerData f = new FakerData();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(f.getEmail());
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys(f.getPassword());
        System.out.println(f.getPassword());
        driver.findElement(By.xpath("//button[@name='login' and @value='1']")).click();
        Thread.sleep(1000);
        //List<WebElement> divs = driver.findElements(By.xpath("//div[@role='alert' and @id='error_box']"));
        String errorMessage=driver.findElement(By.xpath("//div[@role='alert' and @id='error_box']")).getText();
        Assert.assertEquals(expected,errorMessage);
    }




    @Test (priority = 2)
    public void ClickonCreateAccount()
    {
        WebElement button = driver.findElement(By.xpath("//a[@title='button']"));
        //Assert.assertNotNull(button);
    }

    @AfterTest
    public void closeDriver()
    {
        //driver.close();
    }

    @AfterMethod
    public void afterMethod()
    {

    }




}
