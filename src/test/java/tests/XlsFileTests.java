package tests;

import com.codeborne.xlstest.XLS;
import model.ReportRow;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.getXls;
import static utils.Files.readXlsxFromPath;
import static utils.Files.getIntegerPart;

public class XlsFileTests {
    @Test
    void xlsSimpleTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/report.xls";
        String expectedData = "Total cost";

        XLS xls = getXls(xlsFilePath);
        assertThat(xls, XLS.containsText(expectedData));
    }

    @Test
    void xlsReportRowTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/report.xls";
        XLS xls = getXls(xlsFilePath);

        ReportRow expectedRow1 = new ReportRow("10001", "Apples", "100");
        ReportRow expectedRow2 = new ReportRow("10002", "Tables", "200");

        ReportRow actualRow1 = new ReportRow(
                getIntegerPart(xls.excel.getSheetAt(0).getRow(1).getCell(0).toString()),
                xls.excel.getSheetAt(0).getRow(1).getCell(1).toString(),
                getIntegerPart(xls.excel.getSheetAt(0).getRow(1).getCell(2).toString()));

        ReportRow actualRow2 = new ReportRow(
                getIntegerPart(xls.excel.getSheetAt(0).getRow(2).getCell(0).toString()),
                xls.excel.getSheetAt(0).getRow(2).getCell(1).toString(),
                getIntegerPart(xls.excel.getSheetAt(0).getRow(2).getCell(2).toString()));

        assertThat(actualRow1, equalTo(expectedRow1));
        assertThat(actualRow2, equalTo(expectedRow2));
    }

    @Test
    void xlsxTest() {
        String xlsFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "Name 2";

        String actualData = readXlsxFromPath(xlsFilePath);
        assertThat(actualData, containsString(expectedData));
    }

    @Test
    void xlsxCellTest() throws IOException {
        String xlsFilePath = "./src/test/resources/files/1.xlsx";
        String expectedData = "Name 2";

        XLS xls = getXls(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(2).getCell(1).toString();

        assertThat(actualData, containsString(expectedData));
    }
}
