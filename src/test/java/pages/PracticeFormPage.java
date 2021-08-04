package pages;

import com.codeborne.selenide.Selenide;
import сomponents.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormPage {

    private final static String FORM_TITLE = "Student Registration Form";
    private Calendar calendar = new Calendar();

    public PracticeFormPage openPracticeFormPage() {
        Selenide.open("/automation-practice-form");
        $x("//*[@class='practice-form-wrapper']").shouldHave(text(FORM_TITLE));
        return this;
    }

    public PracticeFormPage enterFirstName(String firstName) {
        $x("//*[@id='firstName']").val(firstName);
        return this;
    }

    public PracticeFormPage enterLastName(String lastName) {
        $x("//*[@id='lastName']").val(lastName);
        return this;
    }

    public PracticeFormPage enterEmail(String email) {
        $x("//*[@id='userEmail']").val(email);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $x("//*[@id='genterWrapper']//*[text()='" + gender + "']").click();
        return this;
    }

    public PracticeFormPage enterMobileNumber(String mobileNumber) {
        $x("//*[@id='userNumber']").val(mobileNumber);
        return this;
    }

    public PracticeFormPage selectDateOfBirth(String year, String month, String day) {
        calendar.selectDate(year, month, day);
        return this;
    }

    public PracticeFormPage enterSubject(String subject) {
        $x("//*[@id='subjectsInput']").val(subject).pressEnter();
        return this;
    }

    public PracticeFormPage uploadPicture(String path) {
        $x("//*[@id='uploadPicture']").uploadFile(new File(path));
        return this;
    }

    public PracticeFormPage enterCurrentAddress(String address) {
        $x("//*[@id='currentAddress']").val(address);
        return this;
    }

    public PracticeFormPage selectState(String state) {
        $x("//*[@id='state']").scrollTo().click();
        $x(String.format("//*[@id='stateCity-wrapper']//*[text()='%s']", state)).click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        $x("//*[@id='city']").scrollTo().click();
        $x(String.format("//*[@id='stateCity-wrapper']//*[text()='%s']", city)).click();
        return this;
    }

    public void clickSubmitButton() {
        $x("//*[@id='submit']").click();
    }

    public PracticeFormPage checkStudentName(String studentName) {
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text(studentName));
        return this;
    }

    public PracticeFormPage checkStudentEmail(String studentEmail) {
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text(studentEmail));
        return this;
    }

    public PracticeFormPage checkStudentGender(String studentGender) {
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text(studentGender));
        return this;
    }

    public PracticeFormPage checkMobileNumber(String mobileNumber) {
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text(mobileNumber));
        return this;
    }

    public PracticeFormPage checkDateOfBirth(String dateOfBirth) {
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text(dateOfBirth));
        return this;
    }

    public PracticeFormPage checkSubjects(String subjects) {
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text(subjects));
        return this;
    }

    public PracticeFormPage checkPicture(String pictureName) {
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text(pictureName));
        return this;
    }

    public PracticeFormPage checkAddress(String address) {
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text(address));
        return this;
    }

    public PracticeFormPage checkStateAndCity(String StateAndCity) {
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text(StateAndCity));
        return this;
    }
}
