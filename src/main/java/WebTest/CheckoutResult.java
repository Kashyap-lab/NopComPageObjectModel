package WebTest;

import org.openqa.selenium.By;

public class CheckoutResult extends Utils
{
    private By _checkoutsuccessmessage =By.xpath("//strong[contains(text(),'processed')]");

    public void verifyCheckoutSuccessMessage()

    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_checkoutsuccessmessage);
        String expected = "Your order has been successfully processed!";
        assertTextMessage("checkout is not successful",expected,_checkoutsuccessmessage);
    }
}
