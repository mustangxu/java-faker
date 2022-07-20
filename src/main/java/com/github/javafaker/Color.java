package com.github.javafaker;

public class Color {
    private final Faker faker;

    protected Color(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("color.name", this, this.faker);
    }

    public String hex() {
        return hex(true);
    }

    public String hex(boolean includeHashSign) {
        String hexString = this.faker.random().hex(6);
        if(includeHashSign)
            return "#" + hexString;
        return hexString;
    }
}
