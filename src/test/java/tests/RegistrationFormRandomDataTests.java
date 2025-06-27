package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class RegistrationFormRandomDataTests extends TestBase {

    @Test
    void fullRegistrationTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(fakerFirstName);                                              //text fields
        $("#lastName").setValue(fakerLastName);
        $("#userEmail").setValue(fakerUserEmail);

        $("#genterWrapper").$(byText(fakerUserGender)).click();                               //radio button

        $("#userNumber").setValue(randomUserPhoneNumber);                                        //text field

        $("#dateOfBirthInput").click();                                                            //calendar
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue(randomUserSubject).pressEnter();              //text field-dropdown list

        $("#hobbiesWrapper").$(byText(randomUserHobby)).click();                                   //checkbox

        $("#uploadPicture").uploadFromClasspath("images/Me.jpg");                       //file upload

        $("#currentAddress").setValue(randomUserCurrentAddress);                                  //text area

        $("#state").click();                                                     //text fields-dropdown lists
        $("#stateCity-wrapper").$(byText(randomUserState)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(randomUserCity)).click();

        $("#submit").click();                                                                        //button

        $(".modal-dialog").should(appear);                                                        //assertion

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(fakerFirstName), text(fakerLastName),
                text(fakerUserEmail), text(randomUserPhoneNumber), text(randomUserCurrentAddress));
    }
}