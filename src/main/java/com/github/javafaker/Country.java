package com.github.javafaker;

public class Country {
    private final Faker faker;
    private final String flagUrl;

    protected Country(Faker faker) {
        this.faker = faker;
        this.flagUrl = "http://flags.fmcdn.net/data/flags/w580/";
    }

    public String flag() {
        return this.flagUrl + this.faker.fakeValuesService().resolve("country.code2", this, this.faker) + ".png";
    }

    public String countryCode2() {
        return this.faker.fakeValuesService().resolve("country.code2", this, this.faker);
    }

    public String countryCode3() {
        return this.faker.fakeValuesService().resolve("country.code3", this, this.faker);
    }

    public String capital() {
        return this.faker.fakeValuesService().resolve("country.capital", this, this.faker);
    }

    public String currency() {
        return this.faker.fakeValuesService().resolve("country.currency", this, this.faker);
    }

    public String currencyCode() {
        return this.faker.fakeValuesService().resolve("country.currency_code", this, this.faker);
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("country.name", this, this.faker);
    }

}
