package steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

import static utils.WebDriverRunner.getDriver;

public class AfterStep {

    public static WebDriver driver;

    @After
    public static void cleanUp() {
        driver = getDriver();
        driver.close();
    }
}