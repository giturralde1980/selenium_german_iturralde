package practicos.selenium.examen.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import practicos.selenium.examen.PageObject.LandingPage;
import practicos.selenium.examen.PageObject.RegistrationPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExamenSelenium extends BaseTest {


    @Test
    public void Test_TitleNotNull()
    {
        LandingPage p = new LandingPage(super.driver);
        p.clickOnWebElementByXPath("//a[@role='button' and @ajaxify='/reg/spotlight/']");
        Assert.assertNotNull(p.getTitle());
    }

    @Test
    public void Test_getNumberOfErrors()
    {
        RegistrationPage p = new RegistrationPage(super.driver);
        p.clickOnWebElementByXPath("//button[@type='submit' and @name='websubmit']");

    }


/*

    @Test
    @Parameters("tagName")
    public void getH1(@Optional("h1")String tagNameValue)
    {
        List<WebElement>h1s = driver.findElements(By.tagName(tagNameValue));
        Assert.assertTrue(h1s.size()>0);
        for (WebElement ele : h1s)
        {
            System.out.println("+++++-> "+ele.getText());
        }
    }

    @Test
    @Parameters({"userName","password"})
    public void getHk(String userNameValue,String passwordValue)
    {

    }

*/



}
