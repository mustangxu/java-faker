package com.github.javafaker;

public class Witcher {
    private final Faker faker;
    
    protected Witcher(Faker faker) {
        this.faker = faker;
    }
    
    public String character() {
        return this.faker.fakeValuesService().resolve("games.witcher.characters", this, this.faker);
    }
    
    public String witcher() {
        return this.faker.fakeValuesService().resolve("games.witcher.witchers", this, this.faker);
    }
    
    public String school() {
        return this.faker.fakeValuesService().resolve("games.witcher.schools", this, this.faker);
    }
    
    public String location() {
        return this.faker.fakeValuesService().resolve("games.witcher.locations", this, this.faker);
    }
    
    public String quote() {
        return this.faker.fakeValuesService().resolve("games.witcher.quotes", this, this.faker);
    }
    
    public String monster() {
        return this.faker.fakeValuesService().resolve("games.witcher.monsters", this, this.faker);
    }
}
