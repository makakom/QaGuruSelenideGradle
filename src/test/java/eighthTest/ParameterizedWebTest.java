package eighthTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedWebTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("JUnit5", "Issues"),
                Arguments.of("Allure", "Actions")
        );
    }

    @BeforeEach
    void beforeEach() {
        open("https://github.com/");
    }

    @AfterEach
    void AfterEach() {
        closeWebDriver();
    }

    @ValueSource(strings = {"JUnit5", "Allure"})
    @ParameterizedTest(name = "Проверка поиска на github")
    public void searchTextOnGitHub(String textSearch) {
        $("[data-test-selector='nav-search-input']").setValue(textSearch).pressEnter();
        $(".repo-list").shouldHave(Condition.text(textSearch));
    }

    @CsvSource({
            "JUnit5, Issues",
            "Allure, Actions"
    })
    @ParameterizedTest(name = "Проверка названия {1} в репозитории")
    public void checkNameTabInRepository(String textSearch, String nameTab) {
        $("[data-test-selector='nav-search-input']").setValue(textSearch).pressEnter();
        $$("ul.repo-list li").get(0).$("a").click();
        $(String.format("#%s-tab", nameTab.toLowerCase())).shouldBe(visible);
    }

    @MethodSource("methodSource")
    @ParameterizedTest(name = "Проверка названия {1} в репозитории")
    public void checkNameInRepositoryVersion2(String textSearch, String nameTab) {
        $("[data-test-selector='nav-search-input']").setValue(textSearch).pressEnter();
        $$("ul.repo-list li").get(0).$("a").click();
        $(String.format("#%s-tab", nameTab.toLowerCase())).shouldBe(visible);
    }

}
