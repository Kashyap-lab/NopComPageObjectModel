package WebTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserSelector extends Utils {
    // 1
    public static LoadProp loadProp = new LoadProp();
    public static final String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");


    public void setUpBrowser() {
        LoadProp loadProp = new LoadProp();
        System.out.println("We are using... " + browser + "browser");
        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);

        // 2
        // if sauce lab is true ....
        if (SAUCE_LAB) {
            System.out.println("Running is SauceLab....with browser " + browser);

            if (browser.equalsIgnoreCase("chrome")) {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "windows 8");
                caps.setCapability("version", "78.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                loadProp.getProperty("url");
                System.out.println(URL);
                // 3
            } else if (browser.equalsIgnoreCase("IE")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "11");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                // 4.
            } else if (browser.equalsIgnoreCase("FireFox")) {
                DesiredCapabilities caps = DesiredCapabilities.firefox();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "56");
                caps.setCapability("name", "Testing on Firefox 56");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                // 7
            } else if (browser.equalsIgnoreCase("Safari")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "OS X 10.10");
                caps.setCapability("version", "8.0");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                // 8
            } else if (browser.equalsIgnoreCase("edge")) {
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability("platform", "Windows 10");
                caps.setCapability("version", "16.16299");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver.get(loadProp.getProperty("url"));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Wrong browser name or empty: " + browser);

            }

        }
        // if sauce lab is false
        else {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/Resources/BrowserDriver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                //  user select firefox browser
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/Resources/BrowserDriver/geckodriver.exe");

                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
                // user select Internet Explorer browser
            } else if (browser.equalsIgnoreCase("Internet Explorer")) {
                System.setProperty("webdriver.ie.driver", "src/test/resources/BrowserDriver/IEDriverServer.exe");

                driver = new InternetExplorerDriver();
                driver.manage().window().fullscreen();
                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                driver.get("https://demo.nopcommerce.com/");
            } else {
                System.out.println("Browser is not correct" + browser);
            }

        }

    }

    public void CloseBrowser()
    {
        driver.quit();

    }
}


