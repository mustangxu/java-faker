package com.github.javafaker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RandomFakerTest extends AbstractFakerTest {

    private static final int CONSTANT_SEED_VALUE = 10;
    private Random random;

    @Override
    @BeforeEach
    public void before() throws Exception {
        super.before();
        this.random = new Random();
        this.faker = new Faker(this.random);
    }

    @Test
    public void testNumerifyRandomnessCanBeControlled() {
        this.resetRandomSeed();
        final var firstInvocation = this.faker.numerify("###");

        this.resetRandomSeed();
        final var secondInvocation = this.faker.numerify("###");
        assertThat(firstInvocation, is(secondInvocation));
    }

    @Test
    public void testLetterifyRandomnessCanBeControlled() {
        this.resetRandomSeed();
        final var firstInvocation = this.faker.letterify("???");

        this.resetRandomSeed();
        final var secondInvocation = this.faker.letterify("???");
        assertThat(firstInvocation, is(secondInvocation));
    }

    @Test
    public void testNameRandomnessCanBeControlled() {
        this.resetRandomSeed();
        final var firstInvocation = this.faker.name().name();

        this.resetRandomSeed();
        final var secondInvocation = this.faker.name().name();
        assertThat(firstInvocation, is(secondInvocation));
    }

    @Test
    public void testEmailRandomnessCanBeControlled() {
        this.resetRandomSeed();
        final var firstInvocation = this.faker.internet().emailAddress();

        this.resetRandomSeed();
        final var secondInvocation = this.faker.internet().emailAddress();
        assertThat(firstInvocation, is(secondInvocation));
    }

    private void resetRandomSeed() {
        this.random.setSeed(CONSTANT_SEED_VALUE);
    }
}
