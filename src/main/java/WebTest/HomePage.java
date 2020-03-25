package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Utils
{
    private By _registerLink = By.linkText("Register");
    private By _JewelryLink = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a");
    private By _itemBoxesField = By.className("product-item");
    private By _addCartButtonField = By.cssSelector("[type='button'][value='Add to cart']");
    private By _productNameField = By.cssSelector("h2.product-title > a");

    public void ClickOnRegisterButton(){
        clickOnComputers(_registerLink);

    }
    public void ClickOnJewelryLink(){
        clickOnElement(_JewelryLink);
    }
    public void UserIsOnHomePage(){
        driver.getCurrentUrl();

    }
    private By _computer = By.linkText("Computers");
    public void ClickOnComputerCatagory(){
        clickOnElement(_computer);
    }
    public void verifyAddToCompareButtonForEachProduct(){
        List<WebElement> productlist = driver.findElements(By.cssSelector(("")));
        for (WebElement we: productlist){
            System.out.println(we.getText());
        }
    }
    public void checkAddtoCartButtonOnAllProducts(){
        //finding all the items available in homepage
        List<WebElement> listOfItems = driver.findElements(_itemBoxesField);
        int count = 0 ;
        for (WebElement item : listOfItems)
        {
            //finding how many add to cart present in each item by its element
            int cart = item.findElements(_addCartButtonField).size();
            if ((cart==1)){
                count++;

            }else {
                //get title name of item which does not have add to cart button
                System.out.println("NO ADD TO CART BUTTON >>>>>>"+item.findElement(_productNameField).getText());
            }
            Assert.assertEquals(count,listOfItems.size(),"Some of items does not have ADD TO CART button");
        }

    }



}
