package practicos.selenium.examen.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public WebDriver driver;

    public BasePage (WebDriver _driver)
    {
        this.driver=_driver;
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public WebElement getWebElementById(String id)
    {
        WebElement webElement = this.driver.findElement(By.id(id));
        return webElement;
    }

    public WebElement getWebElementByName(String name)
    {
        WebElement webElement = this.driver.findElement(By.name(name));
        return webElement;
    }

    public WebElement getWebElementByXPath(String path)
    {
        WebElement webElement = this.driver.findElement(By.xpath(path));
        return webElement;
    }

    public List<WebElement> getListOfWebElementsByXPath(String path)
    {
        List<WebElement>listOFelements = this.driver.findElements(By.xpath(path));
        return listOFelements;
    }

    public void clickOnWebElementByXPath(String path)
    {
        this.driver.findElement(By.xpath(path)).click();
    }

    public void sendDataToWebElementByXpath(String path, String text)
    {
        this.driver.findElement(By.xpath(path)).sendKeys(text);
    }
}
