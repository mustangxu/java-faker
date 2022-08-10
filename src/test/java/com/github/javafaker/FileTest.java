package com.github.javafaker;

import com.github.javafaker.repeating.Repeat;
import org.junit.jupiter.api.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileTest extends AbstractFakerTest {

    @Test
    @Repeat(times=10)
    public void testExtension() {
        assertThat(this.faker.file().extension(),
                matchesRegularExpression("(flac|mp3|wav|bmp|gif|jpeg|jpg|png|tiff|css|csv|html|js|json|txt|mp4|avi|mov|webm|doc|docx|xls|xlsx|ppt|pptx|odt|ods|odp|pages|numbers|key|pdf)"));
    }

    @Test
    @Repeat(times=10)
    public void testMimeTypeFormat() {
        assertThat(this.faker.file().mimeType(), matchesRegularExpression(".+\\/.+"));
    }

    @Test
    @Repeat(times=10)
    public void testFileName() {
        assertThat(this.faker.file().fileName(), matchesRegularExpression("([a-z\\-_]+)(\\\\|\\/)([a-z\\-_]+)\\.([a-z0-9]+)"));
    }

    @Test
    public void testFileNameSpecifyExtension() {
        assertThat(this.faker.file().fileName(null, null, "txt", null), 
                matchesRegularExpression("([a-z\\-_]+)(\\\\|\\/)([a-z\\-_]+)\\.txt"));
    }

    @Test
    public void testFileNameSpecifyDir() {
        assertThat(this.faker.file().fileName("my_dir", null, null, null),
                matchesRegularExpression("my_dir(\\\\|\\/)([a-z\\-_]+)\\.([a-z0-9]+)"));
    }

    @Test
    public void testFileNameSpecifySeparator() {
        assertThat(this.faker.file().fileName(null,null,null,"\\"), 
                matchesRegularExpression("([a-z\\-_]+)\\\\([a-z\\-_]+)\\.([a-z0-9]+)"));
    }

    @Test
    public void testFileNameSpecifyName() {
        assertThat(this.faker.file().fileName(null,"da_name",null,null),
                matchesRegularExpression("([a-z\\-_]+)(\\\\|\\/)da_name\\.([a-z0-9]+)"));
    }
}
