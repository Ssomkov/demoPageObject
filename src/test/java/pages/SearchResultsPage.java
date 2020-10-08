package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import helpers.Actions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.htmlelements.annotations.Name;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage extends Actions {

    @Name("Блок с хедером")
    private SelenideElement headerBlock = $(By.xpath("//div[@class='serp-header__main']"));
    @Name("Блок со списком результата поиска")
    private SelenideElement searchResultListBlock = $(By.xpath("//ul[@id='search-result']"));

    public SearchResultsPage() {
        $(headerBlock).waitUntil(Condition.visible.because("Страница Яндекса с результатами поиска не открылась"), 10000);
    }

    @Step("Проверка отображения [{0}] блока со списком результата поиска")
    public SearchResultsPage checkVisibilitySearchResultListBlock(boolean isVisible, SoftAssert softAssert) {
        softAssert.assertEquals(isVisibleElement(searchResultListBlock, 10000, isVisible), isVisible,
                "Видимость блока со списком результата поиска ожидалась: " + isVisible);
        return this;
    }
}
