package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class SipTest extends AbstractFakerTest {

    @Test
    public void method_returnUpperCaseWithMinimum3Chars() {
        assertThat(this.faker.sip().method(), matchesRegularExpression("^[A-Z]{3,}$"));
    }

    @Test
    public void contentType_returnLowerCaseTwoWordsSepereatedBySlashMinimum3And4Chars() {
        assertThat(this.faker.sip().contentType(), matchesRegularExpression("^[a-z]{4,}[/]{1,}[a-z0-9-]{3,}$"));
    }

    @Test
    public void messagingPort_return4DigitIntBetween1000And9999() {
        assertThat(this.faker.sip().messagingPort(), both(greaterThanOrEqualTo(1000)).and(lessThan(10000)));
    }

    @Test
    public void rtpPort_returnPositiveEvenInt() {
        var sut = this.faker.sip().rtpPort();
        assertThat(sut, greaterThanOrEqualTo(2));
        assertThat(sut % 2, is(0));
    }

    @Test
    public void provisionalResponseCode_return3DigitIntBetween100And199() {
        assertThat(this.faker.sip().provisionalResponseCode(), both(greaterThanOrEqualTo(100)).and(lessThan(200)));
    }

    @Test
    public void successResponse_Codereturn3DigitIntBetween200And299() {
        assertThat(this.faker.sip().successResponseCode(), both(greaterThanOrEqualTo(200)).and(lessThan(300)));
    }

    @Test
    public void redirectResponseCode_Codereturn3DigitIntBetween300And399() {
        assertThat(this.faker.sip().redirectResponseCode(), both(greaterThanOrEqualTo(300)).and(lessThan(400)));
    }

    @Test
    public void clientErrorResponseCode_Codereturn3DigitIntBetween400And499() {
        assertThat(this.faker.sip().clientErrorResponseCode(), both(greaterThanOrEqualTo(400)).and(lessThan(500)));
    }

    @Test
    public void serverErrorResponseCode_Codereturn3DigitIntBetween500And599() {
        assertThat(this.faker.sip().serverErrorResponseCode(), both(greaterThanOrEqualTo(500)).and(lessThan(600)));
    }

    @Test
    public void globalErrorResponseCode_Codereturn3DigitIntBetween600And699() {
        assertThat(this.faker.sip().globalErrorResponseCode(), both(greaterThanOrEqualTo(600)).and(lessThan(700)));
    }

    @Test
    public void provisionalResponsePhrase_returnAnyNonDigitString() {
        assertThat(this.faker.sip().provisionalResponsePhrase(), matchesRegularExpression("\\D+"));
    }

    @Test
    public void successResponsePhrase_returnAnyNonDigitString() {
        assertThat(this.faker.sip().successResponsePhrase(), matchesRegularExpression("\\D+"));
    }

    @Test
    public void redirectResponsePhrase_returnAnyNonDigitString() {
        assertThat(this.faker.sip().redirectResponsePhrase(), matchesRegularExpression("\\D+"));
    }

    @Test
    public void clientErrorResponsePhrase_returnAnyNonDigitString() {
        assertThat(this.faker.sip().clientErrorResponsePhrase(), matchesRegularExpression("\\D+"));
    }

    @Test
    public void serverErrorResponsePhrase_returnAnyNonDigitString() {
        assertThat(this.faker.sip().serverErrorResponsePhrase(), matchesRegularExpression("\\D+"));
    }

    @Test
    public void globalErrorResponsePhrase_returnAnyNonDigitString() {
        assertThat(this.faker.sip().globalErrorResponsePhrase(), matchesRegularExpression("\\D+"));
    }

    @Test
    public void bodyString_returnAValidSdpBodyString() {
        var sut = this.faker.sip().bodyString().split("\n");

        assertThat(sut.length, is(7));

        assertThat(sut[0], is("v=0"));

        var secondLine = sut[1].split(" ");
        assertThat(secondLine[0], startsWith("o="));
        assertThat(secondLine[1], matchesRegularExpression("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$"));
        assertThat(secondLine[secondLine.length - 1], matchesRegularExpression("[a-z]+\\.\\w{2,4}"));

        assertThat(sut[2], is("s=-"));

        var fourthLine = sut[3].split(" ");
        assertThat(fourthLine[0], is("c=IN"));
        assertThat(fourthLine[fourthLine.length - 1], matchesRegularExpression("^\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}$"));

        assertThat(sut[4], is("t=0 0"));

        var sixthLine = sut[5].split(" ");
        assertThat(sixthLine[0], is("m=audio"));
        assertThat(Integer.parseInt(sixthLine[1]), greaterThanOrEqualTo(2));
        assertThat(Integer.parseInt(sixthLine[1]) % 2, is(0));

        assertThat(sut[6], is("a=rtpmap:0 PCMU/8000"));
    }

    @Test
    public void bodyBytes_isNotNull() {
        var sut = this.faker.sip().bodyBytes();

        assertThat(sut.length, notNullValue());
    }

    @Test
    public void nameAddress_returnValidNameAddressString() {
        var sut = this.faker.sip().nameAddress().split("@");

        assertThat(sut[0].split(":")[1], matchesRegularExpression("\\w+"));
        assertThat(sut[1].split(":")[0], matchesRegularExpression("^\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}$"));
    }
}
