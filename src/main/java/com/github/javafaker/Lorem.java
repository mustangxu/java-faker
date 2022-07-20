package com.github.javafaker;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.join;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Lorem {
    private final Faker faker;

    protected Lorem(Faker faker) {
        this.faker = faker;
    }

    public char character() {
        return this.character(false);
    }

    public char character(boolean includeUppercase) {
        return this.characters(1, includeUppercase).charAt(0);
    }

    public String characters() {
        return this.characters(255, false);
    }

    public String characters(boolean includeUppercase) {
        return this.characters(255, includeUppercase);
    }

    public String characters(int minimumLength, int maximumLength) {
        return this.characters(this.faker.random().nextInt(maximumLength - minimumLength) + minimumLength, false);
    }

    public String characters(int minimumLength, int maximumLength, boolean includeUppercase) {
        return this.characters(this.faker.random().nextInt(maximumLength - minimumLength) + minimumLength, includeUppercase);
    }

    public String characters(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeDigit) {
        return this.characters(this.faker.random().nextInt(maximumLength - minimumLength) + minimumLength, includeUppercase, includeDigit);
    }

    public String characters(int fixedNumberOfCharacters) {
        return this.characters(fixedNumberOfCharacters, false);
    }

    public String characters(int fixedNumberOfCharacters, boolean includeUppercase) {
        return this.characters(fixedNumberOfCharacters, includeUppercase, true);
    }

    public String characters(int fixedNumberOfCharacters, boolean includeUppercase, boolean includeDigit) {
        if (fixedNumberOfCharacters < 1) {
            return "";
        }
        var buffer = new char[fixedNumberOfCharacters];
        for (var i = 0; i < buffer.length; i++) {
            char randomCharacter;

            if (includeDigit) {
                randomCharacter = characters[this.faker.random().nextInt(characters.length)];
            } else {
                randomCharacter = letters[this.faker.random().nextInt(letters.length)];
            }

            if (includeUppercase && this.faker.bool().bool()) {
                randomCharacter = Character.toUpperCase(randomCharacter);
            }
            buffer[i] = randomCharacter;
        }
        return new String(buffer);
    }

    public List<String> words(int num) {
        List<String> returnList = new ArrayList<>();
        for (var i = 0; i < num; i++) {
            returnList.add(this.word());
        }
        return returnList;
    }

    public List<String> words() {
        return this.words(3);
    }

    public String word() {
        return this.faker.fakeValuesService().resolve("lorem.words", this, this.faker);
    }

    /**
     * Create a sentence with a random number of words within the range 4..10.
     * @return a random sentence
     */
    public String sentence() {
        return this.sentence(3);
    }

    /**
     * Create a sentence with a random number of words within the range (wordCount+1)..(wordCount+6).
     * @param wordCount
     * @return a random sentence
     */
    public String sentence(int wordCount) {
        return this.sentence(wordCount, 6);
    }

    /**
     * Create a sentence with a random number of words within the range (wordCount+1)..(wordCount+randomWordsToAdd).</p>
     *
     * Set {@code randomWordsToAdd} to 0 to generate sentences with a fixed number of words.
     * @param wordCount
     * @param randomWordsToAdd
     * @return a random sentence
     */
    public String sentence(int wordCount, int randomWordsToAdd) {
        var numberOfWordsToAdd = randomWordsToAdd == 0 ? 0 : this.faker.random().nextInt(randomWordsToAdd);
        return capitalize(join(this.words(wordCount + numberOfWordsToAdd), " ") + ".");
    }

    public List<String> sentences(int sentenceCount) {
        List<String> sentences = new ArrayList<>(sentenceCount);
        for (var i = 0; i < sentenceCount; i++) {
            sentences.add(this.sentence());
        }
        return sentences;
    }

    public String paragraph(int sentenceCount) {
        return join(this.sentences(sentenceCount + this.faker.random().nextInt(3)), " ");
    }

    public String paragraph() {
        return this.paragraph(3);
    }

    public List<String> paragraphs(int paragraphCount) {
        List<String> paragraphs = new ArrayList<>(paragraphCount);
        for (var i = 0; i < paragraphCount; i++) {
            paragraphs.add(this.paragraph());
        }
        return paragraphs;
    }

    /**
     * Create a string with a fixed size. Can be useful for testing
     * validator based on length string for example
     *
     * @param numberOfLetters size of the expected String
     * @return a string with a fixed size
     */
    public String fixedString(int numberOfLetters) {
        var builder = new StringBuilder();
        while (builder.length() < numberOfLetters) {
            builder.append(this.sentence());
        }
        return StringUtils.substring(builder.toString(), 0, numberOfLetters);
    }

    static {
        var builder = new StringBuilder(36);
        for (var character = 'a'; character <= 'z'; character++) {
            builder.append(character);
        }
        letters = builder.toString().toCharArray();
        for (var number = '0'; number <= '9'; number++) {
            builder.append(number);
        }
        characters = builder.toString().toCharArray();
    }

    private static final char[] letters;
    private static final char[] characters;

}
