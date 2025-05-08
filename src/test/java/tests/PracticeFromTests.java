package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeFromTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest () {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Doe");
        $("#userEmail").setValue("johndoe6659@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89841658948");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--004").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Me.JPG");
        $("#currentAddress").setValue("Pnz");
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("John Doe"));
        $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("johndoe6659@mail.com"));
        $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Male"));
        $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("89841658948"));
        $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("04 <May>,1986"));
        $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("Maths"));
        $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Reading"));
        $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("Me.png"));
        $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("Pnz"));
        $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("Haryana Kamal"));
    }
}


