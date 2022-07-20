package com.github.javafaker;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

/**
 * Provides utility methods for generating fake strings, such as names, phone
 * numbers, addresses. generate random strings with given patterns
 *
 * @author ren
 */
public class Faker {
    private final RandomService randomService;
    private final FakeValuesService fakeValuesService;

    private final Ancient ancient;
    private final App app;
    private final Artist artist;
    private final Avatar avatar;
    private final Aviation aviation;
    private final Lorem lorem;
    private final Music music;
    private final Name name;
    private final Number number;
    private final Internet internet;
    private final PhoneNumber phoneNumber;
    private final Pokemon pokemon;
    private final Address address;
    private final Business business;
    private final Book book;
    private final ChuckNorris chuckNorris;
    private final Color color;
    private final Commerce commerce;
    private final Country country;
    private final Currency currency;
    private final Company company;
    private final Crypto crypto;
    private final IdNumber idNumber;
    private final Hacker hacker;
    private final Options options;
    private final Code code;
    private final Coin coin;
    private final Finance finance;
    private final Food food;
    private final GameOfThrones gameOfThrones;
    private final Gender gender;
    private final DateAndTime dateAndTime;
    private final Demographic demographic;
    private final Dog dog;
    private final Educator educator;
    private final ElderScrolls elderScrolls;
    private final Shakespeare shakespeare;
    private final SlackEmoji slackEmoji;
    private final Space space;
    private final Superhero superhero;
    private final Bool bool;
    private final Team team;
    private final Beer beer;
    private final University university;
    private final Cat cat;
    private final File file;
    private final Stock stock;
    private final LordOfTheRings lordOfTheRings;
    private final Zelda zelda;
    private final HarryPotter harryPotter;
    private final RockBand rockBand;
    private final Esports esports;
    private final Friends friends;
    private final Hipster hipster;
    private final Job job;
    private final TwinPeaks twinPeaks;
    private final RickAndMorty rickAndMorty;
    private final Yoda yoda;
    private final Matz matz;
    private final Witcher witcher;
    private final DragonBall dragonBall;
    private final FunnyName funnyName;
    private final HitchhikersGuideToTheGalaxy hitchhikersGuideToTheGalaxy;
    private final Hobbit hobbit;
    private final HowIMetYourMother howIMetYourMother;
    private final LeagueOfLegends leagueOfLegends;
    private final Overwatch overwatch;
    private final Robin robin;
    private final StarTrek starTrek;
    private final Weather weather;
    private final Lebowski lebowski;
    private final Medical medical;
    private final Animal animal;
    private final BackToTheFuture backToTheFuture;
    private final PrincessBride princessBride;
    private final Buffy buffy;
    private final Relationships relationships;
    private final Nation nation;
    private final Dune dune;
    private final AquaTeenHungerForce aquaTeenHungerForce;
    private final ProgrammingLanguage programmingLanguage;
    private final Kaamelott kaamelott;
    private final Photography photography;
    private final StarCraft starCraft;
    private final BojackHorseman bojackHorseman;
    private final Disease disease;
    private final Basketball basketball;
    private final Barcode barcode;
    private final Sip sip;
    private final EnglandFootBall englandfootball;
    private final Mountain mountain;

    public Faker() {
        this(Locale.ENGLISH);
    }

    public Faker(Locale locale) {
        this(locale, (Random)null);
    }

    public Faker(Random random) {
        this(Locale.ENGLISH, random);
    }

    public Faker(Locale locale, Random random) {
        this(locale, new RandomService(random));
    }

    public Faker(Locale locale, RandomService randomService) {
        this(new FakeValuesService(locale, randomService), randomService);
    }

