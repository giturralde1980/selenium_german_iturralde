package practicos.selenium;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Selenium_Primeros_Pasos {

    WebDriver driver;


    @Test
    //practico uno
    public void TestFacebook()
    {
        driver = getWebDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        //driver.close();
    }

    @Test
    //practico dos
    public void mostrarTitulo()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        String titulo = driver.getTitle();
        driver.manage().window().maximize();
        System.out.println(titulo);
    }

    @Test
    //practico 3
    public void mostrarH1yH2()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        List<WebElement> listH1 = new ArrayList<WebElement>();
        listH1 = driver.findElements(By.tagName("h1"));
        List<WebElement> listH2 = new ArrayList<WebElement>();
        listH2 = driver.findElements(By.tagName("h2"));


        for (WebElement h1 : listH1)
        {
            if (!h1.getText().isEmpty()) {
                System.out.println("titulo h1 " + h1.getText());
            }
        }
        System.out.println("cantidad total de h1 " + listH1.size());

        for (WebElement h2 : listH2)
        {
            if(!h2.getText().isEmpty()) {
                System.out.println("titulo h2 " + h2.getText());
            }
        }
        System.out.println("cantidad total de h2 " + listH2.size());
    }


    //practico 4 links
    @Test
    public void bbcMundoLinks()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        List<WebElement> links = new ArrayList<WebElement>();
        links = driver.findElements(By.tagName("a"));
        for(WebElement li : links)
        {
            System.out.println("Titulo de los links: " +li.getText());
        }

    }


    //practico 5 listas
    @Test
    public void bbcMundoListas()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        List<WebElement> listas = new ArrayList<WebElement>();
        listas = driver.findElements(By.tagName("li"));
        for(WebElement li : listas)
        {
            System.out.println("Titulo de los links: " +li.getText());
        }

    }

    @Test
    //ejercicio 6
    public void spotifyTitleTest()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        String titulo = driver.getTitle();
        if (titulo.equals("Escuchar es todo - Spotify.")) {
            System.out.println("Test passed");
        }else
        {
            //sobra el punto y por eso falla (copi paste literal del ejercicio)
            System.out.println("Test failed");
            System.out.println(titulo);
        }
    }

    @Test
    //ejercicio 7
    public void getWindowsSizeTest()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver 3");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Heithg: " +driver.manage().window().getSize().getHeight());
        System.out.println("Width " +driver.manage().window().getSize().getWidth());
        Dimension s = new Dimension(1024,768);
        driver.manage().window().setSize(s);
    }



    //ejercicio 8
    //Crear un método llamado getGoogleDriver que inicialice un sitio web www.google.com. Debe
   // retornar un objeto de tipo Webdriver
    private WebDriver getWebDriver()
    {
        driver = new ChromeDriver();
        return driver;
    }

    //ejercicio9
    //Crear un método llamado getDriver que inicialice un sitio web que recibe por parámetro. Debe
    //retornar un objeto de tipo Webdriver
    private WebDriver getDriver (String url)
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        return webDriver;
    }

    //Ejercicio 10
    //Crear un método llamado searchInGoogle
    //Acceder a google.com
    //Ingresar en el buscador, la palabra “WebElement” y presionar enter

    @Test
    private void searchInGoogle() throws InterruptedException {
        WebDriver d = getDriver("https://www.google.com");
        //WebElement element = d.findElement(By.ByXPath('//button[text()="Continuar"]'));
        List <WebElement> elements = d.findElements(By.xpath("//button"));
        Thread.sleep(5000);
        for (WebElement w : elements)
        {
            System.out.println(w.getText());
            if (w.getText().equals("I agree"))
            {
                w.click();
            }
        }

        WebElement buscador = d.findElement(By.name("q"));
        buscador.sendKeys("mama galiña..?");
        buscador.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
    }

   /* Ejercicio 11
    Crear un método llamado searchInGoogleAndGoBack
    Acceder a google.com
    Imprimir el título del sitio
    Buscar: WebElement y presionar ENTER
    Volver atras
    Refrescar la página
    Ir hacia adelante*/

    @Test
    private void searchInGoogleAndGoBack() throws InterruptedException {
        WebDriver d = getDriver("https://www.google.com");
        String titulo = d.getTitle();
        System.out.println("Titulo de la web: " + titulo);
        List <WebElement> elements = d.findElements(By.xpath("//button"));
        Thread.sleep(5000);
        for (WebElement w : elements)
        {
            System.out.println(w.getText());
            if (w.getText().equals("I agree"))
            {
                w.click();
            }
        }
        d.findElement(By.name("q")).sendKeys("soda stereo");
        d.findElement(By.name("q")).sendKeys(Keys.RETURN);

        Thread.sleep(2000);
        d.navigate().back();
        d.navigate().refresh();
        d.navigate().forward();
    }
/*
    Ejercicio 12
    Crear un método llamado facebookPageTest
    Abrir un navegador con facebook: https://www.facebook.com/
    Mostrar la cantidad de div que existen (utilizando tagname)
    Mostrar el texto de todos los tipos a (hipervínculos)
    Mostrar la cantidad de botones que tiene la página
    Mostrar los textos de los botones que se encuentran en la página*/

    @Test
    private void facebookPageTest() throws InterruptedException {
        WebDriver d = getDriver("https://www.facebook.com/");
        List <WebElement> divs = d.findElements(By.tagName("div"));
        List <WebElement> hiper = d.findElements(By.tagName("a"));
        List <WebElement> but = d.findElements(By.tagName("button"));
        //List <WebElement> txt = d.findElements(By.tagName("buton"));
        Thread.sleep(2000);
        //d.findElement(By.xpath("//button[text()='Accept all']")).click();

        System.out.println("cantidad de divs de la pagina: "+ divs.size());
        System.out.println("cantidad de hiperpinculos de la pagina: "+ hiper.size());


        System.out.println("cantidad de butons de la pagina: "+ but.size());
        for (WebElement w : but)
        {
            System.out.println("texto de 1 de los botones:"+ w.getText());
            if (w.getText().equals("Accept All"))
            {
                w.click();
            }
        }

        Thread.sleep(2000);

    }

/*
    Ejercicio 13
    Crear un método de test llamado sendKeysToFacebook
    Ir a Facebook https://www.facebook.com/
    Completar el email y contraseña con los datos: test@test.com y holamundo
            respectivamente
    Hacer click en login*/


    @Test
    private void sendKeysToFacebook(){
        WebDriver d = getDriver("https://www.facebook.com");
        List <WebElement> but = d.findElements(By.tagName("button"));
        WebElement btnLogIn=null;
        for (WebElement w : but)
        {
            System.out.println("texto de 1 de los botones:"+ w.getText());
            if (w.getText().equals("Accept All"))
            {
                w.click();
            }else if (w.getText().equals("Log In"))
            {
                 btnLogIn = w;
            }
        }

        d.findElement(By.name("email")).sendKeys("test@test.com");
        d.findElement(By.name("pass")).sendKeys("holamundo");
        btnLogIn.click();
    }

}
