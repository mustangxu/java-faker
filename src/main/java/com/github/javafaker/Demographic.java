package com.github.javafaker;

public class Demographic {

    private final Faker faker;

    protected Demographic(Faker faker) {
        this.faker = faker;
    }

    public String race() {
        return this.faker.fakeValuesService().fetchString("demographic.race");
    }

    public String educationalAttainment() {
        return this.faker.fakeValuesService().fetchString("demographic.educational_attainment");
    }

    public String demonym() {
        return this.faker.fakeValuesService().fetchString("demographic.demonym");
    }

    public String sex() {
        return this.faker.fakeValuesService().fetchString("demographic.sex");
    }

    public String maritalStatus() {
        return this.faker.fakeValuesService().fetchString("demographic.marital_status");
    }
}
