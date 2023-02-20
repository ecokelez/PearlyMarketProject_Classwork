package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsUtils {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
   protected static ExtentTest extentTest;

    public static void extentReportsSetUp(String testerName, String testName) {
//      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
        String path = System.getProperty("user.dir") + "\\test-output\\reports\\" + testerName + "\\" + currentTime + ".html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//       *************************************RAPORU CUSTOMIZE EDEBILIRIZ*********************
        extentReports.setSystemInfo("Application", "PearlyMarketplace");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "team05");
        extentReports.setSystemInfo("Sprint No", "Sprint-1");
        extentReports.setSystemInfo("QA Name", testerName);
//        *********************************EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBILIRIZ****
        extentHtmlReporter.config().setDocumentTitle("Team05 Extent Reports");
//        ********************************RAPOR AYARLARI BITTI****************************
//        Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);
//        Extent Test objesi ni olustur
        extentTest = extentReports.createTest(testName, testName + " Report");
    }

    public static ExtentTest extentTest() {
        return extentTest;
    }

    public static void extentFlush() {
        extentReports.flush();
    }


}
