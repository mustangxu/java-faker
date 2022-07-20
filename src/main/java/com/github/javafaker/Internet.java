package com.github.javafaker;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.stripAccents;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.github.javafaker.service.FakerIDN;

public class Internet {
    private final Faker faker;

    protected Internet(Faker faker) {
        this.faker = faker;
    }

    public String emailAddress() {
        return this.emailAddress(this.faker.name().username());
    }

    public String emailAddress(String localPart) {
        return Internet.emailAddress(localPart, FakerIDN.toASCII(this.faker.fakeValuesService().resolve("internet.free_email", this, this.faker)));
    }

    public String safeEmailAddress() {
        return this.safeEmailAddress(this.faker.name().username());
    }

    public String safeEmailAddress(String localPart) {
        return Internet.emailAddress(localPart, FakerIDN.toASCII(this.faker.fakeValuesService().resolve("internet.safe_email", this, this.faker)));
    }

    private static String emailAddress(String localPart, String domain) {
        return join(stripAccents(localPart), "@", domain);
    }

    public String domainName() {
        return this.domainWord() + "." + this.domainSuffix();
    }

    public String domainWord() {
        return FakerIDN.toASCII(this.faker.name().lastName().toLowerCase().replace("'", ""));
    }

    public String domainSuffix() {
        return this.faker.fakeValuesService().resolve("internet.domain_suffix", this, this.faker);
    }

    public String url() {
        return join(
            "www",
            ".",
            FakerIDN.toASCII(
                this.faker.name().firstName().toLowerCase().replace("'", "") +
                "-" +
                this.domainWord()
                    ),
            ".",
            this.domainSuffix()
                );
    }

    /**
     * Generates a random avatar url based on a collection of profile pictures of real people. All this avatar have been
     * authorized by its awesome users to be used on live websites (not just mockups). For more information, please
     * visit: http://uifaces.com/authorized
     *
     * @return an url to a random avatar image.
     * @see <a href="http://uifaces.com/authorized">Authorized UI Faces</a>
     */
    public String avatar() {
        return "https://s3.amazonaws.com/uifaces/faces/twitter/" + this.faker.fakeValuesService().resolve("internet.avatar", this, this.faker);
    }

    /**
     * Generates a random image url based on the lorempixel service. All the images provided by this service are released
     * under the creative commons license (CC BY-SA). For more information, please visit: http://lorempixel.com/
     *
     * @return an url to a random image.
     * @see <a href="http://lorempixel.com/">lorempixel - Placeholder Images for every case</a>
     */
    public String image() {
        var dimension = StringUtils.split(this.faker.fakeValuesService().resolve("internet.image_dimension", this, this.faker), 'x');
        if (dimension.length == 0) {
            return "";
        }
        return this.image(
            Integer.valueOf(StringUtils.trim(dimension[0])), Integer.valueOf(StringUtils.trim(dimension[1])),
            this.faker.bool().bool(), null);
    }

    /**
     * Same as image() but allows client code to choose a few image characteristics
     *
     * @param width  the image width
     * @param height the image height
     * @param gray   true for gray image and false for color image
     * @param text   optional custom text on the selected picture
     * @return an url to a random image with the given characteristics.
     */
    public String image(Integer width, Integer height, Boolean gray, String text) {
        return String.format("http://lorempixel.com/%s%s/%s/%s/%s",
            gray ? "g/" : StringUtils.EMPTY, width, height, this.faker.fakeValuesService().resolve("internet.image_category", this, this.faker),
                StringUtils.isEmpty(text) ? StringUtils.EMPTY : text);
    }

    public String password() {
        return this.password(8, 16);
    }

    public String password(boolean includeDigit) {
        return this.password(8, 16, false, false, includeDigit);
    }

    public String password(int minimumLength, int maximumLength) {
        return this.password(minimumLength, maximumLength, false);
    }

    public String password(int minimumLength, int maximumLength, boolean includeUppercase) {
        return this.password(minimumLength, maximumLength, includeUppercase, false);
    }

