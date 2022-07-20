package com.github.javafaker;

/**
 * Generate random, different kinds of disease.
 */
public class Disease {
    private final Faker faker;

    /**
     * Create a constructor for Disease
     * @param faker The Faker instance for generating random, different kinds of disease, e.g. the internal disease.
     */
    protected Disease(Faker faker) {
        this.faker = faker;
    }

    /**
     * Generate random internal disease
     * @return An internal disease
     */
    public String internalDisease() {
        return this.faker.fakeValuesService().resolve("disease.internal_disease", this, this.faker);
    }

    /**
     * Generate random neurology disease
     * @return A neurology disease
     */
    public String neurology() {
        return this.faker.fakeValuesService().resolve("disease.neurology", this, this.faker);
    }

    /**
     * Generate random surgery disease
     * @return A surgery disease
     */
    public String surgery() {
        return this.faker.fakeValuesService().resolve("disease.surgery", this, this.faker);
    }

    /**
     * Generate random paediattics disease
     * @return A paediatrics disease
     */
    public String paediatrics() {
        return this.faker.fakeValuesService().resolve("disease.paediatrics", this, this.faker);
    }

    /**
     * Generate random gynecology and obstetrics disease
     * @return A gynecology and obstetrics disease
     */
    public String gynecologyAndObstetrics() {
        return this.faker.fakeValuesService().resolve("disease.gynecology_and_obstetrics", this, this.faker);
    }

    /**
     * Generate random ophthalmology and otorhinolaryngology disease
     * @return A ophthalmology and otorhinolaryngology disease
     */
    public String ophthalmologyAndOtorhinolaryngology() {
        return this.faker.fakeValuesService().resolve("disease.ophthalmology_and_otorhinolaryngology", this, this.faker);
    }

    /**
     * Generate random dermatolory disease
     * @return A dermatolory disease
     */
    public String dermatolory() {
        return this.faker.fakeValuesService().resolve("disease.dermatolory", this, this.faker);
    }

}
