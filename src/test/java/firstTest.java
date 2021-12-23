import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class firstTest {


    @Test
    @DisplayName("Первый тест 10 поток")
    public void firstTestQAGuru() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("test@tset.ru");
        $("#userNumber").setValue("89211111111");
        $("#genterWrapper").$(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__month").$(byText("20")).click();

        $("#subjectsInput").setValue("Economics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/paintMaster.png"));
        $("#currentAddress").setValue("test");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").scrollTo().click();

        //Asserts
        $(".modal-content").shouldBe(Condition.visible);
        $$x("//div[@class='modal-body']//td[2]").shouldHave(CollectionCondition.exactTexts(
                "Ivan Ivanov", "test@tset.ru", "Male", "8921111111", "20 December,1992", "Economics",
                "Sports", "paintMaster.png", "test", "NCR Noida"));
    }
}