    public String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial) {
        return this.password(minimumLength, maximumLength, includeUppercase, includeSpecial, true);
    }

    public String password(int minimumLength, int maximumLength, boolean includeUppercase, boolean includeSpecial, boolean includeDigit) {
        if (!includeSpecial) {
            return this.faker.lorem().characters(minimumLength, maximumLength, includeUppercase, includeDigit);
        }
        var password = this.faker.lorem().characters(minimumLength,
            maximumLength, includeUppercase, includeDigit).toCharArray();
        char[] special = { '!', '@', '#', '$', '%', '^', '&', '*' };
        for (var i = 0; i < this.faker.random().nextInt(minimumLength); i++) {
            password[this.faker.random()
                     .nextInt(password.length)] = special[this.faker.random()
                                                          .nextInt(special.length)];
        }
        return new String(password);
    }

    /**
     * <p>Returns a MAC address in the following format: 6-bytes in MM:MM:MM:SS:SS:SS format.</p>
     * @return a correctly formatted MAC address
     * @param prefix a prefix to put on the front of the address
     */
    public String macAddress(String prefix) {
        final var tmp = prefix == null ? "" : prefix;
        final var prefixLength = tmp.trim().length() == 0
                ? 0
                    : tmp.split(":").length;

        final var out = new StringBuilder(tmp);
        for (var i=0;i < 6 - prefixLength;i++) {
            if (out.length() > 0) {
                out.append(':');
            }
            out.append(Integer.toHexString(this.faker.random().nextInt(16)));
            out.append(Integer.toHexString(this.faker.random().nextInt(16)));
        }
        return out.toString();
    }

    /**
     * @see Internet#macAddress(String)
     */
    public String macAddress() {
        return this.macAddress("");
    }

    /**
     * returns an IPv4 address in dot separated octets.
     * @return a correctly formatted IPv4 address.
     */
    public String ipV4Address() {
        return String.format("%d.%d.%d.%d",
            this.faker.random().nextInt(254) + 2,
            this.faker.random().nextInt(254) + 2,
            this.faker.random().nextInt(254) + 2,
            this.faker.random().nextInt(254) + 2);
    }

    /**
     * @return a valid private IPV4 address in dot notation
     */
    public String privateIpV4Address() {
        final Integer[] PRIVATE_FIRST_OCTET = {10,127,169,192,172};
        final Integer[] PRIVATE_SECOND_OCTET_172 = {16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};

        final var r = this.faker.random();
        int first = this.random(PRIVATE_FIRST_OCTET),
                second = r.nextInt(256),
                third = r.nextInt(256),
                fourth = r.nextInt(256);

        switch (first) {
            case 172:
                second = this.random(PRIVATE_SECOND_OCTET_172);
                break;
            case 192:
                second = 168;
                break;
            case 169:
                second = 254;
                break;
        }
        return String.format("%d.%d.%d.%d", first, second, third, fourth);
    }

    /**
     * @return a valid public IPV4 address in dot notation
     */
    public String publicIpV4Address() {
        final var r = this.faker.random();

        final int[] PRIVATE_FIRST_OCTET = {10,127,169,192,172};

        int first = r.nextInt(256),
                second = r.nextInt(256),
                third = r.nextInt(256),
                fourth = r.nextInt(256);

        while (Arrays.binarySearch(PRIVATE_FIRST_OCTET, first) > 0) {
            first = r.nextInt(256);
        }
        return String.format("%d.%d.%d.%d", first, second, third, fourth);
    }

    /**
     * @return a valid IPV4 CIDR
     */
    public String ipV4Cidr() {
        return new StringBuilder(this.ipV4Address())
                .append('/')
                .append(this.faker.random().nextInt(31) + 1)
                .toString();
    }

    /**
     * <p>Returns an IPv6 address in hh:hh:hh:hh:hh:hh:hh:hh format.</p>
     * @return a correctly formatted IPv6 address.
     */
    public String ipV6Address() {
        final var tmp = new StringBuilder();
        for (var i=0;i < 8;i++) {
            if (i > 0) {
                tmp.append(":");
            }
            tmp.append(Integer.toHexString(this.faker.random().nextInt(16)));
            tmp.append(Integer.toHexString(this.faker.random().nextInt(16)));
            tmp.append(Integer.toHexString(this.faker.random().nextInt(16)));
            tmp.append(Integer.toHexString(this.faker.random().nextInt(16)));
        }
        return tmp.toString();
    }

    /**
     * @return a valid IPV6 CIDR
     */
    public String ipV6Cidr() {
        return new StringBuilder(this.ipV6Address())
                .append('/')
                .append(this.faker.random().nextInt(127) + 1)
                .toString();
    }

    /**
     * @return a slug using '_' as the word separator and two {@link Lorem} words as the values
     */
    public String slug() {
        return this.slug(this.faker.lorem().words(2), "_");
    }

    /**
     * @param wordsOrNull if null, then 2 {@link Lorem} words
     * @param glueOrNull  if null, "_"
     * @return a slug string combining wordsOrNull with glueOrNull (ex. x_y)
     */
    public String slug(List<String> wordsOrNull, String glueOrNull) {
        final var glue = glueOrNull == null
                ? "_"
                    : glueOrNull;
        final var words = wordsOrNull == null
                ? this.faker.lorem().words(2)
                    : wordsOrNull;

        final var slug = new StringBuilder();
        for (var i = 0; i < words.size(); i++) {
            if (i > 0) {
                slug.append(glue);
            }
            slug.append(words.get(i));
        }
        return slug.toString();
    }

    /**
     * Returns a UUID (type 4) as String.
     * @return A UUID as String.
     */
    public String uuid() {
        return UUID.randomUUID().toString();
    }

    private <T> T random(T[] src) {
        return src[this.faker.random().nextInt(src.length)];
    }

    public String userAgent(UserAgent userAgent) {
        var agent = userAgent;

        if(agent == null) {
            agent = UserAgent.any();
        }

        var userAgentKey = "internet.user_agent." + agent.toString();
        return this.faker.fakeValuesService().resolve(userAgentKey, this, this.faker);
    }

    public String userAgentAny() {
        return this.userAgent(null);
    }

    public enum UserAgent {
        AOL("aol"),
        CHROME("chrome"),
        FIREFOX("firefox"),
        INTERNET_EXPLORER("internet_explorer"),
        NETSCAPE("netscape"),
        OPERA("opera"),
        SAFARI("safari");

        //Browser's name in corresponding yaml (internet.yml) file.
        private String browserName;

        UserAgent(String browserName) {
            this.browserName = browserName;
        }

        private static UserAgent any() {
            var agents = UserAgent.values();
            var randomIndex = (int)(Math.random() * agents.length);
            return agents[randomIndex];
        }

        @Override
        public String toString() {
            return this.browserName;
        }
    }
}
