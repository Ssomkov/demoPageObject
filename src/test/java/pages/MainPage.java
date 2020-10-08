package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends Actions {

    @Name("Яндекс лого")
    private SelenideElement yandexSearchFieldLogo = $(By.xpath("//div[@aria-label='Яндекс']"));
    @Name("Поле 'Строка поиска'")
    private SelenideElement searchField = $(By.xpath("//input[@id='text']"));
    @Name("Кнопка 'Найти'")
    private SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));

    public MainPage() {
        $(yandexSearchFieldLogo).waitUntil(Condition.visible.because("Стартовая страница Яндекса не открылась"), 10000);
    }

    @Step("Ввод значения [{0}] в поле 'Строка поиска'")
    public void setValueSearchField(String value) {
        setTextField(searchField, value);
    }

    @Step("Клик на кнопку 'Найти'")
    public void clickSearchButton() {
        clickElement(searchButton);
    }
}
