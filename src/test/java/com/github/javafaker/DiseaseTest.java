package com.github.javafaker;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.javafaker.repeating.Repeat;

public class DiseaseTest extends AbstractFakerTest {
    @Test
    public void testInternalDisease() {
        this.faker = new Faker();
        assertThat(this.faker.disease().internalDisease(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testNeurology() {
        this.faker = new Faker();
        assertThat(this.faker.disease().neurology(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testSurgery() {
        this.faker = new Faker();
        assertThat(this.faker.disease().surgery(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testPaediatrics() {
        this.faker = new Faker();
        assertThat(this.faker.disease().paediatrics(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testGynecologyAndObstetrics() {
        this.faker = new Faker();
        assertThat(this.faker.disease().gynecologyAndObstetrics(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testOphthalmologyAndOtorhinolaryngology() {
        this.faker = new Faker();
        assertThat(this.faker.disease().ophthalmologyAndOtorhinolaryngology(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }

    @Test
    public void testDermatolory() {
        this.faker = new Faker();
        assertThat(this.faker.disease().dermatolory(), matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+"));
    }


    @Test
    public void testInternalDiseaseWith10000Times() {
        this.faker = new Faker();
        var isExist = false;
        for (var i = 0; i < 10000; i++) {
            var generateString = this.faker.disease().internalDisease();
            if ("anaphylaxis".equals(generateString)) {
                isExist = true;
            }
        }
        assertTrue(isExist);
    }

    @Test
    @Repeat(times = 10000)
    public void testNeurologyWith10000Times() {
        this.faker = new Faker();
        assertThat(this.faker.disease().neurology(), isStringWithContents());
    }

    @Test
    @Repeat(times = 10000)
    public void testSurgeryWith10000Times() {
        this.faker = new Faker();
        assertThat(this.faker.disease().surgery(), isStringWithContents());
    }

    @Test
    @Repeat(times = 10000)
    public void testPaediatricsWith10000Times() {
        this.faker = new Faker();
        assertThat(this.faker.disease().paediatrics(), isStringWithContents());
    }

    @Test
    @Repeat(times = 10000)
    public void testGynecologyAndObstetricsWith10000Times() {
        this.faker = new Faker();
        assertThat(this.faker.disease().gynecologyAndObstetrics(), isStringWithContents());
    }

    @Test
    @Repeat(times = 10000)
    public void testOphthalmologyAndOtorhinolaryngologyWith10000Times() {
        this.faker = new Faker();
        assertThat(this.faker.disease().ophthalmologyAndOtorhinolaryngology(), isStringWithContents());
    }

    @Test
    @Repeat(times = 10000)
    public void testDermatoloryWith10000Times() {
        this.faker = new Faker();
        assertThat(this.faker.disease().dermatolory(), isStringWithContents());
    }

}
