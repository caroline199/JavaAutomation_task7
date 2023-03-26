package steps;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static steps.BeforeStep.driver;

public class TestHoverOnHouses {

    Actions actions = new Actions(driver);
    private static final By houseSection = By.xpath("//span[@class='b-main-navigation__text' and text()='Дома и квартиры']");
    private static final By dropdownHouseSection = By.xpath("//span[text()='Дома и квартиры']/../..//div[contains(@class, 'grid')]//span[contains(@class, 'sign')]");

    @When("Наводим курсор на пункт пункт Дома и квартиры")
    public void HoverOnHousesSection() throws InterruptedException {
        actions.moveToElement(driver.findElement(houseSection)).perform();
        sleep(1000);

    }

    @Then("Проверяем, что появилось подменю, отображающее категории - города, количество комнат, ценовой диапазон")
    public void checkHousesSubCategories() {
        ArrayList<String> houseSubCategory = new ArrayList<>();
        houseSubCategory.add("1-комнатные");
        houseSubCategory.add("2-комнатные");
        houseSubCategory.add("3-комнатные");
        houseSubCategory.add("4+-комнатные");
        houseSubCategory.add("Минск");
        houseSubCategory.add("Гомель");
        houseSubCategory.add("Могилев");
        houseSubCategory.add("Витебск");
        houseSubCategory.add("Гродно");
        houseSubCategory.add("Брест");
        houseSubCategory.add("До 30 000 $");
        houseSubCategory.add("30 000–80 000 $");
        houseSubCategory.add("От 80 000 $");

        List<String> texts = new ArrayList<>();
        for (WebElement el : driver.findElements(dropdownHouseSection)
        ) {
            texts.add(el.getText());
        }

        Assertions.assertThat(texts.containsAll(houseSubCategory)).isTrue();

    }
}