    public Faker(FakeValuesService fakeValuesService, RandomService random) {
        this.randomService = random;
        this.fakeValuesService = fakeValuesService;

        this.ancient = new Ancient(this);
        this.app = new App(this);
        this.artist = new Artist(this);
        this.avatar = new Avatar(this);
        this.aviation = new Aviation(this);
        this.lorem = new Lorem(this);
        this.music = new Music(this);
        this.name = new Name(this);
        this.number = new Number(this);
        this.internet = new Internet(this);
        this.phoneNumber = new PhoneNumber(this);
        this.pokemon = new Pokemon(this);
        this.address = new Address(this);
        this.book = new Book(this);
        this.business = new Business(this);
        this.chuckNorris = new ChuckNorris(this);
        this.color = new Color(this);
        this.idNumber = new IdNumber(this);
        this.hacker = new Hacker(this);
        this.company = new Company(this);
        this.crypto = new Crypto(this);
        this.elderScrolls = new ElderScrolls(this);
        this.commerce = new Commerce(this);
        this.currency = new Currency(this);
        this.options = new Options(this);
        this.code = new Code(this);
        this.file = new File(this);
        this.finance = new Finance(this);
        this.food = new Food(this);
        this.gameOfThrones = new GameOfThrones(this);
        this.gender = new Gender(this);
        this.dateAndTime = new DateAndTime(this);
        this.demographic = new Demographic(this);
        this.dog = new Dog(this);
        this.educator = new Educator(this);
        this.shakespeare = new Shakespeare(this);
        this.slackEmoji = new SlackEmoji(this);
        this.space = new Space(this);
        this.coin = new Coin(this);
        this.superhero = new Superhero(this);
        this.team = new Team(this);
        this.bool = new Bool(this);
        this.beer = new Beer(this);
        this.university = new University(this);
        this.cat = new Cat(this);
        this.stock = new Stock(this);
        this.lordOfTheRings = new LordOfTheRings(this);
        this.zelda = new Zelda(this);
        this.harryPotter = new HarryPotter(this);
        this.rockBand = new RockBand(this);
        this.esports = new Esports(this);
        this.friends = new Friends(this);
        this.hipster = new Hipster(this);
        this.job = new Job(this);
        this.twinPeaks = new TwinPeaks(this);
        this.rickAndMorty = new RickAndMorty(this);
        this.yoda = new Yoda(this);
        this.matz = new Matz(this);
        this.witcher = new Witcher(this);
        this.dragonBall = new DragonBall(this);
        this.funnyName = new FunnyName(this);
        this.hitchhikersGuideToTheGalaxy = new HitchhikersGuideToTheGalaxy(this);
        this.hobbit = new Hobbit(this);
        this.howIMetYourMother = new HowIMetYourMother(this);
        this.leagueOfLegends = new LeagueOfLegends(this);
        this.overwatch = new Overwatch(this);
        this.robin = new Robin(this);
        this.starTrek = new StarTrek(this);
        this.weather = new Weather(this);
        this.lebowski = new Lebowski(this);
        this.medical = new Medical(this);
        this.country = new Country(this);
        this.animal = new Animal(this);
        this.backToTheFuture = new BackToTheFuture(this);
        this.princessBride = new PrincessBride(this);
        this.buffy = new Buffy(this);
        this.relationships = new Relationships(this);
        this.nation = new Nation(this);
        this.dune = new Dune(this);
        this.aquaTeenHungerForce = new AquaTeenHungerForce(this);
        this.programmingLanguage = new ProgrammingLanguage(this);
        this.kaamelott = new Kaamelott(this);
        this.photography = new Photography(this);
        this.starCraft = new StarCraft(this);
        this.bojackHorseman = new BojackHorseman(this);
        this.disease = new Disease(this);
        this.basketball = new Basketball(this);
        this.barcode = new Barcode(this);
        this.sip = new Sip(this);
        this.englandfootball = new EnglandFootBall(this);
        this.mountain = new Mountain(this);
    }

    /**
     * Constructs Faker instance with default argument.
     *
     * @return {@link Faker#Faker()}
     */
    public static Faker instance() {
        return new Faker();
    }

    /**
     * Constructs Faker instance with provided {@link Locale}.
     *
     * @param locale - {@link Locale}
     * @return {@link Faker#Faker(Locale)}
     */
    public static Faker instance(Locale locale) {
        return new Faker(locale);
    }

    /**
     * Constructs Faker instance with provided {@link Random}.
     *
     * @param random - {@link Random}
     * @return {@link Faker#Faker(Random)}
     */
    public static Faker instance(Random random) {
        return new Faker(random);
    }

    /**
     * Constructs Faker instance with provided {@link Locale} and {@link Random}.
     *
     * @param locale - {@link Locale}
     * @param random - {@link Random}
     * @return {@link Faker#Faker(Locale, Random)}
     */
    public static Faker instance(Locale locale, Random random) {
        return new Faker(locale, random);
    }

