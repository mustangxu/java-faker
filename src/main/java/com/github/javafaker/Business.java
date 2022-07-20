package com.github.javafaker;

public class Business {
    
    private final Faker faker;

    protected Business(Faker faker) {
        this.faker = faker;
    }

    public String creditCardNumber() {
        return this.faker.fakeValuesService().resolve("business.credit_card_numbers", this, this.faker);
    }

    public String creditCardType() {
        return this.faker.fakeValuesService().resolve("business.credit_card_types", this, this.faker);
    }

    public String creditCardExpiry() {
        return this.faker.fakeValuesService().resolve("business.credit_card_expiry_dates", this, this.faker);
    }
}
