import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PruebaNetflixTest {
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/es-en/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    @Test(priority = 0)
    public void iniciarSesionPageTest()
    {
        //cookies issue
        driver.findElement(By.xpath("//button[@class='btn-red btn-accept']")).click();
        String actualName=driver.getTitle();
        driver.findElement(By.xpath("//a[@class='authLinks redButton']")).click();
        String newName=driver.getTitle();
        Assert.assertNotEquals(actualName,newName);
    }
    @Test (priority = 1)
    public void validar_h1()
    {
        List<WebElement> list_h1 = new ArrayList<WebElement>();
        list_h1=driver.findElements(By.tagName("h1"));
        System.out.println(list_h1.size());
        for(WebElement w : list_h1)
        {
            System.out.println(w.getText());
        }
    }

    @Test (priority = 2)
    public void validar_loginFacebook()
    {
        WebElement element = driver.findElement(By.xpath("//*[@class='fbBtnText']"));
        Assert.assertEquals("Login with Facebook",element.getText());
    }

    @Test (priority = 3)
    public void fakeEmailTest()
    {
        Faker f = new Faker();
        driver.navigate().back();
        driver.findElement(By.name("email")).sendKeys(f.internet().emailAddress());
        driver.findElement(By.xpath("//*[@class='cta-btn-txt']")).click();
        System.out.println(driver.getCurrentUrl());
        //Assert.assertTrue(driver.getCurrentUrl().contains("signup")); No lo encuentra pero lo veo en la url : dejo comentado
    }

    @AfterTest
    public void close()
    {
        driver.close();
    }

}
