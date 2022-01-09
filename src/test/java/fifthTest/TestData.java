package fifthTest;

import java.util.Date;
import java.util.List;

public class TestData {

    private String
            firstName,
            lastName,
            email,
            number,
            gender,
            subject,
            picture,
            currentAddress,
            state,
            city;

    private Date dateOfBirth;
    private List<String> hobbies;


    public String getFirstName() {
        return firstName;
    }

    public TestData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TestData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TestData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public TestData setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public TestData setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public TestData setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public TestData setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public TestData setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
        return this;
    }

    public String getState() {
        return state;
    }

    public TestData setState(String state) {
        this.state = state;
        return this;
    }

    public String getCity() {
        return city;
    }

    public TestData setCity(String city) {
        this.city = city;
        return this;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public TestData setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public TestData setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
        return this;
    }
}
