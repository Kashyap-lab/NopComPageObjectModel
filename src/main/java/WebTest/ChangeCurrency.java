package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ChangeCurrency extends Utils
{
    private By _currency = By.id("customerCurrency");
    private String value = "Euro";
    //  private String value1 = "Dollar";

    public void userShouldBeAbleViewCurrencyChange() {

        SelectDropDownByVisileText(_currency, value);
    }
    //   public void userShouldBeAbleViewCurrencyChange1(){
    //     SelectDropDownByVisileText(_currency,value1);
    // }


    public void verifyCurrencyChangeFromUsDollarToEuro() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> productlist = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        for (WebElement we : productlist) {
            System.out.println(we.getText());
            System.out.println("***************");
            softAssert.assertTrue(we.getText().contains("€"), "$ not found" + we.getText());

        }

          softAssert.assertAll();
          System.out.println("please check your currency");
    }

}
