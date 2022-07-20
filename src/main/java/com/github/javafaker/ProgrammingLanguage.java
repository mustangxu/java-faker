package com.github.javafaker;

public class ProgrammingLanguage {

    private final Faker faker;

    public ProgrammingLanguage(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("programming_language.name", this, this.faker);
    }

    public String creator() {
        return this.faker.fakeValuesService().resolve("programming_language.creator", this, this.faker);
    }

}
