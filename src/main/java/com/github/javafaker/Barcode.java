package com.github.javafaker;

public class Barcode {

    private Faker faker;

    public Barcode(Faker faker) {
        this.faker = faker;
    }

    public String type() {
        return this.faker.resolve("barcode.types");
    }

    public String data(){
        return this.faker.resolve("barcode.datas");
    }

    public String typeAndData(){
        return this.faker.resolve("barcode.typeAndData");
    }
}
