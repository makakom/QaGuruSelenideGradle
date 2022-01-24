package sixthTest;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class SelenideTest {


    @Test
    @DisplayName("Проверка названия Issue в репозитории через Web-интерфейс")
    void checkNameIssuesInRepository() {
        addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $("[data-test-selector='nav-search-input']").val("Junit5").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("#issues-tab").shouldBe(visible);
    }
}
