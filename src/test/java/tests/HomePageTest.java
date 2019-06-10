package tests;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import constants.PageSpecs;
import core.BaseUILayoutTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HomePageTest extends BaseUILayoutTest {

    @Test
    public void checkLogoAndUtilityLinksVisiblity() throws IOException {
        //Executing Layout check and obtaining the Layout report
        layoutReport = Galen.checkLayout(driver, PageSpecs.COSTCO_TRAVEL_HOME, Arrays.asList("desktop"));
    }

    @AfterMethod
    public void reportUpdate() {
        try {
            //Creating a list of tests
            List<GalenTestInfo> tests = new LinkedList<>();
            //The object you create will be consisting the information regarding the test
            GalenTestInfo test = GalenTestInfo.fromString("Test Automation Using Galen Framework");
            //Adding layout report to the test report
            test.getReport().layout(layoutReport, "Verify logo present and log image comparison");
            tests.add(test);
            //Exporting all test report to html
            new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
