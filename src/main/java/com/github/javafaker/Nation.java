package com.github.javafaker;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;

public class Nation {

    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    private final Faker faker;

    protected Nation(Faker faker) {
        this.faker = faker;
    }

    public String nationality() {
        return this.faker.fakeValuesService().resolve("nation.nationality", this, this.faker);
    }

    public String language() {
        return this.faker.fakeValuesService().resolve("nation.language", this, this.faker);
    }

    public String capitalCity() {
        return this.faker.fakeValuesService().resolve("nation.capital_city", this, this.faker);
    }

    public String flag() {
        @SuppressWarnings("unchecked")
        var flagInts = (List<Integer>) this.faker.fakeValuesService().fetch("nation.flag");

        var byteBuffer = ByteBuffer.allocate(flagInts.size());

        for (Integer flagInt : flagInts) {
            byteBuffer.put(flagInt.byteValue());
        }

        return new String(byteBuffer.array(), UTF8_CHARSET);
    }

}
