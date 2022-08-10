package com.github.javafaker.integration;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.util.ReflectionUtilsPredicates.withModifier;
import static org.reflections.util.ReflectionUtilsPredicates.withParametersCount;
import static org.reflections.util.ReflectionUtilsPredicates.withReturnType;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import com.google.common.collect.Maps;

/**
 * The purpose of these tests is to ensure that the Locales have been properly configured
 * and that methods return values. The unit tests should ensure what the values returned
 * are correct. These tests just ensure that the methods can be invoked.
 */
@RunWith(value = Parameterized.class)
public class FakerIT {

    private static final Logger logger = LoggerFactory.getLogger(FakerIT.class);
    private final Locale locale;
    private final Faker faker;

    /**
     * a collection of Locales -> Exceptions.
     * In the case of 'pt', city_prefix is '' by design. This test fails because it's testing that all string returning
     * methods return a non blank string. But pt city_prefix is blank ,but the test shouldn't fail. So we add put
     * exceptions like this into this collection.
     */
    private static final Map<Locale, List<String>> exceptions = Maps.newHashMap();
    static {
        // 'it' has an empty suffix list so it never returns a value
        exceptions.put(new Locale("it"), Arrays.asList("Name.suffix"));
        exceptions.put(new Locale("es-mx"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("pt"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("uk"), Arrays.asList("Address.stateAbbr", "Address.streetSuffix",
            "Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("pt-BR"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("pt-br"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("Pt_br"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("pT_Br"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
        exceptions.put(new Locale("pt","Br", "x2"), Arrays.asList("Address.cityPrefix", "Address.citySuffix"));
    }

    public FakerIT(Locale locale, Random random) {
        this.locale = locale;
        if (locale != null && random != null) {
            this.faker = new Faker(locale, random);
        } else if (locale != null) {
            this.faker = new Faker(locale);
        } else if (random != null) {
            this.faker = new Faker(random);
        } else {
            this.faker = new Faker();
        }
    }

    @Parameterized.Parameters(name = "testing locale {0} and random {1}")
    public static Collection<Object[]> data() {
        Object[][] data = {
            {Locale.ENGLISH, new Random()},
            {new Locale("pt-BR"), null},
            {new Locale("pt-br"), null},
            {new Locale("Pt_br"), null},
            {new Locale("pT_Br"), null},
            {new Locale("pt","Br","x2"), null},
            {null, new Random()},
            {null, null}};

        var ymlFiles = new File("./src/main/resources").list();
        var numberOfYmlFiles = ymlFiles.length;
        var dataFromYmlFiles = new Object[numberOfYmlFiles][2];
        for (var i = 0; i < numberOfYmlFiles; i++) {
            var ymlFileName = ymlFiles[i];
            dataFromYmlFiles[i][0] = new Locale(StringUtils.substringBefore(ymlFileName, "."));
        }

        List<Object[]> allData = new ArrayList<>(Arrays.asList(data));
        allData.addAll(Arrays.asList(dataFromYmlFiles));
        return allData;
    }

    @Test
    public void testAllFakerMethodsThatReturnStrings() throws Exception {
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker);
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.ancient());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.address());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.app());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.artist());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.aviation());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.backToTheFuture());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.business());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.book());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.chuckNorris());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.color());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.commerce());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.company());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.country());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.crypto());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.demographic());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.dragonBall());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.dog());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.educator());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.funnyName());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.hitchhikersGuideToTheGalaxy());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.hobbit());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.howIMetYourMother());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.internet());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.leagueOfLegends());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.lorem());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.overwatch());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.phoneNumber());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.pokemon());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.robin());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.starTrek());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.music());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.name());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.file());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.finance());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.food());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.gameOfThrones());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.gender());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.hacker());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.idNumber());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.shakespeare());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.slackEmoji());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.space());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.stock());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.superhero());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.team());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.beer());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.coin());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.university());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.cat());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.lordOfTheRings());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.zelda());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.harryPotter());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.rockBand());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.esports());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.friends());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.hipster());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.job());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.twinPeaks());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.rickAndMorty());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.yoda());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.matz());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.witcher());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.weather());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.lebowski());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.animal());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.princessBride());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.elderScrolls());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.buffy());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.relationships());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.nation());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.dune());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.aquaTeenHungerForce());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.programmingLanguage());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.kaamelott());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.photography());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.starCraft());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.bojackHorseman());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.disease());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.basketball());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.barcode());
        this.testAllMethodsThatReturnStringsActuallyReturnStrings(this.faker.englandfootball());
    }

    private void testAllMethodsThatReturnStringsActuallyReturnStrings(Object object) throws Exception {
        @SuppressWarnings("unchecked")
        var methodsThatReturnStrings = getAllMethods(object.getClass(),
            withModifier(Modifier.PUBLIC),
            withReturnType(String.class),
            withParametersCount(0));

        for (Method method : methodsThatReturnStrings) {
            if (this.isExcepted(object, method)) {
                continue;
            }
            final var returnValue = method.invoke(object);
            logger.info("{} {}.{} = {}", this.locale, object.getClass().getSimpleName().toLowerCase(), method.getName(), returnValue);
            var failureReason = method + " on " + object;
            assertThat(failureReason, returnValue, is(instanceOf(String.class)));
            final var returnValueAsString = (String) returnValue;
            assertThat(failureReason, returnValueAsString, not(is(emptyOrNullString())));
            assertThat(failureReason + " is a slash encoded regex", returnValueAsString,
                not(allOf(startsWith("/"), endsWith("/"))));
        }
    }

    private boolean isExcepted(Object object, Method method) {
        final var classDotMethod = exceptions.get(this.locale);
        if (classDotMethod == null) {return false;}
        return classDotMethod.contains(object.getClass().getSimpleName() + "." + method.getName());
    }

    @Test
    public void testExceptionsNotCoveredInAboveTest() {
        assertThat(this.faker.bothify("####???"), is(notNullValue()));
        assertThat(this.faker.letterify("????"), is(notNullValue()));
        assertThat(this.faker.numerify("####"), is(notNullValue()));

        assertThat(this.faker.lorem().paragraph(1), is(notNullValue()));
        assertThat(this.faker.lorem().paragraphs(1), is(notNullValue()));

        assertThat(this.faker.lorem().sentence(1), is(notNullValue()));
        assertThat(this.faker.lorem().sentences(1), is(notNullValue()));

        assertThat(this.faker.address().streetAddress(), is(notNullValue()));

        assertThat(this.faker.lorem().words(), is(notNullValue()));
        assertThat(this.faker.lorem().words(1), is(notNullValue()));
    }

}
