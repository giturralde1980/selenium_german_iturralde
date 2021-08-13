package practicos.selenium.practico11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class spotifyByPlaceHolderTest {
    private WebDriver getDriver()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        WebDriver d = new ChromeDriver();
        d.get("https://www.spotify.com/uy/signup/");
        return d;
    }

    /*
    Ejercicio 7
        Crear una clase llamada SpotifyWithCssSelectorTest
        Crear un método llamado spotifyByPlaceHolderTest
        Ingresar al sitio: https://www.spotify.com/uy/signup/
        Completar todos los campos con Css Selector placeholder
        Crear una rama partiendo de dev llamada practico11/ejercicio7 y subir los cambios del archivo
     */
    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        WebDriver d = getDriver();
        Thread.sleep(2000);
        d.findElement(By.id("onetrust-accept-btn-handler")).click();
        //d.findElement(By.xpath("//[@id='onetrust-accept-btn-handler']"));
        d.findElement(By.cssSelector("input[name='email']")).sendKeys("test@test.uy");
        d.findElement(By.cssSelector("input[name='confirm']")).sendKeys("test@test.uy");
        d.findElement(By.cssSelector("input[name='password']")).sendKeys("test@test.uy");
        d.findElement(By.cssSelector("input[name='displayname']")).sendKeys("germanSeleniumTest");

        d.findElement(By.cssSelector("input[name='day']")).sendKeys("15");

        WebElement selectMonth = d.findElement(By.cssSelector("select[name='month']"));
        Select month = new Select(selectMonth);
        month.selectByIndex(1);

        d.findElement(By.cssSelector("input[name='year']")).sendKeys("1999");

        //Thread.sleep(5000);
        //d.findElement(By.id("gender_option_male")).click();
        //click on fieldset before ?????
        //class="encore-light-theme"

       // WebElement fieldsetRadio = d.findElement(By.cssSelector("fieldset[role='radiogroup']"));
       // Assert.assertNotNull(fieldsetRadio);


       // WebElement s1 = d.findElement(By.cssSelector("input[name='gender'][value='male']"));
       // Assert.assertNotNull(s1);

        Thread.sleep(5000);

        //WebElement s2 = d.findElement(By.xpath("//input[@name='gender'and @value='male']"));

        WebElement s2 = d.findElement(By.cssSelector("label[for='gender_option_male']"));
        Assert.assertNotNull(s2);
        s2.click();




        //s1.click();

        //d.findElement(By.cssSelector("input[id='marketing-opt-checkbox']")).click();
        //d.findElement(By.cssSelector("input[id='third-party-checkbox']")).click();

    }
}