    /**
     * Returns a string with the '#' characters in the parameter replaced with random digits between 0-9 inclusive.
     * <p>
     * For example, the string "ABC##EFG" could be replaced with a string like "ABC99EFG".
     *
     * @param numberString
     * @return
     */
    public String numerify(String numberString) {
        return this.fakeValuesService.numerify(numberString);
    }

    /**
     * Returns a string with the '?' characters in the parameter replaced with random alphabetic
     * characters.
     * <p>
     * For example, the string "12??34" could be replaced with a string like "12AB34".
     *
     * @param letterString
     * @return
     */
    public String letterify(String letterString) {
        return this.fakeValuesService.letterify(letterString);
    }

    /**
     * Returns a string with the '?' characters in the parameter replaced with random alphabetic
     * characters.
     * <p>
     * For example, the string "12??34" could be replaced with a string like "12AB34".
     *
     * @param letterString
     * @param isUpper
     * @return
     */
    public String letterify(String letterString, boolean isUpper) {
        return this.fakeValuesService.letterify(letterString, isUpper);
    }

    /**
     * Applies both a {@link #numerify(String)} and a {@link #letterify(String)}
     * over the incoming string.
     *
     * @param string
     * @return
     */
    public String bothify(String string) {
        return this.fakeValuesService.bothify(string);
    }

    /**
     * Applies both a {@link #numerify(String)} and a {@link #letterify(String)}
     * over the incoming string.
     *
     * @param string
     * @param isUpper
     * @return
     */
    public String bothify(String string, boolean isUpper) {
        return this.fakeValuesService.bothify(string, isUpper);
    }

    /**
     * Generates a String that matches the given regular expression.
     */
    public String regexify(String regex) {
        return this.fakeValuesService.regexify(regex);
    }

    public RandomService random() {
        return this.randomService;
    }

    public Currency currency() {
        return this.currency;

    }

    FakeValuesService fakeValuesService() {
        return this.fakeValuesService;
    }

    public Ancient ancient() {
        return this.ancient;
    }

    public App app() {
        return this.app;
    }

    public Artist artist() {
        return this.artist;
    }

    public Avatar avatar() {
        return this.avatar;
    }

    public Aviation aviation() {
        return this.aviation;
    }

    public Music music() {
        return this.music;
    }

    public Name name() {
        return this.name;
    }

    public Number number() {
        return this.number;
    }

    public Internet internet() {
        return this.internet;
    }

    public PhoneNumber phoneNumber() {
        return this.phoneNumber;
    }

    public Pokemon pokemon() {
        return this.pokemon;
    }

    public Lorem lorem() {
        return this.lorem;
    }

    public Address address() {
        return this.address;
    }

    public Book book() {
        return this.book;
    }

    public Buffy buffy() {
        return this.buffy;
    }

    public Business business() {
        return this.business;
    }

    public ChuckNorris chuckNorris() {
        return this.chuckNorris;
    }

    public Color color() {
        return this.color;
    }

    public Commerce commerce() {
        return this.commerce;
    }

    public Company company() {
        return this.company;
    }

    public Crypto crypto() {
        return this.crypto;
    }

    public Hacker hacker() {
        return this.hacker;
    }

    public IdNumber idNumber() {
        return this.idNumber;
    }

    public Options options() {
        return this.options;
    }

    public Code code() {
        return this.code;
    }

    public Coin coin() {
        return this.coin;
    }

    public File file() {
        return this.file;
    }

    public Finance finance() {
        return this.finance;
    }

    public Food food() {
        return this.food;
    }

    public ElderScrolls elderScrolls() {
        return this.elderScrolls;
    }

    public GameOfThrones gameOfThrones() {
        return this.gameOfThrones;
    }

    public Gender gender() {
        return this.gender;
    }

    public DateAndTime date() {
        return this.dateAndTime;
    }

    public Demographic demographic() {
        return this.demographic;
    }

    public Dog dog() {
        return this.dog;
    }

    public Educator educator() {
        return this.educator;
    }

    public SlackEmoji slackEmoji() {
        return this.slackEmoji;
    }

    public Shakespeare shakespeare() {
        return this.shakespeare;
    }

