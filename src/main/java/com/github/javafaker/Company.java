package com.github.javafaker;

import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.github.javafaker.service.FakerIDN;

public class Company {

    private final Faker faker;

    protected Company(Faker faker) {
        this.faker = faker;
    }

    public String name() {
        return this.faker.fakeValuesService().resolve("company.name", this, this.faker);
    }

    public String suffix() {
        return this.faker.fakeValuesService().resolve("company.suffix", this, this.faker);
    }

    public String industry() {
        return this.faker.fakeValuesService().resolve("company.industry", this, this.faker);
    }

    public String profession() {
        return this.faker.fakeValuesService().resolve("company.profession", this, this.faker);
    }

    public String buzzword() {
        @SuppressWarnings("unchecked")
        var buzzwordLists = (List<List<String>>) this.faker.fakeValuesService().fetchObject("company.buzzwords");
        List<String> buzzwords = new ArrayList<>();
        for (List<String> buzzwordList : buzzwordLists) {
            buzzwords.addAll(buzzwordList);
        }
        return buzzwords.get(this.faker.random().nextInt(buzzwords.size()));
    }

    /**
     * Generate a buzzword-laden catch phrase.
     */
    public String catchPhrase() {
        @SuppressWarnings("unchecked")
        var catchPhraseLists = (List<List<String>>) this.faker.fakeValuesService().fetchObject("company.buzzwords");
        return this.joinSampleOfEachList(catchPhraseLists, " ");
    }

    /**
     * When a straight answer won't do, BS to the rescue!
     */
    public String bs() {
        @SuppressWarnings("unchecked")
        var buzzwordLists = (List<List<String>>) this.faker.fakeValuesService().fetchObject("company.bs");
        return this.joinSampleOfEachList(buzzwordLists, " ");
    }

    /**
     * Generate a random company logo url in PNG format.
     */
    public String logo() {
        var number = this.faker.random().nextInt(13) + 1;
        return "https://pigment.github.io/fake-logos/logos/medium/color/" + number + ".png";
    }

    public String url() {
        return join(
            "www",
            ".",
            FakerIDN.toASCII(this.domainName()),
            ".",
            this.domainSuffix()
                );
    }

    private String domainName(){
        return StringUtils.deleteWhitespace(this.name().toLowerCase().replace(",", "").replace("'", ""));
    }

    private String domainSuffix() {
        return this.faker.fakeValuesService().resolve("internet.domain_suffix", this, this.faker);
    }

    private String joinSampleOfEachList(List<List<String>> listOfLists, String separator) {
        List<String> words = new ArrayList<>();
        for (List<String> list : listOfLists) {
            words.add(list.get(this.faker.random().nextInt(list.size())));
        }
        return join(words, separator);
    }
}
