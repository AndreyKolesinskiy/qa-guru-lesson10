package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends BaseTest {

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Male";
    String mobileNumber = faker.number().digits(10);
    String yearOfBirth = "2001";
    String mothOfBirth = "June";
    String dayOfBirth = "12";
    String subject = "Math";
    String filePath = "src/test/resources/testFile.jpg";
    String pictureName = "testFile.jpg";
    String address = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Karnal";

    @Test
    @DisplayName("Test for user registration")
    public void userCanFillAndSubmitTheForm() {

        step("Open practice form page", () ->{
            practiceFormPage.openPracticeFormPage();
        });

        step("Fill form with data", () ->{
            practiceFormPage
                    .enterFirstName(firstName)
                    .enterLastName(lastName)
                    .enterEmail(email)
                    .selectGender(gender)
                    .enterMobileNumber(mobileNumber)
                    .selectDateOfBirth(yearOfBirth, mothOfBirth, dayOfBirth)
                    .enterSubject(subject)
                    .uploadPicture(filePath)
                    .enterCurrentAddress(address)
                    .selectState(state)
                    .selectCity(city);
        });

        step("Submit form", () ->{
            practiceFormPage.clickSubmitButton();
        });

        step("Verify displayed data", () ->{
            practiceFormPage
                    .checkStudentName(firstName + " " + lastName)
                    .checkStudentEmail(email)
                    .checkStudentGender(gender)
                    .checkMobileNumber(mobileNumber)
                    .checkDateOfBirth(dayOfBirth + " " + mothOfBirth + "," + yearOfBirth)
                    .checkSubjects(subject)
                    .checkPicture(pictureName)
                    .checkAddress(address)
                    .checkStateAndCity(state + " " + city);
        });
    }
}
