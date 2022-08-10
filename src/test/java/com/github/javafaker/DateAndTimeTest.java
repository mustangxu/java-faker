/**
 *
 */
package com.github.javafaker;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

/**
 * @author pmiklos
 */
public class DateAndTimeTest extends AbstractFakerTest {

    @Test
    public void testFutureDate() {
        var now = new Date();

        for (var i = 0; i < 1000; i++) {
            var future = this.faker.date().future(1, TimeUnit.SECONDS, now);
            assertThat("past date", future.getTime(), greaterThan(now.getTime()));
            assertThat("future date over range", future.getTime(), lessThan(now.getTime() + 1000));
        }
    }

    @Test
    public void testFutureDateWithMinimum(){
        for (var i = 0; i < 1000; i++) {
            var now = new Date();
            var future = this.faker.date().future(5, 4, TimeUnit.SECONDS);
            assertThat("past date", future.getTime(), greaterThan(now.getTime()));
            assertThat("future date over range", future.getTime(), lessThan(now.getTime() + 5001));
            assertThat("future date under minimum range", future.getTime(), greaterThan(now.getTime() + 3999));
        }
    }

    @Test
    public void testPastDateWithMinimum(){
        for (var i = 0; i < 1000; i++) {
            var now = new Date();
            var past = this.faker.date().past(5, 4, TimeUnit.SECONDS);
            assertThat("future date", past.getTime(), lessThan(now.getTime()));
            assertThat("past date over range", past.getTime(), greaterThan(now.getTime() - 5001));
            assertThat("past date under minimum range", past.getTime(), lessThan(now.getTime() - 3999));
        }
    }

    @Test
    public void testPastDateWithReferenceDate() {
        var now = new Date();

        for (var i = 0; i < 1000; i++) {
            var past = this.faker.date().past(1, TimeUnit.SECONDS, now);
            assertThat("past date", past.getTime(), lessThan(now.getTime()));
            assertThat("past date over range", past.getTime(), greaterThan(now.getTime() - 1000));
        }
    }

    @Test
    public void testPastDate() {
        var now = new Date();
        var past = this.faker.date().past(100, TimeUnit.SECONDS);
        assertThat("past date is in the past", past.getTime(), lessThan(now.getTime()));
    }

    @Test
    public void testBetween() {
        var now = new Date();
        var then = new Date(now.getTime() + 1000);

        for (var i = 0; i < 1000; i++) {
            var date = this.faker.date().between(now, then);
            assertThat("after upper bound", date.getTime(), lessThan(then.getTime()));
            assertThat("before lower bound", date.getTime(), greaterThanOrEqualTo(now.getTime()));
        }
    }
    @Test
    public void testBetweenThenLargerThanNow(){
        try{
            var now = new Date();
            var then = new Date(now.getTime() + 1000);
            this.faker.date().between(then, now);
            fail("Should be exception");}catch (IllegalArgumentException e){
                assertEquals("Invalid date range, the upper bound date is before the lower bound.", e.getMessage());
            }
    }
    @Test
    public void testBirthday() {
        var currentYear = Calendar.getInstance().get(Calendar.YEAR);
        var currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        var currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        var from = new GregorianCalendar(currentYear - 65, currentMonth, currentDay).getTime().getTime();
        var to = new GregorianCalendar(currentYear - 18, currentMonth, currentDay).getTime().getTime();

        for (var i = 0; i < 5000; i++) {
            var birthday = this.faker.date().birthday();
            assertThat("birthday is after upper bound", birthday.getTime(), lessThan(to));
            assertThat("birthday is before lower bound", birthday.getTime(), greaterThanOrEqualTo(from));
        }
    }

    @Test
    public void testBirthdayWithAges() {
        var currentYear = Calendar.getInstance().get(Calendar.YEAR);
        var currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        var currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        for (var i = 0; i < 5000; i++) {
            var minAge = this.faker.number().numberBetween(1, 99);
            var maxAge = this.faker.number().numberBetween(minAge, 100);

            var from = new GregorianCalendar(currentYear - maxAge, currentMonth, currentDay).getTime().getTime();
            var to = new GregorianCalendar(currentYear - minAge, currentMonth, currentDay).getTime().getTime();

            var birthday = this.faker.date().birthday(minAge, maxAge);
            assertThat("birthday is after upper bound", birthday.getTime(), lessThanOrEqualTo(to));
            assertThat("birthday is before lower bound", birthday.getTime(), greaterThanOrEqualTo(from));
        }
    }

}
