package com.github.javafaker;

public class Dog {

    private final Faker faker;

    protected Dog(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("creature.dog.name", this, this.faker);
    }

    public String breed() {
        return this.faker.fakeValuesService().resolve("creature.dog.breed", this, this.faker);
    }

    public String sound() {
        return this.faker.fakeValuesService().resolve("creature.dog.sound", this, this.faker);
    }

    public String memePhrase() {
        return this.faker.fakeValuesService().resolve("creature.dog.meme_phrase", this, this.faker);
    }

    public String age() {
        return this.faker.fakeValuesService().resolve("creature.dog.age", this, this.faker);
    }

    public String coatLength() {
        return this.faker.fakeValuesService().resolve("creature.dog.coat_length", this, this.faker);
    }

    public String gender() {
        return this.faker.fakeValuesService().resolve("creature.dog.gender", this, this.faker);
    }

    public String size() {
        return this.faker.fakeValuesService().resolve("creature.dog.size", this, this.faker);
    }
}
