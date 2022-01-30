package tenthTest;

import fifthTest.BaseTest;
import fifthTest.TestData;
import fifthTest.pages.PracticeFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("ninthTest")
public class SystemPropertiesTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    private final TestData testData = new TestData();

    @Test
    @Tag("properties")
    @DisplayName("Проверка заполнения формы студента")
    public void checkStudentFormTest() {
        practiceFormPage.openPracticeFormPage();
        practiceFormPage.fillFirsName(testData.firstName)
                .fillLastName(testData.lastName)
                .fillEmail(testData.email)
                .fillUserNumber(testData.number)
                .selectGender(testData.gender)
                .fillDateOfBirth(testData.dateOfBirth)
                .fillSubject(testData.subject)
                .selectHobbies(testData.hobbies)
                .fillCurrentAddress(testData.currentAddress)
                .fillState(testData.state)
                .fillCity(testData.city)
                .clickSubmit();

        //Asserts
       practiceFormPage.assertForm(testData);
    }

}
