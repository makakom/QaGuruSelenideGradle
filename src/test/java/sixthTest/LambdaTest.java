package sixthTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    @Test
    @DisplayName("Проверка названия Issue в репозитории через Web-интерфейс")
    void checkNameIssuesInRepository() {
        step("1. Открыть страницу - 'https://github.com/'", () -> {
            open("https://github.com/");
        });

        step("2. В строку поиска ввести - 'Junit5'", () -> {
            $("[data-test-selector='nav-search-input']").val("Junit5").pressEnter();
        });

        step("3. Кликнуть по первому результату поиска", () -> {
            $("ul.repo-list li").$("a").click();
        });

        step("4. Проверить наличие вкладки - 'Issues'", () -> {
            $("#issues-tab").shouldBe(visible);
        });
    }
}
