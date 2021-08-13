package practicos.selenium.examen.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import practicos.selenium.examen.PageObject.LandingPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.facebook.com");
        LandingPage p = new LandingPage(driver) ;
        p.clickOnWebElementByXPath("//button[@title='Aceptar todas']");

    }

    @AfterMethod
    public void closeDriver()
    {
       // driver.close();
    }
}
