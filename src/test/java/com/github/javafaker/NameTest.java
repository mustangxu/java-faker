package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Test;

import com.github.javafaker.repeating.Repeat;


public class NameTest  extends AbstractFakerTest{

    @Test
    public void testName() {
        assertThat(this.faker.name().name(), matchesRegularExpression("([\\w']+\\.?( )?){2,3}"));
    }

    @Test
    public void testNameWithMiddle() {
        assertThat(this.faker.name().nameWithMiddle(), matchesRegularExpression("([\\w']+\\.?( )?){3,4}"));
    }

    @Test @Repeat(times = 10)
    public void testNameWithMiddleDoesNotHaveRepeatedName() {
        var nameWithMiddle = this.faker.name().nameWithMiddle();
        var splitNames = nameWithMiddle.split(" ");
        var firstName = splitNames[0];
        var middleName = splitNames[1];
        assertThat(firstName, not(equalTo(middleName)));
    }

    @Test
    public void testFullName() {
        assertThat(this.faker.name().fullName(), matchesRegularExpression("([\\w']+\\.?( )?){2,4}"));
    }

    @Test
    public void testFirstName() {
        assertThat(this.faker.name().firstName(), matchesRegularExpression("\\w+"));
    }

    @Test
    public void testLastName() {
        assertThat(this.faker.name().lastName(), matchesRegularExpression("[A-Za-z']+"));
    }

    @Test
    public void testPrefix() {
        assertThat(this.faker.name().prefix(), matchesRegularExpression("\\w+\\.?"));
    }

    @Test
    public void testSuffix() {
        assertThat(this.faker.name().suffix(), matchesRegularExpression("\\w+\\.?"));
    }

    @Test
    public void testTitle() {
        assertThat(this.faker.name().title(), matchesRegularExpression("(\\w+\\.?( )?){3}"));
    }

    @Test
    public void testUsername() {
        assertThat(this.faker.name().username(), matchesRegularExpression("^(\\w+)\\.(\\w+)$"));
    }

    @Test
    public void testUsernameWithSpaces() {
        final var name = spy(new Name(this.faker));
        doReturn("Compound Name").when(name).firstName();
        doReturn(name).when(this.faker).name();
        assertThat(this.faker.name().username(), matchesRegularExpression("^(\\w+)\\.(\\w+)$"));
    }

    @Test
    public void testBloodGroup() {
        assertThat(this.faker.name().bloodGroup(), matchesRegularExpression("(A|B|AB|O)[+-]"));
    }

}
