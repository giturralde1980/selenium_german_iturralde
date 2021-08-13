package practicos.selenium.examen.PageObject;

import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {


    public RegistrationPage(WebDriver _driver) {
        super(_driver);
    }


    public void fillPersonalInformation(String name, String lastName, String email)
    {
        sendDataToWebElementByXpath("//input[@name='firstname'",name);
        sendDataToWebElementByXpath("//input[@name='firstname'",lastName);
        sendDataToWebElementByXpath("//input[@name='name=reg_email__'",email);
        //sendDataToWebElementByXpath("//input[@name='firstname'",lastName);

    }

}


