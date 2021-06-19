import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InterviewQuestionSiteTest {
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://allstq.com/most-popular-testng-interview-questions/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void validate_Title()
    {
        Assert.assertEquals("Most popular TestNG interview questions - Software Testing Questions",driver.getTitle());
    }

    @Test
    public void validate_Url()
    {
        Assert.assertTrue(driver.getCurrentUrl()!=null); //francamente no se me ocurrio que validar aqui con el true
    }

    @Test
    public void validate_Menu()
    {
        List<WebElement> list_menu = new ArrayList<WebElement>();
        list_menu=driver.findElements(By.xpath("//*[@id='primary-menu']"));
        for(WebElement w:list_menu)
        {
            if (w.getText().equals("Selenium"))
            {
                System.out.println("Se encontro selenium");
            }else if (w.getText().equals("Selenium"))
            {
            System.out.println("Se encontro Java");
            }
        }



    }

    @Test
    public void landingPageTest()
    {

        WebElement element=driver.findElement(By.xpath("//h1[@itemprop='headline']"));
        Assert.assertNotNull(element);
        Assert.assertEquals("MOST POPULAR TESTNG INTERVIEW QUESTIONS", element.getText());
        System.out.println(element.getText());

        //Imprimir las primeros 5 títulos y preguntas del sitio en la pantalla
        List<WebElement> list_h1 = new ArrayList<WebElement>();
        list_h1=driver.findElements(By.tagName("h1"));

        List<WebElement> list_h3 = new ArrayList<WebElement>();
        list_h3=driver.findElements(By.tagName("h3"));

        Assert.assertNotNull(list_h3);
        System.out.println("Impresion de 5 preguntas: "+ list_h3.size());
        int contador=0;
        for(WebElement w : list_h3)
        {
            if (contador<5){
                System.out.println("pregunta: " + w.getText());
                contador++;
            }
        }

        for(WebElement t : list_h1)
        {
            System.out.println("Titulos (hay unicamente uno)....:" + t.getText());
        }
    }


    @AfterMethod
    public void close()
    {
       driver.close();
    }
}
