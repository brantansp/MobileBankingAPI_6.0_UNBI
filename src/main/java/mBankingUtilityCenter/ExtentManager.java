package mBankingUtilityCenter;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;
import mBankingPageObjectModel.StaticStore;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
/**
 * 
 * @author brantansp
 *
 */
public class ExtentManager{
	
	public static ExtentReports extent;
	public static ExtentTest extentLogger;
	public static String response="";
	public static String transactionID = "";
	public static String resource = "";
	static HttpConnect obj=new HttpConnect();
	private static String dbResult[];
	public static WebDriver driver;
	//protected static Log log = LogFactory.getLog(ExtentManager.class);
	protected static Log log = LogFactory.getLog(MethodHandles.lookup().lookupClass().getSimpleName());
	public static Properties prop=getProperty();
	public static Properties resourceprop=getResourceProperty();
	
    static{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }
    
	@BeforeSuite
	public void setUp(){
      	log.info("Running Mobile banking API Automation testing on mPAY 4.0"+"\r\n");
			extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/ExtentReport/STMExtentReport.html", true);
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			prop =getProperty();
	}

	@BeforeMethod
	public void beforeMethod(Method method)
	{
		extentLogger = extent.startTest(this.getClass().getSimpleName()+ " ::  " +method.getName(), method.getName()); 
		extentLogger.assignAuthor("Brantan sp");
		extentLogger.assignCategory("Automation Testing");
		extentLogger.log( LogStatus.PASS, "Test started successfully");
	}
	
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			extentLogger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			extentLogger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}extent.endTest(extentLogger);
	}
	
	@AfterSuite
	public void endReport(){ 
                extent.flush();
                if(prop.getProperty("openReportInBrowser").equals("Y"))
                {
                	 //launchReport();
                }
    } 
	
	public static Properties getProperty()
	{
		prop=ExcelReader.getPropertyFromExcel("Data","InputData");
		return prop;
	}
	
	public static Properties getResourceProperty()
	{
		prop=ExcelReader.getPropertyFromExcel("Data","Resources");
		return prop;
	}
	
	public static void main(String[] args) {
		//launchReport();
		
		System.out.println(resourceprop.getProperty("ComplaintRegistration"));
	}
	
	public static void launchReport()
	{
		System.out.println("*******************");
		System.out.println("launching Report in browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driver\\chromedriver2.33.exe");
		driver = new ChromeDriver();
		System.setProperty("java.net.preferIPv4Stack", "true");
/*		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		driver.manage().window().maximize();
		driver.get(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\STMExtentReport.html");
		System.out.println("*******************");
	}
	
	public static void assertResponse(String response)
	{
		System.out.println("Came Here : " + response);
		
		assertTrue(response.substring(response.lastIndexOf("\"rsCode\":\""),response.lastIndexOf("\",\"rsMsg\"")).contains("000"));		
	}
	
	public static String sendReq (String Request, String txnType, String resource) throws IOException, SQLException
	{
		log.info("******************************START******************************");
	    log.info("Request : " + txnType);
	    //BigInteger uniNum = RandomNumGenerator.generate();

			response = HttpConnect.Post(Request, resource);
			log.info("Response received from Server : "+response);
/*     	if (response.contains("TXNID"))
			{
				transactionID= response.substring(response.lastIndexOf("TXNID:")+6, response.lastIndexOf("TXNID:")+18);
				log.info("Transaction ID : "+transactionID);
				if(prop.getProperty("dbReport")=="Y")
				{
					dbResult = dbTransactionlog.fetchRecord(transactionID);
					WriteToCSVFile.reportGeneration( dbResult);
				}		
			}*/
	log.info("******************************END********************************\r\n");
	return response;
	}
}



