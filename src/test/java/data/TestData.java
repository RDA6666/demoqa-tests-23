package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    public static String
            firstName = "Dmitry",
            lastName = "Ryzhov",
            userEmail = "dmitryryzhov@mail.com",
            userPhoneNumber = "1234567890",
            userCurrentAddress = "Penza";

    static Faker faker = new Faker(new Locale("en-US"));                             //random test data generation
    public static String
            randomFirstName = faker.name().firstName(),
            randomLastName = faker.name().lastName(),
            randomUserEmail = faker.internet().emailAddress(),
            randomUserPhoneNumber = faker.phoneNumber().subscriberNumber(10),
            randomUserCurrentAddress = faker.address().fullAddress();
}
