package ui_tests;

import helpers.JsonUtils;
import io.qameta.allure.Step;
import models.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.SearchResultsPage;

public class SmokeSearchTest extends BaseTestClass {

    private static final String SMOKE_SEARCH = "src\\test\\resources\\smoke\\search.json";

    private SoftAssert softAssert;
    private Navigation navigation;
    private MainPage mainPage;
    private SearchResultsPage searchResultsPage;

    @DataProvider(name = "data")
    public java.lang.Object[][] data() {
        TestData testData = JsonUtils.generateDataFromFile(SMOKE_SEARCH, TestData.class);
        return new Object[][]{{testData}};
    }

    @Test(description = "Яндекс - проверка работы поисковой строки", dataProvider = "data")
    public void checkAutoModelTest(TestData testData) {

        navigation = new Navigation();
        softAssert = new SoftAssert();

        step1();
        step2(testData);
        step3();
        step4();

        softAssert.assertAll();
    }

    @Step("Открытие главной страницы Яндекса")
    private void step1() {
        mainPage = navigation.openMainPage();
    }

    @Step("Ввод значения [{0}] в строку поиска")
    private void step2(TestData testData) {
        mainPage.setValueSearchField(testData.getSearchValue());
    }

    @Step("Нажатие на кнопку поиска и переход на страницу с результатами")
    private void step3() {
        mainPage.clickSearchButton();
        searchResultsPage = new SearchResultsPage();
    }

    @Step("Проверка отображения [{0}] блока с результатами")
    private void step4() {
        searchResultsPage.checkVisibilitySearchResultListBlock(true, softAssert);
    }
}
