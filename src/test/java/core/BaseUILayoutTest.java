package core;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import constants.URLConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.LinkedList;
import java.util.List;

public class BaseUILayoutTest {

    protected WebDriver driver;
    protected LayoutReport layoutReport;

    @BeforeClass
    public void init() {
        //declaration and instantiation of Objects/variables
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        //triggers chrome to launch for directing it towards the base url
        driver.get(URLConstants.baseURL);
        //Maximize the browser window
        driver.manage().window().maximize();
    }



    @AfterClass
    public void tearDown() {
        //Close and Quit the driver.
        driver.quit();
    }
}
