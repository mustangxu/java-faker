package com.github.javafaker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang3.ArrayUtils;

public class Relationships {
    private final Faker faker;

    protected Relationships(final Faker faker) {
        this.faker = faker;
    }

    public String direct() {
        return this.faker.resolve("relationship.familial.direct");
    }

    public String extended() {
        return this.faker.resolve("relationship.familial.extended");
    }

    public String inLaw() {
        return this.faker.resolve("relationship.in_law");
    }

    public String spouse() {
        return this.faker.resolve("relationship.spouse");
    }

    public String parent() {
        return this.faker.resolve("relationship.parent");
    }

    public String sibling() {
        return this.faker.resolve("relationship.sibling");
    }

    public String any() {
        Method currentMethod = getClass().getEnclosingMethod();

        try {
            Method[] methods = Relationships.class.getDeclaredMethods();
            methods = ArrayUtils.removeElement(methods, currentMethod);
            int indx = this.faker.random().nextInt(methods.length);
            Method runMethod = methods[indx];
            Relationships relationships = new Relationships(this.faker);
            return (String)runMethod.invoke(relationships);
        } catch (SecurityException e) {
            throw new RuntimeException("SecurityException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("IllegalArgumentException: " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("IllegalAccessException: " + e.getMessage());
        } catch (InvocationTargetException e) {
            throw new RuntimeException("InvocationTargetException: " + e.getMessage());
        }
    }

}
