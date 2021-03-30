package tests;

import com.codeborne.selenide.Configuration;
import model.AgentProductivityReport;
import org.junit.jupiter.api.Test;
import utils.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DownloadFileTests {

    @Test
    void selenideDownloadReadmeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";

        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadedFile);

        assertThat(fileContent, containsString("Selenide = UI Testing Framework powered by Selenium WebDriver"));
    }

    @Test
    public void downloadDiabolocomCSVFile() throws IOException {
        Configuration.downloadsFolder = "downloads";
        Configuration.timeout = 60000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.startMaximized = true;
        Configuration.proxyEnabled = true;
        Configuration.fileDownload = PROXY;

        open("https://qa1.engage.diabolocom.com/app/login");
        $("[data-test-id='login-username-input']").setValue("elena_balakina_admin");
        $("[data-test-id='login-password-input']").setValue("Qwe1234_");
        $("[data-test-id='login-btn-submit']").click();
        $("[data-test-id='nav-link-statistics-reports'").click();
        $(".widget-filters-action-group i.btn-menu").click();

        File downloadedFile = $("[data-test-id='cld-export-csv-btn']").download();

        // TODO: parse into java object

        File csvFile = new File("./downloads/1617044711677_5952_15/agentProductivity.csv");
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line = "";
        AgentProductivityReport reportRow = new AgentProductivityReport();
        int k = 0;

        while ((line = br.readLine()) != null) {
            String[] valuesInLine = line.split(";");

            if (k == 1) {
                reportRow.setAgentName(valuesInLine[0]);
                reportRow.setContactsHandled(valuesInLine[1]);
                reportRow.setOutboundCalls(valuesInLine[2]);
                reportRow.setInboundCalls(valuesInLine[3]);
                reportRow.setFreeCalls(valuesInLine[4]);
                reportRow.setInboundEmails(valuesInLine[5]);
                reportRow.setOutboundEmails(valuesInLine[6]);
                break;
            }

            k++;
        }

        assertEquals(reportRow.getAgentName(), "agent_Balakina");
        assertEquals(reportRow.getContactsHandled(), "1");
        assertEquals(reportRow.getOutboundCalls(), "1");
    }
}
