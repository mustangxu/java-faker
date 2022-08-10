package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class BasketballTest extends AbstractFakerTest {

    @Test
    public void testPositions(){
        this.faker = new Faker();
        assertThat(this.faker.basketball().positions(),matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+")); }

    @Test
    public void testTeams(){
        this.faker = new Faker();
        assertThat(this.faker.basketball().teams(),matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+")); }

    @Test
    public void testCoaches(){
        this.faker = new Faker();
        assertThat(this.faker.basketball().coaches(),matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+")); }

    @Test
    public void testPlayers(){
        this.faker = new Faker();
        assertThat(this.faker.basketball().players(),matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+")); }

    @Test
    public void testPositionsWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.basketball().positions();
            if("Point Guard".equals(generateString)){isExist=true;}
        }
        assertTrue(isExist);
    }

    @Test
    public void testTeamsWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.basketball().teams();
            if("Atlanta Hawks".equals(generateString)){isExist=true;}
        }
        assertTrue(isExist);
    }

    @Test
    public void testCoachesWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.basketball().coaches();
            if("Kenny Atkinson".equals(generateString)){isExist=true;}
        }
        assertTrue(isExist);
    }

    @Test
    public void testPlayersWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.basketball().players();
            if("Joel Embiid".equals(generateString)){isExist=true;}
        }
        assertTrue(isExist); }
}
