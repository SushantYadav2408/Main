


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ReadWrite {
	
	public static HashMap<String, String> oDataMap = new HashMap<String, String>();
	public static HashMap<String, String> excelFileMap  = new HashMap<String, String>();
	public static WebDriver oDriver;
    public static WebDriverWait wait;
    public static String ExcelPath,ExcelFileName,sOut;
    public static String PolicyNo,DOB,Date_OF_Loss,InquiryNo,ClaimNo,ID,PW,URL,ClaimType;
    public static String Act_ClaimNo_PendingTab,Act_InquiryNo,Act_PolicyNo,ScreenPath,ScriptPath,ChromeDriverPath,ClaimHistory,AlertMsg;
    public static int iReturnValue,ScreenNO,i,URLLaunch,PendingTabFlag;
	public static void readXLSFile() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(ExcelPath+"\\"+ExcelFileName);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet=wb.getSheetAt(1);
		
		/*InputStream ExcelFileToRead1 = new FileInputStream(ExcelPath+"\\"+ExcelFileName);
		HSSFWorkbook wb1 = new HSSFWorkbook(ExcelFileToRead1);*/

		HSSFSheet sheet1=wb.getSheetAt(2);
		HSSFRow row,row1; 
		HSSFCell cell,keyCell,cell1;		
		int length;
		
		//Second Method
		if(sheet.getLastRowNum()>0)
		{
			URLLaunch=1;
		for (  i = 1 ; i <= sheet.getLastRowNum() ; i++ )
        {
			String key ="",value ="";
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{	 
			      keyCell = sheet.getRow(0).getCell(j);
			      cell = sheet.getRow(i).getCell(j);
			      
			      key = keyCell.getStringCellValue().trim();
			      
			      switch (cell.getCellType()) { 
                     case HSSFCell.CELL_TYPE_NUMERIC:
                    	Double d = new Double(cell.getNumericCellValue());
 						long l = d.longValue();
// 						Double compD = (double) l;
 						value =Long.toString(l);
//                      value = cell.getNumericCellValue() + "t";
 						System.out.println(value); 
 						break; 
                     case HSSFCell.CELL_TYPE_STRING: 
                    	 value = cell.getStringCellValue().trim(); 
                    	 System.out.println(value); 
                    	 break; 
                     default :
                    	 value ="";	 
			      }
//			      value = cell.getStringCellValue().trim();
			      oDataMap.put(key, value);
			      ScreenNO=1;
			}
			System.out.println("Excel Data Read Successfully");
			sOut="Excel Data Read Successfully";
			if(oDataMap.get("Executor_Flag").equalsIgnoreCase("Yes"))
			{
				try{
					   System.out.println("Execution is started");
					   sOut = sOut + "\nExecution is started";
						ID=oDataMap.get("UserID");
						PW=oDataMap.get("Password");
						//URL= "https://mnldculapp47:9443/claims/common/Logon.jsp";
						ClaimType=oDataMap.get("Claim_Type");
						PolicyNo=oDataMap.get("Policy_Number");
						DOB=oDataMap.get("DOB");
						Date_OF_Loss=oDataMap.get("Date_of_Loss");
						InquiryNo=oDataMap.get("Inquiry_Number");
						ClaimNo=oDataMap.get("Claim_No");
						ScriptPath ="";
						AlertMsg="";
						Act_ClaimNo_PendingTab="";
						Act_InquiryNo="";
						ClaimHistory="";
						//ChromeDriverPath="\\\\10.49.181.57\\qk\\Sushant\\ePurge\\CMS\\ForntEnd\\ChomeDriver";
						ScreenPath =ExcelPath+"\\"+"Screenshot";
						
						System.out.println("Policy Number is :"+PolicyNo);
						sOut = sOut + "\nPolicy Number is :"+PolicyNo;
						if(URLLaunch==1)
						{	
						//System.out.println("Application Launch Cde");
						String PAth=ExcelPath+"\\chromedriver.exe";
						System.setProperty("webdriver.chrome.driver", PAth);
						oDriver= new ChromeDriver();
						wait = new WebDriverWait(oDriver, 20);
						//oDriver.navigate().to("http://mnldculapp47:9080/claims/common/Logon.jsp");  //UAT Link
						oDriver.navigate().to(URL);  //SIT Link
						oDriver.manage().window().maximize();
						//oDriver.manage().timeouts().pageLoadTimeout(arg0, arg1)
						System.out.println("Application  Launch Successfully");
						Screen();
						URLLaunch = URLLaunch + 1;
						}
						Page1();
						if(iReturnValue==0)
						{
						Page3();
						}
						if(iReturnValue==0)
						{
						Page2();
						}
						if(iReturnValue==0)
						{
							Page4();	
						}
						
                        //Comparison
						String CompFlag="";
						int l= sheet1.getLastRowNum();
						int m= sheet1.getRow(l).getLastCellNum();
						
						String Arr[] ={Act_ClaimNo_PendingTab,Act_InquiryNo,ClaimHistory,AlertMsg};
						String Arr1[]={"Claim_No","Inquiry_Number","Policy_Number","AlertMsg"};
						String Arr2[] ={"Pending Claim","Notification","Claim History","Notification"};
						for(int iArr=0;iArr<Arr.length;iArr++)
						{
						if(!Arr1[iArr].isEmpty()){
							if(Arr1[iArr].contains("AlertMsg") && AlertMsg.equalsIgnoreCase(""))
							{
							  break;
							}
								l = l+1;
							//To create new row
							row1 = sheet1.createRow(l);
							//For loop to create cells
							for(int lceel=0;lceel<=m;lceel++)
							{
								cell1=row1.createCell(lceel);

						        cell1.setCellType(cell1.CELL_TYPE_STRING);
							}
							
							String aa= oDataMap.get("Policy_Number");
							sheet1.getRow(l).getCell(0).setCellValue((String)aa);
							if(oDataMap.get("Before_Epurge").equalsIgnoreCase("Yes") && oDataMap.get("After_Epurge").equalsIgnoreCase("No") )
							{
								sheet1.getRow(l).getCell(1).setCellValue((String)"Before");
							}
							else if (oDataMap.get("Before_Epurge").equalsIgnoreCase("No") && oDataMap.get("After_Epurge").equalsIgnoreCase("Yes") )
							{
								sheet1.getRow(l).getCell(1).setCellValue((String)"After");
							}
												
							sheet1.getRow(l).getCell(2).setCellValue((String)Arr2[iArr]);
							sheet1.getRow(l).getCell(3).setCellValue((String)Arr1[iArr]);
						
							sheet1.getRow(l).getCell(4).setCellValue((String)"Value Comparison");
							
							String a="",b="";
							if(Arr1[iArr].equalsIgnoreCase("AlertMsg"))
							{
								sheet1.getRow(l).getCell(5).setCellValue((String)"There are no matching policies for this inquiry.");
								a = sheet1.getRow(l).getCell(5).getStringCellValue().trim();
							}else {
								sheet1.getRow(l).getCell(5).setCellValue((String)oDataMap.get(Arr1[iArr]));
								a = sheet1.getRow(l).getCell(5).getStringCellValue().trim();
							}
							sheet1.getRow(l).getCell(6).setCellValue((String)Arr[iArr]);
							b=sheet1.getRow(l).getCell(6).getStringCellValue().trim();
							if(a.equalsIgnoreCase(b) && oDataMap.get("After_Epurge").equalsIgnoreCase("No"))
							{
								sheet1.getRow(l).getCell(7).setCellValue((String)"Pass");
							}
							else{
								if((b.equalsIgnoreCase("")) && oDataMap.get("After_Epurge").equalsIgnoreCase("Yes"))
								{
									sheet1.getRow(l).getCell(7).setCellValue((String)"Pass");
									//CompFlag="Fail";
								}
								else if((a.equalsIgnoreCase(b)) && Arr1[iArr].equalsIgnoreCase("AlertMsg")){
									sheet1.getRow(l).getCell(7).setCellValue((String)"Pass");
									//CompFlag="Fail";
									}								
								else{
								sheet1.getRow(l).getCell(7).setCellValue((String)"Fail");
								CompFlag="Fail";
								}
							}
							
						}
						}
						
						
						if(oDataMap.get("Before_Epurge").equalsIgnoreCase("Yes") && oDataMap.get("After_Epurge").equalsIgnoreCase("No") )
						{	
						if(!Act_ClaimNo_PendingTab.isEmpty())
						{
							if(!Act_InquiryNo.isEmpty())
							{
								if(!ClaimHistory.isEmpty() && CompFlag.isEmpty())
								{
									oDataMap.put("Before_Result","Pass");
									oDataMap.put("Before_Screenshot_Path",ScreenPath);
								} else{
									oDataMap.put("Before_Result","Fail");
									oDataMap.put("Before_Screenshot_Path",ScreenPath);
								}
							} else{
								oDataMap.put("Before_Result","Fail");
								oDataMap.put("Before_Screenshot_Path",ScreenPath);
							}
						}else{
							oDataMap.put("Before_Result","Fail");
							oDataMap.put("Before_Screenshot_Path",ScreenPath);
						}			
						}
						
						if(oDataMap.get("Before_Epurge").equalsIgnoreCase("No") && oDataMap.get("After_Epurge").equalsIgnoreCase("Yes") )
						{	
						if(Act_ClaimNo_PendingTab.isEmpty())
						{
							if(Act_InquiryNo.isEmpty())
							{
								if(ClaimHistory.isEmpty() && CompFlag.isEmpty())
								{
									oDataMap.put("After_Result","Pass");
									oDataMap.put("After_Screenshot_Path",ScreenPath);
								} else{
									oDataMap.put("After_Result","Fail");
									oDataMap.put("After_Screenshot_Path",ScreenPath);
								}
							} else{
								oDataMap.put("After_Result","Fail");
								oDataMap.put("After_Screenshot_Path",ScreenPath);
							}
						}else{
							oDataMap.put("After_Result","Fail");
							oDataMap.put("After_Screenshot_Path",ScreenPath);
						}			
						}
						
						// Logout the Page
						
						oDriver.switchTo().defaultContent();
			    		 
			    		 oDriver.switchTo().frame(0);
			    		     		 
			    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Back to Logon')]")));
			    		
			    		oDriver.findElement(By.xpath("//*[contains(text(),'Back to Logon')]")).click();
			    		
			    		Thread.sleep(2000);
			    		
			    		oDriver.switchTo().defaultContent();
			    		
						//Update the data in Excel
						sheet.getRow(i).getCell(0).setCellValue("No");
						sheet.getRow(i).getCell(11).setCellValue(oDataMap.get("Before_Result"));
						sheet.getRow(i).getCell(12).setCellValue(oDataMap.get("Before_Screenshot_Path"));
						sheet.getRow(i).getCell(13).setCellValue(oDataMap.get("After_Result"));
						sheet.getRow(i).getCell(14).setCellValue(oDataMap.get("After_Screenshot_Path"));
						
					}catch(Exception e){
						
						iReturnValue=1;
						System.out.println("Error is :" +e);
						/*logger.error("error in CompareTableVerification : "+e.getMessage());
						iTerminateInd = 1;
						sOutput = sOutput+" | "+e.getMessage();*/
					}
			}
			
        }
		
		//After Changes save the file
		
		ExcelFileToRead.close();//Close InpuStream
		//ExcelFileToRead1.close();
		FileOutputStream fos =new FileOutputStream(new File(ExcelPath+"\\"+ExcelFileName));
		wb.write(fos);
        fos.close();
	    System.out.println("Execution Completed");
	    oDriver.close();
	    oDriver.quit();
		}
		
	
	}
	
	public static void Page1()
    {
		 iReturnValue=0;
   	 try{
   		 System.out.println("Login Page load successfully");
   	 oDriver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
   	 oDriver.findElement(By.name("txtUser")).sendKeys(ID);
   	 oDriver.findElement(By.name("txtPassword")).sendKeys(PW);
   	 oDriver.findElement(By.xpath("//*[@name='rbClaim' and @value='"+ClaimType+"']")).click();
   	 Screen();
   	 
   	 oDriver.findElement(By.name("btnLogon")).click();
   	 }catch(Exception e)
   	 {
   		 System.out.println("Error is :"+e);
   		 iReturnValue=1; 
   		 Screen();
   		 /*iTerminateInd = 1;
			sOutput = sOutput+" | "+e.getMessage();*/
   	 }  
   	
    }
	
	
	 public static void Page2()
     {
    	
    	 try{ 
              System.out.println("Notification  Page");
    		 
              oDriver.switchTo().defaultContent();
    		 
    		  oDriver.switchTo().frame(0);
 
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Notification')]")));
    		 
    		 oDriver.findElement(By.xpath("//*[contains(text(),'Notification')]")).click();
    		 
    		 Thread.sleep(1000);
    		 
    		 oDriver.switchTo().defaultContent();
    		 
    		 oDriver.switchTo().frame(1);
    		 
    		 Screen();
    		 
    		        wait.until(ExpectedConditions.elementToBeClickable(By.id("txtPolicyNo")));
    		        
                  	oDriver.findElement(By.id("txtPolicyNo")).sendKeys(PolicyNo);//5000026111   //5001118439
    		 
                  	oDriver.findElement(By.id("txtInquiryNo")).sendKeys(InquiryNo);
                  	
                  	//oDriver.findElement(By.id("txtPolicyNo")).sendKeys(PolicyNo);
                  	
                  	oDriver.findElement(By.id("clDOB")).sendKeys(DOB); //DOB
    					
    			
    			    oDriver.findElement(By.id("clDOL")).sendKeys(Date_OF_Loss); // Date of loss
    			
    			   Screen();
    			 
    			   oDriver.findElement(By.id("btnSearch")).click(); // Search Button
    			
    			Thread.sleep(2000);
    			
    			try
    			{
    				Alert alert = oDriver.switchTo().alert();
    				AlertMsg = alert.getText();  
    				Robot robot = new Robot();
    				// create rectangle for full screenshot
    				Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    				// capture screen of the desktop
    				BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
    				// save the screenshot to local system
    				ImageIO.write(screenFullImage, "png", new File(ScreenPath+"\\"+ScreenNO+".png"));
    				
    				alert.accept();
                    System.out.println("alert was present and accepted");
                    ScreenNO = ScreenNO + 1;
    			}catch(Exception e)
    			{
                        System.out.println("alert was not present");
                        if(oDriver.findElements(By.xpath("//*[@id='mainBodyDiv']/table/tbody/tr[2]/td[2]")).size()>0)
                        {
              			Act_InquiryNo= oDriver.findElement(By.xpath("//*[@id='mainBodyDiv']/table/tbody/tr[2]/td[2]")).getText().trim();


              			Act_PolicyNo= oDriver.findElement(By.xpath("//*[@id='mainBodyDiv']/table/tbody/tr[2]/td[3]")).getText().trim();
              			
              			Screen();
              			
              		 int oSize = oDriver.findElements(By.xpath("//*[@id='mainBodyDiv']/table/tbody/tr")).size();
               		 for(int iclaim=2;iclaim<oSize;iclaim++)
               		 {
               			 oDriver.findElement(By.xpath("//*[@id='mainBodyDiv']/table/tbody/tr["+ iclaim +"]/td[2]/a")).click();
               			 
               			/* oDriver.switchTo().defaultContent();
                   		 
                   		 oDriver.switchTo().frame(1);*/
               			 
               			 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'CLAIM ANALYSIS WORKSHEET - INQUIRY')]")));
                   		 //Thread.sleep(1000);
                   		
                   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='mainBodyDiv']/table/tbody/tr["+ iclaim +"]/td[2]/a")));
                   		 
                   		 Screen();
                
               		 }
                        }
                      
    			}
              
        
    	 }catch(Exception e)
    	 {
    		 System.out.println("Error is :"+e);
    		 Screen();
    		 iReturnValue=1;
    		/* iReturnValue=1;
    		 iTerminateInd = 1;
 			sOutput = sOutput+" | "+e.getMessage();
 			CaptureScreenshot();*/
    	 } //return iReturnValue;
    }
     
     public static void Page3()
     {
		 iReturnValue=0;
    	 try{
    		 PendingTabFlag =0;
    		 Screen();
    		 
    		 oDriver.switchTo().defaultContent();
    		 
    		 oDriver.switchTo().frame("menuLeft");
    		/* CaptureScreenshot();
    		 sSFStepKeyword="Result$Application Login Successfully";
 			WriteOutput();*/
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Pending Claims')]")));
    		 oDriver.findElement(By.xpath("//*[contains(text(),'Pending Claims')]")).click();
    		 
    		 System.out.println("Application  login  Successfully");
    		 
    		 System.out.println("Pending Claim Page Loaded Successfully");
    		 
    		 Thread.sleep(2000);
    		     		 
    		 oDriver.switchTo().defaultContent();
    		 
    		 oDriver.switchTo().frame("investigator");

    		Act_ClaimNo_PendingTab="";
    		
    		oDriver.manage().timeouts().implicitlyWait(03,TimeUnit.SECONDS) ;
    		
    		int aaa= oDriver.findElements(By.xpath("//a[contains(text(),'"+ ClaimNo +"')]")).size();
    		
    		if(aaa>0)
    		{
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'"+ ClaimNo +"')]")));	
    		
    		//Screen();
    		
    		oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).click();
    		
    		Act_ClaimNo_PendingTab = ClaimNo;
    		
    		 Thread.sleep(200);
    		 
    		 oDriver.switchTo().defaultContent();
    		 
    		 oDriver.switchTo().frame("frame_eligibility");
    		 
    		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'CLAIM ANALYSIS WORKSHEET')]")));
    		 
    		 Screen();
    		 
    		 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
				 //oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).isDisplayed();
				 //WebElement element = oDriver.findElement(By.xpath("//table[@id='TBL8PAL']//*[contains(text(),'"+ PolicyNo+"')]"));
				 je.executeScript("window.scrollBy(0,500)", "");
				 Thread.sleep(500);
				 Screen();
				 
				je.executeScript("window.scrollBy(0,500)", "");
			    Thread.sleep(500);
			    Screen();
			 
			 je.executeScript("window.scrollBy(0,500)", "");
				 Thread.sleep(500);
				 Screen();
    		 
    		 PendingTabFlag =1;
    		 
    		 Screen();
    		} else{
    			
    			PendingTabFlag=0;
    			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rbSelSC']")));	
    			
    			if(oDriver.findElements(By.xpath("//*[@id='rbSelSC']")).size()>0)
    			{
    			oDriver.findElement(By.xpath("//*[@id='rbSelSC']")).click();
    			
    			 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    			
    			 if(oDriver.findElements(By.xpath("//*[@id='TBL4']//*[contains(text(),'"+ ClaimNo+"')]")).size()>0)
    	    		{
    				 PendingTabFlag=1;
    				 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
    				 je.executeScript("arguments[0].scrollIntoView(true);", oDriver.findElement(By.xpath("//*[@id='TBL4']//*[contains(text(),'"+ ClaimNo+"')]")));
    				 Thread.sleep(500); 
    				 //Wb.sendKeys(arg0);
    				 
    					for (int i = 0; i < 5; i++) {
    						//JavascriptExecutor js = (JavascriptExecutor) driver;
    						je.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",oDriver.findElement(By.xpath("//*[@id='TBL4']//*[contains(text(),'"+ ClaimNo+"')]")));
    					} 
    	    		Screen();
    	    		PendingTabFlag=0;
    	    		Act_ClaimNo_PendingTab = ClaimNo;
    	    		}
    			}
    			
    			//for Abeyance radio button
    			if(oDriver.findElements(By.xpath("//*[@id='rbSelAbeyance']")).size()>0)
    			{
    			oDriver.findElement(By.xpath("//*[@id='rbSelAbeyance']")).click();
    			
    			 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    			
    			 if(oDriver.findElements(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).size()>0)
    	    		{
    				 PendingTabFlag=1;
    				 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
    				 je.executeScript("arguments[0].scrollIntoView(true);", oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    				 Thread.sleep(500); 
    				 //Wb.sendKeys(arg0);
    				 
    					for (int i = 0; i < 5; i++) {
    						//JavascriptExecutor js = (JavascriptExecutor) driver;
    						je.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    					} 
    	    		Screen();
    	    		PendingTabFlag=0;
    	    		Act_ClaimNo_PendingTab = ClaimNo;
    	    		}
    			}
    			
    			if(oDriver.findElements(By.xpath("//*[@id='rbSelPC']")).size()>0)
    			{
    			 oDriver.findElement(By.xpath("//*[@id='rbSelPC']")).click();
     			
    			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    			
    			 if(oDriver.findElements(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).size()>0)
    	    		{
    				 Screen();
    				 
    				 oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]/preceding::td[1]")).click();
    				 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
    				 je.executeScript("arguments[0].scrollIntoView(true);", oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    				 Thread.sleep(500); 
    				 //Wb.sendKeys(arg0);
    				 
    					for (int i = 0; i < 5; i++) {
    						//JavascriptExecutor js = (JavascriptExecutor) driver;
    						je.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    					}
    	    		Screen();
    	    		Act_ClaimNo_PendingTab = ClaimNo;
    	    		}
    			}
 
    			 
    			 if(oDriver.findElements(By.xpath("//*[@id='rbSelBC']")).size()>0)
    			 {
    				 oDriver.findElement(By.xpath("//*[@id='rbSelBC']")).click();
    			 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")));
    			
    			 if(oDriver.findElements(By.xpath("//*[@id='TBLBRANCH2']//*[contains(text(),'"+ ClaimNo+"')]")).size()>0)
    	    		{
    				 Screen();
    				// Thread.sleep(5000);
    				 
    				 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
    				 //oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).isDisplayed();
    				 WebElement element = oDriver.findElement(By.xpath("//*[contains(text(),'"+ PolicyNo +"')]"));
    				 je.executeScript("arguments[0].scrollIntoView(true);", element);
    				 Thread.sleep(500); 
    				 //Wb.sendKeys(arg0);
    				 Actions actions = new Actions(oDriver);
    				 actions.moveToElement(element);
    				 actions.perform();
    				 
    					for (int i = 0; i < 5; i++) {
    						//JavascriptExecutor js = (JavascriptExecutor) driver;
    						je.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
    					}
    	    		Screen();
    	    		Act_ClaimNo_PendingTab = ClaimNo;
    	    		}
    			 }
    			 
    			 if(oDriver.findElements(By.xpath("//*[@id='rbSelRC']")).size()>0)
    			 {
    			 oDriver.findElement(By.xpath("//*[@id='rbSelRC']")).click();
    			 if(oDriver.findElements(By.xpath("//table[@id='TBL8PAL']//*[contains(text(),'"+  PolicyNo+"')]")).size()>0)
 	    		{
 				 Screen();
 				 
 				 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
 				 //oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).isDisplayed();
 				 WebElement element = oDriver.findElement(By.xpath("//table[@id='TBL8PAL']//*[contains(text(),'"+ PolicyNo+"')]"));
 				 je.executeScript("arguments[0].scrollIntoView(true);", element);
 				 Thread.sleep(500); 
 				 //Wb.sendKeys(arg0);
 				 Actions actions = new Actions(oDriver);
 				 actions.moveToElement(element);
 				 actions.perform();
 				for (int i = 0; i < 5; i++) {
					//JavascriptExecutor js = (JavascriptExecutor) driver;
					je.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
				}
    			 
 	    		Screen();
 	    		Act_ClaimNo_PendingTab = ClaimNo;
 	    		}
    			} 
    		}
    	 
    		PendingTabFlag =1;
    		 }catch(Exception e)
    	 {
    			 System.out.println("Error is :"+e);
        		 Screen();
        		 iReturnValue=1;
    		 /*iReturnValue=1; 
    		 iTerminateInd = 1;
 			sOutput = sOutput+" | "+e.getMessage();*/
    	 }  
    	
     }
    
     
     public static void Page4()
     {
		 iReturnValue=0;
    	 try{
    		 System.out.println("Claim History Page loaded Successfully");
    		 
    		 oDriver.switchTo().defaultContent();
    		 
    		 oDriver.switchTo().frame(0);
    		/* CaptureScreenshot();
    		 sSFStepKeyword="Result$Application Login Successfully";
 			WriteOutput();*/
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Claim History')]")));
    		 oDriver.findElement(By.xpath("//*[contains(text(),'Claim History')]")).click();
    		 
    		 
    		 oDriver.switchTo().defaultContent();
    		 
    		 oDriver.switchTo().frame(1);
    		 
    		 
    		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtPol_no")));
    		 oDriver.findElement(By.name("txtPol_no")).sendKeys(PolicyNo);
    		 
    		 Screen();
    		 
    		 oDriver.findElement(By.name("btnSEARCH")).click();
    		 
    		 Thread.sleep(2000);  
    		 
    		 ClaimHistory="";
    		     		 
    		 Screen();
    		 
    		 if(oDriver.findElements(By.xpath("//*[@class='list']/tbody/tr[2]/td[1]")).size()>0)
    		 {
    		 ClaimHistory = oDriver.findElement(By.xpath("//*[@class='list']/tbody/tr[2]/td[1]")).getText();
    		 System.out.println(ClaimHistory);
    		 
    		 int oSize = oDriver.findElements(By.xpath("//*[@class='list']/tbody/tr")).size();
    		 for(int iclaim=2;iclaim<=oSize;iclaim++)
    		 {
    			 oDriver.findElement(By.xpath("//*[@class='list']/tbody/tr["+ iclaim +"]/td[3]/font/a")).click();
    			 
    			 oDriver.switchTo().defaultContent();
    			 
    			 oDriver.switchTo().frame("mainWindow");
        		 
        		 oDriver.switchTo().frame("frame_eligibility");
    			 
    			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'CLAIM ANALYSIS WORKSHEET')]")));
    			 
    			 PendingTabFlag=0;
    			 Screen();
    			 
    			 JavascriptExecutor je =(JavascriptExecutor) oDriver; 
 				 //oDriver.findElement(By.xpath("//*[contains(text(),'"+ ClaimNo+"')]")).isDisplayed();
 				 //WebElement element = oDriver.findElement(By.xpath("//table[@id='TBL8PAL']//*[contains(text(),'"+ PolicyNo+"')]"));
 				 je.executeScript("window.scrollBy(0,500)", "");
 				 Thread.sleep(500);
 				 Screen();
 				 
 				je.executeScript("window.scrollBy(0,500)", "");
				 Thread.sleep(500);
				 Screen();
				 
				 je.executeScript("window.scrollBy(0,500)", "");
 				 Thread.sleep(500);
 				 Screen();
 				 
    			 PendingTabFlag=1;
    			 Screen();
    			 
    			 oDriver.switchTo().defaultContent();
        		 
    			 oDriver.switchTo().defaultContent();
    			 
        		 oDriver.switchTo().frame(0);
        		
        		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Claim History')]")));
        		 oDriver.findElement(By.xpath("//*[contains(text(),'Claim History')]")).click();
        		 
        		 
        		 oDriver.switchTo().defaultContent();
        		 
        		 oDriver.switchTo().frame(1);
        		 
        		 
        		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtPol_no")));
        		 oDriver.findElement(By.name("txtPol_no")).sendKeys(PolicyNo);
        		 
   
        		 
        		 oDriver.findElement(By.name("btnSEARCH")).click();
        		 
        		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='list']/tbody/tr["+ iclaim +"]/td[3]/font/a")));
    		 }
    		 }
    		 
    		
    		
    		 }catch(Exception e)
    	     {
    			 System.out.println("Error is :"+e);
        		 Screen();
        		 iReturnValue=1;
    		 /*iReturnValue=1; 
    		 iTerminateInd = 1;
 			sOutput = sOutput+" | "+e.getMessage();*/
    	     }  
    	
     }
    
   public static void Screen()
   {
	   System.out.println("Screen  No. :" + ScreenNO);
	   try
	   {
		   if(ScreenNO==1)
		   {
			   File file = new File(ScreenPath);
			   if (!file.exists()) {
		            if (file.mkdir()) {
		                System.out.println("Screenshot folder Created!");
		            } else {
		                System.out.println("Failed to create directory!");
		            } }  
			   
		   ScreenPath = ScreenPath +"\\"+ PolicyNo;  
		   File file1 = new File(ScreenPath);
	        if (!file1.exists()) {
	            if (file1.mkdir()) {
	                System.out.println("Policy Screenshot folder Created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
	        
	        if(oDataMap.get("Before_Epurge").equalsIgnoreCase("Yes") && oDataMap.get("After_Epurge").equalsIgnoreCase("No") )
			{
	        	ScreenPath = ScreenPath + "\\CMS_FE_Before";
			}else
			{
				ScreenPath = ScreenPath + "\\CMS_FE_After";
			}
	        
	        File file2 = new File(ScreenPath);
	        if (!file2.exists()) {
	            if (file2.mkdir()) {
	                System.out.println("Process Screenshot folder Created!");
	            } else {
	                System.out.println("Failed to create directory!");
	            }
	        }
		   }
		   
		   if(PendingTabFlag==0){
		   TakesScreenshot scrShot =((TakesScreenshot)oDriver);

	        //Call getScreenshotAs method to create image file

	       File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	       //Copy file at destination

	        FileUtils.copyFile(SrcFile, new File(ScreenPath+"\\"+ScreenNO+".png"));
		   }else{
	        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(oDriver);
	        ImageIO.write(fpScreenshot.getImage(),"PNG",new File(ScreenPath+"\\"+ScreenNO+".png"));
		   }	        
	        ScreenNO = ScreenNO + 1;
	       
	        
	   }catch(Exception e)
	   {
		   iReturnValue = 1;
		   System.out.println("Error is :" + e);
  		   Screen();
	   }
	   
   }

	public static void main(String[] args) throws IOException {
		
		//String para = args[0];
		String para = "\\\\10.49.181.57\\qk\\Sushant\\ePurge\\CMS\\ForntEnd\\CMS`Epurge_CMS_TestHarness.xls`https://mnldculapp47:9443/claims/common/Logon.jsp";
		System.out.println(para);
		String [] oPRCDetails = para.split("`");
		ExcelPath = oPRCDetails[0];
		ExcelFileName = oPRCDetails[1];
		URL = oPRCDetails[2];
		readXLSFile();
	}

}
