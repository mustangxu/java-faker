package com.github.javafaker;

public class SlackEmoji {

    private final Faker faker;

    protected SlackEmoji(Faker faker) {
        this.faker = faker;
    }

    public String people() {
        return this.faker.resolve("slack_emoji.people");
    }

    public String nature() {
        return this.faker.resolve("slack_emoji.nature");
    }

    public String foodAndDrink() {
        return this.faker.resolve("slack_emoji.food_and_drink");
    }

    public String celebration() {
        return this.faker.resolve("slack_emoji.celebration");
    }

    public String activity() {
        return this.faker.resolve("slack_emoji.activity");
    }

    public String travelAndPlaces() {
        return this.faker.resolve("slack_emoji.travel_and_places");
    }

    public String objectsAndSymbols() {
        return this.faker.resolve("slack_emoji.objects_and_symbols");
    }

    public String custom() {
        return this.faker.resolve("slack_emoji.custom");
    }

    public String emoji() {
        return this.faker.fakeValuesService().resolve("slack_emoji.emoji", this, this.faker);
    }
}
