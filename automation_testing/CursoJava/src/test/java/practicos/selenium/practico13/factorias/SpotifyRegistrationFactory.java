package practicos.selenium.practico13.factorias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SpotifyRegistrationFactory {

    WebDriver driver;
    private String name;
    private String lastName;
    private String email;
    private String pass;

    public SpotifyRegistrationFactory(String _name, String _lastName, String _email,String _pass)
    {
        this.name=_name;
        this.lastName=_lastName;
        this.email=_email;
        this.pass=_pass;
    }

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/es/signup/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void clickOnDoRegistration()
    {
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        SpotifyHelper po = new SpotifyHelper(driver);

        //po.clickOnElementByXPath("//button[@id='onetrust-accept-btn-handler']");
        po.fillDataformByXpath(name, lastName, email,pass);
        po.getWebElementByXPath("//input[@name='day']").sendKeys("16");
        WebElement select = po.getWebElementByXPath("//select[@name='month']");
        po.getWebElementByXPath("//input[@name='year']").sendKeys("1990");
        Select selectMonth = new Select(select);
        selectMonth.selectByIndex(2);
        po.clickOnElementByXPath("//button[@type='submit']");
    }
}
