package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static utils.WebDriverRunner.getDriver;

public class BeforeStep {

    public static WebDriver driver;

    @Given("Открываем сайт {string}")
    public void openWebSite(String url) {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver_mac64/chromedriver");
        driver = getDriver();
        driver.get("https://onliner.by");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }
}