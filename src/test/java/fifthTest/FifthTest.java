package fifthTest;

import tenthTest.BaseTest;
import tenthTest.TestData;
import tenthTest.pages.PracticeFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FifthTest extends BaseTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    private final TestData testData = new TestData();

    @Test
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
                .uploadPicture(testData.picture)
                .fillCurrentAddress(testData.currentAddress)
                .fillState(testData.state)
                .fillCity(testData.city)
                .clickSubmit();

        //Asserts
       practiceFormPage.assertForm(testData);
    }

}
