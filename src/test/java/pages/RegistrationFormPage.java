package pages;

import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static data.TestData.*;

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

    public RegistrationFormPage setLastName() {                                                      //заполнить фамилию
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail() {                                                           //заполнить email
        $("#userEmail").setValue(userEmail);
        return this;
    }


}