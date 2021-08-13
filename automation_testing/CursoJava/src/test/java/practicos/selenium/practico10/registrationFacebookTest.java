package practicos.selenium.practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class registrationFacebookTest {
    private WebDriver getDriver()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        WebDriver d = new ChromeDriver();
        d.get("https://www.facebook.com");
        //click on accept cookies
        d.findElement(By.xpath("//button[@title='Accept All']")).click();

        return d;
    }

    /*
    Crear un método de test llamado fullRegistrationTest
    Ir a Facebook https://www.facebook.com/
    Completar los campos de registro con los siguientes valores:
    First Name: “John”
    Last Name: “Smith”
    Mobile: “5555555”
    New Password: “123456789”
    Birthday: Jun 26 1980
    Gender: Male
     */
    @Test
    private void fullRegistrationTest() throws InterruptedException {
        WebDriver d = getDriver();
        d.findElement(By.xpath("//a[@title='Spanish (Spain)']")).click();
        //click nueva cuenta
        d.findElement(By.xpath("//a[@role='button' and @ajaxify='/reg/spotlight/']")).click();

        Thread.sleep(2000);

        d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
        d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Smith");

        //uso email  en lubar del movil solicitado  ya que fallaba el formato de acuerdo a ubicacion
        d.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("test@test.net");
        d.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("test@test.net");

        d.findElement(By.xpath("//input[@name='reg_passwd__' and @id='password_step_input']")).sendKeys("123456789");

        Thread.sleep(2000);

        WebElement selectDias = d.findElement(By.xpath("//select[@id='day' and @name='birthday_day']"));
        Select dias= new Select(selectDias);
        dias.selectByValue("26");

        WebElement selectMeses = d.findElement(By.xpath("//select[@id='month' and @name='birthday_month']"));
        Select meses= new Select(selectMeses);
        meses.selectByIndex(5);

        WebElement selectAnos = d.findElement(By.xpath("//select[@id='year' and @name='birthday_year']"));
        Select anos= new Select(selectAnos);
        anos.selectByVisibleText("1980");

        d.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();

    }


}
