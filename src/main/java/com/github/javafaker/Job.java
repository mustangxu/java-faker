package com.github.javafaker;

public class Job {

    private final Faker faker;

    public Job(final Faker faker) {
        this.faker = faker;
    }

    public String field() {
        return this.faker.fakeValuesService().resolve("job.field", this, this.faker);
    }

    public String seniority() {
        return this.faker.fakeValuesService().resolve("job.seniority", this, this.faker);
    }

    public String position() {
        return this.faker.fakeValuesService().resolve("job.position", this, this.faker);
    }

    public String keySkills() {
        return this.faker.fakeValuesService().resolve("job.key_skills", this, this.faker);
    }

    public String title() {
        return this.faker.fakeValuesService().resolve("job.title", this, this.faker);
    }
}
