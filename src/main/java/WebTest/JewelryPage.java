package WebTest;

import org.openqa.selenium.By;

public class JewelryPage extends Utils
{
    private By _Product1 = By.xpath("//input[contains(@onclick,'/compareproducts/add/40')]");
    private By _Product2 = By.xpath("//input[contains(@onclick,'/compareproducts/add/42')]");
    private By _ComparisonLink = By.xpath("//a[(text()='product comparison')]");
    private By _ProductBracelet = By.xpath("//a[contains(text(),'Flower Girl Bracelet')]");
    private By _Product = By.xpath("//input[@value='Add to cart']");
    private By _AddToCart = By.xpath("//span[@class='cart-label']");
    private By _ShoppingCart = By.className("//span[@class='close']");
    private By _CheckBox = By.xpath("//input[@id='termsofservice']");
    private By _checkout = By.xpath("//button[@type='submit']");
    public void VerifyUserIsOnJeweleryPage(){
        assertURL("jewelry");
    }
    public void ChooseProductsToCompare(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_Product1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_Product2);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_ComparisonLink);

    }
    public void AddToCartProduct() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_Product);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_AddToCart);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // ClickOnElement(_ShoppingCart);
        clickOnElement(_CheckBox);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_checkout);
    }

}
