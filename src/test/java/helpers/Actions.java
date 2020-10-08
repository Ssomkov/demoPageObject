package helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Actions {

    public void setTextField(SelenideElement element, String value) {
        $(element).clear();
        $(element).sendKeys(value);
    }

    public void clickElement(SelenideElement element) {
        $(element).click();
    }

    public boolean isVisibleElement(SelenideElement elem, int timeMS) {
        int step = 300;
        for (int i = 0; i < timeMS; i += step) {
            if ($(elem).isDisplayed()) {
                return true;
            }
            sleep(step);
        }
        return false;
    }

    public boolean isVisibleElement(SelenideElement elem, int timeMS, boolean expectVisibility) {
        int step = 300;
        for (int i = 0; i < timeMS; i += step) {
            if ($(elem).isDisplayed() == expectVisibility) {
                return $(elem).isDisplayed();
            }
            sleep(step);
        }
        return $(elem).isDisplayed();
    }
}
