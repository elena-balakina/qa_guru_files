package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class DocFileTests {
    @Test
    void docTest() throws IOException {
        String docFilePath = "./src/test/resources/files/1.doc";
        String expectedData = "Text to check";

        String actualData = readTextFromPath(docFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void docxTest() throws IOException {
        String docxFilePath = "./src/test/resources/files/1.docx";
        String expectedData = "Text to check";

        String actualData = readTextFromPath(docxFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
