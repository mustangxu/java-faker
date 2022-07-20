package com.github.javafaker;

public class PhoneNumber {
    private final Faker faker;

    protected PhoneNumber(Faker faker) {
        this.faker = faker;
    }

    public String cellPhone() {
        return this.faker.numerify(this.faker.fakeValuesService().resolve("cell_phone.formats", this, this.faker));
    }

    public String phoneNumber() {
        return this.faker.numerify(this.faker.fakeValuesService().resolve("phone_number.formats", this, this.faker));
    }

    public String extension() {
        return subscriberNumber();
    }

    public String subscriberNumber(int length) {
        StringBuilder subscriberNumber = new StringBuilder();
        for (int i = 0; i < length; i++) {
            subscriberNumber.append("#");
        }
        return this.faker.numerify(subscriberNumber.toString());
    }

    public String subscriberNumber() {
        return subscriberNumber(4);
    }
}
