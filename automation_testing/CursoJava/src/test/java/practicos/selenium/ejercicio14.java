package practicos.selenium;
/*
Ejercicio 14
        Subir este ejercicio en a github en una rama nueva llamada selenium/ejercicio1.
        Crear una pull request y agregar a seleniumcurso como revisor.
        Crear un método con un nombre a seleccionar
        Acceder a Netflix: https://www.netflix.com/uy/
        Mostrar los elementos h1 y h2 que hay en el sitio
        Refrescar la página
        Mostrar el texto de los botones que se encuentran en la página
        Mostrar la cantidad de elementos div que contiene el sitio
        Obtener y mostrar el título de la página
        Mostrar la cantidad de elementos de tipos link
        */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ejercicio14 {

    @Test
    private void seleccionar(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.netflix.com/uy/");
        List<WebElement> h1s = webDriver.findElements(By.tagName("h1"));
        List<WebElement> h2s = webDriver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de h1 es: " + h1s.size());
        System.out.println("La cantidad de h2 es: " + h2s.size());
        //Page refresh
        webDriver.navigate().refresh();
        //get button texst
        List<WebElement>buttons = webDriver.findElements(By.tagName("button"));
        for (WebElement w : buttons)
        {
            if (!w.getText().equals(""))
            {
                System.out.println("texto de boton: "+ w.getText());
                //To avoid message regarding cookies acceptance
                if (w.getText().equals("Aceptar"))
                {
                    w.click();
                }
            }
        }

        //divs
        List<WebElement>divs = webDriver.findElements(By.tagName("div"));
        System.out.println("Cantidad de divs: " +divs.size());

        //titulo de la pagina
        System.out.println("Titulo de la pagina: " +webDriver.getTitle());

        //cantidad de elementos tipo link
        List<WebElement>links = webDriver.findElements(By.tagName("a"));
        System.out.println("Cantidad de links: " +links.size());


    }
}
