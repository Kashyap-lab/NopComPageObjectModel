package WebTest;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils
{
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");
    private By _email = By.id("Email");
    private By _password = By.id("Password");
    private By _confirmPassword = By.id("ConfirmPassword");
    private By _registerButton = By.id("register-button");
    private String firstName = "Kash";
    private String lastName = "shah";
    private static String timestamp = timeStamp();
    public void verifyUserIsOnRegisterPage(){
        assertURL("register");

    }

    public void userEntersRegistrationDetails(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SendText(_firstName,firstName);
        SendText(_lastName,lastName);
        SendText(_email,"Kashyap+"+timestamp+"@yahoo.com");
        SendText(_password,"12345678");
        SendText(_confirmPassword,"12345678");
        clickOnElement(_registerButton);
    }
}
