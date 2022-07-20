package com.github.javafaker;

public class Address {
    private final Faker faker;

    protected Address(Faker faker) {
        this.faker = faker;
    }

    public String streetName() {
        return this.faker.fakeValuesService().resolve("address.street_name", this, this.faker);
    }

    public String streetAddressNumber() {
        return String.valueOf(this.faker.random().nextInt(1000));
    }

    public String streetAddress() {
        return this.faker.fakeValuesService().resolve("address.street_address", this, this.faker);
    }

    public String streetAddress(boolean includeSecondary) {
        var streetAddress = new StringBuilder().append(this.faker.fakeValuesService().resolve("address.street_address", this, this.faker));
        if (includeSecondary) {
            streetAddress.append(" ").append(this.secondaryAddress());
        }
        return streetAddress.toString();
    }

    public String secondaryAddress() {
        return this.faker.numerify(this.faker.fakeValuesService().resolve("address.secondary_address", this,this.faker));
    }

    public String zipCode() {
        return this.faker.bothify(this.faker.fakeValuesService().resolve("address.postcode", this,this.faker));
    }

    public String postcode() {
        return this.faker.bothify(this.faker.fakeValuesService().resolve("address.postcode", this,this.faker));
    }

    public String zipCodeByState(String stateAbbr) {
        return this.faker.fakeValuesService().resolve("address.postcode_by_state." + stateAbbr, this, this.faker);
    }

    public String countyByZipCode(String postCode) {
        return this.faker.fakeValuesService().resolve("address.county_by_postcode." + postCode, this, this.faker);
    }

    public String streetSuffix() {
        return this.faker.fakeValuesService().resolve("address.street_suffix", this, this.faker);
    }

    public String streetPrefix() {
        return this.faker.fakeValuesService().resolve("address.street_prefix", this, this.faker);
    }

    public String citySuffix() {
        return this.faker.fakeValuesService().resolve("address.city_suffix", this, this.faker);
    }

    public String cityPrefix() {
        return this.faker.fakeValuesService().resolve("address.city_prefix", this, this.faker);
    }

    public String city() {
        return this.faker.fakeValuesService().resolve("address.city", this, this.faker);
    }

    public String cityName() {
        return this.faker.fakeValuesService().resolve("address.city_name", this, this.faker);
    }

    public String state() {
        return this.faker.fakeValuesService().resolve("address.state", this, this.faker);
    }

    public String stateAbbr() {
        return this.faker.fakeValuesService().resolve("address.state_abbr", this, this.faker);
    }

    public String firstName() {
        return this.faker.name().firstName();
    }

    public String lastName() {
        return this.faker.name().lastName();
    }

    public String latitude() {
        return String.format("%.8g", this.faker.random().nextDouble() * 180 - 90);
    }

    public String longitude() {
        return String.format("%.8g", this.faker.random().nextDouble() * 360 - 180);
    }

    public String timeZone() {
        return this.faker.fakeValuesService().resolve("address.time_zone", this, this.faker);
    }

    public String country() {
        return this.faker.fakeValuesService().resolve("address.country", this, this.faker);
    }

    public String countryCode() {
        return this.faker.fakeValuesService().resolve("address.country_code", this, this.faker);
    }

    public String buildingNumber() {
        return this.faker.numerify(this.faker.fakeValuesService().resolve("address.building_number", this, this.faker));
    }

    public String fullAddress() {
        return this.faker.fakeValuesService().resolve("address.full_address", this, this.faker);
    }
}
