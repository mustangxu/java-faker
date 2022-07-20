package com.github.javafaker;

public class Food {

    private final Faker faker;

    protected Food(Faker faker) {
        this.faker = faker;
    }

    public String ingredient() {
        return this.faker.fakeValuesService().resolve("food.ingredients", this, this.faker);
    }

    public String spice() {
        return this.faker.fakeValuesService().resolve("food.spices", this, this.faker);
    }

    public String dish() {
        return this.faker.fakeValuesService().resolve("food.dish", this, this.faker);
    }

    public String fruit() {
        return this.faker.fakeValuesService().resolve("food.fruits", this, this.faker);
    }

    public String vegetable() {
        return this.faker.fakeValuesService().resolve("food.vegetables", this, this.faker);
    }

    public String sushi() {
        return this.faker.fakeValuesService().resolve("food.sushi", this, this.faker);
    }

    public String measurement() {
        return this.faker.fakeValuesService().resolve("food.measurement_sizes", this, this.faker) +
                " " + this.faker.fakeValuesService().resolve("food.measurements", this, this.faker);
    }
}
