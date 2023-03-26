package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static steps.BeforeStep.driver;

public class TestHoverOnCars {
    Actions actions = new Actions(driver);
    private static final By carSection = By.xpath("//span[@class='b-main-navigation__text' and text()='Автобарахолка']");
    private static final By dropdownCarSection = By.xpath("//a[text()='Автобарахолка']/../..//div[contains(@class, 'grid')]//span[contains(@class, 'sign')]");


    @When("Наводим курсор на пункт Автобарахолка")
    public void HoverOnCarSection() throws InterruptedException {
        actions.moveToElement(driver.findElement(carSection)).perform();
        sleep(1000);
    }

    @Then("Проверяем, что появилось подменю, отображающее категории - деление по ценам, по городам и марки")
    public void checkCarSubCategories() {
        ArrayList<String> carSubCategory = new ArrayList<>();
        carSubCategory.add("Отзывы об авто");
        carSubCategory.add("Новые авто");
        carSubCategory.add("С пробегом");
        carSubCategory.add("Цена с НДС");
        carSubCategory.add("Авто до 4000 р.");
        carSubCategory.add("Авто до 10 000 р.");
        carSubCategory.add("Минск");
        carSubCategory.add("Гомель");
        carSubCategory.add("Могилев");
        carSubCategory.add("Витебск");
        carSubCategory.add("Гродно");
        carSubCategory.add("Брест");
        carSubCategory.add("Audi");
        carSubCategory.add("BMW");
        carSubCategory.add("Citroen");
        carSubCategory.add("Ford");
        carSubCategory.add("Mazda");
        carSubCategory.add("Mercedes-Benz");
        carSubCategory.add("Nissan");
        carSubCategory.add("Opel");
        carSubCategory.add("Peugeot");
        carSubCategory.add("Renault");
        carSubCategory.add("Toyota");
        carSubCategory.add("Volkswagen");

        List<String> texts = new ArrayList<>();
        for (WebElement el : driver.findElements(dropdownCarSection)
        ) {
            texts.add(el.getText());
        }

        Assertions.assertThat(texts.containsAll(carSubCategory)).isTrue();

    }
}