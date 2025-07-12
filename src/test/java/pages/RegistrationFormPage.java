package pages;

import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static data.TestData.endPoint;
import static data.TestData.firstName;

public class RegistrationFormPage extends TestBase {

    public RegistrationFormPage openRegistrationFormPage() {                                          //открыть страницу
        open(endPoint);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName() {                                                         //заполнить имя
        $("#firstName").setValue(firstName);
        return this;
    }


}