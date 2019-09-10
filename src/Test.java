import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.experitest.client.Client;
import com.experitest.selenium.MobileWebDriver;

public class Test {

  private static String host = "localhost";
  private static int port = 8889;
  private static String projectBaseDirectory = "D:\\QK\\WorkSpace";
  protected static MobileWebDriver driver = null;
  public static void main(String[] args) throws Exception {
	  //String sMobDeviceName="iPOS_ePolicy";
	  /*driver = new MobileWebDriver(host, port);	 
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.client.setDevice(sMobDeviceName.replace("-",":"));// "ios_app:iPad Pro"
	  driver.client.setSpeed("Fast");
	  driver.client.setShowPassImageInReport(false);
	  driver.client.setShowImageInReport(false);
	  driver.device().openScreen();*/
	  
   driver = new MobileWebDriver( host, port, projectBaseDirectory, "xml", "reports", "test_linear");
  // String Paramanteres= args[0]; // "D:\\AIA\\IPOS\\IPA files\\iPoS20_Latest.ipa";
   String Paramanteres="\\\\PALWDDCD12C2S\\Shared\\BPLAC ipa file\\6.5\\UAT\\PH_BPLAC_UAT_Debug_V6.50_2019062517_157968.ipa`iPOS_ePolicy`030305666`";
   String Paramanteres1[] =Paramanteres.split("`");
   String ipafile=Paramanteres1[0];
   String sDevice=Paramanteres1[1];
   String AgentCode=Paramanteres1[2];
   String scriptpath=Paramanteres1[3];
   System.out.println(ipafile);
   File file= new File(ipafile);
   boolean exists=file.exists();
   System.out.println(exists);
   
   Runtime.getRuntime().exec("wscript "+ scriptpath);
   
   if(exists==true){
	driver.setDevice(sDevice);
	if(driver.application("com.philamlife.ipos").uninstall()){
           // If statement
       }
		System.out.println("uninstalled successfully");
		driver.application(ipafile).install(true);
		System.out.println("installed successfully");
       
          driver.setDevice(sDevice);
          driver.client.setShowPassImageInReport(false);
          driver.application("com.philamlife.ipos").launch(true, true);
              Thread.sleep(5000);
       driver.useNativeIdentification();
     /* driver.client.click("NATIVE", "xpath=//*[@text='OK']", 0, 1);
       Thread.sleep(2000);
       driver.client.click("NATIVE", "xpath=//*[@text='Allow' and @id='Allow']", 0, 1);*/
       
       if(driver.client.waitForElement("NATIVE", "xpath=//*[@text='Reactivation/Add New User' and @class='UIButtonLabel']", 0, 500)){
           // If statement
       }
       driver.client.click("NATIVE", "xpath=//*[@text='Reactivation/Add New User' and @class='UIButtonLabel']", 0, 1);
       if(driver.client.waitForElement("NATIVE", "xpath=//*[contains(text(),'OK') and @class='UILabel']", 0, 500)){
           // If statement
       }
       driver.client.click("NATIVE", "xpath=//*[contains(text(),'OK') and @class='UILabel']", 0, 1);
       if(driver.client.waitForElement("NATIVE", "xpath=//*[@nodeName='INPUT' and @id='username']", 0, 500)){
           // If statement
       }
       driver.client.elementSendText("WEB", "xpath=//*[@nodeName='INPUT' and @id='username']", 0, AgentCode);
       driver.client.elementSendText("WEB", "xpath=//*[@nodeName='INPUT' and @id='password']", 0, "New00001!");
       driver.client.click("WEB", "xpath=//*[@name='btn_submit' and @value='OK']", 0, 1);
       
       if(driver.client.waitForElement("NATIVE", "xpath=//*[@text='Confirm' and @class='UIButtonLabel']", 0, 10000)){
           // If statement
       }
       driver.client.click("NATIVE", "xpath=//*[@text='Confirm' and @class='UIButtonLabel']", 0, 1);
       if(driver.client.waitForElement("NATIVE", "xpath=//*[@text='New Password']/following::*[@class='TFEdit' and @onScreen='true']", 0, 10000)){
           // If statement
       }
       driver.client.elementSendText("NATIVE", "xpath=//*[@text='New Password']/following::*[@class='TFEdit' and @onScreen='true']", 0, "Quality@001");
       driver.client.elementSendText("NATIVE", "xpath=(//*[@text='Confirm Password']/following::*[@class='TFEdit' and @onScreen='true'])[1]", 0, "Quality@001");
       driver.client.click("NATIVE", "xpath=//*[@accessibilityLabel='Ok']", 0, 1);
       Thread.sleep(5000);
       if(driver.client.waitForElement("NATIVE", "xpath=//*[contains(text(),'OK')]", 0, 10000)){
           // If statement
       }
       driver.client.click("NATIVE", "xpath=//*[contains(text(),'OK')]", 0, 1);
       
       Thread.sleep(5000);
       
       scriptpath = scriptpath + "\\" + "BVT_Launch.vbs";
       
       Runtime.getRuntime().exec("wscript "+ scriptpath);
       
}
}}