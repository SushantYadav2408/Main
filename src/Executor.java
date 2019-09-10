//package Dev;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import com.experitest.selenium.*;
import java.sql.*;
import java.util.Date;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.search.FlagTerm;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.time.DateUtils;

import com.experitest.client.Client;
import com.experitest.selenium.MobileWebDriver;
//import com.opera.core.systems.internal.input.KeyEvent;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;
//import com.testautomationguru.utility.CompareMode;
//import com.testautomationguru.utility.PDFUtil;
//import com.testautomationguru.utility.CompareMode;
//import com.testautomationguru.utility.PDFUtil;
import com.zeonpad.pdfcompare.ZPDFCompare;

public class Executor{
	public static Connection oConn;
	public static Statement oStmt;
	public Statement oStmt1, oStmt2, oStmt3;
	public ResultSet oRs;
	public static Boolean sElementFound=null;
	public static String sTextFilePath="",sPolicyNum="";
	public static String sPlanID, sReleaseID, sCycleID, sMultiFlag = "",flag="",
			sMultiE2EFlag = "", sArgs = "", sFailFlag = "", sCopyFilePATH ="",sIntegrationFlag="" ;
	public String sconnectionString, sPlanTestcaseId = "", sRCTCRunid = "0",
			sMaxRCTCRunid = "0", sPlanTestcaseStatus = "", sAutomationFunction,
			splanexecutiondate = "", sRCAutomationFunction, sRCTestcaseID = "",
			sRCScenarioId, sScenarioId, sTCID, sRCTCID, sSFStepKeyword,			
			sTableName, sPlanRelCyc, sScreenShotPath,sEmailSub,sAtsid="",sPolicy_No=""; //Sushant_Yadav 30 May 2019 Description:Create object to Append Policy No in integration table.
	public String sEmailDate="",sEmailSentTime="";  ////Sushant Yadav :21 Jun 2019 : Description: Script not passing proper Date and time for PDF comparison
	public String sOTPEmailDate="",sOTPEmailTime=""; //Sushant Yadav :19 Jun 2019 : Description: create object for ePayment debit card flow to read OTP sent Date and time
	public static String sFullScreenShotPath;
	public String sMachineId;
	public String sStatus = "";
	public String sOutput = "";
	public String sOutputpdf = "";
	public String sSTPStatus = "";
	public String sTempOutput = "";
	public String sExpectedResult;
	public String sRCExpectedResult;
	public String sDate;
	public String sSFStepsDesc;
	public String sDate1;
	public String sSFStepOR;
	public String sSFStepId;
	public String sKeywordName;
	public String sObjClass;
	public String sTestCaseDesc;
	public String sRCTestCaseDesc;
	public String sRunID;
	public String sCalcMethod;
	public String sValidationFunction;
	public String sExecutionTime;
	public String sTestDataTC = "";
	public String sRCTestDataTC = "";
	public String sRCExecutionTime;
	public String sBrowser;
	public String sScriptPath;
	public String sKey = "";
	public String sExecDate = "";
	public String sAppName = "";
	public String sProductName = "";
	public String sRound = "";
	public String sEnvName = "";
	public String parentWindowHandle = "";
	public String sLocalDBTableName = "";
	public String sid = "";
	public String sTestData = "";
	public String sActualCheck = "";
	public String IsDataUpdate = "";
	public String sExitSFFlag = "";
	public String sExitStatus = "";
	public String sUIName = "";
	public String sEnvType;
	public String sMaxDynamicWaitTime;
	public String sChromeDriver_Path;
	public String sIEDriver_Path;
	public String Driver_Path;
	public String ChromeDriver_Path;
	public String IEDriver_Path;
	public String sRCTCflowid = "0";
	public String sMobDeviceName = "";
	public String DataType;
	public String sModule;
	public String sSubModule;
	public String sRCModule;
	public String sRCSubModule;
	public String sUser;
	public String Source_Template_Name;
	public String Source_Keyword_Name;
	public String Destination_Mapped_Container;
	public String Destination_Mapped_Column;
	public String Destination_Mapped_RunID;
	public String sValoRsTCRunID;
	public String sValoRsAFUpdateColumn;
	public String sConnectionString;
	public String sObjProperty1 = "";
	public String sconnectionString1;
	public String sFlowID = "0";
	public String sFlowCode = "0";
	public String sFDTableName = "";
	public String sMasterFlowID = "";
	public String sFlowSFID = "";
	public String sFlowName = "";
	public String sMainSubModule = "";
	public String sMainModule = "";
	public String host = "localhost";
	public String sProjectName;
	public String sTestType;
	public String UIName;
	public static String AppUrl1 = "", AppURL = "",sScrenCnt="";
	public int iScreenNum, iTerminateInd, iRCTCTerminateInd, iRCInd,
	isFlowSelected = 0, iUpdateValue = 0, iExecuteQueryInd,
	iReturnValue, SubPopupActionInd, iTicket, port = 8889;
	public String[] oModule, oSubModule, oMobDeviceName, omodsubmod,
	sEnv_Test_type, Test_type;
	public static String sE2EFlag = "", sScreenFlag = "";
	public HashMap<String, String> oExcludePgMap = new HashMap<String, String>();
	public static HashMap<String, String> oGlobalMap = new HashMap<String, String>();
	public HashMap<String, String> oTestDataMap = new HashMap<String, String>();
	public WebElement oTestObject = null;
	public static String oTestObject1 = null;
	public String TestValue;
	public String sEmailFlag="";
	public List<WebElement> arrTestObjects = null;
	public Date oStartTime, oRCStartTime, oEndTime, oRCEndTime;
	static Logger logger;
	public static WebDriver oDriver;
	public static MobileWebDriver oDriver_Mob;
	public Client client = null;
	public String projectBaseDirectory = "C:\\Users\\Q4450\\workspace\\project3"; // "C:\\Users\\qksys\\workspace\\project4";
	public static Executor exc = new Executor();
	public static int Row_sSize = 0;

	public static void main(String[] args) {
		try {
			// Executor exc = new Executor();
			logger = Logger.getRootLogger();
			logger.setLevel(Level.INFO);
			logger.setAdditivity(false);
			logger.addAppender(new ConsoleAppender(new PatternLayout(
					"%d{ISO8601} [%t] %-5p %c %x - %m%n")));
			//PRC PRC for RPD MatRecap UAT policy
			//sArgs="TP000045`UATRound1`Iteration1.3`iPOS_ePolicy^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//PRC for Firestrome Developement SIT policy
			//sArgs="TP000041`SITRound1`Iteration1.1`QKMOB913^PropGen~ATS~SIT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//PRC for Firestrome Company Developement UAT policy
			 // sArgs="TP000041`UATRound2`Iteration1.1`QKMOB913^Lead Upload~Lead Upload~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//PRC for SIT policy
			 // sArgs="TP000034`SITRound1`Iteration1.1`iPOS_ePolicy^PropGen~ATS~SIT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			//BVT Framwork WLCI PAL Testing
			 //sArgs="TP000038`UATRound1`Iteration1.1`Q3643_iPad^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//PAL GIO JL
			//sArgs="TP000053`UATRound1`Iteration1.1`Q3643_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";			
			//PAL All-In-One 
			//sArgs="TP000053`SITRound2`Iteration1.3`Fir001_iPad^PropGen~ATS~SIT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";		
			//sArgs="TP000099`UATRound1`Iteration1.1`Fir001_iPad^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDF7V9B2S`Main`SEETEST`NA";
			//sArgs = args[0];
//			Rerun-All 39 Negative case - Iteration1.5			
		//	sArgs="TP000021`SITRound1`Iteration1.5`QKMOB913^PropGen~ATS~SIT`Admin`\\\\PALWDLC0LH8FJ\\QK\\Seema\\Seema\\UiPathFramework\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//WLCI BPLAC E2E farmwork Test 
			//sArgs="TP000030`UATRound2`Iteration1.1`iPOS_ePolicy^PropGen~ATS~UAT`Admin`\\\\PALWDLC0LH8FJ\\QK\\Seema\\Seema\\UiPathFramework\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
//						AIA Negative case - Iteration1.4
			//ePolicy Kit WLCI PAL 
			//sArgs="TP000009`UATRound1`Iteration2.3`E018859_iPscheduledwithdrawalad^PropGen~ATS~UAT`Admin`\\\\\\\\Palwdlc0lh8fj\\\\qk\\\\Philam_Execution\\\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";			
			//WLCI PAL E2E farmwork Test 			
			//sArgs="TP000035`UATRound1`Iteration1.1`QKMOB913^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//			Non-ECM Positive case - Iteration1.2			
			//sArgs="TP010012`UATRound1`Iteration1.2`iPad Air 2^PropGen~ATS~SIT`Admin`E:\\Swapnil\\Projects\\PhilamLife\\Dryrun\\Executor`E:\\Swapnil\\Projects\\PhilamLife\\Dryrun\\Screenshot`Server=192.168.1.15:port=1433:user=sa:password=quark@123:databaseName=qath_aiaphilamlife_dev`PALWDLC0LSLHG`Main`SEETEST`NA";			
			/*			ECM Positive case - Iteration1.1
			sArgs="TP010012`UATRound1`Iteration1.1`iPad Air 2^PropexGen~ATS~SIT`Admin`E:\\Swapnil\\Projects\\PhilamLife\\Dryrun\\Executor`E:\\Swapnil\\Projects\\PhilamLife\\Dryrun\\Screenshot`Server=192.168.1.15:port=1433:user=sa:password=quark@123:databaseName=qath_aiaphilamlife_dev`PALWDLC0LSLHG`Main`SEETEST`NA";
*/			
			//BVT for WLCI BPLAC 
			//For SIT
		//	sArgs="TP000030`SITRound1`Iteration1.2`iPOS_ePolicy^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//For UAT
			//sArgs="TP000030`UATRound2`Iteration1.3`iPOS_ePolicy^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//BVT for RPD MAtRecap
			//sArgs="TP000045`UATRound2`Iteration1.1`iPOS_ePolicy^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//sTextFilePath ="\\\\10.49.181.57\\qk\\Suyog\\IPOS_Enquiry\\ipos.txt";
            //BVT for WLCI CITI
			//sArgs="TP000038`SITRound1`Iteration1.1`iPOS_ePolicy^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";			
			//sArgs="TP000047`UATRound1`Iteration1.1`Q3643_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDF7V9B2S`Main`SEETEST`NA";
			//sArgs="TP000048`UATRound1`Iteration1.2`QKMOB913^PropGen~ATS~BVT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			
			//sArgs="TP000055`UATRound1`Iteration1.1`Q3643_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			//BPLAC ULP Express
			//sArgs="TP000054`UATRound1`Iteration1.1`Q3643_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			
			//BPLAC Joint Life
			sArgs="TP000054`UATRound2`Iteration1.1`Q3643_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			
			//LMS firestrome
			 //sArgs="TP000047`UATRound1`Iteration1.2`LMS_iPOS_ePolicy^LMS~Lead Creation~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			  // sArgs="TP000078`UATRound1`Iteration1.1`Fir001_iPad^New Business~E-Sumbission~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDLC0LH8FJ`Main`SEETEST`NA";
			 //sArgs="TP000047`UATRound2`Iteration1.1`LMS_iPOS_ePolicy^LMS~Lead Assign~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			//IPOS CITI 29/07/2019
			 //  sArgs="TP000052`UATRound1`Iteration1.1`QKMOB913^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDF7V9B2S`Main`SEETEST`NA";
			//  sArgs="TP000052`UATRound1`Iteration1.10`Q364()3_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			//sArgs="TP000052`UATRound1`Iteration1.11`QKMOB913^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			 //IPOS WLCI Negative testcase execuation
			 //sArgs="TP000055`UATRound1`Iteration1.10`Q3643_iPad^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			//IPOS WLCI CITI E2E 
			//sArgs="TP000052`UATRound1`Iteration1.11`QKMOB913^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			
			//CITI LAQ
			//sArgs="TP000052`UATRound1`Iteration1.1`QKMOB913^EApplication~Supplemenatry Form LAQ~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA";
			
			//sArgs="TP000100`UATRound1`Iteration1.1`iPOS_ePolicy^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=PALWDLC0LH8FJ:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife`PALWDDJX5SD2S`Main`SEETEST`NA";
			//sArgs = args[0];
			System.out.println("Arg = " +sArgs);
			exc.UserDetails("a", sArgs);
//			sArgs="TP010010`SITRound1`Cycle 2.0`Ipad Air2^New Business~Proposal Creation~SIT~Yes`Admin`E:\\Swapnil\\Projects\\PhilamLife\\Dryrun\\Executor`E:\\Swapnil\\Projects\\PhilamLife\\Dryrun\\Screenshot`Server=10.0.6.238:port=1433:user=sa:password=quark@123:databaseName=qath_philamlife`Machine1`Executor`SEETEST`NA`QATH";
//			exc.UserDetails("a", sArgs);	
            // sArgs = sArgs.replace("Selenium", "UFT");
//			 exc.UserDetails("a",args[0]);
			// sArgs = args[0].replace("Selenium" , "UFT");
			// exc.CloseApp();
			exc.ExecuteTest();
//			exc.logout();
			exc.closeapp();
			/*
			 * if (oDriver_Mob != null) {
			 * oDriver_Mob.application(AppUrl1).close(); } exc.oDriver.quit();
			 */
			// exc.oDriver.close();

			if (oConn.isClosed() == true) {
				exc.connect();
			}
			ResultSet oRSQueryPS;
			String sQy = "select count(*) As Col from qath_testplan_executor where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and planstatus = 'Fail'";
			logger.info("sQuery=" + sQy);
			oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			oRSQueryPS = oStmt.executeQuery(sQy);
			String sCnt = "";
			if (oRSQueryPS.next()) {
				sCnt = oRSQueryPS.getString("Col");
			}
			oRSQueryPS.close();
			if (!(sMultiE2EFlag.equalsIgnoreCase("yes"))) {
				// JOptionPane.showMessageDialog(null,
				// "Execution Completed","InfoBox",
				// JOptionPane.INFORMATION_MESSAGE);
				Close_popup();
			}
			if (sCnt.equalsIgnoreCase("0")) {
					System.exit(0);
			} else {
				System.exit(1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void connect() {
		logger.info("Inside Connect");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			.newInstance();
			// String connectionString =
			// "jdbc:sqlserver://qknbk237:1433;user=sa;password=quark@123;databaseName=qath_maxlife";
			// sconnectionString1 =
			// ("Server=10.0.6.244:1433:UserID=sa:password=quark@123:databseName=qath_maxlife ");
			String[] oSonnectionString = sconnectionString1.split(":");
			sConnectionString = "jdbc:sqlserver://"
					+ oSonnectionString[0].split("=")[1] + ":"
					+ oSonnectionString[1].split("=")[1] + ";"
					+ oSonnectionString[2] + ";" + oSonnectionString[3] + ";"
					+ oSonnectionString[4];
			// sConnectionString =
			// "jdbc:sqlserver://qknbk237:1433;user=sa;password=quark@123;databaseName=qth_UNOMaxlife";
			logger.info("connectionString=" + sConnectionString);
			oConn = DriverManager.getConnection(sConnectionString);
			logger.info("Connected to Database Successfully");
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {
			}
		}
	}

	public void updateemailflag() {
		logger.info("Inside Flag");
		logger.info("Email Flag = " +sEmailFlag);
		if(iReturnValue != 1){
		try {
			if (sEmailFlag.equalsIgnoreCase("")) {
				sEmailFlag = "Y";
			}
		}catch(Exception e){
			logger.info("Exception = "+e.getMessage());
		}
		}
	}
	
	public void updateemailparm() {
		logger.info("Inside updateemailparm");
		
		 // Sushant Yadav : Script not passing proper Date and time for PDF comparison.
		/*Date sEmailTime = new Date();
		Date oDateTemp = new Date(sEmailTime.getTime());
		SimpleDateFormat oDF = new SimpleDateFormat("hh.mm aa");
		//oDF.setTimeZone(TimeZone.getTimeZone("UTC"));
*/		
		if (sEmailFlag.equalsIgnoreCase("")) {
			sEmailFlag ="N";
		}
		try {
			
			oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sQuery = "select * from "+sTableName+" where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and test_case = '"
					+ sPlanTestcaseId
					+ "'";
			
			logger.info(sQuery);
			String sPsd = "",emailid="",sInsuredFN ="",ssInsuredDOB="",sDOB_D="",sDOB_M="",sDOB_Y="",sPDFPWD="" ;
			ResultSet oRSQuery = oStmt
					.executeQuery(sQuery);
			if (oRSQuery.next()) {
//				sPsd = oRSQuery.getString("emailpdfpassword");
				emailid = oRSQuery.getString("emailto");
				sInsuredFN = oRSQuery.getString("firstname_life_insured");
				ssInsuredDOB = oRSQuery.getString("dob_life_insured");
			}
			sInsuredFN = sInsuredFN.substring(0, 2).toUpperCase();
			sDOB_D = ssInsuredDOB.substring(0, 2);
			sDOB_M = ssInsuredDOB.substring(2, 4);
			sDOB_Y = ssInsuredDOB.substring(4, 8);
			
			sPDFPWD = sInsuredFN+sDOB_M+sDOB_D+sDOB_Y;
			
			logger.info("ATS ID = " +sAtsid);
			
//			sEmailSub = " PDF Password : " + sPDFPWD + "_" + sEmailSub;
			
			logger.info(("delete from qath_email_params where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and MainTestCaseID = '"
					+ sPlanTestcaseId
				    + "'"));
			oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			oStmt.executeUpdate("delete from qath_email_params where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and MainTestCaseID = '"
					+ sPlanTestcaseId
				    + "'");
			
			oStmt = oConn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
	if (sPlanID.contains("TP")) {
			logger.info("sQuery="
					+ "insert into qath_email_params (planid,planreleaseid,plancycleid,maintestcaseid,testcaseid,device,emailid,emailSubject,emailpdfpassword,emaildate,emailtime,emailtriggerflag,emaildownloadflag,compareflag,pdfpath,ats_id"// RunID
					+ ") Values" + "('"
					+ sPlanID
					+ "','"
					+ sReleaseID
					+ "','"
					+ sCycleID
					+ "','"
					+ sPlanTestcaseId
					+ "','"
					+ ""
					+ "','"
					+ sMobDeviceName
					+ "','"
					+ emailid
					+ "','"
					+ sEmailSub
					+ "','"
					+ sPDFPWD
					+ "','"
					+ sEmailDate
					+ "','"
					+ sEmailSentTime
					+ "','"
					+ sEmailFlag
					+ "','"
					+ ""
					+ "','"
					+ ""
					+ "','"
					+ sFullScreenShotPath
					+"','"
					+sAtsid
				    + "')");
			oStmt.executeUpdate("insert into qath_email_params (planid,planreleaseid,plancycleid,maintestcaseid,testcaseid,device,emailid,emailSubject,emailpdfpassword,emaildate,emailtime,emailtriggerflag,emaildownloadflag,compareflag,pdfpath,ats_id"// RunID
					+ ") Values" + "('"
					+ sPlanID
					+ "','"
					+ sReleaseID
					+ "','"
					+ sCycleID
					+ "','"
					+ sPlanTestcaseId
					+ "','"
					+ ""
					+ "','"
					+ sMobDeviceName
					+ "','"
					+ emailid
					+ "','"
					+ sEmailSub
					+ "','"
					+ sPDFPWD
					+ "','"
					+ sEmailDate
					+ "','"
					+ sEmailSentTime
					+ "','"
					+ sEmailFlag
					+ "','"
					+ ""
					+ "','"
					+ ""
					+ "','"
					+ sFullScreenShotPath
					+"','"
					+sAtsid
				    + "')");
				}else if(sPlanID.contains("STP")) {
					logger.info("sQuery="
							+ "insert into qath_email_params (planid,planreleaseid,plancycleid,maintestcaseid,testcaseid,device,emailid,emailSubject,emailpdfpassword,emaildate,emailtime,emailtriggerflag,emaildownloadflag,compareflag,pdfpath"// RunID
							+ ") Values" + "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ emailid
							+ "','"
							+ sEmailSub
							+ "','"
							+ sPDFPWD
							+ "','"
							+ sEmailDate
							+ "','"
							+ sEmailSentTime
							+ "','"
							+ sEmailFlag
							+ "','"
							+ ""
							+ "','"
							+ ""
							+ "','"
							+ sFullScreenShotPath
						    + "')");
					oStmt.executeUpdate("insert into qath_email_params (planid,planreleaseid,plancycleid,maintestcaseid,testcaseid,device,emailid,emailSubject,emailpdfpassword,emaildate,emailtime,emailtriggerflag,emaildownloadflag,compareflag,pdfpath"// RunID
							+ ") Values" + "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ emailid
							+ "','"
							+ sEmailSub
							+ "','"
							+ sPDFPWD
							+ "','"
							+ sEmailDate
							+ "','"
							+ sEmailSentTime
							+ "','"
							+ sEmailFlag
							+ "','"
							+ ""
							+ "','"
							+ ""
							+ "','"
							+ sFullScreenShotPath
						    + "')");
				}
			
		}catch(Exception e){
			logger.info("Exception = "+e.getMessage());
		}
	}
	
	public void disconnect() {
		logger.info("Inside  Disconnect");
		try {
			if (oStmt != null) {
				oStmt.close();
			}
			if (oConn != null) {
				oConn.close();
			}
			if (oRs != null) {
				oRs.close();
			}
			logger.info("Database Disconnected  Successfully");
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public ResultSet executequery(String sQuery) {
		iExecuteQueryInd = 0;
		logger.info(" InsideExecute Query");
		try {
			if (oConn.isClosed() == true) {
				connect();
			}
			String sSQLQuery = getsqlquery(sQuery);
			logger.info(sSQLQuery);
			if (sSQLQuery.startsWith("select")) {
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY,
						ResultSet.HOLD_CURSORS_OVER_COMMIT);
				oRs = oStmt.executeQuery(sSQLQuery);
				if (oRs.next()) {
					oRs.beforeFirst();
				} else {
					iExecuteQueryInd = 1;
				}
				if (sQuery.toUpperCase().equals("ACTUALDATA")
						|| sQuery.toUpperCase().equals("RCACTUALDATA")) {
					ResultSetMetaData oMetaData = oRs.getMetaData();
					int iColumnCount = oMetaData.getColumnCount();
					while (oRs.next()) {
						for (int iColumn = 1; iColumnCount >= iColumn; iColumn = iColumn + 1) {
							oGlobalMap.put(oMetaData.getColumnName(iColumn)
									.toLowerCase(), oRs.getString(oMetaData
											.getColumnName(iColumn)));
							logger.info(oMetaData.getColumnName(iColumn)
									.toLowerCase()
									+ "="
									+ oRs.getString(oMetaData
											.getColumnName(iColumn)));
						}
					}
				}
			} else {
				oStmt.executeUpdate(sSQLQuery);
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return oRs;
	}

	public int callsf() {
		logger.info("Inside CallSf");
		String sTempStepKeyword = sFullScreenShotPath;
		try {
			String[] oArrFields = sSFStepKeyword.split(";;");
			for (int iArrFields = 0; oArrFields.length > iArrFields; iArrFields = iArrFields + 1) {
				logger.info("Object Name=" + oArrFields[iArrFields]);
			String sTempAutomationFunction = sAutomationFunction;
			sAutomationFunction =oArrFields[iArrFields];
			ResultSet oRsSF = executequery("STEPFUNMASTR");
			/*if(sSFStepKeyword.contains("SFIPOS003"))
			{
				sFullScreenShotPath=sTempStepKeyword;
				sFullScreenShotPath=sFullScreenShotPath+"\\"+"CFF";
			}
			else if(sSFStepKeyword.contains("SFIPOS004"))
			{
				sFullScreenShotPath=sTempStepKeyword;
				sFullScreenShotPath=sFullScreenShotPath+"\\"+"SQS";
			}
			else if(sSFStepKeyword.contains("SFIPOS005"))
			{
				sFullScreenShotPath=sTempStepKeyword;
				sFullScreenShotPath=sFullScreenShotPath+"\\"+"EAPP";
			}
			else if(sSFStepKeyword.contains("SFIPOS006"))
			{
				sFullScreenShotPath=sTempStepKeyword;
				sFullScreenShotPath=sFullScreenShotPath+"\\"+"Review and Sign";
			}
			else if(sSFStepKeyword.contains("SFIPOS008"))
			{
				sFullScreenShotPath=sTempStepKeyword;
				sFullScreenShotPath=sFullScreenShotPath+"\\"+"Payment";
			}*/
			sAutomationFunction = sTempAutomationFunction;
			while (oRsSF.next()) {
				sSFStepsDesc = oRsSF.getString("SF_StepsDesc");
				sSFStepKeyword = oRsSF.getString("SF_StepKeyword");
				sSFStepOR = oRsSF.getString("SF_StepOR");
				sSFStepId = oRsSF.getString("SF_StepID");
				if (sSFStepId.equalsIgnoreCase("SF_Fir_ATS_BPLAC-0118")) {
					logger.info("stop");
				}
				logger.info("sSFStepsDesc=" + sSFStepsDesc + ",sSFStepKeyword="
						+ sSFStepKeyword + ",sSFStepOR=" + sSFStepOR
						+ ",sSFStepId=" + sSFStepId);
				// Seema : 10 Nov changed as FunctionCall was called twice,
				// instead of once
				DataType = "ACTUALDATA";
				if (sPlanID.startsWith("STP")) {
					DataType = "RCACTUALDATA";
				}
				FunctionCall();
				if (iReturnValue != 0) {
					sTempStepKeyword = sSFStepKeyword;
					sSFStepKeyword = "";
					screens();
					sSFStepKeyword = sTempStepKeyword;
					sStatus = "Fail";
					// sOutput = "Testcase failed due to the error | " +
					// sOutput;
					iReturnValue = 0;
					iRCTCTerminateInd = 1;
					closeapp();
					break;
				}
			}
		}
		}catch (Exception e) {
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int exitsf() {
		logger.info("Inside ExitSf");
		String sTempStepKeyword = "";
		try {
			// Seema : 8 Nov 17 : To handle whether proceed or stop, if exit
			// condition fails
			if (sStatus.equalsIgnoreCase("fail")) {
				sExitStatus = "Fail";
				if (sSFStepKeyword.equalsIgnoreCase("continue")) {
					iReturnValue = 0;
					iRCTCTerminateInd = 0;
					// iTerminateInd = 0;
				} else {
					sExitSFFlag = "Yes";
				}
			} else {
				sExitSFFlag = "Yes";
			}
		} catch (Exception e) {
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (Exception e1) {
			}
		}
		return iReturnValue;
	}

	public String getsqlquery(String sQuery) {
		logger.info("Inside getSQLQuery");
		String sSQLQuery = "";
		try {
			switch (sQuery.toUpperCase()) {
			case "TESTCASE":
				// Modified by Seema 1st Apr17 : To fetch exact planstatus for
				// end to end resume from failed step feature
				sSQLQuery = "select plantestcaseid, planstatus,planexecutiondate from qath_testplan_executor where planmodule = '"
						+ sModule
						+ "'  and plansubmodule = '"
						+ sSubModule
						+ "' and planusername = '"
						+ sUser
						+ "' and planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and planstatus in ('Yet to Begin','Terminated') and device = '"
						+ sMobDeviceName
						+ "'  order by plantestcaseid";
				break;
			case "FLOWDEFINITION":
				// Modified by Seema 29Jun17 : To fetch Flow Defined by User as
				// part of Test Data
				sSQLQuery = "select * from Flow_Master where Master_Flow_ID = '"
						+ sAutomationFunction + "'";
				break;
			case "FLOWDEFTABLE":
				// Modified by Seema 29Jun17 : To fetch Flow Defined by User as
				// part of Test Data
				sSQLQuery = "select * from " + sFDTableName
				+ " where planid = '" + sPlanID
				+ "' and planreleaseid = '" + sReleaseID
				+ "' and plancycleid = '" + sCycleID
				+ "'  and test_case = '" + sPlanTestcaseId + "'";
				break;
			case "FLOWDETAILS":
				// Modified by Seema 29Jun17 : To fetch Flow master
				sSQLQuery = "select * from flow_details where master_flow_id = '"
						+ sAutomationFunction + "' order by Flow_ID";
				break;
			case "MAIN":
				if (sPlanID.contains("STP")) {
					// sSQLQuery =
					// "select expectedresult,  steps, automationfunction, testData, scenarioid, TCID , TestCaseDesc,validationfunction,module, submodule from qath_service_test_case where Module = '"
					// + sModule + "'  and SubModule = '" + sSubModule +
					// "'and testcaseid = '" + sPlanTestcaseId + "'";
					// modified by latha 13Feb18: to fetch the testcase details,
					// field names are changed
					sSQLQuery = "select expectedresult,automationfunction, testData, scenarioid,testcaseid,TestCaseDesc,validationfunction,module, submodule from qath_service_test_case where Module = '"
							+ sModule
							+ "'  and SubModule = '"
							+ sSubModule
							+ "'and testcaseid = '" + sPlanTestcaseId + "'";
				} else {
					// sSQLQuery =
					// "select expectedresult,  steps, automationfunction, testData, scenarioid, TCID , TestCaseDesc,validationfunction,calcmethod from test_case where Module = '"
					// + sModule + "'  and SubModule = '" + sSubModule +
					// "'and testcaseid = '" + sPlanTestcaseId + "'";
					// modified by latha 13Feb18: to fetch the testcase details,
					// field names are changed
					sSQLQuery = "select expectedresult, automationfunction, testData, scenarioid,testcaseid, TestCaseDesc,validationfunction,calcmethod from test_case where Module = '"
							+ sModule
							+ "'  and SubModule = '"
							+ sSubModule
							+ "'and testcaseid = '" + sPlanTestcaseId + "'";
				}
				break;
			case "STEPFUNMASTR":
				sSQLQuery = "select * from qtp_stepfunction_master where SF_Name = '"
						+ sAutomationFunction + "' Order By SF_StepID ASC"; //and (SF_StepID<'SF_ATS_CITI-0009' or SF_StepID> 'SF_ATS_CITI-0086')
				break;
			case "RUNCHART":
				if(sE2EFlag.equalsIgnoreCase("Y")){
					// sSQLQuery =
					// "select nbtestcaseid , RunID, servicingmodule, nbsubmodule from qath_service_runchart_tc_mapping where RunChartID = '"
					// + sAutomationFunction + "' And servicingtexeestcaseid = '" +
					// sPlanTestcaseId + "' Order By RunID";
						sSQLQuery = "select nbtestcaseid , RunID, servicingmodule, nbsubmodule ,screenshotflag from qath_service_runchart_tc_mapping where RunChartID = '"
							+ sAutomationFunction + "' And nbtestcaseid = '" + sRCTestcaseID + "' And servicingtestcaseid = '" + sPlanTestcaseId + "' and runid >= '"
							+ sRCTCRunid + "' Order By RunID";
					}else{
						sSQLQuery = "select nbtestcaseid , RunID, servicingmodule, nbsubmodule, screenshotflag from qath_service_runchart_tc_mapping where RunChartID = '"
								+ sAutomationFunction + "' And servicingtestcaseid = '" + sPlanTestcaseId + "' and runid >= '"
								+ sRCTCRunid + "' Order By RunID";
					}
					break;
			case "RCMAIN":
				sSQLQuery = "select Module As RCDrivenModule,  SubModule As RCDrivenSubModule , expectedresult As RCexpectedresult,  Steps As RCSteps, automationfunction As RCautomationfunction, TestData As RCTestData, scenarioid As RCscenarioid, TCID As RCTCID , TestCaseDesc As RCTestCaseDesc , calcmethod As RCCalcMethod, validationfunction As RCValidationFunction From test_case where testcaseid = '"
						+ sRCTestcaseID + "'";
				break;
			case "RCSTEPFUNMASTR":
				sSQLQuery = "select * from QTP_stepfunction_master where SF_Name = '"
						+ sRCAutomationFunction + "' Order By SF_StepID";
				break;
			case "ACTUALDATA":
				if (!(sAutomationFunction.toLowerCase().contains("flow"))) {
					sSQLQuery = "select * from " + sSFStepKeyword
							+ " where Test_Case = '" + sPlanTestcaseId
							+ "' and planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID + "'";
				} else {
					sSQLQuery = "select * from " + sSFStepKeyword
							+ " where Test_Case = '" + sPlanTestcaseId
							+ "' and planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and flow_code = '" + sFlowCode + "'";
				}
				sTableName = sSFStepKeyword;
				break;
			case "RCACTUALDATA":
				sSQLQuery = "select * from " + sSFStepKeyword
				+ " where planid = '" + sPlanID
				+ "' and planreleaseid = '" + sReleaseID
				+ "' and plancycleid = '" + sCycleID
				+ "' and Test_Case_Ser = '" + sRCTestcaseID
				+ "' and Test_Case = '" + sPlanTestcaseId + "'";
				sTableName = sSFStepKeyword;
				break;
			case "OR":
				sSQLQuery = "select * From [qath_or_mapping] where OR_Module = '"
						+ sSFStepOR
						+ "' And Object_Name = '"
						+ sKeywordName
						+ "'";
				break;
			case "ORMOB":
				sSQLQuery = "select * From [qath_or_mapping] where OR_Module = '"
						+ sSFStepOR
						+ "' And Object_Name = '"
						+ sKeywordName
						+ "' and UI_Name <> ''";
				break;
			case "MEMBERINFO":
				sSQLQuery = "select * from EAPPS_SForm_Manfaat_Rumah_Sakit where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and Test_Case_Ser = '"
						+ sRCTestcaseID
						+ "' and Test_Case = '" + sPlanTestcaseId + "'";
				break;
			case "CLASSCODE":
				sSQLQuery = "select * from EAPPS_Data_Coverage_Data where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and Test_Case_Ser = '"
						+ sRCTestcaseID
						+ "' and Test_Case = '" + sPlanTestcaseId + "'";
				break;
			case "CLNTDETAIL":
				sSQLQuery = "select * from EAPPS_Client_Data where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and test_case = '" + sPlanTestcaseId + "'";
				break;
			case "ENVIRONMENT":
				if (sPlanID.contains("STP")) {
					sSQLQuery = "select * from qath_service_testplan_scheduler where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "' and plancycleid like '"
							+ sCycleID
							+ "' and planmodule = '"
							+ sModule
							+ "' and plansubmodule = '" + sSubModule + "'";
				} else {
					sSQLQuery = "select * from qath_testplan_scheduler where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "' and plancycleid like '"
							+ sCycleID
							+ "' and planmodule = '"
							+ sModule
							+ "' and plansubmodule = '" + sSubModule + "'";
				}
				break;
			case "EAPPS_STATUS":
				sSQLQuery = "select * from EAPPS_Client_Data where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and test_case = '" + sPlanTestcaseId + "'";
				break;
			case "RCTCRESULT":
				sSQLQuery = "select * from QTP_RC_TC_Results where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and maintestcaseid = '" + sPlanTestcaseId
						+ "' and TestCaseID = '" + sRCTestcaseID
						+ "' and device = '" + sMobDeviceName + "'";
				break;
				// AF_mapping
			case "AFKEYWORDMAPPING":
				if (!(sAutomationFunction.toLowerCase().contains("flow"))) {
					sSQLQuery = "select * from AF_Keyword_Mapping where Keyword_RunID ='"
							+ sRunID
							+ "' and RunchartID ='"
							+ sAutomationFunction + "' ";
				} else {
					sSQLQuery = "select * from AF_Keyword_Mapping where Keyword_RunID ='"
							+ sFlowCode
							+ "' and RunchartID ='"
							+ sAutomationFunction + "' ";
				}
				break;
				// AF_mapping
			}
			logger.info("sSQLQuery=" + sSQLQuery);
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			}

			catch (Exception e1) {

			}
		}
		return sSQLQuery;

	}

	public void createtxt() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String sExcelFilePath = "";
		logger.info("Inside Createtxt");
		try {
			ResultSet oRSQueryPS;
			logger.info("sQuery="
					+ "select value from parameter_setup where parameter = 'File_Path'");
			oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			oRSQueryPS = oStmt
					.executeQuery("select value from parameter_setup where parameter = 'File_Path'");
			if (oRSQueryPS.next()) {
				sExcelFilePath = oRSQueryPS.getString("value");
			}
			oRSQueryPS.close();
			File file = new File(sExcelFilePath + "/UFT_" + sMachineId + ".txt");
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
				file.delete();
				file.createNewFile();
			}
			String content = sArgs + "`" + sPlanTestcaseId; // "This is the content to write into file1";
			fw = new FileWriter(sExcelFilePath + "/UFT_" + sMachineId + ".txt");
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void launchvbs() {
		String sExcelFilePath = "";
		try {
			ResultSet oRSQueryPS;
			String sQry = "select value from parameter_setup where parameter = 'File_Path'";
			logger.info("sQuery=" + sQry);
			oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			oRSQueryPS = oStmt.executeQuery(sQry);
			if (oRSQueryPS.next()) {
				sExcelFilePath = oRSQueryPS.getString("value");
			}
			oRSQueryPS.close();
			String cmdArr[] = { "cscript",
					sExcelFilePath + "\\UFT_Executor_" + sMachineId + ".vbs" };
			Runtime.getRuntime().exec(cmdArr);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitforpageload() {
		logger.info("Inside PageLoad");
		try {
			int iWaitTime = 0;
			while (true) {
				try {
					if (oDriver != null) {
						logger.info("ReadyState="
								+ ((JavascriptExecutor) oDriver).executeScript(
										"return document.readyState")
										.toString());
						if (((JavascriptExecutor) oDriver).executeScript(
								"return document.readyState")
								.equals("complete")) {
							break;
						} else {
							Thread.sleep(1000);
							iWaitTime = iWaitTime + 1;
							if (iWaitTime > 30) {
								throw new Exception(
										"Timeout Error while Page Load "
												+ sSFStepKeyword.split(":")[0]);
							}
						}
					} else {
						break;
					}
				} catch (UnhandledAlertException e) {
					logger.error("Skipped alert : " + e.getAlertText());
					break;
				}
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public void closeapp() {

		logger.info("Inside CloseApp");
		try {
			// SessionId sSessionId = null;
			/*
			 * try { sSessionId = ((MobileWebDriver)
			 * oDriver_Mob).getSessionId(); } catch (Exception e) { }
			 */
			try {
				if (oDriver_Mob != null) {
					// oDriver_Mob.application("com.aia.myipos.dev").close();
					// oDriver_Mob.client.closeDeviceReflection();

					// oDriver_Mob.close();
					// oDriver_Mob.releaseClient();
					// oDriver_Mob.quit();
				} else if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
					if (oDriver_Mob != null) {
						oDriver_Mob.application(AppUrl1).close();
						// oDriver.quit();
					}

				}
			} catch (Exception Ex) {
				System.out.println(Ex.getMessage());
			}
			// else if(sBrowser.equals("IE")){
			// Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			// Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			// }
			// else if(sBrowser.equals("Chrome")){
			// Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			// Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			// }
			// else{
			// Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			// }
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public void UserDetails(String sEnv, String sPRCDetails) {
		System.out.println("Inside    UserDetails");
		System.out.println("sPRCDetails : " + sPRCDetails);
		try {
			String[] oPRCDetails = sPRCDetails.split("`");
			System.out.println("oPRCDetails : " + oPRCDetails.length);
			sconnectionString1 = oPRCDetails[7];
			System.out.println(sconnectionString1);
			connect();
			switch (sEnv.toUpperCase()) {
			case "A":
				sPlanID = oPRCDetails[0];
				sReleaseID = oPRCDetails[1];
				sCycleID = oPRCDetails[2];
				sUser = oPRCDetails[4];
				sScreenShotPath = oPRCDetails[6].trim();
				sMachineId = oPRCDetails[8];
				sScriptPath = oPRCDetails[5];
				sBrowser = oPRCDetails[11];
//				sProjectName = oPRCDetails[12];
				String[] oModuleDetails = oPRCDetails[3].split("\\*");
				oMobDeviceName = new String[oModuleDetails.length];
				omodsubmod = new String[oModuleDetails.length];
				System.out.println("s");

				for (int i = 0; oModuleDetails.length > i; i = i + 1) {
					String[] oTemp = oModuleDetails[i].split("\\^");
					oMobDeviceName[i] = oTemp[0];
					omodsubmod[i] = oTemp[1];
				}
				sEnv_Test_type = omodsubmod[0].split("~");
				Test_type = sEnv_Test_type[2].split("#");
				sTestType = Test_type[0];
				sPlanRelCyc = sPlanID + "_" + sReleaseID + "_" + sCycleID;
				iScreenNum = 1;
				iTerminateInd = 0;
				iRCTCTerminateInd = 0;
				iRCInd = 0;
				iExecuteQueryInd = 0;
				// Swapnil Parab updated on 21-08-2017
				// FolderCreate();
				// logger.addAppender(new RollingFileAppender(new PatternLayout(
				// "%d{ISO8601} [%t] %-5p %c %x - %m%n"), sScreenShotPath
				// + "\\Logs1\\" + sMachineId + ".log"));
				logger.info("Inside  User Details");
				logger.info("Log file path : " + sScreenShotPath + "\\Logs1\\"
						+ sMachineId + ".log");
				logger.info("User Details:  sPlanID=" + sPlanID
						+ ",sReleaseID=" + sReleaseID + ",sCycleID=" + sCycleID
						+ ",sUser=" + sUser + ",sScreenShotPath="
						+ sScreenShotPath + ",sMachineId=" + sMachineId);
				break;
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
				logger.error("Invalid launch string");
				e.printStackTrace();
			} catch (Exception e1) {

			}
		}
	}

	public void ExecuteTest() {
		logger.info("Inside ExecuteTest");
		try {
			int flag = 0;
			for (int i = 0; omodsubmod.length > i; i = i + 1) {
				String[] allmodsubmodArr = omodsubmod[i].split("#");
				// sLoginFlag = 0;
				if (flag != 0) {
					exc.logout();
				}
				for (int ims = 0; allmodsubmodArr.length > ims; ims = ims + 1) {

					String[] modsubmodArr = allmodsubmodArr[ims].split("~");
					sModule = modsubmodArr[0];
					sSubModule = modsubmodArr[1];
					sMobDeviceName = oMobDeviceName[i];
//					sScreenFlag=modsubmodArr[3];
					logger.info("sModule=" + sModule + ",sSubModule="
							+ sSubModule + ",sMobDeviceName=" + sMobDeviceName);
					connect();
					// Fetch Max Dynamic Wait Time. If paramter does not exist,
					// max time will be 5 mins
					ResultSet oRSQueryPS;
					String sMDTQry = "select value from parameter_setup where parameter = 'MaxDynamicWaitTime'";
					logger.info("sQuery=" + sMDTQry);
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					oRSQueryPS = oStmt.executeQuery(sMDTQry);
					if (oRSQueryPS.next()) {
						sMaxDynamicWaitTime = oRSQueryPS.getString("value");
					} else {
						sMaxDynamicWaitTime = "300";
					}
					oRSQueryPS.close();
					ResultSet oRSTestCaseID = executequery("TESTCASE");
					if (iExecuteQueryInd == 1) {
  						iExecuteQueryInd = 0;
						sStatus = "Fail";
						sOutput = "No TestCase  Is Selected For Execution";
						logger.error(sOutput);
					} else {
						ArrayList<String> oArrTestCaseID = new ArrayList<String>();
						// Modified by Seema 1st Apr17 : To fetch exact
						// planstatus for end to end resume from failed step
						// feature
						ArrayList<String> oArrTestCaseStatus = new ArrayList<String>();
						ArrayList<String> oArrTestCaseExecutiondate = new ArrayList<String>(); // 19th
						// April
						// Varsha
						while (oRSTestCaseID.next()) {
							oArrTestCaseID.add(oRSTestCaseID
									.getString("plantestcaseid"));
							// Modified by Seema 1st Apr17 : To fetch exact
							// planstatus for end to end resume from failed step
							// feature
							oArrTestCaseStatus.add(oRSTestCaseID
									.getString("planstatus"));
							oArrTestCaseExecutiondate.add(oRSTestCaseID
									.getString("planexecutiondate"));// 19th
							// April
							// Varsha
						}
						disconnect();

						if (flag == 0) {
							if (!sMobDeviceName.equalsIgnoreCase("desktop")) {
								sSFStepKeyword = "";
								connect();
								navigateurl();
								flag = 1;
							}
						}

						for (int iTestCase = 0; oArrTestCaseID.size() > iTestCase; iTestCase = iTestCase + 1) {
							// while(oRSTestCaseID.next()){
							connect();

							oStartTime = new Date();

							// sPlanTestcaseId =
							// oRSTestCaseID.getString("plantestcaseid");
							sPlanTestcaseId = oArrTestCaseID.get(iTestCase);
							sPlanTestcaseStatus = oArrTestCaseStatus
									.get(iTestCase);
							splanexecutiondate = oArrTestCaseExecutiondate
									.get(iTestCase);// 19th April Varsha
							logger.info("sPlanTestcaseId = " + sPlanTestcaseId
									+ ", sPlanTestcaseStatus = "
									+ sPlanTestcaseStatus
									+ ", splanexecutiondate = "
									+ splanexecutiondate);// 19th April Varsha
							iTerminateInd = 0;
							iRCTCTerminateInd = 0;
							iScreenNum = 1;
							ResultSet oRSMain = executequery("MAIN");
							if (iExecuteQueryInd == 1) {
								iExecuteQueryInd = 0;
								sStatus = "Fail";
								sOutput = "Selected TestCase Is Not There In Database";
								sExpectedResult = "";
							} else {
								// Modified by Seema 1st Apr17 : to club it with
								// below if condition, as same condition is not
								// required multiple times deleted old code of
								// deleting output tables
								oRSMain.first();
								sTestDataTC = "";
								sAutomationFunction = oRSMain
										.getString("automationfunction");
								sExpectedResult = oRSMain
										.getString("expectedresult");
								sScenarioId = oRSMain.getString("scenarioid");
								sTCID = oRSMain.getString("testcaseid");
								sTestCaseDesc = oRSMain
										.getString("TestCaseDesc");
								sValidationFunction = oRSMain
										.getString("validationfunction");
								sTestDataTC = oRSMain.getString("testdata");
								// Modified by Seema on 29 Jun17 : Flow ID
								// approach
								sMainModule = sModule; // oRSMain.getString("module");
								sMainSubModule = sSubModule; // oRSMain.getString("submodule");
								oStmt = oConn.createStatement(
										ResultSet.TYPE_SCROLL_INSENSITIVE,
										ResultSet.CONCUR_READ_ONLY);
								oStmt.executeUpdate("update qath_testplan_executor set testdata = '' "
										+ "where planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and planmodule = '"
										+ sModule
										+ "' and plansubmodule = '"
										+ sSubModule
										+ "' and plantestcaseid = '"
										+ sPlanTestcaseId + "'");
								if (sPlanID.startsWith("STP")) {
									sCalcMethod = "";
								} else {
									sCalcMethod = oRSMain
											.getString("calcmethod");
								}
								logger.info("sAutomationFunction="
										+ sAutomationFunction
										+ ",sExpectedResult=" + sExpectedResult
										+ ",sScenarioId=" + sScenarioId
										+ ",sTCID=" + sTCID + ",sTestCaseDesc="
										+ sTestCaseDesc + ",sCalcMethod="
										+ sCalcMethod);
								// Modified by Seema 1st Apr17 : To fetch exact
								// planstatus for end to end resume from failed
								// step feature
								// FolderCreate();
								if (sAutomationFunction.equals("")
										|| sAutomationFunction.equals("DUMMY")) {
									sStatus = "Fail";
									sOutput = "Automation Function Is Not Assigned To The Selected TestCase";
									sExpectedResult = "";
									System.out
									.println("Automation Function Is Not Assigned To The Selected TestCase");
								} else {
									if (sPlanID.startsWith("STP")) {
										// Modified by Seema 1st Apr17 : To
										// fetch exact planstatus for end to end
										// resume from failed step feature
										if (sPlanTestcaseStatus
												.equalsIgnoreCase("dropped")) {
											// Fetch Run ID from Terminated case
											// step
											oStmt = oConn
													.createStatement(
															ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_READ_ONLY);
											String sQuery = "select * from qtp_rc_tc_results where planid = '"
													+ sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID
													+ "' and MainTestCaseID = '"
													+ sPlanTestcaseId
													+ "' and status = 'Terminated' and device = '"
													+ sMobDeviceName + "'"; // order
											// by
											// runid";
											logger.info(sQuery);
											ResultSet oRSQuery = oStmt
													.executeQuery(sQuery);
											if (oRSQuery.next()) {
												sRCTCRunid = oRSQuery
														.getString("runid");
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												String sMaxQuery = "select * from qtp_rc_tc_results where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName + "'";// order
												// by
												// runid
												// desc";
												logger.info(sMaxQuery);
												ResultSet oRSMaxQuery = oStmt
														.executeQuery(sMaxQuery);
												if (oRSMaxQuery.next()) {
													sMaxRCTCRunid = oRSQuery
															.getString("runid");
												}
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oStmt.executeUpdate("delete from qtp_rc_tc_results where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName + "'");// and
												// RunID
												// >=
												// '"
												// +
												// sRCTCRunid
												// +
												// "'");
											} else {
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oStmt.executeUpdate("delete from qtp_rc_tc_results where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName + "'");
											}
										} else {
											
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oStmt.executeUpdate("delete from qtp_rc_tc_results where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName + "'");
										}
										FolderCreate();
										ResultSet oRCRunchart = executequery("RunChart");
										if (iExecuteQueryInd == 1) {
											iExecuteQueryInd = 0;
											sStatus = "Fail";
											sOutput = "Selected E2E TestCase Is Not Mapped With Modular TestCases";
										} else {
											iRCInd = 1;
											while (oRCRunchart.next()) {
												oRCStartTime = new Date();
												sRCTestcaseID = oRCRunchart
														.getString("nbtestcaseid");
												sRCModule = oRCRunchart
														.getString("servicingmodule");
												sRCSubModule = oRCRunchart
														.getString("nbsubmodule");
												sRunID = oRCRunchart
														.getString("RunID");
												String sRctcScreenFlag ="";
												sRctcScreenFlag = oRCRunchart.getString("screenshotflag");
												if(sScreenFlag.equalsIgnoreCase("NA")){
//													sRctcScreenFlag = sScreenFlag;
													sScreenFlag = sRctcScreenFlag;
												}
												logger.info("ScreenFlag for E2E run chart = "+sScreenFlag);

												sRCTCflowid = sRunID; // Swapnil
												// 6/7/17
												// to
												// test
												// FlowId
												// approach
												iScreenNum = 1;
												logger.info("sRCTestcaseID="
														+ sRCTestcaseID
														+ ",sRCModule="
														+ sRCModule
														+ ",sRCSubModule="
														+ sRCSubModule
														+ ",sRunID=" + sRunID);
												// Modified by Seema 1st Apr17 :
												// To fetch exact planstatus for
												// end to end resume from failed
												// step feature
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and TestCaseID = '"
														+ sRCTestcaseID
														+ "' and device = '"
														+ sMobDeviceName
														+ "' and testtype = '"
														+ sTestType + "'");
												oStmt.executeUpdate("delete from QTP_CompareResult where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and Module = '"
														+ sModule
														+ "' and SubModule = '"
														+ sSubModule
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and TestCaseID = '"
														+ sRCTestcaseID
														+ "' and device = '"
														+ sMobDeviceName
														+ "' and testtype = '"
														+ sTestType + "'");
												oStmt.executeUpdate("delete from benefit_illustration_pdf where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and Module = '"
														+ sModule
														+ "' and SubModule = '"
														+ sSubModule
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and TestCaseID = '"
														+ sRCTestcaseID
														+ "' and device = '"
														+ sMobDeviceName + "'");
												oStmt.executeUpdate("delete from policy_document_pdf where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and Module = '"
														+ sModule
														+ "' and SubModule = '"
														+ sSubModule
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and TestCaseID = '"
														+ sRCTestcaseID
														+ "' and device = '"
														+ sMobDeviceName + "'");
												oStmt.executeUpdate("delete from Proposal_Details_pdf where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and Module = '"
														+ sModule
														+ "' and SubModule = '"
														+ sSubModule
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and TestCaseID = '"
														+ sRCTestcaseID
														+ "' and device = '"
														+ sMobDeviceName + "'");
												ResultSet oRsRCMain = executequery("RCMain");
												if (iExecuteQueryInd == 1) {
													iExecuteQueryInd = 0;
													sStatus = "Fail";
													sOutput = "Selected Modular TestCase Is Not There In Database";
													sRCAutomationFunction = "";
												} else {
													oRsRCMain.first();
													sRCAutomationFunction = oRsRCMain
															.getString("RCautomationfunction");
													sRCExpectedResult = oRsRCMain
															.getString("RCexpectedresult");
													sRCScenarioId = oRsRCMain
															.getString("RCscenarioid");
													sRCTCID = oRsRCMain
															.getString("RCTCID");
													sRCTestCaseDesc = oRsRCMain
															.getString("RCTestCaseDesc");
													sCalcMethod = oRsRCMain
															.getString("RCCalcMethod");
													sValidationFunction = oRsRCMain
															.getString("RCValidationFunction");
													sRCTestDataTC = oRsRCMain
															.getString("RCTestData");
													logger.info("sRCAutomationFunction="
															+ sRCAutomationFunction
															+ ",sRCExpectedResult="
															+ sRCExpectedResult
															+ ",sRCScenarioId="
															+ sRCScenarioId
															+ ",sRCTCID="
															+ sRCTCID
															+ ",sRCTestCaseDesc="
															+ sRCTestCaseDesc
															+ ",sCalcMethod="
															+ sCalcMethod);
													if (iRCTCTerminateInd == 1) {
														sStatus = "Fail";
														sOutput = "TestCase Fail Because Earlier TC Is Fail";
													} else {
														if (sRCAutomationFunction
																.equals("")) {
															sStatus = "Fail";
															sOutput = "Automation Function Is Not Assigned To The Selected Modular TestCase";
														} else {
															ResultSet oRsSF = executequery("RCStepFunMastr");
															if (iRCTCTerminateInd == 1) {
																iExecuteQueryInd = 0;
																sStatus = "Fail";
																sOutput = "TestCase Fail Because Earlier TC Is Fail";
															} else {
																String sTempStepKeyword = "";
																while (oRsSF
																		.next()) {
																	sSFStepsDesc = oRsSF
																			.getString("SF_StepsDesc");
																	sSFStepKeyword = oRsSF
																			.getString("SF_StepKeyword");
																	sSFStepOR = oRsSF
																			.getString("SF_StepOR");
																	sSFStepId = oRsSF
																			.getString("SF_StepID");
																	logger.info("sSFStepsDesc="
																			+ sSFStepsDesc
																			+ ",sSFStepKeyword="
																			+ sSFStepKeyword
																			+ ",sSFStepOR="
																			+ sSFStepOR
																			+ ",sSFStepId="
																			+ sSFStepId);
																	DataType = "RCACTUALDATA";
																	FunctionCall();
																	System.out
																	.println("iRCTCTerminateInd value : "
																			+ iRCTCTerminateInd);
																	/*if (iReturnValue != 0) {
																		logger.info("Stop");
																	}*/
																	if (iReturnValue != 0) {
																		sTempStepKeyword = sSFStepKeyword;
																		sSFStepKeyword = "";
																		screens();
																		sSFStepKeyword = sTempStepKeyword;
																		sStatus = "Fail";
																		// sOutput
																		// =
																		// "Testcase failed due to the error | "
																		// +
																		// sOutput;
																		iReturnValue = 0;
																		iRCTCTerminateInd = 1;
																		closeapp();
																		break;
																	}
																}
																// AF_Mapping
																// Start Seema :
																// 10 Nov if
																// case is
																// failed, AF
																// mapping is
																// not requried
																// to be done
																if (!(iRCTCTerminateInd == 1)) {
																	logger.info("Inside  AFKeywordMapping");
																	try {
																		ResultSet oRSAF = executequery("AFKEYWORDMAPPING"); // Check
																		// for
																		// AF
																		// Entry
																		if (iExecuteQueryInd != 1) {
																			while (oRSAF
																					.next()) {
																				// Update
																				// Data
																				// from
																				// Source
																				// to
																				// Destination
																				// Table
																				Source_Template_Name = oRSAF
																						.getString("Template_Name"); // Source
																				// Table
																				// Name
																				Source_Keyword_Name = oRSAF
																						.getString("Keyword_Name"); // Source
																				// Column
																				// Name
																				Destination_Mapped_Container = oRSAF
																						.getString("Mapped_Container"); // Destination
																				// Table
																				// Name
																				Destination_Mapped_Column = oRSAF
																						.getString("Mapped_Column"); // Destination
																				// Column
																				// Name
																				Destination_Mapped_RunID = oRSAF
																						.getString("Mapped_RunID"); // Destination
																				// Run
																				// ID
																				// Fetch
																				// Source
																				// data
																				String sskynQry = "Select "
																						+ Source_Keyword_Name
																						+ " From "
																						+ Source_Template_Name
																						+ " Where planid = '"
																						+ sPlanID
																						+ "' and planreleaseid = '"
																						+ sReleaseID
																						+ "'  and plancycleid= '"
																						+ sCycleID
																						+ "' and Test_Case = '"
																						+ sPlanTestcaseId
																						+ "' and Test_Case_Ser = '"
																						+ sRCTestcaseID
																						+ "'";
																				logger.info("sQuery="
																						+ sskynQry);
																				Statement oStmt1 = oConn
																						.createStatement(
																								ResultSet.TYPE_SCROLL_INSENSITIVE,
																								ResultSet.CONCUR_READ_ONLY);
																				ResultSet oRSUpdateColumn = oStmt1
																						.executeQuery(sskynQry);
																				oRSUpdateColumn
																				.first();
																				sValoRsAFUpdateColumn = oRSUpdateColumn
																						.getString(Source_Keyword_Name);
																				if (Destination_Mapped_RunID
																						.equals("")) {
																					oStmt1 = oConn
																							.createStatement(
																									ResultSet.TYPE_SCROLL_INSENSITIVE,
																									ResultSet.CONCUR_READ_ONLY);
																					// if(!sActual.equalsIgnoreCase("")){
																					String sSQLQuery = ("Update "
																							+ Destination_Mapped_Container
																							+ " Set "
																							+ Destination_Mapped_Column
																							+ " = '"
																							+ sValoRsAFUpdateColumn
																							+ "' Where planid = '"
																							+ sPlanID
																							+ "' and planreleaseid = '"
																							+ sReleaseID
																							+ "'  and plancycleid= '"
																							+ sCycleID
																							+ "' and Test_Case = '"
																							+ sPlanTestcaseId + "'");
																					logger.info("sSQLQuery="
																							+ sSQLQuery);
																					oStmt1.executeUpdate(sSQLQuery);
																					// }
																				} else {
																					logger.info("Select nbtestcaseid From qath_service_runchart_tc_mapping Where servicingtestcaseid = '"
																							+ sPlanTestcaseId
																							+ "' and runid = '"
																							+ Destination_Mapped_RunID
																							+ "'");
																					ResultSet oRsTCRunID = oStmt1
																							.executeQuery("Select nbtestcaseid From qath_service_runchart_tc_mapping Where servicingtestcaseid = '"
																									+ sPlanTestcaseId
																									+ "' and runid = '"
																									+ Destination_Mapped_RunID
																									+ "'");
																					oRsTCRunID
																					.first();
																					sValoRsTCRunID = oRsTCRunID
																							.getString("nbtestcaseid");
																					String sSQLQuery = ("Update "
																							+ Destination_Mapped_Container
																							+ " Set "
																							+ Destination_Mapped_Column
																							+ " = '"
																							+ sValoRsAFUpdateColumn
																							+ "' Where planid = '"
																							+ sPlanID
																							+ "' and planreleaseid = '"
																							+ sReleaseID
																							+ "'  and plancycleid= '"
																							+ sCycleID
																							+ "' and Test_Case = '"
																							+ sPlanTestcaseId
																							+ "' and test_case_ser = '"
																							+ sValoRsTCRunID + "'");
																					logger.info("sSQLQuery="
																							+ sSQLQuery);
																					oStmt1.executeUpdate(sSQLQuery);
																				}
																			}
																			iExecuteQueryInd = 0;
																		}
																		// AF_Mapping
																		// End
																	} catch (Exception e) {
																		// iTerminateInd
																		// = 1;
																		iReturnValue = 1;
																		iRCTCTerminateInd = 1;
																	}
																}
															}
														}
													}
												}
												oRCEndTime = new Date();
												Date oDateTemp = new Date(
														oRCEndTime.getTime()
														- oRCStartTime
														.getTime());
												SimpleDateFormat oDF = new SimpleDateFormat(
														"HH:mm:ss");
												oDF.setTimeZone(TimeZone
														.getTimeZone("UTC"));
												sRCExecutionTime = oDF
														.format(oDateTemp);
												logger.info("sRCExecutionTime="
														+ sRCExecutionTime);
												parentWindowHandle = "";
												try {
													UpdateRCTCResult();
													// Launch UFT
													if (sPlanID.contains("STP")) {
														if (sSTPStatus
																.equalsIgnoreCase("pass")) {
															String sExcelFilePath = "";
															ResultSet oRSQueryPS1;
															String sFPQry = "select value from parameter_setup where parameter = 'File_Path'";
															logger.info("sQuery="
																	+ sFPQry);
															oStmt = oConn
																	.createStatement(
																			ResultSet.TYPE_SCROLL_INSENSITIVE,
																			ResultSet.CONCUR_READ_ONLY);
															oRSQueryPS1 = oStmt
																	.executeQuery(sFPQry);
															if (oRSQueryPS1
																	.next()) {
																sExcelFilePath = oRSQueryPS1
																		.getString("value");
															}
															oRSQueryPS1.close();
															sMultiFlag = "Yes";
															sMultiE2EFlag = "Yes";
															closeapp();
															File file1 = new File(
																	sExcelFilePath
																	+ "/Selenium_"
																	+ sMachineId
																	+ ".txt");
															if (file1.exists()) {
																file1.delete();
															}
															createtxt();
															Thread.sleep(500);
															launchvbs();
															Thread.sleep(100);
															// Wait for text
															// file to get
															// created
															try {
																File file = new File(
																		sExcelFilePath
																		+ "/Selenium_"
																		+ sMachineId
																		+ ".txt");
																while (!(file
																		.exists())) {
																	System.out
																	.println("af");
																	Thread.sleep(100);
																}
																file.delete();
															} catch (Exception ex) {
																logger.info(ex
																		.getMessage());
															}
															sSTPStatus = "";
															break;
														}
													}
												} catch (Exception e) {
													logger.error("Exception at UpdateRCTCResult"
															+ e.getMessage());
												}
												sKey = "";
											}

											if (iRCTCTerminateInd == 1) {
												ResultSet oRSQuery;
												String sCPTQry = "select count(*) As Col from dbo.QTP_ where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and Module = '"
														+ sModule
														+ "' and SubModule = '"
														+ sSubModule
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName
														+ "' and testtype = '"
														+ sTestType
														+ "' and  CompareResult = 'Terminated'";
												logger.info("sQuery=" + sCPTQry);
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oRSQuery = oStmt
														.executeQuery(sCPTQry);
												if (oRSQuery.next()
														&& !oRSQuery.getString(
																"Col").equals(
																		"0")) {
													sStatus = "Terminated";
													sOutput = "TestCase Execution Terminated Kindly drill down to check Sub Test Case Results";
													// sOutput =
													// "TestCase Execution Terminated,To Complete Case journey,please navigate to RC_TC result.";
												} else {
													sStatus = "Fail";
													sOutput = "TestCase Execution failed Kindly drill down to check Sub Test Case Results";
													// sOutput =
													// "TestCase Execution failed,To Complete Case journey,please navigate to RC_TC result.";
												}
											} else {
												ResultSet oRSQuery, oRSQuery1, oRSQuery2;
												String sCPFQry = "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and Module = '"
														+ sModule
														+ "' and SubModule = '"
														+ sSubModule
														+ "' and MainTestCaseID = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName
														+ "'  and testtype = '"
														+ sTestType
														+ "' and  CompareResult = 'Fail'";
												logger.info("sQuery=" + sCPFQry);
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oRSQuery = oStmt
														.executeQuery(sCPFQry);
												String sQRTFQry = "select count(*) As Col from dbo.qtp_rc_tc_results where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and maintestcaseid = '"
														+ sPlanTestcaseId
														+ "' and device = '"
														+ sMobDeviceName
														+ "' and  Status = 'Fail'";
												logger.info("sQuery="
														+ sQRTFQry);
												oStmt = oConn
														.createStatement(
																ResultSet.TYPE_SCROLL_INSENSITIVE,
																ResultSet.CONCUR_READ_ONLY);
												oRSQuery2 = oStmt
														.executeQuery(sQRTFQry);
												if ((oRSQuery.next() && !oRSQuery
														.getString("Col")
														.equals("0"))
														|| (oRSQuery2.next() && !oRSQuery2
																.getString(
																		"Col")
																		.equals("0"))) {
													sStatus = "Fail";
													sOutput = "TestCase Execution failed Kindly drill down to check Sub Test Case Results";
													// sOutput =
													// "TestCase Execution failed,To Complete Case journey,please navigate to RC_TC result.";
												} else {
													sStatus = "Pass";
													sOutput = "TestCase Executed Successfully. Kindly drill down to check Sub Test Case Results";
													// sOutput =
													// "TestCase Executed Successfully.To Complete Case journey,please navigate to RC_TC result.";
												}
											}
										}
									} else {

										if (!(sAutomationFunction.toLowerCase()
												.contains("flow"))) {
											// UpdateResult();
											sRCTCflowid = "0";
											sFlowCode = "0";
											// sRCTCRunID=sFlowID;
											sOutput = "";
											// Modified by Seema 1st Apr17 : to
											// club it with below if condition,
											// as same condition is not required
											// multiple times

											FolderCreate();
											oStmt = oConn
													.createStatement(
															ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_READ_ONLY);
											oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
													+ sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID
													+ "' and MainTestCaseID = '"
													+ sPlanTestcaseId
													+ "' and device = '"
													+ sMobDeviceName + "'");
											oStmt.executeUpdate("delete from QTP_CompareResult where planid = '"
													+ sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID
													+ "' and Module = '"
													+ sModule
													+ "' and SubModule = '"
													+ sSubModule
													+ "' and MainTestCaseID = '"
													+ sPlanTestcaseId
													+ "' and device = '"
													+ sMobDeviceName
													+ "' and testtype = '"
													+ sTestType + "'");
											/*
											 * oStmt.executeUpdate(
											 * "delete from benefit_illustration_pdf where planid = '"
											 * + sPlanID +
											 * "' and planreleaseid = '" +
											 * sReleaseID +
											 * "' and plancycleid = '" +
											 * sCycleID + "' and Module = '" +
											 * sModule + "' and SubModule = '" +
											 * sSubModule +
											 * "' and MainTestCaseID = '" +
											 * sPlanTestcaseId +
											 * "' and device = '" +
											 * sMobDeviceName + "'");
											 * oStmt.executeUpdate(
											 * "delete from policy_document_pdf where planid = '"
											 * + sPlanID +
											 * "' and planreleaseid = '" +
											 * sReleaseID +
											 * "' and plancycleid = '" +
											 * sCycleID + "' and Module = '" +
											 * sModule + "' and SubModule = '" +
											 * sSubModule +
											 * "' and MainTestCaseID = '" +
											 * sPlanTestcaseId +
											 * "' and device = '" +
											 * sMobDeviceName + "'");
											 * oStmt.executeUpdate(
											 * "delete from Proposal_Details_pdf where planid = '"
											 * + sPlanID +
											 * "' and planreleaseid = '" +
											 * sReleaseID +
											 * "' and plancycleid = '" +
											 * sCycleID + "' and Module = '" +
											 * sModule + "' and SubModule = '" +
											 * sSubModule +
											 * "' and MainTestCaseID = '" +
											 * sPlanTestcaseId +
											 * "' and device = '" +
											 * sMobDeviceName + "'");
											 */

											ResultSet oRsSF = executequery("STEPFUNMASTR");
											if (iExecuteQueryInd == 1) {
												iExecuteQueryInd = 0;
												sStatus = "Fail";
												sOutput = "Step Function doesn't exist";
												logger.error(sOutput);
											}
											while (oRsSF.next()) {
												logger.info("****pre output : "
														+ sOutput);
												if (!(sExitSFFlag
														.equalsIgnoreCase("yes"))) {
													sSFStepsDesc = oRsSF
															.getString("SF_StepsDesc");
													sSFStepKeyword = oRsSF
															.getString("SF_StepKeyword");
													sSFStepOR = oRsSF
															.getString("SF_StepOR");
													sSFStepId = oRsSF
															.getString("SF_StepID");
													 if 
													 ( 
													  sSFStepId.equalsIgnoreCase("SF_ESub_BPLAC-0020"))
													 {
														 logger.info("stop");
													 }
													logger.info("sSFStepsDesc="  
															+ sSFStepsDesc
															+ ",sSFStepKeyword="
															+ sSFStepKeyword
															+ ",sSFStepOR="
															+ sSFStepOR
															+ ",sSFStepId="
															+ sSFStepId);
													DataType = "ActualData";
     													FunctionCall();
 													logger.info("iReturnValue at step " + sSFStepId + " = " +iReturnValue);
 													
 													/*if (iReturnValue != 0) {
 														iReturnValue=0;	
 														iTerminateInd = 0;
													logger.info("Stop");
												    }*/
 													
 													if (iReturnValue != 0) {
														logger.info("****error output : "
																+ sOutput);
														String sTempStepKeyword = "";
														sTempStepKeyword = sSFStepKeyword;
														sSFStepKeyword = "";
														screens();
														sSFStepKeyword = sTempStepKeyword;
														sStatus = "Fail";
														// sOutput =
														// "Testcase failed due to the error | "
														// + sOutput;
														closeapp();
														iReturnValue = 0;
														break;
													}
												}
												logger.info("****post output : "
														+ sOutput);
											}
										} else {
											// Modified by Seema 28 Jun17 for
											// Flow id, as alternative to
											// runchart need to uncomment later
											// Need to handle folder file
											// deletion flow id wise
											// need to uncomment later
											// FolderCreate();
											String sFlowDet = "";
											oStmt = oConn
													.createStatement(
															ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_READ_ONLY);
											ResultSet oRSFM = executequery("FLOWDEFINITION");
											if (iExecuteQueryInd == 1) {
												iExecuteQueryInd = 0;
												sStatus = "Fail";
												sOutput = "Selected Master Flow is not available in Flow Master Table";
											} else
												while (oRSFM.next()) {
													// sFlowName
													// ="Flow_Definition";
													// sFlowName =
													// oRSFM.getString("Flow_Definition_Table");
													sFDTableName = oRSFM
															.getString("Flow_Definition_Table");
													oStmt = oConn
															.createStatement(
																	ResultSet.TYPE_SCROLL_INSENSITIVE,
																	ResultSet.CONCUR_READ_ONLY);
													ResultSet oRCFlowDef = executequery("FLOWDEFTABLE");
													if (iExecuteQueryInd == 1) {
														iExecuteQueryInd = 0;
														sStatus = "Fail";
														sOutput = "Selected Modular Test Case Flow Data is not defined";
													} else {
														oRCFlowDef.next();
														oStmt = oConn
																.createStatement(
																		ResultSet.TYPE_SCROLL_INSENSITIVE,
																		ResultSet.CONCUR_READ_ONLY);
														ResultSet oRCFlowMast = executequery("FLOWDETAILS");
														oRCFlowMast
														.beforeFirst();
														if (iExecuteQueryInd == 1) {
															iExecuteQueryInd = 0;
															sStatus = "Fail";
															sOutput = "Flow Details is not available for Selected Master Flow";
														} else {
															iRCInd = 1;
															while (oRCFlowMast
																	.next()) {
																// if(iTerminateInd!=1){
																oRCStartTime = new Date();
																sFlowName = oRCFlowMast
																		.getString("flow_name");
																sFlowDet = oRCFlowDef
																		.getString(sFlowName);
																iScreenNum = 1;
																// isFlowSelected=0;
																if (sFlowDet
																		.equalsIgnoreCase("y")) {
																	// if(iTerminateInd!=1){
																	isFlowSelected = 1;
																	sFlowID = oRCFlowMast
																			.getString("flow_id");
																	sFlowCode = oRCFlowMast
																			.getString("flow_code");
																	sRCTCflowid = sFlowID; // Swapnil
																	// 6/7/17
																	// to
																	// test
																	// FlowId
																	// approach
																	sRCAutomationFunction = oRCFlowMast
																			.getString("sf_id");
																	FolderCreate();
																	oStmt = oConn
																			.createStatement(
																					ResultSet.TYPE_SCROLL_INSENSITIVE,
																					ResultSet.CONCUR_READ_ONLY);
																	logger.info("sRCAutomationFunction="
																			+ sRCAutomationFunction
																			+ ",sFlowID="
																			+ sFlowID
																			+ ", sFlowCode = "
																			+ sFlowCode);
																	System.out
																	.println("delete from QTP_ActualResult where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and TestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and TestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	oStmt.executeUpdate("delete from QTP_CompareResult where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and Module = '"
																			+ sModule
																			+ "' and SubModule = '"
																			+ sSubModule
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and TestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "' and testtype='"
																			+ sTestType
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	oStmt.executeUpdate("delete from benefit_illustration_pdf where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and Module = '"
																			+ sModule
																			+ "' and SubModule = '"
																			+ sSubModule
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and TestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	oStmt.executeUpdate("delete from policy_document_pdf where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and Module = '"
																			+ sModule
																			+ "' and SubModule = '"
																			+ sSubModule
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and TestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	oStmt.executeUpdate("delete from Proposal_Details_pdf where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and Module = '"
																			+ sModule
																			+ "' and SubModule = '"
																			+ sSubModule
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and TestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	logger.info("delete from qtp_rc_tc_results where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	oStmt.executeUpdate("delete from qtp_rc_tc_results where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "'"); // and
																	// RunID
																	// =
																	// '"
																	// +
																	// sFlowCode
																	// +
																	// "'");
																	if (iRCTCTerminateInd == 1) {
																		sStatus = "Fail";
																		sOutput = "TestCase Fail Because Earlier TC Is Fail";
																	} else {
																		if (sRCAutomationFunction
																				.equals("")) {
																			sStatus = "Fail";
																			sOutput = "Automation Function Is Not Assigned To The Selected Flow";
																		} else {
																			ResultSet oRsSF = executequery("RCStepFunMastr");
																			if (iRCTCTerminateInd == 1) {
																				iExecuteQueryInd = 0;
																				sStatus = "Fail";
																				sOutput = "TestCase Fail Because Earlier TC Is Fail";
																			} else {
																				while (oRsSF
																						.next()) {
																					// if(iTerminateInd!=1){
																					sSFStepsDesc = oRsSF
																							.getString("SF_StepsDesc");
																					sSFStepKeyword = oRsSF
																							.getString("SF_StepKeyword");
																					sSFStepOR = oRsSF
																							.getString("SF_StepOR");
																					sSFStepId = oRsSF
																							.getString("SF_StepID");
																					logger.info("sSFStepsDesc="
																							+ sSFStepsDesc
																							+ ",sSFStepKeyword="
																							+ sSFStepKeyword
																							+ ",sSFStepOR="
																							+ sSFStepOR
																							+ ",sSFStepId="
																							+ sSFStepId);
																					if (sSFStepId.equalsIgnoreCase("SF_Fir_ESub_BPLAC-0020")) {
																						logger.info("stop");
																					}
																					DataType = "ACTUALDATA";
																					FunctionCall();
																					logger.info("iTerminateInd Value :"
																							+ iTerminateInd
																							+ "iRCTCTerminateInd Value :"
																							+ iRCTCTerminateInd);
																					if (iReturnValue != 0) {
																						String sTempStepKeyword = "";
																						sTempStepKeyword = sSFStepKeyword;
																						sSFStepKeyword = "";
																						screens();
																						sSFStepKeyword = sTempStepKeyword;
																						sStatus = "Fail";
																						// sOutput
																						// =
																						// "Testcase failed due to the error | "
																						// +
																						// sOutput;
																						iReturnValue = 0;
																						iRCTCTerminateInd = 1;
																						closeapp();
																						break;
																					}
																					// }
																				}
																				if (!(iRCTCTerminateInd == 1)) {
																					// AF_Mapping
																					// Start
																					logger.info("Inside AFKeywordMapping");
																					try {
																						ResultSet oRSAF = executequery("AFKEYWORDMAPPING"); // Check
																						// for
																						// AF
																						// Entry
																						if (iExecuteQueryInd != 1) {
																							while (oRSAF
																									.next()) {
																								// Update
																								// Data
																								// from
																								// Source
																								// to
																								// Destination
																								// Table
																								Source_Template_Name = oRSAF
																										.getString("Template_Name"); // Source
																								// Table
																								// Name
																								Source_Keyword_Name = oRSAF
																										.getString("Keyword_Name"); // Source
																								// Column
																								// Name
																								Destination_Mapped_Container = oRSAF
																										.getString("Mapped_Container"); // Destination
																								// Table
																								// Name
																								Destination_Mapped_Column = oRSAF
																										.getString("Mapped_Column"); // Destination
																								// Column
																								// Name
																								Destination_Mapped_RunID = oRSAF
																										.getString("Mapped_RunID"); // Destination
																								// Run
																								// ID
																								// Fetch
																								// Source
																								// data
																								String sAFKYWry = "Select "
																										+ Source_Keyword_Name
																										+ " From "
																										+ Source_Template_Name
																										+ " Where planid = '"
																										+ sPlanID
																										+ "' and planreleaseid = '"
																										+ sReleaseID
																										+ "'  and plancycleid= '"
																										+ sCycleID
																										+ "' and Test_Case = '"
																										+ sPlanTestcaseId
																										+ "' and flow_code = '"
																										+ sFlowCode
																										+ "'";
																								logger.info("sQuery="
																										+ sAFKYWry);
																								Statement oStmt1 = oConn
																										.createStatement(
																												ResultSet.TYPE_SCROLL_INSENSITIVE,
																												ResultSet.CONCUR_READ_ONLY);
																								ResultSet oRSUpdateColumn = oStmt1
																										.executeQuery(sAFKYWry);
																								oRSUpdateColumn
																								.first();
																								try {
																									sValoRsAFUpdateColumn = oRSUpdateColumn
																											.getString(Source_Keyword_Name);
																								} catch (Exception e) {
																									logger.info("sValoRsAFUpdateColumn error "
																											+ e.getMessage());
																								}
																								if (Destination_Mapped_RunID
																										.equals("")) {
																									// Swapnil
																									// Parab
																									// updated
																									// on
																									// 20-08-2017
																									CheckData();
																									if (sActualCheck
																											.equalsIgnoreCase("")) {
																										String sSQLQuery = ("Update "
																												+ Destination_Mapped_Container
																												+ " Set "
																												+ Destination_Mapped_Column
																												+ " = '"
																												+ sValoRsAFUpdateColumn
																												+ "' Where planid = '"
																												+ sPlanID
																												+ "' and planreleaseid = '"
																												+ sReleaseID
																												+ "'  and plancycleid= '"
																												+ sCycleID
																												+ "' and Test_Case = '"
																												+ sPlanTestcaseId + "'");
																										logger.info("sSQLQuery="
																												+ sSQLQuery);
																										oStmt1.executeUpdate(sSQLQuery);
																									}
																								} else {
																									// Swapnil
																									// Parab
																									// updated
																									// on
																									// 20-08-2017
																									CheckData();
																									logger.info("sActData = "
																											+ sValoRsAFUpdateColumn
																											+ " : sExpData = "
																											+ sActualCheck);
																									if (sActualCheck
																											.equalsIgnoreCase("")) {
																										String sSQLQuery = ("Update "
																												+ Destination_Mapped_Container
																												+ " Set "
																												+ Destination_Mapped_Column
																												+ " = '"
																												+ sValoRsAFUpdateColumn
																												+ "' Where planid = '"
																												+ sPlanID
																												+ "' and planreleaseid = '"
																												+ sReleaseID
																												+ "'  and plancycleid= '"
																												+ sCycleID
																												+ "' and Test_Case = '"
																												+ sPlanTestcaseId
																												+ "' and flow_code = '"
																												+ Destination_Mapped_RunID + "'");
																										logger.info("sSQLQuery="
																												+ sSQLQuery);
																										oStmt1.executeUpdate(sSQLQuery);
																									} else if (iUpdateValue == 1) {
																										logger.info("No data update require");
																									} else if (!sValoRsAFUpdateColumn
																											.equalsIgnoreCase(sActualCheck)) {
																										String sSQLQuery = ("Update "
																												+ Destination_Mapped_Container
																												+ " Set "
																												+ Destination_Mapped_Column
																												+ " = '"
																												+ sValoRsAFUpdateColumn
																												+ "' Where planid = '"
																												+ sPlanID
																												+ "' and planreleaseid = '"
																												+ sReleaseID
																												+ "'  and plancycleid= '"
																												+ sCycleID
																												+ "' and Test_Case = '"
																												+ sPlanTestcaseId
																												+ "' and flow_code = '"
																												+ Destination_Mapped_RunID + "'");
																										logger.info("sSQLQuery="
																												+ sSQLQuery);
																										oStmt1.executeUpdate(sSQLQuery);
																									}
																								}
																							}
																							iExecuteQueryInd = 0;
																						}
																					} catch (Exception e) {
																						System.out
																						.println(""
																								+ e.getMessage());
																					}
																					// AF_Mapping
																					// End
																				}
																			}
																		}
																	}
																	oRCEndTime = new Date();
																	Date oDateTemp = new Date(
																			oRCEndTime
																			.getTime()
																			- oRCStartTime
																			.getTime());
																	SimpleDateFormat oDF = new SimpleDateFormat(
																			"HH:mm:ss");
																	oDF.setTimeZone(TimeZone
																			.getTimeZone("UTC"));
																	sRCExecutionTime = oDF
																			.format(oDateTemp);
																	logger.info("sRCExecutionTime="
																			+ sRCExecutionTime);
																	parentWindowHandle = "";
																	try {
																		UpdateRCTCResult();
																	} catch (Exception e) {
																		logger.info("Exception at UpdateRCTCResult : "
																				+ e.getMessage());
																	}
																	sKey = "";
																}
																// }
															}
															if (isFlowSelected != 0) {
																if (iRCTCTerminateInd == 1) {
																	ResultSet oRSQuery;
																	String sQCPTQry = "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and Module = '"
																			+ sModule
																			+ "' and SubModule = '"
																			+ sSubModule
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "' and testtype = '"
																			+ sTestType
																			+ "' and  CompareResult = 'Terminated'";
																	logger.info("sQuery="
																			+ sQCPTQry);
																	oStmt = oConn
																			.createStatement(
																					ResultSet.TYPE_SCROLL_INSENSITIVE,
																					ResultSet.CONCUR_READ_ONLY);
																	oRSQuery = oStmt
																			.executeQuery(sQCPTQry);
																	if (oRSQuery
																			.next()
																			&& !oRSQuery
																			.getString(
																					"Col")
																					.equals("0")) {
																		sStatus = "Terminated";
																		sOutput = "TestCase Execution Terminated Kindly drill down to check Sub Test Case Results";
																		// sOutput
																		// =
																		// "TestCase Execution Terminated,To Complete Case journey,please navigate to RC_TC result.";
																	} else {
																		sStatus = "Fail";
																		sOutput = "TestCase Execution failed Kindly drill down to check Sub Test Case Results";
																		// sOutput
																		// =
																		// "TestCase Execution failed,To Complete Case journey,please navigate to RC_TC result.";
																	}
																} else {
																	ResultSet oRSQuery, oRSQuery1, oRSQuery2;
																	String sQCPFQry = "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and Module = '"
																			+ sModule
																			+ "' and SubModule = '"
																			+ sSubModule
																			+ "' and MainTestCaseID = '"
																			+ sPlanTestcaseId
																			+ "' and device = '"
																			+ sMobDeviceName
																			+ "' and testtype='"
																			+ sTestType
																			+ "' and  CompareResult = 'Fail'";
																	logger.info("sQuery="
																			+ sQCPFQry);
																	oStmt = oConn
																			.createStatement(
																					ResultSet.TYPE_SCROLL_INSENSITIVE,
																					ResultSet.CONCUR_READ_ONLY);
																	oRSQuery = oStmt
																			.executeQuery(sQCPFQry);
																	String sQRCTCQry = "select count(*) As Col from dbo.qtp_rc_tc_results where planid = '"
																			+ sPlanID
																			+ "' and planreleaseid = '"
																			+ sReleaseID
																			+ "' and plancycleid = '"
																			+ sCycleID
																			+ "' and maintestcaseid = '"
																			+ sPlanTestcaseId
																			+ "' and  Status = 'Fail' and device = '"
																			+ sMobDeviceName
																			+ "'";
																	logger.info("sQuery="
																			+ sQRCTCQry);
																	oStmt = oConn
																			.createStatement(
																					ResultSet.TYPE_SCROLL_INSENSITIVE,
																					ResultSet.CONCUR_READ_ONLY);
																	oRSQuery2 = oStmt
																			.executeQuery(sQRCTCQry);
																	if ((oRSQuery
																			.next() && !oRSQuery
																			.getString(
																					"Col")
																					.equals("0"))
																					|| (oRSQuery2
																							.next() && !oRSQuery2
																							.getString(
																									"Col")
																									.equals("0"))) {
																		sStatus = "Fail";
																		sOutput = "TestCase Execution failed Kindly drill down to check Sub Test Case Results";
																		// sOutput
																		// =
																		// "TestCase Execution failed,To Complete Case journey,please navigate to RC_TC result.";
																	} else {
																		sStatus = "Pass";
																		// sOutput
																		// =
																		// "TestCase Executed Successfully.To Complete Case journey,please navigate to RC_TC result.";
																		// //
																		// Case
																		// Results";
																		sOutput = "TestCase Executed Successfully. Kindly drill down to check Sub Test Case Results";
																	}
																}
															} else {
																sStatus = "Fail";
																sOutput = "Please Select flow against Selected TestCase";
															}
															// }
														}
													}
												}
										}
									}
								}
							}
							oEndTime = new Date();
							Date oDateTemp = new Date(oEndTime.getTime()
									- oStartTime.getTime());
							SimpleDateFormat oDF = new SimpleDateFormat("HH:mm:ss");
							oDF.setTimeZone(TimeZone.getTimeZone("UTC"));
							sExecutionTime = oDF.format(oDateTemp);
							logger.info("sExecutionTime=" + sExecutionTime);
							parentWindowHandle = "";
							//callxaml(); // Swapnil To call Xaml
							UpdateResult();
//							copyfile();
							Home_page();
//							landing_page();
							sMultiFlag = "";
							sSTPStatus = "";
							oTestDataMap.clear();
							iTerminateInd = 0;
							iRCTCTerminateInd = 0;
							iReturnValue = 0;
							sExitStatus = "";
							sKey="";
							disconnect();
						}
					}
				}
				//BVT();
				closeapp();
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
				sStatus = "Fail";
				UpdateResult();
				sMultiFlag = "";
				sSTPStatus = "";
			} catch (Exception e1) {

			}

		}
	}

	public void CheckData() throws SQLException {
		logger.info("Inside CheckData");
		sActualCheck = "";
		ResultSet oQuery = null;
		ResultSet oQuery1 = null;
		try {
			String sSQLQuery1 = ("Select " + Destination_Mapped_Column
					+ " From " + Destination_Mapped_Container
					+ " Where planid = '" + sPlanID + "' and planreleaseid = '"
					+ sReleaseID + "' and plancycleid= '" + sCycleID
					+ "' and Test_Case = '" + sPlanTestcaseId
					+ "' and flow_code = '" + Destination_Mapped_RunID + "'");
			logger.info("sSQLQuery=" + sSQLQuery1);
			String sActual = "";
			oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			oQuery = oStmt.executeQuery(sSQLQuery1);
			if (oQuery.next()) {
				sActualCheck = oQuery.getString(Destination_Mapped_Column)
						.trim();
			}
		} catch (Exception e) {
			System.out.println("CheckData error : " + e.getMessage());
		}
		oQuery.close();
		String sSQLQuery = ("Select * From " + Destination_Mapped_Container
				+ " Where planid = '" + sPlanID + "' and planreleaseid = '"
				+ sReleaseID + "' and plancycleid= '" + sCycleID
				+ "' and Test_Case = '" + sPlanTestcaseId
				+ "' and flow_code = '" + Destination_Mapped_RunID + "'");
		logger.info("sSQLQuery=" + sSQLQuery);
		String sActual = "";
		oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		oQuery1 = oStmt.executeQuery(sSQLQuery);
		if (oQuery1.next()) {
			try {
				IsDataUpdate = oQuery1.getString("IsDataUpdate").trim();
				System.out.println("Update Require ? =" + IsDataUpdate);
				logger.info("Destination_Mapped_Column : "
						+ Destination_Mapped_Column);
				if (Destination_Mapped_Column.equalsIgnoreCase("Ticket_ID")
						|| Destination_Mapped_Column
						.equalsIgnoreCase("Enter_Ticket")) {
					iUpdateValue = 0;
				}
				if (!IsDataUpdate.equalsIgnoreCase("")
						&& !IsDataUpdate.equalsIgnoreCase("No")) {
					iUpdateValue = 1;
				}
			} catch (Exception e) {
			}
		}
		oQuery1.close();
	}

	public void FunctionCall() {
		// Seema : Changes done to call if condition once, instead of each case
		// statement
		logger.info("Inside FunctionCall");
		try {
			if (iTerminateInd == 0) {
				// Executor exeFC = new Executor();
				Method m = exc.getClass().getMethod(sSFStepsDesc.toLowerCase());
				m.invoke(exc);
				// For paramter
				/*
				 * test t = new test(); String MyVar = "aa"; Class[] cArg = new
				 * Class[1]; cArg[0] = String.class; // Method method =
				 * c.getDeclaredMethod ("method name", parameterTypes) //
				 * method.invoke (objectToInvokeOn, params) Method m =
				 * t.getClass().getMethod(MyVar, cArg); m.invoke(t, "Sd");
				 */
			}
			
		} catch (Exception e) {
			iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}


	public void FolderCreate() {
		logger.info("Inside FolderCreate");
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd")
			.parse(splanexecutiondate);
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			sDate = sdf.format(date1);
			System.out.println(sDate);
			if (sRCTestcaseID == null || sRCTestcaseID == "") {
				sFullScreenShotPath = sScreenShotPath + "\\" + sTestType + "\\" + sDate  + "\\"
						+ sModule + "\\" + sSubModule.trim() + "\\"
						+ sMobDeviceName + "\\" + sPlanRelCyc 
						+ "\\" + sPlanTestcaseId;
			} else {
				sFullScreenShotPath = sScreenShotPath + "\\" + sTestType + "\\" + sDate
						+ "\\" + sModule + "\\" + sSubModule.trim() + "\\"
						+ sMobDeviceName + "\\" + sPlanRelCyc
						+ "\\" + sPlanTestcaseId;
			}
//			logger.addAppender(new RollingFileAppender(new PatternLayout(
//					"%d{ISO8601} [%t] %-5p %c %x - %m%n"), sFullScreenShotPath
//					+ "\\Selenium_" + sMachineId + "-" + sPlanTestcaseId
//					+ ".log"));
			logger.addAppender(new RollingFileAppender(new PatternLayout(
					"%d{ISO8601} [%t] %-5p %c %x - %m%n"), sFullScreenShotPath
					+ "\\SeeTest_" + sMachineId +".log"));
			logger.setAdditivity(false); // Swapnil Parab updated on 22-08-2017
			logger.info("sFullScreenShotPath=" + sFullScreenShotPath);
//			logger.info("Log File Path for Testcase " + sPlanTestcaseId + " = "
//					+ sFullScreenShotPath + "\\Selenium_" + sMachineId + "-"
//					+ sPlanTestcaseId + ".log");
			logger.info("Log File Path for Testcase " + sPlanTestcaseId + " = "
					+ sFullScreenShotPath + "\\SeeTest" + sMachineId + "-"
					+ sPlanTestcaseId + ".log");
			// Modified by Seema 1st Apr17 : To fetch exact planstatus for end
			// to end resume from failed step feature
			// Modified by Seema 27Jun17 : For Flow ID
			if (new File(sFullScreenShotPath).exists()) {
				if ((sRCTCRunid.equals("0")) && (sFlowID.equals("0"))) {
					// if(new File(sFullScreenShotPath).exists()){
					for (File file : new File(sFullScreenShotPath).listFiles())
						file.delete();
					// }
					// else{
					// new File(sFullScreenShotPath).mkdirs();
					// }
				} else if ((!(sRCTCRunid.equals("0"))) && (sFlowID.equals("0"))) {
					int iRCTCRunid = Integer.parseInt(sRCTCRunid);
					int iMaxRCTCRunid = Integer.parseInt(sMaxRCTCRunid);
					for (int iRunid = iRCTCRunid; iRunid <= iMaxRCTCRunid; iRunid++) {
						String name = sRCTestcaseID + "_" + sSFStepId + "_"
								+ iRunid;
						File file = new File(sFullScreenShotPath);
						File[] list = file.listFiles();
						if (list != null)
							for (File fil : list) {
								if (fil.isDirectory()) {
									// findFile(name,fil);
								} else if (fil.getName().contains(name)) {
									System.out.println(fil.getParentFile());
									fil.delete();
								}
							}
					}
				} else if (((sRCTCRunid.equals("0")))
						&& (!(sFlowID.equals("0")))) {
					String name = sPlanTestcaseId + "_" + sSFStepId + "_"
							+ sFlowCode;
					File file = new File(sFullScreenShotPath);
					File[] list = file.listFiles();
					if (list != null)
						for (File fil : list) {
							if (fil.isDirectory()) {
								// findFile(name,fil);
							} else if (fil.getName().contains(name)) {
								System.out.println(fil.getParentFile());
								fil.delete();
							}
						}
				}
			} else {
				new File(sFullScreenShotPath).mkdirs();
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}

		}
	}

	
	public void FolderCreateOld() {
		logger.info("Inside  FolderCreate");
		try {
			// sDate = new SimpleDateFormat("MM-dd-yyyy").format(new Date());
			// sDate = new SimpleDateFormat(splanexecutiondate).format(new
			// Date());
			// sDate = sDate.split(" ")[0];

			// String splanexecutiondate = "2017-10-02 00:00:00.000";
			Date date1 = new SimpleDateFormat("yyyy-MM-dd")
			.parse(splanexecutiondate);
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			sDate = sdf.format(date1);
			System.out.println(sDate);
			if (sRCTestcaseID == null || sRCTestcaseID == "") {
				sFullScreenShotPath = sScreenShotPath + "\\" + sProjectName
						+ "\\" + sTestType + "\\" + sDate + "\\" + sUser + "\\"
						+ sModule + "\\" + sSubModule.trim() + "\\"
						+ sMobDeviceName + "\\" + sPlanRelCyc // + "/" +
						// sScenarioId
						+ "\\" + sPlanTestcaseId;
			} else {
				sFullScreenShotPath = sScreenShotPath + "\\" + sProjectName
						+ "\\" + sTestType + "\\" + sDate + "\\" + sUser + "\\"
						+ sModule + "\\" + sSubModule.trim() + "\\"
						+ sMobDeviceName + "\\" + sPlanRelCyc // + "/" +
						// sScenarioId
						+ "\\" + sPlanTestcaseId;
			}
			logger.addAppender(new RollingFileAppender(new PatternLayout(
					"%d{ISO8601} [%t] %-5p %c %x - %m%n"), sFullScreenShotPath
					+ "\\Selenium_" + sMachineId + "-" + sPlanTestcaseId
					+ ".log"));
			logger.setAdditivity(false); // Swapnil Parab updated on 22-08-2017
			logger.info("sFullScreenShotPath=" + sFullScreenShotPath);
			logger.info("Log File Path for Testcase " + sPlanTestcaseId + " = "
					+ sFullScreenShotPath + "\\Selenium_" + sMachineId + "-"
					+ sPlanTestcaseId + ".log");
			// Modified by Seema 1st Apr17 : To fetch exact planstatus for end
			// to end resume from failed step feature
			// Modified by Seema 27Jun17 : For Flow ID
			if (new File(sFullScreenShotPath).exists()) {
				if ((sRCTCRunid.equals("0")) && (sFlowID.equals("0"))) {
					// if(new File(sFullScreenShotPath).exists()){
					for (File file : new File(sFullScreenShotPath).listFiles())
						file.delete();
					// }
					// else{
					// new File(sFullScreenShotPath).mkdirs();
					// }
				} else if ((!(sRCTCRunid.equals("0"))) && (sFlowID.equals("0"))) {
					int iRCTCRunid = Integer.parseInt(sRCTCRunid);
					int iMaxRCTCRunid = Integer.parseInt(sMaxRCTCRunid);
					for (int iRunid = iRCTCRunid; iRunid <= iMaxRCTCRunid; iRunid++) {
						String name = sRCTestcaseID + "_" + sSFStepId + "_"
								+ iRunid;
						File file = new File(sFullScreenShotPath);
						File[] list = file.listFiles();
						if (list != null)
							for (File fil : list) {
								if (fil.isDirectory()) {
									// findFile(name,fil);
								} else if (fil.getName().contains(name)) {
									System.out.println(fil.getParentFile());
									fil.delete();
								}
							}
					}
				} else if (((sRCTCRunid.equals("0")))
						&& (!(sFlowID.equals("0")))) {
					String name = sPlanTestcaseId + "_" + sSFStepId + "_"
							+ sFlowCode;
					File file = new File(sFullScreenShotPath);
					File[] list = file.listFiles();
					if (list != null)
						for (File fil : list) {
							if (fil.isDirectory()) {
								// findFile(name,fil);
							} else if (fil.getName().contains(name)) {
								System.out.println(fil.getParentFile());
								fil.delete();
							}
						}
				}
			} else {
				new File(sFullScreenShotPath).mkdirs();
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}

		}
	}

	public int fetchdata() {
		logger.info("Inside FetchData");
		iReturnValue = 0;
		try {
			oGlobalMap.clear();
			executequery(DataType);
			if (iExecuteQueryInd == 1) {
				iExecuteQueryInd = 0;
				sStatus = "Fail";
				sOutput = "Data or Flow_Code For The Selected Modular TestCase Is Not In The Data Container";
				logger.info(sOutput);
				// iTerminateInd = 1;
				iReturnValue = 1;
			}
		} catch (Exception e) {
			try {
				logger.info("Inside  FetchData exception");
				String sIDSFStepKeyword = sSFStepKeyword;
				sSFStepKeyword = "FetchData_Exception";
				screens();
				sSFStepKeyword = sIDSFStepKeyword;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error("InputData exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int inputdata() {
		logger.info("Inside   InputData");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			String[] oObjects = sIDSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				String sTestData = "";
				String[] oObj = oObjects[iObjInd].split(":");
				if (oObj.length > 1) {
					if (oObj[1].equalsIgnoreCase("random")) {
						sTestData = String.valueOf(this.randomGenerator());
					} else {
						sTestData = oGlobalMap.get(oObj[1].toLowerCase());
					}
					if (sTestData != null && !sTestData.equals("")) {
						GetObj(oObj[0]);
					} else if (sTestData == null || !sTestData.equals("")) {
						GetObj(oObj[0]);
					}
				} else {
					sTestData = oGlobalMap.get(oObjects[iObjInd].toLowerCase()
							.trim());
					if (sTestData != null && !sTestData.equals("")) {
						GetObj(oObjects[iObjInd]);
					} else if (sTestData == null || sTestData.equals("")) {
						GetObj(oObj[0]);
					}
				}
				
				if ((oObjects[iObjInd]).toLowerCase().equalsIgnoreCase("otp_emailid") && !sTestData.equals("")) {
					Date sEmailTime = new Date();
					Date oDateTemp = new Date(sEmailTime.getTime());
					SimpleDateFormat oDF = new SimpleDateFormat("hh.mm aa");
					
					sOTPEmailDate = new SimpleDateFormat("dd-MM-yyyy").format(sEmailTime);
					sOTPEmailTime=oDF.format(oDateTemp);
				}
				logger.info("Data= " + sTestData);
				if (((oObjects[iObjInd]).toLowerCase().contains("xyz")) && (!(sMobDeviceName.equalsIgnoreCase("desktop")))) {
//					if (oObjects[iObjInd].equalsIgnoreCase("dob")) {
//
//						oDriver_Mob.useNativeIdentification();
//					} else {
//
//						oDriver_Mob.useWebIdentification();
//					}

					String[] sIDArr = sObjProperty1.split(":=");
					String sIDProp = sObjProperty1.split(":=")[0];
					String sIDVal = sObjProperty1.split(":=")[1];
					if (sIDArr.length > 1) {
						sIDVal = sObjProperty1.split(sIDProp + ":=")[1];
					}
					switch (sIDProp.toUpperCase()) {
					case ".XPATH":
						
						oDriver_Mob.findElement(By.xpath(sIDVal)).sendKeys(
								sTestData);

						// Thread.sleep(100);
						try {
							oDriver_Mob.device().closeKeyboard();
							// Thread.sleep(100);
						} catch (Exception e) {

						}
						break;
					case ".ID":
						
						oDriver_Mob.findElement(By.id(sIDVal)).sendKeys(
								sTestData);
						try {

							oDriver_Mob.device().closeKeyboard();
							// Thread.sleep(1000);
						} catch (Exception e) {

						}
						break;

					}
					// oTestObject.sendKeys(sTestData);
					oDriver_Mob.useWebIdentification();
				} else if ((oObjects[iObjInd]
						.equalsIgnoreCase("Employeer_Name"))
						&& (!(sMobDeviceName.equalsIgnoreCase("desktop")))) {
					oDriver_Mob.useWebIdentification();
					oDriver.findElement(
							By.xpath("//label[contains(text(),'Name of your employer')]/following::input[1]"))
							.sendKeys(sTestData);
				} else if ((oObjects[iObjInd]
						.equalsIgnoreCase("Card_Exp_Month"))
						&& (!(sMobDeviceName.equalsIgnoreCase("desktop")))) {
					oDriver.findElement(
							By.xpath("//*[@class='android.widget.Spinner' and @index='7']"))
							.sendKeys("Aug");
					Thread.sleep(500);
					oDriver.findElement(
							By.xpath("//*[@class='android.widget.Spinner' and @index='7']"))
							.click();
				} else if ((oObjects[iObjInd].equalsIgnoreCase("Card_Exp_Year"))
						&& (!(sMobDeviceName.equalsIgnoreCase("desktop")))) {
					oDriver.findElement(
							By.xpath("//*[@class='android.widget.Spinner' and @index='8']"))
							.sendKeys("2018");
					Thread.sleep(500);
					oDriver.findElement(
							By.xpath("//*[@class='android.widget.Spinner' and @index='8']"))
							.click();
				} else if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
					if (sTestData != null && !sTestData.equals("")) {
						if (sUIName.equalsIgnoreCase("Native")) {

							oDriver_Mob.useNativeIdentification();
							UIName = "Native";
						} else {

							oDriver_Mob.useWebIdentification();
							UIName = "WEB";
						}
						
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT.KEYBOARD":
							 oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sTestData);
							 try {
								 oDriver_Mob.device().closeKeyboard();
							 }catch(Exception e) {
								 
							 }
							 break;
						//Sushant Yadav :25/07/2019 : Require to set the value for DatePicker	 
						case "HTML.INPUT.TEXT.DATE":
							if(sTestData.contains("/"))
							{
								sTestData = sTestData.replace("/", ".")	;
							}
							if(sTestData.contains("-"))
							{
								sTestData = sTestData.replace("-", ".")	;
							}
							String str0 = oDriver_Mob.client.elementSetProperty(UIName, oTestObject1, 0, "date", sTestData);	
							 break;	
						case "HTML.INPUT.TEXT.POSITION":
							int oTestObjectPosition=0;
							if(oTestObject1.contains(":="))
							{
								String oTestObjectSpilt1[] = oTestObject1.split(":=");
								oTestObject1 = oTestObjectSpilt1[0];
								oTestObjectPosition = Integer.parseInt(oTestObjectSpilt1[1]); 
							}
							try {
							    oDriver_Mob.client.elementSendText(UIName, oTestObject1, oTestObjectPosition, sTestData);
																													 
								Boolean a1 = oDriver_Mob.client.isElementFound("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']",0);
								if (a1.equals(true)) {
									oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']", 0, 1); 
								}
								oDriver_Mob.client.closeKeyboard();
								//Thread.sleep(100);
							} catch (Exception e1) {

							}
							
						break;	 
						case "HTML.INPUT.TEXT":

							if (oObjects[iObjInd].equalsIgnoreCase("prem")) {
								oTestObject.clear();
								//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time 
								Thread.sleep(100);
								oTestObject.sendKeys(sTestData);
								Thread.sleep(100);
								oTestObject.sendKeys(Keys.TAB);
							} 
							else if (oObjects[iObjInd].equalsIgnoreCase("prem")) {
								oTestObject.clear();
								Thread.sleep(100);
								oTestObject.sendKeys(sTestData);
								Thread.sleep(100);
								oTestObject.sendKeys(Keys.TAB);
							} 
							else if(oObjects[iObjInd].contains("_FaceAmount") || oObjects[iObjInd].contains("Principle_Sum"))
							{
								
								oDriver_Mob.client.click(UIName,oTestObject1, 0, 2);
								Thread.sleep(200);
								Boolean a1 = oDriver_Mob.findElement(By.xpath("xpath=//*[@text='Select All']")).waitFor(200);
								if (a1.equals(false)) {
									oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
									Thread.sleep(200);
								}
								
								// Sushant Yadav 21/05/2019 Script fail to replace the value of basic Face amount
								Boolean a101 = oDriver_Mob.findElement(By.xpath("xpath=//*[@text='Select All']")).waitFor(200);
								if (a101.equals(false)) {
									oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
									Thread.sleep(200);
									Boolean a102 = oDriver_Mob.findElement(By.xpath("xpath=//*[@text='Select All']")).waitFor(200);
									if (a102.equals(false)) {
										oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
										Thread.sleep(200);
									}
									Boolean a103 = oDriver_Mob.findElement(By.xpath("xpath=//*[@text='Select All']")).waitFor(200);
									if (a102.equals(false)) {
										oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
										Thread.sleep(200);
									}
								}
								oDriver_Mob.client.click(UIName,"xpath=//*[@text='Select All']", 0, 1);
								Thread.sleep(100);
								oDriver_Mob.client.click(UIName,"xpath=//*[@accessibilityLabel='Cut' and @text='Cut']", 0, 1);
								Thread.sleep(100);
								oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sTestData );
								Thread.sleep(100);
								try {
								if(oObjects[iObjInd].contains("_FaceAmount"))
								{
									oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']", 0, 1);  
									//oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1740']", 0, 1);
								}
									oDriver_Mob.client.closeKeyboard();
								} catch (Exception e1) {

								}
							}
							
							
							else {
								if ((oObjects[iObjInd]
										.equalsIgnoreCase("Bulk_Generation_text"))
										|| (oObjects[iObjInd]
												.equalsIgnoreCase("Email_Details"))) {
									// oTestObject.clear();
									Thread.sleep(1000);
									oTestObject.sendKeys(sTestData);
									Thread.sleep(2000);
									oTestObject.sendKeys(Keys.TAB);
								} else {

									 oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sTestData);

									try {
										
										if (oObjects[iObjInd].equalsIgnoreCase("Mobile_Owner_Ext") || oObjects[iObjInd].equalsIgnoreCase("Emailaddress_owner")){//Remove All else if
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
										}else if (oObjects[iObjInd].equalsIgnoreCase("Mobile_Owner_Num")){
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
											
										}else if (oObjects[iObjInd].equalsIgnoreCase("MobileCode_Life_Assured")){
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
//											oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[17]", 0, 1);
										}else if (oObjects[iObjInd].equalsIgnoreCase("SYG_Priority1_AmtInvest_Max") || oObjects[iObjInd].equalsIgnoreCase("SYG_Priority1_AmtInvest_Min")){
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
//											oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[17]", 0, 1);			
										}else if (oObjects[iObjInd].equalsIgnoreCase("MobileNumber_Life_Assured")){
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
//											oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[17]", 0, 1);
										}else if (oObjects[iObjInd].contains("DOB")){
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
//											oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[17]", 0, 1);
										}else if (oObjects[iObjInd].equalsIgnoreCase("Nameofcompany_Life_Assured")){
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
											oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Done' and @id='Done' and @class='UIAButton']", 0, 1);
//											oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[17]", 0, 1);
											
										}
										//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
										//Thread.sleep(100);
										else {
											//oDriver_Mob.client.click("NATIVE", "nixpath=//*[@id='Done' and @visible='true']", 0, 1); 
																																 
											Boolean a1 = oDriver_Mob.client.isElementFound("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']",0);
											if (a1.equals(true)) {
												oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']", 0, 1); 
											}/*
											Boolean a2 = oDriver_Mob.findElement(By.xpath("(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1740']")).waitFor(500);
											if (a2.equals(true)) {
												oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1740']", 0, 1);
											}*/
											oDriver_Mob.client.closeKeyboard();
											//Sushant Yadav : 29/08/2019 : Done the changes in dynamic wait to decrease execuation time
											//Thread.sleep(100);
										} 
										
									} catch (Exception e) {
										try {
											oDriver_Mob.client.closeKeyboard();
										} catch (Exception e1) {
	
										}
									}

								}
							}
							// }
							break;
						case "HTML.INPUT.TEXT.FOCUS":
							if (oTestObject != null
							&& !sTestData.equalsIgnoreCase("")) {
								oTestObject.sendKeys(sTestData);
								// Actions actions = new Actions(oDriver);
								// actions.moveToElement(oTestObject);
								// actions.click();
								// actions.sendKeys(sTestData);
								// actions.build().perform();
							}
							break;
						case "HTML.INPUT.DATEPICKER":
							if (oTestObject != null) {
								JavascriptExecutor js = (JavascriptExecutor) oDriver;
								js.executeScript("document.getElementById('"
										+ oTestObject
										+ "').setAttribute('attr', '')");
								((JavascriptExecutor) oDriver)
								.executeScript("document.getElementById('"
										+ oTestObject
										+ "').removeAttribute('readonly',0);"); // Enables
								// the
								// from
								// date
								// box
								oTestObject.clear();
								Thread.sleep(1000);
								oTestObject.sendKeys(sTestData);
								Thread.sleep(100);
							}
						case "HTML.INPUT.CHECKBOX":
							if (oTestObject != null) {
								if (sTestData.equalsIgnoreCase("n")) {
									if (oTestObject.isSelected()) {
										oTestObject.click();
									}
								} else {
									oTestObject.getLocation().getX();
									if (!(oTestObject.isSelected())) {
										oTestObject.click();
									}
								}
							} else if (arrTestObjects != null) {
								for (int iObj = 0; arrTestObjects.size() > iObj; iObj = iObj + 1) {
									if (arrTestObjects.get(iObj)
											.getAttribute("value")
											.equals(sTestData)) {
										arrTestObjects.get(iObj).click();
										break;
									}
								}
							}
							break;
						case "HTML.INPUT.RADIO":
							if (oTestObject != null
							&& oTestObject.isDisplayed()) {
								if (oTestObject.isEnabled()) {
									oTestObject.click();
									// while(!(oTestObject.getAttribute("value").equals(sTestData))){
									// oTestObject.click();
									// }
								}

							} else if (arrTestObjects != null) {
								for (int iObj = 0; arrTestObjects.size() > iObj; iObj = iObj + 1) {
									if ((arrTestObjects.get(iObj).getAttribute(
											"value").equals(sTestData))) {
										if ((arrTestObjects.get(iObj)
												.isDisplayed())) {
											arrTestObjects.get(iObj).click();
											// while(!(arrTestObjects.get(iObj).getAttribute("value").equals(sTestData))){
											// arrTestObjects.get(iObj).click();
											// }
										}
										break;
									}
								}
							}
							break;
						case "HTML.SELECT":
							// Select oSelect = new Select(oTestObject);
							// Thread.sleep(100);
							// oSelect.selectByVisibleText(sTestData);
							// (1000);
							try {
								// oTestObject.sendKeys(Keys.TAB);
								String[] sIDArr = sObjProperty1.split("=");
								String sIDProp = sObjProperty1.split("=")[0];
								String sIDVal = sObjProperty1.split("=")[1];
								if (sIDArr.length > 1) {
									sIDVal = sObjProperty1.split(sIDProp + "=")[1];
								}
								((Client) oDriver).hybridSelect("", 0, sIDProp,
										sIDVal, sTestData);
							} catch (Exception e) {
							}
							break;
						case "HTML.SELECT.VALUE":
							String Method = null;
							if (oTestObject1.contains("xpath=")) {
								Method = "xpath";
							} else
								Method = "id";

							oDriver_Mob.client.hybridSelect(UIName, 0, Method,
									oTestObject1, sTestData);
							// Select oSelect1 = new Select(oTestObject);
							// oSelect1.selectByValue(sTestData);
							break;
						case "HTML.SELECT.TEXT":
							oTestObject.click();
							oTestObject = oDriver.findElement(By
									.xpath("//*[contains(text(),'" + sTestData
											+ "')]"));
							oTestObject.click();
							// driver.findElement(By.xpath("//*[contains(text(),sTestData)]")).click();
							// driver.findElement(By.xpath("//li[contains(text(),'75')]")).click();
							// oSelect1.selectByValue(sTestData);
							break;
						case "HTML.TEXTAREA":
							if (oTestObject.isEnabled()) {
								oTestObject.clear();
								oTestObject.sendKeys(sTestData);
							}
							break;
						}
						// ((MobileWebDriver) oDriver).useWebIdentification();
					} else {
						if (sTestData == null || sTestData.equals("")) {
							sTestData = "";
							if (oObjects[iObjInd].equalsIgnoreCase("User_ID")
									|| oObjects[iObjInd]
											.equalsIgnoreCase("Password")) {
								// oTestObject.click();
								oDriver_Mob.client.elementSendText("Native", oTestObject1, 0, "");
								//oTestObject.clear();
								try {
									// ((MobileWebDriver)
									// oDriver).device().closeKeyboard();;
									oDriver_Mob.device().closeKeyboard();

									// Thread.sleep(1000);
								} catch (Exception e) {

								}
							}
						}
					}
				} else {
					// oTestObject=
					// oDriver.findElement(By.xpath("//html/body/div[3]/table[3]/tbody/tr[1]/td[1]"));
					if (sTestData != null
							&& !sTestData.equals("")
							&& ((oTestObject != null && oTestObject.isEnabled()) || arrTestObjects != null)) {
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
							if (oTestObject.isEnabled()
									&& !(oTestObject.getAttribute("readonly") != null && oTestObject
									.getAttribute("readonly").equals(
											"true"))) {
								if (oObjects[iObjInd].equalsIgnoreCase("prem")) {
									oTestObject.clear();
									Thread.sleep(1000);
									oTestObject.sendKeys(sTestData);
									Thread.sleep(100);
									oTestObject.sendKeys(Keys.TAB);
								} else {
									if ((oObjects[iObjInd]
											.equalsIgnoreCase("Bulk_Generation_text"))
											|| (oObjects[iObjInd]
													.equalsIgnoreCase("Email_Details"))) {
										// oTestObject.clear();
										Thread.sleep(1000);
										oTestObject.sendKeys(sTestData);
										Thread.sleep(2000);
										oTestObject.sendKeys(Keys.TAB);
									} else {
										oTestObject.clear();
										Thread.sleep(1000);
										oTestObject.sendKeys(sTestData);
										Thread.sleep(100);
										// oTestObject.sendKeys(Keys.TAB);
									}
								}
							}
							break;
						case "HTML.INPUT.TEXT.FOCUS":
							if (oTestObject != null
							&& !sTestData.equalsIgnoreCase("")) {
								Actions actions = new Actions(oDriver);
								actions.moveToElement(oTestObject);
								actions.click();
								actions.sendKeys(sTestData);
								actions.build().perform();
							}
							break;
						case "HTML.INPUT.DATEPICKER":
							if (oTestObject != null) {
								JavascriptExecutor js = (JavascriptExecutor) oDriver;
								js.executeScript("document.getElementById('"
										+ oTestObject
										+ "').setAttribute('attr', '')");
								((JavascriptExecutor) oDriver)
								.executeScript("document.getElementById('"
										+ oTestObject
										+ "').removeAttribute('readonly',0);"); // Enables
								// the
								// from
								// date
								// box
								oTestObject.clear();
								Thread.sleep(1000);
								oTestObject.sendKeys(sTestData);
								Thread.sleep(100);
							}
						case "HTML.INPUT.CHECKBOX":
							if (oTestObject != null) {
								if (sTestData.equalsIgnoreCase("n")) {
									if (oTestObject.isSelected()) {
										oTestObject.click();
									}
								} else {
									if (!(oTestObject.isSelected())) {
										oTestObject.click();
									}
								}
							} else if (arrTestObjects != null) {
								for (int iObj = 0; arrTestObjects.size() > iObj; iObj = iObj + 1) {
									if (arrTestObjects.get(iObj)
											.getAttribute("value")
											.equals(sTestData)) {
										arrTestObjects.get(iObj).click();
										break;
									}
								}
							}
							break;
						case "HTML.INPUT.RADIO":
							if (oTestObject != null
							&& oTestObject.isDisplayed()) {
								if (oTestObject.isEnabled()) {
									oTestObject.click();
									// while(!(oTestObject.getAttribute("value").equals(sTestData))){
									// oTestObject.click();
									// }
								}
							} else if (arrTestObjects != null) {
								for (int iObj = 0; arrTestObjects.size() > iObj; iObj = iObj + 1) {
									if ((arrTestObjects.get(iObj).getAttribute(
											"value").equals(sTestData))) {
										if ((arrTestObjects.get(iObj)
												.isDisplayed())) {
											arrTestObjects.get(iObj).click();
											// while(!(arrTestObjects.get(iObj).getAttribute("value").equals(sTestData))){
											// arrTestObjects.get(iObj).click();
											// }
										}
										break;
									}
								}
							}
							break;
						case "HTML.SELECT":
							Select oSelect = new Select(oTestObject);
							Thread.sleep(100);
							oSelect.selectByVisibleText(sTestData);
							Thread.sleep(1000);
							try {
								oTestObject.sendKeys(Keys.TAB);
							} catch (Exception e) {
							}
							break;
						case "HTML.SELECT.VALUE":
							Select oSelect1 = new Select(oTestObject);
							oSelect1.selectByValue(sTestData);
							break;
						case "HTML.SELECT.TEXT":
							oTestObject.click();
							oTestObject = oDriver.findElement(By
									.xpath("//*[contains(text(),'" + sTestData
											+ "')]"));
							oTestObject.click();
							// driver.findElement(By.xpath("//*[contains(text(),sTestData)]")).click();
							// driver.findElement(By.xpath("//li[contains(text(),'75')]")).click();
							// oSelect1.selectByValue(sTestData);
							break;
						case "HTML.TEXTAREA":
							if (oTestObject.isEnabled()) {
								oTestObject.clear();
								oTestObject.sendKeys(sTestData);
							}
							break;
						}
					} else {
						if (sTestData == null) {
							sTestData = "";
						}
						if (!sTestData.equals("")
								&& ((oTestObject == null || arrTestObjects == null))) {
							String sTempStepKeyword = "";
							sTempStepKeyword = sSFStepKeyword;
							sSFStepKeyword = "Object Not present on application";
							screens();
							if (sOutput.equals("")) {
								sOutput = oObjects[iObjInd]
										+ " is not present on the application. Test Data is : "
										+ sTestData;
							} else {
								sOutput = sOutput
										+ " | "
										+ oObjects[iObjInd]
												+ " is not present on the application. Test Data is : "
												+ sTestData;
							}
							logger.info(sOutput);
							iReturnValue = 1;
							iRCTCTerminateInd = 1;
							// iTerminateInd = 1;
						}
					}
				}
			}
		} catch (Exception e) {
			try {
				logger.info("Inside  InputData exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				logger.error("InputData exception: " + e.getMessage());
			} catch (Exception e1) {
				iReturnValue = 1;
			}
		}
		try {
			oDriver_Mob.client.closeKeyboard();
		} catch (Exception e1) {

		}
		return iReturnValue;
	}

	public int isavailable() {
		logger.info("Inside IsAvailable");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			String[] oObjects = sIDSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				GetObj(oObjects[iObjInd]);
				String sField = oObjects[iObjInd];
				String sExpected = oObjects[iObjInd]
						+ " should be available on the screen";
				String sActual = "";
				String sCompareResult = "";
				if (oTestObject != null && oTestObject.isEnabled()) {
					sActual = oObjects[iObjInd] + " is available on the screen";
					sCompareResult = "Pass";
				} else {
					sActual = oObjects[iObjInd]
							+ " is not available on the screen";
					sCompareResult = "Fail";
				}
				// WebDriverWait myDynamicElement_a = new WebDriverWait(oDriver,
				// 180);
				// myDynamicElement_a.until(ExpectedConditions.elementToBeClickable(oTestObject));
				if (sRCTestcaseID == null || sRCTestcaseID == "") {
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					logger.info("sQuery="
							+ "insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
							+ ") Values" + "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
					oStmt.executeUpdate("insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype) Values"
							+ "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
				} else {
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					logger.info("sQuery="
							+ "insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype) Values"
							+ "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sRCTestcaseID
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
					oStmt.executeUpdate("insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype) Values"
							+ "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sRCTestcaseID
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
				}
			}
		} catch (Exception e) {
			try {
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int isselected() {
		logger.info("Inside  IsSelected");
		iReturnValue = 0;
		int sFlag = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			String[] oObjects = sIDSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				GetObj(oObjects[iObjInd]);
				String sField = oObjects[iObjInd];
				String sExpected = oObjects[iObjInd]
						+ " should be Selected on the screen";
				String sActual = "";
				String sCompareResult = "";
				if (oTestObject != null && oTestObject.isSelected()) {
					sActual = oObjects[iObjInd] + " is selected on the screen";
					sCompareResult = "Pass";

				} else {
					sActual = oObjects[iObjInd]
							+ " is not selected on the screen";
					sCompareResult = "Fail";
				}
				// WebDriverWait myDynamicElement_a = new WebDriverWait(oDriver,
				// 180);
				// myDynamicElement_a.until(ExpectedConditions.elementToBeClickable(oTestObject));
				if (sRCTestcaseID == null || sRCTestcaseID == "") {
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					logger.info("sQuery="
							+ "insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
							+ ") Values" + "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
					oStmt.executeUpdate("insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype) Values"
							+ "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
				} else {
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					logger.info("sQuery="
							+ "insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype) Values"
							+ "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sRCTestcaseID
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
					oStmt.executeUpdate("insert into QTP_CompareResult (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype) Values"
							+ "('"
							+ sPlanID
							+ "','"
							+ sReleaseID
							+ "','"
							+ sCycleID
							+ "','"
							+ sModule
							+ "','"
							+ sSubModule
							+ "','"
							+ sPlanTestcaseId
							+ "','"
							+ sRCTestcaseID
							+ "','"
							+ sScenarioId
							+ "','"
							+ sTCID
							+ "','"
							+ sField
							+ "','"
							+ sExpected
							+ "','"
							+ sActual
							+ "','"
							+ sCompareResult
							+ "','"
							+ sMobDeviceName
							+ "','"
							+ sTestType + "')");
				}
			}
		} catch (Exception e) {
			try {
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public void getobjclass(String sObjectName) {
		logger.info("Inside GetObjClass");
		try {
			sKeywordName = sObjectName;
			ResultSet oRSOR = executequery("OR");
			oRSOR.first();
			if (!oRSOR.getString("Object_Class").equals("")) {
				sObjClass = oRSOR.getString("Object_Class").split(":=")[1];
			} else {
				sObjClass = "";
			}

		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public void GetObj(String sObjectName) {
		logger.info("Inside GetObj");
		try {
			sKeywordName = sObjectName;
			ResultSet oRSOR;
			
			if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
				oRSOR = executequery("OR");
//				if (iExecuteQueryInd == 1) {
//					iExecuteQueryInd = 0;
////					oRSOR = executequery("OR");
//				}
				oRSOR.first();
				sUIName = oRSOR.getString("UI_Name");
				if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
					// if (!(sBrowser.equalsIgnoreCase("NA")))
					// updated by latha on 13Feb2018: present condition Browser
					// is NA
					if ((sBrowser.equalsIgnoreCase("NA"))) {
						if (sUIName.equalsIgnoreCase("Native")) {
							// ((MobileWebDriver)
							// oDriver).useNativeIdentification();
							oDriver_Mob.useNativeIdentification();
						} else {
							// ((MobileWebDriver)
							// oDriver).useWebIdentification();
							oDriver_Mob.useWebIdentification();
						}
					}
				}
			} else {
				oRSOR = executequery("OR");
			}
			oRSOR.first();
			String sObjectClassName = "", sObjectClassValue = "", sObjectProperty = "", sObjectValue = "", sObjPosition = "", sObjProperty = "";
			List<WebElement> oTestObjects = null;
			arrTestObjects = null;
			oTestObject = null;
			String sSetVal="";
			int ival=0;
			if (!oRSOR.getString("Object_Class").equals("")) {
				sObjectClassName = oRSOR.getString("Object_Class").split(":=")[0];
				sObjectClassValue = oRSOR.getString("Object_Class").split(":=")[1];
				if (oRSOR.getString("Object_Property").contains("$$")) {
					sSetVal = (oGlobalMap.get(oRSOR.getString("Object_Property").split("\\$\\$")[1].toLowerCase()));
					sObjProperty = oRSOR.getString("Object_Property").replace("$$"+ oRSOR.getString("Object_Property").split("\\$\\$")[1] + "$$", sSetVal);
					TestValue = sSetVal;
					ival=1;
				} 
				if (oRSOR.getString("Object_Property").contains("##")) {
					sSetVal = (oGlobalMap.get(oRSOR.getString("Object_Property").split("\\#\\#")[1].toLowerCase()));
					sObjProperty = sObjProperty.replace("##"+ oRSOR.getString("Object_Property").split("\\#\\#")[1] + "##", sSetVal);
					TestValue = sSetVal;
					ival=1;
				}
				else if (ival != 1){
					sObjProperty = oRSOR.getString("Object_Property");
					TestValue = "value";
				}
				sObjProperty1 = sObjProperty;
				if (sObjProperty.split(":=").length == 1) {
					sObjectProperty = sObjProperty.split(":=")[0];
					sObjectValue = "";
				} else if (sObjProperty.split(":=").length == 2) {
					sObjectProperty = sObjProperty.split(":=")[0];
					sObjectValue = sObjProperty.split(":=")[1];
				} else if (sObjProperty.split(":=").length == 3) {
					sObjectProperty = sObjProperty.split(":=")[0];
					sObjectValue = sObjProperty.split(":=")[1];
					sObjPosition = sObjProperty.split(":=")[2];
				}
				logger.info("Object Properties :  " + sObjectClassName + "="
						+ sObjectClassValue + "," + sObjectProperty + "="
						+ sObjectValue);
			}
			try {
				// updated by latha on 03Oct2018: to handle nixpath
				if (sObjectProperty.equalsIgnoreCase("xpath")||sObjectProperty.equalsIgnoreCase(".xpath")) {
					if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
						oTestObject1 = "xpath=" + sObjectValue;
//						 sElementFound =oDriver_Mob.client.isElementFound("NATIVE",""+oTestObject1+"",0);
					} else {
						oTestObjects = oDriver.findElements(By
								.xpath(sObjectValue));
					}
				
					//Sushant Yadav : 08082019 :When require to handle object base on Position in Seetest
					if(sObjPosition != null && !sObjPosition.equals(""))
					{
						if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
							oTestObject1 = "xpath=" + sObjectValue + ":=" + sObjPosition ;
//							 sElementFound =oDriver_Mob.client.isElementFound("NATIVE",""+oTestObject1+"",0);
						} else {
							oTestObjects = oDriver.findElements(By
									.xpath(sObjectValue));
						}
					}
					// oTestObjects=
					// oDriver.findElements(By.xpath("//*[@id='collap-on1_2']/div[8]/div[2]/div/div/div/img"));
				} else if (sObjectProperty.equalsIgnoreCase("id")||sObjectProperty.equalsIgnoreCase(".id")) {
					if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
						oTestObject1 = "id=" + sObjectValue;
					} else {
						oTestObjects = oDriver
								.findElements(By.id(sObjectValue));
					}
				} 
				else if (sObjectProperty.equalsIgnoreCase("nixpath")||sObjectProperty.equalsIgnoreCase(".nixpath")) {
					if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
						oTestObject1 = "nixpath=" + sObjectValue;
					} 
				} 
				else {
					switch (sObjectClassValue.toUpperCase()) {
					case "HTML.INPUT.TEXT":
					case "HTML.SELECT.TEXT":
					case "HTML.INPUT.CHECKBOX":
					case "HTML.INPUT.BUTTON":
					case "HTML.INPUT.SUBMIT":
					case "HTML.INPUT.RADIO":
						logger.info("Property := " + "//*[@"
								+ sObjectProperty.replace(".", "") + "='"
								+ sObjectValue + "']");
						if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
							oTestObject1 = "xpath=//*[@"
									+ sObjectProperty.replace(".", "") + "='"
									+ sObjectValue + "']";
						} else {
							oTestObjects = oDriver.findElements(By
									.xpath("//*[@"
											+ sObjectProperty.replace(".", "")
											+ "='" + sObjectValue + "']"));
						}
						break;
					case "HTML.SELECT":
						oTestObjects = oDriver.findElements(By
								.xpath("//select[@"
										+ sObjectProperty.replace(".", "")
										+ "='" + sObjectValue + "']"));
						break;
					case "HTML.A":
					case "HTML.DATE":
						// oTestObjects =
						// oDriver.findElements(By.linkText(sObjectValue));
						oTestObjects = oDriver.findElements(By
								.linkText(sObjectValue));
						break;
					case "HTML.A.PARTIAL":
						// Modified by Seema
						oTestObjects = oDriver.findElements(By
								.partialLinkText((sObjectValue).replaceAll(
										"\\s+", " ")));
						break;
					case "HTML.DIV":
						oTestObjects = oDriver.findElements(By.xpath("//div[@"
								+ sObjectProperty.replace(".", "") + "='"
								+ sObjectValue + "']"));
						break;
					case "HTML.SPAN":
						oTestObjects = oDriver.findElements(By.xpath("//span[@"
								+ sObjectProperty.replace(".", "") + "='"
								+ sObjectValue + "']"));
						break;
					case "HTML.TABLE":
						oTestObjects = oDriver.findElements(By
								.xpath("//table[@"
										+ sObjectProperty.replace(".", "")
										+ "='" + sObjectValue + "']"));
						break;
					case "HTML.TD":
						oTestObjects = oDriver.findElements(By.xpath("//td[@"
								+ sObjectProperty.replace(".", "") + "='"
								+ sObjectValue + "']"));
						break;
					case "HTML.IMAGE":
						oTestObjects = oDriver.findElements(By.xpath("//img[@"
								+ sObjectProperty.replace(".", "") + "='"
								+ sObjectValue + "']"));
						break;
						// case "HTML.DATE":
						// oTestObjects =
						// oDriver.findElements(By.linkText(sObjectValue));
						// break;
					case "HTML.FRAME":
						oTestObjects = oDriver
						.findElements(By.id(sObjectValue));
						break;
					case "HTML.DIALOGBUTTON":
						try {
							oDriver.switchTo().alert();
							oDriver.switchTo().alert().accept();
						} catch (Exception e) {
							logger.info("Alert was not present");
						}
						break;
					}
				}
			} catch (UnhandledAlertException e) {
				logger.info("Alert skipped : " + e.getAlertText());
			}

			if (oTestObject1 != null && oTestObject1.length() > 1) {
				sObjClass = sObjectClassValue;
			} else if (oTestObjects != null && oTestObjects.size() == 1) {
				oTestObject = oTestObjects.get(0);
				sObjClass = sObjectClassValue;
			} else if (oTestObjects != null && oTestObjects.size() > 1) {
				arrTestObjects = oTestObjects;
				sObjClass = sObjectClassValue;
				if (oRSOR.getString("Object_Property").split(":=").length == 3) {
					oTestObject = oTestObjects.get(Integer
							.parseInt(sObjPosition));
					arrTestObjects = null;
				} else {
					oTestObject = oTestObjects.get(0);
					arrTestObjects = null;
				}
			} else {
				oTestObject = null;
				arrTestObjects = null;
				sObjClass = sObjectClassValue;
				logger.info(sObjectName + " not found");

			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {

				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	@SuppressWarnings("deprecation")
	public int navigateurl() {
		logger.info("Inside NavigateURL");
		ResultSet oRSQueryPS;
		iReturnValue = 0;
		try {
			String ServerIP = "";
			if (sSFStepKeyword.equals("")) {

				Statement oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				String sevnexeqry = "select top(1) planlausername,planenvname,querytype from qath_testplan_executor where planmodule = '"
						+ sModule
						+ "'  and plansubmodule = '"
						+ sSubModule
						+ "' and planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and device = '"
						+ sMobDeviceName
						+ "'  order by plantestcaseid";
				logger.info(sevnexeqry);
				ResultSet oRSEnv = oStmt.executeQuery(sevnexeqry);
				if (!oRSEnv.next()) {
					sStatus = "Fail";
					sOutput = "Environment not Found";
					sExpectedResult = "";
					logger.info("Environment not Found");
				} else {
					String env = oRSEnv.getString("planenvname").split("-")[0];
					oRSEnv.close();
					if (!(env.equals(""))) {
						// oRSEnv =
						
						//Swapnil Parab - 13-May-19
						Statement oStmt1 = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						String sevnexeqry1 ="select * from server_master where server_name in (Select server_name from environment_master where env_name = '"
						 + env + "')";
						logger.info(sevnexeqry1);
						ResultSet oRSEnv1 = oStmt.executeQuery(sevnexeqry1);
						 if (oRSEnv1.next()) {
							 String Server = oRSEnv1.getString("server_ip");
							 if (Server.contains(":")) {
								 Server = oRSEnv1.getString("server_ip").split(":")[1];
								 if (Server.equalsIgnoreCase("Integration")) {
									 sIntegrationFlag ="Y";
								 }
								 else {
									 sIntegrationFlag="";
								 }
							 }else {
								 sIntegrationFlag="";
							 }
						 }
						// update by latha on 14FEB2018 : for mobile automation
						// env,server ip is not required
						if (sMobDeviceName.equalsIgnoreCase("desktop")) {
							oRSEnv = oStmt
									.executeQuery("select * from environment_master where env_name = '"
											+ env + "'");
							if (!oRSEnv.next()) {
								// sStatus = "Fail";
								sOutput = "Server IP not Found";
								sExpectedResult = "";
								logger.info("Server IP not Found");
							} else {
								ServerIP = oRSEnv.getString("db_dsn");
							}
						}
					} else {
						sStatus = "Fail";
						sOutput = "Environment name is blank";
						sExpectedResult = "";
						logger.info("Environment name is blank");
					}
				}
			} else {
				ServerIP = oGlobalMap.get(sSFStepKeyword.toLowerCase());
			}
			// if(!(ServerIP.equals(""))){
			// updated by latha on 13Feb2018: present condition Server is NA
			if ((!(ServerIP.equals("NA"))) || (!(ServerIP.equals("")))) {
				// String ServerIP = oRSEnv.getString("server_name");
				// String ServerIP = oRSEnv.getString("server_ip");
				// String ServerIP = oRSEnv.getString("db_dsn");
				// For Web Based Applications
				SessionId sSessionId = null;
				try {
					sSessionId = ((RemoteWebDriver) oDriver).getSessionId();
				} catch (Exception e) {
				}
				if (oDriver != null && sSessionId != null) {
					closeapp();
				}
				String sDPQry = "select value from parameter_setup where parameter = 'Driver_Path'";
				logger.info("sQuery=" + sDPQry);
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				oRSQueryPS = oStmt.executeQuery(sDPQry);
				if (oRSQueryPS.next()) {
					ChromeDriver_Path = oRSQueryPS.getString("value");
					System.out.println(ChromeDriver_Path);
				}
				// else{
				// ChromeDriver_Path = "D:/";
				// }
				// oRSQueryPS.close();
				//
				if (sMobDeviceName.equalsIgnoreCase("desktop")) {
					if (sBrowser.equals("IE")) {
						System.setProperty("webdriver.ie.driver",
								"IEDriverServer.exe");
						Map<String, Boolean> prefs = new Hashtable<String, Boolean>();
						prefs.put("download.prompt_for_download", true);
						DesiredCapabilities cap = new DesiredCapabilities();
						cap.setCapability(
								CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
								org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE);
						cap.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
						cap.setCapability("prefs", prefs);
						oDriver = new InternetExplorerDriver(cap);
					} else if (sBrowser.equals("Chrome")) {
						System.setProperty("webdriver.chrome.driver",
								ChromeDriver_Path);
						Map<String, Boolean> prefs = new Hashtable<String, Boolean>();
						prefs.put("download.prompt_for_download", true);
						ChromeOptions options = new ChromeOptions();
						HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
						options.setExperimentalOptions("prefs", prefs);
						options.addArguments("--test-type");
						options.addArguments("--disable-extensions");
						DesiredCapabilities cap = DesiredCapabilities.chrome();
						cap.setCapability(ChromeOptions.CAPABILITY,
								chromeOptionsMap);
						cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						cap.setCapability(ChromeOptions.CAPABILITY, options);
						oDriver = new ChromeDriver(cap);
					} else {
						Map<String, Boolean> prefs = new Hashtable<String, Boolean>();
						prefs.put("download.prompt_for_download", true);
						DesiredCapabilities cap = new DesiredCapabilities();
						cap.setCapability(
								CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
								org.openqa.selenium.UnexpectedAlertBehaviour.IGNORE);
						cap.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
						cap.setCapability("prefs", prefs);
						oDriver = new FirefoxDriver(cap);
					}
					oDriver.manage().timeouts()
					.implicitlyWait(2, TimeUnit.SECONDS);
					oDriver.manage().window().maximize();
					oDriver.get(ServerIP);
					waitforpageload();
					Thread.sleep(2000);
				} else {
					ResultSet oRSQueryMQ;
					String sMQry = "select App_Package, App_Activity, port_number, browser_name from device_master where  Device_Name = '"
							+ sMobDeviceName + "'";
					logger.info("sQuery=" + sMQry);
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					oRSQueryMQ = oStmt.executeQuery(sMQry);
					String sBrowserName = "";
					if (oRSQueryMQ.next()) {
						sBrowserName = oRSQueryMQ.getString("browser_name");
						// if (sBrowserName.equals(""))
						// updated by latha 13Feb2018: as sBrowserName is null
						if (sBrowserName == null || sBrowserName.equalsIgnoreCase("")) {
							// AppURL = oRSQueryMQ.getString("App_Package") +
							// "/" + oRSQueryMQ.getString("App_Activity");
							AppURL = oRSQueryMQ.getString("App_Activity");
							AppUrl1 = AppURL;
						} else {
							AppURL = oRSQueryMQ.getString("browser_name") + ":"
									+ oRSQueryMQ.getString("App_Package");
						}
						port = Integer.parseInt(oRSQueryMQ.getString("port_number"));
					} else {
						port = 8889;
					}
					oRSQueryMQ.close();
//					WebDriverWait wait = new WebDriverWait(oDriver_Mob, 30);
					// oDriver = new MobileWebDriver(host, port);
					oDriver_Mob = new MobileWebDriver(host, port);
					// oDriver_Mob.client.setSpeed("Fast");
					//oDriver_Mob.client.setClientDebugStatus(false);
					//oDriver_Mob.client.setDefaultTimeout(2);
				//	oDriver_Mob.client.setDefaultClickDownTime(2);

					// ((MobileWebDriver)
					// oDriver).setDevice(sMobDeviceName.replace("_", ":")); //
					// "adb:SM-T825");
					// updated by latha on 13Feb2018 : to replace - to :
					
					oDriver_Mob.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//					oDriver_Mob.device().wait(2000);
//					oDriver_Mob.client.
					//Sushant Yadav :25/07/2019
					String sMobDeviceName1 = sMobDeviceName; 
					if(sMobDeviceName.contains("LMS"))
					{
						sMobDeviceName1 = sMobDeviceName1.replace("LMS_","");
					}
					oDriver_Mob.client.setDevice(sMobDeviceName1.replace("-",":"));// "ios_app:iPad Pro"
				//	oDriver_Mob.client.setDevice("ios_app:iPad779");
					oDriver_Mob.client.setSpeed("Fast");
					oDriver_Mob.client.setShowPassImageInReport(false);
					// oDriver_Mob.client.setShowImageInReport(false);
					
					// oDriver_Mob.client.clearDeviceLog();
					
//					oDriver_Mob.client.setDisableConsole(true);
//					oDriver_Mob.client.setShowReport(false);
					
					// ((MobileWebDriver)
					oDriver_Mob.client.setShowImageInReport(false);
					oDriver_Mob.device().openScreen();
					oDriver_Mob.client.launch(AppURL, true, true);// application(AppURL).launch(true,
					// true);
					// Thread.sleep(1000);
					// ((MobileWebDriver)
					oDriver_Mob.client.setWebAutoScroll(true);
//					oDriver_Mob.client.setThrowExceptionOnFail(true);
					oDriver_Mob.client.setThrowExceptionOnFail(false);
					// "chrome:https://buy-pact.prudential.com.sg/d2c/pl_entry").launch(true,
					// false);
					// if (!(sBrowserName.equals(""))){
					// updated by latha 13Feb2018: as sBrowserName is null
					if (!(sBrowserName == null)) {
						// ((MobileWebDriver) oDriver).useWebIdentification();
						oDriver_Mob.useWebIdentification();
					}
				}
			}
		} catch (Exception e) {
			try {
				sOutput = "NavigateURL function Failed";

				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				captureerror();
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {
				iReturnValue = 1;
			}
		}
		return iReturnValue;
	}

	public int navigate() {
		logger.info("Inside NavigateObjects");
		iReturnValue = 0;
		String temp = "";
		try {
			
			String[] oObjects = sSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				temp = oChildObjects[0];
				GetObj(oChildObjects[0]);
				if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {

					if (sUIName.equalsIgnoreCase("Native")) {

						oDriver_Mob.useNativeIdentification();
						UIName = "Native";
					} else {

						oDriver_Mob.useWebIdentification();
						UIName = "WEB";
					}

				}

				if ((oChildObjects[0].equalsIgnoreCase("policy_document_pdf"))
						&& (!(sMobDeviceName.equalsIgnoreCase("Desktop")))) {
					oDriver.findElement(
							By.xpath("//*[@id='PL-what-support-1']")).click();
				} else {
					if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
						if (TestValue != null && !TestValue.equals("")) {
							switch (sObjClass.toUpperCase()) {
							case "HTML.INPUT.BUTTON":
								if(oChildObjects[0].equalsIgnoreCase("BackBtn"))
								{
									Thread.sleep(100);
									oDriver_Mob.client.setProperty("iosDevice.nonInstrumented", "false");
									Thread.sleep(300);
								}else if(oChildObjects[0].equalsIgnoreCase("HomeBtn"))
								{
									oDriver_Mob.client.setProperty("iosDevice.nonInstrumented", "false");
									Thread.sleep(300);
								}else if(oChildObjects[0].equalsIgnoreCase("ProceedToeSub_Btn"))
								{
									oDriver_Mob.client.setProperty("iosDevice.nonInstrumented", "false");
									Thread.sleep(300);
								}
								//Thread.sleep(100);
								oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
								Thread.sleep(300);
								break;
							case "HTML.INPUT.TEXT":
								//Thread.sleep(100);
								oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
								Thread.sleep(300);
								break;
							case "HTML.INPUT.TEXT.KEYBOARD":
								//Thread.sleep(100);
								oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
								Thread.sleep(300);
								 /*Boolean a1 =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='OK']",0);
								if (a1.equals(true))
								{
									oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
									Thread.sleep(500);
								}*/
								try {
									//oDriver_Mob.client.click("NATIVE", "nixpath=//*[@id='Done' and @visible='true']", 0, 1);
									oDriver_Mob.client.closeKeyboard();
									//Thread.sleep(200);
								}catch(Exception e) {
									oDriver_Mob.client.closeKeyboard();
								}
								break;
							case "HTML.INPUT.CLEAR":	
								String str = oDriver_Mob.client.elementGetText(UIName, oTestObject1, 0);
								if(!str.equalsIgnoreCase("")){
								for (int i = 0; i < str.length(); i++) {
									
									oDriver_Mob.client.click(UIName, "xpath=//*[@text='fca input delete icon']",0, 1);
								}
								}
								else
								{
									
								}
								break;
							case "HTML.INPUT.CM":
								//oDriver_Mob.findElementByXPath("//*[@class='UIATextField' and (./preceding-sibling::* | ./following-sibling::*)[@text]]").clear();
								for (int i = 0; i < TestValue.length(); i++) {
									String sTestObj = oTestObject1.replace("'"
											+ TestValue + "'",
											"'" + TestValue.charAt(i) + "'");
									System.out.println(sTestObj);
									oDriver_Mob.client.click(UIName, sTestObj,
											0, 1);
								}
								break;

							default:
								if (oTestObject1 != null) {
									oDriver_Mob.client.click(UIName,
											oTestObject1, 0, 1);
								}
								break;
							}
						}
//						else if (TestValue != null && !TestValue.equals("")) {
//							iReturnValue = 1;
//							iRCTCTerminateInd = 1;
//							if (sOutput.equals("")) {
//								sOutput = "Object "+ oChildObjects[0] +" not found on application with Testdata = " +TestValue;
//							} else {
//								sOutput = sOutput + " | " + "Object "+ oChildObjects[0] +" not found on application with Testdata = " +TestValue;
//							}
//						}
					} else if ((oTestObject != null) || arrTestObjects != null) {
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.BUTTON":
							if ((!(sMobDeviceName.equalsIgnoreCase("desktop")))
									&& (oChildObjects[0]
											.equalsIgnoreCase("Review_Submit_Button"))) {
								oDriver.findElement(
										By.xpath("//*[@id='btnContinueToReviewSummary']"))
										.click();
							} else if ((oChildObjects[0]
									.equalsIgnoreCase("Verification_Submit_Page"))
									&& (!(sMobDeviceName
											.equalsIgnoreCase("Desktop")))) {
								oDriver.findElement(
										By.xpath("//*[@id='makePayment']/span[1]"))
										.click();
							} else if ((oChildObjects[0]
									.equalsIgnoreCase("Payment_Submit_Button"))
									&& (!(sMobDeviceName
											.equalsIgnoreCase("Desktop")))) {
								oDriver.findElement(
										By.id("summaryCommonPayment")).click();
								// ((MobileWebDriver)
								// oDriver).device().swipe("Down", 0, 500);
								oDriver.findElement(
										By.xpath("//*[@id='submitBtn']"))
										.click();
							} else {
								if (oTestObject != null
										&& oTestObject.isDisplayed()) {
									oTestObject.click();

								}

								else if (arrTestObjects != null) {
									for (int iTemp = 0; iTemp < arrTestObjects
											.size(); iTemp++) {
										if (arrTestObjects.get(iTemp)
												.isDisplayed()) {
											arrTestObjects.get(iTemp).click();
										}
									}
								} else if (oTestObject != null) {
									oTestObject.click();
								}
							}
							break;
						case "HTML.A":
						case "HTML.IMAGE":
							if (oTestObject != null) {
								if (iObjectSize > 1
										&& oChildObjects[1].equals("hover")) {
									// Actions action = new
									// Actions(oDriver);
									// action.moveToElement(oTestObject).perform();
									((JavascriptExecutor) oDriver)
									.executeScript(
											"arguments[0].click();",
											oTestObject);
								} else if (iObjectSize > 1
										&& oChildObjects[1]
												.equals("hoverPerform")) {
									Actions action = new Actions(oDriver);
									Thread.sleep(2000);
									action.moveToElement(oTestObject).perform();
								} else if (iObjectSize > 1
										&& oChildObjects[1].equals("js")) {
									((JavascriptExecutor) oDriver)
									.executeScript(
											"arguments[0].click();",
											oTestObject);
								} else if (oTestObject
										.getText()
										.equalsIgnoreCase(
												"Low Termination Value Cases -- Refund post interest")) {
									List<WebElement> k = oDriver
											.findElements(By.id("iv_0"));
									k.get(1).click();
								} else {
									try {
										oTestObject.click();
									} catch (Exception e) {
									}
								}
							}
							break;
						case "HTML.SELECT":
							if (oTestObject != null) {
								Actions action = new Actions(oDriver);
								action.moveToElement(oTestObject);
								action.click().build().perform();
							}
							break;

						default:
							if (oTestObject != null
							&& oTestObject.isDisplayed()) {
								oTestObject.click();
							}
							break;
						}
					}
				}

			}
			if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
				if (!(sBrowser.equalsIgnoreCase("NA"))) {
					// ((MobileWebDriver) oDriver).useWebIdentification();
					oDriver_Mob.useWebIdentification();
				}
			}
		} catch (Exception e) {
			try {
				sOutput = "Error at element :  " + temp;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				captureerror();
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				// iTerminateInd = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {
				iReturnValue = 1;
			}
		}
		return iReturnValue;
	}
	
	
	public int swipewhilenotfound() {
		logger.info("Inside swipewhilenotfound");
		iReturnValue = 0;
		String sFundAmt ="";
		try {
			
		}catch(Exception e) {
			logger.info(""+e.getMessage());
		}
		return iReturnValue;
	}
	
	
	public int fundselection() {
		logger.info("Inside fundselection");
		iReturnValue = 0;
		String sFundAmt ="";
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				logger.info("Object Name=" + oChildObjects[0]);
				GetObj(oChildObjects[0]);
				if (oTestObject == null && arrTestObjects != null) {
					oTestObject = arrTestObjects.get(0);
					arrTestObjects = null;
				}
				
				oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sQuery = "select "+oChildObjects[0]+" , * from "+sTableName+" where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and test_case = '"
						+ sPlanTestcaseId
						+ "'";
				
				logger.info(sQuery);
				ResultSet oRSQuery = oStmt
						.executeQuery(sQuery);
				if (oRSQuery.next()) {
					sFundAmt = oRSQuery.getString(oChildObjects[0]);
				 if (!sFundAmt.equalsIgnoreCase("")) {

				  
					//Sushant Yadav : 08/07/2019 : Screen to scrolling properly. 
					 String oTestObject2[]=oTestObject1.split("xpath=");
					 String oTestObject3 =oTestObject2[1];
					Boolean a11 = oDriver_Mob.findElement(By.xpath(oTestObject3)).waitFor(200); 
					if(a11.equals(false))
					{
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@accessibilityLabel='Fund Allocation']", 0, "Up", 300, 200);
					}
				    Thread.sleep(500);					 
					oDriver_Mob.client.swipeWhileNotFound("Down", 700, 1000, "NATIVE", oTestObject1, 0, 1000, 10, false); 
				    oDriver_Mob.client.click("NATIVE", oTestObject1, 0, 1);
				    Thread.sleep(100);
				    oDriver_Mob.client.elementSendText("NATIVE", oTestObject1, 0, sFundAmt);
				    Thread.sleep(200);
				    try {
				    	Boolean a1 = oDriver_Mob.client.isElementFound("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']",0);
						if (a1.equals(true)) {
							oDriver_Mob.client.click("NATIVE", "nixpath=//*[@value='Hide keyboard' and @id='Hide keyboard' and @class='UIAButton']", 0, 1); 
						}
						oDriver_Mob.client.closeKeyboard();
						Thread.sleep(100);
						/*Boolean a1 = oDriver_Mob.findElement(By.xpath("(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1874']")).waitFor(200);
						if (a1.equals(true)) {
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1874']", 0, 1);
						}
						Boolean a2 = oDriver_Mob.findElement(By.xpath("(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1740']")).waitFor(1000);
						if (a2.equals(true)) {
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,"xpath=(//*[@class='UIKBKeyplaneView']/*[@class='UIKBKeyView'])[@x='1740']", 0, 1);
						}*/
					} catch (Exception e1) {

					}
				 }
				}
			}
		}catch(Exception e) {
			logger.info(""+e.getMessage());
		}
		return iReturnValue;
	}
	
	
	public int updatepolicydetails() {
		logger.info("Inside UpdateDBFromApp");
		iReturnValue = 0;
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				logger.info("Object Name=" + oChildObjects[0]);
				GetObj(oChildObjects[0]);
				if (oTestObject == null && arrTestObjects != null) {
					oTestObject = arrTestObjects.get(0);
					arrTestObjects = null;
				}

				String sValue = "";
				if (oTestObject != null || oTestObject1 != null) {
					switch (iObjectSize) {
					case 1:
						logger.info("Inside UpdateDBFromApp - Case 1");
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
						case "HTML.INPUT.BUTTON":
						case "HTML.DIV":
							if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
								String UIName, sTestData;
								if (sUIName.equalsIgnoreCase("Native")) {
									oDriver_Mob.useNativeIdentification();
									UIName = "Native";
								} else {
									oDriver_Mob.useWebIdentification();
									UIName = "WEB";
								}

								boolean b = oDriver_Mob.client.isElementFound(
										UIName, oTestObject1, 0);

								if (b == true) {
									// Thread.sleep(100);
									sValue = oDriver_Mob.client.elementGetText(
											UIName, oTestObject1, 0).trim();
									System.out.println(sValue);
									sValue = sValue.replaceAll("( )+", " ");
									if (oChildObjects[0].contains("o_Product")) {
										sValue = sValue.replace("\n", "-");
									}
									Boolean coloumncheck = oGlobalMap
											.containsKey(oChildObjects[0]
													.toLowerCase());
									if (coloumncheck == true) {
										String sSQLQuery = "update "
												+ sTableName + " set "
												+ oChildObjects[0] + " = '"
												+ sValue + "' where planid = '"
												+ sPlanID
												+ "' and planreleaseid = '"
												+ sReleaseID
												+ "' and plancycleid = '"
												+ sCycleID
												+ "' and test_case = '"
												+ sPlanTestcaseId
												+ "' and test_Case_ser = '"
												+ sRCTestcaseID + "'";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
										logger.info("Data for "
												+ oChildObjects[0]
														.toLowerCase() + " - "
														+ sValue);
										oGlobalMap.put(
												oChildObjects[0].toLowerCase(),
												sValue);
									}
								}
//								if (b == false && oChildObjects[0].contains("Rider_Name_")) {
//
//									break;
//
//								}
								
								String sText="",sProduct="",sPaymentMode="",sFaceAmount="",sPremium="",sMode="";
//								String sText="Dollar Protect Plus Vitality Regular Pay FA:50,000 Premium:187.82 Mode: Monthly";
								sText =sValue;
								
								
								String sFA=sText.split("FA:")[0];
//								System.out.println(sFA.substring(29, 40));
								
								String[] arr = sFA.split("\\s"); 
								int i=arr.length;
								String saText="";
//								System.out.println(i);
								for (int k=i-2;k<i;k++) {
									
									if (!saText.equalsIgnoreCase("")){
										saText =saText + " " + arr[k];
									}else {
										saText= arr[k];
									}
								}
								
								
								sProduct=sFA.split(saText)[0].trim();
								sPaymentMode=saText.trim();
								String sFA1=sText.split("FA:")[1];
								sFaceAmount=sFA1.split("Premium:")[0].trim();
								sPremium=sFA1.split("Premium:")[1].split("Mode:")[0].trim();
								sMode=sFA1.split("Mode:")[1].trim();
								
								System.out.println("Product Name = " +sProduct);
								System.out.println("Payment Mode = " +sPaymentMode);
								System.out.println("Face Ammount = "+sFaceAmount);
								System.out.println("Premium = "+sPremium);
								System.out.println("Mode = "+sMode);
								
								ArrayList<String> list=new ArrayList<String>();
								list.add(sProduct);
								list.add(sPaymentMode);
								list.add(sFaceAmount);
								list.add(sPremium);
								list.add(sMode);
								
								ArrayList<String> list2=new ArrayList<String>();
								list2.add("PolicyInfo_ProductName");
								list2.add("PolicyInfo_PaymentMode");
								list2.add("PolicyInfo_FaceAmount");
								list2.add("PolicyInfo_Premium");
								list2.add("PolicyInfo_Mode");
								
								int j =list.size();
								
								
							logger.info("sValue=" + sValue);
							
				for (int a=0;a<j;a++)	{		
					sValue =list.get(a);
					oChildObjects[0] =list2.get(a);
					logger.info("sValue=" + sValue);
					logger.info("Object Name = " + oChildObjects[0]);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue, device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							} else {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							}	
				}
						}
						}
						}
				}
			}
			}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
		return iReturnValue;
						
	}

	public int updatedbfromapp() {
		logger.info("Inside UpdateDBFromApp");
		iReturnValue = 0;
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				logger.info("Object Name=" + oChildObjects[0]);
				GetObj(oChildObjects[0]);
				if (oTestObject == null && arrTestObjects != null) {
					oTestObject = arrTestObjects.get(0);
					arrTestObjects = null;
				}

				String sValue = "";
				if (oTestObject != null || oTestObject1 != null) {
					switch (iObjectSize) {
					case 1:
						logger.info("Inside UpdateDBFromApp - Case 1");
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
						case "HTML.INPUT.BUTTON":
						case "HTML.DIV":
							if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
								String UIName, sTestData;
								if (sUIName.equalsIgnoreCase("Native")) {
									oDriver_Mob.useNativeIdentification();
									UIName = "Native";
								} else {
									oDriver_Mob.useWebIdentification();
									UIName = "WEB";
								}

								boolean b = oDriver_Mob.client.isElementFound(
										UIName, oTestObject1, 0);

								if (b == true) {
									// Thread.sleep(100);
									sValue = oDriver_Mob.client.elementGetText(
											UIName, oTestObject1, 0).trim();
									System.out.println(sValue);
									sValue = sValue.replaceAll("( )+", " ");
									if (oChildObjects[0].contains("o_Product")) {
										sValue = sValue.replace("\n", "-");
									}
									Boolean coloumncheck = oGlobalMap
											.containsKey(oChildObjects[0]
													.toLowerCase());
									if (coloumncheck == true) {
										String sSQLQuery = "update "
												+ sTableName + " set "
												+ oChildObjects[0] + " = '"
												+ sValue + "' where planid = '"
												+ sPlanID
												+ "' and planreleaseid = '"
												+ sReleaseID
												+ "' and plancycleid = '"
												+ sCycleID
												+ "' and test_case = '"
												+ sPlanTestcaseId
												+ "' and test_Case_ser = '"
												+ sRCTestcaseID + "'";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
										logger.info("Data for "
												+ oChildObjects[0]
														.toLowerCase() + " - "
														+ sValue);
										oGlobalMap.put(
												oChildObjects[0].toLowerCase(),
												sValue);
									}
								}
								if (b == false && oChildObjects[0].contains("Rider_Name_")) {
									break;
								}
							} else {
								sValue = oTestObject.getText().trim();
							}
							if (sValue == null || sValue == "") {
								sValue = oTestObject.getAttribute("value")
										.trim();
								if (sValue.contains("\n")) {
									sValue = sValue.replace("\\n", "");
								}
							} else {
								if (sValue.contains("\n")) {
									sValue = sValue.split("\\n")[1];
								}
							}
							logger.info("sValue=" + sValue);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue, device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ "" //Swapnil - 14 April 19
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							} else {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							}

							break;
						case "HTML.SELECT":
							if (oTestObject.isEnabled()) {
								String sValue1 = ((new Select(oTestObject))
										.getFirstSelectedOption()).getText()
										.trim();
								logger.info("sValue=" + sValue1);
								if (sRCTestcaseID == null
										|| sRCTestcaseID == "") {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ oChildObjects[0]
													+ "','"
													+ sValue1 + "','" + sMobDeviceName
													// + "','"
													// + sFlowCode
													+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								} else {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sRCTestcaseID
											+ "','"
											+ oChildObjects[0]
													+ "','"
													+ sValue1 + "','" + sMobDeviceName
													// + "','"
													// + sRCTCflowid
													+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							}
							break;
						case "HTML.SPAN":
							String sValue2 = oTestObject.getText().trim();
							if (sValue2 == null || sValue2 == "") {
								sValue2 = oTestObject.getAttribute("value")
										.trim();
							} else {
								if (sValue2.contains("\n")) {
									sValue2 = sValue2.split("\\n")[0];
								}
							}

							logger.info("sValue= " + sValue2);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue2
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							} else {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue2
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							}
							break;

						case "HTML.NEWLINE":
							try {
								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {

									String UIName;
									if (sUIName.equalsIgnoreCase("Native")) {
										oDriver_Mob.useNativeIdentification();
										UIName = "Native";
									} else {
										oDriver_Mob.useWebIdentification();
										UIName = "WEB";
									}
									boolean b = oDriver_Mob.client
											.isElementFound(UIName,
													oTestObject1, 0);
									if (b == true) {
										sValue = oDriver_Mob.client
												.elementGetText(UIName,
														oTestObject1, 0).trim();

										sValue = sValue.replaceAll("( )+", " ");
										if (sValue.contains("\n")) {
											sValue = sValue.replace("\n", " -");
										}
									}
								}
							} catch (Exception e) {
								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {

									if (sValue == null || sValue == "") {

									}
								} else {
									sValue = oTestObject.getText().trim();
								}
							}
							logger.info("sValue=" + sValue);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[0]
												.toLowerCase());
								if (coloumncheck == true) {
									// Commented runid for pru
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[0]
													+ " = '" + sValue
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId + "' "; // and
									// flow_code
									// = '"
									// + sFlowCode+ "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);

								}
							}

							else {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[0]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[0]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[0]
													+ " = '" + sValue
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and test_case_ser = '"
													+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);

								}
							}
							break;
						}
						break;
					case 2:
						logger.info("Inside UpdateDBFromApp - Case 2");
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
						case "HTML.INPUT.BUTTON":
						case "HTML.DIV":

							sValue = "";
							try {
								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {

									String UIName;
									if (sUIName.equalsIgnoreCase("Native")) {
										oDriver_Mob.useNativeIdentification();
										UIName = "Native";
									} else {
										oDriver_Mob.useWebIdentification();
										UIName = "WEB";
									}
									boolean b = oDriver_Mob.client
											.isElementFound(UIName,
													oTestObject1, 0);
									if (b == true) {
										sValue = oDriver_Mob.client
												.elementGetText(UIName,
														oTestObject1, 0).trim();

										if (oChildObjects[0]
												.equalsIgnoreCase("o_Product")) {
											sValue = sValue.replace("\n", "-");
										}
										sValue = sValue.replaceAll("( )+", " ");
										sValue = sValue.replaceAll("\n", "");

									}

								} else {
									sValue = oTestObject.getText().trim();
								}
								// sValue =
								// oTestObject.getAttribute("value").trim();

							} catch (Exception e) {

								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {
									/*
									 * sValue=oDriver_Mob.client.elementGetText(
									 * UIName, oTestObject1, 0).trim();
									 * 
									 * if
									 * (sValue.contains("                        "
									 * )) { sValue =
									 * sValue.replace("                        "
									 * ," ");
									 * 
									 * }
									 */
									if (sValue == null || sValue == "") {

									}
								} else {
									sValue = oTestObject.getText().trim();
								}
							}
							if (sValue == null || sValue == "") {
								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {

								} else
									sValue = oTestObject.getText().trim();
							} else {
								if (sValue.contains("\n")) {
									sValue = sValue.split("\\n")[1];
								}
							}
							logger.info("sValue=" + sValue);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ "" // Swapnil P - 14- April-19
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									// Commented runid for pru
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId + "' "; // and
									// flow_code
									// = '"
									// + sFlowCode+ "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);

								}
							}

							else {
								// Commented runid for pru
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // ,RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and test_case_ser = '"
													+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);

								}
							}
							break;
						case "HTML.SELECT":
							if (oTestObject.isEnabled()) {
								String sValue1 = ((new Select(oTestObject))
										.getFirstSelectedOption()).getText()
										.trim();
								logger.info("sValue=" + sValue1);
								if (sRCTestcaseID == null
										|| sRCTestcaseID == "") {
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // ,RunID"
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ oChildObjects[1]
													+ "','"
													+ sValue1 + "','" + sMobDeviceName
													// + "','"
													// + sFlowCode
													+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
									Boolean coloumncheck = oGlobalMap
											.containsKey(oChildObjects[1]
													.toLowerCase());
									if (coloumncheck == true) {
										sSQLQuery = "update " + sTableName
												+ " set " + oChildObjects[1]
														+ " = '" + sValue1
														+ "' where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and test_case = '"
														+ sPlanTestcaseId + "'";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);

									}
								}

								else {
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sRCTestcaseID
											+ "','"
											+ oChildObjects[1]
													+ "','"
													+ sValue1 + "','" + sMobDeviceName
													// + "','"
													// + sRCTCflowid
													+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
									Boolean coloumncheck = oGlobalMap
											.containsKey(oChildObjects[1]
													.toLowerCase());
									if (coloumncheck == true) {

										sSQLQuery = "update " + sTableName
												+ " set " + oChildObjects[1]
														+ " = '" + sValue1
														+ "' where planid = '"
														+ sPlanID
														+ "' and planreleaseid = '"
														+ sReleaseID
														+ "' and plancycleid = '"
														+ sCycleID
														+ "' and test_case = '"
														+ sPlanTestcaseId
														+ "' and test_case_ser = '"
														+ sRCTestcaseID + "'";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
									}
								}
								break;
							}
							break;
						case "HTML.NEWLINE":
							try {
								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {

									String UIName;
									if (sUIName.equalsIgnoreCase("Native")) {
										oDriver_Mob.useNativeIdentification();
										UIName = "Native";
									} else {
										oDriver_Mob.useWebIdentification();
										UIName = "WEB";
									}
									boolean b = oDriver_Mob.client
											.isElementFound(UIName,
													oTestObject1, 0);
									if (b == true) {
										sValue = oDriver_Mob.client
												.elementGetText(UIName,
														oTestObject1, 0).trim();

										sValue = sValue.replaceAll("( )+", " ");
										if (sValue.contains("\n")) {
											sValue = sValue.replace("\n", "-");
										}
									}
								}
							} catch (Exception e) {
								if (!(sMobDeviceName
										.equalsIgnoreCase("desktop"))) {

									if (sValue == null || sValue == "") {

									}
								} else {
									sValue = oTestObject.getText().trim();
								}
							}
							logger.info("sValue=" + sValue);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // ,RunID"
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);

								}
							}

							else {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device" // RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {

									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and test_case_ser = '"
													+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							}
							break;

						case "HTML.SPAN":
							String sValue2 = oTestObject.getText().trim();
							if (sValue2 == null || sValue2 == "") {
								sValue = oTestObject.getAttribute("value")
										.trim();
							}
							logger.info("sValue=" + sValue2);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue2
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue2
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and flow_code = '" + sFlowCode
													+ "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
									// Change
								}
							} else {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device " // RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue2
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {

									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue2
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and test_case_ser = '"
													+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							}
							break;
						case "HTML.A":
							String sValue3 = oTestObject.getText().trim();
							if (sValue3.contains("'")) {
								sValue3 = sValue3.replace("'", "");
							}
							if (sValue3 == null || sValue3 == "") {
								sValue3 = oTestObject.getAttribute("value")
										.trim();
							}
							logger.info("sValue=" + sValue3);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device " // RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue3
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue3
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and flow_code = '" + sFlowCode
													+ "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							} else {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device "// RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue3
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue3
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and test_case_ser = '"
													+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							}
							break;
						}
						break;
					case 3:
						logger.info("Inside UpdateDBFromApp - Case 3");
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
							sValue = oTestObject.getAttribute("value").trim();
							if (sValue == null || sValue == "") {
								sValue = oTestObject.getText().trim();
							}
							logger.info("sValue=" + sValue);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								String sSQLQuery = "update " + oChildObjects[2]
										+ " set " + oChildObjects[1] + " = '"
										+ sValue + "' where planid = '"
										+ sPlanID + "' and planreleaseid = '"
										+ sReleaseID + "' and plancycleid = '"
										+ sCycleID + "' and test_case = '"
										+ sPlanTestcaseId + "'";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							} else {
								String sSQLQuery = "update " + oChildObjects[2]
										+ " set " + oChildObjects[1] + " = '"
										+ sValue + "' where planid = '"
										+ sPlanID + "' and planreleaseid = '"
										+ sReleaseID + "' and plancycleid = '"
										+ sCycleID + "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and test_case_ser = '"
										+ sRCTestcaseID + "'";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
							}
							break;
						case "HTML.SELECT":
							if (oTestObject.isEnabled()) {
								String sValue1 = ((new Select(oTestObject))
										.getFirstSelectedOption()).getText()
										.trim();
								logger.info("sValue=" + sValue1);
								if (sRCTestcaseID == null
										|| sRCTestcaseID == "") {
									String sSQLQuery = "update "
											+ oChildObjects[2] + " set "
											+ oChildObjects[1] + " = '"
											+ sValue1 + "' where planid = '"
											+ sPlanID
											+ "' and planreleaseid = '"
											+ sReleaseID
											+ "' and plancycleid = '"
											+ sCycleID + "' and test_case = '"
											+ sPlanTestcaseId + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								} else {
									String sSQLQuery = "update "
											+ oChildObjects[2] + " set "
											+ oChildObjects[1] + " = '"
											+ sValue1 + "' where planid = '"
											+ sPlanID
											+ "' and planreleaseid = '"
											+ sReleaseID
											+ "' and plancycleid = '"
											+ sCycleID + "' and test_case = '"
											+ sPlanTestcaseId
											+ "' and test_case_ser = '"
											+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							}
							break;
						case "HTML.A":
							String sValue2 = oTestObject.getText().trim();
							if (sValue2 == null || sValue2 == "") {
								sValue = oTestObject.getAttribute("value")
										.trim();
							}
							logger.info("sValue=" + sValue2);
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device " // RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue2
												+ "','" + sMobDeviceName
												// + "','"
												// + sFlowCode
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue2
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							} else {
								String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device " // RunID
										+ ") Values ('"
										+ sPlanID
										+ "','"
										+ sReleaseID
										+ "','"
										+ sCycleID
										+ "','"
										+ sPlanTestcaseId
										+ "','"
										+ sRCTestcaseID
										+ "','"
										+ oChildObjects[1]
												+ "','"
												+ sValue2
												+ "','" + sMobDeviceName
												// + "','"
												// + sRCTCflowid
												+ "')";
								logger.info("sSQLQuery=" + sSQLQuery);
								oStmt.executeUpdate(sSQLQuery);
								Boolean coloumncheck = oGlobalMap
										.containsKey(oChildObjects[1]
												.toLowerCase());
								if (coloumncheck == true) {
									sSQLQuery = "update " + sTableName
											+ " set " + oChildObjects[1]
													+ " = '" + sValue2
													+ "' where planid = '" + sPlanID
													+ "' and planreleaseid = '"
													+ sReleaseID
													+ "' and plancycleid = '"
													+ sCycleID + "' and test_case = '"
													+ sPlanTestcaseId
													+ "' and test_case_ser = '"
													+ sRCTestcaseID + "'";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
							}
							break;
						}
						break;
					}
				}
			}

		} catch (Exception e) {
			logger.info("Inside UpdateDBfromApp exception");
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.info("UpdateDBfromApp exception : " + sOutput);
				logger.error(e.getMessage());
				iReturnValue = 1;
				// iTerminateInd = 1;
				iRCTCTerminateInd = 1;
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int ReadDataFromPDFold1() {
		logger.info("Inside ReadDataFromPDF ");
		iReturnValue = 0;
		try {
			String sFlag = "";
			String[] sITArr;
			String[] sIDataArr;
			String[] sSFKeyArr;
			String sQuery = "", sPDFData = "";
			String[] oObjects = sSFStepKeyword.split(";;");
			String sDestPath = "";
			if (oObjects[0].equals("")) {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
						+ ".pdf";
			} else {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId + "_"
						+ oObjects[0] + ".pdf";
			}
			String PDFPath = sDestPath.replace("/", "\\"); // "C:/QK_LOCAL/QK Team/Seema/Benefit_Illustration_Product_Summary_PRUlady.pdf".replace("/",
			// "\\");
			System.out.println(PDFPath);
			// waiting code for pdf download start
			Thread.sleep(10000);
			File f = new File(PDFPath);
			PdfReader reader = new PdfReader(PDFPath);// D:/rnd/MTU-NBUATSPIS010-TC0121.pdf
			System.out.println("This PDF has " + reader.getNumberOfPages()
					+ " pages.");
			// Split Data and fetch output
			for (int iObjInd = 1; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				sSFKeyArr = oObjects[iObjInd].split("\\~\\~");
				sPDFData = "";
				sFlag = "";
				for (int j = 1; j <= reader.getNumberOfPages(); j++) {
					String page = PdfTextExtractor.getTextFromPage(reader, j);
					System.out.println("Page Content of Page number " + j
							+ ":\n\n" + page + "\n\n");
					if (page.contains(sSFKeyArr[1])) {
						sITArr = page.split("\\n");
						for (int iIData = 0; iIData < sITArr.length; iIData = iIData + 1) {
							if (sITArr[iIData].contains(sSFKeyArr[1])) {
								sIDataArr = sITArr[iIData].split(sSFKeyArr[2]);
								System.out.println(sIDataArr.length);
								System.out.println(" reuqired data is : "
										+ sIDataArr[Integer
										            .parseInt(sSFKeyArr[3])]);
								sPDFData = sIDataArr[Integer
								                     .parseInt(sSFKeyArr[3])];
								if (sSFKeyArr.length == 5) {
									int iULen = Integer.parseInt((sSFKeyArr[4])
											.split("-")[1]);
									// Considering it as length -1 for now
									for (int iLoopCnt = (Integer
											.parseInt(sSFKeyArr[3]) + 1); iLoopCnt < ((sIDataArr.length) - iULen); iLoopCnt++) {
										sPDFData = sPDFData + " "
												+ sIDataArr[iLoopCnt];
									}
								}
								System.out.println("final data is : "
										+ sPDFData);
								sFlag = "Found";

								if (sRCTestcaseID == null
										|| sRCTestcaseID == "") {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sSFKeyArr[0] + "','" + sPDFData
											// + "','"
											// + sFlowCode
											+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								} else {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sRCTestcaseID
											+ "','"
											+ sSFKeyArr[0] + "','" + sPDFData
											// + "','"
											// + sRCTCflowid
											+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
								break;
							}
						}
						if (sFlag.equalsIgnoreCase("found")) {
							break;
						}
					}
				}
			}
			reader.close(); // finally, close the file.
		} catch (Exception e) {
			logger.info("Inside UpdateDBfromApp exception");
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
			}
			logger.info("UpdateDBfromApp exception : " + sOutput);
			logger.error(e.getMessage());
			iReturnValue = 1;
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
		}
		return iReturnValue;
	}

	public int ReadDataFromPDFBI1() {
		logger.info("Inside ReadDataFromPDF ");
		iReturnValue = 0;
		try {
			String[] sITArr;
			String[] sIDataArr;
			String[] sSFKeyArr;
			String sQuery = "", sPDFData = "";
			String[] oObjects = sSFStepKeyword.split(";;");
			String sDestPath = "";
			if (oObjects[0].equals("")) {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
						+ ".pdf";
			} else {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId + "_"
						+ oObjects[0] + ".pdf";
			}
			String PDFPath = sDestPath.replace("/", "\\"); // "C:/QK_LOCAL/QK Team/Seema/Benefit_Illustration_Product_Summary_PRUlady.pdf".replace("/",
			// "\\");
			System.out.println(PDFPath);
			// waiting code for pdf download start
			Thread.sleep(10000);
			File f = new File(PDFPath);
			PdfReader reader = new PdfReader(PDFPath);// D:/rnd/MTU-NBUATSPIS010-TC0121.pdf
			System.out.println("This PDF has " + reader.getNumberOfPages()
					+ " pages.");
			// Split Data and fetch output
			for (int iObjInd = 1; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				sSFKeyArr = oObjects[iObjInd].split("\\~\\~");
				sPDFData = "";
				for (int j = 1; j <= reader.getNumberOfPages(); j++) {
					String page = PdfTextExtractor.getTextFromPage(reader, j);
					System.out.println("Page Content of Page number " + j
							+ ":\n\n" + page + "\n\n");
					if (page.contains(sSFKeyArr[1])) {
						sITArr = page.split("\\n");
						for (int iIData = 0; iIData < sITArr.length; iIData = iIData + 1) {
							if (sITArr[iIData].contains(sSFKeyArr[1])) {
								sIDataArr = sITArr[iIData].split(sSFKeyArr[2]);
								System.out.println(sIDataArr.length);
								System.out.println(" reuqired data is : "
										+ sIDataArr[Integer
										            .parseInt(sSFKeyArr[3])]);
								sPDFData = sIDataArr[Integer
								                     .parseInt(sSFKeyArr[3])];
								if (sSFKeyArr.length == 5) {
									// Considering it as length -1 for now
									for (int iLoopCnt = (Integer
											.parseInt(sSFKeyArr[3]) + 1); iLoopCnt < ((sIDataArr.length) - 1); iLoopCnt++) {
										sPDFData = sPDFData + " "
												+ sIDataArr[iLoopCnt];
									}
								}
								if (sRCTestcaseID == null
										|| sRCTestcaseID == "") {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sSFKeyArr[0] + "','" + sPDFData
											// + "','"
											// + sFlowCode
											+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								} else {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sRCTestcaseID
											+ "','"
											+ sSFKeyArr[0] + "','" + sPDFData
											// + "','"
											// + sRCTCflowid
											+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
								break;
							}
						}
					}
				}
			}
			reader.close(); // finally, close the file.
		} catch (Exception e) {
			logger.info("Inside UpdateDBfromApp exception");
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
			}
			logger.info("UpdateDBfromApp exception : " + sOutput);
			logger.error(e.getMessage());
			iReturnValue = 1;
			iTerminateInd = 1;
			iRCTCTerminateInd = 1;
		}
		return iReturnValue;
	}

	/*
	 * public int readcontentfrompdf() {
	 * logger.info("Inside  ReadContentFromPDF "); iReturnValue = 0; String
	 * sProductCode = "", file1 = "", file2 = "", sCompTable =
	 * "policy_document_pdf", sPDFName = "policy_document", file1_Name = "",
	 * sexclude_pages = ""; PDFUtil pdfUtil = new PDFUtil(); try { // String[]
	 * oObjects = sSFStepKeyword.split(","); // file1 = oObjects[2]; // file2 =
	 * oObjects[3]; // sCompTable = oObjects[0]; // sPDFName = oObjects[1];
	 * sCompTable = "policy_document_pdf"; sPDFName = "policy_document";
	 * sProductCode = "SL2"; sFullScreenShotPath =
	 * "D:\\Prudential\\PDFCompare\\Files"; ResultSet oRSQueryPS;
	 * logger.info("sQuery=" +
	 * "select excel_file from pdf_master where file_type = '" + sPDFName +
	 * "' and product_code = '" + sProductCode + "'"); oStmt =
	 * oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); oRSQueryPS = oStmt .executeQuery(
	 * "select excel_file,exclude_pages from pdf_master where file_type = '" +
	 * sPDFName + "' and product_code = '" + sProductCode + "'"); if
	 * (oRSQueryPS.next()) { file1 = oRSQueryPS.getString("excel_file");
	 * sexclude_pages = oRSQueryPS.getString("exclude_pages"); }
	 * oRSQueryPS.close(); oExcludePgMap.clear(); if
	 * (!(sexclude_pages.equals(""))) { String[] sExPg =
	 * sexclude_pages.split(","); for (int iExPgCnt = 0; iExPgCnt <
	 * sExPg.length;) oExcludePgMap.put(sExPg[iExPgCnt], sExPg[iExPgCnt]); } if
	 * (file1.contains("/")) { String[] as = file1.split("/"); file1_Name =
	 * as[as.length - 1]; } else if (file1.contains("\\")) { String separator =
	 * "\\"; String[] as = file1.split(Pattern.quote(separator)); file1_Name =
	 * as[as.length - 1]; } //
	 * file1="D:\\Prudential\\PDFCompare\\Files\\Correct one.pdf"; // //Faulty
	 * //
	 * one.pdf";//args[0].split("`")[0]; 	//"D:/Prudential/15oct17/SL2-DP080-TC001
	 * /SL2-DP080-TC001_benefit_illustration_pdf.pdf"; file2 =
	 * "D:\\Prudential\\PDFCompare\\Files\\PRUlady_Iteration 1.pdf";// Faulty //
	 * one.pdf"; //Correct one.pdf";//args[0].split("`")[1]; // //
	 * "D:/Prudential/15oct17/SL2-DP080-TC001/SL2-DP080-TC001_benefit_illustration_pdf.pdf"
	 * ; // System.out.println(pdfUtil.getText(file1,2)); //
	 * System.out.println(pdfUtil.getText(file2,2)); //
	 * System.out.println(pdfUtil.compare(file1, file2, 2, 2)); // String //
	 * file2=
	 * "D:/Prudential/15oct17/SL2-DP080-TC001/SL2-DP080-TC001_policy_document_pdf.pdf"
	 * ; // compares the pdf documents and returns a boolean // true if both
	 * files have same content. false otherwise. int pgCnt1 =
	 * pdfUtil.getPageCount(file1); int pgCnt2 = pdfUtil.getPageCount(file2);
	 * int iPgCompareCnt = 1; String spageflag = ""; if (!(pgCnt1 == pgCnt2)) {
	 * sOutputpdf = "Page count does not match."; if (pgCnt1 < pgCnt2) {
	 * iPgCompareCnt = pgCnt1; spageflag = "less"; } else { iPgCompareCnt =
	 * pgCnt2; spageflag = "more"; } } else { iPgCompareCnt = pgCnt1; } String
	 * sImagePath = sFullScreenShotPath + "/Images"; if (new
	 * File(sImagePath).exists()) { for (File file : new
	 * File(sImagePath).listFiles()) file.delete(); } new
	 * File(sImagePath).mkdirs(); for (int iPgLoop = 1; iPgLoop <=
	 * iPgCompareCnt; iPgLoop++) { String sPgNo = String.valueOf(iPgLoop);
	 * Boolean coloumncheck = oExcludePgMap.containsKey(sPgNo); if
	 * (coloumncheck) { } else { readpdfline(file1, file2, iPgLoop, sCompTable,
	 * sPDFName); pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
	 * pdfUtil.highlightPdfDifference(true);
	 * pdfUtil.setImageDestinationPath(sImagePath); //
	 * pdfUtil.excludeText("[dynamic]","dynamic","[Prospect]");
	 * pdfUtil.compare(file1, file2, iPgLoop, iPgLoop); Thread.sleep(5000); File
	 * file = new File(sImagePath + "/" + file1_Name.replace(".pdf", "") + "_" +
	 * String.valueOf(iPgLoop) + "_diff.png"); if ((file.exists())) { if
	 * (sRCTestcaseID == null || sRCTestcaseID == "") { oStmt =
	 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" + "insert into " +
	 * sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sPlanTestcaseId + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" +
	 * "Requirements should match" + "','" + "Requirements does not match" +
	 * "','" + "Fail" + "','" + sMobDeviceName + "')"); // sFlowCode // + //
	 * "')"); oStmt.executeUpdate("insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sPlanTestcaseId + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" +
	 * "Requirements should match" + "','" + "Requirements does not match" +
	 * "','" + "Fail" + "','" + sMobDeviceName + "')"); // sFlowCode // + //
	 * "')"); } else { oStmt = oConn.createStatement(
	 * ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 * logger.info("sQuery=" + "insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" +
	 * "Requirements should match" + "','" + "Requirements does not match" +
	 * "','" + "Fail" + "','" + sMobDeviceName + "')"); // sFlowCode // + //
	 * "')"); oStmt.executeUpdate("insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" +
	 * "Requirements should match" + "','" + "Requirements does not match" +
	 * "','" + "Fail" + "','" + sMobDeviceName + "')"); // sFlowCode // + //
	 * "')"); } } } } if (!(spageflag.equals(""))) { // expected is less than
	 * actual if (spageflag.equalsIgnoreCase("less")) { for (int iPgLoop =
	 * pgCnt1 + 1; iPgLoop <= pgCnt2; iPgLoop++) { if (sRCTestcaseID == null ||
	 * sRCTestcaseID == "") { oStmt = oConn.createStatement(
	 * ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	 * logger.info("sQuery=" + "insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sPlanTestcaseId + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode + // "')");
	 * oStmt.executeUpdate("insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sPlanTestcaseId + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode + // "')"); } else { oStmt =
	 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" + "insert into " +
	 * sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode + // "')");
	 * oStmt.executeUpdate("insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode + // "')"); } } }// expected is more
	 * than actual else { for (int iPgLoop = pgCnt2 + 1; iPgLoop <= pgCnt1;
	 * iPgLoop++) { if (sRCTestcaseID == null || sRCTestcaseID == "") { oStmt =
	 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" + "insert into " +
	 * sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sPlanTestcaseId + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode // + // "')");
	 * oStmt.executeUpdate("insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sPlanTestcaseId + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode // + // "')"); } else { oStmt =
	 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" + "insert into " +
	 * sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode // + // "')");
	 * oStmt.executeUpdate("insert into " + sCompTable +
	 * " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device"
	 * // RunID + ") Values" + "('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sModule + "','" + sSubModule + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "','" + sScenarioId + "','" + sTCID + "','" +
	 * sPDFName + "_Page" + String.valueOf(iPgLoop) + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is available" + "','" + "Page number " +
	 * String.valueOf(iPgLoop) + " is not available" + "','" + "Fail" + "','" +
	 * sMobDeviceName + "')"); // sFlowCode // + // "')"); } } } }
	 * System.out.println("final sOutputpdf : " + sOutputpdf); } catch
	 * (Exception e) { logger.info("Inside ReadContentFromPDF exception"); if
	 * (sOutput.equals("")) { sOutput = e.getMessage().split("\\n")[0]; } else {
	 * sOutput = sOutput + " | " + e.getMessage().split("\\n")[0]; }
	 * logger.info("UpdateDBfromApp exception : " + sOutput);
	 * logger.error(e.getMessage()); iReturnValue = 1; iTerminateInd = 1;
	 * iRCTCTerminateInd = 1; } return iReturnValue; }
	 */

	public String readpdfline(String sPDF1, String sPDF2, int sPgCnt,
			String sCompTable, String sPDFName) {
		String[] sITArr1;
		String[] sITArr2;
		int iMaxCnt = 1;
		String sLineFlag = "";
		String sField = "", sExpected = "", sActual = "", sCompareResult = "";
		try {
			PdfReader reader1 = new PdfReader(sPDF1);
			PdfReader reader2 = new PdfReader(sPDF2);
			String page1 = PdfTextExtractor.getTextFromPage(reader1, sPgCnt);
			System.out.println("Page Content of Page number " + sPgCnt
					+ ":\n\n" + page1 + "\n\n");
			sITArr1 = page1.split("\\n");
			String page2 = PdfTextExtractor.getTextFromPage(reader2, sPgCnt);
			System.out.println("Page Content of Page number " + sPgCnt
					+ ":\n\n" + page2 + "\n\n");
			sITArr2 = page2.split("\\n");
			if (sITArr1.length == sITArr2.length) {
				iMaxCnt = sITArr1.length;
			} else if (sITArr1.length < sITArr2.length) {
				iMaxCnt = sITArr1.length;
				sLineFlag = "less";
				sOutputpdf = sOutputpdf
						+ ". Mismatch found in total number of lines in page number "
						+ String.valueOf(sPgCnt) + ".";
			} else {
				iMaxCnt = sITArr2.length;
				sLineFlag = "more";
				sOutputpdf = sOutputpdf
						+ ". Mismatch found in total number of lines in page number "
						+ String.valueOf(sPgCnt) + ".";
			}
			String sOutputpdf1 = " Data mismatch found in page numbers : "
					+ String.valueOf(sPgCnt) + " and line numbers : ";
			String sLineNumbers = "";
			for (int iIData = 0; iIData < iMaxCnt; iIData = iIData + 1) {
				if ((sITArr1[iIData]).equals(sITArr2[iIData])) {

				} else {
					if (sLineNumbers.equals("")) {
						sOutputpdf = sOutputpdf + sOutputpdf1
								+ String.valueOf(iIData);
					} else {
						sOutputpdf = sOutputpdf + ", " + String.valueOf(iIData);
					}
					sLineNumbers = String.valueOf(iIData);
					sCompareResult = "Fail";
					sExpected = sITArr1[iIData];
					sActual = sITArr2[iIData];
					sField = sPDFName + "_Page" + String.valueOf(sPgCnt)
							+ "_Line" + String.valueOf(iIData);
					// Insert in table failure
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery=" + "insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sPlanTestcaseId
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
						oStmt.executeUpdate("insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sPlanTestcaseId
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
					} else {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery=" + "insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sRCTestcaseID
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
						oStmt.executeUpdate("insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sRCTestcaseID
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
					}
				}
			}
			// Extra lines handler
			if (!(sLineFlag.equals(""))) {
				// expected is less than actual
				if (sLineFlag.equalsIgnoreCase("less")) {
					for (int iIData = sITArr1.length + 1; iIData < sITArr2.length; iIData = iIData + 1) {
						sActual = sITArr2[iIData];
						sField = sPDFName + "_Page" + String.valueOf(sPgCnt)
								+ "_Line" + String.valueOf(iIData);
						// for (int iPgLoop = pgCnt1 + 1; iPgLoop <= pgCnt2;
						// iPgLoop ++){
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery=" + "insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sPlanTestcaseId
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + "" + "','"
									+ sActual + " is available" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");
							oStmt.executeUpdate("insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sPlanTestcaseId
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + "" + "','"
									+ sActual + " is available" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");
						} else {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery=" + "insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sRCTestcaseID
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + "" + "','"
									+ sActual + " is available" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");
							oStmt.executeUpdate("insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sRCTestcaseID
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + "" + "','"
									+ sActual + " is available" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");
						}
					}
				}// expected is more than actual
				else {
					for (int iIData = sITArr2.length + 1; iIData < sITArr1.length; iIData = iIData + 1) {
						sExpected = sITArr1[iIData];
						sField = sPDFName + "_Page" + String.valueOf(sPgCnt)
								+ "_Line" + String.valueOf(iIData);
						// for (int iPgLoop = pgCnt1 + 1; iPgLoop <= pgCnt2;
						// iPgLoop ++){
						// for (int iPgLoop = pgCnt2 + 1; iPgLoop <= pgCnt1;
						// iPgLoop ++){
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery=" + "insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sPlanTestcaseId
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ " is available" + "','" + "" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");

							oStmt.executeUpdate("insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sPlanTestcaseId
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ " is available" + "','" + "" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");
						} else {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery=" + "insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sRCTestcaseID
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ " is available" + "','" + "" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");

							oStmt.executeUpdate("insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sRCTestcaseID
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ " is available" + "','" + "" + "','"
									+ "Fail" + "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode + "')");
						}
					}
				}
			}
		} catch (Exception e) {

		}
		return "";
	}

	/*
	 * public int ReadContentFromPDF_9nov() {
	 * logger.info("Inside  ReadContentFromPDF "); iReturnValue = 0; String
	 * file1 = "", file2 = "", sCompTable = "policy_document_pdf", sPDFName =
	 * "policy_document"; PDFUtil pdfUtil = new PDFUtil(); try { String[]
	 * oObjects = sSFStepKeyword.split(","); file1 = oObjects[2]; file2 =
	 * oObjects[3]; sCompTable = oObjects[0]; sPDFName = oObjects[1]; sCompTable
	 * = "policy_document_pdf"; sPDFName = "policy_document"; file1 =
	 * "D:\\Prudential\\PDFCompare\\Faulty one.pdf";// args[0].split("`")[0]; //
	 * //
	 * "D:/Prudential/15oct17/SL2-DP080-TC001/SL2-DP080-TC001_benefit_illustration_pdf.pdf"
	 * ; file2 = "D:\\Prudential\\PDFCompare\\Correct one.pdf";//
	 * args[0].split("`")[1]; // //
	 * "D:/Prudential/15oct17/SL2-DP080-TC001/SL2-DP080-TC001_benefit_illustration_pdf.pdf"
	 * ; // System.out.println(pdfUtil.getText(file1,2)); //
	 * System.out.println(pdfUtil.getText(file2,2)); //
	 * System.out.println(pdfUtil.compare(file1, file2, 2, 2)); // String //
	 * file2=
	 * "D:/Prudential/15oct17/SL2-DP080-TC001/SL2-DP080-TC001_policy_document_pdf.pdf"
	 * ; // compares the pdf documents and returns a boolean // true if both
	 * files have same content. false otherwise. int pgCnt1 =
	 * pdfUtil.getPageCount(file1); int pgCnt2 = pdfUtil.getPageCount(file2);
	 * int iPgCompareCnt = 1;
	 * 
	 * System.out.println(); if (!(pgCnt1 == pgCnt2)) { sOutputpdf =
	 * "Page count does not match."; if (pgCnt1 < pgCnt2) { iPgCompareCnt =
	 * pgCnt1; } else { iPgCompareCnt = pgCnt2; } } else { iPgCompareCnt =
	 * pgCnt1; if (pdfUtil.compare(file1, file2)) {
	 * 
	 * } else { sOutputpdf = "Page count matches but data mismatch found. "; } }
	 * String sOutputpdf1 = "Data mismatch found in page numbers : "; String
	 * sPgNumbers = ""; for (int iPgLoop = 1; iPgLoop <= iPgCompareCnt;
	 * iPgLoop++) { if (pdfUtil.compare(file1, file2, iPgLoop, iPgLoop)) {
	 * 
	 * } else { if (sPgNumbers.equals("")) { sOutputpdf = sOutputpdf +
	 * sOutputpdf1 + String.valueOf(iPgLoop); } else { sOutputpdf = sOutputpdf +
	 * ", " + String.valueOf(iPgLoop); } sPgNumbers = String.valueOf(iPgLoop); }
	 * } for (int iPgLoop = 1; iPgLoop <= iPgCompareCnt; iPgLoop++) { if
	 * (pdfUtil.compare(file1, file2, iPgLoop, iPgLoop)) {
	 * 
	 * } else { readpdfline(file1, file2, iPgLoop, sCompTable, sPDFName); } }
	 * System.out.println("final sOutputpdf : " + sOutputpdf); } catch
	 * (Exception e) { logger.info("Inside UpdateDBfromApp exception"); if
	 * (sOutput.equals("")) { sOutput = e.getMessage().split("\\n")[0]; } else {
	 * sOutput = sOutput + " | " + e.getMessage().split("\\n")[0]; }
	 * logger.info("UpdateDBfromApp exception : " + sOutput);
	 * logger.error(e.getMessage()); iReturnValue = 1; iTerminateInd = 1;
	 * iRCTCTerminateInd = 1; } return iReturnValue; }
	 */

	public String readpdfline_9nov(String sPDF1, String sPDF2, int sPgCnt,
			String sCompTable, String sPDFName) {
		String[] sITArr1;
		String[] sITArr2;
		int iMaxCnt = 1;
		String sField = "", sExpected = "", sActual = "", sCompareResult = "";
		try {
			PdfReader reader1 = new PdfReader(sPDF1);
			PdfReader reader2 = new PdfReader(sPDF2);
			String page1 = PdfTextExtractor.getTextFromPage(reader1, sPgCnt);
			System.out.println("Page Content of Page number " + sPgCnt
					+ ":\n\n" + page1 + "\n\n");
			sITArr1 = page1.split("\\n");
			String page2 = PdfTextExtractor.getTextFromPage(reader2, sPgCnt);
			System.out.println("Page Content of Page number " + sPgCnt
					+ ":\n\n" + page2 + "\n\n");
			sITArr2 = page2.split("\\n");
			if (sITArr1.length == sITArr2.length) {
				iMaxCnt = sITArr1.length;
			} else if (sITArr1.length < sITArr2.length) {
				iMaxCnt = sITArr1.length;
				sOutputpdf = sOutputpdf
						+ ". Mismatch found in total number of lines in page number "
						+ String.valueOf(sPgCnt) + ".";
			} else {
				iMaxCnt = sITArr2.length;
				sOutputpdf = sOutputpdf
						+ ". Mismatch found in total number of lines in page number "
						+ String.valueOf(sPgCnt) + ".";
			}
			String sOutputpdf1 = " Data mismatch found in page numbers : "
					+ String.valueOf(sPgCnt) + " and line numbers : ";
			String sLineNumbers = "";
			for (int iIData = 0; iIData < iMaxCnt; iIData = iIData + 1) {
				if ((sITArr1[iIData]).equals(sITArr2[iIData])) {

				} else {
					if (sLineNumbers.equals("")) {
						sOutputpdf = sOutputpdf + sOutputpdf1
								+ String.valueOf(iIData);
					} else {
						sOutputpdf = sOutputpdf + ", " + String.valueOf(iIData);
					}
					sLineNumbers = String.valueOf(iIData);
					sCompareResult = "Fail";
					sExpected = sITArr1[iIData];
					sActual = sITArr2[iIData];
					sField = sPDFName + "_Page" + String.valueOf(sPgCnt)
							+ "_Line" + String.valueOf(iIData);
					// Insert in table failure
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery=" + "insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sPlanTestcaseId
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')");// sFlowCode
						// +
						// "')");

						oStmt.executeUpdate("insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sPlanTestcaseId
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
					} else {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery=" + "insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sRCTestcaseID
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
						oStmt.executeUpdate("insert into "
								+ sCompTable
								+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
								+ ") Values" + "('" + sPlanID + "','"
								+ sReleaseID + "','" + sCycleID + "','"
								+ sModule + "','" + sSubModule + "','"
								+ sPlanTestcaseId + "','" + sRCTestcaseID
								+ "','" + sScenarioId + "','" + sTCID + "','"
								+ sField + "','" + sExpected + "','" + sActual
								+ "','" + sCompareResult + "','"
								+ sMobDeviceName + "','" + sTestType + "')"); // sFlowCode
						// +
						// "')");
					}
				}
			}
		} catch (Exception e) {

		}
		return "";
	}

	public int readdatafrompdf() {
		logger.info("Inside ReadDataFromPDF ");
		iReturnValue = 0;
		try {
			// sSFStepKeyword =
			// "proposal_details_pdf;;Proposal_details_Name~~Policy Description + 1~~ ~~0;;BI_Illustration_Plan_Type~~Policy Description + 1~~ ~~2;;BI_Illustration_Policy_Term~~Policy Description + 1~~ ~~3~~length-1;;BI_Illustration_Yearly_Premium~~Policy Description + 1~~ ~~6";
			// sMobDeviceName = "desktop";
			if (sMobDeviceName.equalsIgnoreCase("desktop")) {
				String sFlag = "";
				String[] sITArr;
				String[] sIDataArr;
				String[] sSFKeyArr;
				String sQuery = "", sPDFData = "";
				String[] oObjects = sSFStepKeyword.split(";;");
				String sDestPath = "";
				if (oObjects[0].equals("")) {
					sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
							+ ".pdf";
				} else {
					sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
							+ "_" + oObjects[0] + ".pdf";
				}
				// sDestPath =
				// "D:\\Prudential\\15oct17\\SL2-DP080-TC001\\SL2-DP080-TC001_Proposal_Details_pdf.pdf";
				String PDFPath = sDestPath.replace("/", "\\"); // "C:/QK_LOCAL/QK Team/Seema/Benefit_Illustration_Product_Summary_PRUlady.pdf".replace("/",
				// "\\");
				System.out.println(PDFPath);
				// waiting code for pdf download start
				Thread.sleep(10000);
				File f = new File(PDFPath);
				PdfReader reader = new PdfReader(PDFPath);// D:/rnd/MTU-NBUATSPIS010-TC0121.pdf
				System.out.println("This PDF has " + reader.getNumberOfPages()
						+ " pages.");
				// Split Data and fetch output
				for (int iObjInd = 1; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
					logger.info("Object Name=" + oObjects[iObjInd]);
					sSFKeyArr = oObjects[iObjInd].split("\\~\\~");
					String sSearchString = sSFKeyArr[1];
					int iSearchPg = 0;
					if (sSFKeyArr[1].contains("+")) {
						System.out.println(sSFKeyArr[1].split("\\+").length);
						sSearchString = sSFKeyArr[1].split("\\+")[0];
						if (sSFKeyArr[1].split("\\+").length == 2) {
							iSearchPg = Integer.parseInt((sSFKeyArr[1]
									.split("\\+")[1]).trim());
						}
					}
					sPDFData = "";
					sFlag = "";
					for (int j = 1; j <= reader.getNumberOfPages(); j++) {
						String page = PdfTextExtractor.getTextFromPage(reader,
								j);
						System.out.println("Page Content of Page number " + j
								+ ":\n\n" + page + "\n\n");
						if (page.contains(sSearchString)) {
							sITArr = page.split("\\n");
							for (int iIData = 0; iIData < sITArr.length; iIData = iIData + 1) {
								if (sITArr[iIData].contains(sSearchString)) {
									// sIDataArr = sITArr[iIData +
									// iSearchPg].split(sSFKeyArr[2]);
									sIDataArr = sITArr[iIData + iSearchPg]
											.split("\\" + sSFKeyArr[2]);
									System.out.println(sIDataArr.length);
									System.out.println(" reuqired data is : "
											+ sIDataArr[Integer
											            .parseInt(sSFKeyArr[3])]);
									sPDFData = sIDataArr[Integer
									                     .parseInt(sSFKeyArr[3])];
									if (sSFKeyArr.length == 5) {
										int iULen = Integer
												.parseInt((sSFKeyArr[4])
														.split("-")[1]);
										// Considering it as length -1 for now
										for (int iLoopCnt = (Integer
												.parseInt(sSFKeyArr[3]) + 1); iLoopCnt < ((sIDataArr.length) - iULen); iLoopCnt++) {
											sPDFData = sPDFData + " "
													+ sIDataArr[iLoopCnt];
										}
									}
									System.out.println("final data is : "
											+ sPDFData);
									sFlag = "Found";
									if (sRCTestcaseID == null
											|| sRCTestcaseID == "") {
										// Commented runid for pru
										String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
												+ ") Values ('"
												+ sPlanID
												+ "','"
												+ sReleaseID
												+ "','"
												+ sCycleID
												+ "','"
												+ sPlanTestcaseId
												+ "','"
												+ sPlanTestcaseId
												+ "','"
												+ sSFKeyArr[0]
														+ "','"
														+ sPDFData
														+ "','"
														+ sMobDeviceName
														// + "','"
														// + sFlowCode
														+ "')";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
									} else {
										// Commented runid for pru
										String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
												+ ") Values ('"
												+ sPlanID
												+ "','"
												+ sReleaseID
												+ "','"
												+ sCycleID
												+ "','"
												+ sPlanTestcaseId
												+ "','"
												+ sRCTestcaseID
												+ "','"
												+ sSFKeyArr[0]
														+ "','"
														+ sPDFData
														+ "','"
														+ sMobDeviceName
														// + "','"
														// + sRCTCflowid
														+ "')";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
									}
									break;
								}
							}
							if (sFlag.equalsIgnoreCase("found")) {
								break;
							}
						}
					}
				}
				reader.close(); // finally, close the file.
			}
		} catch (Exception e) {
			logger.info("Inside Readdatafrompdf exception");
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
			}
			logger.info("Readdatafrompdf exception : " + sOutput);
			logger.error(e.getMessage());
			iReturnValue = 1;
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
		}
		return iReturnValue;
	}

	public int ReadDataFromPDF16oct() {
		logger.info("Inside ReadDataFromPDF ");
		iReturnValue = 0;
		try {
			if (sMobDeviceName.equalsIgnoreCase("desktop")) {
				String sFlag = "";
				String[] sITArr;
				String[] sIDataArr;
				String[] sSFKeyArr;
				String sQuery = "", sPDFData = "";
				String[] oObjects = sSFStepKeyword.split(";;");
				String sDestPath = "";
				if (oObjects[0].equals("")) {
					sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
							+ ".pdf";
				} else {
					sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
							+ "_" + oObjects[0] + ".pdf";
				}
				String PDFPath = sDestPath.replace("/", "\\"); // "C:/QK_LOCAL/QK Team/Seema/Benefit_Illustration_Product_Summary_PRUlady.pdf".replace("/",
				// "\\");
				System.out.println(PDFPath);
				// waiting code for pdf download start
				Thread.sleep(10000);
				File f = new File(PDFPath);
				PdfReader reader = new PdfReader(PDFPath);// D:/rnd/MTU-NBUATSPIS010-TC0121.pdf
				System.out.println("This PDF has " + reader.getNumberOfPages()
						+ " pages.");
				// Split Data and fetch output
				for (int iObjInd = 1; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
					logger.info("Object Name=" + oObjects[iObjInd]);
					sSFKeyArr = oObjects[iObjInd].split("\\~\\~");
					sPDFData = "";
					sFlag = "";
					for (int j = 1; j <= reader.getNumberOfPages(); j++) {
						String page = PdfTextExtractor.getTextFromPage(reader,
								j);
						System.out.println("Page Content of Page number " + j
								+ ":\n\n" + page + "\n\n");
						if (page.contains(sSFKeyArr[1])) {
							sITArr = page.split("\\n");
							for (int iIData = 0; iIData < sITArr.length; iIData = iIData + 1) {
								if (sITArr[iIData].contains(sSFKeyArr[1])) {
									sIDataArr = sITArr[iIData]
											.split(sSFKeyArr[2]);
									System.out.println(sIDataArr.length);
									System.out.println(" reuqired data is : "
											+ sIDataArr[Integer
											            .parseInt(sSFKeyArr[3])]);
									sPDFData = sIDataArr[Integer
									                     .parseInt(sSFKeyArr[3])];
									if (sSFKeyArr.length == 5) {
										int iULen = Integer
												.parseInt((sSFKeyArr[4])
														.split("-")[1]);
										// Considering it as length -1 for now
										for (int iLoopCnt = (Integer
												.parseInt(sSFKeyArr[3]) + 1); iLoopCnt < ((sIDataArr.length) - iULen); iLoopCnt++) {
											sPDFData = sPDFData + " "
													+ sIDataArr[iLoopCnt];
										}
									}
									System.out.println("final data is : "
											+ sPDFData);
									sFlag = "Found";
									if (sRCTestcaseID == null
											|| sRCTestcaseID == "") {
										// Commented runid for pru
										String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
												+ ") Values ('"
												+ sPlanID
												+ "','"
												+ sReleaseID
												+ "','"
												+ sCycleID
												+ "','"
												+ sPlanTestcaseId
												+ "','"
												+ sPlanTestcaseId
												+ "','"
												+ sSFKeyArr[0]
														+ "','"
														+ sPDFData
														+ "','"
														+ sMobDeviceName
														// + "','"
														// + sFlowCode
														+ "')";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
									} else {
										// Commented runid for pru
										String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
												+ ") Values ('"
												+ sPlanID
												+ "','"
												+ sReleaseID
												+ "','"
												+ sCycleID
												+ "','"
												+ sPlanTestcaseId
												+ "','"
												+ sRCTestcaseID
												+ "','"
												+ sSFKeyArr[0]
														+ "','"
														+ sPDFData
														+ "','"
														+ sMobDeviceName
														// + "','"
														// + sRCTCflowid
														+ "')";
										logger.info("sSQLQuery=" + sSQLQuery);
										oStmt.executeUpdate(sSQLQuery);
									}
									break;
								}
							}
							if (sFlag.equalsIgnoreCase("found")) {
								break;
							}
						}
					}
				}
				reader.close(); // finally, close the file.
			}
		} catch (Exception e) {
			logger.info("Inside UpdateDBfromApp exception");
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
			}
			logger.info("UpdateDBfromApp exception : " + sOutput);
			logger.error(e.getMessage());
			iReturnValue = 1;
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
		}
		return iReturnValue;
	}

	public int ReadDataFromPDFold() {
		logger.info("Inside ReadDataFromPDF ");
		iReturnValue = 0;
		try {
			String[] sITArr;
			String[] sIDataArr;
			String[] sSFKeyArr;
			String sQuery = "", sPDFData = "";
			String[] oObjects = sSFStepKeyword.split(";;");
			String sDestPath = "";
			if (oObjects[0].equals("")) {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
						+ ".pdf";
			} else {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId + "_"
						+ oObjects[0] + ".pdf";
			}
			String PDFPath = sDestPath.replace("/", "\\"); // "C:/QK_LOCAL/QK Team/Seema/Benefit_Illustration_Product_Summary_PRUlady.pdf".replace("/",
			// "\\");
			System.out.println(PDFPath);
			// waiting code for pdf download start
			Thread.sleep(10000);
			File f = new File(PDFPath);
			PdfReader reader = new PdfReader(PDFPath);// D:/rnd/MTU-NBUATSPIS010-TC0121.pdf
			System.out.println("This PDF has " + reader.getNumberOfPages()
					+ " pages.");
			// Split Data and fetch output
			for (int iObjInd = 1; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				sSFKeyArr = oObjects[iObjInd].split("\\~\\~");
				sPDFData = "";
				for (int j = 1; j <= reader.getNumberOfPages(); j++) {
					String page = PdfTextExtractor.getTextFromPage(reader, j);
					System.out.println("Page Content of Page number " + j
							+ ":\n\n" + page + "\n\n");
					if (page.contains(sSFKeyArr[1])) {
						sITArr = page.split("\\n");
						for (int iIData = 0; iIData < sITArr.length; iIData = iIData + 1) {
							if (sITArr[iIData].contains(sSFKeyArr[1])) {
								sIDataArr = sITArr[iIData].split(sSFKeyArr[2]);
								System.out.println(sIDataArr.length);
								System.out.println(" reuqired data is : "
										+ sIDataArr[Integer
										            .parseInt(sSFKeyArr[3])]);
								sPDFData = sIDataArr[Integer
								                     .parseInt(sSFKeyArr[3])];
								if (sSFKeyArr.length == 5) {
									// Considering it as length -1 for now
									for (int iLoopCnt = Integer
											.parseInt(sSFKeyArr[3]); iLoopCnt < (sIDataArr.length - 1); iLoopCnt++) {
										sPDFData = sPDFData + " "
												+ sIDataArr[iLoopCnt];
									}
								}
								if (sRCTestcaseID == null
										|| sRCTestcaseID == "") {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device "// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sSFKeyArr[0]
													+ "','"
													+ sPDFData
													+ "','" + sMobDeviceName
													// + "','"
													// + sFlowCode
													+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								} else {
									// Commented runid for pru
									String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
											+ ") Values ('"
											+ sPlanID
											+ "','"
											+ sReleaseID
											+ "','"
											+ sCycleID
											+ "','"
											+ sPlanTestcaseId
											+ "','"
											+ sRCTestcaseID
											+ "','"
											+ sSFKeyArr[0]
													+ "','"
													+ sPDFData
													+ "','" + sMobDeviceName
													// + "','"
													// + sRCTCflowid
													+ "')";
									logger.info("sSQLQuery=" + sSQLQuery);
									oStmt.executeUpdate(sSQLQuery);
								}
								break;
							}
						}
					}
				}
			}
			reader.close(); // finally, close the file.
		} catch (Exception e) {
			logger.info("Inside RReadDataFromPDF  exception");
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			logger.info("UpdateDBfromApp exception : " + sOutput);
			logger.error(e.getMessage());
			iReturnValue = 1;
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
		}
		return iReturnValue;
	}

	/*
	 * public int updatepdfillusrationdetails() throws Exception {
	 * logger.info("Inside UpdatePDFIllusrationDetails"); iTerminateInd = 0; try
	 * { String[] sITArr; String[] sIDataArr; String sQuery = ""; String
	 * PDFPath=sDestPath.replace("/", "\\"); logger.info(PDFPath); //waiting
	 * code for pdf download start Thread.sleep(10000); File f = new
	 * File(PDFPath); for(int i=0;i<=20;i++){ if(f.exists()) {
	 * logger.info("file downloaded"); break; } else { Thread.sleep(2000); if(i
	 * >= 20){ throw new Exception(
	 * "Timeout Error while Downloading PDF or PDF not exixts in given path"); }
	 * }}//waiting code for pdf download end PdfReader reader = new
	 * PdfReader(PDFPath);//D:/rnd/MTU-NBUATSPIS010-TC0121.pdf
	 * logger.info("This PDF has "+reader.getNumberOfPages()+" pages."); for
	 * (int j=1;j<=reader.getNumberOfPages();j++) { String page =
	 * PdfTextExtractor.getTextFromPage(reader, j);
	 * logger.info("Page Content of Page number "+j+":\n\n"+page+"\n\n"); if
	 * (page.contains("ILLUSTRATION TABLE") ||
	 * page.contains("TABEL ILUSTRASI")){ sITArr = page.split("\\n");
	 * logger.info(sITArr.length); // for(int iColumn =
	 * 1;iColumnCount>=iColumn;iColumn=iColumn+1){ //
	 * Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"
	 * ).newInstance(); // String connectionString =
	 * "jdbc:sqlserver://10.252.174.138:1433;user=sa;password=qath@1234;databaseName=qath_manulife"
	 * ; // System.out.println("connectionString="+connectionString); // oConn =
	 * DriverManager.getConnection(connectionString); this.Connect(); for(int
	 * iIT = 0; iIT <= sITArr.length; iIT = iIT + 1){ if
	 * ((sITArr[iIT].contains("<")) && (sITArr[iIT].contains(">"))){ for (int
	 * iReadCnt = 1; iReadCnt <= 20; iReadCnt = iReadCnt + 1){ iIT = iIT + 1;
	 * if((sITArr[iIT].contains("<")) && (sITArr[iIT].contains(">"))) { oStmt =
	 * oConn
	 * .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY
	 * ); if(sRCTestcaseID == null || sRCTestcaseID == ""){
	 * oStmt.executeUpdate("delete from PDF_Illusration_Details where planid='"+
	 * sPlanID +"'" + sReleaseID + "','" + sCycleID + "','" + sPlanTestcaseId +
	 * "',''," ); } else {
	 * oStmt.executeUpdate("delete from PDF_Illusration_Details where planid='"+
	 * sPlanID +"'" + sReleaseID + "','" + sCycleID + "','" + sPlanTestcaseId +
	 * "','" + sRCTestcaseID + "'," ); } iIT = iIT + 1; iReadCnt = 1; } String
	 * temp =""; sIDataArr = sITArr[iIT].split(" "); // if(sIDataArr.length>5){
	 * sQuery = ""; for (int iIData = 0; iIData < sIDataArr.length;iIData =
	 * iIData + 1){
	 * 
	 * if(iIData==sIDataArr.length-1){ if(sITArr[iIT+1].split(" ").length==1) {
	 * temp =(sITArr[iIT+1]); iIT=iIT+1; }
	 * 
	 * } if (sQuery.equals("")){ sQuery = "'" + sIDataArr[iIData] +"'"; } else {
	 * sQuery = sQuery + ", '" + sIDataArr[iIData] +temp + "'"; } } for (int
	 * iColumnCount =
	 * sIDataArr.length;15>iColumnCount;iColumnCount=iColumnCount+1) { sQuery =
	 * sQuery + ",''"; } logger.info(sQuery); oStmt =
	 * oConn.createStatement(ResultSet
	 * .TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); if(sRCTestcaseID ==
	 * null || sRCTestcaseID == ""){ logger.info("sQuery=" +
	 * "insert into PDF_Illusration_Details values ('" + sPlanID + "','" +
	 * sReleaseID + "','" + sCycleID + "','" + sPlanTestcaseId + "',''," +
	 * sQuery.replace("null","0") + ")");
	 * oStmt.executeUpdate("insert into PDF_Illusration_Details values ('" +
	 * sPlanID + "','" + sReleaseID + "','" + sCycleID + "','" + sPlanTestcaseId
	 * + "',''," + sQuery.replace("null","0") + ")"); } else{
	 * logger.info("sQuery=" + "insert into PDF_Illusration_Details values ('" +
	 * sPlanID + "','" + sReleaseID + "','" + sCycleID + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "'," + sQuery.replace("null","0") + ")");
	 * oStmt.executeUpdate("insert into PDF_Illusration_Details values ('" +
	 * sPlanID + "','" + sReleaseID + "','" + sCycleID + "','" + sPlanTestcaseId
	 * + "','" + sRCTestcaseID + "'," + sQuery.replace("null","0") + ")"); } //
	 * oStmt.executeUpdate(
	 * "insert into PDF_Illusration_Details values ('TP000001','Rel 1.0','Cycle 1.0','MTU-TC001','MTU-TC001',"
	 * + sQuery +")"); // } } break; } } // System.out.println("Sd"); } }
	 * 
	 * reader.close(); // finally, close the file. } catch (IOException e) {
	 * iRCTCTerminateInd = 1; sOutput = sOutput + " | "+ e.getMessage();
	 * iReturnValue = 1; logger.error(e.getMessage()); } return iTerminateInd; }
	 */
	// random
	public int randomGenerator() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(10000000);
		return randomInt;
	}

	public int updatedbfromdb() {
		logger.info("Inside UpdateDBFromDB");
		iReturnValue = 0;
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				switch (iObjectSize) {
				case 4:
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						String sSourceTable = oObjects[iObjInd].split(":")[0];
						String sSourceColumn = oObjects[iObjInd].split(":")[1];
						String sTargetTable = oObjects[iObjInd].split(":")[2];
						String sTargetColumn = oObjects[iObjInd].split(":")[3];
						logger.info("sSourceTable=" + sSourceTable
								+ ",sSourceColumn=" + sSourceColumn
								+ ",sTargetTable=" + sTargetTable
								+ ",sTargetColumn=" + sTargetColumn);
						logger.info("sQuery=" + "select " + sSourceColumn
								+ " from " + sSourceTable + " where planid = '"
								+ sPlanID + "' and planreleaseid = '"
								+ sReleaseID + "' and plancycleid = '"
								+ sCycleID + "' and Test_Case = '"
								+ sPlanTestcaseId + "' and flow_code = '"
								+ sFlowCode + "'");
						ResultSet oRSSource = oStmt.executeQuery("select "
								+ sSourceColumn + " from " + sSourceTable
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId
								+ "' and flow_code = '" + sFlowCode + "'");
						oRSSource.first();
						String sTargetValue = oRSSource
								.getString(sSourceColumn);
						logger.info("sTargetValue=" + sTargetValue);
						logger.info("sQuery=" + "update " + sTargetTable
								+ " set " + sTargetColumn + " = '"
								+ sTargetValue + "' where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'");
						oStmt.executeUpdate("update " + sTargetTable + " set "
								+ sTargetColumn + " = '" + sTargetValue
								+ "' where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					} else {
						String sSourceTable = oObjects[iObjInd].split(":")[0];
						String sSourceColumn = oObjects[iObjInd].split(":")[1];
						String sTargetTable = oObjects[iObjInd].split(":")[2];
						String sTargetColumn = oObjects[iObjInd].split(":")[3];
						logger.info("sSourceTable=" + sSourceTable
								+ ",sSourceColumn=" + sSourceColumn
								+ ",sTargetTable=" + sTargetTable
								+ ",sTargetColumn=" + sTargetColumn);
						logger.info("sQuery=" + "select " + sSourceColumn
								+ " from " + sSourceTable + " where planid = '"
								+ sPlanID + "' and planreleaseid = '"
								+ sReleaseID + "' and plancycleid = '"
								+ sCycleID + "' and Test_Case = '"
								+ sPlanTestcaseId + "'");
						ResultSet oRSSource = oStmt
								.executeQuery("select " + sSourceColumn
										+ " from " + sSourceTable
										+ " where planid = '" + sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID + "' and plancycleid = '"
										+ sCycleID + "' and Test_Case = '"
										+ sPlanTestcaseId + "'");
						oRSSource.first();
						String sTargetValue = oRSSource
								.getString(sSourceColumn);
						logger.info("sTargetValue=" + sTargetValue);
						logger.info("sQuery=" + "update " + sTargetTable
								+ " set " + sTargetColumn + " = '"
								+ sTargetValue + "' where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'");
						oStmt.executeUpdate("update " + sTargetTable + " set "
								+ sTargetColumn + " = '" + sTargetValue
								+ "' where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					}
					break;
				case 2:
					String sSourceCol = oObjects[iObjInd].split(":")[0];
					String sTargetCol = oObjects[iObjInd].split(":")[1];
					logger.info("sSourceCol=" + sSourceCol + ",sTargetCol="
							+ sTargetCol);
					logger.info("sQuery=" + "select " + sSourceCol + " from "
							+ sTableName + " where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					ResultSet oRSSourceTemp = oStmt.executeQuery("select "
							+ sSourceCol + " from " + sTableName
							+ " where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					oRSSourceTemp.first();
					String sTarValue = oRSSourceTemp.getString(sSourceCol);
					logger.info("sTarValue=" + sTarValue);
					logger.info("sQuery=" + "update " + sTableName + " set "
							+ sTargetCol + " = '" + sTarValue
							+ "' where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					oStmt.executeUpdate("update " + sTableName + " set "
							+ sTargetCol + " = '" + sTarValue
							+ "' where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					break;
				case 3:
					String sLocalDBTable = oObjects[iObjInd].split(":")[0];
					String sLocalDBCol = oObjects[iObjInd].split(":")[1];
					String sTDCol = oObjects[iObjInd].split(":")[2];
					logger.info("sLocalDBTable=" + sLocalDBTable
							+ ",sLocalDBCol=" + sLocalDBCol + ",sTDCol="
							+ sTDCol);
					String sQry = "";
					if (sAutomationFunction.contains("Flow")) {
						// if (sRCTestcaseID == null || sRCTestcaseID == "") {
						sRCTestcaseID = "";
						sQry = "select " + sTDCol + " from " + sTableName
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'";
					} else {
						sQry = "select " + sTDCol + " from " + sTableName
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId
								+ "' and test_case_ser = '" + sRCTestcaseID
								+ "'";
					}
					logger.info("sQuery=" + sQry);
					ResultSet oRSTD = oStmt.executeQuery(sQry);
					oRSTD.first();
					String[] sTDArr = sTDCol.split(",");
					String sData = "'";
					for (int iTDArr = 0; sTDArr.length > iTDArr; iTDArr = iTDArr + 1) {
						sData = sData + oRSTD.getString(sTDArr[iTDArr]) + "','";
						logger.info(sTDArr[iTDArr] + "="
								+ oRSTD.getString(sTDArr[iTDArr]));
					}
					sData = sData.substring(0, (sData.length() - 2));
					String sInsertQry = "insert into "
							+ sLocalDBTable
							+ "(planid, planreleaseid, plancycleid, test_case, test_case_ser, "
							+ sLocalDBCol + ") values ('" + sPlanID + "','"
							+ sReleaseID + "','" + sCycleID + "','"
							+ sPlanTestcaseId + " ','" + sRCTestcaseID + "',"
							+ sData + ")";
					logger.info("sTargetValue =" + sInsertQry);
					oStmt.executeUpdate(sInsertQry);
					break;
				case 5: // Particularly for entering values in referencetabale
					String sSourceTbl = oObjects[iObjInd].split(":")[0];
					String sSourceClmn = oObjects[iObjInd].split(":")[1];
					String sTargetTbl = oObjects[iObjInd].split(":")[2];
					String sTargetClmn = oObjects[iObjInd].split(":")[3];
					String sTargetFC = oObjects[iObjInd].split(":")[4];
					logger.info("sSourceTbl=" + sSourceTbl + ",sSourceClmn="
							+ sSourceClmn + ",sTargetTbl=" + sTargetTbl
							+ ",sTargetClmn=" + sTargetClmn + ",sTargetFC="
							+ sTargetFC);
					logger.info("sQuery=" + "select " + sSourceClmn + " from "
							+ sSourceTbl + " where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					ResultSet oRSSource1 = oStmt.executeQuery("select "
							+ sSourceClmn + " from " + sSourceTbl
							+ " where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Test_Case = '" + sPlanTestcaseId + "'");
					oRSSource1.first();
					String sTargetValue1 = oRSSource1.getString(sSourceClmn);
					logger.info("sTargetValue=" + sTargetValue1);
					logger.info("sQuery=" + "insert into " + sTargetTbl
							+ " values ( '" + sPlanID + "' , '" + sReleaseID
							+ "' , '" + sCycleID + "' , '" + sReleaseID
							+ "' , '" + sRCTestcaseID + "' , '"
							+ sPlanTestcaseId + "' , '" + sSourceClmn + "' , '"
							+ sTargetValue1 + "' , '" + sTargetFC + "'");
					oStmt.executeUpdate("insert into " + sTargetTbl
							+ " values ( '" + sPlanID + "' , '" + sReleaseID
							+ "' , '" + sCycleID + "' , '" + sReleaseID
							+ "' , '" + sRCTestcaseID + "' , '"
							+ sPlanTestcaseId + "' , '" + sSourceClmn + "' , '"
							+ sTargetValue1 + "' , '" + sTargetFC + "'");
					break;
				}
			}
		} catch (Exception e) {
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {
				iReturnValue = 1;
			}
		}
		return iReturnValue;
	}

	public int fetchfromlocaldb() {
		logger.info("Inside   FetchFromLocalDB");
		iReturnValue = 0;
		String sTestData = "", sCol = "", sSelQuery = "", sSQLQuery = "", sTargetValue = "";
		ResultSet oRSFlagUpdate = null;
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				sTestData = oGlobalMap.get(oObjects[iObjInd].toLowerCase());
				// sTestData = "Select " + oObjects[iObjInd] +"from "+
				// "NRIC_Data_Dump "+"where " +
				// "nationality ="+oObjects[1]+"and dob ="+oObjects[2];
				System.out.println("Plolicy Number : " + sTestData);
				if (sTestData.toLowerCase().contains("from")) {
					sCol = sTestData.split("from")[0];
					sCol = (sCol.replace("select", "")).trim();
					sSelQuery = "select id, " + sCol + " from "
							+ sTestData.split("from")[1];
					System.out.println("" + sSelQuery);
					if (sSelQuery.contains("$$")) {
						String[] sSelArr = sSelQuery.split("\\$\\$");
						for (int iCnt = 1; iCnt < sSelArr.length; iCnt = iCnt + 2) {
							String sd = oGlobalMap.get(sSelArr[iCnt]
									.toLowerCase()); // "fd";
							sSelQuery = sSelQuery.replace("$$" + sSelArr[iCnt]
									+ "$$", sd);
						}
					}
					System.out.println("" + sSelQuery);
					sLocalDBTableName = ((sTestData.split("from")[1])
							.split("where")[0]).trim();
					if ((sTestData.toLowerCase()).matches("select(.*)from(.*)")) {
						ResultSet oRSSource = oStmt
								.executeQuery(sSelQuery
										+ " and ( used_flag = '' OR used_flag is  null)");
						oRSSource.first();
						sTargetValue = oRSSource.getString(sCol);
						sid = oRSSource.getString("id");
						oGlobalMap.put(oObjects[iObjInd].toLowerCase(),
								sTargetValue);
						// Update LocalDB as Used
						sSQLQuery = "update " + sLocalDBTableName
								+ " set used_flag = 'used'" + " where id = '"
								+ sid + "'";
						logger.info("sSQLQuery=" + sSQLQuery);
						oStmt.executeUpdate(sSQLQuery);
						// Update Value in test data container
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							sRCTestcaseID = "";
						} else {
						}
						sSQLQuery = "update " + sTableName + " set "
								+ oObjects[iObjInd] + " = '" + sTargetValue
								+ "' where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and test_case = '" + sPlanTestcaseId + "'"
								+ " and test_case_ser = '" + sRCTestcaseID
								+ "'";
						logger.info("sSQLQuery=" + sSQLQuery);
						// update Policy_details set used_flag='Used' where
						// Pol_id=''
						oStmt.executeUpdate(sSQLQuery);
					}
				}
			}
		} catch (Exception e) {
			if (sOutput.equals("")) {
				sOutput = "Data not found for Query : " + sTestData;
			} else {
				sOutput = sOutput + " | Data not found for Query : "
						+ sTestData;
			}

			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	public int updateexpectedresultfromdb() {
		logger.info("Inside  UpdateExpectedResultFromDB");
		iReturnValue = 0;
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			String SourceCol = "";
			String TargetCol = "";
			String sQuery = "";
			String ValRsUpdateColumn = "";
			ResultSet oRSQuery;
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				switch (iObjectSize) {
				case 1:
					SourceCol = oObjects[iObjInd].split(":")[0];
					TargetCol = SourceCol;
					logger.info("SourceCol=" + SourceCol + ",TargetCol="
							+ TargetCol);
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						sQuery = "select " + SourceCol + " from " + sTableName
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'";
						logger.info("sQuery=" + sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							ValRsUpdateColumn = oRSQuery.getString(SourceCol);
							if (TargetCol.equalsIgnoreCase("IC_name")) {
								ValRsUpdateColumn = ValRsUpdateColumn
										.substring(0, 6)
										+ "-"
										+ ValRsUpdateColumn.substring(6, 8)
										+ "-"
										+ ValRsUpdateColumn.substring(8, 12);
							} else if (TargetCol.equalsIgnoreCase("User_ID")) {
								ValRsUpdateColumn = "00000" + ValRsUpdateColumn;
							}
						}

						oRSQuery.close();
						oStmt.executeUpdate("delete from QTP_ExpectedResult Where TestCaseId = '"
								+ sPlanTestcaseId
								+ "' and Field = '"
								+ TargetCol + "'");
						oStmt.executeUpdate("insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
								+ " values ('"
								+ sPlanTestcaseId
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','Auto')");
					} else {
						sQuery = "select " + SourceCol + " from " + sTableName
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId
								+ "' and test_case_ser = '" + sRCTestcaseID
								+ "'";
						logger.info("sQuery=" + sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							ValRsUpdateColumn = oRSQuery.getString(SourceCol);
							if (ValRsUpdateColumn.equalsIgnoreCase("IC_name")) {
								ValRsUpdateColumn = ValRsUpdateColumn
										.substring(0, 6)
										+ "-"
										+ ValRsUpdateColumn.substring(6, 8)
										+ "-"
										+ ValRsUpdateColumn.substring(8, 12);
							}
						}
						oRSQuery.close();
						oStmt.executeUpdate("delete from QTP_ExpectedResult Where TestCaseId = '"
								+ sRCTestcaseID
								+ "' and Field = '"
								+ TargetCol
								+ "'");
						oStmt.executeUpdate("insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
								+ " values ('"
								+ sRCTestcaseID
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','Auto')");
					}
					break;
				case 2:
					SourceCol = oObjects[iObjInd].split(":")[0];
					TargetCol = oObjects[iObjInd].split(":")[1];
					logger.info("SourceCol=" + SourceCol + ",TargetCol="
							+ TargetCol);
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						if (SourceCol.contains("~~")) {
							String SourceCol1, SourceCol2;
							String SourceCol1_Data = "";
							String SourceCol2_Data = "";
							SourceCol1 = SourceCol.split("~~")[0];
							SourceCol2 = SourceCol.split("~~")[1];
							sQuery = "select " + SourceCol1 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									// + "' and test_case_ser = '" +
									// sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol1_Data = oRSQuery
										.getString(SourceCol1);
								logger.info("SourceCol1_Data="
										+ SourceCol1_Data);
							}
							sQuery = "select " + SourceCol2 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									// + "' and test_case_ser = '" +
									// sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol2_Data = oRSQuery
										.getString(SourceCol2);
								logger.info("SourceCol2_Data="
										+ SourceCol2_Data);
							}
							oRSQuery.close();
							ValRsUpdateColumn = SourceCol1_Data + " "
									+ SourceCol2_Data;
						} else {
							sQuery = "select " + SourceCol + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId + "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								ValRsUpdateColumn = oRSQuery
										.getString(SourceCol);
							}
							oRSQuery.close();
						}
						logger.info("ValRsUpdateColumn=" + ValRsUpdateColumn);
						oStmt.executeUpdate("delete from QTP_ExpectedResult Where TestCaseId = '"
								+ sPlanTestcaseId
								+ "' and Field = '"
								+ TargetCol + "'");
						oStmt.executeUpdate("insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
								+ " values ('"
								+ sPlanTestcaseId
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','Auto')");
					} else {
						if (SourceCol.contains("~~")) {
							String SourceCol1, SourceCol2;
							String SourceCol1_Data = "";
							String SourceCol2_Data = "";
							SourceCol1 = SourceCol.split("~~")[0];
							SourceCol2 = SourceCol.split("~~")[1];
							sQuery = "select " + SourceCol1 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '" + sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol1_Data = oRSQuery
										.getString(SourceCol1);
								logger.info("SourceCol1_Data="
										+ SourceCol1_Data);
							}
							sQuery = "select " + SourceCol2 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '" + sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol2_Data = oRSQuery
										.getString(SourceCol2);
								logger.info("SourceCol2_Data="
										+ SourceCol2_Data);
							}
							oRSQuery.close();
							ValRsUpdateColumn = SourceCol1_Data + " "
									+ SourceCol2_Data;
						} else {
							sQuery = "select " + SourceCol + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '" + sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								ValRsUpdateColumn = oRSQuery
										.getString(SourceCol);
							}
							oRSQuery.close();
						}
						oStmt.executeUpdate("delete from QTP_ExpectedResult Where TestCaseId = '"
								+ sRCTestcaseID
								+ "' and Field = '"
								+ TargetCol
								+ "'");
						oStmt.executeUpdate("insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
								+ " values ('"
								+ sRCTestcaseID
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','Auto')");
					}
					break;
				}
			}
		} catch (Exception e) {
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | "+"\n" + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int updateactualresultfromdb() {
		logger.info("Inside  UpdateActualResultFromDB");
		iReturnValue = 0;
		try {
			String[] oObjects = sSFStepKeyword.split(";;");
			String SourceCol = "";
			String TargetCol = "";
			String sQuery = "";
			String ValRsUpdateColumn = "";
			ResultSet oRSQuery;
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				String[] oChildObjects = oObjects[iObjInd].split(":");
				int iObjectSize = oChildObjects.length;
				switch (iObjectSize) {
				case 1:
					SourceCol = oObjects[iObjInd].split(":")[0];
					TargetCol = SourceCol;
					logger.info("SourceCol=" + SourceCol + ",TargetCol="
							+ TargetCol);
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						sQuery = "select " + SourceCol + " from " + sTableName
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId + "'";
						logger.info("sQuery=" + sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							ValRsUpdateColumn = oRSQuery.getString(SourceCol);
						}
						oRSQuery.close();
						oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sPlanTestcaseId
								+ "' and Field = '"
								+ TargetCol
								+ "' and device = '"
								+ sMobDeviceName + "'");
						// Commented runid for pru
						String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue, device"// ,RunID
								+ ") Values ('"
								+ sPlanID
								+ "','"
								+ sReleaseID
								+ "','"
								+ sCycleID
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','"
								+ sMobDeviceName
								// + "','"
								// + sFlowCode
								+ "')";
						logger.info("sSQLQuery=" + sSQLQuery);
						oStmt.executeUpdate(sSQLQuery);
					} else {
						sQuery = "select " + SourceCol + " from " + sTableName
								+ " where planid = '" + sPlanID
								+ "' and planreleaseid = '" + sReleaseID
								+ "' and plancycleid = '" + sCycleID
								+ "' and Test_Case = '" + sPlanTestcaseId
								+ "' and test_case_ser = '" + sRCTestcaseID
								+ "'";
						logger.info("sQuery=" + sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							ValRsUpdateColumn = oRSQuery.getString(SourceCol);
						}
						oRSQuery.close();
						oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sRCTestcaseID
								+ "' and Field = '"
								+ TargetCol
								+ "' and device = '" + sMobDeviceName + "'");
						// Commented runid for pru
						String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
								+ ") Values ('"
								+ sPlanID
								+ "','"
								+ sReleaseID
								+ "','"
								+ sCycleID
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ sRCTestcaseID
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','"
								+ sMobDeviceName
								// + "','"
								// + sRCTCflowid
								+ "')";
						logger.info("sSQLQuery=" + sSQLQuery);
						oStmt.executeUpdate(sSQLQuery);
					}
					break;
				case 2:
					SourceCol = oObjects[iObjInd].split(":")[0];
					TargetCol = oObjects[iObjInd].split(":")[1];
					logger.info("SourceCol=" + SourceCol + ",TargetCol="
							+ TargetCol);
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						if (SourceCol.contains("~~")) {
							String SourceCol1, SourceCol2;
							String SourceCol1_Data = "";
							String SourceCol2_Data = "";
							SourceCol1 = SourceCol.split("~~")[0];
							SourceCol2 = SourceCol.split("~~")[1];
							sQuery = "select " + SourceCol1 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									// + "' and test_case_ser = '" +
									// sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol1_Data = oRSQuery
										.getString(SourceCol1);
								logger.info("SourceCol1_Data="
										+ SourceCol1_Data);
							}
							sQuery = "select " + SourceCol2 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									// + "' and test_case_ser = '" +
									// sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol2_Data = oRSQuery
										.getString(SourceCol2);
								logger.info("SourceCol2_Data="
										+ SourceCol2_Data);
							}
							oRSQuery.close();
							ValRsUpdateColumn = SourceCol1_Data + " "
									+ SourceCol2_Data;
						} else {
							sQuery = "select " + SourceCol + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId + "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								ValRsUpdateColumn = oRSQuery
										.getString(SourceCol);
							}
							oRSQuery.close();
						}
						logger.info("ValRsUpdateColumn=" + ValRsUpdateColumn);
						oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sPlanTestcaseId
								+ "' and Field = '"
								+ TargetCol
								+ "' and device = '"
								+ sMobDeviceName + "'");
						// Commented runid for pru
						String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue, device"// ,RunID
								+ ") Values ('"
								+ sPlanID
								+ "','"
								+ sReleaseID
								+ "','"
								+ sCycleID
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','"
								+ sMobDeviceName
								// + "','"
								// + sFlowCode
								+ "')";
						logger.info("sSQLQuery=" + sSQLQuery);
						oStmt.executeUpdate(sSQLQuery);
					} else {
						if (SourceCol.contains("~~")) {
							String SourceCol1, SourceCol2;
							String SourceCol1_Data = "";
							String SourceCol2_Data = "";
							SourceCol1 = SourceCol.split("~~")[0];
							SourceCol2 = SourceCol.split("~~")[1];
							sQuery = "select " + SourceCol1 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '" + sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol1_Data = oRSQuery
										.getString(SourceCol1);
								logger.info("SourceCol1_Data="
										+ SourceCol1_Data);
							}
							sQuery = "select " + SourceCol2 + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '" + sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								SourceCol2_Data = oRSQuery
										.getString(SourceCol2);
								logger.info("SourceCol2_Data="
										+ SourceCol2_Data);
							}
							oRSQuery.close();
							ValRsUpdateColumn = SourceCol1_Data + " "
									+ SourceCol2_Data;
						} else {
							sQuery = "select " + SourceCol + " from "
									+ sTableName + " where planid = '"
									+ sPlanID + "' and planreleaseid = '"
									+ sReleaseID + "' and plancycleid = '"
									+ sCycleID + "' and Test_Case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '" + sRCTestcaseID
									+ "'";
							logger.info("sQuery=" + sQuery);
							oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								ValRsUpdateColumn = oRSQuery
										.getString(SourceCol);
							}
							oRSQuery.close();
						}
						oStmt.executeUpdate("delete from QTP_ActualResult where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sRCTestcaseID
								+ "' and Field = '"
								+ TargetCol
								+ "' and device = '" + sMobDeviceName + "'");
						// Commented runid for pru
						String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
								+ ") Values ('"
								+ sPlanID
								+ "','"
								+ sReleaseID
								+ "','"
								+ sCycleID
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ sRCTestcaseID
								+ "','"
								+ TargetCol
								+ "','"
								+ ValRsUpdateColumn
								+ "','"
								+ sMobDeviceName
								// + "','"
								// + sRCTCflowid
								+ "')";
						logger.info("sSQLQuery=" + sSQLQuery);
						oStmt.executeUpdate(sSQLQuery);
					}
					break;
				}
			}
		} catch (Exception e) {
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | "+"\n" + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int delay() {
		logger.info("Inside Delay " + sSFStepKeyword + " Sec");
		iReturnValue = 0;
		try {
			Boolean coloumncheck = oGlobalMap.containsKey(sSFStepKeyword
					.toLowerCase());
			if (coloumncheck == true) {
				Thread.sleep(Integer.parseInt(oGlobalMap.get(sSFStepKeyword
						.toLowerCase())) * 1000);
			} else {
				Thread.sleep(Integer.parseInt(sSFStepKeyword) * 1000);
			}
		} catch (Exception e) {
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	/*
	 * public int callapi() { logger.info("Inside CallApi " + sSFStepKeyword +
	 * " is API Name"); iReturnValue = 0; try { String sAPIResult = ""; //
	 * NRIC_FIN_No String sType = ""; String sAPIResponse = ""; // String[]
	 * Param; Runner run = new Runner(); if (sSFStepKeyword.contains(":")) {
	 * sSFStepKeyword = sSFStepKeyword.split(":")[0]; sType = "csv"; }
	 * logger.info(sSFStepKeyword.toUpperCase()); switch
	 * (sSFStepKeyword.toUpperCase()) { case "COMPUTE": // sAPIResult =
	 * run.computeApiData(sSFStepKeyword); if (sType.equalsIgnoreCase("csv")) {
	 * // sAPIResult = run.clientSearchApiData(sSFStepKeyword); // String[]
	 * Param = //
	 * {oGlobalMap.get(("token_id").toLowerCase()),"true","false","","false"};
	 * String[] Param = { oGlobalMap.get(("name").toLowerCase()),
	 * oGlobalMap.get(("DOB").toLowerCase()),
	 * oGlobalMap.get(("Age").toLowerCase()),
	 * oGlobalMap.get(("Gender").toLowerCase()),
	 * oGlobalMap.get(("Smoker").toLowerCase()),
	 * oGlobalMap.get(("ResidentStatus").toLowerCase()),
	 * oGlobalMap.get(("NumberOfLife").toLowerCase()),
	 * oGlobalMap.get(("ClientType").toLowerCase()),
	 * oGlobalMap.get(("SQSProdCode").toLowerCase()),
	 * oGlobalMap.get(("SQSisAgeRequire").toLowerCase()),
	 * oGlobalMap.get(("SQSisSmokerReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisResidentialStatusReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisOccupReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisGenderReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisPaymentModeReq").toLowerCase()),
	 * oGlobalMap.get(("SQSPaymentMode").toLowerCase()),
	 * oGlobalMap.get(("SQSCompoCode").toLowerCase()),
	 * oGlobalMap.get(("SQSisBasic").toLowerCase()),
	 * oGlobalMap.get(("SQSlifeInsuredType").toLowerCase()),
	 * oGlobalMap.get(("SQSterm").toLowerCase()),
	 * oGlobalMap.get(("SQSbenefitTerm").toLowerCase()),
	 * oGlobalMap.get(("SQSPremiumTerm").toLowerCase()),
	 * oGlobalMap.get(("SQSPremium").toLowerCase()),
	 * oGlobalMap.get(("SQSSumAssured").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanOptCode").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanoptDesc").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanoptDataType").toLowerCase()),
	 * oGlobalMap.get(("CompoplanOptValue").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanisOptValueEditable").toLowerCase()),
	 * oGlobalMap.get(("TermOptCode").toLowerCase()),
	 * oGlobalMap.get(("TermOptValue").toLowerCase()),
	 * oGlobalMap.get(("TermOptDesc").toLowerCase()),
	 * oGlobalMap.get(("ProdCode").toLowerCase()),
	 * oGlobalMap.get(("isAgeReq").toLowerCase()),
	 * oGlobalMap.get(("isSmokerReq").toLowerCase()),
	 * oGlobalMap.get(("isResidentialStatusReq").toLowerCase()),
	 * oGlobalMap.get(("isOccupReq").toLowerCase()),
	 * oGlobalMap.get(("isGenderReq").toLowerCase()),
	 * oGlobalMap.get(("isPaymentModeReq").toLowerCase()),
	 * oGlobalMap.get(("PaymentMode").toLowerCase()),
	 * oGlobalMap.get(("Compocode").toLowerCase()),
	 * oGlobalMap.get(("isBasic").toLowerCase()),
	 * oGlobalMap.get(("lifeInsuredType").toLowerCase()),
	 * oGlobalMap.get(("term").toLowerCase()),
	 * oGlobalMap.get(("benefitTerm").toLowerCase()),
	 * oGlobalMap.get(("premiumTerm").toLowerCase()),
	 * oGlobalMap.get(("premium").toLowerCase()),
	 * oGlobalMap.get(("sum assured").toLowerCase()),
	 * oGlobalMap.get(("optcode").toLowerCase()),
	 * oGlobalMap.get(("optDesc").toLowerCase()),
	 * oGlobalMap.get(("optDatatype").toLowerCase()),
	 * oGlobalMap.get(("optValue").toLowerCase()),
	 * oGlobalMap.get(("isOptValueEditable").toLowerCase()),
	 * oGlobalMap.get(("OptCode1").toLowerCase()),
	 * oGlobalMap.get(("OptValue1").toLowerCase()),
	 * oGlobalMap.get(("opTDesc1").toLowerCase()),
	 * oGlobalMap.get(("token_id").toLowerCase()) }; //
	 * {oGlobalMap.get(("token_id"
	 * ).toLowerCase()),"true","false",oGlobalMap.get(
	 * ("NRIC_FIN_No").toLowerCase()),"false"}; sAPIResult =
	 * ComputeParam.compute(Param); // Update response in actual result if
	 * (sAPIResult.split("~~").length == 3) { sAPIResponse =
	 * (sAPIResult.split("~~")[2]).replace("'","''"); } logger.info(sAPIResult);
	 * if (sAPIResult.contains("~~")) { sStatus = sAPIResult.split("~~")[1]; }
	 * else { sStatus = "Fail"; } if (sOutput.equals("")) { sOutput =
	 * sAPIResult.split("~~")[0]; } else { sOutput = sOutput + " | " +
	 * sAPIResult.split("~~")[0]; } } else { // String[] Param = //
	 * {"2017827151218wlm"
	 * ,"true","false",oGlobalMap.get(("NRIC_FIN_No").toLowerCase()),"false"};
	 * String[] Param = { oGlobalMap.get(("name").toLowerCase()),
	 * oGlobalMap.get(("DOB").toLowerCase()),
	 * oGlobalMap.get(("Age").toLowerCase()),
	 * oGlobalMap.get(("Gender").toLowerCase()),
	 * oGlobalMap.get(("Smoker").toLowerCase()),
	 * oGlobalMap.get(("ResidentStatus").toLowerCase()),
	 * oGlobalMap.get(("NumberOfLife").toLowerCase()),
	 * oGlobalMap.get(("ClientType").toLowerCase()),
	 * oGlobalMap.get(("SQSProdCode").toLowerCase()),
	 * oGlobalMap.get(("SQSisAgeRequire").toLowerCase()),
	 * oGlobalMap.get(("SQSisSmokerReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisResidentialStatusReq") .toLowerCase()),
	 * oGlobalMap.get(("SQSisOccupReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisGenderReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisPaymentModeReq") .toLowerCase()),
	 * oGlobalMap.get(("SQSPaymentMode").toLowerCase()),
	 * oGlobalMap.get(("SQSCompoCode").toLowerCase()),
	 * oGlobalMap.get(("SQSisBasic").toLowerCase()), oGlobalMap
	 * .get(("SQSlifeInsuredType").toLowerCase()),
	 * oGlobalMap.get(("SQSterm").toLowerCase()),
	 * oGlobalMap.get(("SQSbenefitTerm").toLowerCase()),
	 * oGlobalMap.get(("SQSPremiumTerm").toLowerCase()),
	 * oGlobalMap.get(("SQSPremium").toLowerCase()),
	 * oGlobalMap.get(("SQSSumAssured").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanOptCode").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanoptDesc").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanoptDataType") .toLowerCase()),
	 * oGlobalMap.get(("CompoplanOptValue").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanisOptValueEditable") .toLowerCase()),
	 * oGlobalMap.get(("TermOptCode").toLowerCase()),
	 * oGlobalMap.get(("TermOptValue").toLowerCase()),
	 * oGlobalMap.get(("TermOptDesc").toLowerCase()),
	 * oGlobalMap.get(("ProdCode").toLowerCase()),
	 * oGlobalMap.get(("isAgeReq").toLowerCase()),
	 * oGlobalMap.get(("isSmokerReq").toLowerCase()),
	 * oGlobalMap.get(("isResidentialStatusReq") .toLowerCase()),
	 * oGlobalMap.get(("isOccupReq").toLowerCase()),
	 * oGlobalMap.get(("isGenderReq").toLowerCase()),
	 * oGlobalMap.get(("isPaymentModeReq").toLowerCase()),
	 * oGlobalMap.get(("PaymentMode").toLowerCase()),
	 * oGlobalMap.get(("Compocode").toLowerCase()),
	 * oGlobalMap.get(("isBasic").toLowerCase()),
	 * oGlobalMap.get(("lifeInsuredType").toLowerCase()),
	 * oGlobalMap.get(("term").toLowerCase()),
	 * oGlobalMap.get(("benefitTerm").toLowerCase()),
	 * oGlobalMap.get(("premiumTerm").toLowerCase()),
	 * oGlobalMap.get(("premium").toLowerCase()),
	 * oGlobalMap.get(("sum assured").toLowerCase()),
	 * oGlobalMap.get(("optcode").toLowerCase()),
	 * oGlobalMap.get(("optDesc").toLowerCase()),
	 * oGlobalMap.get(("optDatatype").toLowerCase()),
	 * oGlobalMap.get(("optValue").toLowerCase()), oGlobalMap
	 * .get(("isOptValueEditable").toLowerCase()),
	 * oGlobalMap.get(("OptCode1").toLowerCase()),
	 * oGlobalMap.get(("OptValue1").toLowerCase()),
	 * oGlobalMap.get(("opTDesc1").toLowerCase()),
	 * oGlobalMap.get(("token_id").toLowerCase()) }; sAPIResult =
	 * ComputeParam.compute(Param); logger.info(sAPIResult); if
	 * (sAPIResult.contains("~~")) { sStatus = sAPIResult.split("~~")[1]; } else
	 * { sStatus = "Fail"; } if (sOutput.equals("")) { sOutput =
	 * sAPIResult.split("~~")[0]; } else { sOutput = sOutput + " | " +
	 * sAPIResult.split("~~")[0]; } // Update response in actual result if
	 * (sAPIResult.split("~~").length == 3) { sAPIResponse =
	 * (sAPIResult.split("~~")[2]).replace("'", "''"); ; } } break; case
	 * "CLIENTSEARCH": logger.info("nric number is " +
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase())); // sAPIResult =
	 * run.clientSearchApiData(sSFStepKeyword); if
	 * (sType.equalsIgnoreCase("csv")) { // sAPIResult =
	 * run.clientSearchApiData(sSFStepKeyword); // String[] Param = //
	 * {oGlobalMap.get(("token_id").toLowerCase()),"true","false","","false"};
	 * String[] Param = { oGlobalMap.get(("token_id").toLowerCase()), "true",
	 * "false", oGlobalMap.get(("NRIC_FIN_No").toLowerCase()), "false" };
	 * sAPIResult = ClientSearchParam.clientSearch(Param);
	 * 
	 * // Update response in actual result if (sAPIResult.split("~~").length ==
	 * 3) { sAPIResponse = (sAPIResult.split("~~")[2]).replace("'", "''"); ; }
	 * logger.info(sAPIResult); if (sAPIResult.contains("~~")) { sStatus =
	 * sAPIResult.split("~~")[1]; } else { sStatus = "Fail"; } if
	 * (sOutput.equals("")) { sOutput = sAPIResult.split("~~")[0]; } else {
	 * sOutput = sOutput + " | " + sAPIResult.split("~~")[0]; } } else {
	 * String[] Param = { "2017827151218wlm", "true", "false",
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase()), "false" }; sAPIResult =
	 * ClientSearchParam.clientSearch(Param); logger.info(sAPIResult); if
	 * (sAPIResult.contains("~~")) { sStatus = sAPIResult.split("~~")[1]; } else
	 * { sStatus = "Fail"; } if (sOutput.equals("")) { sOutput =
	 * sAPIResult.split("~~")[0]; } else { sOutput = sOutput + " | " +
	 * sAPIResult.split("~~")[0]; } // Update response in actual result if
	 * (sAPIResult.split("~~").length == 3) { sAPIResponse =
	 * (sAPIResult.split("~~")[2]).replace("'", "''"); ; } } String sFN = "",
	 * sLN = "", sDOB = "", sCN = "", sNationality = "", sCountryofBirth = "",
	 * sSalutation = "", sEmail = "", sMP = "", sIDNumber = "", sGender = "",
	 * sMaritalStatus = "", sOccupation = "", sOccClass = "", sHtcm = "", sWtkg
	 * = "", sAddType = "", sCountry = "", sBlkHouseNo = "", sStreet = "",
	 * sUnitNo = "", sBldg = "", spcode_city = ""; if
	 * (sAPIResult.contains("firstName")) { if
	 * ((sAPIResult.split("firstName\":\"").length) == 1) { } else { sFN =
	 * (sAPIResult.split("firstName\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("lastName")) { if
	 * ((sAPIResult.split("lastName\":\"").length) == 1) { } else { sLN =
	 * (sAPIResult.split("lastName\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("nationality")) { if
	 * ((sAPIResult.split("nationality\":\"").length) == 1) { } else {
	 * sNationality = (sAPIResult.split("nationality\":\"")[1]) .split("\"")[0];
	 * } } if (sAPIResult.contains("countryOfBirth")) { if
	 * ((sAPIResult.split("countryOfBirth\":\"").length) == 1) { } else {
	 * sCountryofBirth = (sAPIResult
	 * .split("countryOfBirth\":\"")[1]).split("\"")[0]; } } if
	 * (sAPIResult.contains("salutation")) { if
	 * ((sAPIResult.split("salutation\":\"").length) == 1) { } else {
	 * sSalutation = (sAPIResult.split("salutation\":\"")[1]) .split("\"")[0]; }
	 * } if (sAPIResult.contains("email")) { if
	 * ((sAPIResult.split("email\":\"").length) == 1) { } else { sEmail =
	 * (sAPIResult.split("email\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("dateOfBirth")) { if
	 * ((sAPIResult.split("dateOfBirth\":\"").length) == 1) { } else { sDOB =
	 * (sAPIResult.split("dateOfBirth\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("clientNumber")) { if
	 * ((sAPIResult.split("clientNumber\":\"").length) == 1) { } else { sCN =
	 * (sAPIResult.split("clientNumber\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("mobilePhone")) { if
	 * ((sAPIResult.split("mobilePhone\":\"").length) == 1) { } else { sMP =
	 * (sAPIResult.split("mobilePhone\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("idNumber")) { if
	 * ((sAPIResult.split("idNumber\":\"").length) == 1) { } else { sIDNumber =
	 * (sAPIResult.split("idNumber\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("gender")) { if
	 * ((sAPIResult.split("gender\":\"").length) == 1) { } else { sGender =
	 * (sAPIResult.split("gender\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("maritalStatus")) { if
	 * ((sAPIResult.split("maritalStatus\":\"").length) == 1) { } else {
	 * sMaritalStatus = (sAPIResult
	 * .split("maritalStatus\":\"")[1]).split("\"")[0]; } } if
	 * (sAPIResult.contains("occupation")) { if
	 * ((sAPIResult.split("occupation\":\"").length) == 1) { } else {
	 * sOccupation = (sAPIResult.split("occupation\":\"")[1]) .split("\"")[0]; }
	 * } if (sAPIResult.contains("occupationClass")) { if
	 * ((sAPIResult.split("occupationClass\":\"").length) == 1) { } else {
	 * sOccClass = (sAPIResult.split("occupationClass\":\"")[1])
	 * .split("\"")[0]; } } if (sAPIResult.contains("height")) { if
	 * ((sAPIResult.split("height\":\"").length) == 1) { } else { sHtcm =
	 * (sAPIResult.split("height\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("weight")) { if
	 * ((sAPIResult.split("weight\":\"").length) == 1) { } else { sWtkg =
	 * (sAPIResult.split("weight\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("addressType")) { if
	 * ((sAPIResult.split("addressType\":\"").length) == 1) { } else { sAddType
	 * = (sAPIResult.split("addressType\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("country")) { if
	 * ((sAPIResult.split("country\":\"").length) == 1) { } else { sCountry =
	 * (sAPIResult.split("country\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("postalCode")) { if
	 * ((sAPIResult.split("postalCode\":\"").length) == 1) { } else {
	 * spcode_city = (sAPIResult.split("postalCode\":\"")[1]) .split("\"")[0]; }
	 * } if (sAPIResult.contains("block")) { if
	 * ((sAPIResult.split("block\":\"").length) == 1) { } else { sBlkHouseNo =
	 * (sAPIResult.split("block\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("streetName")) { if
	 * ((sAPIResult.split("streetName\":\"").length) == 1) { } else { sStreet =
	 * (sAPIResult.split("streetName\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("floorUnit")) { if
	 * ((sAPIResult.split("floorUnit\":\"").length) == 1) { } else { sUnitNo =
	 * (sAPIResult.split("floorUnit\":\"")[1]) .split("\"")[0]; } } if
	 * (sAPIResult.contains("buildingName")) { if
	 * ((sAPIResult.split("buildingName\":\"").length) == 1) { } else { sBldg =
	 * (sAPIResult.split("buildingName\":\"")[1]) .split("\"")[0]; } } String
	 * sAPITCID = "", sAPITC = "", sAPISerTC = ""; if (sRCTestcaseID == null ||
	 * sRCTestcaseID == "") { sAPITCID = sPlanTestcaseId; sAPITC =
	 * sPlanTestcaseId; sAPISerTC = ""; } else { sAPITCID = sRCTestcaseID;
	 * sAPITC = sPlanTestcaseId; sAPISerTC = sRCTestcaseID; } // String TCID,
	 * String sFieldName, String sExpValue updateexpecteddata(sAPITCID,
	 * "ClientAPI_firstname", sFN, sAPITC, sAPISerTC);
	 * updateexpecteddata(sAPITCID, "ClientAPI_lastname", sLN, sAPITC,
	 * sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_DOB", sDOB, sAPITC,
	 * sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_ClientNumber", sCN,
	 * sAPITC, sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_Nationality",
	 * sNationality, sAPITC, sAPISerTC); updateexpecteddata(sAPITCID,
	 * "clientAPI_CountryOfBirth", sCountryofBirth, sAPITC, sAPISerTC);
	 * updateexpecteddata(sAPITCID, "clientAPI_Salutation", sSalutation, sAPITC,
	 * sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_Email", sEmail,
	 * sAPITC, sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_MobilePhone",
	 * sMP, sAPITC, sAPISerTC); updateexpecteddata(sAPITCID,
	 * "clientAPI_IDNumber", sIDNumber, sAPITC, sAPISerTC);
	 * updateexpecteddata(sAPITCID, "clientAPI_Gender", sGender, sAPITC,
	 * sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_MaritalStatus",
	 * sMaritalStatus, sAPITC, sAPISerTC); updateexpecteddata(sAPITCID,
	 * "clientAPI_Occupation", sOccupation, sAPITC, sAPISerTC);
	 * updateexpecteddata(sAPITCID, "clientAPI_OccuptionClass", sOccClass,
	 * sAPITC, sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_Heightincm",
	 * sHtcm, sAPITC, sAPISerTC); updateexpecteddata(sAPITCID,
	 * "clientAPI_Weightinkg", sWtkg, sAPITC, sAPISerTC);
	 * updateexpecteddata(sAPITCID, "clientAPI_AddressType", sAddType, sAPITC,
	 * sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_Country", sCountry,
	 * sAPITC, sAPISerTC); updateexpecteddata(sAPITCID,
	 * "clientAPI_BlockHouseNo", sBlkHouseNo, sAPITC, sAPISerTC);
	 * updateexpecteddata(sAPITCID, "clientAPI_Street", sStreet, sAPITC,
	 * sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_UnitNo", sUnitNo,
	 * sAPITC, sAPISerTC); updateexpecteddata(sAPITCID, "clientAPI_Building",
	 * sBldg, sAPITC, sAPISerTC); updateexpecteddata(sAPITCID,
	 * "clientAPI_PostalCode", spcode_city, sAPITC, sAPISerTC); // sFN = "", sLN
	 * = "", sDOB = "",sCN = "",sNationality = "", // sCountryofBirth =
	 * "",sSalutation = "", sEmail = "", sMP="", //
	 * sIDNumber="",sGender="",sMaritalStatus
	 * ="",sOccupation="",sOccClass="",sHtcm="",sWtkg="",sAddType // =
	 * "",sCountry="",sBlkHouseNo="", //
	 * sStreet="",sUnitNo="",sBldg="",spcode_city="";
	 * 
	 * 
	 * if (sRCTestcaseID == null || sRCTestcaseID == "") { // Commented runid
	 * for pru String sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * //,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sPlanTestcaseId + "','" +
	 * "ClientAPI_firstname" + "','" + sFN + "','" + sMobDeviceName // + "','"
	 * // + sFlowCode + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); }else { // Commented runid for pru String
	 * sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * //,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sRCTestcaseID + "','" +
	 * "ClientAPI_firstname" + "','" + sFN + "','" + sMobDeviceName // + "','"
	 * // + sRCTCflowid + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); } if (sRCTestcaseID == null ||
	 * sRCTestcaseID == "") { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId +
	 * "' and Field = '" + "given_name" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "given_name" + "','" + sFN +
	 * "','Auto')"); } else { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "given_name" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "given_name" + "','" + sFN +
	 * "','Auto')"); } if (sAPIResult.contains("lastName")){ sLN =
	 * (sAPIResult.split("lastName\":\"")[1]).split("\"")[0]; } if
	 * (sRCTestcaseID == null || sRCTestcaseID == "") { // Commented runid for
	 * pru String sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * //,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sPlanTestcaseId + "','" +
	 * "ClientAPI_lastname" + "','" + sLN + "','" + sMobDeviceName // + "','" //
	 * + sFlowCode + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); }else { // Commented runid for pru String
	 * sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * //,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sRCTestcaseID + "','" +
	 * "ClientAPI_lastname" + "','" + sLN + "','" + sMobDeviceName // + "','" //
	 * + sRCTCflowid + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); } if (sRCTestcaseID == null ||
	 * sRCTestcaseID == "") { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId +
	 * "' and Field = '" + "surname" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "surname" + "','" + sLN +
	 * "','Auto')"); } else { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "surname" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "surname" + "','" + sLN +
	 * "','Auto')"); } if (sAPIResult.contains("nationality")){ sNationality =
	 * (sAPIResult.split("nationality\":\"")[1]).split("\"")[0]; } if
	 * (sRCTestcaseID == null || sRCTestcaseID == "") { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId
	 * + "' and Field = '" + "nationality" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "nationality" + "','" +
	 * sNationality + "','Auto')"); } else { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "nationality" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "nationality" + "','" +
	 * sNationality + "','Auto')"); } if
	 * (sAPIResult.contains("countryOfBirth")){ sCountryofBirth =
	 * (sAPIResult.split("countryOfBirth\":\"")[1]).split("\"")[0]; } if
	 * (sRCTestcaseID == null || sRCTestcaseID == "") { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId
	 * + "' and Field = '" + "country" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "country" + "','" +
	 * sCountryofBirth + "','Auto')"); } else { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "country" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "country" + "','" +
	 * sCountryofBirth + "','Auto')"); } if (sAPIResult.contains("salutation")){
	 * sSalutation = (sAPIResult.split("salutation\":\"")[1]).split("\"")[0]; }
	 * if (sRCTestcaseID == null || sRCTestcaseID == "") { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId
	 * + "' and Field = '" + "salutation" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "salutation" + "','" +
	 * sSalutation + "','Auto')"); } else { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "salutation" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "salutation" + "','" +
	 * sSalutation + "','Auto')"); } if (sAPIResult.contains("eamil")){ sEmail =
	 * (sAPIResult.split("email\":\"")[1]).split("\"")[0]; } if (sRCTestcaseID
	 * == null || sRCTestcaseID == "") { oStmt.executeUpdate
	 * ("delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId
	 * + "' and Field = '" + "email_address" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "email_address" + "','" +
	 * sEmail + "','Auto')"); } else { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "email_address" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "email_address" + "','" + sEmail
	 * + "','Auto')"); } if (sAPIResult.contains("dateOfBirth")){ sDOB =
	 * (sAPIResult.split("dateOfBirth\":\"")[1]).split("\"")[0]; } if
	 * (sRCTestcaseID == null || sRCTestcaseID == "") { // Commented runid for
	 * pru String sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * //,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sPlanTestcaseId + "','" +
	 * "clientAPI_DOB" + "','" + sDOB + "','" + sMobDeviceName // + "','" // +
	 * sFlowCode + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); }else { // Commented runid for pru String
	 * sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * //,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sRCTestcaseID + "','" +
	 * "clientAPI_DOB" + "','" + sDOB + "','" + sMobDeviceName // + "','" // +
	 * sRCTCflowid + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); }// Update for Expected result for LA if
	 * (sRCTestcaseID == null || sRCTestcaseID == "") { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId +
	 * "' and Field = '" + "date_of_birth" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "date_of_birth" + "','" + sDOB
	 * + "','Auto')"); } else { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "date_of_birth" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "date_of_birth" + "','" + sDOB +
	 * "','Auto')"); } if (sAPIResult.contains("clientNumber")){ sCN =
	 * (sAPIResult.split("clientNumber\":\"")[1]).split("\"")[0]; }// Update for
	 * Expected result for LA if (sRCTestcaseID == null || sRCTestcaseID == "")
	 * { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId +
	 * "' and Field = '" + "contract_owner" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "contract_owner" + "','" + sCN
	 * + "','Auto')"); } else { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "contract_owner" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "contract_owner" + "','" + sCN +
	 * "','Auto')"); } if (sAPIResult.contains("mobilePhone")){ sMP =
	 * (sAPIResult.split("mobilePhone\":\"")[1]).split("\"")[0]; }// Update for
	 * Expected result for LA if (sRCTestcaseID == null || sRCTestcaseID == "")
	 * { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sPlanTestcaseId +
	 * "' and Field = '" + "DP_Mobile_Phone" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sPlanTestcaseId + "','" + "DP_Mobile_Phone" + "','" +
	 * sMP + "','Auto')"); } else { oStmt.executeUpdate(
	 * "delete from QTP_ExpectedResult Where TestCaseId = '" + sRCTestcaseID +
	 * "' and Field = '" + "DP_Mobile_Phone" + "'"); oStmt.executeUpdate(
	 * "insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
	 * + " values ('" + sRCTestcaseID + "','" + "DP_Mobile_Phone" + "','" + sMP
	 * + "','Auto')"); }
	 * 
	 * break; case "QUESTIONNAIRE": // sAPIResult =
	 * run.questionnaireApiData(sSFStepKeyword); if
	 * (sType.equalsIgnoreCase("csv")) { // sAPIResult =
	 * run.clientSearchApiData(sSFStepKeyword); // String[] Param = //
	 * {oGlobalMap.get(("token_id").toLowerCase()),"true","false","","false"};
	 * String[] Param = { oGlobalMap.get(("token_id").toLowerCase()),
	 * oGlobalMap.get(("name").toLowerCase()),
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase()),
	 * oGlobalMap.get(("DOB").toLowerCase()),
	 * oGlobalMap.get(("Age").toLowerCase()),
	 * oGlobalMap.get(("Gender").toLowerCase()),
	 * oGlobalMap.get(("ResidentStatus").toLowerCase()),
	 * oGlobalMap.get(("existingClient").toLowerCase()),
	 * oGlobalMap.get(("lastPolicyPurchaseDate") .toLowerCase()),
	 * oGlobalMap.get(("docId").toLowerCase()),
	 * oGlobalMap.get(("ProdCode").toLowerCase()),
	 * oGlobalMap.get(("Compocode").toLowerCase()),
	 * oGlobalMap.get(("sumassured").toLowerCase()),
	 * oGlobalMap.get(("isBasic").toLowerCase()),
	 * oGlobalMap.get(("platform").toLowerCase()),
	 * oGlobalMap.get(("transactionType").toLowerCase()),
	 * oGlobalMap.get(("version").toLowerCase()),
	 * oGlobalMap.get(("categoryList").toLowerCase()) }; //
	 * {oGlobalMap.get(("token_id"
	 * ).toLowerCase()),"true","false",oGlobalMap.get(
	 * ("NRIC_FIN_No").toLowerCase()),"false"}; sAPIResult =
	 * QuestionnaireParam.questionnaire(Param); // ComputeParam.compute(Param);
	 * 
	 * // Update response in actual result if (sAPIResult.split("~~").length ==
	 * 3) { sAPIResponse = (sAPIResult.split("~~")[2]).replace("'", "''"); ; }
	 * logger.info(sAPIResult); if (sAPIResult.contains("~~")) { sStatus =
	 * sAPIResult.split("~~")[1]; } else { sStatus = "Fail"; } if
	 * (sOutput.equals("")) { sOutput = sAPIResult.split("~~")[0]; } else {
	 * sOutput = sOutput + " | " + sAPIResult.split("~~")[0]; } } else { //
	 * String[] Param = //
	 * {"2017827151218wlm","true","false",oGlobalMap.get(("NRIC_FIN_No"
	 * ).toLowerCase()),"false"}; String[] Param = {
	 * oGlobalMap.get(("token_id").toLowerCase()),
	 * oGlobalMap.get(("name").toLowerCase()),
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase()),
	 * oGlobalMap.get(("DOB").toLowerCase()),
	 * oGlobalMap.get(("Age").toLowerCase()),
	 * oGlobalMap.get(("Gender").toLowerCase()),
	 * oGlobalMap.get(("ResidentStatus").toLowerCase()),
	 * oGlobalMap.get(("existingClient").toLowerCase()),
	 * oGlobalMap.get(("lastPolicyPurchaseDate") .toLowerCase()),
	 * oGlobalMap.get(("docId").toLowerCase()),
	 * oGlobalMap.get(("ProdCode").toLowerCase()),
	 * oGlobalMap.get(("Compocode").toLowerCase()),
	 * oGlobalMap.get(("sumassured").toLowerCase()),
	 * oGlobalMap.get(("isBasic").toLowerCase()),
	 * oGlobalMap.get(("platform").toLowerCase()),
	 * oGlobalMap.get(("transactionType").toLowerCase()),
	 * oGlobalMap.get(("version").toLowerCase()),
	 * oGlobalMap.get(("categoryList").toLowerCase()) }; sAPIResult =
	 * ComputeParam.compute(Param); logger.info(sAPIResult); if
	 * (sAPIResult.contains("~~")) { sStatus = sAPIResult.split("~~")[1]; } else
	 * { sStatus = "Fail"; } if (sOutput.equals("")) { sOutput =
	 * sAPIResult.split("~~")[0]; } else { sOutput = sOutput + " | " +
	 * sAPIResult.split("~~")[0]; } // Update response in actual result if
	 * (sAPIResult.split("~~").length == 3) { sAPIResponse =
	 * (sAPIResult.split("~~")[2]).replace("'", "''"); ; } } // if
	 * (sType.equalsIgnoreCase("csv")){ // sAPIResult =
	 * run.computeApiData(sSFStepKeyword); // }else{ // String[] Param = //
	 * {"2017827151218wlm"
	 * ,"TRUE","FALSE",oGlobalMap.get(("NRIC_FIN_No").toLowerCase()),"FALSE"};
	 * // sAPIResult = ComputeParam.compute(Param); // } break; }
	 * 
	 * BufferedWriter bw = null; FileWriter fw = null; String sExcelFilePath =
	 * ""; try { File file = new File(sFullScreenShotPath + "/" + sSFStepKeyword
	 * + ".txt"); if (file.createNewFile()) {
	 * System.out.println("File is created!"); } else {
	 * System.out.println("File already exists."); } String content =
	 * sAPIResponse; // "This is the content to write into file1"; fw = new
	 * FileWriter(sFullScreenShotPath + "/" + sSFStepKeyword + ".txt"); bw = new
	 * BufferedWriter(fw); bw.write(content); System.out.println("Done"); }
	 * catch (Exception e) { e.printStackTrace(); } finally { try { if (bw !=
	 * null) bw.close(); if (fw != null) fw.close(); } catch (IOException ex) {
	 * ex.printStackTrace(); }
	 * 
	 * }
	 * 
	 * if (sRCTestcaseID == null || sRCTestcaseID == "") { // Commented runid
	 * for pru String sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue, device"
	 * // ,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sPlanTestcaseId + "','" +
	 * sSFStepKeyword + "','" + sAPIResponse + "','" + sMobDeviceName // + "','"
	 * // + sFlowCode + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); } else { // Commented runid for pru
	 * String sSQLQuery =
	 * "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"
	 * // ,RunID + ") Values ('" + sPlanID + "','" + sReleaseID + "','" +
	 * sCycleID + "','" + sPlanTestcaseId + "','" + sRCTestcaseID + "','" +
	 * sSFStepKeyword + "','" + sAPIResponse + "','" + sMobDeviceName // + "','"
	 * // + sRCTCflowid + "')"; logger.info("sSQLQuery=" + sSQLQuery);
	 * oStmt.executeUpdate(sSQLQuery); }
	 * 
	 * } catch (Exception e) { if (sOutput.equals("")) { sOutput =
	 * e.getMessage().split("\\n")[0]; } else { sOutput = sOutput + " | " +
	 * e.getMessage().split("\\n")[0]; } // iReturnValue = 1;
	 * logger.error(e.getMessage()); } return iReturnValue; }
	 */

	/*
	 * public int callapi1shubh() { logger.info("Inside CallApi " +
	 * sSFStepKeyword + " is API Name"); iReturnValue = 0; try { String
	 * sAPIResult = ""; // NRIC_FIN_No String sAPIResponse = ""; // String[]
	 * Param; Runner run = new Runner();
	 * logger.info(sSFStepKeyword.toUpperCase()); switch
	 * (sSFStepKeyword.toUpperCase()) { case "COMPUTE": String[] Param = {
	 * oGlobalMap.get(("name").toLowerCase()),
	 * oGlobalMap.get(("DOB").toLowerCase()),
	 * oGlobalMap.get(("Age").toLowerCase()),
	 * oGlobalMap.get(("Gender").toLowerCase()),
	 * oGlobalMap.get(("Smoker").toLowerCase()),
	 * oGlobalMap.get(("ResidentStatus").toLowerCase()),
	 * oGlobalMap.get(("NumberOfLife").toLowerCase()),
	 * oGlobalMap.get(("ClientType").toLowerCase()),
	 * oGlobalMap.get(("SQSProdCode").toLowerCase()),
	 * oGlobalMap.get(("SQSisAgeRequire").toLowerCase()),
	 * oGlobalMap.get(("SQSisSmokerReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisResidentialStatusReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisOccupReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisGenderReq").toLowerCase()),
	 * oGlobalMap.get(("SQSisPaymentModeReq").toLowerCase()),
	 * oGlobalMap.get(("SQSPaymentMode").toLowerCase()),
	 * oGlobalMap.get(("SQSCompoCode").toLowerCase()),
	 * oGlobalMap.get(("SQSisBasic").toLowerCase()),
	 * oGlobalMap.get(("SQSlifeInsuredType").toLowerCase()),
	 * oGlobalMap.get(("SQSterm").toLowerCase()),
	 * oGlobalMap.get(("SQSbenefitTerm").toLowerCase()),
	 * oGlobalMap.get(("SQSPremiumTerm").toLowerCase()),
	 * oGlobalMap.get(("SQSPremium").toLowerCase()),
	 * oGlobalMap.get(("SQSSumAssured").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanOptCode").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanoptDesc").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanoptDataType").toLowerCase()),
	 * oGlobalMap.get(("CompoplanOptValue").toLowerCase()),
	 * oGlobalMap.get(("CompoPlanisOptValueEditable").toLowerCase()),
	 * oGlobalMap.get(("TermOptCode").toLowerCase()),
	 * oGlobalMap.get(("TermOptValue").toLowerCase()),
	 * oGlobalMap.get(("TermOptDesc").toLowerCase()),
	 * oGlobalMap.get(("ProdCode").toLowerCase()),
	 * oGlobalMap.get(("isAgeReq").toLowerCase()),
	 * oGlobalMap.get(("isSmokerReq").toLowerCase()),
	 * oGlobalMap.get(("isResidentialStatusReq").toLowerCase()),
	 * oGlobalMap.get(("isOccupReq").toLowerCase()),
	 * oGlobalMap.get(("isGenderReq").toLowerCase()),
	 * oGlobalMap.get(("isPaymentModeReq").toLowerCase()),
	 * oGlobalMap.get(("PaymentMode").toLowerCase()),
	 * oGlobalMap.get(("Compocode").toLowerCase()),
	 * oGlobalMap.get(("isBasic").toLowerCase()),
	 * oGlobalMap.get(("lifeInsuredType").toLowerCase()),
	 * oGlobalMap.get(("term").toLowerCase()),
	 * oGlobalMap.get(("benefitTerm").toLowerCase()),
	 * oGlobalMap.get(("premiumTerm").toLowerCase()),
	 * oGlobalMap.get(("premium").toLowerCase()),
	 * oGlobalMap.get(("sum assured").toLowerCase()),
	 * oGlobalMap.get(("optcode").toLowerCase()),
	 * oGlobalMap.get(("optDesc").toLowerCase()),
	 * oGlobalMap.get(("optDatatype").toLowerCase()),
	 * oGlobalMap.get(("optValue").toLowerCase()),
	 * oGlobalMap.get(("isOptValueEditable").toLowerCase()),
	 * oGlobalMap.get(("OptCode1").toLowerCase()),
	 * oGlobalMap.get(("OptValue1").toLowerCase()),
	 * oGlobalMap.get(("opTDesc1").toLowerCase()),
	 * oGlobalMap.get(("token_id").toLowerCase()) }; sAPIResult =
	 * ComputeParam.compute(Param); // Update response in actual result if
	 * (sAPIResult.split("~~").length == 3) { sAPIResponse =
	 * (sAPIResult.split("~~")[2]).replace("'","''"); } logger.info(sAPIResult);
	 * if (sAPIResult.contains("~~")) { sStatus = sAPIResult.split("~~")[1]; }
	 * else { sStatus = "Fail"; } if (sOutput.equals("")) { sOutput =
	 * sAPIResult.split("~~")[0]; } else { sOutput = sOutput + " | " +
	 * sAPIResult.split("~~")[0]; } break; case "CLIENTSEARCH":
	 * logger.info("nric number is " +
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase())); String[] Param1 = {
	 * oGlobalMap.get(("token_id").toLowerCase()), "true", "false",
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase()), "false" }; sAPIResult =
	 * ClientSearchParam.clientSearch(Param1); if (sAPIResult.split("~~").length
	 * == 3) { sAPIResponse = (sAPIResult.split("~~")[2]).replace("'", "''"); }
	 * logger.info(sAPIResult); if (sAPIResult.contains("~~")) { sStatus =
	 * sAPIResult.split("~~")[1]; } else { sStatus = "Fail"; } if
	 * (sOutput.equals("")) { sOutput = sAPIResult.split("~~")[0]; } else {
	 * sOutput = sOutput + " | " + sAPIResult.split("~~")[0]; } break; case
	 * "QUESTIONNAIRE": // sAPIResult =
	 * run.questionnaireApiData(sSFStepKeyword); // sAPIResult =
	 * run.clientSearchApiData(sSFStepKeyword); // String[] Param = //
	 * {oGlobalMap.get(("token_id").toLowerCase()),"true","false","","false"};
	 * String[] Param11 = { oGlobalMap.get(("token_id").toLowerCase()),
	 * oGlobalMap.get(("name").toLowerCase()),
	 * oGlobalMap.get(("NRIC_FIN_No").toLowerCase()),
	 * oGlobalMap.get(("DOB").toLowerCase()),
	 * oGlobalMap.get(("Age").toLowerCase()),
	 * oGlobalMap.get(("Gender").toLowerCase()),
	 * oGlobalMap.get(("ResidentStatus").toLowerCase()),
	 * oGlobalMap.get(("existingClient").toLowerCase()),
	 * oGlobalMap.get(("lastPolicyPurchaseDate") .toLowerCase()),
	 * oGlobalMap.get(("docId").toLowerCase()),
	 * oGlobalMap.get(("ProdCode").toLowerCase()),
	 * oGlobalMap.get(("Compocode").toLowerCase()),
	 * oGlobalMap.get(("sumassured").toLowerCase()),
	 * oGlobalMap.get(("isBasic").toLowerCase()),
	 * oGlobalMap.get(("platform").toLowerCase()),
	 * oGlobalMap.get(("transactionType").toLowerCase()),
	 * oGlobalMap.get(("version").toLowerCase()),
	 * oGlobalMap.get(("categoryList").toLowerCase()) }; sAPIResult =
	 * QuestionnaireParam.questionnaire(Param11); //
	 * ComputeParam.compute(Param); if (sAPIResult.split("~~").length == 3) {
	 * sAPIResponse = (sAPIResult.split("~~")[2]).replace("'", "''"); }
	 * logger.info(sAPIResult); if (sAPIResult.contains("~~")) { sStatus =
	 * sAPIResult.split("~~")[1]; } else { sStatus = "Fail"; } if
	 * (sOutput.equals("")) { sOutput = sAPIResult.split("~~")[0]; } else {
	 * sOutput = sOutput + " | " + sAPIResult.split("~~")[0]; } break; } } catch
	 * (Exception e) { if (sOutput.equals("")) { sOutput =
	 * e.getMessage().split("\\n")[0]; } else { sOutput = sOutput + " | " +
	 * e.getMessage().split("\\n")[0]; } // iReturnValue = 1;
	 * logger.error(e.getMessage()); } return iReturnValue; }
	 */

	public void updateexpecteddata(String TCID, String sFieldName,
			String sExpValue, String sTC, String sTCSer) {
		logger.info("Inside UpdateExpectedData");
		try {
			oStmt.executeUpdate("delete from QTP_ExpectedResult Where TestCaseId = '"
					+ TCID + "' and Field = '" + sFieldName + "'");
			oStmt.executeUpdate("insert into QTP_ExpectedResult (TestCaseID,Field,ExpectedValue,DataType) "
					+ " values ('"
					+ TCID
					+ "','"
					+ sFieldName
					+ "','"
					+ sExpValue + "','Auto')");
			Boolean coloumncheck = oGlobalMap.containsKey(sFieldName
					.toLowerCase());
			if (coloumncheck == true) {
				// Commented runid for pru
				String sSQLQuery = "update " + sTableName + " set "
						+ sFieldName + " = '" + sExpValue
						+ "' where planid = '" + sPlanID
						+ "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and test_case = '" + sTC
						+ "' and test_case_ser = '" + sTCSer + "'"; // and
				// flow_code
				// = '" +
				// sFlowCode+
				// "'";
				logger.info("sSQLQuery=" + sSQLQuery);
				oStmt.executeUpdate(sSQLQuery);
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				iRCTCTerminateInd = 1;
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public int dynamicwait() {
		int count = 0;
		logger.info("Inside  DynamicWait ");
		iReturnValue = 0;
		String sFlag = "";
		try {
			GetObj(sSFStepKeyword.split(":")[0]);
			WebDriverWait myDynamicElement_a = new WebDriverWait(oDriver,
					Integer.parseInt(sMaxDynamicWaitTime));
			WebDriverWait wait = new WebDriverWait(oDriver,
					Integer.parseInt(sMaxDynamicWaitTime));
			while (oTestObject == null) {
				Thread.sleep(1000);
				wait = new WebDriverWait(oDriver,
						Integer.parseInt(sMaxDynamicWaitTime));
				count = count + 1;
				if (Integer.parseInt(sMaxDynamicWaitTime) == count) {
					sFlag = "Fail";
					break;
				}
			}
			if (!(sFlag.equalsIgnoreCase("Fail"))) {
				switch ((sSFStepKeyword.split(":")[1]).toUpperCase()) {
				case "ELEMENTTOBECLICKABLE":
					// myDynamicElement_a.until(ExpectedConditions.elementToBeClickable(oTestObject));
					break;
				case "VISIBILITYOFELEMENTLOCATED":
					// wait.until(ExpectedConditions.visibilityOfElementLocated((By)
					// oTestObject));
					break;
				case "INVISIBILITYOFELEMENTLOCATED":

					break;
				}
			}

		} catch (Exception e) {
			try {
				if (e.getMessage().toLowerCase().contains(null)) {
					sOutput = "null pointer exception" + " | " + sOutput;
				} else {
					if (sOutput.equals("")) {
						sOutput = e.getMessage().split("\\n")[0];
					} else {
						sOutput = sOutput + " | " +"\n"
								+ e.getMessage().split("\\n")[0];
					}
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int scrollintoview() {
		logger.info("Inside scrollintoview");
		iReturnValue = 0;
		String temp = "";
		int leftX = 500;
		try {
			// sSFStepKeyword="planning_for_old_age_to_discuss_review:scrollintoview";
			// sSFStepKeyword="Claim_subsubcategory_search:SCROLLINTOVIEW";
			if (sMobDeviceName.equalsIgnoreCase("desktop")) {
				// GetObj(sSFStepKeyword.split(":")[0]);
				JavascriptExecutor jse = (JavascriptExecutor) oDriver;
				switch ((sSFStepKeyword.split(":")[1]).toUpperCase()) {
				case "SCROLLINTOVIEW":
					jse.executeScript("arguments[0].scrollIntoView();",
							oTestObject);
					break;
				}
			} else if (!sMobDeviceName.equalsIgnoreCase("desktop")) {
				System.out.println("");
				// GetObj(sSFStepKeyword.split(":")[0]);
				// JavascriptExecutor jse = (JavascriptExecutor) oDriver;
				switch ((sSFStepKeyword.split(":")[1]).toUpperCase()) {
				case "SCROLLINTOVIEW":

					oDriver_Mob.device().swipe("Down", 500, 3500);
					// oDriver_Mob.client.elementSwipe("Web",sSFStepKeyword, 0,
					// "Down", 0, 1000);
					System.out.println("after swipe");
					Thread.sleep(700);
					break;

				case "SCROLL":
					oDriver_Mob.device().swipe("Down", 900, 1000);
					Thread.sleep(700);
					break;

				case "SWIPE":
					oDriver_Mob.device().swipe("Down", 800, 1000);
				//Sushant Yadav : 29/08/2019 :To decrease execution time 
					Thread.sleep(700);
					break;
				case "SWIPELONG":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 200, 1000);
					Thread.sleep(700);
					break;	
				case "SWIPESHORT":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 500, 1000);
					Thread.sleep(700);
					break;
				case "SWIPESHORT300":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 300, 1000);
					Thread.sleep(700);
					break;
				case "SWIPESHORT400":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 400, 1000);
					Thread.sleep(700);
					break;
				case "SWIPESHORT600":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 600, 1000);
					Thread.sleep(700);
					break;
				case "SWIPESHORT700":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 700, 1000);
					Thread.sleep(700);
					break;
				case "SWIPESHORTS":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 900, 1000);
					Thread.sleep(700);
					break;
				case "SWIPEELEMENT":
					// Thread.sleep(1000);
					oDriver_Mob.findElement(By.xpath("//*[contains(text(),'Owner') and @onScreen='true']")).swipe("Up", 850, 1000);		
					Thread.sleep(700);
					break;
				case "SWIPEELEMENTS":
					// Thread.sleep(1000);
					oDriver_Mob.findElement(By.xpath("//*[@text='First Name' and @class='UILabel' and @top='true']")).swipe("Up", 500, 1000);
				
					Thread.sleep(700);
					break;
				case "RIGHT":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Right", 100, 100);
					 Thread.sleep(700);
					break;
				case "UP":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Up", 500, 3500);
					Thread.sleep(700);
					break;
				case "UP1":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Up", 800, 3500);
					Thread.sleep(700);
					break;

				case "PDF":
					// Thread.sleep(1000);
					oDriver_Mob.device().swipe("Down", 10, 10);
					Thread.sleep(700);
					break;
				case "ELEMENTSWIPE":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElement=oTestObject1;
					//Sushant Yadav : 04/09/2019 : Change into swip due to facing issue sometime
					////oDriver_Mob.findElement(By.xpath(""+sElement+"")).swipe("Up", 300, 100);
					oDriver_Mob.client.elementSwipe(UIName, ""+sElement+"", 0, "Up" , 300, 100);
					Thread.sleep(700);
					break;
					
				case "ELEMENTSWIPEDOWNSHORT":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElement11=oTestObject1;
//					oDriver_Mob.findElement(By.xpath("//*[@text='Date of Birth']")).swipe("Down", 300);
					oDriver_Mob.findElement(By.xpath(""+sElement11+"")).swipe("Down", 300, 100);
					Thread.sleep(700);
					break;
				
				case "ELEMENTSWIPEDOWN":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElemente=oTestObject1;
//					oDriver_Mob.findElement(By.xpath("//*[@text='Date of Birth']")).swipe("Down", 300);
					oDriver_Mob.findElement(By.xpath(""+sElemente+"")).swipe("Up", 300, 1000);
					Thread.sleep(700);
					break;
					
				case "ELEMENTSWIPELEFT":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementL1=oTestObject1;
//					oDriver_Mob.findElement(By.xpath("//*[@text='Date of Birth']")).swipe("Down", 300);
					oDriver_Mob.findElement(By.xpath(""+sElementL1+"")).swipe("Left", 800, 1000);
					Thread.sleep(700);
					break;
				//Sushant Yadav : 26-07-2019 : Scroll the particular element when expected element not found base on requirement
				case "ELEMENTSWIPEWHILENOTFOUND":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[3]);
					String sScrollElemt=oTestObject1;
					GetObj(sSFStepKeyword.split(":")[2]);
					String sExpectedElemt=oTestObject1;
					
					while(!(oDriver_Mob.client.isElementFound(UIName, oTestObject1,0))) {
						oDriver_Mob.client.elementSwipe(UIName, sScrollElemt, 0, sSFStepKeyword.split(":")[4], 300, 1000);
						Thread.sleep(700);
					}
					
					break;	
					
				case "SWIPEWHILENOTFOUND":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElement1=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 900, 1000, "NATIVE", ""+sElement1+"", 0, 1000, 5, true);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
					
				case "SWIPEWHILENOTFOUNDNOTCLICK":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementa1=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 900, 1000, "NATIVE", ""+sElementa1+"", 0, 1000, 5, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
				case "SWIPEWHILENOTFOUNDSHORT":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElement111=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 500, 1000, "NATIVE", ""+sElement111+"", 0, 1000, 10, true);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
				//Sushant Yadav : 22-06-2019 :Require to add  Short swip when object not found.	
				case "SWIPEWHILENOTFOUNDSHORTNOTCLICK":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementShortNA=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 500, 1000, "NATIVE", ""+sElementShortNA+"", 0, 1000, 10, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
					
				case "SWIPEWHILENOTFOUNDLONG":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementLong1=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 200, 1000, "NATIVE", ""+sElementLong1+"", 0, 1000, 5, true);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
				//Sushant Yadav : 22-06-2019 :Require to add  Short swip when object not found.	
				case "SWIPEWHILENOTFOUNDLONGNOTCLICK":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementLong2=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 200, 1000, "NATIVE", ""+sElementLong2+"", 0, 1000, 10, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
					
				case "SWIPEWHILENOTFOUNDUP":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementup=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Up", 500, 1000, "NATIVE", ""+sElementup+"", 0, 1000, 10, true);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
					
				case "SWIPEWHILEOBJECTNOTFOUND":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElement21=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Down", 200, 1000, "NATIVE", ""+sElement21+"", 0, 1000, 10, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
				//Sushant Yadav : 20-06-2019 : Scroll the Object file not found with shot swip Up in EApplication.
				case "SWIPEWHILEOBJECTNOTFOUNDUPNOTCLICK":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElement22=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Up", 200, 1000, "NATIVE", ""+sElement22+"", 0, 1000, 10, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
				//Sushant Yadav :25/07/2019 :Require to scroll right when object is not found
				case "SWIPEWHILENOTFOUNDNOTCLICKRIGHT":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementR=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Right", 800, 1000, "NATIVE", ""+sElementR+"", 0, 1000, 10, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;	
					//Sushant Yadav :25/07/2019 :Require to scroll right when object is not found
				case "SWIPEWHILENOTFOUNDNOTCLICKLEFT":
					// Thread.sleep(1000);
					GetObj(sSFStepKeyword.split(":")[2]);
					String sElementL=oTestObject1;
					oDriver_Mob.client.swipeWhileNotFound("Left", 800, 1000, "NATIVE", ""+sElementL+"", 0, 1000, 10, false);
//					oDriver_Mob.findElement(By.xpath(""+sElement1+"")).swipe("Up", 300, 100);
					Thread.sleep(700);
					break;
					
				case "MONTH":
					GetObj(sSFStepKeyword.split(":")[2]);
					String Str1=oTestObject1;
					GetObj(sSFStepKeyword.split(":")[3]);
					String Str2=oTestObject1;
					 if(oDriver_Mob.client.elementSwipeWhileNotFound("NATIVE", Str1, "Down", 500, 3500, "NATIVE", Str2, 0, 1000, 12, true)){
				            // If statement
				        }

					break;
					
				case "YEAR":
					GetObj(sSFStepKeyword.split(":")[2]);
				    Str1=oTestObject1;
					GetObj(sSFStepKeyword.split(":")[3]);
					Str2=oTestObject1;
				    if(oDriver_Mob.client.elementSwipeWhileNotFound("NATIVE",Str1 , "Up", 500, 3500, "NATIVE", Str2, 0, 1000, 20, true)){
				            // If statement
				       }


					break;
				case "ROW":
					String view = null;
					GetObj(sSFStepKeyword.split(":")[0]);
					if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
						if (sUIName.equalsIgnoreCase("Native")) {

							oDriver_Mob.useNativeIdentification();
							view = "NATIVE";
						} else {

							oDriver_Mob.useWebIdentification();
							view = "WEB";
						}
					}

					oDriver_Mob.client.elementScrollToTableRow(view,
							oTestObject1, 0, 0);
					break;

				}
			}

		} catch (Exception e) {
			try {
				sOutput = e.getMessage().split("\\n")[0] + " | " + sOutput;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int scrollTo() throws Exception {
		try {
			logger.info("Inside  scrollTo");
			String sVPId = "";
			String[] sObj = sSFStepKeyword.split(";;");

			for (int i = 0; i < sObj.length; i++) {
				try {
					oTestObject = oDriver.findElement(By.name(sObj[i]));
					int leftX = oTestObject.getLocation().getX();
					int leftY = oTestObject.getLocation().getY(); // int rightX
					// = leftX +
					oTestObject.getSize().getWidth();
					int rightX = leftX * leftX;
					// TouchAction act = new TouchAction((AndroidDriver)
					// oDriver);

					((AndroidDriver) oDriver).swipe(leftX, 0, leftX, 100, 1000);
				} catch (Exception e) {
					iReturnValue = 1;
					if (sOutput.equals("")) {
						sOutput = "Searching object not belong to Module";
					}
				}
			}

		} catch (Exception e) {
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}

		}
		return iReturnValue;
	}

	public int extractpdf() throws Exception {
		try {
			logger.info("Inside scrollTo");
			String sVPId = "";
			String[] sObj = sSFStepKeyword.split(";;");
			Thread.sleep(5000);
			for (int i = 0; i < sObj.length; i++) {
				try {
					GetObj(sObj[i]);
					sTestData = oGlobalMap.get(sObj[i].toLowerCase().trim());
					  String host = "outlook.office365.com"; //change accordingly
				      String mailStoreType = "smtp.office365.com";
				      String username = "latha.vk@qualitykiosk.com"; //change accordingly
				      String password = "Qlvk@028"; //change accordingly
				      Thread.sleep(2000);
				      check(host, mailStoreType, username, password);
				      logger.info("zip pwd: = "+sTestData);
				      //System.out.println("zip pwd: "+sTestData);
				      //SamExtraction function is used to extract zipfloder pdf with password 
				      SamExtraction(sTestData);
				     
				} catch (Exception e) {
					iReturnValue = 1;
					if (sOutput.equals("")) {
						sOutput = "Searching object not belong to Module";
					}
				}
			}

		} catch (Exception e) {
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}

		}
		return iReturnValue;
	}
	//comparepdf function is used to compare two pdfs
	/*public int comparepdf() throws Exception {
		try {
			logger.info("Inside   compare pdf");
				
					PDFUtil pdfUtil = new PDFUtil();
					ResultSet oRSQueryPS;
					String path = "";
					String sDPQry = "select value from parameter_setup where parameter = 'Pdf_Expected_Path'";
					logger.info("sQuery=" + sDPQry);
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					oRSQueryPS = oStmt.executeQuery(sDPQry);
					if (oRSQueryPS.next()) {
						path = oRSQueryPS.getString("value");
						System.out.println(path);
					}
					String stepkeyword=sSFStepKeyword;
					GetObj(stepkeyword);
					sTestData = oGlobalMap.get(stepkeyword.toLowerCase().trim());
					logger.info("sTestData:= "+sTestData);
					File[] listFiles = new File(path).listFiles();
				//	pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
					//Color colorCode=new Color(255-102-102);
					Color colorCode=Color.RED;
					ZPDFCompare obj = new ZPDFCompare();
					for (int i = 0; i < listFiles.length; i++) {

					    if (listFiles[i].isFile()) {
					        String fileName = listFiles[i].getName();
					        if (fileName.startsWith(sTestData)
					                && fileName.endsWith(".pdf")) {
					        	
					            System.out.println("found file" + " " + fileName);
					            if(fileName.contains("ENG_SI&PDS"))
					            {
					            	
					            	String file1=path+""+sTestData+"_ENG_SI&PDS.pdf";
					            	logger.info("Expected file name :"+file1);
					        		String file2=sFullScreenShotPath+"\\ENG_SI&PDS.pdf";
					        		logger.info("Actual file name :"+file2);
					        		obj.pdfcompare(file1,file2,sFullScreenShotPath+"\\"+sTestData+"_ENG_SI&PDS_Diff.pdf",sFullScreenShotPath+"\\ENG_SI&PDS_Diff.pdf");
					        		pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
					        		//Color colorCode=new Color(255-102-102);
					        		
					        	
					        		int c=pdfUtil.getPageCount(file1);
					        		logger.info("Number of pages in PDF : "+c);
					        		//pdfUtil.setImageDestinationPath("D:\\Latha\\New folder\\Comparepdf\\Expected_Files\\");
					        	
					        		//pdfUtil.savePdfAsImage(file2, 1, c);
					        		for(int j=0;j<=c;j++) {
					        		
					        			
					        			pdfUtil.compare(file1, file2, j, c);
					        			
					        		pdfUtil.highlightPdfDifference(true);
					        		pdfUtil.highlightPdfDifference(colorCode);
					        	
					        		pdfUtil.setImageDestinationPath(sFullScreenShotPath);
					        		logger.info("Comparing pdf page No: "+j);
					        		}
					            }
					            else  if(fileName.contains("BM_SI&PDS"))
					            {
					            	String file1=path+""+sTestData+"_BM_SI&PDS.pdf";
					            	logger.info("Expected file name :"+file1);
					        		String file2=sFullScreenShotPath+"\\BM_SI&PDS.pdf";
					        		logger.info("Actual file name :"+file2);
					        		obj.pdfcompare(file1,file2,sFullScreenShotPath+"\\sTestData"+"_BM_SI&PDS_Diff.pdf",sFullScreenShotPath+"\\BM_SI&PDS_Diff.pdf");
					        		//pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
					        		//Color colorCode=new Color(255-102-102);
					        		
					        	
					        		int c=pdfUtil.getPageCount(file1);
					        		logger.info("Number of pages in PDF : "+c);
					        		pdfUtil.setImageDestinationPath("D:\\Latha\\New folder\\Comparepdf\\Expected_Files\\");
					        	
					        		pdfUtil.savePdfAsImage(file2, 1, c);
					        		for(int j=0;j<=c;j++) {
					        		
					        			
					        			pdfUtil.compare(file1, file2, j, c);
					        			
					        		pdfUtil.highlightPdfDifference(true);
					        		pdfUtil.highlightPdfDifference(colorCode);
					        	
					        		pdfUtil.setImageDestinationPath(sFullScreenShotPath);
					        		logger.info("Comparing pdf page No: "+j);
					        		}
					            }
					            else if(fileName.contains("CHI_SI&PDS"))
					            {
					            	String file1=path+""+sTestData+"_CHI_SI&PDS.pdf";
					            	logger.info("Expected file name :"+file1);
					        		String file2=sFullScreenShotPath+"\\CHI_SI&PDS.pdf";
					        		obj.pdfcompare(file1,file2,sFullScreenShotPath+"\\sTestData"+"_CHI_SI&PDS_Diff.pdf",sFullScreenShotPath+"\\CHI_SI&PDS_Diff.pdf");
					        		
					        	//	pdfUtil.setCompareMode(CompareMode.VISUAL_MODE);
					        		logger.info("Actual file name :"+file2);
					        		//Color colorCode=new Color(255-102-102);
					        		
					        	
					        		int c=pdfUtil.getPageCount(file1);
					        		logger.info("Number of pages in PDF : "+c);
					        		pdfUtil.setImageDestinationPath("D:\\Latha\\New folder\\Comparepdf\\Expected_Files\\");
					        	
					        		pdfUtil.savePdfAsImage(file2, 1, c);
					        		for(int j=0;j<=c;j++) {
					        		
					        			
					        			pdfUtil.compare(file1, file2, j, c);
					        			
					        		pdfUtil.highlightPdfDifference(true);
					        		pdfUtil.highlightPdfDifference(colorCode);
					        	
					        		pdfUtil.setImageDestinationPath(sFullScreenShotPath);
					        		logger.info("Comparing pdf page No: "+j);
					        		}
					            }
					        }
					
					    }
					}		
		} catch (Exception e) {
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}

		}
		return iReturnValue;
	}*/
	
	public static void SamExtraction(String Pwd) {

	    final FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("N/A", "zip");
	        //Folder where zip file is present
	        final File file = new File(sFullScreenShotPath);
	        for (final File child : file.listFiles()) {
	            try {
	                ZipFile zipFile = new ZipFile(child);
	                if (extensionFilter.accept(child)) {
	                    if (zipFile.isEncrypted()) {
	                        //Your ZIP password
	                        zipFile.setPassword(Pwd);
	                    }
	                    List fileHeaderList = zipFile.getFileHeaders();

	                    for (int i = 0; i < fileHeaderList.size(); i++) {
	                        FileHeader fileHeader = (FileHeader) fileHeaderList.get(i);
	                        //Path where you want to Extract
	                        zipFile.extractFile(fileHeader,sFullScreenShotPath);
	                        System.out.println("Extracted");
	                    }
	                    logger.info("PDF Extracted");
	                }
	            } catch (Exception e) {
	                System.out.println("Please Try Again");
	            }
	        }

	    }
	
	final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	   @SuppressWarnings("unlikely-arg-type")
	public static void check(String host, String storeType, String user,String password) 
	{

		      try {

		      //create properties field
		      Properties properties = new Properties();
		      Session session = Session.getDefaultInstance(System.getProperties(), null);
		      Store store = session.getStore("pop3s");
		      store.connect(host, user, password);
		      //create the folder object and open it
		      Folder emailFolder = store.getFolder("Inbox");
		      emailFolder.open(Folder.READ_ONLY);
		      int sCount = + emailFolder.getUnreadMessageCount();
		      System.out.println("No of Unread Messages : " +sCount );
	          Message messages[] = emailFolder.search(new FlagTerm(new Flags(Flag.SEEN), false));

		      int o=sCount;
		      for (int i = 0, n = messages.length; i < n; i++) {
		    	  o=o-1;
		    	  System.out.println("" +o);
		    	  Message message = messages[o];
		    	  String filename = "";
		    	  try{
		    	  Multipart mp = (Multipart) message.getContent();
		    	  int parts = mp.getCount();
		    	  System.out.println("getcount : " + parts);
		          BodyPart bp = mp.getBodyPart(0);
		          System.out.println("Email Number " + (i + 1));
		          System.out.println("SENT DATE:" + message.getSentDate());
		          System.out.println("From: " + message.getFrom()[0]);
		        String s=message.getFrom()[0].toString();
		        System.out.println("s = "+s);
		          System.out.println("SUBJECT:" + message.getSubject());
		          Object content = message.getContent();
		          String emailbody = "";
		          if(message.getSubject().contains("[Not Virus Scanned]")&& s.contains("Quality Kiosk")){
		             
		            
		          if (content instanceof java.lang.String){
		        	 emailbody = (String)content;
		          }else if (content instanceof Multipart) {
		        	  Multipart mm = (Multipart)content;
		        	  for (int j = 0; j < mm.getCount(); j++) {

		        	      Part part = mm.getBodyPart(j);
		        	      String disposition = part.getDisposition();
		        	      String fileName = part.getFileName();
		        	      String decodedAttachmentName = null;
		        	      String folderPath = sFullScreenShotPath;
		        	      if (fileName!=null) {
		        	    	  logger.info("Attached File Name :: " + fileName);
		        	  		decodedAttachmentName = MimeUtility.decodeText(fileName);
		        	  		logger.info("Decoded string :: " + decodedAttachmentName);
		        	  		decodedAttachmentName = Normalizer.normalize(decodedAttachmentName, Normalizer.Form.NFC);
		        	  		logger.info("Normalized string :: " + decodedAttachmentName);
		        	  		int extensionIndex = decodedAttachmentName.indexOf(1);
		        	  		extensionIndex = extensionIndex == -1 ? decodedAttachmentName.length() : extensionIndex;
		        	  		File parentFile = new File(folderPath);
		        	  		logger.info("Updating file name if any file with the same name exists. File : " + decodedAttachmentName);


		        	  		logger.info("Updated file name : " + decodedAttachmentName);
		        	  	
		        	  	}
		        	  	if (disposition != null && disposition.equalsIgnoreCase(Part.ATTACHMENT)) {
		        	  		File file = new File(folderPath + File.separator + decodedAttachmentName);
		        	  		file.getParentFile().mkdirs();
		        	  	}
		        	      if (disposition == null) {

		        	       MimeBodyPart mbp = (MimeBodyPart) part;
		        	       if (mbp.isMimeType("text/plain")) {
		        	        // Plain
		        	        emailbody += (String) mbp.getContent();
		        	       } 

		        	      } else if ((disposition != null) && (disposition.equals(Part.ATTACHMENT) || disposition .equals(Part.INLINE))) {

		     
		        	       MimeBodyPart mbp = (MimeBodyPart) part;
		        	       if (mbp.isMimeType("text/plain")) {
		        	        emailbody += (String) mbp.getContent();
		        	       } else {
		        	    	   System.out.println("dsa");
		        	    	   MimeBodyPart partw = (MimeBodyPart) mm.getBodyPart(j);

		        	    	   	String fileName1 = part.getFileName();
		        	    	   	logger.info(File.separator);
		   						((MimeBodyPart) part).saveFile(folderPath + File.separator + fileName1);
		        	    	   
		        	       }

		        	       }
		        	      }
					
		          }
		          break;
		          }
		    	  }catch(Exception ee){
		    		  System.out.println(ee.getMessage());
		    	  }
       
		          System.out.println("---------------------------------");

		      }

		      
		      emailFolder.close(false);
		      store.close();

		      } catch (NoSuchProviderException e) {
		         e.printStackTrace();
		      } catch (MessagingException e) {
		         e.printStackTrace();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   
	}
	   
	   //Sushant Yadav : 19-06-2019 : ePaymnet dedit card flow issue unable to inset directly ATMPIN so we create function which devide ATM pin in character and click on number base on character
	   public void atm_pin() {
		   String pinNumber = "";
		   UIName = "WEB";
		   pinNumber = oGlobalMap.get("atmpinno");
		   	int Length=pinNumber.length();
		   	System.out.println(Length);

		   	for(int i=0;i<Length;i++) {
		   		int EnterAtmPinNumber;
		   		char Num =pinNumber.charAt(i);
		   		System.out.println("Number " +i + " = " + Num);
		   		oTestObject1="xpath=//*[@value='"+Num+"']";
		   		System.out.println("xpath=//*[@value='"+Num+"']");
		   		oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
		   	}
		   }
	   
	   //Sushant Yadav : 19-06-2019 :Create function to read OTP with help of VBS also pass parameter to run VBS and wait till VBS run completely
	   public void otpread() {
		   logger.info("Inside ePayment OTP Read function");
			iReturnValue = 0;
		   try
		   {
			   String sServer="",sDBUserID="",sDBPW="",sDBInstance="",sOTPEmailID="",sOTPEmailSub="",ssPath="";
			  
			   ssPath = sScriptPath + "\\ReadMail.vbs ";
			   sOTPEmailID = oGlobalMap.get("otp_emailid");
			   sOTPEmailSub = oGlobalMap.get("otpemailsub");
			   if(sOTPEmailID.contains("aia.com"))
			   {
			   sOTPEmailSub = sOTPEmailSub.replace(" ", "__");	
			   
			   String[] oSonnectionString = sconnectionString1.split(":");
			   sServer = oSonnectionString[0].split("=")[1];
				sDBUserID=oSonnectionString[2].split("=")[1];
				sDBPW=oSonnectionString[3].split("=")[1];
				sDBInstance=oSonnectionString[4].split("=")[1];
				
				   Date sEmailTime = new Date();
					Date oDateTemp = new Date(sEmailTime.getTime());
					SimpleDateFormat oDF = new SimpleDateFormat("hh.mm aa");
					
					sOTPEmailDate = new SimpleDateFormat("dd-MM-yyyy").format(sEmailTime);
					sOTPEmailTime=oDF.format(oDateTemp);
					
				
				 logger.info("Read OTP Vbs Command :" + "wscript "+ ssPath + sPlanID +" "+ sReleaseID +" "+sCycleID +" "+sPlanTestcaseId +" "+sServer +" "+sDBUserID+" "+ sDBPW +" "+sDBInstance + " "+sOTPEmailID + " " +sOTPEmailSub +" " + sOTPEmailDate + " " + sOTPEmailTime);
				 Runtime.getRuntime().exec("wscript "+ ssPath + sPlanID +" "+ sReleaseID +" "+sCycleID +" "+sPlanTestcaseId +" "+sServer +" "+sDBUserID+" "+ sDBPW +" "+sDBInstance + " "+sOTPEmailID + " " +sOTPEmailSub +" " + sOTPEmailDate + " " + sOTPEmailTime);
				 Thread.sleep(20000);
			   }
		   }catch(Exception e ) {
			   try {
				     iReturnValue = 1;
					if (sOutput.equals("")) {
						sOutput = e.getMessage().split("\\n")[0];
					} else {
						sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
					}
					logger.error(e.getMessage());
				   } catch (Exception e1) {

				   }
	       }
		   }   
	   //Sushant Yadav : Create the function to raise mail for BVT
	   public void BVT() {
		   logger.info("Inside BVT raise mail");
			iReturnValue = 0;
		   try
		   {
			   String sServer="",sDBUserID="",sDBPW="",sDBInstance="",ssPath="";
			   String sProductCode = "",sPlanEnv="",sChannel="",sExcelFile="",sExcelFilePath="",sEmailDate="",sEmailSentTime="";
			   //Run PC Mapping 
			   if(sTestType.contains("BVT"))
			   {
			   connect();
			   //Query to findout the product code 
			   oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sQuery = "select * from qath_testplan_scope where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "'";
				
				logger.info(sQuery);
				
				ResultSet oRSQuery = oStmt
						.executeQuery(sQuery);
				if (oRSQuery.next()) {
					sProductCode = oRSQuery.getString("planproductcode");
				}
				logger.info("Product Code ="+sProductCode);
				if(!sProductCode.isEmpty())
				{
					//Query for find out Channel of BVT
					oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sQuery1 = "select * from qath_testplan_scheduler where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "' and plancycleid = '"
							+ sCycleID
							+ "'";
					
					logger.info(sQuery1);
					
					ResultSet oRSQuery1 = oStmt
							.executeQuery(sQuery1);
					if (oRSQuery1.next()) {
						sPlanEnv = oRSQuery1.getString("planenvname");
					}	
					
					logger.info("Environment Type =" + sPlanEnv);
					String sPalnEnv1[]=sPlanEnv.split("-"); 
					if(sPalnEnv1[2].contains(" "))
					{
					 sChannel = sPalnEnv1[2].split(" ")[2];
					}else{
						sChannel = sPalnEnv1[2];	
					}
	                
					//Query for findout the excel file which want to run.
					oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sQuery2 = "Select * from qath_premium_calc_master where product_code='"
							+ sProductCode
							+ "' and excel_file like '%"
							+ sChannel
							+ "%'";
					
					logger.info(sQuery2);
					
					ResultSet oRSQuery2 = oStmt
							.executeQuery(sQuery2);
					if (oRSQuery2.next()) {
						sExcelFile = oRSQuery2.getString("excel_file");
					}	
					
					logger.info("Wrapper file Name=" + sExcelFile);
					//Query on parameter_setup to findout the Excel Path  
					oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sQuery3 = "Select * from parameter_setup where parameter ='Excel_Path'";
					
					logger.info(sQuery3);
					
					ResultSet oRSQuery3 = oStmt
							.executeQuery(sQuery3);
					if (oRSQuery3.next()) {
						sExcelFilePath = oRSQuery3.getString("value");
					}	
					
					logger.info("PC Mapping File Path=" + sExcelFilePath);
					//Update the Wrapper file base on product code and excel file name

		               File file = new File(sExcelFilePath.concat("\\" + sExcelFile.trim()));
		              /* HSSFWorkbook workbook = new HSSFWorkbook(file);
		                HSSFSheet sheet = workbook.getSheet(sheet_name);*/
		               HSSFWorkbook workbook = null;
		               InputStream ExcelFileToRead = new FileInputStream(sExcelFilePath.concat("\\" + sExcelFile.trim()));
		       		   HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		       		   HSSFSheet sheet=wb.getSheetAt(0);
		       		   
		                Cell cell = null;
		                      
		                cell = sheet.getRow(20).getCell(5);
		                cell.setCellValue(sPlanID);
		                      
		                cell = sheet.getRow(22).getCell(5);
		                cell.setCellValue(sReleaseID);
		                      
		                cell = sheet.getRow(24).getCell(5);
		                cell.setCellValue(sCycleID);
		                    
		                cell = sheet.getRow(26).getCell(5);
		                cell.setCellValue(sProductCode);
		                    
		                ExcelFileToRead.close();
		                    
		                FileOutputStream outFile = new FileOutputStream(new File(sExcelFilePath.concat("\\" + sExcelFile.trim())));
		                wb.write(outFile);
		                outFile.close();
		                      
		                int lastPeriodPos = sExcelFile.lastIndexOf('.');
		                String vbs_name = sExcelFile.substring(0, lastPeriodPos) + ".vbs";
		                    
		                File vbs_file = new File(sExcelFilePath.concat("\\vbs\\" + vbs_name));
		                      
		                if (vbs_file != null && vbs_file.isFile()) {
		                    // write query to update status flag for the PRC
		                    updateStatusFlag(sPlanID, sReleaseID, sCycleID);
		                        
		                    String VbsPath="";
		                    VbsPath = sExcelFilePath.concat("\\" + "vbs" + "\\" + vbs_name)+ "\"";
		                    // execute the .vbs file
		                   // Runtime.getRuntime().exec("cmd.exe /k cscript \"" + sExcelFilePath.concat("\\" + "vbs" + "\\" + vbs_name) + "\"");
		                    Runtime.getRuntime().exec("wscript \""+ VbsPath);  
		                    int check_counter = 0;
		                    String complete_flag = "";
		                        
		                    // check for completion status
		                    while (true) {
		                        Thread.sleep(10000);
		                        check_counter++;
		                        
		                        // write query to fetch status flag for the PRC                        
		                        complete_flag = getStatusFlag(sPlanID, sReleaseID, sCycleID);
		                            
		                        if ("true".equalsIgnoreCase(complete_flag)) {
		                                break;
		            
		                        }
		            
		                        if (check_counter >= (30 * 2)) {
		                            try {
		                                Runtime.getRuntime().exec("taskkill /f /t /IM EXCEL.EXE");
		                                Thread.sleep(1000);
		                            
		                            } catch (Exception ex) {
		                                
		                            }
		            
		                        }
		            
		                    }
		                        
		                } 
		                
		            
					
					
				}
				
			   }
			   //Run the VBS directly to initiate mail by VBScript
			   if(sTestType.contains("BVT"))
			   {
			   ssPath = sScriptPath + "\\CreateMail.vbs ";
			   String[] oSonnectionString = sconnectionString1.split(":");
			   sServer = oSonnectionString[0].split("=")[1];
				sDBUserID=oSonnectionString[2].split("=")[1];
				sDBPW=oSonnectionString[3].split("=")[1];
				sDBInstance=oSonnectionString[4].split("=")[1];
				
				//BVT Run Date and Time
				Date sEmailTime11 = new Date();
				Date oDateTemp11 = new Date(sEmailTime11.getTime());
				SimpleDateFormat oDF11 = new SimpleDateFormat("hh.mm aa");
				sEmailDate = new SimpleDateFormat("dd-MM-yyyy").format(sEmailTime11);
				sEmailSentTime=oDF11.format(oDateTemp11);
				
				
				 logger.info("Read OTP Vbs Command :" + "wscript "+ ssPath + sPlanID +" "+ sReleaseID +" "+sCycleID +" "+sServer +" "+sDBUserID+" "+ sDBPW +" "+ sDBInstance + " " + sEmailDate + " " + sProductCode + " " +sChannel + " " + sTestType);
				 Runtime.getRuntime().exec("wscript "+ ssPath + sPlanID +" "+ sReleaseID +" "+sCycleID +" "+sServer +" "+sDBUserID+" "+ sDBPW +" "+sDBInstance+ " " + sEmailDate + " " + sProductCode + " " +sChannel + " " + sTestType);
				 Thread.sleep(2000);
			   }
		   }catch(Exception e ) {
			   try {
				     iReturnValue = 1;
					if (sOutput.equals("")) {
						sOutput = e.getMessage().split("\\n")[0];
					} else {
						sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
					}
					logger.error(e.getMessage());
				   } catch (Exception e1) {

				   }
	       }
		   }    
	   
	//Sushant Yadav : 03/07/2019 : Function wait till PC Mapping result updated
	   public void updateStatusFlag(String planid, String releaseid, String cycleid) {
	        
	        ResultSet rs = null;
	        String query = "";
	        
	        try {
	            connect();
	            oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            
	            query = "select * from qath_flags where planid='" + planid + "' and planreleaseid='" + releaseid + "' " + "and plancycleid='" + cycleid + "'";
	            rs = oStmt.executeQuery(query);
	            
	            if (rs.next()) {
	                System.out.println("PRC entry found in flag table. updating now...");
	                String uquery = "update qath_flags set flag='False' where planid='" + planid + "' and planreleaseid='" + releaseid + "' " + "and plancycleid='" + cycleid + "'";
	                int rows = oStmt.executeUpdate(uquery);
	                
	            } else {
	                System.out.println("PRC entry not found in flag table. adding new entry...");
	                
	                String iquery = "insert into qath_flags (planid, planreleaseid, plancycleid, flag) values ('" + planid + "', '" + releaseid +  "', '"  + cycleid + "', 'False')";
	                int rows = oStmt.executeUpdate(iquery);
	                
	            }
	            
	        } catch (SQLException se) {
	            logger.info("SQL Exception from MappingDAO -> updateStatusFlag: " + se);
	                
	        } catch (Exception e) {
	        	logger.info("Exception from MappingDAO -> updateStatusFlag: " + e);
	                
	        } finally {
	            try {
	                if (oStmt != null)
	                	oStmt.close();
	            
	            } catch (Exception e) {
	            
	            }
	            
	        }
	        
	    }

//Sushant Yadav : 03/07/2019 : Function wait till status of PC mapping updated
	   
	   public String getStatusFlag(String planid, String releaseid, String cycleid) {
	       
	        Statement stmt = null;
	        ResultSet rs = null;
	        String query = "";
	        
	        try {
	            connect();
	            oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            
	            query = "select flag from qath_flags where planid='" + planid + "' and planreleaseid='" + releaseid + "' " + "and plancycleid='" + cycleid + "'";
	            rs = oStmt.executeQuery(query);
	            
	            while (rs.next()) {
	                flag = rs.getString("flag");
	                
	            }
	            
	        } catch (SQLException se) {
	            logger.info("SQL Exception from MappingDAO -> getStatusFlag: " + se);
	                
	        } catch (Exception e) {
	        	logger.info("Exception from MappingDAO -> getStatusFlag: " + e);
	                
	        } finally {
	            try {
	                if (stmt != null)
	                    stmt.close();
	            
	            } catch (SQLException se) {
	            
	            }
	            
	        }
	        
	        return flag;
	        
	    } 
  
	public int screens() throws InterruptedException {
		//sScreenFlag ="yes";
		logger.info("Inside screens");
		iReturnValue = 0;
		try {
			if(sScreenFlag.toLowerCase().equalsIgnoreCase("critical") || sScreenFlag.toLowerCase().equalsIgnoreCase("")){
				if(sSFStepKeyword.contains("~critical")){
					sScrenCnt = String.format("%05d", iScreenNum);
		            System.out.println(sScrenCnt);
					if (sSFStepKeyword.contains(":")) {
						String spilt[] = sSFStepKeyword.split(":");
						sSFStepKeyword = spilt[0];
					}
					String sPath = "";
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
//						if (sSFStepKeyword != null && !sSFStepKeyword.equals("")) {
//							sPath = sFullScreenShotPath + "/" + sSFStepKeyword + "_";
//						} else {
//							sPath = sFullScreenShotPath + "/";
//						}
						if(sSFStepKeyword.contains("~critical")){
							sPath = sFullScreenShotPath + "/";
						}else{
						    sPath = sFullScreenShotPath + "/" + sSFStepKeyword + "_";
						}
//						if (!(sAutomationFunction.toLowerCase().contains("flow"))) {
						sPath = sPath + sScrenCnt + "_"+ sPlanTestcaseId + "_" + sSFStepId + ".png";
//						} else {
//							sPath = sPath + sPlanTestcaseId + "_" + sFlowCode + "_" + sSFStepId + "_" + iScreenNum + ".png";
//						}
					} else {
						if (sSFStepKeyword != null && !sSFStepKeyword.equals("") && !sSFStepKeyword.contains("~critical")) {
							if(sSFStepKeyword.contains("~critical")){
								sPath = sFullScreenShotPath + "/" + sScrenCnt + "_";
							}else{
							    sPath = sFullScreenShotPath + "/"+ sScrenCnt + "_" + sSFStepKeyword + "_";
							}
						} else {
							sPath = sFullScreenShotPath + "/";
						}
						sPath = sPath + sPlanTestcaseId + "_" + sRCTestcaseID + "_" + sSFStepId + ".png";
					}
					logger.info("sPath = " + sPath);
					try {
						String sAlertActualText;
//						if(oDriver != null){
						sAlertActualText = oDriver.switchTo().alert().getText();
//						}
						Robot oRobot = new Robot();
						BufferedImage oImg = oRobot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
						File oSavePath = new File(sPath);
						ImageIO.write(oImg, "png", oSavePath);
					} catch (Exception e) {
						if (oDriver !=null| oDriver_Mob != null ) {
							String Output = e.getMessage();
							File screenshot= null;
							if(oDriver_Mob != null){
								screenshot = ((TakesScreenshot)oDriver_Mob).getScreenshotAs(OutputType.FILE);
							}else{
								screenshot = ((TakesScreenshot)oDriver).getScreenshotAs(OutputType.FILE);
							}
							System.out.println("screen text "+screenshot); 
							FileUtils.copyFile(screenshot, new File(sPath));
						}
					}
					
				
			}else if(sScreenFlag.toLowerCase().equalsIgnoreCase("")){
				sScrenCnt = String.format("%05d", iScreenNum);
	            System.out.println(sScrenCnt);
					if (sSFStepKeyword.contains(":")) {
						String spilt[] = sSFStepKeyword.split(":");
						sSFStepKeyword = spilt[0];
					}
					String sPath = "";
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
//						if (sSFStepKeyword != null && !sSFStepKeyword.equals("")) {
//							sPath = sFullScreenShotPath + "/" + sSFStepKeyword + "_";
//						} else {
//							sPath = sFullScreenShotPath + "/";
//						}
						if (sSFStepKeyword != null && !sSFStepKeyword.equals("")) {
							sPath = sFullScreenShotPath + "/" +sScrenCnt + "_"+ sSFStepKeyword + "_";
						} else {
							sPath = sFullScreenShotPath + "/" +sScrenCnt + "_";
						}
//						if (!(sAutomationFunction.toLowerCase().contains("flow"))) {
//						sPath = sPath + sScrenCnt + "_" + sPlanTestcaseId + "_" + sSFStepId + ".png";
						sPath = sPath + sSFStepId + ".png";
//						} else {
//							sPath = sPath + sPlanTestcaseId + "_" + sFlowCode + "_" + sSFStepId + "_" + iScreenNum + ".png";
//						}
					} else {
						if (sSFStepKeyword != null && !sSFStepKeyword.equals("")) {
							sPath = sFullScreenShotPath + "/" + sSFStepKeyword + "_";
						} else {
							sPath = sFullScreenShotPath + "/";
						}
						
						sPath = sPath + sScrenCnt + "_" + sPlanTestcaseId + "_" + sRCTestcaseID + "_" + sSFStepId +".png";
					}
					logger.info("sPath = " + sPath);
					try {
						String sAlertActualText = oDriver.switchTo().alert().getText();
						Robot oRobot = new Robot();
						BufferedImage oImg = oRobot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
						File oSavePath = new File(sPath);
						ImageIO.write(oImg, "png", oSavePath);
					} catch (Exception e) {
						if (oDriver != null || oDriver_Mob != null ) {
							String Output = e.getMessage();
							File screenshot= null;
							if(oDriver_Mob != null){
								screenshot = ((TakesScreenshot) oDriver_Mob).getScreenshotAs(OutputType.FILE);
							}else{
								screenshot = ((TakesScreenshot) oDriver).getScreenshotAs(OutputType.FILE);
							}
							System.out.println("screen text "+screenshot); 
							FileUtils.copyFile(screenshot, new File(sPath));
							sCopyFilePATH = sPath;
							
							System.out.println("Copy File path = " +sCopyFilePATH);
						}
					}
					//iScreenNum = iScreenNum + 1;
			}
				iScreenNum = iScreenNum + 1;
				}
		} catch (Exception e) {
			iReturnValue = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
			}
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	
	public static void copyfile() throws IOException {
		InputStream is = null;
	    OutputStream os = null;
		try {
	        is = new FileInputStream("E:\\Swapnil\\DeskApp\\9March19-Downloads\\Dollar Protect Plus Vitality_11-03-2019.pdf");
	        os = new FileOutputStream(sCopyFilePATH +"\\Dollar Protect Plus Vitality_11-03-2019.pdf");
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }

	}
	
	
	
	public int CaptureScreenshotOld() {
		logger.info("Inside CaptureScreenshot");
		iReturnValue = 0;
		try {
			// Thread.sleep(2000);
			String sPath = "";
			if (sRCTestcaseID == null || sRCTestcaseID == "") {
				// Modified by Seema 27Jun17 for flow id
				sPath = sFullScreenShotPath + "/" + sPlanTestcaseId + "_"
						+ sSFStepId + "_" + sFlowCode + "_" + iScreenNum
						+ ".png";
				// sPath = sFullScreenShotPath +"/" + sPlanTestcaseId + "_" +
				// sSFStepId + "_" + iScreenNum + ".png";
				System.out.println(sPath);
				System.out.println("sFullScreenShotPath : "
						+ sFullScreenShotPath);
			} else {
				// sFullScreenShotPath +"/"+ sPlanTestcaseId + "_" +
				// sRCTestcaseID + "_" + sSFStepId + "_" + iScreenNum + ".jpg";
				// sPath = sFullScreenShotPath +"/" + sRCTestcaseID + "_" +
				// sSFStepId + "_" + iScreenNum + ".png";
				// Modified by Seema 1st Apr17 : To fetch exact planstatus for
				// end to end resume from failed step feature
				sPath = sFullScreenShotPath + "/" + sRCTestcaseID + "_"
						+ sSFStepId + "_" + sRCTCRunid + "_" + iScreenNum
						+ ".png";
			}
			logger.info("sPath = " + sPath);
			try {
				String sAlertActualText = oDriver.switchTo().alert().getText();
				Robot oRobot = new Robot();
				// oRobot.keyPress(KeyEvent.
				BufferedImage oImg = oRobot.createScreenCapture(new Rectangle(
						Toolkit.getDefaultToolkit().getScreenSize()));
				File oSavePath = new File(sPath);
				ImageIO.write(oImg, "png", oSavePath);
				// File screenshot =
				// ((TakesScreenshot)oDriver).getScreenshotAs(OutputType.FILE);
				// FileUtils.copyFile(screenshot, new File(sPath));
			} catch (Exception e) {
				String Output = e.getMessage();
				File screenshot = ((TakesScreenshot) oDriver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File(sPath));
				// if(Output.contains("unexpected alert"))
				// {
				// logger.info("Alert exist on screen");
				// Robot oRobot = new Robot();
				// // oRobot.keyPress(KeyEvent.
				// BufferedImage oImg = oRobot.createScreenCapture(new
				// Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
				// File oSavePath = new File(sPath);
				// ImageIO.write(oImg, "png", oSavePath);
				//
				// }
			}
			// try{
			// oDriver.switchTo().alert();
			// }
			// catch(NoAlertPresentException e){
			// File screenshot =
			// ((TakesScreenshot)oDriver).getScreenshotAs(OutputType.FILE);
			// FileUtils.copyFile(screenshot, new File(sPath));
			// return iReturnValue;
			// }
			// Robot oRobot = new Robot();
			// BufferedImage oImg = oRobot.createScreenCapture(new
			// Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			// File oSavePath = new File(sPath);
			// ImageIO.write(oImg, "JPG", oSavePath);
			iScreenNum = iScreenNum + 1;
		} catch (Exception e) {
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public void UpdateResult() throws IOException {
//		copyfile();
		logger.info("Inside UpdateResult");
		String sOutput1 = "", sVPFlag = "";
		try {
			logger.info("sSTPStatus : " + sSTPStatus + "_ sMultiFlag : "
					+ sMultiFlag);
			if (!(sExitStatus.equals(""))) {
				sStatus = "Fail";
			}
			// if(!(sSTPStatus.equalsIgnoreCase("pass"))){
			if (!(sMultiFlag.equalsIgnoreCase("Yes"))) {
				logger.info("status : " + sStatus + " : output " + sOutput);
				sExitSFFlag = "";
				sExitStatus = "";
				if (iRCInd != 1) {
					String iCompareCount = "0";
					String iIllCount = "0";
					String iPropCnt = "0";
					String iPDCnt = "0";
					if (sOutput.toLowerCase().contains("(session info")) {
						sOutput = sOutput.split("\\(Session info")[0].trim();
						System.out.println(sOutput);
					}
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					logger.info("sQuery="
							+ "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
							+ sPlanID + "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Module = '" + sModule
							+ "' and SubModule = '" + sSubModule
							+ "' and TestCaseID = '" + sPlanTestcaseId
							+ "' and device = '" + sMobDeviceName
							+ "' and testtype = '" + sTestType
							+ "' and  CompareResult = 'Fail'");
					ResultSet oRSQuery1 = oStmt
							.executeQuery("select count(*) As Col from dbo.QTP_CompareResult where planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' and Module = '"
									+ sModule
									+ "' and SubModule = '"
									+ sSubModule
									+ "' and TestCaseID = '"
									+ sPlanTestcaseId
									+ "' and device = '"
									+ sMobDeviceName
									+ "' and testtype = '"
									+ sTestType
									+ "' and  CompareResult = 'Fail'");
					if (oRSQuery1.first()) {
						iCompareCount = oRSQuery1.getString("Col");
					}
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					logger.info("sQuery="
							+ "select count(*) As Col from dbo.benefit_illustration_pdf where planid = '"
							+ sPlanID + "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and Module = '" + sModule
							+ "' and SubModule = '" + sSubModule
							+ "' and TestCaseID = '" + sPlanTestcaseId
							+ "' and device = '" + sMobDeviceName
							+ "' and testtype = '" + sTestType
							+ "' and  CompareResult = 'Fail'");
					/*
					 * ResultSet oRSQuery2 = oStmt .executeQuery(
					 * "select count(*) As Col from dbo.benefit_illustration_pdf where planid = '"
					 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
					 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
					 * sModule + "' and SubModule = '" + sSubModule +
					 * "' and TestCaseID = '" + sPlanTestcaseId +
					 * "' and device = '" + sMobDeviceName +
					 * "' and  CompareResult = 'Fail'");
					 * 
					 * if (oRSQuery2.first()) { iIllCount =
					 * oRSQuery2.getString("Col"); } oStmt =
					 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
					 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" +
					 * "select count(*) As Col from dbo.policy_document_pdf where planid = '"
					 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
					 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
					 * sModule + "' and SubModule = '" + sSubModule +
					 * "' and TestCaseID = '" + sPlanTestcaseId +
					 * "' and device = '" + sMobDeviceName +
					 * "' and  CompareResult = 'Fail'"); ResultSet oRSQuery3 =
					 * oStmt .executeQuery(
					 * "select count(*) As Col from dbo.policy_document_pdf where planid = '"
					 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
					 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
					 * sModule + "' and SubModule = '" + sSubModule +
					 * "' and TestCaseID = '" + sPlanTestcaseId +
					 * "' and device = '" + sMobDeviceName +
					 * "' and  CompareResult = 'Fail'");
					 * 
					 * if (oRSQuery3.first()) { iPDCnt =
					 * oRSQuery3.getString("Col"); } oStmt =
					 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
					 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" +
					 * "select count(*) As Col from dbo.Proposal_Details_pdf where planid = '"
					 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
					 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
					 * sModule + "' and SubModule = '" + sSubModule +
					 * "' and TestCaseID = '" + sPlanTestcaseId +
					 * "' and device = '" + sMobDeviceName +
					 * "' and  CompareResult = 'Fail'"); ResultSet oRSQuery4 =
					 * oStmt .executeQuery(
					 * "select count(*) As Col from dbo.Proposal_Details_pdf where planid = '"
					 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
					 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
					 * sModule + "' and SubModule = '" + sSubModule +
					 * "' and TestCaseID = '" + sPlanTestcaseId +
					 * "' and device = '" + sMobDeviceName +
					 * "' and  CompareResult = 'Fail'");
					 * 
					 * if (oRSQuery4.first()) { iPropCnt =
					 * oRSQuery4.getString("Col"); }
					 */
					if (!(iCompareCount.equals("0"))) {
						sStatus = "Fail";
						sOutput1 = "Data Verification Failed | ";
					}
					if (!(iIllCount.equals("0"))) {
						sStatus = "Fail";
						if (sOutput1.equals("")) {
							sOutput1 = "Benefit Illustration Comparison Failed | ";
						} else {
							sOutput1 = sOutput1
									+ "Benefit Illustration Comparison Failed | ";
						}
					}
					if (!(iPDCnt.equals("0"))) {
						sStatus = "Fail";
						if (sOutput1.equals("")) {
							sOutput1 = "Policy Document Comparison Failed | ";
						} else {
							sOutput1 = sOutput1
									+ "Policy Document Comparison Failed | ";
						}
					}
					if (!(iPropCnt.equals("0"))) {
						sStatus = "Fail";
						if (sOutput1.equals("")) {
							sOutput1 = "Proposal Details Comparison Failed | ";
						} else {
							sOutput1 = sOutput1 +"\n"
									+ "Proposal Details Comparison Failed | ";
						}
					}
					if (sOutput1.equals("")) {
						sOutput = sOutput;
					} else {
						sOutput = sOutput1 + sOutput;
					}

					if (sValidationFunction.equals("Positive")) {
						if (sStatus.equalsIgnoreCase("pass")) {
							sStatus = "Pass";
							sOutput = "Test Case Executed Successfully | " +"\n"+ sOutput;
						} else {
							sStatus = "Fail";
							sOutput = "Test Case Execution Failed | " +"\n"+ sOutput;
						}
					} else {
						if (sVPFlag.equals("")) {
							if (sStatus.equalsIgnoreCase("pass")) {
								sStatus = "Fail";
								sOutput = "Test Case Execution Failed | " +"\n"
										+ sOutput;
							} else {
								sStatus = "Pass";
								sOutput = "Test Case Executed Successfully | "+"\n"
										+ sOutput;
							}
						} else {
							sStatus = "Fail";
							sOutput = "Test Case Execution Failed | " +"\n"+ sOutput;
						}
					}
					// if (!(iCompareCount.equals("0")) &&
					// !(iIllCount.equals("0")) && !(iPDCnt.equals("0")) &&
					// !(iPropCnt.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput =
					// "Data Verification Failed | Benefit Illustration Comparison Failed  | Policy Document Comparison Failed | Proposal Details Comparison Failed | "
					// + sOutput;
					// }
					// if (!(iCompareCount.equals("0")) &&
					// !(iIllCount.equals("0")) && !(iPDCnt.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput =
					// "Data Verification Failed | Benefit Illustration Comparison Failed  | Policy Document Comparison Failed | "
					// + sOutput;
					// }
					// if (!(iCompareCount.equals("0")) &&
					// !(iIllCount.equals("0")) && !(iPropCnt.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput =
					// "Data Verification Failed | Benefit Illustration Comparison Failed  | Proposal Details Comparison Failed | "
					// + sOutput;
					// }
					// if (!(iCompareCount.equals("0")) && !(iPDCnt.equals("0"))
					// && !(iPropCnt.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput =
					// "Data Verification Failed | Policy Document Comparison Failed | Proposal Details Comparison Failed | "
					// + sOutput;
					// }
					// if(!(iCompareCount.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput =
					// "Data Verification Failed, || Illustration Comparison Failed "
					// + sOutput;
					// }
					// if(!(iCompareCount.equals("0"))){
					// sStatus = "Fail";
					// sOutput =
					// "Test Case Execution Failed | Data Verification Failed | "
					// +
					// sOutput;
					// }else{
					// if (!(iCompareCount.equals("0"))&&
					// sValidationFunction.equals("Positive")) {
					// sStatus = "Fail";
					// sOutput =
					// "Test Case Execution Failed | Data Verification Failed | "
					// + sOutput;
					// }
					// else if(!(iIllCount.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput = "Illustration Comparison Failed,  " + sOutput;
					// }
					// else if (!sStatus.equals("Fail")&&
					// !sStatus.equals("Terminated")&&
					// sValidationFunction.equals("Positive")) {
					// sStatus = "Pass";
					// sOutput = "Test Case Executed Successfully | " + sOutput;
					// }
					// else if(!(iCompareCount.equals("0")) &&
					// !(iIllCount.equals("0")) &&
					// sValidationFunction.equals("Negative")){
					// sStatus = "Pass";
					// sOutput =
					// "Data Verification Failed, || Illustration Comparison Failed "
					// + sOutput;
					// }
					// else if (!(iCompareCount.equals("0")) &&
					// sValidationFunction.equals("Negative")) {
					// sStatus = "Fail";
					// sOutput =
					// "Test Case Execution Failed | Data Verification Failed | "
					// + sOutput;
					// }
					// else if(!(iIllCount.equals("0")) &&
					// sValidationFunction.equals("Negative")){
					// sStatus = "Pass";
					// sOutput = "Illustration Comparison Failed,  " + sOutput;
					// }
					// else if ((sStatus.equals("Fail") ||
					// sStatus.equals("Terminated")) &&
					// sValidationFunction.equals("Negative")) {
					// sStatus = "Pass";
					// sOutput = "Test Case Executed Successfully | " + sOutput;
					// } else if (sStatus.equals("Pass") &&
					// sValidationFunction.equals("Negative")) {
					// sStatus = "Fail";
					// sOutput = "Test Case Execution Failed | " + sOutput;
					// } else if (sStatus.equals("Fail") &&
					// sValidationFunction.equals("Positive")) {
					// // sStatus = "Fail";
					// sOutput = "Test Case Execution Failed | " + sOutput;
					// }
					// }
				}

				logger.info("sStatus=" + sStatus + ",sOutput=" + sOutput);
				sOutput = sOutput.replace("'", "''");
				sExpectedResult = sExpectedResult.replace("'", "''");
				// Modified by Seema 30Jun17 : For Flow ID
				String sRCTCExeTime = "";
				int sec = 00;
				int min = 00;
				int hr = 00;
				SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
				logger.info("sQuery="
						+ "select * from QTP_RC_TC_Results where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and maintestcaseid = '" + sPlanTestcaseId
						+ "' and TestCaseID = '" + sRCTestcaseID
						+ "' and device = '" + sMobDeviceName
						+ "' and testtype = '" + sTestType + "'");
				ResultSet oRCTCRSQuery = oStmt
						.executeQuery("select * from QTP_RC_TC_Results where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and maintestcaseid = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sRCTestcaseID
								+ "' and device = '"
								+ sMobDeviceName
								+ "' and testtype = '"
								+ sTestType + "'");
				while (oRCTCRSQuery.next()) {
					sRCTCExeTime = oRCTCRSQuery.getString("executiontime");
					Date d3 = format.parse(sRCTCExeTime);
					sec = sec + d3.getSeconds();
					min = min + d3.getMinutes();
					hr = hr + d3.getHours();
					Time sum = new Time(hr, min, sec);
					System.out.println(sum); // Output: 11:14:16
					sExecutionTime = "" + sum;
				}
				logger.info("sQuery="
						+ "insert into QTP_Results (UserName,MachineID,PRC,Module,SubModule,TestCaseID,ScenarioID,TCID,ExpectedResult,ActualResult,Status,ExecutionTime,Execution_Date)"
						+ " values ('"
						+ sUser
						+ "','"
						+ sMachineId
						+ "','"
						+ sPlanRelCyc
						+ "','"
						+ sModule
						+ "','"
						+ sSubModule
						+ "','"
						+ sPlanTestcaseId
						+ "','"
						+ sScenarioId
						+ "','"
						+ sTCID
						+ "','"
						+ sExpectedResult
						+ "','"
						+ sOutput
						+ "','"
						+ sStatus
						+ "','"
						+ sExecutionTime
						+ "','"
						+ new SimpleDateFormat("MM-dd-yyyy").format(oStartTime)
						+ "')");
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				oStmt.executeUpdate("insert into QTP_Results (UserName,MachineID,PRC,Module,SubModule,TestCaseID,ScenarioID,TCID,ExpectedResult,ActualResult,Status,ExecutionTime,Execution_Date)"
						+ " values ('"
						+ sUser
						+ "','"
						+ sMachineId
						+ "','"
						+ sPlanRelCyc
						+ "','"
						+ sModule
						+ "','"
						+ sSubModule
						+ "','"
						+ sPlanTestcaseId
						+ "','"
						+ sScenarioId
						+ "','"
						+ sTCID
						+ "','"
						+ sExpectedResult
						+ "','"
						+ sOutput
						+ "','"
						+ sStatus
						+ "','"
						+ sExecutionTime
						+ "','"
						+ new SimpleDateFormat("MM-dd-yyyy").format(oStartTime)
						+ "')");
				logger.info("sQuery="
						+ "update qath_testplan_executor set planstatus = '"
						+ sStatus
						+ "', "
						+ "expectedresult = '"
						+ sExpectedResult
						+ "', "
						+ "actualresult = '"
						+ sOutput
						+ "',"
						+ "executiontime = '"
						+ sExecutionTime
						+ "',"
						+ "screenshotpath = '"
						+ sFullScreenShotPath
						+ "' "
						+ "where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and planmodule = '"
						+ sModule
						+ "' and plansubmodule = '"
						+ sSubModule
						+ "' and plantestcaseid = '"
						+ sPlanTestcaseId
						+ "' and device = '" + sMobDeviceName + "'");
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				oStmt.executeUpdate("update qath_testplan_executor set planstatus = '"
						+ sStatus
						+ "', "
						+ "expectedresult = '"
						+ sExpectedResult
						+ "', "
						+ "actualresult = '"
						+ sOutput
						+ "',"
						+ "executiontime = '"
						+ sExecutionTime
						+ "', "
						+ "screenshotpath = '"
						+ sFullScreenShotPath
						+ "' "
						+ "where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and planmodule = '"
						+ sModule
						+ "' and plansubmodule = '"
						+ sSubModule
						+ "' and plantestcaseid = '"
						+ sPlanTestcaseId
						+ "' and device = '" + sMobDeviceName + "'");
				if (sStatus.equalsIgnoreCase("fail")) {
					sFailFlag = "Yes";
				}
				// Update Test Data as per Maxlife Format
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				logger.info("sQuery="
						+ "select * from qath_testplan_executor where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and planmodule = '" + sModule
						+ "' and plansubmodule = '" + sSubModule
						+ "' and plantestcaseid = '" + sPlanTestcaseId
						+ "' and device = '" + sMobDeviceName + "'");
				ResultSet oRSQueryTD = oStmt
						.executeQuery("select * from qath_testplan_executor where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and planmodule = '"
								+ sModule
								+ "' and plansubmodule = '"
								+ sSubModule
								+ "' and plantestcaseid = '"
								+ sPlanTestcaseId
								+ "' and device = '" + sMobDeviceName + "'");
				String sExeTestData = "";
				if (oRSQueryTD.first()) {
					sExeTestData = oRSQueryTD.getString("testdata");
					if (sExeTestData == null) {
						sExeTestData = "";
					}
				}
				if (sTestDataTC == null) {
					sTestDataTC = "";
				}
				logger.info("sTestDataTC : " + sTestDataTC + "sExeTestData : "
						+ sExeTestData);
				String sConsolTD = "";
				if (sTestDataTC.equals("") && (sExeTestData.equals(""))) {
					sConsolTD = "";
				} else if (sTestDataTC.equals("")
						&& (!(sExeTestData.equals("")))) {
					sConsolTD = sExeTestData;
				} else if ((!(sTestDataTC.equals("")))
						&& ((sExeTestData.equals("")))) {
					sConsolTD = sTestDataTC;
				} else {
					sConsolTD = sTestDataTC + "||" + sExeTestData;
				}
				logger.info("sConsolTD : " + sConsolTD + "sExeTestData : "
						+ sExeTestData);
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				oStmt.executeUpdate("update qath_testplan_executor set testdata = '"
						+ sKey
						+ "' "
						+ "where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and planmodule = '"
						+ sModule
						+ "' and plansubmodule = '"
						+ sSubModule
						+ "' and plantestcaseid = '"
						+ sPlanTestcaseId
						+ "' and device = '" + sMobDeviceName + "'");
				sSTPStatus = sStatus;
				sStatus = "";
				sOutput = "";
			}
			sMultiFlag = "";
			// sAFFlag = "";
		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public int waittillexist() {
		logger.info("Inside waitTillExist");
		iReturnValue = 0;
		try {
			Thread.sleep(1000);
			GetObj(sSFStepKeyword.split(":")[0]);
			int iTimeout = Integer.parseInt(sMaxDynamicWaitTime);// Integer.parseInt(sSFStepKeyword.split(":")[1]);
			int iCounter = 0;
			while (oTestObject != null) {
				Thread.sleep(1000);
				iCounter = iCounter + 1;
				if (iCounter > iTimeout) {
					throw new Exception("Timeout Error while Page Load "
							+ sSFStepKeyword.split(":")[0]);
				}
				GetObj(sSFStepKeyword.split(":")[0]);
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}

		}
		return iReturnValue;
	}

	public int captureerror() {
		logger.info("Inside  CaptureError");
		iReturnValue = 0;
		ResultSet oRSQuery = null;
		String sQuery = null;

		try {
			SessionId sSessionId = null;
			try {

				sSessionId = ((RemoteWebDriver) oDriver).getSessionId();
			} catch (Exception e) {
			}

			// if (oDriver != null) {
			iReturnValue = 0;
			String sIDSFStepKeyword = sSFStepKeyword;
			String sExpected = "", sActual = "", sCompareResult = "";
			String[] oObj;
			String sErrorDesc = null;
			List<WebElement> oErrorObjects1 = null, oErrorObjects21 = null, oErrorObjects2 = null, oErrorObjects3 = null, oErrorObjects4 = null, oErrorObjects5 = null, oErrorObjects6 = null, oErrorObjects7 = null, oErrorObjects9, oErrorObjects10, oErrorObjects11, oErrorObjects12, oErrorObjects13 = null;
			WebElement oErrorObj1, oErrorObj2, oErrorObj3, oErrorObj4;
			if (!sSFStepKeyword.equalsIgnoreCase("")) {
				try {
					String[] oObjects = sIDSFStepKeyword.split(";;");
					for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						oObj = oObjects[iObjInd].split(":");
						sQuery = "Select ExpectedValue From QTP_ExpectedResult Where TestCaseId = '"
								+ sPlanTestcaseId
								+ "' and Field = '"
								+ oObj[0]
										+ "' and RunId = '" + sFlowCode + "'";
						logger.info(sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							sExpected = oRSQuery.getString("ExpectedValue");
							logger.info("sExpected = " + sExpected);
							if (!sExpected.equalsIgnoreCase("")) {
								logger.info("Object Name=" + oObjects[iObjInd]);
								logger.info(oObjects[iObjInd]
										+ " expected value = " + sExpected);
								String sTestData = "";
								// String[] oObj =
								// oObjects[iObjInd].split(":");
								if (oObj.length > 1) {
									/*
									 * if (oObj[1].equalsIgnoreCase("random")) {
									 * sTestData =
									 * String.valueOf(this.randomGenerator ());
									 * } else { sTestData = oGlobalMap.get
									 * (oObj[1].toLowerCase()); }
									 */
									GetObj(oObj[0]);

									// oErrorObjects1 = (List<WebElement>)
									// oTestObject;
									if (oTestObject != null) {
										String sTempStepKeyword = "";
										sTempStepKeyword = sSFStepKeyword;
										sSFStepKeyword = "";
										screens();
										sSFStepKeyword = sTempStepKeyword;
										sErrorDesc = oTestObject.getText();
										if (!sErrorDesc.equalsIgnoreCase("")) {
											if (sErrorDesc
													.equalsIgnoreCase(sExpected)) {
												logger.info("Forword to expected department");
												sErrorDesc = "";
											} else {
												logger.info("Forword to expected department"
														+ sErrorDesc);
												logger.info("Not forword to expected department");
											}
										}
									}
								}
							}
						}
					}
					oRSQuery.close();
				} catch (Exception e) {
				}
			} else {
				if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
					if (sUIName.equalsIgnoreCase("Native")) {
						oDriver_Mob.useNativeIdentification();
						UIName = "Native";
					} else {
						oDriver_Mob.useWebIdentification();
						UIName = "WEB";
					}
					String sTempStepKeyword="";
					int i=0;
					Thread.sleep(500);
					try {
						oDriver_Mob.device().closeKeyboard();
					} catch (Exception e) {
					}
					try {
						
						Boolean a1 = oDriver_Mob.findElement(By.xpath("//*[@text='Information']/following::*[@class='UILabel'][1]")).waitFor(100);
						Boolean a2 = oDriver_Mob.findElement(By.xpath("//*[@text='Warning!']/following::*[@class='UILabel'][1]")).waitFor(100);
						Boolean a3 = oDriver_Mob.findElement(By.xpath("//*[@text='Error']/following::*[@class='UILabel'][1]")).waitFor(100);
						Boolean a4 = oDriver_Mob.findElement(By.xpath("//*[@text='OK']")).waitFor(100);
						Boolean a5 = oDriver_Mob.findElement(By.xpath("//*[@text='Note']/following::*[@class='UILabel'][1]")).waitFor(100);
						Boolean a6 = oDriver_Mob.findElement(By.xpath("(//*[@accessibilityLabel='AN ERROR OCCURRED'])[1]")).waitFor(100);
						
//						Boolean a1 =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='Information']/following::*[@class='UILabel'][1]",0);
						
//						Boolean a2 =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='Warning!']/following::*[@class='UILabel'][1]",0);
//						Boolean a3 =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='Error']/following::*[@class='UILabel'][1]",0);
//						Boolean a4 =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='OK']",0);
//						Boolean a_4 =oDriver_Mob.client.isElementFound("NATIVE","nixpath=//*[@text='OK']",0);
						if (a1.equals(true))
						{
							sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@text='Information']/following::*[@class='UILabel'][1]",0).trim();
							sErrorDesc = "Error message = "+sErrorDesc;
							sSFStepKeyword = "Error message";
							screens();
							sSFStepKeyword = sTempStepKeyword;
							if(sErrorDesc.contains("ATTACH") || sErrorDesc.contains("ACCEPTABLE") || 
							   sErrorDesc.contains("ACCEPTABLE") || sErrorDesc.contains("MAXIMUM") ||
							   sErrorDesc.contains("SUBMIT") || sErrorDesc.contains("MAX") || 
							   sErrorDesc.contains("CONSIDERATION") || sErrorDesc.contains("PLAN") 
							   || sErrorDesc.contains("input your CURRENT agency portal password")) {
								sErrorDesc ="";
								oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK']", 0, 1);
							}else if(sErrorDesc.contains("The Face Amount")) {
								oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK']", 0, 1);
								Thread.sleep(100);
								oDriver_Mob.client.click(UIName, "xpath=//*[@text='Face Amount' and @class='UILabel']/following-sibling::*", 0, 1);
								Thread.sleep(100);
								oDriver_Mob.client.click(UIName,"xpath=//*[@text='Select All']", 0, 1);
								Thread.sleep(100);
								oDriver_Mob.client.click(UIName,"xpath=//*[@accessibilityLabel='Cut' and @text='Cut']", 0, 2);
								try {
									oDriver_Mob.device().closeKeyboard();
								} catch (Exception e) {
								}
							}else if(sErrorDesc.contains("Please key in Basic Face Amount") ||
									sErrorDesc.contains("Please input a valid date")) {
								sErrorDesc ="";
								Thread.sleep(1000);
;								oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK']", 0, 1);
								Thread.sleep(1000);
								try {
									oDriver_Mob.device().closeKeyboard();
								} catch (Exception e) {
								}
							}
						}
						Boolean a_1 =oDriver_Mob.findElement(By.xpath("//*[@text='Information']/following::*[@class='UIAStaticText']")).waitFor(200);
						if (a_1.equals(true))
						{
							sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"nixpath=//*[@text='Information']/following::*[@class='UIAStaticText']",0).trim();
							sErrorDesc = "Error message = "+sErrorDesc;
							sSFStepKeyword = "Error message";
							
							screens();
							sSFStepKeyword = sTempStepKeyword;
							if(sErrorDesc.contains("ATTACH") || sErrorDesc.contains("ACCEPTABLE") || 
							   sErrorDesc.contains("ACCEPTABLE") || sErrorDesc.contains("MAXIMUM") ||
							   sErrorDesc.contains("SUBMIT") || sErrorDesc.contains("MAX") || 
							   sErrorDesc.contains("CONSIDERATION") || sErrorDesc.contains("PLAN")) {
							   sErrorDesc ="";
								oDriver_Mob.client.click(UIName, "nixpath=//*[@text='OK']", 0, 1);
								Thread.sleep(2000);
								try {
									oDriver_Mob.device().closeKeyboard();
								} catch (Exception e) {
								}
							}
						}
						
						else if (a2.equals(true)) {
							sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@text='Warning!']/following::*[@class='UILabel'][1]",0).trim();
							sErrorDesc = "Error message = "+sErrorDesc;
							
							sSFStepKeyword = "Error message";
							screens();
							sSFStepKeyword = sTempStepKeyword;
						}else if (a3.equals(true)) {
							sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@text='Error']/following::*[@class='UILabel'][1]",0).trim();
							
							if(sErrorDesc.contains("Please key in Basic Face Amount") ||
									sErrorDesc.contains("Please input a valid date")) {
								sErrorDesc ="";
								Thread.sleep(1000);
;								oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK']", 0, 1);
								Thread.sleep(1000);
								try {
									oDriver_Mob.device().closeKeyboard();
								} catch (Exception e) {
								}
							}
							else {
								sErrorDesc = "Error message = "+sErrorDesc;
								sSFStepKeyword = "Error message";
								screens();
								sSFStepKeyword = sTempStepKeyword;
							}
						}else if (a5.equals(true)) {
							sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@text='Note']/following::*[@class='UILabel'][1]",0).trim();
							sErrorDesc = "Error message = "+sErrorDesc;
							sSFStepKeyword = "Error message";
							screens();
							sSFStepKeyword = sTempStepKeyword;
						}
						else if (a6.equals(true)) {
							//sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@text='Warning!']/following::*[@class='UILabel'][1]",0).trim();
							sErrorDesc = "Error message = An Error Occurred Pop-Up Display";
							sSFStepKeyword = "Error message";
							screens();
							sSFStepKeyword = sTempStepKeyword;
						}
						if (a4.equals(true)) {
							oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK']", 0, 1);
						}
						
//						i = oDriver_Mob.client.getElementCount(UIName,"xpath=//*[@accessibilityLabel='Notices']/following-sibling::*[@accessibilityLabel]|//*[contains(text(),'Please input your')]|//*[@text='Tips']/following-sibling::*|//*[contains(text(),'Please select')]|//*[@text='Information']/following::*[contains(@id,'alert') and @text]|//*[@text='Error message']/following-sibling::*|//*[@text='Message']/following-sibling::*|//*[@text='Error']/following-sibling::*|//*[contains(text(),'Please input')]|//*[@text='INFORMATION']/following::*[contains(@id,'alert') and @text]|//*[@text='INFORMATION:']/following::*[contains(@id,'alert') and @text]|//*[@text='tips']/following-sibling::*|//*[@text='Info']/following-sibling::*|//*[@text='ALERT']/following-sibling::*[@text='Failed to update, please try refresh later.' and @hidden='false']");
	
						
					} catch (Exception e) {
					}
//					if (i != 0 && i>0) {
//						String sTempStepKeyword = "";
//						sTempStepKeyword = sSFStepKeyword;
//						
//						if (i == 1) {
//							sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@text='Information']/following::*[@class='UILabel'][1]|//*[@text='Warning!']/following::*[@class='UILabel'][1]",0).trim();
//							if(!sErrorDesc.contains("Failed to get the DeviceToken, It will affect")){
//							sSFStepKeyword = "~critical";
//							screens();
//							sSFStepKeyword = sTempStepKeyword;
//							}
//							oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK']", 0, 1);
//							
//						} else {
//							for (int iError = 0; iError <i; iError++) {
//								
//								if(sErrorDesc==null){
//								sErrorDesc = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@accessibilityLabel='Notices']/following-sibling::*[@accessibilityLabel]|//*[contains(text(),'Please input your')]|//*[@text='Tips']/following-sibling::*|//*[contains(text(),'Please select')]|//*[@text='Information']/following::*[contains(@id,'alert') and @text]|//*[@text='Error message']/following-sibling::*|//*[@text='Message']/following-sibling::*|//*[@text='Error']/following-sibling::*|//*[contains(text(),'Please input')]|//*[@text='INFORMATION']/following::*[contains(@id,'alert') and @text]|//*[@text='INFORMATION:']/following::*[contains(@id,'alert') and @text]|//*[@text='tips']/following-sibling::*|//*[@text='Info']/following-sibling::*",iError).trim();
//								}
//								else if(sErrorDesc!=null)
//								{
//									String str = oDriver_Mob.client.elementGetText(UIName,"xpath=//*[@accessibilityLabel='Notices']/following-sibling::*[@accessibilityLabel]|//*[contains(text(),'Please input your')]|//*[@text='Tips']/following-sibling::*|//*[contains(text(),'Please select')]|//*[@text='Information']/following::*[contains(@id,'alert') and @text]|//*[@text='Error message']/following-sibling::*|//*[@text='Message']/following-sibling::*|//*[@text='Error']/following-sibling::*|//*[contains(text(),'Please input')]|//*[@text='INFORMATION']/following::*[contains(@id,'alert') and @text]|//*[@text='INFORMATION:']/following::*[contains(@id,'alert') and @text]|//*[@text='tips']/following-sibling::*|//*[@text='Info']/following-sibling::*",iError).trim();
//									sErrorDesc+=str;
//								}
//								}
//							sSFStepKeyword = "~critical";
//							screens();
//							sSFStepKeyword = sTempStepKeyword;
//						}
//						
//						
//					}
				
				}
			}
			if (sErrorDesc.equalsIgnoreCase("Failed to get the DeviceToken, It will affect the remote notification, please open the network or open the push switch in config.")) {
				try {

					oDriver_Mob.device().closeKeyboard();
					// Thread.sleep(1000);
				} catch (Exception e) {

				}

				sErrorDesc = "";
			}

			if (sErrorDesc == null) {
				sErrorDesc = "";
			}

			if (!sErrorDesc.equals("")) {
				sStatus = "Fail";

				if ((sOutput.equals(""))) {
					sOutput = sErrorDesc;
				} else {
					sOutput = sOutput + " | " + "\n"+ sErrorDesc;
				}
				try {

					oDriver_Mob.device().closeKeyboard();
					// Thread.sleep(1000);
				} catch (Exception e) {

				}
				//Sushant Yadav : 19-06-2019 : Change for Negative TC scenario (When Error description not blank)
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				// iTerminateInd = 1;
			} else if (sErrorDesc.equals("") && !sStatus.equals("Fail")
					&& !sStatus.equals("Terminated")) {
				sStatus = "Pass";
			}
			logger.info("Error Description=" + sErrorDesc + " and output is "
					+ sOutput);

		} catch (UnhandledAlertException e) {
			logger.info("catch 1");
			String sAlertActualText = oDriver.switchTo().alert().getText();
			if (!(sAlertActualText.equals(""))) {
				if (!(sOutput.equals(""))) {
					sOutput = sOutput + " | " +"\n"+ sAlertActualText;
				} else {
					sOutput = sAlertActualText;
				}
				// iRCTCTerminateInd = 1;
				iReturnValue = 1;
				logger.error(e.getAlertText());
			}
		} catch (Exception e) {
			try {
				logger.info("catch 2");
				// if(e.getMessage().contains("cannot be evaluated")){
				// logger.error("Skipped : " + e.getMessage());
				// }
				// else{

				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
				
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
			// }
		}
		//oDriver_Mob.device().closeKeyboard();
		return iReturnValue;
	}

	
	//Sushant Yadav : 06/07/2019 : To find out total signature available on screen and do the signature.
		public int signature() {
		logger.info("Inside Signature");
		iReturnValue = 0;
		try {
			int SignSize = oDriver_Mob.findElements(By.xpath("xpath=//*[@class='TFSSignDocFieldSignature' and @knownSuperClass='UIButton']")).size();
				while((SignSize)>0)
				{
				String sElement1="xpath=//*[@class='TFSSignDocFieldSignature' and @knownSuperClass='UIButton' and @onScreen='true'][2]";
				Thread.sleep(100);
				oDriver_Mob.client.swipeWhileNotFound("Down", 700, 1000, "NATIVE", ""+sElement1+"", 0, 1000, 15, false);
				Thread.sleep(2000);
				int SignSize1 = oDriver_Mob.findElements(By.xpath("//*[@class='TFSSignDocFieldSignature' and @knownSuperClass='UIButton' and @onScreen='true']")).size();
				for(int i=1;i<=SignSize1;i++)
				{
				String sElement2="xpath=(//*[@class='TFSSignDocFieldSignature' and @knownSuperClass='UIButton' and @onScreen='true'])["+i+"]";	
				oDriver_Mob.client.click("NATIVE", sElement2, 0, 1);
				Thread.sleep(1000);
				sSFStepKeyword ="SignHere";
				//dragdrop();
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@accessibilityLabel='signatureIndicator']", 0, 1);
//				oDriver_Mob.findElement(By.xpath("//*[@accessibilityLabel='signatureIndicator']")).drag(1200, 200);
//				oDriver_Mob.findElement(By.xpath(""+oTestObject1+"")).drag(1200, 200);
				oDriver_Mob.client.drag("NATIVE", "xpath=//*[@accessibilityLabel='signatureIndicator']", 0, 1200, 200);
				
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@accessibilityLabel='check icon' and @class='UIButton']", 0, 1);
                Thread.sleep(1000);
                SignSize--;
				}
				 oDriver_Mob.client.swipe("Down", 300, 1000);
				 /*if(SignSize==0)
				 {
					 int SignSize11 = oDriver_Mob.findElements(By.xpath("xpath=(//*[@class='TFSSignDocFieldSignature' and @knownSuperClass='UIButton' and @onScreen='true'])[1]")).size();
					 if(SignSize11>0)
					 {
						 String sElement2="xpath=(//*[@class='TFSSignDocFieldSignature' and @knownSuperClass='UIButton' and @onScreen='true'])[1]";	
							oDriver_Mob.client.click("NATIVE", sElement2, 0, 1);	
							sSFStepKeyword ="SignHere";
							//dragdrop();
							oDriver_Mob.client.click("NATIVE", "xpath=//*[@accessibilityLabel='signatureIndicator']", 0, 1);
//							oDriver_Mob.findElement(By.xpath("//*[@accessibilityLabel='signatureIndicator']")).drag(1200, 200);
//							oDriver_Mob.findElement(By.xpath(""+oTestObject1+"")).drag(1200, 200);
							oDriver_Mob.client.drag("NATIVE", "xpath=//*[@accessibilityLabel='signatureIndicator']", 0, 1200, 200);
							
							oDriver_Mob.client.click("NATIVE", "xpath=//*[@accessibilityLabel='check icon' and @class='UIButton']", 0, 1);
			                Thread.sleep(200); 
					 }
				 }*/
				 
				}
			
		}catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iRCTCTerminateInd = 1;
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}	
		return iReturnValue;
	}
	
	
	public void UpdateRCTCResult() {
		logger.info("Inside UpdateRCTCResult");
		String sOutput1 = "", sVPFlag = "";
		try {
			sSTPStatus = sStatus;
			if (sSTPStatus.equals("")) {
				sSTPStatus = "Pass";
			}
			logger.info("sStatus=" + sStatus + ",sOutput=" + sOutput);
			sExitSFFlag = "";
			sExitStatus = "";
			String iCompareCount = "0";
			String iIllCount = "0";
			String iPropCnt = "0";
			String iPDCnt = "0";
			// String sRCTCRunID = sRunID;// Modified by Seema on 29 Jun17 :
			// Flow
			// ID approach
			if (sOutput.toLowerCase().contains("(session info")) {
				sOutput = sOutput.split("\\(Session info")[0].trim();
				System.out.println(sOutput);
			}
			// Modified by Seema on 29 Jun17 : Flow ID approach
			if (sFlowID.equals("0")) {
				logger.info("Inside flowId = 0");
				/*
				 * oStmt1 = oConn.createStatement(
				 * ResultSet.TYPE_SCROLL_INSENSITIVE,
				 * ResultSet.CONCUR_READ_ONLY); logger.info("sQuery=" +
				 * "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
				 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
				 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
				 * sModule + "' and SubModule = '" + sSubModule +
				 * "' and MainTestCaseID = '" + sPlanTestcaseId +
				 * "' and TestCaseID = '" + sRCTestcaseID +
				 * "' and  CompareResult = 'Fail' and device = '" +
				 * sMobDeviceName + "'"); ResultSet oRSQuery1 = oStmt1
				 * .executeQuery(
				 * "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
				 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
				 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
				 * sModule + "' and SubModule = '" + sSubModule +
				 * "' and MainTestCaseID = '" + sPlanTestcaseId +
				 * "' and TestCaseID = '" + sRCTestcaseID +
				 * "' and  CompareResult = 'Fail' and device = '" +
				 * sMobDeviceName + "'"); if (oRSQuery1.first()) { iCompareCount
				 * = oRSQuery1.getString("Col"); }
				 */
				if (sOutput.toLowerCase().contains("(session info")) {
					sOutput = sOutput.split("\\(Session info")[0].trim();
					System.out.println(sOutput);
				}
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				logger.info("sQuery="
						+ "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and Module = '" + sModule + "' and SubModule = '"
						+ sSubModule + "' and MainTestCaseID = '"
						+ sPlanTestcaseId + "' and TestCaseID = '"
						+ sRCTestcaseID + "' and device = '" + sMobDeviceName
						+ "' and testtype = '" + sTestType
						+ "' and  CompareResult = 'Fail'");
				ResultSet oRSQuery1 = oStmt
						.executeQuery("select count(*) As Col from dbo.QTP_CompareResult where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and Module = '"
								+ sModule
								+ "' and SubModule = '"
								+ sSubModule
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sRCTestcaseID
								+ "' and device = '"
								+ sMobDeviceName
								+ "' and testtype = '"
								+ sTestType
								+ "' and  CompareResult = 'Fail'");
				if (oRSQuery1.first()) {
					iCompareCount = oRSQuery1.getString("Col");
				}
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				logger.info("sQuery="
						+ "select count(*) As Col from dbo.benefit_illustration_pdf where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and Module = '" + sModule + "' and SubModule = '"
						+ sSubModule + "' and MainTestCaseID = '"
						+ sPlanTestcaseId + "' and TestCaseID = '"
						+ sRCTestcaseID + "' and device = '" + sMobDeviceName
						+ "' and testtype = '" + sTestType
						+ "' and  CompareResult = 'Fail'");
				/*
				 * ResultSet oRSQuery2 = oStmt .executeQuery(
				 * "select count(*) As Col from dbo.benefit_illustration_pdf where planid = '"
				 * + sPlanID + "' and planreleaseid = '" + sReleaseID +
				 * "' and plancycleid = '" + sCycleID + "' and Module = '" +
				 * sModule + "' and SubModule = '" + sSubModule +
				 * "'  and MainTestCaseID = '" + sPlanTestcaseId +
				 * "' and TestCaseID = '" + sRCTestcaseID + "' and device = '" +
				 * sMobDeviceName + "' and  CompareResult = 'Fail'");
				 * 
				 * if (oRSQuery2.first()) { iIllCount =
				 * oRSQuery2.getString("Col"); }
				 */
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				logger.info("sQuery="
						+ "select count(*) As Col from dbo.policy_document_pdf where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and Module = '" + sModule + "' and SubModule = '"
						+ sSubModule + "' and MainTestCaseID = '"
						+ sPlanTestcaseId + "' and TestCaseID = '"
						+ sRCTestcaseID + "' and device = '" + sMobDeviceName
						+ "' and testtype = '" + sTestType
						+ "' and  CompareResult = 'Fail'");
				ResultSet oRSQuery3 = oStmt
						.executeQuery("select count(*) As Col from dbo.policy_document_pdf where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and Module = '"
								+ sModule
								+ "' and SubModule = '"
								+ sSubModule
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sRCTestcaseID
								+ "' and device = '"
								+ sMobDeviceName
								+ "' and testtype = '"
								+ sTestType
								+ "' and  CompareResult = 'Fail'");

				if (oRSQuery3.first()) {
					iPDCnt = oRSQuery3.getString("Col");
				}
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				logger.info("sQuery="
						+ "select count(*) As Col from dbo.Proposal_Details_pdf where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and Module = '" + sModule + "' and SubModule = '"
						+ sSubModule + "' and MainTestCaseID = '"
						+ sPlanTestcaseId + "' and TestCaseID = '"
						+ sRCTestcaseID + "' and device = '" + sMobDeviceName
						+ "' and testtype = '" + sTestType
						+ "' and  CompareResult = 'Fail'");
				ResultSet oRSQuery4 = oStmt
						.executeQuery("select count(*) As Col from dbo.Proposal_Details_pdf where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and Module = '"
								+ sModule
								+ "' and SubModule = '"
								+ sSubModule
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								+ "' and TestCaseID = '"
								+ sRCTestcaseID
								+ "' and device = '"
								+ sMobDeviceName
								+ "' and testtype = '"
								+ sTestType
								+ "' and  CompareResult = 'Fail'");

				if (oRSQuery4.first()) {
					iPropCnt = oRSQuery4.getString("Col");
				}
				if (!(iCompareCount.equals("0"))) {
					sStatus = "Fail";
					sOutput1 = "Data Verification Failed | ";
				}
				if (!(iIllCount.equals("0"))) {
					sStatus = "Fail";
					if (sOutput1.equals("")) {
						sOutput1 = "Benefit Illustration Comparison Failed | ";
					} else {
						sOutput1 = sOutput1
								+ "Benefit Illustration Comparison Failed | ";
					}
				}
				if (!(iPDCnt.equals("0"))) {
					sStatus = "Fail";
					if (sOutput1.equals("")) {
						sOutput1 = "Policy Document Comparison Failed | ";
					} else {
						sOutput1 = sOutput1
								+ "Policy Document Comparison Failed | ";
					}
				}
				if (!(iPropCnt.equals("0"))) {
					sStatus = "Fail";
					if (sOutput1.equals("")) {
						sOutput1 = "Proposal Details Comparison Failed | ";
					} else {
						sOutput1 = sOutput1
								+ "Proposal Details Comparison Failed | ";
					}
				}
				if (sOutput1.equals("")) {
					sOutput = sOutput;
				} else {
					sOutput = sOutput1 + "\n"+ sOutput;
				}

				if (sValidationFunction.equals("Positive")) {
					if (sStatus.equalsIgnoreCase("pass")) {
						sStatus = "Pass";
						sOutput = "Test Case Executed Successfully | "
								+ sOutput;
					} else {
						sStatus = "Fail";
						sOutput = "Test Case Execution Failed | " + sOutput;
					}
				} else {
					if (sVPFlag.equals("")) {
						if (sStatus.equalsIgnoreCase("pass")) {
							sStatus = "Fail";
							sOutput = "Test Case Execution Failed | " + sOutput;
						} else {
							sStatus = "Pass";
							sOutput = "Test Case Executed Successfully | "
									+ sOutput;
						}
					} else {
						sStatus = "Fail";
						sOutput = "Test Case Execution Failed | " + sOutput;
					}
				}
				// Modified by Seema on 29 Jun17 : Flow ID approach
			} else {
				oStmt1 = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				logger.info("sQuery="
						+ "select count(*) As Col from dbo.QTP_CompareResult where planid = '"
						+ sPlanID + "' and planreleaseid = '" + sReleaseID
						+ "' and plancycleid = '" + sCycleID
						+ "' and Module = '" + sModule
						+ "' and SubModule = '"
						+ sSubModule
						+ "' and MainTestCaseID = '"
						+ sPlanTestcaseId // + "' and runid = '" + sFlowCode
						+ "' and  CompareResult = 'Fail' and device = '"
						+ sMobDeviceName + "' and testtype = '" + sTestType
						+ "'");
				ResultSet oRSQuery1 = oStmt1
						.executeQuery("select count(*) As Col from dbo.QTP_CompareResult where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and Module = '"
								+ sModule
								+ "' and SubModule = '"
								+ sSubModule
								+ "' and MainTestCaseID = '"
								+ sPlanTestcaseId
								// + "' and runid = '"
								// + sFlowID
								// + sFlowCode
								+ "' and  CompareResult = 'Fail' and device = '"
								+ sMobDeviceName
								+ "'and testtype = '"
								+ sTestType + "'");
				if (oRSQuery1.first()) {
					iCompareCount = oRSQuery1.getString("Col");
				}
				sRCTCflowid = sFlowCode;
				sRCModule = sMainModule;
				sRCSubModule = sMainSubModule;
				sRCTestcaseID = sPlanTestcaseId;
				sRCAutomationFunction = sAutomationFunction;
				sRCExpectedResult = sExpectedResult;
				sRCTestCaseDesc = sTestCaseDesc;
				// sRCExpectedResult = sRCExpectedResult.replace("'", "''");
				// sExpectedResult = sExpectedResult.replace("'", "''");
				// sRCTestCaseDesc = sRCTestCaseDesc.replace("'", "''");
				// sTestCaseDesc = sTestCaseDesc.replace("'", "''");
				if (sOutput.toLowerCase().contains(
						"TestCase Fail Because Earlier TC Is Fail"
						.toLowerCase())) {
					sStatus = "Fail";
					if (!(iCompareCount.equals("0"))
							&& sValidationFunction.equals("Positive")) {
						sOutput = "Data Verification Failed | " + sOutput;
					}
				} else {
					if (!(iCompareCount.equals("0"))
							&& sValidationFunction.equals("Positive")) {
						sStatus = "Fail";
						sOutput = "Data Verification Failed | " + sOutput;
					}
					// else if(!(iIllCount.equals("0")) &&
					// sValidationFunction.equals("Positive")){
					// sStatus = "Fail";
					// sOutput = "Illustration Comparison Failed,  " + sOutput;
					// }
					else if (!sStatus.equals("Fail")
							&& !sStatus.equals("Terminated")
							&& sValidationFunction.equals("Positive")) {
						sStatus = "Pass";
						sOutput = "Test Case Executed Successfully | "
								+ sOutput;
						iRCTCTerminateInd = 0;
					}
					// else if(!(iCompareCount.equals("0")) &&
					// !(iIllCount.equals("0")) &&
					// sValidationFunction.equals("Negative")){
					// sStatus = "Pass";
					// sOutput =
					// "Data Verification Failed, || Illustration Comparison Failed "
					// + sOutput;
					// }
					else if (!(iCompareCount.equals("0"))
							&& sValidationFunction.equals("Negative")) {
						sStatus = "Fail";
						sOutput = "Data Verification Failed | " + sOutput;
					}
					// else if(!(iIllCount.equals("0")) &&
					// sValidationFunction.equals("Negative")){
					// sStatus = "Pass";
					// sOutput = "Illustration Comparison Failed,  " + sOutput;
					// }
					else if ((sStatus.equals("Fail") || sStatus
							.equals("Terminated"))
							&& sValidationFunction.equals("Negative")) {
						sStatus = "Pass";
						sOutput = "Test Case Executed Successfully | "
								+ sOutput;
						iRCTCTerminateInd = 0;
					} else if (sStatus.equals("Pass")
							&& sValidationFunction.equals("Negative")) {
						sStatus = "Fail";
						sOutput = "Test Case Executed Successfully | "
								+ sOutput;
					}
				}
			}
			// oStmt =
			// oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			// logger.info("sQuery=" +
			// "select count(*) As Col from dbo.Compare_Illusration_Details where planid = '"
			// + sPlanID + "' and planreleaseid = '" + sReleaseID +
			// "' and plancycleid = '" + sCycleID + "' and test_case = '" +
			// sPlanTestcaseId + "' and  Result = 'Fail'");
			// ResultSet oRSQuery2 =
			// oStmt.executeQuery("select count(*) As Col from dbo.Compare_Illusration_Details where planid = '"
			// + sPlanID + "' and planreleaseid = '" + sReleaseID +
			// "' and plancycleid = '" + sCycleID + "' and test_case = '" +
			// sPlanTestcaseId + "' and  Result = 'Fail'");
			//
			// if(oRSQuery2.first()){
			// iIllCount = oRSQuery2.getString("Col");
			// }

			// if(!(iCompareCount.equals("0")) && !(iIllCount.equals("0")) &&
			// sValidationFunction.equals("Positive")){
			// sStatus = "Fail";
			// sOutput =
			// "Data Verification Failed, || Illustration Comparison Failed " +
			// sOutput;
			// }

			logger.info("sStatus=" + sStatus + ",sOutput=" + sOutput);
			sOutput = sOutput.replace("'", "''");
			sRCExpectedResult = sRCExpectedResult.replace("'", "''");
			sExpectedResult = sExpectedResult.replace("'", "''");
			sRCTestCaseDesc = sRCTestCaseDesc.replace("'", "''");
			sTestCaseDesc = sTestCaseDesc.replace("'", "''");
			// Modified by Seema on 29 Jun17 : Flow ID approach
			logger.info("sQuery="
					+ "insert into QTP_RC_TC_Results (planid,planreleaseid,plancycleid,Execution_Date,UserName,MachineID,MainTestCaseID,RunID,Module,SubModule,TestCaseID,StepFunction,ExpectedResult,ActualResult,Status,ExecutionTime,TestCaseDesc,MainTestCaseDesc,device,testtype)"
					+ " values ('"
					+ sPlanID
					+ "','"
					+ sReleaseID
					+ "','"
					+ sCycleID
					+ "','"
					+ new SimpleDateFormat("MM-dd-yyyy").format(oRCStartTime)
					+ "','"
					+ sUser
					+ "','"
					+ sMachineId
					+ "','"
					+ sPlanTestcaseId
					+ "','"
					+ sRCTCflowid
					+ "','"
					+ sRCModule
					+ "','"
					+ sRCSubModule
					+ "','"
					+ sRCTestcaseID
					+ "','"
					+ sRCAutomationFunction
					+ "','"
					+ sRCExpectedResult
					+ "','"
					+ sOutput
					+ "','"
					+ sStatus
					+ "','"
					+ sRCExecutionTime
					+ "','"
					+ sRCTestCaseDesc
					+ "','"
					+ sTestCaseDesc
					+ "','"
					+ sMobDeviceName + "','" + sTestType + "')");
			oStmt1 = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY,
					ResultSet.HOLD_CURSORS_OVER_COMMIT);
			oStmt1.executeUpdate("insert into QTP_RC_TC_Results (planid,planreleaseid,plancycleid,Execution_Date,UserName,MachineID,MainTestCaseID,RunID,Module,SubModule,TestCaseID,StepFunction,ExpectedResult,ActualResult,Status,ExecutionTime,TestCaseDesc,MainTestCaseDesc,device,testtype)"
					+ " values ('"
					+ sPlanID
					+ "','"
					+ sReleaseID
					+ "','"
					+ sCycleID
					+ "','"
					+ new SimpleDateFormat("MM-dd-yyyy").format(oRCStartTime)
					+ "','"
					+ sUser
					+ "','"
					+ sMachineId
					+ "','"
					+ sPlanTestcaseId
					+ "','"
					+ sRCTCflowid
					+ "','"
					+ sRCModule
					+ "','"
					+ sRCSubModule
					+ "','"
					+ sRCTestcaseID
					+ "','"
					+ sRCAutomationFunction
					+ "','"
					+ sRCExpectedResult
					+ "','"
					+ sOutput
					+ "','"
					+ sStatus
					+ "','"
					+ sRCExecutionTime
					+ "','"
					+ sRCTestCaseDesc
					+ "','"
					+ sTestCaseDesc
					+ "','"
					+ sMobDeviceName + "','" + sTestType + "')");
			sStatus = "";
			sOutput = "";
			sRCTestcaseID = "";
			// sAFFlag = "";
		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iRCTCTerminateInd = 1;
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}

	public int savepdf() {
		logger.info("Inside SavePDF");
		iTerminateInd = 0;
		try {
			// System.out.println(oDriver.findElements(By.xpath("//*[@id='applicationSummaryLeftContents']/what-you-buying-common/div/div[2]/div/div/div[2]/div[1]/div/div/a[2]")).size());
			// oDriver.findElement(By.xpath("//*[@id='applicationSummaryLeftContents']/what-you-buying-common/div/div[2]/div/div/div[2]/div[1]/div/div/a[2]")).click();
			Thread.sleep(5000);
			String sDestPath = "";
			if (sSFStepKeyword.equals("")) {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
						+ ".pdf";
			} else {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId + "_"
						+ sSFStepKeyword + ".pdf";
			}
			logger.info("sPDFPath=" + sDestPath);
			// if (sSFStepKeyword.equals("Online") || sSFStepKeyword.equals(""))
			// {
			logger.info(sDestPath.replace("/", "\\"));
			if (sMobDeviceName.equalsIgnoreCase("desktop")) {
				Process oProcess = Runtime.getRuntime().exec(
						sScriptPath + "\\SavePDF.exe \""
								+ sDestPath.replace("/", "\\") + "\"");
				// Process oProcess = new ProcessBuilder(sScriptPath +
				// "\\SavePDF.exe \"," + sDestPath.replace("/", "\\") + "\"",
				// "Open").start();
				oProcess.waitFor();

				// } else {
				// throw new Exception("PDF Download Failed");
				// }
				// String parentWindow = oDriver.getWindowHandle();
				// Set<String> handles = oDriver.getWindowHandles();
				// for(String windowHandle : handles){
				// if(!windowHandle.equals(parentWindow)){
				// oDriver.switchTo().window(windowHandle);
				// oDriver.close(); //closing child window
				// }
				// }
				// oDriver.switchTo().window(parentWindow);
			} else {
				((MobileWebDriver) oDriver).useNativeIdentification();
				if (oDriver.findElements(By.xpath("//*[@id='button_primary']"))
						.size() > 0) {
					oDriver.findElement(By.xpath("//*[@id='button_primary']"))
					.click();
				}
				((MobileWebDriver) oDriver).useWebIdentification();
				// Get Last modified file from Device Folder
				File theNewestFile = null;
				ResultSet oRSQueryMQ;
				String filePath = "";
				logger.info("sQuery="
						+ "select add_1 from device_master where  Device_Name = '"
						+ sMobDeviceName + "'");
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				oRSQueryMQ = oStmt
						.executeQuery("select add_1 from device_master where  Device_Name = '"
								+ sMobDeviceName + "'");
				if (oRSQueryMQ.next()) {
					filePath = oRSQueryMQ.getString("add_1");
				}
				oRSQueryMQ.close();
				/*
				 * File dir = new File(filePath); FileFilter fileFilter = new
				 * WildcardFileFilter("*.pdf"); File[] files =
				 * dir.listFiles(fileFilter); if (files.length > 0) {
				 *//** The newest file comes first **/
				/*
				 * Arrays.sort(files,
				 * LastModifiedFileComparator.LASTMODIFIED_REVERSE);
				 * theNewestFile = files[0]; } File F2 = new File(sDestPath); //
				 * copy this file in our location : theNewestFile
				 * FileUtils.copyFile(theNewestFile, F2);
				 */
			}
			Thread.sleep(2000);
			// Verify if fiels is saved sDestPath
			File file = new File(sDestPath);
			while (!(file.exists())) {
				// iTerminateInd = 1;
				iRCTCTerminateInd = 1;
				String sFileName = "";
				if (sSFStepKeyword.equals("")) {
					sFileName = sPlanTestcaseId + ".pdf";
				} else {
					sFileName = sPlanTestcaseId + "_" + sSFStepKeyword + ".pdf";
				}
				if (sOutput.equals("")) {
					sOutput = sFileName + "is not saved successfully";
				} else {
					sOutput = sOutput + " | " + sFileName
							+ "is not saved successfully";
				}
				logger.error(sFileName + "is not saved successfully");
				break;
			}

		} catch (Exception e) {
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			logger.error(e.getMessage());
		}
		return iTerminateInd;
	}

	public int SavePDFold() {
		logger.info("Inside SavePDF");
		iTerminateInd = 0;
		try {
			Thread.sleep(5000);
			String sDestPath = "";
			if (sRCTestcaseID == null || sRCTestcaseID == "") {
				// sDestPath = sFullScreenShotPath + "/"+ sPlanTestcaseId +
				// ".pdf";
				sDestPath = "D:" + "/" + sPlanTestcaseId + ".pdf";
			} else {
				sDestPath = sFullScreenShotPath + "/" + sPlanTestcaseId
						+ ".pdf";
			}
			logger.info("sPDFPath=" + sDestPath);
			if (sSFStepKeyword.equals("Online") || sSFStepKeyword.equals("")) {
				logger.info(sDestPath.replace("/", "\\"));
				Process oProcess = Runtime.getRuntime().exec(
						sScriptPath + "\\SavePDF.exe \""
								+ sDestPath.replace("/", "\\") + "\"");
				// Process oProcess = new ProcessBuilder(sScriptPath +
				// "\\SavePDF.exe \"," + sDestPath.replace("/", "\\") + "\"",
				// "Open").start();
				oProcess.waitFor();

			} else {
				throw new Exception("PDF Download Failed");
			}
			// String parentWindow = oDriver.getWindowHandle();
			// Set<String> handles = oDriver.getWindowHandles();
			// for(String windowHandle : handles){
			// if(!windowHandle.equals(parentWindow)){
			// oDriver.switchTo().window(windowHandle);
			// oDriver.close(); //closing child window
			// }
			// }
			// oDriver.switchTo().window(parentWindow);
		} catch (Exception e) {
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
			sOutput = e.getMessage().split("\\n")[0] + " | " + sOutput;
			logger.error(e.getMessage());
		}
		return iTerminateInd;
	}

	public int uploadattachment() {
		logger.info("Inside  UploadAttachment ");
		iTerminateInd = 0;
		try {
			Thread.sleep(3000);
			if (sMobDeviceName.equalsIgnoreCase("desktop")) {
				String sDestPath = oGlobalMap.get(sSFStepKeyword.toLowerCase());
				// check for file existance
				if (new File(sDestPath).exists()) {
					// if (sRCTestcaseID == null || sRCTestcaseID == ""){
					// sDestPath = sFullScreenShotPath + "/"+ sPlanTestcaseId +
					// ".pdf";
					// }
					// else{
					// sDestPath = sFullScreenShotPath + "/"+ sPlanTestcaseId +
					// "	.pdf";
					// }
					logger.info("Browser for upload is " + sBrowser);
					logger.info("uploadPath= " + sDestPath);
					// sScriptPath=
					// "C:\\Users\\Public\\Pictures\\Sample Pictures";
					if (sBrowser.equalsIgnoreCase("Chrome")) {
						Process oProcess = new ProcessBuilder(sScriptPath
								+ "\\upload.exe", sDestPath.replace("/", "\\"),
								"Open").start();
						oProcess.waitFor();
						Thread.sleep(5000);
					} else if (sBrowser.equalsIgnoreCase("Firefox")) {
						Process oProcess = new ProcessBuilder(sScriptPath
								+ "\\upload.exe", sDestPath.replace("/", "\\"),
								"File Upload").start();
						oProcess.waitFor();
						Thread.sleep(5000);
					} else {
						throw new Exception("Upload Failed");
					}
					// String parentWindow = oDriver.getWindowHandle();
					// Set<String> handles = oDriver.getWindowHandles();
					// for(String windowHandle : handles){
					// if(!windowHandle.equals(parentWindow)){
					// oDriver.switchTo().window(windowHandle);
					// oDriver.close(); //closing child window
					// }
					// }
					// oDriver.switchTo().window(parentWindow);
				} else {
					// iTerminateInd = 1;
					iRCTCTerminateInd = 1;
					if (sOutput.equals("")) {
						sOutput = "File does not exists";
					} else {
						sOutput = sOutput + " | " + "File does not exists";
					}
				}
			} else {
				((MobileWebDriver) oDriver).useNativeIdentification();
				oDriver.findElement(By.xpath("//*[@text='Documents']")).click();
				Thread.sleep(500);
				// oDriver.findElement(By.xpath("//*[@text='IMG_20170221_142506.jpg']")).click();
				// driver.useNativeIdentification();
				// driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[./following-sibling::*[./*[@text='Documents']]]]")).click();
				oDriver.findElement(
						By.xpath("//*[@contentDescription='Show roots']"))
						.click();
				// if(((Object)
				// oDriver.findElement(By.xpath("//*[@text='Photos']"))).waitFor(10000)){
				// // If statement
				// }
				// driver.findElement(By.xpath("//*[@text='Photos']")).click();
				// if(driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@text='Images']]")).waitFor(30000)){
				// If statement
				// }
				Thread.sleep(500);
				oDriver.findElement(
						By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@text='Images']]"))
						.click();
				Thread.sleep(500);
				oDriver.findElement(By.xpath("//*[@text='Screenshots']"))
				.click();
				// driver.findElement(By.xpath("//*[@text='Screenshots']")).click();
				// driver.findElement(By.xpath("//*[@text='Screenshots']")).click();
				Thread.sleep(500);
				oDriver.findElement(
						By.xpath("//*[@id='icon_thumb' and ./parent::*[./following-sibling::*[./*[@text='Screenshot_20170928-182305.png']]]]"))
						.click();
				((MobileWebDriver) oDriver).useWebIdentification();

			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			iRCTCTerminateInd = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			logger.error(e.getMessage());
		}
		return iTerminateInd;
	}

	public int switchtowindow() {
		logger.info("Inside SwitchtoWindow");
		iReturnValue = 0;
		int iFlag = 0;
		// sSFStepKeyword = "CRMNext - Smart.Easy.Complete";

		// String Title=oDriver.getTitle();
		// System.out.println(""+Title);
		try {
			// waitForPageLoad();
			Thread.sleep(3000);
			// Thread.sleep(1000);
			// if(oDriver != null){
			// title1 = oDriver.switchTo().window(winHandle1).getTitle();
			// url1 = oDriver.switchTo().window(winHandle1).getCurrentUrl();
			//
			// Thread.sleep(2000);
			// System.out.println("title 1 :" +title1 + ", URL1: "+ url1);
			// if (sSFStepKeyword.contains("~~")){
			// String[] oTemp = sSFStepKeyword.split("~~");
			// String sTitle1 = oTemp[0];
			// String sURL1 = oTemp[1];
			// if((title1).toLowerCase().contains((sTitle1).toLowerCase())){
			// if((url1).toLowerCase().contains((sURL1).toLowerCase())){
			// oDriver.close();
			// Thread.sleep(2000);
			// iFlag = 1;
			// }
			// }
			// }
			String title1 = "", url1 = "";
			// parentWindowHandle="";
			if (parentWindowHandle.equals("")) {
				parentWindowHandle = oDriver.getWindowHandle();
				logger.info("parentWindowHandle : " + parentWindowHandle);
			}
			if ((!parentWindowHandle.equals("")) && sSFStepKeyword.equals("")) {
				logger.info("Inside  parentWindowHandle");
				oDriver.switchTo().window(parentWindowHandle);
				Thread.sleep(1000);
			} else {
				logger.info("title 1 :" + title1 + ", URL1: " + url1);
				if (sSFStepKeyword.contains("~~")) {
					String[] oTemp = sSFStepKeyword.split("~~");
					String sTitle1 = oTemp[0];
					String sURL1 = oTemp[1];
					// if((title1).toLowerCase().contains((sTitle1).toLowerCase())){
					// if((url1).toLowerCase().contains((sURL1).toLowerCase())){
					// oDriver.close();
					// Thread.sleep(2000);
					// iFlag = 1;
					// }
					// }

					java.util.Set<java.lang.String> windowHandles = oDriver
							.getWindowHandles();
					logger.info(windowHandles);
					int count = windowHandles.size();
					System.out.println("count :" + count);
					String title = "";
					// parentWindowHandle = oDriver.getWindowHandle();
					for (String winHandle : oDriver.getWindowHandles()) {
						System.out.println("winHandle : " + winHandle);
						title1 = oDriver.switchTo().window(winHandle)
								.getTitle(); // Edit by Swapnil --24/08/2016
						url1 = oDriver.switchTo().window(winHandle)
								.getCurrentUrl();

						// waitForPageLoad();
						logger.info(title);

						if ((title1).toLowerCase().contains(
								(sTitle1).toLowerCase())) {
							if ((url1).toLowerCase().contains(
									(sURL1).toLowerCase())) {
								Thread.sleep(2000);
								oDriver.manage().window().maximize();
								iFlag = 1;
								Thread.sleep(3000);
							}
						}
						/*
						 * else{ oDriver.switchTo().window(sSFStepKeyword);
						 * iFlag = 1; }
						 */
					}
					if (iFlag == 0) {
						iRCTCTerminateInd = 1;
						if (sOutput.equals("")) {
							sOutput = "Expected " + sSFStepKeyword
									+ " Window not found ";
						} else {
							sOutput = sOutput + " | " + "Expected "
									+ sSFStepKeyword + " Window not found";
						}

						iReturnValue = 1;
						logger.error(sOutput);
					}
				} else {
					java.util.Set<java.lang.String> windowHandles = oDriver
							.getWindowHandles();
					logger.info(windowHandles);
					int count = windowHandles.size();

					logger.info("count: " + count);
					String title = "";

					// parentWindowHandle = oDriver.getWindowHandle();
					for (String winHandle : oDriver.getWindowHandles()) {
						logger.info("winHandle : " + winHandle);
						title = oDriver.switchTo().window(winHandle).getTitle(); // Edit
						// by
						// Swapnil
						// --24/08/2016
						logger.info(oDriver.switchTo().window(winHandle)
								.getCurrentUrl());
						title1 = oDriver.switchTo().window(winHandle)
								.getTitle(); // Edit by Swapnil --24/08/2016
						url1 = oDriver.switchTo().window(winHandle)
								.getCurrentUrl();

						// waitForPageLoad();
						logger.info(title);

						if ((title).toLowerCase().contains(
								(sSFStepKeyword).toLowerCase())) {
							Thread.sleep(2000);
							// Dimension d = new Dimension(500,600);
							// oDriver.navigate().refresh();
							oDriver.manage().window().maximize();
							iFlag = 1;
							Thread.sleep(3000);
						}
						/*
						 * else{ oDriver.switchTo().window(sSFStepKeyword);
						 * iFlag = 1; }
						 */

					}
					if (iFlag == 0) {

						if (sOutput.equals("")) {
							sOutput = "Expected " + sSFStepKeyword
									+ " Window not found ";
						} else
							/*
							 * { sOutput = sOutput + " | " +
							 * "Expected Window not found"; } iRCTCTerminateInd
							 * = 1; iTerminateInd = 1; iReturnValue = 1;
							 */
							logger.error(sOutput);
					}
				}
			}
			// }
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				// iTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	public int maximize() {
		logger.info("Inside maximize");
		try {
			oDriver.manage().window().maximize();
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	public int rightclick() {
		logger.info("Inside rightclick");
		try {
			Actions action = new Actions(oDriver);
			action.contextClick().build().perform();
			oTestObject.click();
		} catch (Exception e) {
			iRCTCTerminateInd = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;

	}
	
	public int closewindow() {
		logger.info("CloseWindow");
		iReturnValue = 0;
		int iFlag = 0;
		try {
			// waitForPageLoad();
			Thread.sleep(1000);

			for (String winHandle : oDriver.getWindowHandles()) {
				// String title =
				// oDriver.switchTo().window(winHandle).getTitle();

				// System.out.println(title);
				// if
				// ((title).toLowerCase().contains((sSFStepKeyword).toLowerCase())){
				iFlag = 1;
				oDriver.close();
				break;
				// }
			}
			if (iFlag == 0) {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = "Expected Window not found";
				} else {
					sOutput = sOutput + " | " + "Expected " + sSFStepKeyword
							+ "Window not found";
				}
				iReturnValue = 1;
				logger.error(sOutput);
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}


	//Swapnil P - 26-Feb-19
	public int adhoctop() throws InterruptedException {
		logger.info("Inside AdhocTop");
//		oDriver_Mob.findElement(By.xpath("(//*[@class='UIScrollView']/*[@text='Year'])[1]")).swipe("Up", 200, 500);
//		Thread.sleep(2000);
//		String sTableName ="";
//		sTableName = sSFStepKeyword;
		iReturnValue = 0;
		int iFlag = 0;
		String sMDTQry="";
		String sAmount1="",sAmount2="",sAmount3="",sAmount4="",sAmount5="",sAmount6="",sAmount7=""
				,sAmount8="" ,sAmount9 ="",sAmount10="";
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;
		int i6 = 0;
		int i7 = 0;
		int i8 = 0;
		int i9 = 0;
		int i10 = 0;
		
		try {
			ResultSet oRSQueryPS;
			
			if (sPlanID.contains("STP")) {
				sMDTQry = "select *  from "+sTableName+" where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and test_case = '"
						+ sPlanTestcaseId + "'";
			} else {
				sMDTQry = "select * from "+sTableName+" where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and test_case = '"
						+ sPlanTestcaseId + "'";
			}
			
			logger.info("sQuery=" + sMDTQry);
			oStmt = oConn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			oRSQueryPS = oStmt.executeQuery(sMDTQry);
			if (oRSQueryPS.next()) {
				
				String sAdhocTopUpYear_Input1 = oRSQueryPS.getString("AdhocTopUpYear_Input1");
				String sAdhocTopUpYear_Input2 = oRSQueryPS.getString("AdhocTopUpYear_Input2");
				String sAdhocTopUpYear_Input3 = oRSQueryPS.getString("AdhocTopUpYear_Input3");
				String sAdhocTopUpYear_Input4 = oRSQueryPS.getString("AdhocTopUpYear_Input4");
				String sAdhocTopUpYear_Input5 = oRSQueryPS.getString("AdhocTopUpYear_Input5");
				String sAdhocTopUpYear_Input6 = oRSQueryPS.getString("AdhocTopUpYear_Input6");
				String sAdhocTopUpYear_Input7 = oRSQueryPS.getString("AdhocTopUpYear_Input7");
				String sAdhocTopUpYear_Input8 = oRSQueryPS.getString("AdhocTopUpYear_Input8");
				String sAdhocTopUpYear_Input9 = oRSQueryPS.getString("AdhocTopUpYear_Input9");
				String sAdhocTopUpYear_Input10 = oRSQueryPS.getString("AdhocTopUpYear_Input10");
				
				sAmount1 = oRSQueryPS.getString("AdhocTopUpAmount_Input1");
				sAmount2 = oRSQueryPS.getString("AdhocTopUpAmount_Input2");
				sAmount3 = oRSQueryPS.getString("AdhocTopUpAmount_Input3");
				sAmount4 = oRSQueryPS.getString("AdhocTopUpAmount_Input4");
				sAmount5 = oRSQueryPS.getString("AdhocTopUpAmount_Input5");
				sAmount6 = oRSQueryPS.getString("AdhocTopUpAmount_Input6");
				sAmount7 = oRSQueryPS.getString("AdhocTopUpAmount_Input7");
				sAmount8 = oRSQueryPS.getString("AdhocTopUpAmount_Input8");
				sAmount9 = oRSQueryPS.getString("AdhocTopUpAmount_Input9");
				sAmount10 = oRSQueryPS.getString("AdhocTopUpAmount_Input10");
				
				/*try {
				i1 = Integer.parseInt(sAmount1Age);
				i2 = Integer.parseInt(sAmount2Age);
				i3 = Integer.parseInt(sAmount3Age);
				i4 = Integer.parseInt(sAmount4Age);
				i5 = Integer.parseInt(sAmount5Age);
				i6 = Integer.parseInt(sAmount6Age);
				i7 = Integer.parseInt(sAmount7Age);
				i8 = Integer.parseInt(sAmount8Age);
				i9 = Integer.parseInt(sAmount9Age);
				i10 = Integer.parseInt(sAmount10Age);
				}catch(Exception e){
					
				}*/
				if (!sAmount1.equalsIgnoreCase("")){
					int a=0;
					a = Integer.parseInt(sAdhocTopUpYear_Input1);
					i1= a;
					i1= i1+3;
					UIName="Native";
					logger.info("i1 = "+i1);
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i1+"]";
					if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					
					try {
						oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					}catch(Exception e) {
						
					}
					Thread.sleep(1000);
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount1);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount2.equalsIgnoreCase("")){
					int a1=0;
					a1 = Integer.parseInt(sAdhocTopUpYear_Input2);
					i1= a1;
					i1= i1+3;
					logger.info("i1 = "+i1);
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i1+"]";
					if(a1>18 && a1<26 || a1>43 && a1<51 || a1>68 && a1<76 || a1>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a1<9 || a1>25 && a1<34 || a1>50 && a1<59 || a1>75 && a1<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					
					try {
						oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					}catch(Exception e) {
						
					}
					
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount2);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount3.equalsIgnoreCase("")){
					int a2=0;
					a2 = Integer.parseInt(sAdhocTopUpYear_Input3);
					i3 =a2;
					i3= i3+3;
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i3+"]";
					if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					   try {
						   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					   }catch(Exception e1) {
						  
					  }
					
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount3);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e2){
					}
				}
				if (!sAmount4.equalsIgnoreCase("")){
					int a4=0;
					a4 = Integer.parseInt(sAdhocTopUpYear_Input4);
					i4=a4;
					i4= i4+3;
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i4+"]";
					if(a4>18 && a4<26 || a4>43 && a4<51 || a4>68 && a4<76 || a4>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a4<9 || a4>25 && a4<34 || a4>50 && a4<59 || a4>75 && a4<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					try {
						  oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					 }catch(Exception e1) {
						   
					}
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount4);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount5.equalsIgnoreCase("")){
					int a5=0;
					a5 = Integer.parseInt(sAdhocTopUpYear_Input5);
					i5=a5;
					i5= i5+3;
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i5+"]";
					if(a5>18 && a5<26 || a5>43 && a5<51 || a5>68 && a5<76 || a5>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a5<9 || a5>25 && a5<34 || a5>50 && a5<59 || a5>75 && a5<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					try {
						  oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					  }catch(Exception e1) {
					 }
					
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount5);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount6.equalsIgnoreCase("")){
					int a6=0;
					a6 = Integer.parseInt(sAdhocTopUpYear_Input6);
					i6=a6;
					i6= i6+3;
					
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i6+"]";
					if(a6>18 && a6<26 || a6>43 && a6<51 || a6>68 && a6<76 || a6>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a6<9 || a6>25 && a6<34 || a6>50 && a6<59 || a6>75 && a6<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					 try {
						   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					   }catch(Exception e1) {
						   
					  }
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount6);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount7.equalsIgnoreCase("")){
					int a7=0;
					a7 = Integer.parseInt(sAdhocTopUpYear_Input7);
					i7=a7;
					i7= i7+3;
					
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i7+"]";
					if(a7>18 && a7<26 || a7>43 && a7<51 || a7>68 && a7<76 || a7>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a7<9 || a7>25 && a7<34 || a7>50 && a7<59 || a7>75 && a7<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					try {
						 oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					   }catch(Exception e1) {
						   
					  }
				
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount7);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount8.equalsIgnoreCase("")){
					int a8=0;
					a8 = Integer.parseInt(sAdhocTopUpYear_Input8);
					i8=a8;
					i8= i8+3;
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i8+"]";
					if(a8>18 && a8<26 || a8>43 && a8<51 || a8>68 && a8<76 || a8>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a8<9 || a8>25 && a8<34 || a8>50 && a8<59 || a8>75 && a8<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					 try {
						   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					  }catch(Exception e1) {
						  
					  }
					
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount8);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount9.equalsIgnoreCase("")){
					int a9=0;
					a9 = Integer.parseInt(sAdhocTopUpYear_Input9);
					i9=a9;
					i9= i9+3;
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i9+"]";
					if(a9>18 && a9<26 || a9>43 && a9<51 || a9>68 && a9<76 || a9>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a9<9 || a9>25 && a9<34 || a9>50 && a9<59 || a9>75 && a9<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					   try {
						   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					   }catch(Exception e1) {
						   
					  }
					
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount9);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				if (!sAmount10.equalsIgnoreCase("")){
					int a10=0;
					a10 = Integer.parseInt(sAdhocTopUpYear_Input10);
					i10=a10;
					i10= i10+3;
					
					oTestObject1="xpath=//*[@class='TFEditCurrency']["+i10+"]";
					if(a10>18 && a10<26 || a10>43 && a10<51 || a10>68 && a10<76 || a10>93) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
					}
					if(a10<9 || a10>25 && a10<34 || a10>50 && a10<59 || a10>75 && a10<84) {
						
						logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
						oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
					}
					   try {
						   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					   }catch(Exception e1) {
						   
					  }
					
					oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount10);
					try{
						oDriver_Mob.client.closeKeyboard();
//						oDriver_Mob.device().closeKeyboard();
					}catch(Exception e){
					}
				}
				String sTempStepKeyword="";
				oDriver_Mob.device().swipe("UP", 200, 500);
				Thread.sleep(2000);
				Thread.sleep(1000);
				sTempStepKeyword = sSFStepKeyword;
				sSFStepKeyword = "Addhoc Topup 2";
				screens();
				sSFStepKeyword = sTempStepKeyword;
				Thread.sleep(1000);
				sTempStepKeyword="";
				oDriver_Mob.device().swipe("Down", 200, 500);
				Thread.sleep(2000);
				Thread.sleep(1000);
				sTempStepKeyword = sSFStepKeyword;
				sSFStepKeyword = "Addhoc Topup 3";
				screens();
				sSFStepKeyword = sTempStepKeyword;
				
				oTestObject1="xpath=//*[@text=' DONE ']";
				oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	//Swapnil P - 26-Feb-19
		public int scheduledwithdrawal() throws InterruptedException {
			logger.info("Inside scheduledwithdrawal");
//			oDriver_Mob.findElement(By.xpath("(//*[@class='UIScrollView']/*[@text='Year'])[1]")).swipe("Up", 200, 500);
//			Thread.sleep(2000);
//			String sTableName ="";
//			sTableName = sSFStepKeyword;
			iReturnValue = 0;
			int iFlag = 0;
			String sMDTQry="";
			String sAmount1="",sAmount2="",sAmount3="",sAmount4="",sAmount5="",sAmount6="",sAmount7=""
					,sAmount8="" ,sAmount9 ="",sAmount10="";
			int i1 = 0;
			int i2 = 0;
			int i3 = 0;
			int i4 = 0;
			int i5 = 0;
			int i6 = 0;
			int i7 = 0;
			int i8 = 0;
			int i9 = 0;
			int i10 = 0;
			
			try {
				ResultSet oRSQueryPS;
				
				if (sPlanID.contains("STP")) {
					sMDTQry = "select *  from "+sTableName+" where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "' and plancycleid = '"
							+ sCycleID
							+ "' and test_case = '"
							+ sPlanTestcaseId + "'";
				} else {
					sMDTQry = "select * from "+sTableName+" where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "' and plancycleid = '"
							+ sCycleID
							+ "' and test_case = '"
							+ sPlanTestcaseId + "'";
				}
				
				logger.info("sQuery=" + sMDTQry);
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				oRSQueryPS = oStmt.executeQuery(sMDTQry);
				if (oRSQueryPS.next()) {
					
					String sScheduledWithdrawalYear_Input1 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input1");
					String sScheduledWithdrawalYear_Input2 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input2");
					String sScheduledWithdrawalYear_Input3 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input3");
					String sScheduledWithdrawalYear_Input4 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input4");
					String sScheduledWithdrawalYear_Input5 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input5");
					String sScheduledWithdrawalYear_Input6 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input6");
					String sScheduledWithdrawalYear_Input7 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input7");
					String sScheduledWithdrawalYear_Input8 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input8");
					String sScheduledWithdrawalYear_Input9 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input9");
					String sScheduledWithdrawalYear_Input10 = oRSQueryPS.getString("ScheduledWithdrawalYear_Input10");
					
					sAmount1 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input1");
					sAmount2 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input2");
					sAmount3 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input3");
					sAmount4 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input4");
					sAmount5 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input5");
					sAmount6 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input6");
					sAmount7 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input7");
					sAmount8 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input8");
					sAmount9 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input9");
					sAmount10 = oRSQueryPS.getString("ScheduledWithdrawalAmount_Input10");
					
					/*try {
					i1 = Integer.parseInt(sAmount1Age);
					i2 = Integer.parseInt(sAmount2Age);
					i3 = Integer.parseInt(sAmount3Age);
					i4 = Integer.parseInt(sAmount4Age);
					i5 = Integer.parseInt(sAmount5Age);
					i6 = Integer.parseInt(sAmount6Age);
					i7 = Integer.parseInt(sAmount7Age);
					i8 = Integer.parseInt(sAmount8Age);
					i9 = Integer.parseInt(sAmount9Age);
					i10 = Integer.parseInt(sAmount10Age);
					}catch(Exception e){
						
					}*/
					if (!sAmount1.equalsIgnoreCase("")){
						int a1=0;
						a1 = Integer.parseInt(sScheduledWithdrawalYear_Input1);
						i1=a1;
						i1= i1+3;
						UIName="Native";
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i1+"]";
						if(a1>18 && a1<26 || a1>43 && a1<51 || a1>68 && a1<76 || a1>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-18)+"]", 0, "Up", 400, 500);
						}
						if(a1>25 && a1<34 || a1>50 && a1<59 || a1>75 && a1<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							  
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount1);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount2.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input2);
						i2=a2;
						i2= i2+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i2+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i2-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i2-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i2-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i2-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							   
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount2);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount3.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input3);
						i3 = a2;
						i3= i3+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i3+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i3-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i3-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i3-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i3-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							 
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount3);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount4.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input4);
						i4=a2;
						i4= i4+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i4+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i4-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i4-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i4-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i4-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							   
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount4);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount5.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input5);
						i5=a2;
						i5= i5+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i5+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i5-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i5-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i5-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i5-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							  
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount5);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount6.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input6);
						i6=a2;
						i6= i6+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i6+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i6-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i6-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i6-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i6-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							   
						   }
					
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount6);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount7.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input7);
						i7=a2;
						i7= i7+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i7+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i7-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i7-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i7-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i7-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							   
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount7);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount8.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input8);
						i8=a2;
						i8= i8+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i8+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i8-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i8-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i1-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i8-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							   
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount8);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount9.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input9);
						i9=a2;
						i9= i9+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i9+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i9-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i9-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i9-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i9-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							  
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount9);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					if (!sAmount10.equalsIgnoreCase("")){
						int a2=0;
						a2 = Integer.parseInt(sScheduledWithdrawalYear_Input10);
						i10=a2;
						i10= i10+3;
						oTestObject1="xpath=//*[@class='TFEditCurrency']["+i10+"]";
						if(a2>18 && a2<26 || a2>43 && a2<51 || a2>68 && a2<76 || a2>93) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i10-18)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i10-18)+"]", 0, "Up", 400, 500);
						}
						if(a2<9 || a2>25 && a2<34 || a2>50 && a2<59 || a2>75 && a2<84) {
							
							logger.info("xpath=//*[@class='TFEditCurrency']["+(i10-12)+"]");
							oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFEditCurrency']["+(i10-12)+"]", 0, "Down", 400, 500);
						}
						   try {
							   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						   }catch(Exception e1) {
							  
						   }
						
						oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount10);
						try{
							oDriver_Mob.client.closeKeyboard();
//							oDriver_Mob.device().closeKeyboard();
						}catch(Exception e){
						}
					}
					String sTempStepKeyword="";
					oDriver_Mob.device().swipe("UP", 200, 500);
					Thread.sleep(2000);
					sTempStepKeyword = sSFStepKeyword;
					sSFStepKeyword = "Withdrawal";
					screens();
					sSFStepKeyword = sTempStepKeyword;
					
					Thread.sleep(1000);
					
					sTempStepKeyword="";
					oDriver_Mob.device().swipe("Down", 200, 500);
					Thread.sleep(2000);
					sTempStepKeyword = sSFStepKeyword;
					sSFStepKeyword = "Withdrawal 2";
					screens();
					sSFStepKeyword = sTempStepKeyword;
					
					Thread.sleep(1000);
					oTestObject1="xpath=//*[@text=' DONE ']";
					oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				try {
					iRCTCTerminateInd = 1;
					if (sOutput.equals("")) {
						sOutput = e.getMessage().split("\\n")[0];
					} else {
						sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
					}
					iReturnValue = 1;
					logger.error(e.getMessage());
				} catch (Exception e1) {

				}
			}
			return iReturnValue;

		}

		

		//Swapnil P - 26-Feb-19
			public int vitality_old() throws InterruptedException {
				logger.info("Inside  vitality");
//				oDriver_Mob.findElement(By.xpath("(//*[@class='UIScrollView']/*[@text='Year'])[1]")).swipe("Up", 200, 500);
//				Thread.sleep(2000);
//				String sTableName ="";
//				sTableName = sSFStepKeyword;
				iReturnValue = 0;
				int iFlag = 0;
				String sMDTQry="";
				String sAmount1="",sAmount2="",sAmount3="",sAmount4="",sAmount5="",sAmount6="",sAmount7=""
						,sAmount8="" ,sAmount9 ="",sAmount10="";
				int i1 = 0;
				int i2 = 0;
				int i3 = 0;
				int i4 = 0;
				int i5 = 0;
				int i6 = 0;
				int i7 = 0;
				int i8 = 0;
				int i9 = 0;
				int i10 = 0;
				
				try {
					ResultSet oRSQueryPS;
					
					if (sPlanID.contains("STP")) {
						sMDTQry = "select *  from "+sTableName+" where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId + "'";
					} else {
						sMDTQry = "select * from "+sTableName+" where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId + "'";
					}
					
					logger.info("sQuery=" + sMDTQry);
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					oRSQueryPS = oStmt.executeQuery(sMDTQry);
					if (oRSQueryPS.next()) {
						
						String sYear_Input1 = oRSQueryPS.getString("VitalityYear_Input1");
						String sYear_Input2 = oRSQueryPS.getString("VitalityYear_Input2");
						String sYear_Input3 = oRSQueryPS.getString("VitalityYear_Input3");
						String sYear_Input4 = oRSQueryPS.getString("VitalityYear_Input4");
						String sYear_Input5 = oRSQueryPS.getString("VitalityYear_Input5");
						String sYear_Input6 = oRSQueryPS.getString("VitalityYear_Input6");
						String sYear_Input7 = oRSQueryPS.getString("VitalityYear_Input7");
						String sYear_Input8 = oRSQueryPS.getString("VitalityYear_Input8");
						String sYear_Input9 = oRSQueryPS.getString("VitalityYear_Input9");
						String sYear_Input10 = oRSQueryPS.getString("VitalityYear_Input10");
						
						sAmount1 = oRSQueryPS.getString("VitalityStatus_Input1");
						sAmount2 = oRSQueryPS.getString("VitalityStatus_Input2");
						sAmount3 = oRSQueryPS.getString("VitalityStatus_Input3");
						sAmount4 = oRSQueryPS.getString("VitalityStatus_Input4");
						sAmount5 = oRSQueryPS.getString("VitalityStatus_Input5");
						sAmount6 = oRSQueryPS.getString("VitalityStatus_Input6");
						sAmount7 = oRSQueryPS.getString("VitalityStatus_Input7");
						sAmount8 = oRSQueryPS.getString("VitalityStatus_Input8");
						sAmount9 = oRSQueryPS.getString("VitalityStatus_Input9");
						sAmount10 = oRSQueryPS.getString("VitalityStatus_Input10");
						
						/*try {
						i1 = Integer.parseInt(sAmount1Age);
						i2 = Integer.parseInt(sAmount2Age);
						i3 = Integer.parseInt(sAmount3Age);
						i4 = Integer.parseInt(sAmount4Age);
						i5 = Integer.parseInt(sAmount5Age);
						i6 = Integer.parseInt(sAmount6Age);
						i7 = Integer.parseInt(sAmount7Age);
						i8 = Integer.parseInt(sAmount8Age);
						i9 = Integer.parseInt(sAmount9Age);
						i10 = Integer.parseInt(sAmount10Age);
						}catch(Exception e){
							
						}*/
						if (!sAmount1.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input1);
							i1=a;
							i1= i1+1;
							UIName="Native";
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i1+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i1-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i1-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i1-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i1-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount1+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
//							oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount1);
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount2.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input2);
							i2 = a;
							i2= i2+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i2+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i2-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i2-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i2-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i2-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount2+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
		
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount3.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input3);
							i3 = a;
							i3= i3+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i3+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i3-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i3-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i3-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i3-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								   
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount3+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount4.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input4);
							i4 = a;
							i4= i4+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i4+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i4-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i4-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i4-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i4-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount4+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount5.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input5);
							i5 = a;
							i5= i5+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i5+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i5-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i5-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i5-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i5-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount5+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount6.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input6);
							i6 = a;
							i6= i6+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i6+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i6-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i6-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFEditCurrency']["+(i6-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i6-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount6+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(2000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount7.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input7);
							i7 = a;
							i7= i7+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i7+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i7-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i7-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i7-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i7-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								   
							   }
							oTestObject1="xpath=//*[@text='"+sAmount7+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount8.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input8);
							i8 = a;
							i8= i8+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i8+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i8-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i8-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i8-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i8-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								 
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount8+"' and @top='false' and @class='UITableViewCell']";
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount9.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input9);
							i9 = a;
							i9= i9+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i9+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i9-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i9-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i9-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i9-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								   
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount9+"' and @top='false' and @class='UITableViewCell']";
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount10.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input10);
							i9 = a;
							i10= i10+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i10+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i10-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i10-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i10-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i10-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount10+"' and @top='false' and @class='UITableViewCell']";
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
								//oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						Thread.sleep(1000);
						String sTempStepKeyword="";
						Thread.sleep(1000);
						sTempStepKeyword = sSFStepKeyword;
						sSFStepKeyword = "Vitality";
						screens();
						sSFStepKeyword = sTempStepKeyword;
						Thread.sleep(1000);
						oTestObject1="xpath=//*[@text=' DONE ']";
						oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					try {
						iRCTCTerminateInd = 1;
						if (sOutput.equals("")) {
							sOutput = e.getMessage().split("\\n")[0];
						} else {
							sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
						}
						iReturnValue = 1;
						logger.error(e.getMessage());
					} catch (Exception e1) {

					}
				}
				return iReturnValue;

			}
			
			//Sushant_Yadav 03-09-2019 : Done the Channges for Vitality horital to horizontal logic
			public int vitality() throws InterruptedException
			{
				logger.info("Inside  vitality");
//				oDriver_Mob.findElement(By.xpath("(//*[@class='UIScrollView']/*[@text='Year'])[1]")).swipe("Up", 200, 500);
//				Thread.sleep(2000);
//				String sTableName ="";
//				sTableName = sSFStepKeyword;
				iReturnValue = 0;
				int iFlag = 0;
				String sMDTQry="";
				String sAmount1="",sAmount2="",sAmount3="",sAmount4="",sAmount5="",sAmount6="",sAmount7=""
						,sAmount8="" ,sAmount9 ="",sAmount10="";
				int i1 = 0;
				int i2 = 0;
				int i3 = 0;
				int i4 = 0;
				int i5 = 0;
				int i6 = 0;
				int i7 = 0;
				int i8 = 0;
				int i9 = 0;
				int i10 = 0;
				
				try {
					ResultSet oRSQueryPS;
					
					if (sPlanID.contains("STP")) {
						sMDTQry = "select *  from "+sTableName+" where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId + "'";
					} else {
						sMDTQry = "select * from "+sTableName+" where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId + "'";
					}
					
					logger.info("sQuery=" + sMDTQry);
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					oRSQueryPS = oStmt.executeQuery(sMDTQry);
					while(oRSQueryPS.next()) {
						
						String sYear_Input1 = oRSQueryPS.getString("VitalityYear_Input1");						
						sAmount1 = oRSQueryPS.getString("VitalityStatus_Input1");
						
						if (!sAmount1.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input1);
							i1=a;
							i1= i1+1;
							UIName="Native";
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i1+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i1-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i1-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i1-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i1-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount1+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(500);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(500);
//							oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount1);
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
					}
					Thread.sleep(200);
					String sTempStepKeyword="";
					Thread.sleep(200);
					sTempStepKeyword = sSFStepKeyword;
					sSFStepKeyword = "Vitality";
					screens();
					sSFStepKeyword = sTempStepKeyword;
					Thread.sleep(200);
					oTestObject1="xpath=//*[@text=' DONE ']";
					oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
					Thread.sleep(1000);
				} catch (Exception e) {
					try {
						iRCTCTerminateInd = 1;
						if (sOutput.equals("")) {
							sOutput = e.getMessage().split("\\n")[0];
						} else {
							sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
						}
						iReturnValue = 1;
						logger.error(e.getMessage());
					} catch (Exception e1) {

					}
				}
				return iReturnValue;
			}
			
			
			public int vitality2() throws InterruptedException {
				logger.info("Inside  vitality");
//				oDriver_Mob.findElement(By.xpath("(//*[@class='UIScrollView']/*[@text='Year'])[1]")).swipe("Up", 200, 500);
//				Thread.sleep(2000);
//				String sTableName ="";
//				sTableName = sSFStepKeyword;
				iReturnValue = 0;
				int iFlag = 0;
				String sMDTQry="";
				String sAmount1="",sAmount2="",sAmount3="",sAmount4="",sAmount5="",sAmount6="",sAmount7=""
						,sAmount8="" ,sAmount9 ="",sAmount10="";
				int i1 = 0;
				int i2 = 0;
				int i3 = 0;
				int i4 = 0;
				int i5 = 0;
				int i6 = 0;
				int i7 = 0;
				int i8 = 0;
				int i9 = 0;
				int i10 = 0;
				
				try {
					ResultSet oRSQueryPS;
					
					if (sPlanID.contains("STP")) {
						sMDTQry = "select *  from "+sTableName+" where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId + "'";
					} else {
						sMDTQry = "select * from "+sTableName+" where planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId + "'";
					}
					
					logger.info("sQuery=" + sMDTQry);
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					oRSQueryPS = oStmt.executeQuery(sMDTQry);
					if (oRSQueryPS.next()) {
						
						String sYear_Input1 = oRSQueryPS.getString("PI2_VitalityYear_Input1");
						String sYear_Input2 = oRSQueryPS.getString("PI2_VitalityYear_Input2");
						String sYear_Input3 = oRSQueryPS.getString("PI2_VitalityYear_Input3");
						String sYear_Input4 = oRSQueryPS.getString("PI2_VitalityYear_Input4");
						String sYear_Input5 = oRSQueryPS.getString("PI2_VitalityYear_Input5");
						String sYear_Input6 = oRSQueryPS.getString("PI2_VitalityYear_Input6");
						String sYear_Input7 = oRSQueryPS.getString("PI2_VitalityYear_Input7");
						String sYear_Input8 = oRSQueryPS.getString("PI2_VitalityYear_Input8");
						String sYear_Input9 = oRSQueryPS.getString("PI2_VitalityYear_Input9");
						String sYear_Input10 = oRSQueryPS.getString("PI2_VitalityYear_Input10");
						
						sAmount1 = oRSQueryPS.getString("PI2_VitalityStatus_Input1");
						sAmount2 = oRSQueryPS.getString("PI2_VitalityStatus_Input2");
						sAmount3 = oRSQueryPS.getString("PI2_VitalityStatus_Input3");
						sAmount4 = oRSQueryPS.getString("PI2_VitalityStatus_Input4");
						sAmount5 = oRSQueryPS.getString("PI2_VitalityStatus_Input5");
						sAmount6 = oRSQueryPS.getString("PI2_VitalityStatus_Input6");
						sAmount7 = oRSQueryPS.getString("PI2_VitalityStatus_Input7");
						sAmount8 = oRSQueryPS.getString("PI2_VitalityStatus_Input8");
						sAmount9 = oRSQueryPS.getString("PI2_VitalityStatus_Input9");
						sAmount10 = oRSQueryPS.getString("PI2_VitalityStatus_Input10");
						
						/*try {
						i1 = Integer.parseInt(sAmount1Age);
						i2 = Integer.parseInt(sAmount2Age);
						i3 = Integer.parseInt(sAmount3Age);
						i4 = Integer.parseInt(sAmount4Age);
						i5 = Integer.parseInt(sAmount5Age);
						i6 = Integer.parseInt(sAmount6Age);
						i7 = Integer.parseInt(sAmount7Age);
						i8 = Integer.parseInt(sAmount8Age);
						i9 = Integer.parseInt(sAmount9Age);
						i10 = Integer.parseInt(sAmount10Age);
						}catch(Exception e){
							
						}*/
						if (!sAmount1.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input1);
							i1=a;
							i1= i1+1;
							UIName="Native";
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i1+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i1-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i1-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i1-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i1-12)+"]", 0, "Down", 400, 500);
								Thread.sleep(500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount1+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
//							oDriver_Mob.client.elementSendText(UIName, oTestObject1, 0, sAmount1);
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount2.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input2);
							i2 = a;
							i2= i2+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i2+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i2-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i2-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i2-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i2-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount2+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
		
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount3.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input3);
							i3 = a;
							i3= i3+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i3+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i3-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i3-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i3-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i3-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								   
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount3+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount4.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input4);
							i4 = a;
							i4= i4+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i4+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i4-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i4-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i4-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i4-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount4+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount5.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input5);
							i5 = a;
							i5= i5+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i5+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i5-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i5-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i5-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i5-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount5+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount6.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input6);
							i6 = a;
							i6= i6+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i6+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i6-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i6-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFEditCurrency']["+(i6-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i6-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount6+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(2000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount7.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input7);
							i7 = a;
							i7= i7+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i7+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i7-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i7-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i7-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i7-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								   
							   }
							oTestObject1="xpath=//*[@text='"+sAmount7+"' and @top='false' and @class='UITableViewCell']";
							Thread.sleep(1000);
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount8.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input8);
							i8 = a;
							i8= i8+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i8+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i8-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i8-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i8-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i8-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								 
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount8+"' and @top='false' and @class='UITableViewCell']";
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount9.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input9);
							i9 = a;
							i9= i9+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i9+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i9-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i9-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i9-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i9-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								   
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount9+"' and @top='false' and @class='UITableViewCell']";
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
//								oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						if (!sAmount10.equalsIgnoreCase("")){
							int a=0;
							a = Integer.parseInt(sYear_Input10);
							i9 = a;
							i10= i10+1;
							oTestObject1="xpath=//*[@class='TFComboBox2']["+i10+"]";
							if(a>18 && a<26 || a>43 && a<51 || a>68 && a<76 || a>93) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i10-18)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i10-18)+"]", 0, "Up", 400, 500);
							}
							if(a<9 || a>25 && a<34 || a>50 && a<59 || a>75 && a<84) {
								
								logger.info("xpath=//*[@class='TFComboBox2']["+(i10-12)+"]");
								oDriver_Mob.client.elementSwipe("NATIVE", "xpath=//*[@class='TFComboBox2']["+(i10-12)+"]", 0, "Down", 400, 500);
							}
							   try {
								   oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							   }catch(Exception e1) {
								  
							   }
							
							oTestObject1="xpath=//*[@text='"+sAmount10+"' and @top='false' and @class='UITableViewCell']";
							oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
							Thread.sleep(1000);
							
							try{
								//oDriver_Mob.client.closeKeyboard();
//								oDriver_Mob.device().closeKeyboard();
							}catch(Exception e){
							}
						}
						Thread.sleep(500);
						String sTempStepKeyword="";
						Thread.sleep(500);
						sTempStepKeyword = sSFStepKeyword;
						sSFStepKeyword = "Vitality PI 2 Screen";
						screens();
						sSFStepKeyword = sTempStepKeyword;
						Thread.sleep(500);
						oTestObject1="xpath=//*[@text=' DONE ']";
						oDriver_Mob.client.click(UIName,oTestObject1, 0, 1);
						Thread.sleep(1000);
					}
				} catch (Exception e) {
					try {
						iRCTCTerminateInd = 1;
						if (sOutput.equals("")) {
							sOutput = e.getMessage().split("\\n")[0];
						} else {
							sOutput = sOutput + " | " +"\n"+ e.getMessage().split("\\n")[0];
						}
						iReturnValue = 1;
						logger.error(e.getMessage());
					} catch (Exception e1) {

					}
				}
				return iReturnValue;

			}		

	
	public int comparedbfromdb() {
		logger.info("Inside CompareDBFromDB");
		iTerminateInd = 0;
		String sMainSFKeyword = sSFStepKeyword;
		String sCompTable = "QTP_CompareResult";
		try {
			ResultSet oRSQuery = null;
			String sQuery = null;
			String sRCTCRunID;
			if (sSFStepKeyword.contains("~~")) {
				sCompTable = sSFStepKeyword.split("~~")[0];
				sSFStepKeyword = sSFStepKeyword.split("~~")[1];
			}
			String[] oArrFields = sSFStepKeyword.split(";;");
			for (int iArrFields = 0; oArrFields.length > iArrFields; iArrFields = iArrFields + 1) {
				String[] oArrChildFields = oArrFields[iArrFields].split(":");
				String sExpected = "", sActual = "", sCompareResult = "", sField = oArrChildFields[1];
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (sRCTestcaseID == null || sRCTestcaseID == "") {
					sQuery = "Select ActualValue From QTP_ActualResult Where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "'  and plancycleid= '"
							+ sCycleID
							+ "' and MainTestCaseID = '"
							+ sPlanTestcaseId
							+ "' and TestCaseID = '"
							+ "" //Swapnil P -14-Apr-19
							+ "' And Field = '"
							+ oArrChildFields[1]
									+ "' and device = '" + sMobDeviceName // and RunID =
									// '"
									// + sFlowCode
									+ "'"; // sRCTCRunID
					logger.info(sQuery);
					oRSQuery = oStmt.executeQuery(sQuery);
					if (oRSQuery.next()) {
						sActual = oRSQuery.getString("ActualValue");
					}
					oRSQuery.close();
					sQuery = "Select ExpectedValue From QTP_ExpectedResult Where TestCaseId = '"
							+ sPlanTestcaseId
							+ "' and Field = '"
							+ oArrChildFields[0]
									// + "' and RunId = '"
									// + sFlowCode
									+ "'";
					logger.info(sQuery);
					oRSQuery = oStmt.executeQuery(sQuery);
					if (oRSQuery.next()) {
						sExpected = oRSQuery.getString("ExpectedValue");
					}
					oRSQuery.close();
				} else {
					sQuery = "Select ActualValue From QTP_ActualResult Where planid = '"
							+ sPlanID
							+ "' and planreleaseid = '"
							+ sReleaseID
							+ "'  and plancycleid= '"
							+ sCycleID
							+ "' and MainTestCaseID = '"
							+ sPlanTestcaseId
							+ "' And TestCaseID = '"
							+ sRCTestcaseID
							+ "' and Field = '"
							+ oArrChildFields[1]
									+ "' and device = '" + sMobDeviceName + "'";// and
					// RunID
					// = '"
					// + sRCTCflowid +"'";
					logger.info(sQuery);
					oRSQuery = oStmt.executeQuery(sQuery);
					if (oRSQuery.next()) {
						sActual = oRSQuery.getString("ActualValue").trim();
					}
					oRSQuery.close();
					sQuery = "Select ExpectedValue From QTP_ExpectedResult Where TestCaseId = '"
							+ sRCTestcaseID
							+ "' and Field = '"
							+ oArrChildFields[0]
									// + "' and RunId = '"
									// + sFlowCode
									+ "'";
					logger.info(sQuery);
					oRSQuery = oStmt.executeQuery(sQuery);
					if (oRSQuery.next()) {
						sExpected = oRSQuery.getString("ExpectedValue").trim();
					}
					oRSQuery.close();
				}

				if (oArrChildFields.length == 3) {
					if (oArrChildFields[2].equalsIgnoreCase("endswith")) {
						if (sExpected.equals("")) {
							if (sActual.equals("")) {
								sCompareResult = "Pass";
							} else {
								sCompareResult = "Fail";
							}
						} else {
							try {
								if (sExpected.endsWith(sActual
										.substring(sActual.length() - 4))) {
									sCompareResult = "Pass";
								} else {
									// if (!sExpected.equalsIgnoreCase("")) {
									sCompareResult = "Fail";
									// }
								}
							} catch (Exception ex) {
								sCompareResult = "Fail";
							}
						}
					} else if (oArrChildFields[2]
							.equalsIgnoreCase("startswith")) {
						if (sExpected.equals("")) {
							if (sActual.equals("")) {
								sCompareResult = "Pass";
							} else {
								sCompareResult = "Fail";
							}
						} else {
							try {
								if (sExpected.startsWith(sActual
										.substring(0, 4))) {
									sCompareResult = "Pass";
								} else {
									// if (!sExpected.equalsIgnoreCase("")) {
									sCompareResult = "Fail";
									// }
								}
							} catch (Exception ex) {
								sCompareResult = "Fail";
							}
						}
					}
				} else {
					sExpected = (sExpected.trim()).replace(",", "");
					sActual = (sActual.trim()).replace(",", "");
					if (sExpected.equalsIgnoreCase(sActual)) {
						sCompareResult = "Pass";
					} else {
						// if (!sExpected.equalsIgnoreCase("")) {
						sCompareResult = "Fail";
						// }
					}
				}
				logger.info("sCompareResult=" + sCompareResult);
				if (!(sCompareResult.equals(""))) {
					if (!(sExpected.equals("") && sActual.equals(""))) {
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery=" + "insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sPlanTestcaseId
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ "','" + sActual + "','" + sCompareResult
									+ "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode
							// +
							// "')");
							oStmt.executeUpdate("insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype"// RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sPlanTestcaseId
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ "','" + sActual + "','" + sCompareResult
									+ "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode
							// +
							// "')");
						} else {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery=" + "insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sRCTestcaseID
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ "','" + sActual + "','" + sCompareResult
									+ "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode
							// +
							// "')");
							oStmt.executeUpdate("insert into "
									+ sCompTable
									+ " (planid,planreleaseid,plancycleid,Module,SubModule,MainTestCaseID,TestCaseID,ScenarioID,TCID,Field,ExpectedValue,ActualValue,CompareResult,device,testtype" // RunID
									+ ") Values" + "('" + sPlanID + "','"
									+ sReleaseID + "','" + sCycleID + "','"
									+ sModule + "','" + sSubModule + "','"
									+ sPlanTestcaseId + "','" + sRCTestcaseID
									+ "','" + sScenarioId + "','" + sTCID
									+ "','" + sField + "','" + sExpected
									+ "','" + sActual + "','" + sCompareResult
									+ "','" + sMobDeviceName + "','"
									+ sTestType + "')"); // sFlowCode
							// +
							// "')");
						}
					}
				}
			}
		} catch (Exception e) {
			try {
				 iTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		sSFStepKeyword = sMainSFKeyword;
		return iTerminateInd;
	}

	public void FunctionCalld(String DataType) {
		logger.info("Inside  FunctionCall");
		try {
			switch (sSFStepsDesc.toUpperCase()) {
			case "FETCHDATA":
				oGlobalMap.clear();
				if (iTerminateInd == 0) {
					executequery(DataType);
				}
				if (iExecuteQueryInd == 1) {
					iExecuteQueryInd = 0;
					sStatus = "Fail";
					sOutput = "Data or Flow_Code For The Selected Modular TestCase Is Not In The Data Container";
					logger.info(sOutput);
					// iTerminateInd = 1;
					iReturnValue = 1;

				}
				break;
			case "INPUTDATA":
				if (iTerminateInd == 0) {
					iReturnValue = inputdata();
				}
				break;
			case "NAVIGATE":
				if (iTerminateInd == 0) {
					iReturnValue = navigate();
				}
				break;
			case "NAVIGATEURL":
				if (iTerminateInd == 0) {
					iReturnValue = navigateurl();
				}
				break;
			case "UPDATEDBFROMAPP":
				if (iTerminateInd == 0) {
					iReturnValue = updatedbfromapp();
				}
				break;
			case "UPDATEDBFROMDB":
				if (iTerminateInd == 0) {
					iReturnValue = updatedbfromdb();
				}
				break;
			case "DELAY":
				if (iTerminateInd == 0) {
					iReturnValue = delay();
				}
				break;
			case "CALLAPI":
				if (iTerminateInd == 0) {
					// iReturnValue = callapi();
				}
				break;
			case "SCREENS":
				if (iTerminateInd == 0) {
					iReturnValue = screens();
				}
				break;
			case "CAPTUREERROR":
				if (iTerminateInd == 0) {
					iReturnValue = captureerror();
				}
				break;
			case "INPUTDATAINTABLE":
				if (iTerminateInd == 0) {
					// iReturnValue = inputdataintable();
				}
				break;
			case "UPDATERIDERDATA":
				if (iTerminateInd == 0) {
					// iReturnValue = UpdateRiderData();
				}
				break;

			case "WAITTILLEXIST":
				if (iTerminateInd == 0) {
					iReturnValue = waittillexist();
				}
				break;
			case "SAVEPDF":
				if (iTerminateInd == 0) {
					iReturnValue = savepdf();
				}
				break;
			case "COMPAREDBFROMDB":
				if (iTerminateInd == 0) {
					iReturnValue = comparedbfromdb();
				}
				break;
			case "WRITEOUTPUT":
				if (iTerminateInd == 0) {
					iReturnValue = writeoutput();
				}
				break;
			case "UPDATEILLUSRATIONDETAILS":
				if (iTerminateInd == 0) {
					iReturnValue = updateillusrationdetails();
				}
				break;
			case "SUBSCREENHANDLE":
				if (iTerminateInd == 0) {
					// iReturnValue = subscreenhandle();
				}
				break;
			case "USRATIONDETAILS":
				if (iTerminateInd == 0) {
					iReturnValue = compareillusrationdetails();
				}
				break;
			case "LINKHANDLE":
				if (iTerminateInd == 0) {
					// iReturnValue = LinkHandle();
				}
				break;
			case "TABHANDLE":
				if (iTerminateInd == 0) {
					// iReturnValue = TabHandle();
				}
				break;
			case "INPUTDATE":
				if (iTerminateInd == 0) {
					iReturnValue = inputdate();
				}
				break;
			case "HANDLEALERT":
				if (iTerminateInd == 0) {
					iReturnValue = handlealert();
				}
				break;
			case "SELECTFROMLOV":
				if (iTerminateInd == 0) {
					// iReturnValue = SelectFromLOV();
				}
				break;
			case "STORERIDERDETAIL":
				if (iTerminateInd == 0) {
					// iReturnValue = StoreRiderDetail();
				}
				break;
			case "STORECLIENTDETAIL":
				if (iTerminateInd == 0) {
					// iReturnValue = StoreClientDetail();
				}
				break;
			case "CHECKLOV":
				if (iTerminateInd == 0) {
					// iReturnValue = CheckLOV();
				}
				break;
			case "IFMODULAR":
				if (iTerminateInd == 0) {
					// iReturnValue = IfModular();
				}
				break;
			case "IFE2E":
				if (iTerminateInd == 0) {
					// iReturnValue = IfE2E();
				}
				break;
				// Swapnil Parab updated on 25-07-2017
			case "ACKNOWLEDGEMENT":
				if (iTerminateInd == 0) {
					// iReturnValue = Acknowledgement();
				}
				break;
			case "COMPAREILLUSRATIONDETAILS":
				if (iTerminateInd == 0) {
					iReturnValue = compareillusrationdetails();
				}
				break;
			case "UPDATEDATAFROMAPP":
				if (iTerminateInd == 0) {
					// iReturnValue = updatedatafromapp();
				}
				break;
			case "ADDPOLICYNO":
				if (iTerminateInd == 0) {
					// iReturnValue = AddPolicyNo();
				}
				break;
			case "WAITFOROBJECT":
				if (iTerminateInd == 0) {
					iReturnValue = waitforobject();
				}
				break;
			case "ISAVAILABLE":
				if (iTerminateInd == 0) {
					iReturnValue = isavailable();
				}
				break;
			case "DYNAMICWAIT":
				if (iTerminateInd == 0) {
					iReturnValue = dynamicwait();
				}
				break;
			case "SWITCHTOWINDOW":
				if (iTerminateInd == 0) {
					iReturnValue = switchtowindow();
				}
				break;
			case "SWITCHTOTAB":
				if (iTerminateInd == 0) {
					// iReturnValue = switchtotab();
				}
				break;
			case "UPDATEEXPECTEDRESULTFROMDB":
				if (iTerminateInd == 0) {
					iReturnValue = updateexpectedresultfromdb();
				}
				break;
			case "UPDATEACTUALRESULTFROMDB":
				if (iTerminateInd == 0) {
					iReturnValue = updateactualresultfromdb();
				}
				break;
			case "SCROLL":
				if (iTerminateInd == 0) {
					iReturnValue = scrollintoview();
				}
				break;
			case "SUBPOPUPACTION":
				if (iTerminateInd == 0) {
					iReturnValue = subpopupaction();
				}
				break;
			case "UPLOADATTACHMENT":
				if (iTerminateInd == 0) {
					iReturnValue = uploadattachment();
				}
				break;
			case "IFOBJECTEXISTS":
				if (iTerminateInd == 0) {
					iReturnValue = ifobjectexists();
				}
				break;
			case "SWITCHTOFRAME":
				if (iTerminateInd == 0) {
					iReturnValue = switchtoframe();
				}
				break;
			case "WAITTILLDATAEXIST":
				if (iTerminateInd == 0) {
					iReturnValue = waittilldataexist();
				}
				break;
			case "CAPTUREFRAMEERROR":
				if (iTerminateInd == 0) {
					iReturnValue = captureframeerror();
				}
				break;
			case "SCROLLINTOVIEW":
				if (iTerminateInd == 0) {
					iReturnValue = scrollintoview();
				}
				break;
			case "CLOSEWINDOW":
				if (iTerminateInd == 0) {
					iReturnValue = closewindow();
				}
				break;

			case "REFRESH":
				if (iTerminateInd == 0) {
					iReturnValue = refresh();
				}
				break;
			case "PAGEDOWN":
				if (iTerminateInd == 0) {
					iReturnValue = pagedown();
				}
				break;

			case "SWITCHTOFRAME1":
				if (iTerminateInd == 0) {
					iReturnValue = switchtoframe1();
				}
				break;
			case "SEARCHTEMPLATE":
				if (iTerminateInd == 0) {
					// iReturnValue = searchtemplate();
				}
				break;
			case "SEARCHPARENT":
				if (iTerminateInd == 0) {
					// iReturnValue = searchparent();
				}
				break;

			case "IFOBJECTNOTEXISTS":
				if (iTerminateInd == 0) {
					iReturnValue = ifobjectnotexists();
				}
				break;
			case "SEARCHAPPNUM":
				if (iTerminateInd == 0) {
					// iReturnValue = SearchAppNum();
				}
				break;
			case "MAXIMIZE":
				if (iTerminateInd == 0) {
					iReturnValue = maximize();
				}
				break;
			case "SCROLLRIGHT":
				if (iTerminateInd == 0) {
					// iReturnValue = scrollright();
				}
				break;
			case "VIALEVELS":
				if (iTerminateInd == 0) {
					// iReturnValue = Vialevels();
				}
				break;
			case "SCROLLBAR":
				if (iTerminateInd == 0) {
					// iReturnValue = scrollbar();
				}
				break;
			case "MODES":
				if (iTerminateInd == 0) {
					// iReturnValue = Modes();
				}
				break;
			case "UPDATEUSERNAME":
				if (iTerminateInd == 0) {
					// iReturnValue = updateusername();
				}
				break;
			case "SEARCHAPPNUM1":
				if (iTerminateInd == 0) {
					// iReturnValue = SearchAppNum1();
				}
				break;
			case "SEARCHTICKET":
				if (iTerminateInd == 0) {
					// iReturnValue = SearchTicket();
				}
				break;
			case "PAGEUP":
				if (iTerminateInd == 0) {
					iReturnValue = pageup();
				}
				break;
			case "DYNAMICSEARCH":
				if (iTerminateInd == 0) {
					// iReturnValue = dynamicsearch();
				}
				break;
			case "COPYOFFILE":
				if (iTerminateInd == 0) {
					iReturnValue = copyoffile();
				}
				break;
			case "SEARCHATTACHMENT":
				if (iTerminateInd == 0) {
					// iReturnValue = searchattachment();
				}
				break;
			case "FETCHFROMLOCALDB":
				if (iTerminateInd == 0) {
					iReturnValue = fetchfromlocaldb();
				}
				break;
				// Swapnil Parab updated on 05-08-2017
			case "DATEPICKER":
				if (iTerminateInd == 0) {
					// iReturnValue = datepicker();
				}
				break;
			case "CALLSF":
				if (iTerminateInd == 0) {
					iReturnValue = callsf();
				}
				break;
			case "EXITSF":
				if (iTerminateInd == 0) {
					iReturnValue = exitsf();
				}
				break;
			case "RIGHTCLICK":
				if (iTerminateInd == 0) {
					iReturnValue = rightclick();
				}
				break;
			case "READDATAFROMPDF":
				if (iTerminateInd == 0) {
					iReturnValue = readdatafrompdf();
				}
				break;
			case "READCONTENTFROMPDF":
				if (iTerminateInd == 0) {
					// iReturnValue = readcontentfrompdf();
				}
				break;

			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
	}
	//Swapnil Parab - 13-May-19
	  public int callxaml() throws SQLException {
		  logger.info("Inside callxaml");
		  oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		  String sQuery21 = "select * from iPos_Esubmission where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and test_case = '"
					+ sPlanTestcaseId
					+ "'";
		  
			logger.info(sQuery21);
			ResultSet oRSQuery21 = oStmt.executeQuery(sQuery21);
//			String sMachineId="";
			if (oRSQuery21.next()) {
				sIntegrationFlag=oRSQuery21.getString("endtoend_flag");
			}
		  
		  if(sIntegrationFlag.equalsIgnoreCase("Y")) {	
		  try {
			    sScrenCnt = String.format("%05d", iScreenNum);
				String sIDSFStepKeyword = sSFStepKeyword;
//				createtextfile();
//				sPolicyNum="7002842154";
				
				//Sushant Yadav : 24-06-2019 : Create object to update the script path and screenshot path to run script as per cmd command prompt
				String sParameters="",sParameters1="";
				sParameters = sArgs+"`Integration";
			    sParameters1 = sParameters.replace("\\", "/");
				logger.info("Updated sArgs :"+ sParameters1);
			    
				String sParameters2[] =  sParameters1.split("\\^");
			    
				logger.info("sArgsUipath1 :"+sParameters2[0]);
				logger.info("sArgsUipath2 :"+sParameters2[1]);
			    
				sParameters = sParameters2[0] + "^^" + sParameters2[1];				
				logger.info("iPOS parameters = " +sParameters);
				
				//Sushant Yadav : 24-06-2019 : Done the changes for run .xaml file.
				sScriptPath ="\\\\PALWDLC0LH8FJ\\QK\\Shruti\\Script\\NewFramework\\UiPathFramework_E2E";
				String UipathXamlPath=""; 
				UipathXamlPath = sScriptPath + "\\Main.xaml";
				UipathXamlPath = UipathXamlPath.replace("\\", "/");
				
				oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				//Sushant Yadav - 30 May 2019 Description : Change the name of integration table As Integration_Qath_Parameters
				String sQuery = "select * from Integration_Qath_Parameters where machineid = '"
						+ sMachineId
						+ "' and Flag ='LL'";
				logger.info(sQuery);
				ResultSet oRSQuery = oStmt.executeQuery(sQuery);
//				String sMachineId="";
				if (oRSQuery.next()) {
//					oStmt = oConn.createStatement(
					oStmt = oConn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//Sushant Yadav - 30 May 2019 Description : Change the name of integration table As Integration_Qath_Parameters
					logger.info("update Integration_Qath_Parameters set Flag = 'HOLD' "
							+ "where machineid = '"
							+ sMachineId
							+ "' and Flag ='LL'");
					//Sushant Yadav - 30 May 2019 Description : Change the name of integration table As Integration_Qath_Parameters
					oStmt.executeUpdate("update Integration_Qath_Parameters set Flag = 'HOLD' "
							+ "where machineid = '"
							+ sMachineId
							+ "' and Flag ='LL'");
					
				}
				oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				//Sushant Yadav - 30 May 2019 Description Change the name of integration table As Integration_Qath_Parameters
				String sQuery1 = "select * from Integration_Qath_Parameters where parameteres like '"
						+ sPlanID+"`"+sReleaseID+"`"+sCycleID+"%'";
				logger.info(sQuery1);
				ResultSet oRSQuery1 = oStmt.executeQuery(sQuery1);
				if (oRSQuery1.next()) {
					oStmt = oConn.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					//Sushant Yadav - 30 May 2019 Description Change the name of integration table As Integration_Qath_Parameters
					String sQuery11 = "delete Integration_Qath_Parameters where parameteres like '"
							+ sPlanID+"`"+sReleaseID+"`"+sCycleID+"%'";
					logger.info(sQuery11);
					try {
						ResultSet oRSQuery11 = oStmt.executeQuery(sQuery11);
					}catch(Exception e) {
						
					}
				}
				
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				//Sushant Yadav - 30 May 2019 Description Change the name of integration table As Integration_Qath_Parameters
				logger.info("sQuery="
						+ "insert into Integration_Qath_Parameters (machineid,integration_status,parameteres,automationfunction,flag,screennum,plantestcaseid,pol_no"// RunID
						+ ") Values" + "('"
						+ sMachineId
						+ "','','"
						+ sParameters
						+ "','"
						+ sIDSFStepKeyword
						+ "','"
						+ "LL"
						+ "','"
						+ sScrenCnt
						+ "','"
						+ sPlanTestcaseId
						+ "','"
						+ sPolicy_No
					    + "')");
				//Sushant Yadav - 30 May 2019 Description Change the name of integration table As Integration_Qath_Parameters
						oStmt.executeUpdate("insert into Integration_Qath_Parameters (machineid,integration_status,parameteres,automationfunction,flag,screennum,plantestcaseid,pol_no"// RunID
								+ ") Values" + "('"
								+ sMachineId
								+ "','','"
								+ sParameters
								+ "','"
								+ sIDSFStepKeyword
								+ "','"
								+ "LL"
								+ "','"
								+ sScrenCnt
								+ "','"
								+ sPlanTestcaseId
								+ "','"
								+ sPolicy_No
							    + "')");
						
						//Sushant Yadav : 24-06-2019 : fetch UiRobot.exe path from machine master 
						 String sQuery201 = "select UiRobotPath From machine_master where name='"
									+ sMachineId
									+ "'";
						  
							logger.info(sQuery201);
							ResultSet oRSQuery201 = oStmt.executeQuery(sQuery201);
							String RobotPath="";
							if (oRSQuery201.next()) {
								RobotPath=oRSQuery201.getString("UiRobotPath");
							}		
										
							
					//Sushant Yadav : 24-06-2019 : Add Run xaml with help of CMD command.
					
	                String RunXamlcmd="cmd /k \"\""+RobotPath+"\\UiRobot.exe\" -f \""+UipathXamlPath+"\" -input \"{'qath_parameters':'"+sParameters+"'}\"\"";
					logger.info(RunXamlcmd);
					Runtime run=Runtime.getRuntime();
					Process p=run.exec(RunXamlcmd);		
								
				/*String cmdArr[] = { "cscript", "D:\\QK\\Philam_Execution\\ExecutionFiles\\iposexecutor.vbs" };

		        Runtime.getRuntime().exec(cmdArr);

		        System.out.println("Done");*/
						

						
				
//				String TestcaseID = "";
//			    String userhomepath = System.getProperty("user.home");
//			    String cmd="",value="\\10.49.181.57\\qk\\Suyog\\IPOS_Enquiry\\IPOS_Enquiry.xaml";
//				cmd = "cmd /c start "+userhomepath+"\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe -f \""+value+"\" -i \"{'aSeeTestID': '"+TestcaseID+"'}\"";
//				System.out.println(cmd);
//				Runtime run=Runtime.getRuntime();
//				Process p=run.exec(cmd);
				Thread.sleep(3000);
				int j=0;
				String sFlagVal="";
				for(int k=0;k<=j;k++) {
					oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					//Sushant Yadav - 30 May 2019 Description Change the name of integration table As Integration_Qath_Parameters
					String sQuery2 = "select * from Integration_Qath_Parameters where machineid = '"
							+ sMachineId
							+ "' and parameteres like '"
							+ sPlanID+"`"+sReleaseID+"`"+sCycleID +"%'";
					logger.info(sQuery2);
					ResultSet oRSQuery2 = oStmt.executeQuery(sQuery2);
					
					if (oRSQuery2.next()) {
						sFlagVal=  oRSQuery2.getString("flag");;
					if(sFlagVal.equalsIgnoreCase("ipos")) { 
					    // do something
						System.out.println("File Exists");
						break;
					}
					else {
						j=j+1;
					}
					}
				}
				
				oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				//Sushant Yadav - 30 May 2019 Description Change the name of integration table As Integration_Qath_Parameters
				String sQuery2 = "select * from Integration_Qath_Parameters where machineid = '"
						+ sMachineId
						+ "' and parameteres like '"
						+ sPlanID+"`"+sReleaseID+"`"+sCycleID +"%' and flag='ipos'";
				logger.info(sQuery2);
				ResultSet oRSQuery2 = oStmt.executeQuery(sQuery2);
				String sPara="";
				if (oRSQuery2.next()) {
					sPara=  oRSQuery2.getString("integration_status");
				}
//				Path path = Paths.get(filePathString);
//				byte[] bytes = Files.readAllBytes(path);
//				List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
//				System.out.println(allLines);
//				
//				String LifelineText=allLines.toString();
			
				//Sushant Yadav : 22-06-2019 : Add if condition to check value Life line output. 
				if(!(sPara.equals("")))
				{
				String [] LifelineStatus = sPara.split("`");
				System.out.println("Status = " +LifelineStatus[0]);
				System.out.println("Output = " +LifelineStatus[1]);
				
				sStatus = LifelineStatus[0];
				sOutput = sOutput + "|" + "\n" + LifelineStatus[1];
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		  }
			return iReturnValue;	
	   }
		
	
   public int callxaml_Textfileapproach() {
		try {
			createtextfile();
			String filePathString="\\\\10.49.181.57\\qk\\Suyog\\IPOS_Enquiry\\Lifeline.txt";
			File f = new File(filePathString);
			if(f.exists() && !f.isDirectory()) { 
			    // do something
				System.out.println("File Exists");
				f.delete();
				logger.info("Existing File deleted");
			}

			String cmdArr[] = { "cscript", "D:\\QK\\Philam_Execution\\ExecutionFiles\\iposexecutor.vbs" };

	        Runtime.getRuntime().exec(cmdArr);

	        System.out.println("Done");

			
//			String TestcaseID = "";
//		    String userhomepath = System.getProperty("user.home");
//		    String cmd="",value="\\10.49.181.57\\qk\\Suyog\\IPOS_Enquiry\\IPOS_Enquiry.xaml";
//			cmd = "cmd /c start "+userhomepath+"\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe -f \""+value+"\" -i \"{'aSeeTestID': '"+TestcaseID+"'}\"";
//			System.out.println(cmd);
//			Runtime run=Runtime.getRuntime();
//			Process p=run.exec(cmd);
			Thread.sleep(3000);
			int j=0;
		
			for(int k=0;k<=j;k++) {
				if(f.exists() && !f.isDirectory()) { 
				    // do something
					System.out.println("File Exists");
					break;
				}
				else {
					j=j+1;
				}
				}
			
			Path path = Paths.get(filePathString);
			byte[] bytes = Files.readAllBytes(path);
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			System.out.println(allLines);
			
			String LifelineText=allLines.toString();
			
			String [] LifelineStatus = LifelineText.split(",");
			System.out.println("Life line Status = " +LifelineStatus[0]);
			System.out.println("iPOS Status = " +LifelineStatus[1]);
			
			sStatus = LifelineStatus[0];
			sOutput = LifelineStatus[1];
			
		}catch(Exception e) {
			
		}
		return iReturnValue;
   }
	
	public int createtextfile() {
		
		String sText ="";
		try {
			File file = new File("\\\\10.49.181.57\\qk\\Suyog\\IPOS_Enquiry\\ipos.txt");
	        //Create the file
	        if (file.createNewFile()){
	          System.out.println("File is created!");
	        }else{
	          System.out.println("File already exists.");
	        }
	        //Write Content
	        FileWriter writer = new FileWriter(file);
	       
	        sText = sPlanID+","+sReleaseID+","+sCycleID+","+sPlanTestcaseId+","+sFullScreenShotPath
	        		+","+sStatus+","+sOutput+","+sPolicyNum+","+sModule+","+sSubModule+","+sTestType+","+sMobDeviceName+","+sScenarioId;
	        logger.info("iPOS Text = " +sText);
	        writer.write(sText);
	        writer.close();
		}catch(Exception e) {
			
		}
		return iReturnValue;
	}
	
	public int writeoutput() {
		logger.info("Inside WriteOutput");
		iTerminateInd = 0;
		String sValue = "";
		try {
			String[] oArrFields = sSFStepKeyword.split(";;");
			for (int iArrFields = 0; oArrFields.length > iArrFields; iArrFields = iArrFields + 1) {
				logger.info("Object Name=" + oArrFields[iArrFields]);
				if (oArrFields[iArrFields].toUpperCase().contains("RESULT$")) {
					String iArrres = oArrFields[iArrFields].replace("$", "#");
					String[] OutputMsg = iArrres.split("#");
					if (sOutput.equals("")) {
						sOutput = OutputMsg[1].split(":")[0];
						sStatus = "Pass";
					} else {
						sOutput = sOutput + " | " + "\n" + OutputMsg[1].split(":")[0];
						// updated by latha on 14FEB2018 : assigning sStatus as
						// pass
						sStatus = "Pass";

					}
				} else if (oArrFields[iArrFields].contains("Key-")) {
					oArrFields[iArrFields] = oArrFields[iArrFields]
							.split("Key-")[1];
					GetObj(oArrFields[iArrFields]);
					if (oTestObject1 != null) {
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
							if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
								String UIName, sTestData;
								if (sUIName.equalsIgnoreCase("Native")) {
									oDriver_Mob.useNativeIdentification();
									UIName = "Native";
								} else {
									oDriver_Mob.useWebIdentification();
									UIName = "WEB";
								}
								String[] str1;
								String sV="";
								String sVal1="";
								boolean b = oDriver_Mob.client.isElementFound(UIName, oTestObject1, 0);
								if (b == true) {
									// Thread.sleep(100);
									sValue =oDriver_Mob.client.elementGetText(UIName, oTestObject1, 0).trim();
//									sValue="The data has been successfully submitted! Policy No:1070000524 Membership No:4100335491";
									sV =sValue;
									if (sValue.contains("Policy No:")) {
									sValue = sValue.replace("24 hours", "");
									str1 = sValue.split("Policy No:");
									str1 = str1[1].split("Membership No:");
									System.out.println("Policy No : " +str1[0].replaceAll("\\D+","").trim());
									sValue = str1[0].replaceAll("\\D+","").trim();
									try {
									System.out.println("Membership No : " +str1[1].trim());
									sVal1=str1[1];
									}catch(Exception e) {}
									if (!sVal1.equalsIgnoreCase("")) {
										sKey = "Policy No : " +sValue+ "\n" +"Membership No : " +sVal1;
									}else {
										sKey = "Policy No : " +sValue;
									}
									oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
									logger.info("update iPos_Esubmission set PolicyNumber ='"+sValue+"' where planid = '"
											+ sPlanID
											+ "' and planreleaseid = '"
											+ sReleaseID
											+ "' and plancycleid = '"
											+ sCycleID
											+ "' and test_case = '"
											+ sPlanTestcaseId
										    + "'");
									oStmt.executeUpdate("update iPos_Esubmission set PolicyNumber ='"+sValue+"' where planid = '"
											+ sPlanID
											+ "' and planreleaseid = '"
											+ sReleaseID
											+ "' and plancycleid = '"
											+ sCycleID
											+ "' and test_case = '"
											+ sPlanTestcaseId
										    + "'");
									sPolicyNum =sKey;
//									createtextfile();
									//Sushant Yadav : 10-06-2019 :Pass policy number for Integration_Qath_Parameters
									sPolicy_No = sValue;
								}
									sValue =sV;
							// sValue = (new
							// Select(oTestObject)).getFirstSelectedOption().getText();
							if (sOutput.equals("")) {
								// sOutput = oArrFields[iArrFields] + " = "+
								// sValue;
								sOutput = sValue;
							} else {
								// sOutput = sOutput + " | "
								// +oArrFields[iArrFields] + " = " + sValue;
								sOutput = sOutput + " | " + "\n" + oArrFields[iArrFields]+" = "+sValue;
//								sOutput = sOutput + " | " + sValue;
//								sValue="";
							}
							System.out.println(sValue);
								}
							}
							break;
						case "HTML.INPUT.BUTTON":
							if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
								String UIName, sTestData;
								if (sUIName.equalsIgnoreCase("Native")) {
									oDriver_Mob.useNativeIdentification();
									UIName = "Native";
								} else {
									oDriver_Mob.useWebIdentification();
									UIName = "WEB";
								}

								boolean b = oDriver_Mob.client.isElementFound(UIName, oTestObject1, 0);
								if (b == true) {
									// Thread.sleep(100);
								
									sValue =oDriver_Mob.client.elementGetText(UIName, oTestObject1, 0).trim();
								
							// sValue = (new
							// Select(oTestObject)).getFirstSelectedOption().getText();
							if (sOutput.equals("")) {
								// sOutput = oArrFields[iArrFields] + " = "+
								// sValue;
								sOutput = sValue;
							} else {
								// sOutput = sOutput + " | "
								// +oArrFields[iArrFields] + " = " + sValue;
								sOutput = sOutput + " | "  +"\n"+ oArrFields[iArrFields]+" = "+sValue;
//								sOutput = sOutput + " | " + sValue;
//								sValue="";
							}
							System.out.println(sValue);
								}
							}
							break;
					/*		if (sValue.equalsIgnoreCase("Failed: 1")) {
								iReturnValue = 1;
							}
							if (!oTestDataMap
									.containsKey(oArrFields[iArrFields]
											.toLowerCase())) {
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							} else {
								oTestDataMap.remove(oArrFields[iArrFields]);
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							}
							if (!sKey.equalsIgnoreCase("")) {
								sKey = sKey
										+ " | "
										+ oArrFields[iArrFields]
												+ "="
												+ oTestDataMap
												.get(oArrFields[iArrFields]
														.toLowerCase());
							} else {
								sKey = oArrFields[iArrFields]
										+ "="
										+ oTestDataMap
										.get(oArrFields[iArrFields]
												.toLowerCase());
							}
							System.out.println("sKey : " + sKey);
							logger.info(oArrFields[iArrFields] + "=" + sValue);
							break;
						default:
							sValue = oTestObject.getAttribute("value");
							if (sValue == null || sValue == "") {
								sValue = oTestObject.getText();
								 varsha 
								if (sValue.contains("'")) {
									sValue = sValue.replace("'", "");
								}
								if (sValue.contains("\n")) {
									sValue = sValue.split("\\n")[0];
								}
							}
							if (sOutput.equals("")) {
								// sOutput = oArrFields[iArrFields] + " = "+
								// sValue;
								sOutput = sValue;
							} else {
								// sOutput = sOutput + " | "
								// +oArrFields[iArrFields] + " = " + sValue;
								sOutput = sOutput + " | " + oArrFields[iArrFields]+" = "+sValue;
							}
							if (!oTestDataMap
									.containsKey(oArrFields[iArrFields]
											.toLowerCase())) {
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							} else {
								oTestDataMap.remove(oArrFields[iArrFields]);
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							}
							if (!sKey.equalsIgnoreCase("")) {
								sKey = sKey
										+ " | "
										+ oArrFields[iArrFields].toLowerCase()
										+ "="
										+ oTestDataMap
										.get(oArrFields[iArrFields]
												.toLowerCase());
							} else {
								sKey = oArrFields[iArrFields].toLowerCase()
										+ "="
										+ oTestDataMap
										.get(oArrFields[iArrFields]
												.toLowerCase());
							}
							System.out.println("sKey : " + sKey);
							logger.info(oArrFields[iArrFields] + "=" + sValue);
							break;*/
						}
						String sQuery = "";
						// ResultSet oRSQuery = null;
						/*
						 * oStmt = oConn.createStatement(
						 * ResultSet.TYPE_SCROLL_INSENSITIVE,
						 * ResultSet.CONCUR_READ_ONLY); if (sRCTestcaseID ==
						 * null || sRCTestcaseID == "") { sQuery =
						 * "update qath_testplan_executor set testdata = '" +
						 * sKey + "' where planid = '" + sPlanID +
						 * "' and planreleaseid = '" + sReleaseID +
						 * "' and plancycleid = '" + sCycleID + "' " +
						 * " and planmodule = '" + sModule +
						 * "' and plansubmodule = '" + sSubModule +
						 * "' and plantestcaseid = '" + sPlanTestcaseId +
						 * "' and device = '" + sMobDeviceName + "'"; } else {
						 * sQuery =
						 * "update qath_testplan_executor set testdata = '" +
						 * sKey + "' where planid = '" + sPlanID +
						 * "' and planreleaseid = '" + sReleaseID +
						 * "' and plancycleid = '" + sCycleID + "' " +
						 * " and planmodule = '" + sModule +
						 * "' and plansubmodule = '" + sSubModule +
						 * "' and plantestcaseid = '" + sPlanTestcaseId +
						 * "' and device = '" + sMobDeviceName + "'"; }
						 * logger.info(sQuery); oStmt.executeUpdate(sQuery);
						 */
						// UpdateDynamicExpectedResult();
					}
				} else if (oArrFields[iArrFields].contains("Key#")) {
					oArrFields[iArrFields] = oArrFields[iArrFields]
							.split("Key#")[1];
					GetObj(oArrFields[iArrFields]);
					if (oTestObject != null) {
						switch (sObjClass.toUpperCase()) {
						case "HTML.INPUT.TEXT":
							sValue = (new Select(oTestObject))
							.getFirstSelectedOption().getText();
							if (sOutput.equals("")) {
								sOutput = oArrFields[iArrFields] + " = "
										+ sValue;
							} else {
								sOutput = sOutput + " | " +"\n"
										+ oArrFields[iArrFields] + " = "
										+ sValue;
							}
							if (!oTestDataMap
									.containsKey(oArrFields[iArrFields]
											.toLowerCase())) {
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							} else {
								oTestDataMap.remove(oArrFields[iArrFields]);
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							}
							if (!sKey.equalsIgnoreCase("")) {
								sKey = sKey
										+ " | "
										+ oArrFields[iArrFields]
												+ "="
												+ oTestDataMap
												.get(oArrFields[iArrFields]
														.toLowerCase());
							} else {
								sKey = oArrFields[iArrFields]
										+ "="
										+ oTestDataMap
										.get(oArrFields[iArrFields]
												.toLowerCase());
							}
							System.out.println("sKey : " + sKey);
							logger.info(oArrFields[iArrFields] + "=" + sValue);
							break;
						default:
							sValue = oTestObject.getAttribute("value");
							if (sValue == null || sValue == "") {
								sValue = oTestObject.getText();
								/* varsha */
								if (sValue.contains("'")) {
									sValue = sValue.replace("'", "");
								}
								if (sValue.contains("\n")) {
									sValue = sValue.split("\\n")[0];
								}
							}
							if (sOutput.equals("")) {
								sOutput = oArrFields[iArrFields] + " = "
										+ sValue;
							} else {
								sOutput = sOutput + " | "
										+ oArrFields[iArrFields] + " = "
										+ sValue;
							}
							if (!oTestDataMap
									.containsKey(oArrFields[iArrFields]
											.toLowerCase())) {
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							} else {
								oTestDataMap.remove(oArrFields[iArrFields]);
								oTestDataMap.put(
										oArrFields[iArrFields].toLowerCase(),
										sValue);
							}
							if (!sKey.equalsIgnoreCase("")) {
								sKey = sKey
										+ " | "
										+ oArrFields[iArrFields].toLowerCase()
										+ "="
										+ oTestDataMap
										.get(oArrFields[iArrFields]
												.toLowerCase());
							} else {
								sKey = oArrFields[iArrFields].toLowerCase()
										+ "="
										+ oTestDataMap
										.get(oArrFields[iArrFields]
												.toLowerCase());
							}
							System.out.println("sKey : " + sKey);
							logger.info(oArrFields[iArrFields] + "=" + sValue);
							break;
						}
						String sQuery = "";
						// ResultSet oRSQuery = null;
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							sQuery = "update qath_testplan_executor set testdata = '"
									+ sKey
									+ "' where planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' "
									+ " and planmodule = '"
									+ sModule
									+ "' and plansubmodule = '"
									+ sSubModule
									+ "' and plantestcaseid = '"
									+ sPlanTestcaseId
									+ "' and device = '"
									+ sMobDeviceName + "'";
						} else {
							sQuery = "update qath_testplan_executor set testdata = '"
									+ sKey
									+ "' where planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' "
									+ " and planmodule = '"
									+ sModule
									+ "' and plansubmodule = '"
									+ sSubModule
									+ "' and plantestcaseid = '"
									+ sPlanTestcaseId
									+ "' and device = '"
									+ sMobDeviceName + "'";
						}
						logger.info(sQuery);
						oStmt.executeUpdate(sQuery);
						// UpdateDynamicExpectedResult();
					}
				} else if (oArrFields[iArrFields].contains("Key!")) {
					oArrFields[iArrFields] = oArrFields[iArrFields]
							.split("Key!")[1];
					sValue = oGlobalMap.get(oArrFields[iArrFields]
							.toLowerCase());
					// GetObj(oArrFields[iArrFields]);
					if (!sValue.equalsIgnoreCase("")) {
						// switch (sObjClass.toUpperCase()) {
						// case "HTML.SELECT":
						// sValue = (new Select(oTestObject))
						// .getFirstSelectedOption().getText();
						/*
						 * if (sOutput.equals("")) { sOutput =
						 * oArrFields[iArrFields] + " = " + sValue; } else {
						 * sOutput = sOutput + " | " + oArrFields[iArrFields] +
						 * " = " + sValue; }
						 */

						/*
						 * if(!sTestData.equalsIgnoreCase("") || sTestData!=
						 * null){ sTestData=sTestData + " | " +sValue; sKey
						 * =sTestData; } else{ sTestData=sValue; sKey=sTestData;
						 * }
						 */
						sKey = oArrFields[iArrFields]+" = "+sValue;
						logger.info("Key : " + "=" + sKey);
						logger.info(oArrFields[iArrFields] + "=" + sValue);
						// break;
						//
						// default:
						// sValue = oTestObject.getAttribute("value");
						// if (sValue == null || sValue == "") {
						// sValue = oTestObject.getText();
						// /* varsha */
						// if (sValue.contains("'")) {
						// sValue = sValue.replace("'", "");
						// }
						// if (sValue.contains("\n")) {
						// sValue = sValue.split("\\n")[0];
						// }
						//
						// }
						// if (sOutput.equals("")) {
						// sOutput = oArrFields[iArrFields] + " = "
						// + sValue;
						// } else {
						// sOutput = sOutput + " | "
						// + oArrFields[iArrFields] + " = "
						// + sValue;
						// }

						/*
						 * if(!sTestData.equalsIgnoreCase("")){
						 * sTestData=sTestData + " | " +sOutput+":"+sValue; sKey
						 * =sTestData; } else{
						 */
						// sTestData= sOutput;
						// sKey=sOutput;
						// oGlobalMap.put(sKey, sOutput);
						// sKey = oGlobalMap.get(sKey);
						// System.out.println("sKey : " + sKey);
						// // }
						// logger.info(oArrFields[iArrFields] + "=" + sValue);
						// break;
						//
						// }
						String sQuery = "";
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							sQuery = "update qath_testplan_executor set testdata = '"
									+ sKey
									+ "' where planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' "
									+ " and planmodule = '"
									+ sModule
									+ "' and plansubmodule = '"
									+ sSubModule
									+ "' and plantestcaseid = '"
									+ sPlanTestcaseId
									+ "' and device = '"
									+ sMobDeviceName + "'";
						} else {
							sQuery = "update qath_testplan_executor set testdata = '"
									+ sKey
									+ "' where planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' "
									+ " and planmodule = '"
									+ sModule
									+ "' and plansubmodule = '"
									+ sSubModule
									+ "' and plantestcaseid = '"
									+ sPlanTestcaseId
									+ "' and device = '"
									+ sMobDeviceName + "'";
						}
						logger.info(sQuery);
						oStmt.executeUpdate(sQuery);
					}
				}/*
				 * else if (oArrFields[iArrFields].contains("Key!")) {
				 * oArrFields[iArrFields] = oArrFields[iArrFields]
				 * .split("Key!")[1]; GetObj(oArrFields[iArrFields]); if
				 * (oTestObject != null) { switch (sObjClass.toUpperCase()) {
				 * case "HTML.SELECT": sValue = (new Select(oTestObject))
				 * .getFirstSelectedOption().getText(); if (sOutput.equals(""))
				 * { sOutput = oArrFields[iArrFields] + " = " + sValue; } else {
				 * sOutput = sOutput + " | " + oArrFields[iArrFields] + " = " +
				 * sValue; }
				 * 
				 * 
				 * if(!sTestData.equalsIgnoreCase("") || sTestData!= null){
				 * sTestData=sTestData + " | " +sValue; sKey =sTestData; } else{
				 * sTestData=sValue; sKey=sTestData; }
				 * 
				 * sKey = sOutput; logger.info("Key : " + "=" + sKey);
				 * logger.info(oArrFields[iArrFields] + "=" + sValue); break;
				 * 
				 * default: sValue = oTestObject.getAttribute("value"); if
				 * (sValue == null || sValue == "") { sValue =
				 * oTestObject.getText(); varsha if (sValue.contains("'")) {
				 * sValue = sValue.replace("'", ""); } if
				 * (sValue.contains("\n")) { sValue = sValue.split("\\n")[0]; }
				 * 
				 * } if (sOutput.equals("")) { sOutput = oArrFields[iArrFields]
				 * + " = " + sValue; } else { sOutput = sOutput + " | " +
				 * oArrFields[iArrFields] + " = " + sValue; }
				 * 
				 * if(!sTestData.equalsIgnoreCase("")){ sTestData=sTestData +
				 * " | " +sOutput+":"+sValue; sKey =sTestData; } else{
				 * 
				 * // sTestData= sOutput; // sKey=sOutput; oGlobalMap.put(sKey,
				 * sOutput); sKey = oGlobalMap.get(sKey);
				 * System.out.println("sKey : " + sKey); // }
				 * logger.info(oArrFields[iArrFields] + "=" + sValue); break;
				 * 
				 * }
				 * 
				 * String sQuery = ""; // ResultSet oRSQuery = null; oStmt =
				 * oConn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
				 * ResultSet.CONCUR_READ_ONLY); if (sRCTestcaseID == null ||
				 * sRCTestcaseID == "") { sQuery =
				 * "update qath_testplan_executor set testdata = '" + sKey +
				 * "' where planid = '" + sPlanID + "' and planreleaseid = '" +
				 * sReleaseID + "' and plancycleid = '" + sCycleID + "' " +
				 * " and planmodule = '" + sModule + "' and plansubmodule = '" +
				 * sSubModule + "' and plantestcaseid = '" + sPlanTestcaseId +
				 * "' and device = '" + sMobDeviceName + "'"; } else { sQuery =
				 * "update qath_testplan_executor set testdata = '" + sKey +
				 * "' where planid = '" + sPlanID + "' and planreleaseid = '" +
				 * sReleaseID + "' and plancycleid = '" + sCycleID + "' " +
				 * " and planmodule = '" + sModule + "' and plansubmodule = '" +
				 * sSubModule + "' and plantestcaseid = '" + sPlanTestcaseId +
				 * "' and device = '" + sMobDeviceName + "'"; }
				 * logger.info(sQuery); oStmt.executeUpdate(sQuery); //
				 * UpdateDynamicExpectedResult(); } }
				 */else if (oArrFields[iArrFields].contains("Res@")) {
					 oArrFields[iArrFields] = oArrFields[iArrFields]
							 .split("Res@")[1];
					 GetObj(oArrFields[iArrFields]);
					 if (oTestObject != null) {
						 switch (sObjClass.toUpperCase()) {
						 case "HTML.SELECT":
							 sValue = (new Select(oTestObject))
							 .getFirstSelectedOption().getText();

							 if (sOutput.equals("")) {
								 sOutput = oArrFields[iArrFields] + " = "
										 + sValue;
							 } else {
								 sOutput = sOutput + " | "
										 + oArrFields[iArrFields] + " = "
										 + sValue;
							 }
							 sKey = sValue;
							 logger.info(oArrFields[iArrFields] + "=" + sValue);
							 break;
						 default:
							 sValue = oTestObject.getAttribute("value");
							 if (sValue == null || sValue == "") {
								 sValue = oTestObject.getText();
								 // varsha
								 if (sValue.contains("'")) {
									 sValue = sValue.replace("'", "");
								 }
								 if (sValue.contains("\n")) {
									 sValue = sValue.split("\\n")[0];
								 }

							 }
							 if (sOutput.equals("")) {
								 sOutput = oArrFields[iArrFields] + " = "
										 + sValue;
							 } else {
								 sOutput = sOutput + " | "
										 + oArrFields[iArrFields] + " = "
										 + sValue;
							 }
							 sKey = sValue;
							 logger.info(oArrFields[iArrFields] + "=" + sValue);
							 break;

						 }

						 String sQuery = "";
						 // ResultSet oRSQuery = null;
						 oStmt = oConn.createStatement(
								 ResultSet.TYPE_SCROLL_INSENSITIVE,
								 ResultSet.CONCUR_READ_ONLY);
						 if (sRCTestcaseID == null || sRCTestcaseID == "") {
							 sQuery = "update qath_testplan_executor set testdata = '"
									 + sKey
									 + "' where planid = '"
									 + sPlanID
									 + "' and planreleaseid = '"
									 + sReleaseID
									 + "' and plancycleid = '"
									 + sCycleID
									 + "' "
									 + " and planmodule = '"
									 + sModule
									 + "' and plansubmodule = '"
									 + sSubModule
									 + "' and plantestcaseid = '"
									 + sPlanTestcaseId
									 + "' and device = '"
									 + sMobDeviceName + "'";
						 } else {
							 sQuery = "update qath_testplan_executor set testdata = '"
									 + sKey
									 + "' where planid = '"
									 + sPlanID
									 + "' and planreleaseid = '"
									 + sReleaseID
									 + "' and plancycleid = '"
									 + sCycleID
									 + "' "
									 + " and planmodule = '"
									 + sModule
									 + "' and plansubmodule = '"
									 + sSubModule
									 + "' and plantestcaseid = '"
									 + sPlanTestcaseId
									 + "' and device = '"
									 + sMobDeviceName + "'";
						 }
						 logger.info(sQuery);
						 oStmt.executeUpdate(sQuery);
						 // UpdateDynamicExpectedResult();
					 }
				 }

				 else {

					 // if
					 // ((oArrFields[iArrFields])!=""||(oArrFields[iArrFields])!=null)
					 // {
					 GetObj(oArrFields[iArrFields]);
					 if (oTestObject != null) {
						 switch (sObjClass.toUpperCase()) {
						 case "HTML.SELECT":
							 String sValue1 = (new Select(oTestObject))
							 .getFirstSelectedOption().getText();
							 if (sOutput.equals("")) {
								 sOutput = oArrFields[iArrFields] + " = "
										 + sValue1;
								 // iTerminateInd = 1;
							 } else {
								 sOutput = sOutput + " | "
										 + oArrFields[iArrFields] + " = "
										 + sValue1;
								 // iTerminateInd = 1;
							 }
							 logger.info(oArrFields[iArrFields] + "=" + sValue1);
							 break;
						 default:
							 sValue = oTestObject.getAttribute("value");
							 if (sValue == null || sValue == "") {
								 sValue = oTestObject.getText();
							 }
							 if (sOutput.equals("")) {
								 sOutput = oArrFields[iArrFields] + " = "
										 + sValue;
								 // iTerminateInd = 1;
							 } else {
								 sOutput = sOutput + " | "
										 + oArrFields[iArrFields] + " = "
										 + sValue;
								 // iTerminateInd = 1;
							 }
							 logger.info(oArrFields[iArrFields] + "=" + sValue);
							 break;
						 }

						 if ((sValue == null) || (sValue == "")) {
							 sStatus = "Fail";
							 iReturnValue = 1;
							 iRCTCTerminateInd = 1;
							 // iTerminateInd = 1;
						 }
					 } else {
						 sStatus = "Fail";
						 iReturnValue = 1;
						 iRCTCTerminateInd = 1;
						 // iTerminateInd = 1;
						 if (sOutput.equals("")) {
							 sOutput = oArrFields[iArrFields] + " not found";
							 // iTerminateInd = 1;
						 } else {
							 sOutput = sOutput + " | " + oArrFields[iArrFields]
									 + " not found";
							 // iTerminateInd = 1;
						 }
					 }
					 // }

				 }
				if (oArrFields[iArrFields].contains(":")) {
					ResultSet oRSQuery = null;
					String sQuery = null;
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						sQuery = "select "
								+ oArrFields[iArrFields].split(":")[1]
										+ " from " + sTableName
										+ " where Test_Case = '" + sPlanTestcaseId
										+ "' and planid = '" + sPlanID
										+ "' and planreleaseid = '" + sReleaseID
										+ "' and plancycleid = '" + sCycleID + "'";
						logger.info(sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							sOutput = sOutput
									+ " - "
									+ oRSQuery.getString(oArrFields[iArrFields]
											.split(":")[1]);
						}
						oRSQuery.close();
						// sQuery =
						// "select * from Dynamic_Expected_Result where MainTestCaseID = '"
						// + sPlanTestcaseId + "' and UniqueKey = '" + sKey +
						// "' and Field = '" + sField + "'";
					} else {
						sQuery = "select "
								+ oArrFields[iArrFields].split(":")[1]
										+ " from " + sTableName + " where planid = '"
										+ sPlanID + "' and planreleaseid = '"
										+ sReleaseID + "' and plancycleid = '"
										+ sCycleID + "' and Test_Case_Ser = '"
										+ sRCTestcaseID + "' and Test_Case = '"
										+ sPlanTestcaseId + "'";
						logger.info(sQuery);
						oRSQuery = oStmt.executeQuery(sQuery);
						if (oRSQuery.next()) {
							sOutput = sOutput
									+ " - "
									+ oRSQuery.getString(oArrFields[iArrFields]
											.split(":")[1]);
						}
						oRSQuery.close();
						// sQuery =
						// "select * from Dynamic_Expected_Result where MainTestCaseID = '"
						// + sPlanTestcaseId + "' and UniqueKey = '" + sKey +
						// "' and Field = '" + sField + "'";
					}
				}
			}

		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				iReturnValue = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int updateillusrationdetails() {
		logger.info("Inside UpdateIllusrationDetails");
		iTerminateInd = 0;
		try {
			Thread.sleep(2000);
			if (sSFStepKeyword.equals("") || sSFStepKeyword.equals("Online")) {
				List<WebElement> oTestObjects = oDriver.findElements(By
						.xpath("//table/tbody[@id='result_data_table_body']"));
				if (oTestObjects.size() == 1) {
					List<WebElement> oTableRows = oTestObjects.get(0)
							.findElements(By.tagName("tr"));
					for (int iRowCount = 0; oTableRows.size() > iRowCount; iRowCount = iRowCount + 1) {
						List<WebElement> oColumnObjects = oTableRows.get(
								iRowCount).findElements(By.tagName("td"));
						String sValue = "";
						for (int iColumnCount = 0; oColumnObjects.size() > iColumnCount; iColumnCount = iColumnCount + 1) {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							String sQuery = "";
							if (sRCTestcaseID == null || sRCTestcaseID == "") {
								sQuery = "select * from Expected_Illusration_Details where col"
										+ (iColumnCount + 1)
										+ " = 'X' and planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId + "'";
							} else {
								sQuery = "select * from Expected_Illusration_Details where col"
										+ (iColumnCount + 1)
										+ " = 'X' and planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and test_case_ser = '"
										+ sRCTestcaseID + "'";
							}
							ResultSet oRSQuery = oStmt.executeQuery(sQuery);
							if (oRSQuery.next()) {
								sValue = sValue + ",'X'";
							} else {
								if (iColumnCount == 0) {
									sValue = sValue
											+ "'"
											+ oColumnObjects.get(iColumnCount)
											.getText() + "'";
								} else {
									sValue = sValue
											+ ",'"
											+ oColumnObjects.get(iColumnCount)
											.getText() + "'";
								}
							}
						}
						for (int iColumnCount = oColumnObjects.size(); 15 > iColumnCount; iColumnCount = iColumnCount + 1) {
							sValue = sValue + ",''";
						}
						logger.info("Row Values=" + sValue);
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						if (sRCTestcaseID == null || sRCTestcaseID == "") {
							logger.info("sQuery="
									+ "insert into Actual_Illusration_Details values ('"
									+ sPlanID + "','" + sReleaseID + "','"
									+ sCycleID + "','" + sPlanTestcaseId
									+ "',''," + sValue.replace("null", "0")
									+ ")");
							oStmt.executeUpdate("insert into Actual_Illusration_Details values ('"
									+ sPlanID
									+ "','"
									+ sReleaseID
									+ "','"
									+ sCycleID
									+ "','"
									+ sPlanTestcaseId
									+ "','',"
									+ sValue.replace("null", "0")
									+ ")");
						} else {
							logger.info("sQuery="
									+ "insert into Actual_Illusration_Details values ('"
									+ sPlanID + "','" + sReleaseID + "','"
									+ sCycleID + "','" + sPlanTestcaseId
									+ "','" + sRCTestcaseID + "',"
									+ sValue.replace("null", "0") + ")");
							oStmt.executeUpdate("insert into Actual_Illusration_Details values ('"
									+ sPlanID
									+ "','"
									+ sReleaseID
									+ "','"
									+ sCycleID
									+ "','"
									+ sPlanTestcaseId
									+ "','"
									+ sRCTestcaseID
									+ "',"
									+ sValue.replace("null", "0") + ")");
						}
					}
				}
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iTerminateInd;
	}

	public int compareillusrationdetails() {
		logger.info("Inside CompareIllusrationDetails");
		iTerminateInd = 0;
		boolean iIllFlag = true;
		String sTempStr = "";
		try {
			if (sCalcMethod.equalsIgnoreCase("premium")) {
				oStmt = oConn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet oRSQuery1;
				if (sRCTestcaseID == null || sRCTestcaseID == "") {
					oRSQuery1 = oStmt
							.executeQuery("select * from dbo.Expected_Illusration_Details "
									+ "where  planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' and test_case = '"
									+ sPlanTestcaseId
									+ "'");
				} else {
					oRSQuery1 = oStmt
							.executeQuery("select * from dbo.Expected_Illusration_Details "
									+ "where  planid = '"
									+ sPlanID
									+ "' and planreleaseid = '"
									+ sReleaseID
									+ "' and plancycleid = '"
									+ sCycleID
									+ "' and test_case = '"
									+ sPlanTestcaseId
									+ "' and test_case_ser = '"
									+ sRCTestcaseID
									+ "'");
				}
				ResultSetMetaData oMetaData = oRSQuery1.getMetaData();
				while (oRSQuery1.next()) {
					ResultSet oRSQuery;
					if (sRCTestcaseID == null || sRCTestcaseID == "") {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery="
								+ "select * from dbo.Actual_Illusration_Details "
								+ "where  planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId
								+ "' and col2 = '"
								+ oRSQuery1.getString(oMetaData
										.getColumnName(7))
										+ "' "
										+ "INTERSECT "
										+ "select * from dbo.Expected_Illusration_Details "
										+ "where  planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and col2 = '"
										+ oRSQuery1.getString(oMetaData
												.getColumnName(7)) + "'");
						oRSQuery = oStmt
								.executeQuery("select * from dbo.Actual_Illusration_Details "
										+ "where  planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and col2 = '"
										+ oRSQuery1.getString(oMetaData
												.getColumnName(7))
												+ "' "
												+ "INTERSECT "
												+ "select * from dbo.Expected_Illusration_Details "
												+ "where  planid = '"
												+ sPlanID
												+ "' and planreleaseid = '"
												+ sReleaseID
												+ "' and plancycleid = '"
												+ sCycleID
												+ "' and test_case = '"
												+ sPlanTestcaseId
												+ "' and col2 = '"
												+ oRSQuery1.getString(oMetaData
														.getColumnName(7)) + "'");
					} else {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery="
								+ "select * from dbo.Actual_Illusration_Details "
								+ "where  planid = '"
								+ sPlanID
								+ "' and planreleaseid = '"
								+ sReleaseID
								+ "' and plancycleid = '"
								+ sCycleID
								+ "' and test_case = '"
								+ sPlanTestcaseId
								+ "' and test_case_ser = '"
								+ sRCTestcaseID
								+ "' and col2 = '"
								+ oRSQuery1.getString(oMetaData
										.getColumnName(7))
										+ "'"
										+ "INTERSECT "
										+ "select * from dbo.Expected_Illusration_Details "
										+ "where  planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and test_case_ser = '"
										+ sRCTestcaseID
										+ "' and col2 = '"
										+ oRSQuery1.getString(oMetaData
												.getColumnName(7)) + "'");
						oRSQuery = oStmt
								.executeQuery("select * from dbo.Actual_Illusration_Details "
										+ "where  planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and test_case_ser = '"
										+ sRCTestcaseID
										+ "' and col2 = '"
										+ oRSQuery1.getString(oMetaData
												.getColumnName(7))
												+ "'"
												+ "INTERSECT "
												+ "select * from dbo.Expected_Illusration_Details "
												+ "where  planid = '"
												+ sPlanID
												+ "' and planreleaseid = '"
												+ sReleaseID
												+ "' and plancycleid = '"
												+ sCycleID
												+ "' and test_case = '"
												+ sPlanTestcaseId
												+ "' and test_case_ser = '"
												+ sRCTestcaseID
												+ "' and col2 = '"
												+ oRSQuery1.getString(oMetaData
														.getColumnName(7)) + "'");
					}
					if (oRSQuery.next()) {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						logger.info("sQuery="
								+ "select Expected.planid planid,Expected.planreleaseid,Expected.plancycleid,Expected.test_case,Expected.test_case_ser,"
								+ "Expected.col1 Ex_Col1,Expected.col2 Ex_Col2,Expected.col3 Ex_Col3,Expected.col4 Ex_Col4,Expected.col5 Ex_Col5,Expected.col6 Ex_Col6,Expected.col7 Ex_Col7,Expected.col8 Ex_Col8,Expected.col9 Ex_Col9,Expected.col10 Ex_Col10,Expected.col11 Ex_Col11,Expected.col12 Ex_Col12,Expected.col13 Ex_Col13,Expected.col14 Ex_Col14,Expected.col15 Ex_Col15,"
								+ "Actual.col1 Ac_Col1,Actual.col2 Ac_Col2,Actual.col3 Ac_Col3,Actual.col4 Ac_Col4,Actual.col5 Ac_Col5,Actual.col6 Ac_Col6,Actual.col7 Ac_Col7,Actual.col8 Ac_Col8,Actual.col9 Ac_Col9,Actual.col10 Ac_Col10,Actual.col11 Ac_Col11,Actual.col12 Ac_Col12,Actual.col13 Ac_Col13,Actual.col14 Ac_Col14,Actual.col15 Ac_Col15 "
								+ "from Expected_Illusration_Details Expected left join dbo.Actual_Illusration_Details Actual "
								+ "on Expected.planid = Actual.planid and "
								+ "Expected.planreleaseid = Actual.planreleaseid and "
								+ "Expected.plancycleid = Actual.plancycleid and "
								+ "Expected.col2 = Actual.col2 and "
								+ "Expected.test_case = Actual.test_case "
								+ "where Expected.col2 = '"
								+ oRSQuery1.getString(oMetaData
										.getColumnName(7))
										+ "' and Expected.test_case = '"
										+ sPlanTestcaseId + "' and Expected.planid = '"
										+ sPlanID + "' and Expected.planreleaseid = '"
										+ sReleaseID + "' and Expected.plancycleid = '"
										+ sCycleID + "'");
						ResultSet oRSQueryTemp = oStmt
								.executeQuery("select Expected.planid planid,Expected.planreleaseid,Expected.plancycleid,Expected.test_case,Expected.test_case_ser,"
										+ "Expected.col1 Ex_Col1,Expected.col2 Ex_Col2,Expected.col3 Ex_Col3,Expected.col4 Ex_Col4,Expected.col5 Ex_Col5,Expected.col6 Ex_Col6,Expected.col7 Ex_Col7,Expected.col8 Ex_Col8,Expected.col9 Ex_Col9,Expected.col10 Ex_Col10,Expected.col11 Ex_Col11,Expected.col12 Ex_Col12,Expected.col13 Ex_Col13,Expected.col14 Ex_Col14,Expected.col15 Ex_Col15,"
										+ "Actual.col1 Ac_Col1,Actual.col2 Ac_Col2,Actual.col3 Ac_Col3,Actual.col4 Ac_Col4,Actual.col5 Ac_Col5,Actual.col6 Ac_Col6,Actual.col7 Ac_Col7,Actual.col8 Ac_Col8,Actual.col9 Ac_Col9,Actual.col10 Ac_Col10,Actual.col11 Ac_Col11,Actual.col12 Ac_Col12,Actual.col13 Ac_Col13,Actual.col14 Ac_Col14,Actual.col15 Ac_Col15 "
										+ "from Expected_Illusration_Details Expected left join dbo.Actual_Illusration_Details Actual "
										+ "on Expected.planid = Actual.planid and "
										+ "Expected.planreleaseid = Actual.planreleaseid and "
										+ "Expected.plancycleid = Actual.plancycleid and "
										+ "Expected.col2 = Actual.col2 and "
										+ "Expected.test_case = Actual.test_case "
										+ "where Expected.col2 = '"
										+ oRSQuery1.getString(oMetaData
												.getColumnName(7))
												+ "' and Expected.test_case = '"
												+ sPlanTestcaseId
												+ "' and Expected.planid = '"
												+ sPlanID
												+ "' and Expected.planreleaseid = '"
												+ sReleaseID
												+ "' and Expected.plancycleid = '"
												+ sCycleID + "'");
						if (oRSQueryTemp.next()) {
							logger.info("sQuery="
									+ "insert into Compare_Illusration_Details values('"
									+ oRSQueryTemp.getString("planid")
									+ "','"
									+ oRSQueryTemp.getString("planreleaseid")
									+ "','"
									+ oRSQueryTemp.getString("plancycleid")
									+ "','"
									+ oRSQueryTemp.getString("test_case")
									+ "','"
									+ oRSQueryTemp.getString("test_case_ser")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col1")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col2")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col3")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col4")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col5")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col6")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col7")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col8")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col9")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col10")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col11")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col12")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col13")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col14")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col15")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col1")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col2")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col3")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col4")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col5")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col6")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col7")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col8")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col9")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col10")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col11")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col12")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col13")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col14")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col15")
									+ "','Pass')");
							oStmt.executeUpdate("insert into Compare_Illusration_Details values('"
									+ oRSQueryTemp.getString("planid")
									+ "','"
									+ oRSQueryTemp.getString("planreleaseid")
									+ "','"
									+ oRSQueryTemp.getString("plancycleid")
									+ "','"
									+ oRSQueryTemp.getString("test_case")
									+ "','"
									+ oRSQueryTemp.getString("test_case_ser")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col1")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col2")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col3")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col4")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col5")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col6")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col7")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col8")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col9")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col10")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col11")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col12")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col13")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col14")
									+ "','"
									+ oRSQueryTemp.getString("Ex_Col15")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col1")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col2")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col3")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col4")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col5")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col6")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col7")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col8")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col9")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col10")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col11")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col12")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col13")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col14")
									+ "','"
									+ oRSQueryTemp.getString("Ac_Col15")
									+ "','Pass')");
						}
					} else {
						oStmt = oConn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY);
						ResultSet oRSQueryTemp1 = oStmt
								.executeQuery("select * from dbo.Actual_Illusration_Details "
										+ "where  planid = '"
										+ sPlanID
										+ "' and planreleaseid = '"
										+ sReleaseID
										+ "' and plancycleid = '"
										+ sCycleID
										+ "' and test_case = '"
										+ sPlanTestcaseId
										+ "' and col2 = '"
										+ oRSQuery1.getString(oMetaData
												.getColumnName(7)) + "'");
						if (oRSQueryTemp1.next()) {
							oStmt = oConn.createStatement(
									ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);
							logger.info("sQuery="
									+ "select Expected.planid planid,Expected.planreleaseid,Expected.plancycleid,Expected.test_case,Expected.test_case_ser,"
									+ "Expected.col1 Ex_Col1,Expected.col2 Ex_Col2,Expected.col3 Ex_Col3,Expected.col4 Ex_Col4,Expected.col5 Ex_Col5,Expected.col6 Ex_Col6,Expected.col7 Ex_Col7,Expected.col8 Ex_Col8,Expected.col9 Ex_Col9,Expected.col10 Ex_Col10,Expected.col11 Ex_Col11,Expected.col12 Ex_Col12,Expected.col13 Ex_Col13,Expected.col14 Ex_Col14,Expected.col15 Ex_Col15,"
									+ "Actual.col1 Ac_Col1,Actual.col2 Ac_Col2,Actual.col3 Ac_Col3,Actual.col4 Ac_Col4,Actual.col5 Ac_Col5,Actual.col6 Ac_Col6,Actual.col7 Ac_Col7,Actual.col8 Ac_Col8,Actual.col9 Ac_Col9,Actual.col10 Ac_Col10,Actual.col11 Ac_Col11,Actual.col12 Ac_Col12,Actual.col13 Ac_Col13,Actual.col14 Ac_Col14,Actual.col15 Ac_Col15 "
									+ "from Expected_Illusration_Details Expected left join dbo.Actual_Illusration_Details Actual "
									+ "on Expected.planid = Actual.planid and "
									+ "Expected.planreleaseid = Actual.planreleaseid and "
									+ "Expected.plancycleid = Actual.plancycleid and "
									+ "Expected.col2 = Actual.col2 and "
									+ "Expected.test_case = Actual.test_case "
									+ "where Expected.col2 = '"
									+ oRSQuery1.getString(oMetaData
											.getColumnName(7))
											+ "' and Expected.test_case = '"
											+ sPlanTestcaseId
											+ "' and Expected.planid = '" + sPlanID
											+ "' and Expected.planreleaseid = '"
											+ sReleaseID
											+ "' and Expected.plancycleid = '"
											+ sCycleID + "'");
							ResultSet oRSQueryTemp = oStmt
									.executeQuery("select Expected.planid planid,Expected.planreleaseid,Expected.plancycleid,Expected.test_case,Expected.test_case_ser,"
											+ "Expected.col1 Ex_Col1,Expected.col2 Ex_Col2,Expected.col3 Ex_Col3,Expected.col4 Ex_Col4,Expected.col5 Ex_Col5,Expected.col6 Ex_Col6,Expected.col7 Ex_Col7,Expected.col8 Ex_Col8,Expected.col9 Ex_Col9,Expected.col10 Ex_Col10,Expected.col11 Ex_Col11,Expected.col12 Ex_Col12,Expected.col13 Ex_Col13,Expected.col14 Ex_Col14,Expected.col15 Ex_Col15,"
											+ "Actual.col1 Ac_Col1,Actual.col2 Ac_Col2,Actual.col3 Ac_Col3,Actual.col4 Ac_Col4,Actual.col5 Ac_Col5,Actual.col6 Ac_Col6,Actual.col7 Ac_Col7,Actual.col8 Ac_Col8,Actual.col9 Ac_Col9,Actual.col10 Ac_Col10,Actual.col11 Ac_Col11,Actual.col12 Ac_Col12,Actual.col13 Ac_Col13,Actual.col14 Ac_Col14,Actual.col15 Ac_Col15 "
											+ "from Expected_Illusration_Details Expected left join dbo.Actual_Illusration_Details Actual "
											+ "on Expected.planid = Actual.planid and "
											+ "Expected.planreleaseid = Actual.planreleaseid and "
											+ "Expected.plancycleid = Actual.plancycleid and "
											+ "Expected.col2 = Actual.col2 and "
											+ "Expected.test_case = Actual.test_case "
											+ "where Expected.col2 = '"
											+ oRSQuery1.getString(oMetaData
													.getColumnName(7))
													+ "' and Expected.test_case = '"
													+ sPlanTestcaseId
													+ "' and Expected.planid = '"
													+ sPlanID
													+ "' and Expected.planreleaseid = '"
													+ sReleaseID
													+ "' and Expected.plancycleid = '"
													+ sCycleID + "'");
							if (oRSQueryTemp.next()) {
								String sTempStatus = "Pass";
								sTempStr = "Illustration Comparision Passed with 1% Tolarance";
								try {

									for (int iTol = 3; iTol < 16; iTol = iTol + 1) {
										oRSQueryTemp.getString("Ac_Col" + iTol);
										if (((oRSQueryTemp.getString(
												"Ex_Col" + iTol).equals("n/a")
												|| (oRSQueryTemp
														.getString("Ex_Col"
																+ iTol)
																.equals("0")) || oRSQueryTemp
																.getString("Ex_Col" + iTol)
																.equals("***")) && (oRSQueryTemp
																		.getString("Ac_Col" + iTol)
																		.equals("***")
																		|| oRSQueryTemp.getString(
																				"Ac_Col" + iTol)
																				.equals("0")
																				|| oRSQueryTemp.getString(
																						"Ac_Col" + iTol)
																						.equals("*") || oRSQueryTemp
																						.getString("Ac_Col" + iTol)
																						.equals("-")))
																						|| oRSQueryTemp.getString(
																								"Ex_Col" + iTol)
																								.equals("X")
																								|| oRSQueryTemp.getString(
																										"Ex_Col" + iTol)
																										.equals("-")) {
											// Ignore
											sTempStr = "";
										} else if (!oRSQueryTemp.getString(
												"Ex_Col" + iTol).equals("")
												&& !oRSQueryTemp.getString(
														"Ac_Col" + iTol)
														.equals("")) {
											int iEx = Integer
													.parseInt(oRSQueryTemp
															.getString(
																	"Ex_Col"
																			+ iTol)
																			.replace(".", "")
																			.replace(",", ""));
											int iAc = Integer
													.parseInt(oRSQueryTemp
															.getString(
																	"Ac_Col"
																			+ iTol)
																			.replace(".", "")
																			.replace(",", ""));
											int tolarnace = iEx / 100;
											int diff = Math.abs(iEx - iAc);
											if (diff > tolarnace) {
												sTempStatus = "Fail";
												iIllFlag = false;
												break;
											}
										}
									}
								} catch (Exception e) {
									sTempStatus = "Fail";
									iIllFlag = false;
								}
								logger.info("sQuery="
										+ "insert into "
										+ "Compare_Illusration_Details values('"
										+ oRSQueryTemp.getString("planid")
										+ "','"
										+ oRSQueryTemp
										.getString("planreleaseid")
										+ "','"
										+ oRSQueryTemp.getString("plancycleid")
										+ "','"
										+ oRSQueryTemp.getString("test_case")
										+ "','"
										+ oRSQueryTemp
										.getString("test_case_ser")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col1")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col2")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col3")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col4")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col5")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col6")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col7")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col8")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col9")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col10")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col11")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col12")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col13")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col14")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col15")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col1")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col2")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col3")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col4")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col5")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col6")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col7")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col8")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col9")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col10")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col11")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col12")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col13")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col14")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col15")
										+ "','" + sTempStatus + "')");
								oStmt.executeUpdate("insert into Compare_Illusration_Details values('"
										+ oRSQueryTemp.getString("planid")
										+ "','"
										+ oRSQueryTemp
										.getString("planreleaseid")
										+ "','"
										+ oRSQueryTemp.getString("plancycleid")
										+ "','"
										+ oRSQueryTemp.getString("test_case")
										+ "','"
										+ oRSQueryTemp
										.getString("test_case_ser")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col1")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col2")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col3")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col4")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col5")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col6")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col7")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col8")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col9")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col10")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col11")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col12")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col13")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col14")
										+ "','"
										+ oRSQueryTemp.getString("Ex_Col15")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col1")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col2")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col3")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col4")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col5")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col6")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col7")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col8")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col9")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col10")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col11")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col12")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col13")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col14")
										+ "','"
										+ oRSQueryTemp.getString("Ac_Col15")
										+ "','" + sTempStatus + "')");
							}
						}
					}
				}
			}
			if (iIllFlag && !(sTempStr.equals(""))) {
				sOutput = sOutput + " | " + sTempStr;
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			logger.error(e.getMessage());
		}
		return iTerminateInd;
	}

	public int handlealert() {
		logger.info("Inside HandleAlert");
		iReturnValue = 0;
		try {
			String[] oArr = sSFStepKeyword.split(":");
			String sAlertText = oArr[0];
			String sAlertAction = oArr[1];
			int sAlertTimeout = Integer.parseInt(oArr[2]);
			String sAlertCondition = oArr[3];
			int iWaitTime = 0;
			while (true) {
				if (oDriver != null) {
					try {
						String sAlertActualText = oDriver.switchTo().alert()
								.getText();
						if (sAlertActualText.contains(sAlertText)) {
							logger.info("Alert Text : " + sAlertActualText);
							// if (sAlertAction.equalsIgnoreCase("Accept")) {
							// Updateby Latha on 24Feb2018: alert conatins the
							// text as Yes
							if (sAlertAction.equalsIgnoreCase("Yes")) {
								oDriver.switchTo().alert().accept();
							} else {
								oDriver.switchTo().alert().dismiss();
							}
						} else {
							throw new Exception("Unexpected Alert with Text : "
									+ sAlertActualText);
						}
						break;
					} catch (Exception e) {
						if (e.getMessage().contains(
								"Unexpected Alert with Text")) {
							throw new Exception(e.getMessage());
						}
					}
					Thread.sleep(1000);
					iWaitTime = iWaitTime + 1;
					if (iWaitTime > sAlertTimeout) {
						if (sAlertCondition.equalsIgnoreCase("Optional")) {
							break;
						} else {
							captureerror();
							throw new Exception(
									"Timeout Error while HandleAlert");
						}
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
			// iTerminateInd = 1;
			try {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iTerminateInd;
	}

	// not used

	public int inputdate() {
		iTerminateInd = 0;
		try {
			logger.info("Inside InputDate");
			iReturnValue = 0;

			String[] otestobj = sSFStepKeyword.split(",");
			String oAge = otestobj[1];
			String oDob = otestobj[0];
			if (oGlobalMap.get(oDob.toLowerCase()).isEmpty()) {
				logger.info("Object Name=" + oAge);
				GetObj(oAge);
				if (oTestObject != null || arrTestObjects != null) {
					String agefromscreen = oTestObject.getText();
					int age = Integer.parseInt(agefromscreen);
					int age1 = age * 365 + 30;
					java.util.Date d1 = DateUtils.addDays(new java.util.Date(),
							-age1);
					System.out.println(DateUtils.addDays(new java.util.Date(),
							-age1));
					SimpleDateFormat oDF = new SimpleDateFormat("dd-MMM-yyyy");
					oDF.setTimeZone(TimeZone.getTimeZone("UTC"));
					String sRCExecutionTime = oDF.format(d1);
					System.out.println(sRCExecutionTime);
					GetObj(oDob);
					if ((oTestObject.getAttribute(".readOnly").toString()
							.equalsIgnoreCase("false"))) {
						oTestObject.sendKeys(sRCExecutionTime);
					}
				}
			}
		} catch (Exception e) {
			try {
				iReturnValue = 1;
				// iTerminateInd = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
			} catch (Exception e1) {

			}
		}
		return iTerminateInd;
	}

	public int waitforobject() {
		logger.info("Inside waitForObject");
		iReturnValue = 0;
		iTicket = 0;
		String UIName;
		try {
			GetObj(sSFStepKeyword.split(":")[0]);
			int iTimeout = Integer.parseInt(sSFStepKeyword.split(":")[1]); //Integer.parseInt(sMaxDynamicWaitTime);
			int iCounter = 0;

			if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
				if (sUIName.equalsIgnoreCase("Native")) {
					oDriver_Mob.useNativeIdentification();
					UIName = "Native";
				} else {
					oDriver_Mob.useWebIdentification();
					UIName = "WEB";
				}
				boolean b = false;
				while (b == false) {
					Thread.sleep(30);
					iCounter = iCounter + 1;
					b = oDriver_Mob.client.waitForElement(UIName, oTestObject1,
							0, iTimeout);
					if (iCounter > iTimeout) {
						sTempOutput = sOutput;
						iTicket = 1;
						iReturnValue = 1;
						iTerminateInd = 1;
						// iRCTCTerminateInd = 1;
						throw new Exception("Timeout Error "
								+ sSFStepKeyword.split(":")[0]
										+ " Object not found ");
					}
				}
			} else {
				while (oTestObject == null) {
					Thread.sleep(30);
					iCounter = iCounter + 1;
					if (iCounter > iTimeout) {
						sTempOutput = sOutput;
						iTicket = 1;
						iReturnValue = 1;
						iTerminateInd = 1;
						// iRCTCTerminateInd = 1;
						throw new Exception("Timeout Error "
								+ sSFStepKeyword.split(":")[0]
										+ " Object not found ");
					}
					GetObj(sSFStepKeyword.split(":")[0]);
				}
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				// iTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];

				} else {
					//Sushant Yadav 30May2019 Descriptiopn : Error message add in Actual Result with new line 
					sOutput = sOutput + " | " + "\n" + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {
				iReturnValue = 1;
			}
		}

		return iReturnValue;
	}

	// subpopupAction

	public int subpopupaction() {
		iReturnValue = 0;
		String Action;
		logger.info("Inside SubpopAction");
		try {
			String sMainSFKeyword = sSFStepKeyword;
			String[] oObjects = sSFStepKeyword.split("#");
			String ActionFlag = oObjects[0];

			if (ActionFlag.contains(":")) {
				String[] subActions = ActionFlag.split(":"); // checking for
				// more than one
				// conditions
				// for (int i=0;i < subActions.length;i=i+1 ){
				// sri edit 7/7/2016
				if (subActions[0].contains("||")) {
					String[] subsubActions = subActions[0].split("\\|\\|");
					for (int j = 0; j < subsubActions.length; j = j + 1) {

						String sCompareFlag = "";
						sCompareFlag = CompareCondition(subsubActions[j],
								sCompareFlag);
						if (sCompareFlag.equalsIgnoreCase("Match")) {
							SubPopupActionInd = 1;
							break;
						} else {
							SubPopupActionInd = 0;
						}
					}

					if (SubPopupActionInd == 1) {
						for (int k = 1; k < subActions.length; k = k + 1) {
							String sCompareFlag = "";
							sCompareFlag = CompareCondition(subActions[k],
									sCompareFlag);
							if (sCompareFlag.equalsIgnoreCase("Match")) {
								SubPopupActionInd = 1;
							} else {

								SubPopupActionInd = 0;
								break;
							}
						}
					}
				}
				//
				else {

					for (int i = 0; i < subActions.length; i = i + 1) {
						String sCompareFlag = "";
						sCompareFlag = CompareCondition(subActions[i],
								sCompareFlag);
						if (sCompareFlag.equalsIgnoreCase("Match")) {
							SubPopupActionInd = 1;
						} else {

							SubPopupActionInd = 0;
							break;
						}
					}

				}
			}
			// Varsha
			else if (ActionFlag.contains("||")) {
				String[] subActions = ActionFlag.split("\\|\\|"); // checking
				// for more
				// than one
				// conditions
				// for (int i=0;i < subActions.length;i=i+1 ){
				// sri edit 7/7/2016
				if (subActions[0].contains("!=")) {
					String[] subsubActions = subActions[0].split("\\!\\=");
					for (int j = 0; j < subsubActions.length; j = j + 1) {

						String sCompareFlag = "";
						sCompareFlag = CompareCondition(subsubActions[j],
								sCompareFlag);
						if (sCompareFlag.equalsIgnoreCase("Match")) {
							SubPopupActionInd = 1;
							break;
						} else {
							SubPopupActionInd = 0;
						}
					}

					if (SubPopupActionInd == 1) {
						for (int k = 1; k < subActions.length; k = k + 1) {
							String sCompareFlag = "";
							sCompareFlag = CompareCondition(subActions[k],
									sCompareFlag);
							if (sCompareFlag.equalsIgnoreCase("Match")) {
								SubPopupActionInd = 1;
							} else {

								SubPopupActionInd = 0;
								break;
							}
						}
					}
				}
				//
				else {

					for (int i = 0; i < subActions.length; i = i + 1) {
						String sCompareFlag = "";
						sCompareFlag = CompareCondition(subActions[i],
								sCompareFlag);
						if (sCompareFlag.equalsIgnoreCase("Match")) {
							SubPopupActionInd = 1;
						} else {

							SubPopupActionInd = 0;
							break;
						}
					}

				}
			}

			// Varsha
			// sri edit 7/7/2016
			else if (ActionFlag.contains("||")) {
				String[] subActions = ActionFlag.split("\\|\\|");

				for (int i = 0; i < subActions.length; i = i + 1) {
					String[] subsubActions = subActions[i].split("\\!\\=");
					for (int j = 0; j < subsubActions.length; j = j + 1) {
						String sCompareFlag = "";

						sCompareFlag = CompareCondition(subsubActions[j],
								sCompareFlag);
						if (sCompareFlag.equalsIgnoreCase("Match")) {
							SubPopupActionInd = 1;
							break;
						} else {
							SubPopupActionInd = 0;
						}
						sCompareFlag = CompareCondition(subActions[i],
								sCompareFlag);
						if (sCompareFlag.equalsIgnoreCase("Match")) {
							SubPopupActionInd = 1;
							break;
						} else {
							SubPopupActionInd = 0;
						}
					}
				}
			}

			/*
			 * else if (ActionFlag.contains("!=")) { String[] subActions =
			 * ActionFlag.split("\\!\\="); for (int i = 0; i <
			 * subActions.length; i = i + 1) {
			 * 
			 * String sCompareFlag = ""; sCompareFlag =
			 * CompareCondition(subActions[i], sCompareFlag); if
			 * (sCompareFlag.equalsIgnoreCase("Match")) { SubPopupActionInd = 1;
			 * break; } else { SubPopupActionInd = 0; } } }
			 */
			else {

				String sCompareFlag = "";
				sCompareFlag = CompareCondition(ActionFlag, sCompareFlag);
				if (sCompareFlag.equalsIgnoreCase("Match")) {
					SubPopupActionInd = 1;
				} else {
					SubPopupActionInd = 0;
				}
			}
			if (SubPopupActionInd == 1) {
				SubPopupActionInd = 0;
				for (int i = 1; i < oObjects.length; i = i + 1) {
					if (iTerminateInd == 1) {
						break;
					}
					String[] subAction = oObjects[i].split("\\$\\~\\$");
					sSFStepsDesc = subAction[0];
					if (subAction.length == 2) {
						sSFStepKeyword = subAction[1];
					} else {
						sSFStepKeyword = "";
					}
					// sSFStepsDesc = subAction[0];
					// sSFStepKeyword =subAction[1];
					DataType = subAction[0];
					FunctionCall();
					SubPopupActionInd = 0;
				}
			}
		}

		catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e2) {

			}
		}
		return iReturnValue;
	}

	public String CompareCondition(String sCompareData, String StsCompareFlagr) {
		try {
			logger.info("Inside to check Subpopup Condition ");
			System.out.println("");
			String ExpData = "";
			String ActData;
			if (sCompareData.contains("!=")) {
				logger.info("Inside to check not equal Condition");
				String compare = "";
				ExpData = sCompareData.split("!=")[0];
				ActData = sCompareData.split("=")[1].trim();
				logger.info("Expected Value to check Subpopup Condition : "
						+ ActData);
				logger.info("Actual Value to check Subpopup Condition  : "
						+ oGlobalMap.get(sCompareData.split("!=")[0]
								.toLowerCase().trim()));
				compare = oGlobalMap.get(sCompareData.split("!=")[0]
						.toLowerCase().trim());
				if (!ActData.equalsIgnoreCase(oGlobalMap.get(sCompareData
						.split("!=")[0].toLowerCase().trim()))) {
					if (compare != null || !compare.equals("")) {
						StsCompareFlagr = "Match";
						logger.info("Condition Matched");
					} else {
						logger.info("Condition not-Matched");

					}

				} else {
					logger.info("Condition not-Matched");
				}
			}

			else if (sCompareData.contains("=")) {
				ExpData = sCompareData.split("=")[0];
				ActData = sCompareData.split("=")[1].trim();
				logger.info("Expected Value to check Subpopup Condition : "
						+ ActData);
				logger.info("Actual Value to check Subpopup Condition  : "
						+ oGlobalMap.get(sCompareData.split("=")[0]
								.toLowerCase().trim()));
				if (ActData.equalsIgnoreCase(oGlobalMap.get(sCompareData
						.split("=")[0].toLowerCase().trim()))) {
					StsCompareFlagr = "Match";
					logger.info("Condition Matched");
				} else {
					logger.info("Condition not-Matched");
				}
			}

			else {

				// ExpData=oGlobalMap.get(ExpData);
				ExpData = oGlobalMap.get(sCompareData.toLowerCase());
				logger.info("ExpData to Condition Matched : " + ExpData);
				if ((ExpData == null) || (ExpData.equalsIgnoreCase("NULL"))) {
					ExpData = "";
				}
				if ((ExpData != null) && !(ExpData.equals(""))) {
					StsCompareFlagr = "Match";
					logger.info("ExpData Matched");
				}
			}
		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				sOutput = e.getMessage().split("\\n") + " | " + sOutput;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return StsCompareFlagr;

	}

	
	
	public int ifobjectexists() {
		iReturnValue = 0;
		int IfObjectExist = 0;
		logger.info("inside    ifObjectExists");
		try {
			String sMainSFKeyword = sSFStepKeyword;
			String[] oObjects = sSFStepKeyword.split("#");
			String ActionFlag = oObjects[0];
			String[] subActions = ActionFlag.split(":"); // checking for more
			// than one
			// conditions
			String UIName = null;
			for (int i = 0; i < subActions.length; i = i + 1) {
				GetObj(subActions[i]);
				// Thread.sleep(1000);
				if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
					if (sUIName.equalsIgnoreCase("Native")) {
						// ((MobileWebDriver)
						// oDriver).useNativeIdentification();
						oDriver_Mob.useNativeIdentification();
						UIName = "NATIVE";
					} else {
						// ((MobileWebDriver) oDriver).useWebIdentification();
						oDriver_Mob.useWebIdentification();
						UIName = "WEB";
					}

					if (oDriver_Mob.client.isElementFound(UIName, oTestObject1,
							0)) {
						IfObjectExist = 1;
					}
					else
					{
						IfObjectExist = 0;	
					}
				} else {
					if (oTestObject != null && oTestObject.isDisplayed()) {
						IfObjectExist = 1;
					} else {
						IfObjectExist = 0;
					}
				}
			}
			if (IfObjectExist == 1) {
				for (int i = 1; i < oObjects.length; i = i + 1) {
					String[] subAction = oObjects[i].split("\\$\\~\\$");
					sSFStepsDesc = subAction[0];
					if (subAction.length == 2) {
						sSFStepKeyword = subAction[1];
					}
					DataType = subAction[0];
					FunctionCall();
					SubPopupActionInd = 0;
				}
			}
		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iReturnValue = 1;
				//iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {
				iReturnValue = 1;
			}
		}
		return iReturnValue;
	}

	public int ifobjectnotexists() {
		iReturnValue = 0;
		int ifObjectnotExists = 0;
		logger.info("inside  ifObjectnotExists");
		try {
			String sMainSFKeyword = sSFStepKeyword;
			String[] oObjects = sSFStepKeyword.split("#");
			String ActionFlag = oObjects[0];
			String[] subActions = ActionFlag.split(":"); // checking for more
			// than one
			// conditions
			for (int i = 0; i < subActions.length; i = i + 1) {
				GetObj(subActions[i]);
				if (!((oDriver_Mob.client.isElementFound(UIName, oTestObject1,0)))) {
					ifObjectnotExists = 1;
				} else {
					ifObjectnotExists = 0;
				}
			}
			if (ifObjectnotExists == 1) {
				for (int i = 1; i < oObjects.length; i = i + 1) {
					String[] subAction = oObjects[i].split("\\$\\~\\$");
					sSFStepsDesc = subAction[0];
					if (subAction.length == 2) {
						sSFStepKeyword = subAction[1];
					}
					DataType = subAction[0];
					FunctionCall();
					SubPopupActionInd = 0;
				}
			}
		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int switchtoframe() {
		logger.info("SwitchToFrame");
		iReturnValue = 0;
		int iFlag = 0;
		try {
			Thread.sleep(2000);
			int size = oDriver.findElements(By.tagName("iframe")).size();
			System.out.println("Frame Size : " + size);
			if (!(sSFStepKeyword.equals("")) || sSFStepKeyword == null) {
				if (sMobDeviceName.equalsIgnoreCase("desktop")) {
					waitforpageload();
				}
				try {
					int iFrame = Integer.parseInt(sSFStepKeyword);
					oDriver.switchTo().frame(iFrame);
					Thread.sleep(2000);
					iFlag = 1;
					iReturnValue = 0;
					iTerminateInd = 0;
				} catch (Exception ex) {
					GetObj(sSFStepKeyword);
					if (oTestObject != null) {
						oDriver.switchTo().frame(oTestObject);
						Thread.sleep(2000);
						iFlag = 1;
					} else {
						try {
							oDriver.switchTo().frame(sSFStepKeyword);
							Thread.sleep(2000);
							iFlag = 1;
						} catch (Exception e) {
							oDriver.switchTo().frame(0);
							Thread.sleep(2000);
							iFlag = 1;
							iReturnValue = 0;
							iTerminateInd = 0;
						}
					}
				}
			} else {
				oDriver.switchTo().defaultContent();
				logger.info("Switch to default frame");
				iFlag = 1;
			}
			if (iFlag == 0) {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = "Expected Frame not found " + sSFStepKeyword;
				} else {
					sOutput = sOutput + " | " + "Expected Frame not found "
							+ sSFStepKeyword;
				}
				iReturnValue = 1;
				logger.error(sOutput);
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int waittilldataexist() {

		logger.info("Inside waitTillExist");
		iReturnValue = 0;
		String Data = "";
		try {
			Thread.sleep(2000);
			GetObj(sSFStepKeyword.split(":")[0]);
			int iTimeout = Integer.parseInt(sSFStepKeyword.split(":")[1]);
			// String ActualData = sSFStepKeyword.split(":")[1];
			int iCounter = 0;
			while (Data.contains("--") || Data == null || Data == "") {
				logger.info("data in waitTillDataExist" + Data);
				Thread.sleep(1000);
				iCounter = iCounter + 1;
				if (iCounter > iTimeout) {
					throw new Exception("Timeout Error while Page Load"
							+ sSFStepKeyword.split(":")[0]);
				}
				GetObj(sSFStepKeyword.split(":")[0]);
				Data = oTestObject.getText();
				logger.info("Data in WaitTillDataExist is =" + Data);
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int captureframeerror() {
		logger.info("Inside  CaptureError");
		iReturnValue = 0;
		try {
			SessionId sSessionId = null;
			try {
				sSessionId = ((RemoteWebDriver) oDriver).getSessionId();
			} catch (Exception e) {
			}
			if (oDriver != null && sSessionId != null) {
				String sErrorDesc = "";
				List<WebElement> oErrorObjects1, oErrorObjects2, oErrorObjects3, oErrorObjects4 = null;
				WebElement oErrorObj1, oErrorObj2, oErrorObj3, oErrorObj4;
				logger.info("check for unexpected window");
				oDriver.switchTo().defaultContent();
				oDriver.switchTo().frame("InlineDialog_Iframe");
				oErrorObjects1 = oDriver.findElements(By
						.xpath("//table[@id='gridBodyTable']"));
				if (oErrorObjects1 != null && oErrorObjects1.size() != 0) {
					sErrorDesc = oDriver.findElement(
							By.xpath("//table[@id='gridBodyTable']")).getText();
					sErrorDesc = sErrorDesc.trim();
				}
				oErrorObjects2 = oDriver.findElements(By
						.xpath("//div[@id='dialogHeaderTitle']"));
				if (oErrorObjects2 != null && oErrorObjects2.size() != 0) {
					sErrorDesc = oDriver.findElement(
							By.xpath("//div[@id='dialogHeaderTitle']"))
							.getText();
					sErrorDesc = sErrorDesc.trim();
				}
				if (!sErrorDesc.equals("")) {
					sStatus = "Fail";
					if (!(sOutput.equals(""))) {
						sOutput = sErrorDesc;
					} else {
						sOutput = sOutput + " | " +"\n"+ sErrorDesc;
					}
					iReturnValue = 1;
					iRCTCTerminateInd = 1;
				} else if (sErrorDesc.equals("") && !sStatus.equals("Fail")
						&& !sStatus.equals("Terminated")) {
					sStatus = "Pass";
				}
				logger.info("Error Description=" + sErrorDesc);
			}
		} catch (NoSuchFrameException e) {
			oDriver.switchTo().frame("contentIFrame1");
			System.out.println(e.getMessage());
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
		}
		return iReturnValue;
	}

	public int performkeyevent() {
		logger.info("Inside performkeyevent");
		iReturnValue = 0;
		try {
			Robot oRobot = new Robot();
			Thread.sleep(1000);
			switch (sSFStepKeyword.toLowerCase()) {
			case "pagedown":
				oRobot.keyPress(KeyEvent.VK_PAGE_DOWN);
				break;
			case "pageup":
				oRobot.keyPress(KeyEvent.VK_PAGE_UP);
				break;
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	public int pagedown() {
		logger.info("Inside  pagedown");
		iReturnValue = 0;
		// compare
		try {
			Robot oRobot = new Robot();
			Thread.sleep(1000);
			oRobot.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);
		} catch (Exception e) {
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	public int pageup() {
		logger.info("Inside pageup");
		iReturnValue = 0;
		try {
			Robot oRobot = new Robot();
			oRobot.keyPress(KeyEvent.VK_PAGE_UP);
			Thread.sleep(2000);

		} catch (Exception e) {
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	public int refresh() {
		logger.info("Inside Refresh");
		iReturnValue = 0;
		try {
			oDriver.navigate().refresh();
		} catch (Exception e) {
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	public int switchtoframe1() {
		logger.info("SwitchToFrame1");
		iReturnValue = 0;
		int iFlag = 0;
		try {
			List<WebElement> oTestObjects1 = oDriver.findElements(By
					.tagName("frame"));
			logger.info(oTestObjects1.size());
			for (int i = 0; i <= oTestObjects1.size(); i++) {
				System.out.println("oTestObjects1 = " + oTestObjects1);
			}
			if (!(sSFStepKeyword.equals("")) || sSFStepKeyword == null) {
				waitforpageload();
				if ((sSFStepKeyword.equals("InlineDialog_Iframe"))) {
					oDriver.switchTo().defaultContent();
				}
				oDriver.switchTo().defaultContent();
				// oDriver.switchTo().frame(sSFStepKeyword);
				// updated by Latha on 24Feb2018: parsing the int number
				int iFrame = Integer.parseInt(sSFStepKeyword);
				oDriver.switchTo().frame(iFrame);
				Thread.sleep(2000);
				iFlag = 1;
			} else if ((sSFStepKeyword.equals(""))) {
				waitforpageload();
				Thread.sleep(2000);
				oDriver.switchTo().frame(1);
				oDriver.findElement(By.xpath("//*[@id='txtsearch']")).sendKeys(
						"Test");
				iFlag = 1;
			}
			if (iFlag == 0) {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = "Expected Frame not found";
				} else {
					sOutput = sOutput + " | " + "Expected Frame not found";
				}
				iReturnValue = 1;
				logger.error(sOutput);
			}
		} catch (Exception e) {
			iRCTCTerminateInd = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			iReturnValue = 1;
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	public int copyoffile() {
		System.out.println(" copyoffile");
		String FilePath = sSFStepKeyword;
		String str1 = oGlobalMap.get(FilePath.toLowerCase());
		// str1 = "C:\\Users\\q3646\\Downloads\\Attachments\\Image11c.jpg";
		try {
			String timeStamp = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss")
			.format(Calendar.getInstance().getTime());
			// Create Results folders, of not existS
			str1 = str1.replace("\\", "/");
			String ss[] = str1.split("/");
			String sa[] = str1.split("\\.");
			str1 = str1.replace(ss[ss.length - 1], timeStamp + "."
					+ sa[sa.length - 1]);
			str1 = str1.replace("/", "\\");
			System.out.println(str1);
			File F1 = new File(oGlobalMap.get(FilePath.toLowerCase()));
			File F2 = new File(str1);
			Thread.sleep(1000);
			FileUtils.copyFile(F1, F2);
			oGlobalMap.put(FilePath.toLowerCase(), str1);
			Thread.sleep(2000);
			if (sRCTestcaseID == null || sRCTestcaseID == "") {
				sRCTestcaseID = "";
			} else {
			}
			String sSQLQuery = "update " + sTableName + " set " + FilePath
					+ " = '" + str1 + "' where planid = '" + sPlanID
					+ "' and planreleaseid = '" + sReleaseID
					+ "' and plancycleid = '" + sCycleID
					+ "' and test_case = '" + sPlanTestcaseId
					+ "' and test_case_ser = '" + sRCTestcaseID + "'";
			logger.info("sSQLQuery=" + sSQLQuery);
			oStmt.executeUpdate(sSQLQuery);
		} catch (Exception e) {
			iReturnValue = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
			}
			logger.error(e.getMessage());
		}
		return iReturnValue;
	}

	// updated by latha on 28Mar2018 : to add multiple Riders
	public int multiriderselction() {


		try {
			System.out.println("Inside  multiriderselction");
			ResultSet oRSEnv = null;
			String[] oObjects = sSFStepKeyword.split(";;");
			int iEndRange = 0;
			Statement oStmt = oConn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			String sevnexeqry = "select rider_code_option,Rider_checkbox,rider_code_unit_1,rider_code_unit_2,rider_sum_assured,rider_premium,rider_loading,Confirmation_Popup_Question_Riders from Riders where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and test_case = '"
					+ sPlanTestcaseId
					+ "' and test_case_ser  = '" + sRCTestcaseID + "'";
			logger.info("EvnExeQry = " + sevnexeqry);
			oRSEnv = oStmt.executeQuery(sevnexeqry);
			List<WebElement> oTestObjects = null;
			while (oRSEnv.next()) {
				Row_sSize = oRSEnv.getRow();
				System.out.println(oObjects[0]);
				String Rider_Code = oRSEnv.getString("rider_code_option");
				if (!Rider_Code.equalsIgnoreCase("")) {
					System.out.println(Row_sSize);
					if (oDriver_Mob.client
							.isElementFound(
									UIName,
									"xpath=//*[@text='"
											+ Rider_Code
											+ "' and @hidden='false' and ./preceding-sibling::*]",
											0)) {

					} else {
						oDriver_Mob.device().swipe("DOWN", 500, 3500);
					}

					if (oRSEnv.getString("Rider_checkbox").equalsIgnoreCase("Yes")) {
					//	oTestObjects = oDriver_Mob.findElements(By.xpath("//*[@text='" + Rider_Code+ "' and ./preceding-sibling::*]"));
						oDriver_Mob.client.click(UIName, "xpath=//*[@text='"+ Rider_Code + "' and ./preceding-sibling::*]",	0, 1);
					if(oDriver_Mob.client.isElementFound(UIName,"xpath=//*[@text='INFORMATION:']/following::*[contains(@id,'alert') and @text]|//*[@text='Message']/following::*[contains(@id,'alert') and @text]"))
					{
						String str=oRSEnv.getString("Confirmation_Popup_Question_Riders");
						sSFStepKeyword="~critical";
						screens();
						oDriver_Mob.client.click(UIName, "xpath=//*[@text='OK' and @onScreen='true' and @visible='true' ]|//*[@text='"+str+"' and @onScreen='true' and @visible='true'  and @nodeName='SPAN']|//*[@text='ok' and @onScreen='true' and @visible='true' ]|//*[@text='Ok' and @onScreen='true' and @visible='true' ]|//*[@text='oK' and @onScreen='true' and @visible='true' ]", 0, 1);
					}
					
					
					}
					System.out.println(iEndRange);
					// Thread.sleep(2000);
					String str = oDriver_Mob.findElement(By.xpath("//*[@text='" + Rider_Code + "' and ./preceding-sibling::*]")).getAttribute("id");
					String[] value = null;
					if (str.contains("shortForm")) {
						value = str.split("shortForm");
					} else if (str.contains("AIAFTShortForm")) {
						value = str.split("AIAFTShortForm");
					} else if (str.contains("subRiderName")) {
						value = str.split("subRiderName");
					}

					String Sum_Assured = "input-1", Premium = "input-2", Loading = "input-3", Code_option1 = "select-1", Code_option2 = "select-2";

					if (!oRSEnv.getString("rider_code_unit_1")
							.equalsIgnoreCase("")) {
						System.out.println(value[0] + "" + Code_option1 + ""
								+ value[1]);
						oDriver_Mob.client.click(UIName, "xpath=//*[@id='"
								+ value[0] + "" + Code_option1 + "" + value[1]
										+ "'" + "]", 0, 1);

						oDriver_Mob.client.click(
								UIName,
								"xpath=//*[contains(text(),'"
										+ oRSEnv.getString("rider_code_unit_1")
										+ "') and @nodeName='LI']", 0, 1);

					}
					String sText = oRSEnv.getString("rider_code_unit_2").trim();
					System.out.println("option2 value= " + sText);
					if (!sText.equalsIgnoreCase("")) {
						System.out.println(value[0] + "" + Code_option2 + ""
								+ value[1]);

						oDriver_Mob.client.click(UIName, "xpath=//*[@id='"
								+ value[0] + "" + Code_option2 + "" + value[1]
										+ "'" + "]", 0, 1);

						oDriver_Mob.client.click(
								UIName,
								"xpath=//*[contains(text(),'"
										+ oRSEnv.getString("rider_code_unit_2")
										+ "') and @nodeName='LI']", 0, 1);

					}

					if (!oRSEnv.getString("rider_sum_assured")
							.equalsIgnoreCase("")) {
						System.out.println(value[0] + "" + Sum_Assured + ""
								+ value[1]);
						oDriver_Mob.client.click(UIName,
								"xpath=//*[@id='" + value[0] + "" + Sum_Assured
								+ "" + value[1] + "'" + "]", 0,1);
						
						oDriver_Mob.client.elementSendText(UIName,
								"xpath=//*[@id='" + value[0] + "" + Sum_Assured
								+ "" + value[1] + "'" + "]", 0,
								oRSEnv.getString("rider_sum_assured"));

						try {
							oDriver_Mob.device().closeKeyboard();
						} catch (Exception e) {
						}
					}

					if (!oRSEnv.getString("rider_premium").equalsIgnoreCase("")) {
						System.out.println(value[0] + "" + Premium + ""
								+ value[1]);

						oDriver_Mob.client.elementSendText(UIName,
								"xpath=//*[@id='" + value[0] + "" + Premium
								+ "" + value[1] + "'" + "]", 0,
								oRSEnv.getString("rider_premium"));

						try {

							oDriver_Mob.device().closeKeyboard();
						} catch (Exception e) {
						}
					}

					if (!oRSEnv.getString("rider_loading").equalsIgnoreCase("")) {

						System.out.println(value[0] + "" + Loading + ""
								+ value[1]);
						oDriver_Mob.client.click(UIName,
								"xpath=//*[@id='" + value[0] + "" + Loading
								+ "" + value[1] + "'" + "]", 0, 1);
						oDriver_Mob.client.elementSendText(UIName,
								"xpath=//*[@id='" + value[0] + "" + Loading
								+ "" + value[1] + "'" + "]", 0,
								oRSEnv.getString("rider_loading"));

						try {

							oDriver_Mob.device().closeKeyboard();
						} catch (Exception e) {
						}
					}

					iEndRange = iEndRange + 1;
				}
			}
			
			captureerror();
		//	oDriver_Mob.client.click(UIName, "id=aia-sqs-riders-code1", 0, 1);
			Thread.sleep(1000);
			
		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = e.getMessage().split("\\n")[0] + " | " + sOutput;
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	
	}

	// updated by latha on 28Mar2018 : to add multiple funds
	public int multifundselction() {

		try {

			System.out.println("Inside      multifundselction");

			ResultSet oRSEnv = null;
			String[] sCon = null;
			String sMainSFKeyword = sSFStepKeyword;
			String[] oObjects = sSFStepKeyword.split(";;");
			int iEndRange = 0;
			Statement oStmt = oConn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			String sevnexeqry = "select fund_name,fund_percentage,Confirmation_Popup_Question_Funds from Fund_Allocation where planid = '"
					+ sPlanID
					+ "' and planreleaseid = '"
					+ sReleaseID
					+ "' and plancycleid = '"
					+ sCycleID
					+ "' and test_case = '"
					+ sPlanTestcaseId
					+ "' and test_case_ser  = '" + sRCTestcaseID + "'";
			logger.info("EvnExeQry = " + sevnexeqry);
			oRSEnv = oStmt.executeQuery(sevnexeqry);
			List<WebElement> oTestObjects = null;
			while (oRSEnv.next()) {
				int sSize = oRSEnv.getRow();
				System.out.println(oObjects[0]);
				String value;
				if (!oRSEnv.getString("fund_name").equalsIgnoreCase("")) {
					if (iEndRange <= 10) {
						value = oRSEnv.getString("fund_name");
						boolean b = oDriver_Mob.client.isElementFound(UIName,"xpath=//*[@nodeName='INPUT' and ./parent::*/parent::div/parent::div/preceding-sibling::*[contains(text(),'"+ value + "')]]", 0);
						
						if (b == false) {
							sSFStepKeyword="~critical";
							screens();
							sSFStepKeyword=sMainSFKeyword;
							oDriver_Mob.device().swipe("DOWN", 500, 3500);
						}
						
						oDriver_Mob.client.click(UIName, "xpath=//*[@nodeName='INPUT' and ./parent::*/parent::div/parent::div/preceding-sibling::*[contains(text(),'"+ value + "')]]", 0, 1);
						oDriver_Mob.client
						.elementSendText(
								UIName,
								"xpath=//*[@nodeName='INPUT' and ./parent::*/parent::div/parent::div/preceding-sibling::*[contains(text(),'"
										+ value + "')]]", 0,
										oRSEnv.getString("fund_percentage"));

						try {
							oDriver_Mob.device().closeKeyboard();
						} catch (Exception e) {

						}
						
						captureerror();
					}
				}
				iEndRange = iEndRange + 1;
				
				if (!oRSEnv.getString("Confirmation_Popup_Question_Funds").equalsIgnoreCase("")) {
					String value1 = oRSEnv.getString("Confirmation_Popup_Question_Funds");
					boolean b = oDriver_Mob.client.isElementFound(UIName,"xpath=//*[contains(text(),'chosen does NOT match with your investment risk tolerance level. Are you going to proceed with the fund')]/following::*[@nodeName='SPAN' and @text='"+ value1 + "']", 0);
					
					if (b == true) {
						sSFStepKeyword="~critical";
						screens();
						sSFStepKeyword=sMainSFKeyword;
						oDriver_Mob.client.click(UIName,"xpath=//*[contains(text(),'chosen does NOT match with your investment risk tolerance level. Are you going to proceed with the fund')]/following::*[@nodeName='SPAN' and @text='"+ value1 + "']", 0,1);
					}
				}
			}
			if (!oDriver_Mob.client.isElementFound(UIName,"xpath=//*[@text='TOTAL:' and @hidden='false']", 0))
			{
				sSFStepKeyword="~critical";
				screens();
				sSFStepKeyword=sMainSFKeyword;
				Thread.sleep(1000);
				
				oDriver_Mob.device().swipe("DOWN", 500, 3500);
				
			}
			oDriver_Mob.findElement(By.xpath("//*[@text='TOTAL:']")).click();
			oDriver_Mob.findElement(By.xpath("//*[@text='TOTAL:']")).click();
			Thread.sleep(1000);
		

		} catch (Exception e) {
			try {
				// iTerminateInd = 1;
				iReturnValue = 1;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = e.getMessage().split("\\n")[0] + " | " + sOutput;
				}
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	
	
	}

	public int genrandomnum() {
		logger.info("Inside    genrandomnum");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			String[] oObjects = sIDSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				String sTestData = "";
				String[] oObj = oObjects[iObjInd].split(":");

				switch (oObj[1].toUpperCase()) {
				case "CH":
					break;
				case "NU":
					Random rand = new Random();
					int idata = 10000 + rand.nextInt(99999);
					sTestData = String.valueOf(idata).substring(0, 5);
					// sTestData="-"+sTestData.substring(0,
					// 2)+"-"+sTestData.substring(2, 5);
					break;
				case "AN":
					break;
				}
				Boolean coloumncheck = oGlobalMap.containsKey(oObj[0]
						.toLowerCase());
				if (coloumncheck == true) {
					String sSQLQuery = "update " + sTableName + " set "
							+ oObj[0] + " = '" + sTestData
							+ "' where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and test_case = '" + sPlanTestcaseId
							+ "' and test_Case_ser = '" + sRCTestcaseID + "'";
					logger.info("sSQLQuery=" + sSQLQuery);
					oStmt.executeUpdate(sSQLQuery);
					logger.info("Data for " + oObj[0].toLowerCase() + " - "
							+ sTestData);
					oGlobalMap.put(oObj[0].toLowerCase(), sTestData);
				}
			}
		} catch (Exception e) {
			try {
				logger.info("Inside  InputData exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error("InputData exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}
	

	public int concatenatedata() {
		logger.info("Inside concatenatedata");
		iReturnValue = 0;
		
		//Date sEmailSentTime = new Date();
		String sIDSFStepKeyword = sSFStepKeyword;
		System.out.println(" Date = "+sDate);
		String sTestData = "";
		String sTestDataTmp = "";
		try {
			String[] oObjects = sIDSFStepKeyword.split(";;");
			
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
//				oObjects = oObjects[iObjInd].split(":");
				
				if (oObjects[iObjInd].contains(":")) {
					oObjects[iObjInd] = oObjects[iObjInd].split(":")[0];
				}
				sTestDataTmp = oGlobalMap.get(oObjects[iObjInd].toLowerCase());
				
				if (!sTestData.equalsIgnoreCase("") && !sTestDataTmp.equalsIgnoreCase("")) {
					sTestData = sTestData +"_"+ sTestDataTmp;
				}else if (!sTestDataTmp.equalsIgnoreCase("")) {
					sTestData = sTestDataTmp;
				}
				System.out.println(sTestData);
			}
			
				String[] oObj = sIDSFStepKeyword.split(":");


				//Sushant Yadav :21-06-2019 :Script not passing proper Date and time for PDF comparison.
				 Date sEmailTime11 = new Date();
			     Date oDateTemp11 = new Date(sEmailTime11.getTime());
				 SimpleDateFormat oDF11 = new SimpleDateFormat("hh.mm aa");
					
				 sEmailDate = new SimpleDateFormat("dd-MM-yyyy").format(sEmailTime11);
				 sEmailSentTime=oDF11.format(oDateTemp11);
				sTestData = " " +sTestData +"_"+sEmailDate+"_"+sEmailSentTime;
				System.out.println("TestData = " +sTestData);

				
				oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sQuery = "select * from "+sTableName+" where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and test_case = '"
						+ sPlanTestcaseId
						+ "'";
				
				logger.info(sQuery);
				String sPsd = "",emailid="",sInsuredFN ="",ssInsuredDOB="",sDOB_D="",sDOB_M="",sDOB_Y="",sPDFPWD="" ;
				ResultSet oRSQuery = oStmt
						.executeQuery(sQuery);
				if (oRSQuery.next()) {
//					sPsd = oRSQuery.getString("emailpdfpassword");
					emailid = oRSQuery.getString("emailto");
					sInsuredFN = oRSQuery.getString("firstname_life_insured");
					ssInsuredDOB = oRSQuery.getString("dob_life_insured");
				}
				sInsuredFN = sInsuredFN.substring(0, 2).toUpperCase();
				sDOB_D = ssInsuredDOB.substring(0, 2);
				sDOB_M = ssInsuredDOB.substring(2, 4);
				sDOB_Y = ssInsuredDOB.substring(4, 8);
				
				sPDFPWD = sInsuredFN+sDOB_M+sDOB_D+sDOB_Y;
				
				
				oStmt = oConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				String sQuery1 = "select * from iPOS_ContactCreation where planid = '"
						+ sPlanID
						+ "' and planreleaseid = '"
						+ sReleaseID
						+ "' and plancycleid = '"
						+ sCycleID
						+ "' and test_case = '"
						+ sPlanTestcaseId
						+ "'";
				
				logger.info(sQuery1);
				String ATS_ID = "";
				ResultSet oRSQuery1 = oStmt
						.executeQuery(sQuery1);
				if (oRSQuery1.next()) {
//					sPsd = oRSQuery.getString("emailpdfpassword");
					ATS_ID = oRSQuery1.getString("ats_id");
				}
				sAtsid=ATS_ID;
				sTestData = " Password : " +sPDFPWD +"_ATS ID : "+ATS_ID+ "_"+sTestData;
			
				Boolean coloumncheck = oGlobalMap.containsKey(oObj[1]
						.toLowerCase());
				if (coloumncheck == true) {
					String sSQLQuery = "update " + sTableName + " set "
							+ oObj[1] + " = '" + sTestData
							+ "' where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and test_case = '" + sPlanTestcaseId
							+ "' and test_Case_ser = '" + sRCTestcaseID + "'";
					logger.info("sSQLQuery=" + sSQLQuery);
					oStmt.executeUpdate(sSQLQuery);
					logger.info("Data for " + oObj[0].toLowerCase() + " - "
							+ sTestData);
					sEmailSub =sTestData;
					oGlobalMap.put(oObj[1].toLowerCase(), sTestData);
				}
			
		} catch (Exception e) {
			try {
				logger.info("Inside  InputData exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error("concatenatedata exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	

	public int concatenatedataOld() {
		logger.info("Inside concatenatedata");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		System.out.println(" Date = "+sDate);
		try {
			String[] oObjects = sIDSFStepKeyword.split(";;");
			for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
				logger.info("Object Name=" + oObjects[iObjInd]);
				String sTestData = "";
				String[] oObj = oObjects[iObjInd].split(":");
				for (int iObj = 0; oObj.length > iObj; iObj = iObj + 1) {
					// sTestData="-"+sTestData.substring(0,
					// 2)+"-"+sTestData.substring(2, 5);
					// sTestData=sTestData.substring(0,
					// 6)+"-"+sTestData.substring(6,
					// 8)+"-"+sTestData.substring(8, 12);
					sTestData = sTestData
							+ oGlobalMap.get(oObj[iObj].toLowerCase());

				}
				System.out.println(sTestData);
//				sTestData = sTestData.substring(0, 6) + "-"
//						+ sTestData.substring(6, 8) + "-"
//						+ sTestData.substring(8, 12);
				
				if (!sTestData.equalsIgnoreCase("")) {
					sTestData=sTestData + "_ "+sTestData;
				}
				System.out.println(sTestData);

				Boolean coloumncheck = oGlobalMap.containsKey(oObj[1]
						.toLowerCase());
				if (coloumncheck == true) {
					String sSQLQuery = "update " + sTableName + " set "
							+ oObj[1] + " = '" + sTestData
							+ "' where planid = '" + sPlanID
							+ "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID
							+ "' and test_case = '" + sPlanTestcaseId
							+ "' and test_Case_ser = '" + sRCTestcaseID + "'";
					logger.info("sSQLQuery=" + sSQLQuery);
					oStmt.executeUpdate(sSQLQuery);
					logger.info("Data for " + oObj[0].toLowerCase() + " - "
							+ sTestData);
					oGlobalMap.put(oObj[1].toLowerCase(), sTestData);
				}
			}
		} catch (Exception e) {
			try {
				logger.info("Inside  InputData exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error("concatenatedata exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	
	
	public void logout() {

		logger.info("Inside logout");
		try
		{
		Boolean b = oDriver_Mob.client.isElementFound("WEB","xpath=//*[@id='mainLayout-menu']", 0);
		Boolean a = false;
		if (b.equals(false)) {
			for (int i = 0; i <= 5; i++) {
				
				if (oDriver_Mob.client.isElementFound("WEB","xpath=//*[contains(text(),'CANCEL']", 0)) {
				
					oDriver_Mob.client.click("WEB","xpath=//*[contains(text(),'CANCEL']",0,1);
					a=true;
					
				} else if (oDriver_Mob.client.isElementFound("WEB",	"xpath=//*[@id='newInsured-dismiss']", 0)) {
					
					oDriver_Mob.client.click("WEB","xpath=//*[@id='newInsured-dismiss']",0,1);
					a=true;
					
				} else if (oDriver_Mob.client.isElementFound("WEB",	"xpath=//*[@id='cff_cfflist_backViewBtn']", 0)) {
					
					oDriver_Mob.client.click("WEB","xpath=//*[@id='cff_cfflist_backViewBtn']",0,1);
					a=true;
					
				} else if (oDriver_Mob.client.isElementFound("WEB",	"xpath=//*[@id='cff_contactProfile_backViewBtn']", 0)) {
					
					oDriver_Mob.client.click("WEB","xpath=//*[@id='cff_contactProfile_backViewBtn']",0,1);
					a=true;
					
				} else if (oDriver_Mob.client.isElementFound("WEB",	"xpath=//*[@id='aia-sqs-btn-2']", 0)) {
					
					oDriver_Mob.client.click("WEB","xpath=//*[@id='aia-sqs-btn-2']",0,1);
					a=true;
					
				} else if (oDriver_Mob.client.isElementFound("WEB","xpath=//*[@id='aia-sqs-lifeList-backViewBtn']", 0)) {
					
					oDriver_Mob.client.click("WEB","xpath=//*[@id='aia-sqs-lifeList-backViewBtn']",0,1);
					a=true;
					
				} else if (oDriver_Mob.client.isElementFound("WEB",	"xpath=//*[@id='mainLayout-menu']", 0)) {
					
					oDriver_Mob.client.click("WEB","xpath=//*[@id='mainLayout-menu']",0,1);
					oDriver_Mob.client.click("WEB","xpath=//*[@id='mainLayout-menuList-5']",0,1);
					oDriver_Mob.client.click("WEB","xpath=//*[@class='button-inner' and @text='Agree']",0,1);
					break;
				}
				if(a.equals(false)){
					break;
				}

			}
		} else if (b.equals(true)) {
			
			oDriver_Mob.client.click("WEB","xpath=//*[@id='mainLayout-menu']",0,1);
			oDriver_Mob.client.click("WEB","xpath=//*[@id='mainLayout-menuList-5']",0,1);
			oDriver_Mob.client.click("WEB","xpath=//*[@class='button-inner' and @text='Agree']",0,1);
		}
		if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
			if (oDriver_Mob != null) {
				oDriver_Mob.application(AppUrl1).close();
				oDriver_Mob.client.closeDeviceReflection();

			}
		}
	
	} catch (Exception e) {
		try
		{
		logger.info("Inside  Logout exception");
		String sIDSFStepKeyword1 = sSFStepKeyword;
		sSFStepKeyword = "InputDataException";
		screens();
		sSFStepKeyword = sIDSFStepKeyword1;
		captureerror();
		//iTerminateInd = 0;
		iReturnValue = 0;
		iRCTCTerminateInd = 1;
		if (sOutput.equals("")) {
			sOutput = e.getMessage().split("\\n")[0];
		} else {
			sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
		}
		logger.error(" Logout exception: " + e.getMessage());
		}
		catch(Exception e1){
			
		}
	}


	}
	
	public void Home_page() {
		logger.error("Inside Home_page");
		try {
		  	
			try {
				 oDriver_Mob.device().closeKeyboard();
			 }catch(Exception e) {
			 }
			
           Boolean a1 =oDriver_Mob.findElement(By.xpath("//*[@text='OK']")).waitFor(200);
			if (a1.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
				Thread.sleep(2000);
				try {
					 oDriver_Mob.device().closeKeyboard();
				 }catch(Exception e) {
				 }
			}
			
			Boolean a =oDriver_Mob.findElement(By.xpath("//*[@text='OK']")).waitFor(200);
			
			
			if (a.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
				Thread.sleep(2000);
				try {
					 oDriver_Mob.device().closeKeyboard();
				 }catch(Exception e) {
				 }
			}
//				oDriver_Mob.client.elementSendText("NATIVE", "xpath=//*[contains(text(),'Code')]/following-sibling::*[@class='TFEdit']", 0, "");
//				Thread.sleep(2000);
//				oDriver_Mob.client.elementSendText("NATIVE", "xpath=//*[@text='Password']/following-sibling::*", 0, "");
//				Thread.sleep(2000);
//				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='Login']", 0, 1);
				Thread.sleep(500);
//			}
			//Boolean b =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='Home' and @class='UITabBarButtonLabel']",0);
			Boolean b =oDriver_Mob.findElement(By.xpath("//*[@text='Home' and @class='UITabBarButtonLabel']")).waitFor(200);
			if (b.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='Home' and @class='UITabBarButtonLabel']", 0, 1);
				Thread.sleep(1000);
			}
			
			//Sushant Yadav : 04/09/2019 : Add Exit because we unable to switch after eSudmission if Policy number not created.
			Boolean Exit =oDriver_Mob.client.isElementFound("WEB","xpath=//*[@name='btn_cancel']",0);
			if (Exit.equals(true))
			{
				oDriver_Mob.client.click("WEB","xpath=//*[@name='btn_cancel']", 0, 1);
				Thread.sleep(2000);
				try {
					 oDriver_Mob.device().closeKeyboard();
				 }catch(Exception e) {
				 }
			}
			
			//Boolean c =oDriver_Mob.client.isElementFound("NATIVE","xpath=//*[@text='OK']",0);
			Boolean c =oDriver_Mob.findElement(By.xpath("//*[@text='OK']")).waitFor(200);
			if (c.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
				Thread.sleep(2000);
				try {
					 oDriver_Mob.device().closeKeyboard();
				 }catch(Exception e) {
				 }
			}
			
			Boolean e =oDriver_Mob.findElement(By.xpath("//*[@text='OK']")).waitFor(200);
			if (e.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
				Thread.sleep(2000);

					 oDriver_Mob.device().closeKeyboard();
			}
			
			Boolean f =oDriver_Mob.findElement(By.xpath("//*[@text='Home' and @class='UITabBarButtonLabel']")).waitFor(200);
			if (f.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=//*[@text='Home' and @class='UITabBarButtonLabel']", 0, 1);
				Thread.sleep(1000);
			}
			
			 Boolean d =oDriver_Mob.findElement(By.xpath("(//*[@accessibilityLabel='OK' and @class='RCTView' and @onScreen='true'])[1]")).waitFor(200);
			//Boolean d =oDriver_Mob.client.isElementFound("NATIVE","xpath=(//*[@accessibilityLabel='OK' and @class='RCTView' and @onScreen='true'])[1]",0);
			//Boolean d = oDriver_Mob.findElement(By.xpath("//*[@text='OK']")).waitFor(200);
			if (d.equals(true))
			{
				oDriver_Mob.client.click("NATIVE", "xpath=(//*[@accessibilityLabel='OK' and @class='RCTView' and @onScreen='true'])[1]", 0, 1);
				Thread.sleep(1000);
			}
			
			oDriver_Mob.client.setProperty("iosDevice.nonInstrumented", "false");
			Thread.sleep(500);
			
		}catch(Exception e) {
			
		}
	}
	

	public void landing_page() {

		int flag = 0;
		logger.info("Inside Landing page");

		try {
			Boolean a =oDriver_Mob.client.isElementFound("WEB","xpath=//*[@id='mainLayout-menu' and @onScreen='true']",0);
			Boolean b = oDriver_Mob.client.isElementFound("WEB","xpath=//*[@id='cff_contactProfile_backViewBtn' and @onScreen='true']|//*[@id='cff_contactProfile_backViewBtn']|//*[@id='aia-sqs-lifeList-exitBtn']|//*[@nodeName='BUTTON' and ./*[@text='Yes']]|//*[@id='beforeapp-header-saveTxt' and @onScreen='true']|//*[@nodeName='BUTTON' and ./*[@text='OK' and @onScreen='true']]|//*[@id='newCustom-cancal' and @onScreen='true']|//*[contains(text(),'CANCEL')]|//*[@id='occupationModal_dismiss']|//*[@id='occupation-nameOfEmployer']|//*[@id='newInsured-dismiss']|//*[@id='cff_cfflist_backViewBtn']|//*[@id='aia-sqs-btn-2']|//*[@id='aia-sqs-lifeList-backViewBtn']|//*[@id='EAPP_eappmodule_saveexit']", 0);

			if (b.equals(true))
			{
				for(int i=0;i<=10;i++){
			if(oDriver_Mob.client.isElementFound("WEB","xpath=//*[@id='mainLayout-menu' and @onScreen='true']",0))
			{
			a=true;
			break;
			}
			else
			{
			oDriver_Mob.client.click("WEB","xpath=//*[@id='cff_contactProfile_backViewBtn' and @onScreen='true']|//*[@id='cff_contactProfile_backViewBtn']|//*[@id='aia-sqs-lifeList-exitBtn']|//*[@nodeName='BUTTON' and ./*[@text='Yes']]|//*[@id='beforeapp-header-saveTxt' and @onScreen='true']|//*[@nodeName='BUTTON' and ./*[@text='OK' and @onScreen='true']]|//*[@id='newCustom-cancal' and @onScreen='true']|//*[contains(text(),'CANCEL')]|//*[@id='occupationModal_dismiss']|//*[@id='occupation-nameOfEmployer']|//*[@id='newInsured-dismiss']|//*[@id='cff_cfflist_backViewBtn']|//*[@id='aia-sqs-btn-2']|//*[@id='aia-sqs-lifeList-backViewBtn']|//*[@id='EAPP_eappmodule_saveexit']", 0, 1);
			}
		   }
	     }
			if(a.equals(true))
			{
				oDriver_Mob.client.click("WEB","xpath=//*[@id='mainLayout-menu']", 0, 1);
				oDriver_Mob.client.click("WEB","xpath=//*[@id='mainLayout-menuList-0']", 0, 1);
				
			}
			delete_temp();
			if(oDriver_Mob.client.isElementFound("NATIVE", "//*[@text='This phone number was associated with the Apple ID ?businessadmin@qualitykiosk.com? on ?iPhone_6?.']"))
			{
				oDriver_Mob.client.click("NATIVE","xpath=//*[@text='No' and @id='No' and @class='UIAButton']",0,1);
			}
			String DeviceName = sMobDeviceName.replace("-", ":");
			oDriver_Mob.client.releaseDevice(DeviceName, true, false, false);
			String str4 = oDriver_Mob.client.getConnectedDevices();
			System.out.println(str4);
			if (str4.contains(DeviceName)) {
				oDriver_Mob.setDevice(DeviceName);
				oDriver_Mob.client.closeDeviceReflection();
				oDriver_Mob.client.setShowPassImageInReport(false);
				oDriver_Mob.client.setShowImageInReport(false);
				oDriver_Mob.client.setSpeed("Fast");
				oDriver_Mob.device().openScreen();
				oDriver_Mob.client.launch(AppURL, true, false);

			} else {

				oDriver_Mob.setDevice(DeviceName);
				oDriver_Mob.client.closeDeviceReflection();
				oDriver_Mob.client.setShowPassImageInReport(false);
				oDriver_Mob.client.setShowImageInReport(false);
				oDriver_Mob.client.setSpeed("Fast");
				oDriver_Mob.device().openScreen();
				oDriver_Mob.client.launch(AppURL, true, false);
			}
		} catch (Exception e) {
			try {
				logger.info("Inside  Landing_page exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error("Dropdown scroll exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}

	
	}

	public static void delete_temp() {
		try {
			File tmpFile = File.createTempFile("data", null);
			String a = tmpFile.getAbsolutePath();
			System.out.println(a.lastIndexOf("\\"));
			// File newFile = File.createTempFile("text", ".temp", new
			// File("/Users/pankaj/temp"));
			System.out.println(tmpFile.getCanonicalPath());
			System.out.println(a.substring(0, a.lastIndexOf("\\")));
			if (new File(a.substring(0, a.lastIndexOf("\\"))).exists()) {
				// if(new File(sFullScreenShotPath).exists()){
				for (File file : new File(a.substring(0, a.lastIndexOf("\\")))
				.listFiles())
					file.delete();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void Close_popup() {
		JOptionPane msg = new JOptionPane("Execution Completed",
				JOptionPane.INFORMATION_MESSAGE);
		final JDialog dlg = msg.createDialog("Advert?ncia");
		dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		new Thread(new Runnable() {
			// @Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				dlg.setVisible(false);
			}
		}).start();
		dlg.setVisible(true);

	}

	public int scroll_dropdown() {
		logger.info("Inside dropdown scroll");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			GetObj(sIDSFStepKeyword);
			String view = null, pro = oTestObject1;

			if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
				if (sUIName.equalsIgnoreCase("Native")) {

					oDriver_Mob.useNativeIdentification();
					view = "NATIVE";
				} else {

					oDriver_Mob.useWebIdentification();
					view = "WEB";
				}
			}

			Boolean b = oDriver_Mob.client
					.isElementFound(
							"WEB",
							"css=UL.ant-select-dropdown-menu.ant-select-dropdown-menu-vertical.ant-select-dropdown-menu-root",
							0);

			int offest = 200;
			if (b == true) {
				for (int i = 0; i <= 15; i++) {
					if (oDriver_Mob.client.isElementFound(view, pro, 0)) {
						if (!(pro.contains("contains(text(),'6')"))) {
							//oDriver_Mob.client.click(view, pro, 0, 1);
							break;
						} else {
							oDriver_Mob.client
							.hybridRunJavascript(
									"",
									0,
									"var result = document.querySelector('UL.ant-select-dropdown-menu.ant-select-dropdown-menu-vertical.ant-select-dropdown-menu-root').scrollTop = "
											+ offest + ";");
							//oDriver_Mob.client.click(view, pro, 0, 1);
							break;
						}

					} else
						// if(!(sSFStepKeyword.contains("Industry")))
					{
						String s = oDriver_Mob.client
								.hybridRunJavascript(
										"",
										0,
										"var result = document.querySelector('UL.ant-select-dropdown-menu.ant-select-dropdown-menu-vertical.ant-select-dropdown-menu-root').scrollTop = "
												+ offest + ";");
						offest = offest + 200;
						System.out.println(s);
					}
					/*
					 * else { oDriver_Mob.device().swipe("Down", 500, 3500);
					 * 
					 * }
					 */

				}
			} else {
				offest = 900;
				for (int i = 0; i <= 15; i++) {
					if (oDriver_Mob.client.isElementFound(view, pro, 0)) {
						
						// oDriver_Mob.client.hybridRunJavascript("",0,"var result = document.querySelector('ION-LIST.main-list.list.list-ios').scrollTop = "+offest+";");
						break;
					} else {
						String s = oDriver_Mob.client
								.hybridRunJavascript(
										"",
										0,
										"var result = document.querySelector('ION-LIST.main-list.list.list-ios').scrollTop = "
												+ offest + ";");
						offest = offest + 900;
						System.out.println(s);
					}

				}
			}
		} catch (Exception e) {
			try {
				logger.info("Inside  Dropdown scroll exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 0;
				// iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				logger.error("Dropdown scroll exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	public int scroll_page() {
		logger.info("Inside   scroll Page");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			GetObj(sIDSFStepKeyword);
			String view = null, pro = oTestObject1;

			if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
				if (sUIName.equalsIgnoreCase("Native")) {

					oDriver_Mob.useNativeIdentification();
					view = "NATIVE";
				} else {

					oDriver_Mob.useWebIdentification();
					view = "WEB";
				}
			}

			for (int i = 0; i <= 5; i++) {
				
				if (oDriver_Mob.client.isElementFound(view, pro, 0)) {
					break;

				} else {
					oDriver_Mob.device().swipe("Down", 800, 3500);
				}

			}
		} catch (Exception e) {
			try {
				logger.info("Inside  scroll Page exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "InputDataException";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				// iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				logger.error("Dropdown scroll exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	public int dragdrop() {
		logger.info("Insid drag_drop");
		iReturnValue = 0;
		String sIDSFStepKeyword = sSFStepKeyword;
		try {
			String[] oObj = sIDSFStepKeyword.split(":");
			GetObj(oObj[0]);
			String test1 = oTestObject1, view = null;

			if (!(sMobDeviceName.equalsIgnoreCase("desktop"))) {
				if (sUIName.equalsIgnoreCase("Native")) {

					oDriver_Mob.useNativeIdentification();
					view = "NATIVE";
				} else {

					oDriver_Mob.useWebIdentification();
					view = "WEB";
				}
			}
			// GetObj(oObj[1]);
			// oDriver_Mob.client.dragDrop(view, test1, 0, oTestObject1, 0);
//			System.out.println(""+oTestObject1+"");
			oDriver_Mob.client.click(view, oTestObject1, 0, 1);
//			oDriver_Mob.findElement(By.xpath("//*[@accessibilityLabel='signatureIndicator']")).drag(1200, 200);
//			oDriver_Mob.findElement(By.xpath(""+oTestObject1+"")).drag(1200, 200);
			oDriver_Mob.client.drag(view, oTestObject1, 0, 1200, 200);
			
			
			

			//oDriver_Mob.client.drag(view, oTestObject1, 0, 128, 548);
			// oDriver_Mob.client.findElement(By.xpath("//*[@class='EAGLView']")).drag(128,
			// 548);

		} catch (Exception e) {
			try {
				logger.info("Inside drag_drop exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "drag_drop exception";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
				}
				logger.error("drag_drop exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	public int relaunchapp() {
		logger.info("Inside launch app");
		iReturnValue = 0;

		try {

			oDriver_Mob.client.launch(AppURL, true, false);

		} catch (Exception e) {
			try {
				logger.info("Inside relaunch app exception");
				String sIDSFStepKeyword1 = sSFStepKeyword;
				sSFStepKeyword = "launch app exception";
				screens();
				sSFStepKeyword = sIDSFStepKeyword1;
				captureerror();
				iTerminateInd = 0;
				iReturnValue = 0;
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error("launch app exception: " + e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;

	}

	public int waittillobjectpresent() {
		logger.info("Inside   waittillobjectpresent");
		iReturnValue = 0;
		iTicket = 0;
		try {
			// GetObj(sSFStepKeyword.split(":")[0]);
			Boolean b = oDriver_Mob.findElementByXPath(
					"//*[@text='Please wait ...']").isDisplayed();
			int iTimeout = Integer.parseInt(sMaxDynamicWaitTime);// Integer.parseInt(sSFStepKeyword.split(":")[1]);
			int iCounter = 0;
			while (b == true) {
				Thread.sleep(30);
				iCounter = iCounter + 1;
				if (iCounter > iTimeout) {
					sTempOutput = sOutput;
					iTicket = 1;
					throw new Exception("Timeout Error while Page Load for"
							+ sSFStepKeyword.split(":")[0]);
				}

				b = oDriver_Mob.findElementByXPath(
						"//*[@text='Please wait ...']").isDisplayed();
				// oTestObject= oDriver.findElement(By.id("ssLoadingDiv"));
				// GetObj(sSFStepKeyword.split(":")[0]);
			}
		} catch (Exception e) {
			try {
				iRCTCTerminateInd = 1;
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];

				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				iReturnValue = 1;
				logger.error(e.getMessage());
			} catch (Exception e1) {

			}
		}
		return iReturnValue;
	}

	public int updateriderfromapp() {
		logger.info("Inside updateriderfromapp");
		iReturnValue = 0;
		iTicket = 0;
		try {
			for (int i = 1; i <= Row_sSize; i++) {
				sSFStepKeyword = "Rider_Name_" + i + ":Rider_Name_" + i
						+ ";;Rider_Rider_SA_" + i + ":Rider_Rider_SA_" + i
						+ ";;Rider_Premium_" + i + ":Rider_Premium_" + i + "";
				updatedbfromapp();
				comparedbfromdb();
			}
		} catch (Exception e) {

		}
		return iReturnValue;
	}
	
	public void updateactualdata(String sFieldName, String sActValue) {
		logger.info("Inside updateactualdata");
		try {
			if (sRCTestcaseID == null || sRCTestcaseID == "") {
				// Commented runid for pru
				String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue, device"// ,RunID
						+ ") Values ('"
						+ sPlanID
						+ "','"
						+ sReleaseID
						+ "','"
						+ sCycleID
						+ "','"
						+ sPlanTestcaseId
						+ "','"
						+ sPlanTestcaseId
						+ "','"
						+ sFieldName
						+ "','"
						+ sActValue
						+ "','" + sMobDeviceName
						// + "','"
						// + sFlowCode
						+ "')";
				logger.info("sSQLQuery=" + sSQLQuery);
				oStmt.executeUpdate(sSQLQuery);
				Boolean coloumncheck = oGlobalMap.containsKey(sFieldName.toLowerCase());
				if (coloumncheck == true) {
					oGlobalMap.put(sFieldName.toLowerCase(), sActValue);
					// Commented runid for pru
					String sSQLQuery1 = "update " + sTableName + " set " + sFieldName + " = '" + sActValue
							+ "' where planid = '" + sPlanID + "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID + "' and test_case = '" + sPlanTestcaseId
							+ "' and test_case_ser = ''"; // and flow_code = '" + sFlowCode+ "'";
					logger.info("sSQLQuery=" + sSQLQuery1);
					oStmt.executeUpdate(sSQLQuery1);
				}
			} else {
				// Commented runid for pru
				String sSQLQuery = "insert into QTP_ActualResult (planid,planreleaseid,plancycleid,MainTestCaseID,TestCaseID,Field,ActualValue,device"// ,RunID
						+ ") Values ('"
						+ sPlanID
						+ "','"
						+ sReleaseID
						+ "','"
						+ sCycleID
						+ "','"
						+ sPlanTestcaseId
						+ "','"
						+ sRCTestcaseID
						+ "','"
						+ sFieldName
						+ "','"
						+ sActValue
						+ "','" + sMobDeviceName
						// + "','"
						// + sRCTCflowid
						+ "')";
				logger.info("sSQLQuery=" + sSQLQuery);
				oStmt.executeUpdate(sSQLQuery);
				Boolean coloumncheck = oGlobalMap.containsKey(sFieldName.toLowerCase());
				if (coloumncheck == true) {
					oGlobalMap.put(sFieldName.toLowerCase(), sActValue);
					// Commented runid for pru
					String sSQLQuery1 = "update " + sTableName + " set " + sFieldName + " = '" + sActValue
							+ "' where planid = '" + sPlanID + "' and planreleaseid = '" + sReleaseID
							+ "' and plancycleid = '" + sCycleID + "' and test_case = '" + sPlanTestcaseId
							+ "' and test_case_ser = '" + sRCTestcaseID + "'"; // and flow_code = '" + sFlowCode+ "'";
					logger.info("sSQLQuery=" + sSQLQuery1);
					oStmt.executeUpdate(sSQLQuery1);
				}
			}
		} catch (Exception e) {
			iTerminateInd = 1;
			iRCTCTerminateInd = 1;
			iReturnValue = 1;
			if (sOutput.equals("")) {
				sOutput = e.getMessage().split("\\n")[0];
			} else {
				sOutput = sOutput + " | " +"\n" + e.getMessage().split("\\n")[0];
			}
			logger.error(e.getMessage());
		}
	}

	
	
	public int callapi() {

			logger.info("Inside CallApi " + sSFStepKeyword + " is API Name");
			String[] sParam;
			String messageDesc = "",APIStatus = "",sResponse = "";
			iReturnValue = 0;
			try {
				String[] oObjects = sSFStepKeyword.split(";;");
				for (int iObjInd = 0; oObjects.length > iObjInd; iObjInd = iObjInd + 1) {
					HttpClient httpclient = new DefaultHttpClient();			
					try{
						String stemp = "";//args[0];
		//				String[] atemp = new String[]{ "IPOS13102016143300","IPOS","","","","A5340","Alpp@12345" };
						HttpPost request = new HttpPost("https://www.aia-uat.com.my/iposmy2/services/v1/login/generateToken");//https://www.aia-uat.com.my/iposmy2/services/v1/generateToken");
			//aia			StringEntity params = new StringEntity("{\"reqHeader\": {\"trxnRefNo\": \"IPOS13102016143300\",\"channel\": \"IPOS\",\"reqDateTime\":\"\",\"lineOfBiz\":\"\",\"language\":\"\"},\"reqBody\": {\"userId\": \"18744\",\"password\": \"Alpp@12345\"}}");//18744  23216
						StringEntity params = null ;
						String[] atemp;
						atemp = new String[7];
						switch (oObjects[iObjInd].toUpperCase()) {
							case "LOGIN":
								atemp[0] = oGlobalMap.get(("trxnRefNo").toLowerCase());
								atemp[1] = oGlobalMap.get(("channel").toLowerCase());
								atemp[2] = oGlobalMap.get(("reqDateTime").toLowerCase());
								atemp[3] = oGlobalMap.get(("lineOfBiz").toLowerCase());
								atemp[4] = oGlobalMap.get(("language").toLowerCase());
								atemp[5] = oGlobalMap.get(("Agent_ID").toLowerCase());
								atemp[6] = oGlobalMap.get(("Agent_Password").toLowerCase());
//								 atemp = {
//										oGlobalMap.get(("trxnRefNo").toLowerCase()),
//										oGlobalMap.get(("channel").toLowerCase()),
//										oGlobalMap.get(("reqDateTime").toLowerCase()),
//										oGlobalMap.get(("lineOfBiz").toLowerCase()),
//										oGlobalMap.get(("language").toLowerCase()),
//										oGlobalMap.get(("Agent_ID").toLowerCase()),
//										oGlobalMap.get(("Agent_Password").toLowerCase()),
//										};
								params = new StringEntity("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"userId\": \""+atemp[5]+"\",\"password\": \""+atemp[6]+"\"}}");//18744  23216
								System.out.println("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"userId\": \""+atemp[5]+"\",\"password\": \""+atemp[6]+"\"}}");
								break;
							case "AGENTPROFILE":
							case "LOGOUT":
								if (oObjects[iObjInd].equalsIgnoreCase("Logout")){
									request = new HttpPost("https://www.aia-uat.com.my/iposmy2/services/v1/login/logout");
								}else{
									request = new HttpPost("https://www.aia-uat.com.my/iposmy2/services/v1/login/app");
								}
								atemp[0] = oGlobalMap.get(("trxnRefNo").toLowerCase());
								atemp[1] = oGlobalMap.get(("channel").toLowerCase());
								atemp[2] = oGlobalMap.get(("reqDateTime").toLowerCase());
								atemp[3] = oGlobalMap.get(("lineOfBiz").toLowerCase());
								atemp[4] = oGlobalMap.get(("language").toLowerCase());
								atemp[5] = oGlobalMap.get(("token").toLowerCase());
//								String[] atemp2 = {
//										oGlobalMap.get(("trxnRefNo").toLowerCase()),
//										oGlobalMap.get(("channel").toLowerCase()),
//										oGlobalMap.get(("reqDateTime").toLowerCase()),
//										oGlobalMap.get(("lineOfBiz").toLowerCase()),
//										oGlobalMap.get(("language").toLowerCase()),
//										oGlobalMap.get(("token").toLowerCase()),
//										};
		//						{\"reqHeader\": {	\"trxnRefNo\": \"IPOS13102016143300\",\"channel\": \"IPOS\",\"reqDateTime\": \"\",\"lineOfBiz\": \"\",\"language\": \"\"	},\"reqBody\": {\"token\": \"Idzbi+FtYv+LzqM6Y0ehNJLUrwGxft0GP/RmbhNnwJ9yQb9H40oDoOyOuyVe0IW8DwQ2uVOkAyVXiGFemhKLFaAv6hlvcPgRXsMEcQdI+ibIgG6CzbFY2wpruSmFX7oe\"}}
								params = new StringEntity("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\": \""+atemp[2]+"\",\"lineOfBiz\": \""+atemp[3]+"\",\"language\": \""+atemp[4]+"\"	},\"reqBody\": {\"token\": \""+atemp[5]+"\"}}");//18744  23216
								System.out.println("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\": \""+atemp[2]+"\",\"lineOfBiz\": \""+atemp[3]+"\",\"language\": \""+atemp[4]+"\"	},\"reqBody\": {\"token\": \""+atemp[5]+"\"}}");
								break;
							case "NOTIFICATIONLIST":
								request = new HttpPost("https://www.aia-uat.com.my/iposmy/services/notification/list");
								atemp[0] = oGlobalMap.get(("trxnRefNo").toLowerCase());
								atemp[1] = oGlobalMap.get(("channel").toLowerCase());
								atemp[2] = oGlobalMap.get(("reqDateTime").toLowerCase());
								atemp[3] = oGlobalMap.get(("lineOfBiz").toLowerCase());
								atemp[4] = oGlobalMap.get(("language").toLowerCase());
								atemp[5] = oGlobalMap.get(("pageCount").toLowerCase());
								atemp[6] = oGlobalMap.get(("token").toLowerCase());
		//						{\"reqHeader\": {	\"trxnRefNo\": \"IPOS13102016143300\",\"channel\": \"IPOS\",\"reqDateTime\": \"\",\"lineOfBiz\": \"\",\"language\": \"\"	},\"reqBody\": {\"token\": \"Idzbi+FtYv+LzqM6Y0ehNJLUrwGxft0GP/RmbhNnwJ9yQb9H40oDoOyOuyVe0IW8DwQ2uVOkAyVXiGFemhKLFaAv6hlvcPgRXsMEcQdI+ibIgG6CzbFY2wpruSmFX7oe\"}}
								params = new StringEntity("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"pageCount\": \""+atemp[5]+"\",\"token\": \""+atemp[6]+"\"}}");//18744  23216
								System.out.println("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"pageCount\": \""+atemp[5]+"\",\"token\": \""+atemp[6]+"\"}}");
								break;
							case "CUSTOMERLIST":
								request = new HttpPost("https://www.aia-uat.com.my/iposmy/services/customerList");
								atemp[0] = oGlobalMap.get(("trxnRefNo").toLowerCase());
								atemp[1] = oGlobalMap.get(("channel").toLowerCase());
								atemp[2] = oGlobalMap.get(("reqDateTime").toLowerCase());
								atemp[3] = oGlobalMap.get(("lineOfBiz").toLowerCase());
								atemp[4] = oGlobalMap.get(("language").toLowerCase());
								atemp[5] = oGlobalMap.get(("token").toLowerCase());
								atemp[6] = oGlobalMap.get(("keyword").toLowerCase());
		//						{\"reqHeader\": {	\"trxnRefNo\": \"IPOS13102016143300\",\"channel\": \"IPOS\",\"reqDateTime\": \"\",\"lineOfBiz\": \"\",\"language\": \"\"	},\"reqBody\": {\"token\": \"Idzbi+FtYv+LzqM6Y0ehNJLUrwGxft0GP/RmbhNnwJ9yQb9H40oDoOyOuyVe0IW8DwQ2uVOkAyVXiGFemhKLFaAv6hlvcPgRXsMEcQdI+ibIgG6CzbFY2wpruSmFX7oe\"}}
								params = new StringEntity("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"token\": \""+atemp[5]+"\",\"keyword\": \""+atemp[6]+"\"}}");//18744  23216
								System.out.println("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"token\": \""+atemp[5]+"\",\"keyword\": \""+atemp[6]+"\"}}");
								break;
							case "CUSTOMERINFO":
								request = new HttpPost("https://www.aia-uat.com.my/iposmyu/services/v1/customer");
								atemp[0] = oGlobalMap.get(("trxnRefNo").toLowerCase());
								atemp[1] = oGlobalMap.get(("channel").toLowerCase());
								atemp[2] = oGlobalMap.get(("reqDateTime").toLowerCase());
								atemp[3] = oGlobalMap.get(("lineOfBiz").toLowerCase());
								atemp[4] = oGlobalMap.get(("language").toLowerCase());
								atemp[5] = oGlobalMap.get(("token").toLowerCase());
								atemp[6] = oGlobalMap.get(("nric").toLowerCase());
		//						{\"reqHeader\": {	\"trxnRefNo\": \"IPOS13102016143300\",\"channel\": \"IPOS\",\"reqDateTime\": \"\",\"lineOfBiz\": \"\",\"language\": \"\"	},\"reqBody\": {\"token\": \"Idzbi+FtYv+LzqM6Y0ehNJLUrwGxft0GP/RmbhNnwJ9yQb9H40oDoOyOuyVe0IW8DwQ2uVOkAyVXiGFemhKLFaAv6hlvcPgRXsMEcQdI+ibIgG6CzbFY2wpruSmFX7oe\"}}
								params = new StringEntity("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"token\": \""+atemp[5]+"\",\"nric\": \""+atemp[6]+"\"}}");//18744  23216
								System.out.println("{\"reqHeader\": {\"trxnRefNo\": \""+atemp[0]+"\",\"channel\": \""+atemp[1]+"\",\"reqDateTime\":\""+atemp[2]+"\",\"lineOfBiz\":\""+atemp[3]+"\",\"language\":\""+atemp[4]+"\"},\"reqBody\": {\"token\": \""+atemp[5]+"\",\"nric\": \""+atemp[6]+"\"}}");
								break;
						}
						request.addHeader("content-type", "application/json");
						request.addHeader("Accept","application/json");
						request.setEntity(params);
						HttpEntity requestEntity = request.getEntity();
						String sRequest = EntityUtils.toString(requestEntity);
						System.out.println("sRequest : " + sRequest);
						HttpResponse response = httpclient.execute(request);
						HttpEntity responsEntity = response.getEntity();
						sResponse = EntityUtils.toString(responsEntity);
						if(response.toString().indexOf("200")>0){
							System.out.println("Response header:200");
							if(sResponse.indexOf("meta")>0){
								messageDesc = "API Response Successful for " + oObjects[iObjInd];
								APIStatus = "Pass";
		//						if(sResponse.indexOf("messagedesc")>0){
		//							String res = sResponse.substring(1,1000);
		//							messageDesc = "API reverted successfully, but " +res.substring(res.indexOf("messageDesc")+14,res.indexOf("!"));
		////							APIStatus = "Fail";
		//						}else{
		//							System.out.println("Result: Premium computed successfully");
		////							APIStatus = "Pass";
		//							messageDesc = "Result: Premium computed successfully";
		//						}
							}else{
								System.out.println("Error on sent data");
								APIStatus = "Fail";
								messageDesc = "API Response Failure for " + oObjects[iObjInd];
							}
						}else{
							if(sResponse.indexOf("resultCode")>0){
								System.out.println("Error on sent data");
								APIStatus = "Fail";
								messageDesc = "API Response Failure for " + oObjects[iObjInd];
							}else{
								System.out.println("API failed to revert");
								messageDesc = "API failed to respond for " + oObjects[iObjInd];
								APIStatus = "Fail";
							}
						}	
						if (sOutput.equals("")) {
							sOutput = messageDesc;
						} else {
							sOutput = sOutput + " | " + messageDesc;
						}
						sStatus = APIStatus;
						System.out.println("Response:" +sResponse);
						System.out.println(messageDesc);
						BufferedWriter bw = null;
						FileWriter fw = null;
						String sExcelFilePath = "";
						try {
							File file = new File(sFullScreenShotPath + "/" + oObjects[iObjInd]
									+ ".txt");
							if (file.createNewFile()) {
								System.out.println("File is created!");
							} else {
								System.out.println("File already exists.");
							}
							String content = sResponse; // "This is the content to write into file1";
							fw = new FileWriter(sFullScreenShotPath + "/" + oObjects[iObjInd]
									+ ".txt");
							bw = new BufferedWriter(fw);
							bw.write(content);
							System.out.println("Done");
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try {
								if (bw != null)
									bw.close();
								if (fw != null)
									fw.close();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
		
						}
						if (APIStatus.equalsIgnoreCase("pass")){
							String sToken ="", sName = "", sAgentRank = "", sUserID = "", sMainToken = "", sAgentNric = "", suplineManagerName = "", 
									suplineRank = "", sagentBranch = "", sagentSubRegion = "", sagentRegion = "", saddress1 = "", saddress2 = "", 
									saddress3 = "", spostalcode = "", slocation = "", sstate = "", scountry = "", smobileNo = "", semail = "", sagencyCode = "", 
									sagencyName = "", sagentDOB = "", scontractDate = "", stotalPageCount = "", stotalItemCount = "", stotalNotification = "",
									sgender = "", sNRIC = "", sdob = "", srace = "", sisVitalityMember = "", stitleId = "", ssmoker = "", sOldIC = "", spassportNoOrOthers = "", smaritalStatus = "", snationality = "",
											snationalityOther = "", spermanentResident = "", sraceOther = "", sreligion = "", sagreePayment = "", swithChildren = "",
											scityOfBirth = "", scountryOfBirth = "", sindustry = "", soccupation = "", semployerName = "", snatureOfBusiness = "",
											sexactDuties = "", sannualEarnIncome = "", sreviewDate = "", sclientChoice = "", srankProtectionIndex = "", srankRetirementIndex = "",
											srankEducationIndex = "", srankSavingsIndex = "", sriskSelectionIndex = "", srecommendationReasons = "", srecommendationReasonsSelection = "", 
											sactionTakenIfDifferentRecommendation = "", siAgree = "", sisProvided = "", sisShown = "", sisGuide = "", sisReviewWithClientOnCurrentInsurance = "",User_Id="",Home_address1="",Home_address2="",Home_address3="",Home_address4="",Home_city="",Home_country="",Home_postcode="";
							switch (oObjects[iObjInd].toUpperCase()) {
								case "LOGIN":
									if (sResponse.contains("token")) {
										if ((sResponse.split("token\":\"").length) == 1) {
										} else {
											sToken = (sResponse.split("token\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("name")) {
										if ((sResponse.split("name\":\"").length) == 1) {
										} else {
											sName = (sResponse.split("name\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentRank")) {
										if ((sResponse.split("agentRank\":\"").length) == 1) {
										} else {
											sAgentRank = (sResponse.split("agentRank\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("userId")) {
										if ((sResponse.split("userId\":\"").length) == 1) {
										} else {
											sUserID = (sResponse.split("userId\":\"")[1]).split("\"")[0];
											User_Id="00000" + sUserID;
											
										}
									}
								//	sMainToken = EncryptToken.generateEncryptedToken(sUserID, sToken);
									
									updateexpecteddata(sPlanTestcaseId,"Agent_ID_Login", User_Id,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"AgentName_Login", sName,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"AgentRank_Login", sAgentRank,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"token", sMainToken,sPlanTestcaseId,sPlanTestcaseId);
									updateactualdata("token", sMainToken);
									break;
								case "AGENTPROFILE":
									if (sResponse.contains("userId")) {
										if ((sResponse.split("userId\":\"").length) == 1) {
										} else {
											sUserID = (sResponse.split("userId\":\"")[1]).split("\"")[0];
											User_Id="00000" + sUserID;
										}
									}
									if (sResponse.contains("name")) {
										if ((sResponse.split("name\":\"").length) == 1) {
										} else {
											sName = (sResponse.split("name\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentNric")) {
										if ((sResponse.split("agentNric\":\"").length) == 1) {
										} else {
											sAgentNric = (sResponse.split("agentNric\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentRank")) {
										if ((sResponse.split("agentRank\":\"").length) == 1) {
										} else {
											sAgentRank = (sResponse.split("agentRank\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("uplineManagerName")) {
										if ((sResponse.split("uplineManagerName\":\"").length) == 1) {
										} else {
											suplineManagerName = (sResponse.split("uplineManagerName\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("uplineRank")) {
										if ((sResponse.split("uplineRank\":\"").length) == 1) {
										} else {
											suplineRank = (sResponse.split("uplineRank\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentBranch")) {
										if ((sResponse.split("agentBranch\":\"").length) == 1) {
										} else {
											sagentBranch = (sResponse.split("agentBranch\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentSubRegion")) {
										if ((sResponse.split("agentSubRegion\":\"").length) == 1) {
										} else {
											sagentSubRegion = (sResponse.split("agentSubRegion\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentRegion")) {
										if ((sResponse.split("agentRegion\":\"").length) == 1) {
										} else {
											sagentRegion = (sResponse.split("agentRegion\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("address1")) {
										if ((sResponse.split("address1\":\"").length) == 1) {
										} else {
											saddress1 = (sResponse.split("address1\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("address2")) {
										if ((sResponse.split("address2\":\"").length) == 1) {
										} else {
											saddress2 = (sResponse.split("address2\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("address3")) {
										if ((sResponse.split("address3\":\"").length) == 1) {
										} else {
											saddress3 = (sResponse.split("address3\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("postalcode")) {
										if ((sResponse.split("postalcode\":\"").length) == 1) {
										} else {
											spostalcode = (sResponse.split("postalcode\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("location")) {
										if ((sResponse.split("location\":\"").length) == 1) {
										} else {
											slocation = (sResponse.split("location\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("state")) {
										if ((sResponse.split("state\":\"").length) == 1) {
										} else {
											sstate = (sResponse.split("state\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("country")) {
										if ((sResponse.split("country\":\"").length) == 1) {
										} else {
											scountry = (sResponse.split("country\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("mobileNo")) {
										if ((sResponse.split("mobileNo\":\"").length) == 1) {
										} else {
											smobileNo = (sResponse.split("mobileNo\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("email")) {
										if ((sResponse.split("email\":\"").length) == 1) {
										} else {
											semail = (sResponse.split("email\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agencyCode")) {
										if ((sResponse.split("agencyCode\":\"").length) == 1) {
										} else {
											sagencyCode = (sResponse.split("agencyCode\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agencyName")) {
										if ((sResponse.split("agencyName\":\"").length) == 1) {
										} else {
											sagencyName = (sResponse.split("agencyName\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agentDOB")) {
										if ((sResponse.split("agentDOB\":\"").length) == 1) {
										} else {
											sagentDOB = (sResponse.split("agentDOB\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("contractDate")) {
										if ((sResponse.split("contractDate\":\"").length) == 1) {
										} else {
											scontractDate = (sResponse.split("contractDate\":\"")[1]).split("\"")[0];
										}
									}
								//	sMainToken = EncryptToken.generateEncryptedToken(sUserID, sToken);
									updateexpecteddata(sPlanTestcaseId,"Agent_ID", sUserID,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"AgentName", sName,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"AgentNric", sAgentNric,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"AgentRank", sAgentRank,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"uplineManagerName", suplineManagerName,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"uplineRank", suplineRank,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agentBranch", sagentBranch,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agentSubRegion", sagentSubRegion,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agentRegion", sagentRegion,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"address1", saddress1,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"address2", saddress2,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"address3", saddress3,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"postalcode", spostalcode,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"location", slocation,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"state", sstate,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"country", scountry,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"mobileNo", smobileNo,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"email", semail,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agencyCode", sagencyCode,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agencyName", sagencyName,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agentDOB", sagentDOB,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"contractDate", scontractDate,sPlanTestcaseId,sPlanTestcaseId);
									break;
								case "NOTIFICATIONLIST":
									if (sResponse.contains("totalPageCount")) {
										if ((sResponse.split("totalPageCount\":\"").length) == 1) {
										} else {
											stotalPageCount = (sResponse.split("totalPageCount\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("totalItemCount")) {
										if ((sResponse.split("totalItemCount\":\"").length) == 1) {
										} else {
											stotalItemCount = (sResponse.split("totalItemCount\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("totalNotification")) {
										if ((sResponse.split("totalNotification\":\"").length) == 1) {
										} else {
											stotalNotification = (sResponse.split("totalNotification\":\"")[1]).split("\"")[0];
										}
									}
//									sMainToken = EncryptToken.generateEncryptedToken(sUserID, sToken);
									
									updateexpecteddata(sPlanTestcaseId,"totalPageCount", stotalPageCount,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"totalItemCount", stotalItemCount,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"totalNotification", stotalNotification,sPlanTestcaseId,sPlanTestcaseId);
									break;
								case "CUSTOMERLIST":
									if (sResponse.contains("name")) {
										if ((sResponse.split("name\":\"").length) == 1) {
										} else {
											sName = (sResponse.split("name\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("gender")) {
										if ((sResponse.split("gender\":\"").length) == 1) {
										} else {
											sgender = (sResponse.split("gender\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("NRIC")) {
										if ((sResponse.split("NRIC\":\"").length) == 1) {
										} else {
											sNRIC = (sResponse.split("NRIC\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("dob")) {
										if ((sResponse.split("dob\":\"").length) == 1) {
										} else {
											sdob = (sResponse.split("dob\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("race")) {
										if ((sResponse.split("race\":\"").length) == 1) {
										} else {
											srace = (sResponse.split("race\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("email")) {
										if ((sResponse.split("email\":\"").length) == 1) {
										} else {
											semail = (sResponse.split("email\":\"")[1]).split("\"")[0];
										}
									}
//									sMainToken = EncryptToken.generateEncryptedToken(sUserID, sToken);
									
									updateexpecteddata(sPlanTestcaseId,"gender", sgender,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"NRIC", sNRIC,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"dob", sdob,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"race", srace,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"email", semail,sPlanTestcaseId,sPlanTestcaseId);
									break;
								case "CUSTOMERINFO":
									if (sResponse.contains("isVitalityMember")) {
										if ((sResponse.split("isVitalityMember\":\"").length) == 1) {
										} else {
											sisVitalityMember = (sResponse.split("isVitalityMember\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("titleId")) {
										if ((sResponse.split("titleId\":\"").length) == 1) {
										} else {
											stitleId = (sResponse.split("titleId\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("name")) {
										if ((sResponse.split("name\":\"").length) == 1) {
										} else {
											sName = (sResponse.split("name\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("gender")) {
										if ((sResponse.split("gender\":\"").length) == 1) {
										} else {
											sgender = (sResponse.split("gender\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("smoker")) {
										if ((sResponse.split("smoker\":\"").length) == 1) {
										} else {
											ssmoker = (sResponse.split("smoker\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("NRIC")) {
										if ((sResponse.split("NRIC\":\"").length) == 1) {
										} else {
											sNRIC = (sResponse.split("NRIC\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("OldIC")) {
										if ((sResponse.split("OldIC\":\"").length) == 1) {
										} else {
											sOldIC = (sResponse.split("OldIC\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("passportNoOrOthers")) {
										if ((sResponse.split("passportNoOrOthers\":\"").length) == 1) {
										} else {
											spassportNoOrOthers = (sResponse.split("passportNoOrOthers\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("dob")) {
										if ((sResponse.split("dob\":\"").length) == 1) {
										} else {
											sdob = (sResponse.split("dob\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("maritalStatus")) {
										if ((sResponse.split("maritalStatus\":\"").length) == 1) {
										} else {
											smaritalStatus = (sResponse.split("maritalStatus\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("nationality")) {
										if ((sResponse.split("nationality\":\"").length) == 1) {
										} else {
											snationality = (sResponse.split("nationality\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("nationalityOther")) {
										if ((sResponse.split("nationalityOther\":\"").length) == 1) {
										} else {
											snationalityOther = (sResponse.split("nationalityOther\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("permanentResident")) {
										if ((sResponse.split("permanentResident\":\"").length) == 1) {
										} else {
											spermanentResident = (sResponse.split("permanentResident\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("race")) {
										if ((sResponse.split("race\":\"").length) == 1) {
										} else {
											srace = (sResponse.split("race\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("raceOther")) {
										if ((sResponse.split("raceOther\":\"").length) == 1) {
										} else {
											sraceOther = (sResponse.split("raceOther\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("religion")) {
										if ((sResponse.split("religion\":\"").length) == 1) {
										} else {
											sreligion = (sResponse.split("religion\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("email")) {
										if ((sResponse.split("email\":\"").length) == 1) {
										} else {
											semail = (sResponse.split("email\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("agreePayment")) {
										if ((sResponse.split("agreePayment\":\"").length) == 1) {
										} else {
											sagreePayment = (sResponse.split("agreePayment\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("withChildren")) {
										if ((sResponse.split("withChildren\":\"").length) == 1) {
										} else {
											swithChildren = (sResponse.split("withChildren\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("cityOfBirth")) {
										if ((sResponse.split("cityOfBirth\":\"").length) == 1) {
										} else {
											scityOfBirth = (sResponse.split("cityOfBirth\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("countryOfBirth")) {
										if ((sResponse.split("countryOfBirth\":\"").length) == 1) {
										} else {
											scountryOfBirth = (sResponse.split("countryOfBirth\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("industry")) {
										if ((sResponse.split("industry\":\"").length) == 1) {
										} else {
											sindustry = (sResponse.split("industry\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("occupation")) {
										if ((sResponse.split("occupation\":\"").length) == 1) {
										} else {
											soccupation = (sResponse.split("occupation\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("employerName")) {
										if ((sResponse.split("employerName\":\"").length) == 1) {
										} else {
											semployerName = (sResponse.split("employerName\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("natureOfBusiness")) {
										if ((sResponse.split("natureOfBusiness\":\"").length) == 1) {
										} else {
											snatureOfBusiness = (sResponse.split("natureOfBusiness\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("exactDuties")) {
										if ((sResponse.split("exactDuties\":\"").length) == 1) {
										} else {
											sexactDuties = (sResponse.split("exactDuties\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("annualEarnIncome")) {
										if ((sResponse.split("annualEarnIncome\":\"").length) == 1) {
										} else {
											sannualEarnIncome = (sResponse.split("annualEarnIncome\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("reviewDate")) {
										if ((sResponse.split("reviewDate\":\"").length) == 1) {
										} else {
											sreviewDate = (sResponse.split("reviewDate\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("clientChoice")) {
										if ((sResponse.split("clientChoice\":\"").length) == 1) {
										} else {
											sclientChoice = (sResponse.split("clientChoice\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("rankProtectionIndex")) {
										if ((sResponse.split("rankProtectionIndex\":\"").length) == 1) {
										} else {
											srankProtectionIndex = (sResponse.split("rankProtectionIndex\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("rankRetirementIndex")) {
										if ((sResponse.split("rankRetirementIndex\":\"").length) == 1) {
										} else {
											srankRetirementIndex = (sResponse.split("rankRetirementIndex\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("rankEducationIndex")) {
										if ((sResponse.split("rankEducationIndex\":\"").length) == 1) {
										} else {
											srankEducationIndex = (sResponse.split("rankEducationIndex\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("rankSavingsIndex")) {
										if ((sResponse.split("rankSavingsIndex\":\"").length) == 1) {
										} else {
											srankSavingsIndex = (sResponse.split("rankSavingsIndex\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("riskSelectionIndex")) {
										if ((sResponse.split("riskSelectionIndex\":\"").length) == 1) {
										} else {
											sriskSelectionIndex = (sResponse.split("riskSelectionIndex\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("recommendationReasons")) {
										if ((sResponse.split("recommendationReasons\":\"").length) == 1) {
										} else {
											srecommendationReasons = (sResponse.split("recommendationReasons\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("recommendationReasonsSelection")) {
										if ((sResponse.split("recommendationReasonsSelection\":\"").length) == 1) {
										} else {
											srecommendationReasonsSelection = (sResponse.split("recommendationReasonsSelection\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("actionTakenIfDifferentRecommendation")) {
										if ((sResponse.split("actionTakenIfDifferentRecommendation\":\"").length) == 1) {
										} else {
											sactionTakenIfDifferentRecommendation = (sResponse.split("actionTakenIfDifferentRecommendation\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("iAgree")) {
										if ((sResponse.split("iAgree\":\"").length) == 1) {
										} else {
											siAgree = (sResponse.split("iAgree\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("isProvided")) {
										if ((sResponse.split("isProvided\":\"").length) == 1) {
										} else {
											sisProvided = (sResponse.split("isProvided\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("isShown")) {
										if ((sResponse.split("isShown\":\"").length) == 1) {
										} else {
											sisShown = (sResponse.split("isShown\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("isGuide")) {
										if ((sResponse.split("isGuide\":\"").length) == 1) {
										} else {
											sisGuide = (sResponse.split("isGuide\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("isReviewWithClientOnCurrentInsurance")) {
										if ((sResponse.split("isReviewWithClientOnCurrentInsurance\":\"").length) == 1) {
										} else {
											sisReviewWithClientOnCurrentInsurance = (sResponse.split("isReviewWithClientOnCurrentInsurance\":\"")[1]).split("\"")[0];
										}
									}
									if (sResponse.contains("Home")) {
										if ((sResponse.split("addressType\":\"Home\",\"address1\":").length) == 1) {
										} else {
											Home_address1 = (sResponse.split("addressType\":\"Home\",\"address1\":")[1]).split("\"")[0];
										}
									}
//									sMainToken = EncryptToken.generateEncryptedToken(sUserID, sToken);
									
									updateexpecteddata(sPlanTestcaseId,"isVitalityMember", sisVitalityMember,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"titleId", stitleId,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"name", sName,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"gender", sgender,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"smoker", ssmoker,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"NRIC", sNRIC,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"OldIC", sOldIC,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"passportNoOrOthers", spassportNoOrOthers,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"dob", sdob,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"maritalStatus", smaritalStatus,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"nationality", snationality,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"nationalityOther", snationalityOther,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"permanentResident", spermanentResident,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"race", srace,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"raceOther", sraceOther,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"religion", sreligion,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"email", semail,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"agreePayment", sagreePayment,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"withChildren", swithChildren,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"cityOfBirth", scityOfBirth,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"countryOfBirth", scountryOfBirth,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"industry", sindustry,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"occupation", soccupation,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"employerName", semployerName,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"natureOfBusiness", snatureOfBusiness,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"exactDuties", sexactDuties,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"annualEarnIncome", sannualEarnIncome,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"reviewDate", sreviewDate,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"clientChoice", sclientChoice,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"rankProtectionIndex", srankProtectionIndex,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"rankRetirementIndex", srankRetirementIndex,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"rankEducationIndex", srankEducationIndex,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"rankSavingsIndex", srankSavingsIndex,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"riskSelectionIndex", sriskSelectionIndex,sPlanTestcaseId,sPlanTestcaseId);
								//	updateexpecteddata(sPlanTestcaseId,"recommendationReasons", srecommendationReasons,sPlanTestcaseId,sPlanTestcaseId);
								//	updateexpecteddata(sPlanTestcaseId,"recommendationReasonsSelection", srecommendationReasonsSelection,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"actionTakenIfDifferentRecommendation", sactionTakenIfDifferentRecommendation,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"iAgree", siAgree,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"isProvided", sisProvided,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"isShown", sisShown,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"isGuide", sisGuide,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"Home_address1", Home_address1,sPlanTestcaseId,sPlanTestcaseId);
									updateexpecteddata(sPlanTestcaseId,"isReviewWithClientOnCurrentInsurance", sisReviewWithClientOnCurrentInsurance,sPlanTestcaseId,sPlanTestcaseId);
									break;
							}
						}else{
							iReturnValue = 1;
							iRCTCTerminateInd = 1;
							iTerminateInd = 1;
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						httpclient.getConnectionManager().shutdown();
					}
					System.out.println(messageDesc+ "~~"+APIStatus + "~~" + sResponse.toString());
				}
				
			} catch (Exception e) {
				if (sOutput.equals("")) {
					sOutput = e.getMessage().split("\\n")[0];
				} else {
					sOutput = sOutput + " | " + e.getMessage().split("\\n")[0];
				}
				logger.error(e.getMessage());
			}
			return iReturnValue;
			
	 } 
}
