package WebTest;

import org.openqa.selenium.By;

public class ShippingAddress extends Utils
{
    //user clicks on confirm button
    private By _continue = By.xpath("//input[@onclick='ShippingMethod.save()']");

    public void userShippingAddress(){clickOnElement(_continue);

    }
}
