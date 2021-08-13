package practicos.selenium.practico10;

import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Facebook_LinksDropdownRadiobutton {
/*
    Ejercicio 1
    Crear un método de test llamado forgotAccountTest
    Ir a Facebook https://www.facebook.com/
    Validar que el título sea “Facebook - Inicia sesión o regístrate”
    Hacer click en ¿Olvidaste tu contraseña?
    Validar que el título sea “¿Olvidaste tu contraseña? | No puedo iniciar sesión |
    Facebook”
    Validar que la url sea diferente a “https://www.facebook.com/”
    */

    private WebDriver getDriver()
    {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver 3");
        WebDriver d = new ChromeDriver();
        d.get("https://www.facebook.com");
        //click on accept cookies
        d.findElement(By.xpath("//button[@title='Accept All']")).click();

        return d;
    }

    @Test
    private void forgotAccountTest() throws InterruptedException {
        WebDriver d = getDriver();
        Thread.sleep(2000);
        //cambio de idioma
        d.findElement(By.xpath("//a[@title='Spanish (Spain)']")).click();
        Assert.assertEquals(d.getTitle(), "Facebook - Entrar o registrarse");
        Assert.assertNotEquals(d.getCurrentUrl(),"https://www.facebook.com");
    }
/*
    Ejercicio 2
    Crear un método de test llamado forgotAccountPartialLinkTest
    Ir a Facebook https://www.facebook.com/
    Hacer click en “¿Olvidaste” utilizando el partialLink
    Agregar un assert que el título sea “¿Olvidaste tu contraseña? | No puedo iniciar
    sesión | Facebook”*/

    @Test
    private void forgoitAccountPartialLinkTest()
    {
        WebDriver d = getDriver();
        d.findElement(By.partialLinkText("Forgotten")).click();
        //cambio de idioma
        d.findElement(By.xpath("//a[@title='Spanish (Spain)']")).click();
        Assert.assertEquals(d.getTitle(),"¿Has olvidado la contraseña? | No puedo entrar | Facebook");
    }
/*
   Ejercicio 4
Crear un método de test llamado checkBoxAndComboboxTest
Ir a Facebook https://www.facebook.com/
Hacer click en “Crear cuenta nueva”
Completar el nombre con Alan
Completar el apellido con Smith
Setear el combo para seleccionar el sexo en Male
Completar la fecha de nacimiento con 4 de abril del 2012. Utilizar selectByValue,
selectByVisibleText y selectByIndex respectivamente*/


    @Test
    private void checkBoxAndComboboxTest() throws InterruptedException {
        WebDriver d = getDriver();
        //cambio de idioma
        d.findElement(By.xpath("//a[@title='Spanish (Spain)']")).click();
        //click nueva cuenta
        d.findElement(By.xpath("//a[@role='button' and @ajaxify='/reg/spotlight/']")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mama");
        d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Galiña");


        WebElement selectDias = d.findElement(By.xpath("//select[@id='day' and @name='birthday_day']"));
        Select dias= new Select(selectDias);
        dias.selectByValue("7");

        WebElement selectMeses = d.findElement(By.xpath("//select[@id='month' and @name='birthday_month']"));
        Select meses= new Select(selectMeses);
        meses.selectByIndex(5);

        WebElement selectAnos = d.findElement(By.xpath("//select[@id='year' and @name='birthday_year']"));
        Select anos= new Select(selectAnos);
        anos.selectByVisibleText("1978");
    }
/*
    Ejercicio 6
    Crear un método de test llamado birthdateTest
    Ir a Facebook https://www.facebook.com/
    Setear la fecha de nacimiento para el 20 de diciembre de 1990*/
    @Test
    private void birthdateTest() throws InterruptedException {
        WebDriver d = getDriver();
        d.findElement(By.xpath("//a[@role='button' and @ajaxify='/reg/spotlight/']")).click();
        Thread.sleep(2000);

        WebElement selectDia = d.findElement(By.xpath("//select[@id='day']"));
        WebElement selectMes = d.findElement(By.xpath("//select[@id='month']"));
        WebElement selectAno = d.findElement(By.xpath("//select[@id='year']"));

        Select dia=new Select(selectDia);
        Select mes=new Select(selectMes);
        Select ano=new Select(selectAno);

        dia.selectByValue("20");
        mes.selectByIndex(11);
        ano.selectByVisibleText("1990");
    }

    /*
    Ejercicio 7
    Crear un método de test llamado comboboxTest
    Ir a Facebook https://www.facebook.com/
    Obtener el elemento birthday por su nombre
    Seleccionar el elemento de enero, febrero y por último marzo
    Validar que la lista no esté vacía
    Validar que haya un único valor seleccionado. (eventualmente podría haber más)
     */

    @Test
    private void comboboxTest() throws InterruptedException {
        WebDriver d = getDriver();
        d.findElement(By.xpath("//a[@role='button' and @ajaxify='/reg/spotlight/']")).click();
        Thread.sleep(2000);

        WebElement selectDay = d.findElement(By.xpath("//select[@name='birthday_day']"));
        Select _day = new Select(selectDay);
        Assert.assertTrue(_day.getOptions().size()>0);

        WebElement selectMonth = d.findElement(By.xpath("//select[@name='birthday_month']"));
        Select _month = new Select(selectMonth);
        Assert.assertTrue(_month.getOptions().size() >0);

        _month.selectByIndex(0);
        Thread.sleep(2000);

        _month.selectByIndex(1);
        Thread.sleep(2000);

        _month.selectByIndex(2);
        Thread.sleep(2000);

        _month.selectByIndex(3);
        Thread.sleep(2000);
    }

    /*
    Ejercicio 8
Crear un método privado llamado setBirthdate que reciba como parámetro el driver, el dia, el
mes y la fecha. Debe setear la fecha de nacimiento de la persona que está completando el
formulario. Utilizar el método en la clase completeRegistration
     */

    @Test
    private void setBirthdate(WebDriver d, int day, int month, int year){

    }

}