    public Space space() {
        return this.space;
    }

    public Superhero superhero() {
        return this.superhero;
    }

    public Bool bool() {
        return this.bool;
    }

    public Team team() {
        return this.team;
    }

    public Beer beer() { return this.beer; }

    public University university() {
        return this.university;
    }

    public Cat cat() {
        return this.cat;
    }

    public Stock stock() {
        return this.stock;
    }

    public LordOfTheRings lordOfTheRings() {
        return this.lordOfTheRings;
    }

    public Zelda zelda() {
        return this.zelda;
    }

    public HarryPotter harryPotter() {
        return this.harryPotter;
    }

    public RockBand rockBand() {
        return this.rockBand;
    }

    public Esports esports() {
        return this.esports;
    }

    public Friends friends() {
        return this.friends;
    }

    public Hipster hipster() {
        return this.hipster;
    }

    public Job job() {
        return this.job;
    }

    public TwinPeaks twinPeaks() {
        return this.twinPeaks;
    }

    public RickAndMorty rickAndMorty() {
        return this.rickAndMorty;
    }

    public Yoda yoda() {
        return this.yoda;
    }

    public Matz matz() {
        return this.matz;
    }

    public Witcher witcher() {
        return this.witcher;
    }

    public DragonBall dragonBall() {
        return this.dragonBall;
    }

    public FunnyName funnyName() {
        return this.funnyName;
    }

    public HitchhikersGuideToTheGalaxy hitchhikersGuideToTheGalaxy() {
        return this.hitchhikersGuideToTheGalaxy;
    }

    public Hobbit hobbit() {
        return this.hobbit;
    }

    public HowIMetYourMother howIMetYourMother() {
        return this.howIMetYourMother;
    }

    public LeagueOfLegends leagueOfLegends() {
        return this.leagueOfLegends;
    }

    public Overwatch overwatch() {
        return this.overwatch;
    }

    public Robin robin() {
        return this.robin;
    }

    public StarTrek starTrek() {
        return this.starTrek;
    }

    public Weather weather() {
        return this.weather;
    }

    public Lebowski lebowski() {
        return this.lebowski;
    }

    public Medical medical() {
        return this.medical;
    }

    public Country country() {
        return this.country;
    }

    public Animal animal() {
        return this.animal;
    }

    public BackToTheFuture backToTheFuture() {
        return this.backToTheFuture;
    }

    public PrincessBride princessBride() {
        return this.princessBride;
    }

    public Relationships relationships() {
        return this.relationships;
    }

    public Nation nation() {
        return this.nation;
    }

    public Dune dune() {
        return this.dune;
    }

    public AquaTeenHungerForce aquaTeenHungerForce() {
        return this.aquaTeenHungerForce;
    }

    public ProgrammingLanguage programmingLanguage() {
        return this.programmingLanguage;
    }

    public Kaamelott kaamelott() {
        return this.kaamelott;
    }

    public Photography photography() {
        return  this.photography;
    }

    public StarCraft starCraft() {
        return this.starCraft;
    }

    public BojackHorseman bojackHorseman() { return this.bojackHorseman; }

    public Disease disease() {return this.disease; }

    public Basketball basketball() { return this.basketball; }

    public Barcode barcode() { return this.barcode; }

    public Sip sip() { return this.sip; }

    public EnglandFootBall englandfootball() { return this.englandfootball; }

    public Mountain mountain() { return this.mountain; }

    public String resolve(String key) {
        return this.fakeValuesService.resolve(key, this, this);
    }

    /**
     * Allows the evaluation of native YML expressions to allow you to build your own.
     * <p>
     * The following are valid expressions:
     * <ul>
     * <li>#{regexify '(a|b){2,3}'}</li>
     * <li>#{regexify '\\.\\*\\?\\+'}</li>
     * <li>#{bothify '????','false'}</li>
     * <li>#{Name.first_name} #{Name.first_name} #{Name.last_name}</li>
     * <li>#{number.number_between '1','10'}</li>
     * </ul>
     *
     * @param expression (see examples above)
     * @return the evaluated string expression
     * @throws RuntimeException if unable to evaluate the expression
     */
    public String expression(String expression) {
        return this.fakeValuesService.expression(expression, this);
    }
}
