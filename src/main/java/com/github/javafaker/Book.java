package com.github.javafaker;

public class Book {
    private final Faker faker;

    protected Book(Faker faker) {
        this.faker = faker;
    }

    public String author() {
        return this.faker.fakeValuesService().resolve("book.author", this, this.faker);
    }

    public String title() {
        return this.faker.fakeValuesService().resolve("book.title", this, this.faker);
    }

    public String publisher() {
        return this.faker.fakeValuesService().resolve("book.publisher", this, this.faker);
    }

    public String genre() {
        return this.faker.fakeValuesService().resolve("book.genre", this, this.faker);
    }
}
