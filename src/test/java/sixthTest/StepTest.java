package sixthTest;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StepTest {

    @Test
    @DisplayName("Проверка названия Issue в репозитории через Web-интерфейс")
    void checkNameIssuesInRepository() {
        openPage("https://github.com/");
        searchValue("Junit5");
        clickLinkByIndex(1);
        checkTab("Issues");
    }

    @Step("Открыть страницу - '{url}'")
    private void openPage(String url) {
        open(url);
    }

    @Step("Ввести в строку поиска '{value}' и нажать Enter")
    private void searchValue(String value) {
        $("[data-test-selector='nav-search-input']").val(value).pressEnter();
    }

    @Step("Кликнуть по {index} результату поиска")
    private void clickLinkByIndex(int index) {
        $$("ul.repo-list li").get(index).$("a").click();
    }

    @Step("Проверить, что присутствует вкладка - '{nameTab}'")
    private void checkTab(String nameTab) {
        $(String.format("#%s-tab", nameTab.toLowerCase())).shouldBe(visible);
    }
}
