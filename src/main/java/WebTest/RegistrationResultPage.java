package WebTest;

import org.openqa.selenium.By;

public class RegistrationResultPage extends Utils
{
    private By _registerSuccessMessage = By.className("result");
    String expected = "Your registration completed";

    public void VerifyUserRegistrationSuccessMessage(){
        //assertURL("registerresult");
        assertTextMessage("Your registration completed",expected,_registerSuccessMessage);

    }
}
