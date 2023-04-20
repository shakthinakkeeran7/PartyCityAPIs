package utils;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

public class TestDataGenerator {

    private static Faker faker = new Faker();

    public static JsonObject generateEmployeePayload() {
        JsonObject payload = new JsonObject();
        payload.addProperty("name", faker.name().fullName());
        payload.addProperty("email", faker.internet().emailAddress());
        payload.addProperty("phone", faker.phoneNumber().cellPhone());
        payload.addProperty("address", faker.address().fullAddress());
        return payload;
    }

    public static JsonObject generateEmployeeUpdatePayload() {
        JsonObject payload = new JsonObject();
        payload.addProperty("email", faker.internet().emailAddress());
        payload.addProperty("phone", faker.phoneNumber().cellPhone());
        payload.addProperty("address", faker.address().fullAddress());
        return payload;
    }

    public static String generateEmployeeName() {
        return faker.name().fullName();
    }

    public static String generateEmployeeEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateEmployeePhoneNumber() {
        return faker.phoneNumber().cellPhone();
    }

    public static String generateEmployeeAddress() {
        return faker.address().fullAddress();
    }
}
