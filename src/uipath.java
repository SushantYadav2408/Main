import java.io.IOException;

public class uipath {
public static void main(String aargs[]) throws IOException, InterruptedException 
{
    String sArgs = "TP000035`UATRound1`Iteration1.1`QKMOB913^PropGen~ATS~UAT`Admin`\\\\Palwdlc0lh8fj\\qk\\Philam_Execution\\UiPathFramework`\\\\PALWDLC0LH8FJ\\QK\\Execution\\ProductScreenShot`Server=10.49.181.57:port=1433:user=sa:password=Ph!l@m@987:databaseName=qath_philamlife_dev`PALWDDF7V9B2S`Main`SEETEST`NA`Integration";
    
    String sArgs1 = sArgs.replace("\\", "/");
    
    System.out.println("Updated sArgs :"+ sArgs1);
    
    String sArgsUipath[] =  sArgs1.split("\\^");
    
    System.out.println("sArgsUipath1 :"+sArgsUipath[0]);
    System.out.println("sArgsUipath2 :"+sArgsUipath[1]);
    
    sArgs = sArgsUipath[0] + "^^" + sArgsUipath[1];
    
    System.out.println("sArgs :"+sArgs);
    
    String userhomepath = "C:\\Program Files (x86)\\UiPath\\Studio";
    String cmd="",value="//PALWDLC0LH8FJ/QK/Shruti/Script/NewFramework/UiPathFramework_E2E/Main.xaml";
     cmd="cmd /k \"\""+userhomepath+"\\UiRobot.exe\" -f \""+value+"\" -input \"{'qath_parameters':'"+sArgs+"'}\"\"";
    System.out.println(cmd);
    Runtime run=Runtime.getRuntime();
    Process p=run.exec(cmd);


/*System.out.println(System.getenv("ProgramFiles"));
System.out.println(System.getenv("ProgramFiles(X86)")); 
String TestcaseID="";
//System.out.println("Test Case ="+test_case);
String userhomepath=System.getProperty("user.home");
String value = "D:\\QK\\Suyog\\IPOS_Enquiry\\IPOS_Enquiry.xaml";
System.out.println("Value ="+ value);
String cmd="cmd /c start "+userhomepath+"\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe -f \""+value+"\" -i \"{'aSeeTestID': '"+TestcaseID+"'}\"";
System.out.println(cmd);
Runtime run=Runtime.getRuntime();
Process p=run.exec(cmd);
p.waitFor();
*/
//String TestcaseID = "tc001";
//String userhomepath = System.getProperty("user.home"); //;"C:\\Users\\q1785";
//String cmd="",value="\\\\10.49.181.57\\qk\\Suyog\\IPOS_Enquiry\\IPOS_Enquiry.xaml";
//cmd = "cmd /c start "+userhomepath+"\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe -f \""+value+"\" -i \"{'aSeeTestID': '"+TestcaseID+"'}\"";
////cmd = "cmd /c start "+userhomepath+"\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe -f \""+value+"\"";
//System.out.println(cmd);
//Runtime run=Runtime.getRuntime();
//Process p=run.exec(cmd);


}
}
