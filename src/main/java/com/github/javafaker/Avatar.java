package com.github.javafaker;

public class Avatar {
    private final Faker faker;
    private final String baseUrl;

    protected Avatar(Faker faker) {
        this.faker = faker;
        this.baseUrl = "https://s3.amazonaws.com/uifaces/faces/twitter/";
    }

    public String image() {
        return this.baseUrl + this.faker.fakeValuesService().resolve("internet.avatar", this, this.faker);
    }
}
