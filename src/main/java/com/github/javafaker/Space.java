package com.github.javafaker;

public class Space {

    private final Faker faker;

    protected Space(Faker faker) {
        this.faker = faker;
    }

    public String planet() {
        return this.faker.resolve("space.planet");
    }

    public String moon() {
        return this.faker.resolve("space.moon");
    }

    public String galaxy() {
        return this.faker.resolve("space.galaxy");
    }

    public String nebula() {
        return this.faker.resolve("space.nebula");
    }

    public String starCluster() {
        return this.faker.resolve("space.star_cluster");
    }

    public String constellation() {
        return this.faker.resolve("space.constellation");
    }

    public String star() {
        return this.faker.resolve("space.star");
    }

    public String agency() {
        return this.faker.resolve("space.agency");
    }

    public String agencyAbbreviation() {
        return this.faker.resolve("space.agency_abv");
    }

    public String nasaSpaceCraft() {
        return this.faker.resolve("space.nasa_space_craft");
    }

    public String company() {
        return this.faker.resolve("space.company");
    }

    public String distanceMeasurement() {
        return this.faker.number().numberBetween(10, 100) + ' ' + this.faker.resolve("space.distance_measurement");
    }

    public String meteorite() {
        return this.faker.resolve("space.meteorite");
    }
}
