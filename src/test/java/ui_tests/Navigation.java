package ui_tests;

import helpers.Config;
import helpers.Actions;
import io.qameta.allure.Step;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class Navigation extends Actions {

    @Step("Открытие главной страницы")
    public MainPage openMainPage() {
        open(Config.getMainPage());
        return new MainPage();
    }
}
