package WebTest;

import org.openqa.selenium.By;

public class PaymentMethod extends Utils
{
    //user enters all the details for payment
    private By _checkbox = By.xpath("//input[@id='paymentmethod_1']");
    private By _continue = By.xpath("//input[@onclick='PaymentMethod.save()']");
    private By _dropdown = By.xpath("//select[@class='dropdownlists']");
    private String card = "MasterCard";
    private By _cardHolderName = By.xpath("//input[@id='CardholderName']");
    private String cardHolderName ="k k shah";
    private By _cardNum = By.xpath("//input[@name='CardNumber']");
    private String cardNum = "1234 1234 1234 1234";
    private By _expireMonth = By.xpath("//select[@name='ExpireMonth']");
    private String expireMonth = "7";
    private By _expireYear = By.xpath("//select[@name='ExpireYear']");
    private String expireyear = "2022";
    private By _cardcode = By.xpath("//input[@name='CardCode']");
    private String cardcode = "999";
    private By _contine1 = By.xpath("//input[@onclick='PaymentInfo.save()']");



    public void userChoosePaymentMethod(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_checkbox);
        clickOnElement(_continue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SelectTextFromDropDown(_dropdown,"MasterCard");
        EnterText(_cardHolderName,cardHolderName);
        EnterText(_cardNum,cardNum);
        SelectTextFromDropDown(_expireMonth,expireMonth);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SelectTextFromDropDown(_expireYear,expireyear);
        EnterText(_cardcode,cardcode);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_contine1);

    }
}
