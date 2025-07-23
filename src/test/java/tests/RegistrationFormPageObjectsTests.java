package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectsTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @DisplayName("Позитивный тест с применением методов POM")
    @Test
    void fullRegistrationFormTest() {
        registrationFormPage.openRegistrationFormPage()
                .setFirstName()
                .setLastName()
                .setEmail();
    }
}
