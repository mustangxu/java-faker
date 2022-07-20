package com.github.javafaker;

public class App {
    private final Faker faker;

    protected App(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("app.name", this, this.faker);
    }

    public String version() {
        return this.faker.numerify(this.faker.fakeValuesService().resolve("app.version", this, this.faker));
    }

    public String author() {
        return this.faker.fakeValuesService().resolve("app.author", this, this.faker);
    }
}
