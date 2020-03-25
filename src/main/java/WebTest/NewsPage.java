package WebTest;

import org.openqa.selenium.By;

public class NewsPage extends Utils
{
    LoadProp loadProp = new LoadProp();
    //user adds new comment in news home page
    private By _news = By.xpath("//a[contains(@href,'about')and(@class='read-more')]");
    private By _title = By.xpath("//input[@class='enter-comment-title']");
    private String title = "about nopcommerce website";
    private By _comment = By.xpath("//textarea[@class='enter-comment-text']");
    private String comment = "its very nice practice +"+timeStamp();
    private By _newcomment = By.xpath("//input[@name = 'add-comment']");
    private By _successmessage = By.xpath("//div[contains(text(),'successfully ')]");

    public void userClickOnDetails(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        clickOnElement(_news);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        EnterText(_title,title);
        EnterText(_comment,comment);
        clickOnElement(_newcomment);

    }
    public void verifysuccessmessageofcomment(){
        String expected = "New comment is successfully added.";
        assertTextMessage("New comment is successfully added.",expected,_successmessage);
    }
}
