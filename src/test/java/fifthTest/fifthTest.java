package fifthTest;

import com.github.javafaker.Faker;
import fifthTest.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class fifthTest extends BaseTest {

    private static final Faker faker = new Faker();
    private static final TestData testData = new TestData();

    @BeforeEach
    void beforeEach() {
        testData
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setNumber(faker.phoneNumber().subscriberNumber(10))
                .setCurrentAddress(faker.address().fullAddress())
                .setDateOfBirth(faker.date().birthday())
                .setGender("Male")
                .setSubject(faker.rickAndMorty().character())
                .setHobbies(Arrays.asList("Sports", "Music"))
                .setPicture("paintMaster.png")
                .setCurrentAddress(faker.address().fullAddress())
                .setState("NCR")
                .setCity("Noida");
    }


    @Test
    @DisplayName("Пятый тест 10 поток")
    public void fifthTestQAGuru() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        practiceFormPage.fillFirsName(testData.getFirstName())
                .fillLastName(testData.getLastName())
                .fillEmail(testData.getEmail())
                .fillUserNumber(testData.getNumber())
                .selectGender(testData.getGender())
                .fillDateOfBirth(testData.getDateOfBirth())
                .fillSubject(testData.getSubject())
                .selectHobbies(testData.getHobbies())
                .uploadPicture(testData.getPicture())
                .fillCurrentAddress(testData.getCurrentAddress())
                .fillState(testData.getState())
                .fillCity(testData.getCity())
                .clickSubmit();

        //Asserts
       practiceFormPage.assertForm(testData);
    }

}
