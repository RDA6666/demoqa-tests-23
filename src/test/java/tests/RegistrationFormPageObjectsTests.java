package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

public class RegistrationFormPageObjectsTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fullRegistrationFormTest() {                                                   //тест с применением методов POM
        registrationFormPage.openRegistrationFormPage()
                .setFirstName()
                .setLastName()
                .setEmail();
    }
}
