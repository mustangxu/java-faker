package com.github.javafaker;

import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static org.hamcrest.MatcherAssert.assertThat;

public class MedicalTest extends AbstractFakerTest {

    @Test
    public void testMedicineName() {
        assertThat(this.faker.medical().medicineName(), isStringWithContents());
    }

    @Test
    public void testDiseaseName() {
        assertThat(this.faker.medical().diseaseName(), isStringWithContents());
    }

    @Test
    public void testHospitalName() {
        assertThat(this.faker.medical().hospitalName(), isStringWithContents());
    }

    @Test
    public void testSymptom() {
        assertThat(this.faker.medical().symptoms(), isStringWithContents());
    }


}