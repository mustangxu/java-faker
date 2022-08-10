package com.github.javafaker;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class BojackHorsemanTest extends AbstractFakerTest {

    @Test
    public void testCharacters1(){
        this.faker = new Faker();
        assertThat(this.faker.bojackHorseman().characters(),matchesRegularExpression("[\\p{L}'()\\., 0-9-’’]+")); }

    @Test
    public void testQuotes1(){
        this.faker = new Faker();
        assertFalse(this.faker.bojackHorseman().quotes().isEmpty()); }

    @Test
    public void testTongueTwisters1(){
        this.faker = new Faker();
        assertFalse(this.faker.bojackHorseman().tongueTwisters().isEmpty());}

    @Test
    public void testCharactersWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.bojackHorseman().characters();
            if("Joseph Sugarman".equals(generateString)){isExist=true;}
        }
        assertTrue(isExist);
    }

    @Test
    public void testQuotesWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.bojackHorseman().quotes();
            if("It gets easier. But you have to do it every day, that's the hard part. But it does get easier".equals(generateString))
            {isExist=true;}
        }
        assertTrue(isExist);
    }

    @Test
    public void testTongueTwistersWith10000Times(){
        this.faker = new Faker();
        var isExist=false;
        for(var i=0;i<10000;i++){
            var generateString=this.faker.bojackHorseman().tongueTwisters();
            if("Courtly roles like the formerly portly consort are Courtney Portnoy's forté".equals(generateString))
            {isExist=true;}
        }
        assertTrue(isExist);
    }

}
