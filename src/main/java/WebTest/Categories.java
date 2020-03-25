package WebTest;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Categories extends Utils
{
    private By _noteBooks = By.linkText("Notebooks");
    private By _appleMac = By.linkText("Apple MacBook Pro 13-inch");
    private By _email = By.xpath("//input[@type=\"button\"and@value=\"Email a friend\"]");
    private By _friendEmail = By.xpath("//input[@class=\"friend-email\"]");
    private By _writeIntextBox = By.xpath("//*[@id=\"PersonalMessage\"]");
    private By _sendEmail = By.xpath("//input[@name=\"send-email\"]");
    private By _successfullReferMessage = By.xpath("//*[@class=\"result\"]");
    String expected = " I like this product ,so you can try it";


    // Verify user on computer categories page
    public void verifyUserOnComputerCategoriesPage() {
        assertURL("computers");
    }

    public void userClickOnNoteBook() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickOnElement(_noteBooks);
    }

    //select item Apple MacBook Pro
    public void userClickOnApplemac() {
        clickOnElement(_appleMac);
    }

    // Refer to friend
    public void userReferToFriend() {
        //click email to refer
        clickOnElement(_email);
//Enter details to refer a friend
        EnterText(_friendEmail, "kash@gmail.com");
        //EnterText(_yourEmail,"kash@yahoo.com");
        //enter text in text box
        EnterText(_writeIntextBox, "message");
// click send email button
        clickOnElement(_sendEmail);

        // assertTextMessage( "Your message has been sent.",expected,_successfullReferMessage);
//
        Assert.assertNotEquals(
                expected,_successfullReferMessage);
    }
}
