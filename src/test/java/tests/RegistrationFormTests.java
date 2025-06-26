package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;                                                                       // hardcode test data

public class RegistrationFormTests extends TestBase {

    @Test
    void fullRegistrationTest() {
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

        $("#currentAddress").setValue(userCurrentAddress);                                         //textarea

        $("#state").click();                                                     //text fields-dropdown lists
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();                                                                        //button

        $(".modal-dialog").should(appear);                                                       //assertions
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName),
                text(lastName), text(userEmail), text(userPhoneNumber), text(userCurrentAddress));
    }
}