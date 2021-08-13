package practicos.selenium.practico13.factorias;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SpotifyHelper {

    private WebDriver driver;

    public SpotifyHelper(WebDriver _driver)
    {
        this.driver=_driver;
    }

    public void clickOnElementByXPath(String path)
    {
        this.driver.findElement(By.xpath(path)).click();
    }

    public void clickOnElementByXLinkText(String linkText)
    {
        driver.findElement(By.linkText(linkText)).click();
    }

    public void sendDataToElementByXPath(String path,String data)
    {
        this.driver.findElement(By.xpath(path)).sendKeys(data);
    }

    public List<WebElement> getListOFElementsByXPath(String path)
    {
        List<WebElement>errorsList = driver.findElements(By.xpath(path));
        return errorsList;
    }

    public void fillDataformByXpath(String name, String lastName, String email, String pass)
    {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@id='displayname']")).sendKeys(name+pass);
    }

    public WebElement getWebElementByXPath(String xpathExpression)
    {
        return driver.findElement(By.xpath(xpathExpression));
    }

    public WebElement getSelectElementByXPath(String xpathExpression)
    {
        return driver.findElement(By.xpath(xpathExpression));
    }
}
