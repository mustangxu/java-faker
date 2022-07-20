package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class CryptoTest extends AbstractFakerTest {

    @Test
    public void testMd5() {
        assertThat(this.faker.crypto().md5(), matchesRegularExpression("[a-z\\d]+"));
    }

    @Test
    public void testSha1() {
        assertThat(this.faker.crypto().sha1(), matchesRegularExpression("[a-z\\d]+"));
    }

    @Test
    public void testSha256() {
        assertThat(this.faker.crypto().sha256(), matchesRegularExpression("[a-z\\d]+"));
    }

    @Test
    public void testSha512() {
        assertThat(this.faker.crypto().sha512(), matchesRegularExpression("[a-z\\d]+"));
    }
}
