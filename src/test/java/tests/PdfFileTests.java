package tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Files.getPdf;

public class PdfFileTests {

    @Test
    void pdfTest() throws IOException {
        String pdfFilePath = "./src/test/resources/files/1.pdf";
        String expectedData = "autotests-cloud/qa_guru_5_6_files";

        PDF pdf = getPdf(pdfFilePath);
        assertThat(pdf, PDF.containsText(expectedData));
    }
}
