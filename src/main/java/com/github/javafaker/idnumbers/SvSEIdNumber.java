package com.github.javafaker.idnumbers;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;

/**
 * Implementation based on the definition at
 * https://www.skatteverket.se/privat/folkbokforing/personnummer.4.3810a01c150939e893f18c29.html
 * and the description at
 * https://en.wikipedia.org/wiki/Personal_identity_number_(Sweden)
 */
public class SvSEIdNumber {
    private static final String[] validPatterns = {"######-####", "######+####"};

    public String getValidSsn(Faker f) {
        var candidate = "";
        while (!this.validSwedishSsn(candidate)) {
            var pattern = SvSEIdNumber.getPattern(f);
            candidate = f.numerify(pattern);
        }

        return candidate;
    }

    public String getInvalidSsn(Faker f) {
        var candidate = "121212-1212"; // Seed with a valid number
        while (this.validSwedishSsn(candidate)) {
            var pattern = SvSEIdNumber.getPattern(f);
            candidate = f.numerify(pattern);
        }

        return candidate;
    }

    private static String getPattern(Faker faker) {
        return validPatterns[faker.random().nextInt(2)];
    }

    boolean validSwedishSsn(String ssn) {
        if (ssn.length() != 11) {
            return false;
        }

        try {
            if (SvSEIdNumber.parseDate(ssn)) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        var calculatedChecksum = SvSEIdNumber.calculateChecksum(ssn);
        var checksum = Integer.parseInt(ssn.substring(10, 11));
        return checksum == calculatedChecksum;
    }

    private static boolean parseDate(String ssn) throws ParseException {
        var sdf = new SimpleDateFormat("yyMMdd");
        var dateString = ssn.substring(0, 6);
        var date = sdf.parse(dateString);

        // want to check that the parsed date is equal to the supplied data, most of the attempts will fail
        var reversed = sdf.format(date);
        return !reversed.equals(dateString);
    }

    private static int calculateChecksum(String number) {
        var dateString = number.substring(0, 6);
        var birthNumber = number.substring(7, 10);

        var calculatedNumber = calculateDigits(dateString + birthNumber);
        var sum = calculateDigitSum(calculatedNumber);

        var lastDigit = sum % 10;
        var difference = 10 - lastDigit;

        return difference % 10;
    }

    private static String calculateDigits(String numbers) {
        var calculatedNumbers = new StringBuilder();
        for (var i = 0; i < 9; i++) {
            int res;
            var n = Integer.parseInt(numbers.substring(i, i + 1));
            if (i % 2 == 0) {
                res = n * 2;
            } else {
                res = n;
            }

            calculatedNumbers.append(res);
        }
        return calculatedNumbers.toString();
    }

    private static int calculateDigitSum(String numbers) {
        var sum = 0;
        for (var i = 0; i < numbers.length(); i++) {
            var n = Integer.parseInt(numbers.substring(i, i + 1));
            sum += n;
        }
        return sum;
    }

}