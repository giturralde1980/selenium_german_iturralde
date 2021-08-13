package practicos.selenium.practico10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Salesforce_LinksDropdownRadiobutton {
    private WebDriver getDriver()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        WebDriver d = new ChromeDriver();
        d.get("https://login.salesforce.com");
        //click on accept cookies
        //d.findElement(By.xpath("//button[@title='Accept All']")).click();

        return d;
    }

    /*
    Ejercicio 3
    Crear un método de test llamado customSalesforceLink
    Acceder a: https://login.salesforce.com/
    Hacer click en el link “Use a Custom Domain”
    Completar el custom domain con “as”
    Hacer click en botón Continue
    Completar el campo de email con “test@test.com”
    */

    @Test
    private void customSalesforceLink()
    {
        WebDriver d=getDriver();
        d.findElement(By.xpath("//a[@id='mydomainLink' and @class='fr small']")).click();
        d.findElement(By.xpath("//input[@name='mydomain' and @id='mydomain' and @type='text']")).sendKeys("test@test.com");

    }
}
