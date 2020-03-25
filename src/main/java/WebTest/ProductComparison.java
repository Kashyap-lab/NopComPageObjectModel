package WebTest;

import org.openqa.selenium.By;

public class ProductComparison extends Utils
{
    String expected = "compare products";
    private By _PageTitle = By.xpath("//div [@class='page-title']");
    public void VerifyUserIsOnComparisionPage(){
        assertTextMessage("page not found",expected,_PageTitle);
    }
}
