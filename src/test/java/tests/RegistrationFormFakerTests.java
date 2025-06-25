package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormFakerTests extends TestBase {

    @Test
    void successfulRegistrationTest() {

        Faker faker = new Faker(new Locale("en-US"));                             //random test data generation
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userPhoneNumber = faker.phoneNumber().subscriberNumber(10),
                userCurrentAddress = faker.address().fullAddress();

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);                                                    //text fields
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText("Other")).click();                             //radio button

        $("#userNumber").setValue(userPhoneNumber);                                              //text field

        $("#dateOfBirthInput").click();                                                            //calendar
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Math").pressEnter();                         //text field-dropdown list

        $("#hobbiesWrapper").$(byText("Sports")).click();                               //checkbox

        $("#uploadPicture").uploadFromClasspath("images/Me.jpg");                       //file upload

        $("#currentAddress").setValue(userCurrentAddress);                                        //text area

        $("#state").click();                                                     //text fields-dropdown lists
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();                                                                        //button

        $(".modal-dialog").should(appear);                                                        //assertion

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName),
                text(lastName), text(userEmail), text(userPhoneNumber), text(userCurrentAddress));
    }
}