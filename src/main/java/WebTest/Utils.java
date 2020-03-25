package WebTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage
{
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    public void clickOnComputers(By by){
        driver.findElement(by).click();
    }

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public static String timeStamp(){
        DateFormat dateFormat = new SimpleDateFormat("DDmmYYHHmmSS");
        Date date=new Date();
        return dateFormat.format(date);
    }

    public void WaitForClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForvisibility(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void WaitForElementIsPresent(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void EnterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
        WaitForClickable(by, 60);
    }

    public String GetTextFromElement(By by) {
        WebElement webElement = driver.findElement(by);
        String text = webElement.getText();
        return text;
    }

    public void SelectFromDropDownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public void SelectDropDownByVisileText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public void SelectFromDropDownByIndex(By by, int index) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    public static void assertTextMessage(String message,String expected,By by){
        String actual = getTextFromElement(by);
        Assert.assertEquals(message,expected,actual);
    }

    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }
    public static void SendText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public static void navigateToJewelryPage(){
        driver.get("https://demo.nopcommerce.com/jewelry");
    }
    public static String getTextAttribute(By by){
        return driver.findElement(by).getAttribute("value");
    }
    public static void writeText(By by,String strvalue){
        driver.findElement(by).sendKeys(strvalue);
    }
    public static void SelectTextFromDropDown(By by, String text) {
        Select selectCountry = new Select(driver.findElement(by));
        selectCountry.selectByValue(text);
    }

    public static void takeScreenShot(String fileName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // The below mention will save the screenshot in a D-drive with test method name
        try {
            FileUtils.copyFile(scrFile, new File("src/test/Resources/ScreenShot/" +fileName+ ".jpg"));
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
