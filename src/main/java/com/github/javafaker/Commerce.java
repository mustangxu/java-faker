package com.github.javafaker;

import java.text.DecimalFormat;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class Commerce {
    private final Faker faker;

    protected Commerce(Faker faker) {
        this.faker = faker;
    }

    public String color() {
        return this.faker.fakeValuesService().resolve("color.name", this, this.faker);
    }

    public String department() {
        var numberOfDepartments = Math.max(this.faker.random().nextInt(4), 1);
        SortedSet<String> departments = new TreeSet<>();
        while (departments.size() < numberOfDepartments) {
            departments.add(this.faker.fakeValuesService().resolve("commerce.department", this, this.faker));
        }
        if (departments.size() > 1) {
            var lastDepartment = departments.last();
            return StringUtils.join(departments.headSet(lastDepartment), ", ") + " & " + lastDepartment;
        }
        return departments.first();
    }

    public String productName() {
        return StringUtils.join(new String[] {
            this.faker.fakeValuesService().resolve("commerce.product_name.adjective", this,this.faker),
            this.faker.fakeValuesService().resolve("commerce.product_name.material", this, this.faker),
            this.faker.fakeValuesService().resolve("commerce.product_name.product", this, this.faker) }, " ");
    }

    public String material() {
        return this.faker.fakeValuesService().resolve("commerce.product_name.material", this, this.faker);
    }

    /**
     * Generate a random price between 0.00 and 100.00
     */
    public String price() {
        return this.price(0, 100);
    }

    public String price(double min, double max) {
        var price =  min + this.faker.random().nextDouble() * (max - min);
        return new DecimalFormat("#0.00").format(price);
    }

    public String promotionCode() {
        return this.promotionCode(6);
    }

    public String promotionCode(int digits) {
        return StringUtils.join(this.faker.resolve("commerce.promotion_code.adjective"),
            this.faker.resolve("commerce.promotion_code.noun"),
            this.faker.number().digits(digits));
    }
}
