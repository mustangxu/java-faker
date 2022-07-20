package com.github.javafaker;

public class Educator {
    private final Faker faker;

    protected Educator(Faker faker) {
        this.faker = faker;
    }

    // TODO - move these all out to en.yml by default. 
    public String university() {
        return this.faker.fakeValuesService().resolve("educator.name", this, this.faker) 
                + " " 
                + this.faker.fakeValuesService().resolve("educator.tertiary.type", this, this.faker);
    }

    public String course() {
        return this.faker.fakeValuesService().resolve("educator.tertiary.degree.type", this, this.faker)
                + " "
                + this.faker.fakeValuesService().resolve("educator.tertiary.degree.subject", this, this.faker);
    }

    public String secondarySchool() {
        return this.faker.fakeValuesService().resolve("educator.name", this, this.faker)
                + " "
                + this.faker.fakeValuesService().resolve("educator.secondary", this, this.faker);
    }

    public String campus() {
        return this.faker.fakeValuesService().resolve("educator.name", this, this.faker) + " Campus";
    }

}
