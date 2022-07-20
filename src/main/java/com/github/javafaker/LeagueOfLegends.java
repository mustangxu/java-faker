package com.github.javafaker;

public class LeagueOfLegends {
    private final Faker faker;

    protected LeagueOfLegends(Faker faker) {
        this.faker = faker;
    }

    public String champion() {
        return this.faker.fakeValuesService().resolve("games.league_of_legends.champion", this, this.faker);
    }

    public String location() {
        return this.faker.fakeValuesService().resolve("games.league_of_legends.location", this, this.faker);
    }

    public String quote() {
        return this.faker.fakeValuesService().resolve("games.league_of_legends.quote", this, this.faker);
    }

    public String summonerSpell() {
        return this.faker.fakeValuesService().resolve("games.league_of_legends.summoner_spell", this, this.faker);
    }

    public String masteries() {
        return this.faker.fakeValuesService().resolve("games.league_of_legends.masteries", this, this.faker);
    }

    public String rank() {
        return this.faker.fakeValuesService().resolve("games.league_of_legends.rank", this, this.faker);
    }
}
