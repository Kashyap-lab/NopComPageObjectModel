package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestSuit extends BaseTest
{
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();
    Computers computers = new Computers();
    JewelryPage jewelryPage = new JewelryPage();
    ProductComparison productComparison = new ProductComparison();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();
    Categories categories = new Categories();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    GuestCheckout guestCheckout = new GuestCheckout();
    ShippingAddress shippingAddress = new ShippingAddress();
    PaymentMethod paymentMethod = new PaymentMethod();
    NewsPage newsPage = new NewsPage();
    ChangeCurrency changeCurrency = new ChangeCurrency();
    CheckoutResult checkoutResult = new CheckoutResult();

    @Test
    public void UserShouldAbleToRegisterSuccessfully() {
        //click on register button
        homePage.ClickOnRegisterButton();
        //fill up registration details
        registrationPage.verifyUserIsOnRegisterPage();

        registrationPage.userEntersRegistrationDetails();
        //verify registration success message
        registrationResultPage.VerifyUserRegistrationSuccessMessage();
    }

    @Test
    public void UserShouldBeAbleToCompareTwoDifferentProductsSuccessfully() {
        //User click on jewelry
        homePage.ClickOnJewelryLink();
        //verify user is on jewelry page
        jewelryPage.VerifyUserIsOnJeweleryPage();
        //user choose two products to compare
        jewelryPage.ChooseProductsToCompare();
        //verify user is on comparision page
        productComparison.VerifyUserIsOnComparisionPage();
    }

    @Test
    public void RegisteredUserShouldBeAbleToReferAFriendSuccessfully() {
        //click on register button
        homePage.ClickOnRegisterButton();
        //verify user is on registration page
        registrationPage.verifyUserIsOnRegisterPage();
        //Enter registration details
        registrationPage.userEntersRegistrationDetails();
        //verify user is registered successfully
        registrationResultPage.VerifyUserRegistrationSuccessMessage();
        //click on computer category
        homePage.ClickOnComputerCatagory();
        //verify user is on computer page
        categories.verifyUserOnComputerCategoriesPage();
        //user click on notebook
        categories.userClickOnNoteBook();
        //user click on Applemac
        categories.userClickOnApplemac();
        //user refer  friend
        categories.userReferToFriend();


    }

    @Test
    public void nonRegisterUserShouldNotBeAbleToReferAProductToAFriend() {
        //click on computer category
        homePage.ClickOnComputerCatagory();
        //verify user is on computer category page
        productDetailsPage.VerifyUserIsOnComputerCatagoryPage();
        //click on notebook
        productDetailsPage.userClickOnNoteBook();
        //click on Applemac
        productDetailsPage.userClickOnAppleMac();
        //Refer a friend
        productDetailsPage.UserReferToFriend();

    }

    @Test
    public void UserShouldBeAbleToSortProductHighToLowByPrice() {
        //click on computer category
        homePage.ClickOnComputerCatagory();
        //click on notebook
        computers.UserClickOnNotebook();
        //select position price High to low from dropdown
        computers.UserSelectFRomPositionPriceHighToLow();
        computers.verifyUserShouldBeAbleToSeePriceHighToLow();

    }

    @Test
    public void verifyAddToCompareButtonForEachProduct() {
        List<WebElement> productlist = driver.findElements(By.xpath(("//span[@class='price actual-price']")));
        for (WebElement we : productlist) {
            System.out.println(we.getText());
            System.out.println("*************");

            Assert.assertTrue(we.getText().contains("£"), "£ not found ");
        }
    }

    @Test
    public void guestUserShouldBeAbleToCheckoutSuccessfully() {
        //User click on jewelry
        homePage.ClickOnJewelryLink();
        //user is on jewelery page
        jewelryPage.VerifyUserIsOnJeweleryPage();
        //user add product to cart
        jewelryPage.AddToCartProduct();
        //checkout as a guest
        guestCheckout.checkoutAsGuest();
        //enter shipping address
        shippingAddress.userShippingAddress();
        //enters payment method
        paymentMethod.userChoosePaymentMethod();
        //check out successfully
        checkoutResult.verifyCheckoutSuccessMessage();
    }
    @Test
    public void userShouldBeAbleToAddNewCommentOnNopCommerceWeb(){
        //user clicks on news on home page
        newsPage.userClickOnDetails();
        //user adds new comment in news
        newsPage.verifysuccessmessageofcomment();
    }
    @Test
    public void userShouldBeAbleToVerifyCurrencyChange(){
        //user clicks on currency change option
        changeCurrency.userShouldBeAbleViewCurrencyChange();
        //verify user can view currency change
        changeCurrency.verifyCurrencyChangeFromUsDollarToEuro();


    }
    @Test
    public void verifyAddToCartButtonIsPresentInAllFeaturedProducts(){
        //user should be able to verify add to cart button is present in
        // addToCartButton.AddToCartButton();
        homePage.checkAddtoCartButtonOnAllProducts();

    }

}
