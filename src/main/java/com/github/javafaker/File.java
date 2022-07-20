package com.github.javafaker;

public class File {
    private final Faker faker;

    protected File(Faker faker) {
        this.faker = faker;
    }

    public String extension() {
        return this.faker.resolve("file.extension");
    }

    public String mimeType() {
        return this.faker.resolve("file.mime_type");
    }

    public String fileName() {
        return this.fileName(null, null, null, null);
    }

    public String fileName(String dirOrNull, String nameOrNull, String extensionOrNull, String separatorOrNull) {
        final var sep = separatorOrNull == null ? java.io.File.separator
            : separatorOrNull;
        final var dir = dirOrNull == null ? this.faker.internet().slug() : dirOrNull;
        final var name = nameOrNull == null ? this.faker.lorem().word().toLowerCase() : nameOrNull;
        final var ext = extensionOrNull == null ? this.extension() : extensionOrNull;
        return dir + sep + name + "." + ext;
    }
}
