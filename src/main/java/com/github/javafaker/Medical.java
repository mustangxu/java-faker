package com.github.javafaker;

public class Medical {

    private final Faker faker;

    protected Medical(Faker faker) {
        this.faker = faker;
    }

    public String medicineName() {
        return this.faker.fakeValuesService().resolve("medical.medicine_name", this, this.faker);
    }

    public String diseaseName() {
        return this.faker.fakeValuesService().resolve("medical.disease_name", this, this.faker);
    }

    public String hospitalName() {
        return this.faker.fakeValuesService().resolve("medical.hospital_name", this, this.faker);
    }

    public String symptoms() {
        return this.faker.fakeValuesService().resolve("medical.symptoms", this, this.faker);
    }
}
