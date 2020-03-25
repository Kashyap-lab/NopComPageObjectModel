package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddToCartButton extends Utils
{
    //verify add to cart button is present in feature products
    public void AddToCartButton() {

        List<WebElement> listofItems = driver.findElements(By.xpath("//div[@class=\"product-item\"]"));

        {
            for (WebElement item : listofItems) {
                if (!item.getAttribute("innerHTML").contains("Add to cart")) {
                    System.out.println("This item does not have ADD to cart button>>>>>" + item.getText());
                }
            }
        }
    }
}
