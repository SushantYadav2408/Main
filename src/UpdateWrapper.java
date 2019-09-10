import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class UpdateWrapper {

	public static void main(String[] args) {
		
		String sheet_name = "QATH_DBDetails";
		String planid="",releaseid="",cycleid="",product_code="";
		String pcfile="WLCI IPOS PopGen ATS Verification PAL.xls";
	    String ext = FilenameUtils.getExtension(pcfile.trim());
	    String spath = "//PALWDLC0LH8FJ/qk/Philam_Execution/Premium Calculator";
	    
	    if ("xls".equalsIgnoreCase(ext)) {
	        // for .xls file
	        
	            
	        try {
	           File calcfile = new File(pcfile.trim());
	                
	           // if (calcfile != null && calcfile.isFile()) {
	               File file = new File(spath.concat("\\" + pcfile.trim()));
	              /* HSSFWorkbook workbook = new HSSFWorkbook(file);
	                HSSFSheet sheet = workbook.getSheet(sheet_name);*/
	               //HSSFWorkbook workbook = null;
	               InputStream ExcelFileToRead = new FileInputStream(file);
	       		   HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
	       		   HSSFSheet sheet=wb.getSheetAt(0);
	       		   
	                Cell cell = null;
	                      
	                cell = sheet.getRow(20).getCell(5);
	                cell.setCellValue(planid);
	                      
	                cell = sheet.getRow(22).getCell(5);
	                cell.setCellValue(releaseid);
	                      
	                cell = sheet.getRow(24).getCell(5);
	                cell.setCellValue(cycleid);
	                    
	                cell = sheet.getRow(26).getCell(5);
	                cell.setCellValue(product_code);
	                    
	                ExcelFileToRead.close();
	                    
	                FileOutputStream outFile = new FileOutputStream(new File(spath.concat("\\" + pcfile.trim())));
	                wb.write(outFile);
	                outFile.close();
	                      
	                int lastPeriodPos = pcfile.lastIndexOf('.');
	                String vbs_name = pcfile.substring(0, lastPeriodPos) + ".vbs";
	                    
	                File vbs_file = new File(spath.concat("\\vbs\\" + vbs_name));
	                      
	                if (vbs_file != null && vbs_file.isFile()) {
	                    // write query to update status flag for the PRC
	                   // updateStatusFlag(planid, releaseid, cycleid);
	                        
	                    // execute the .vbs file
	                    Runtime.getRuntime().exec("cmd.exe /k cscript \"" + spath.concat("\\" + "vbs" + "\\" + vbs_name) + "\"");
	        
	                    int check_counter = 0;
	                    String complete_flag = "";
	                        
	                    // check for completion status
	                    while (true) {
	                        Thread.sleep(10000);
	                        check_counter++;
	                        
	                        // write query to fetch status flag for the PRC                        
	                      //  complete_flag = getStatusFlag(planid, releaseid, cycleid);
	                            
	                        if ("true".equalsIgnoreCase(complete_flag)) {
	                                break;
	            
	                        }
	            
	                        if (check_counter >= (10 * 6)) {
	                            try {
	                                Runtime.getRuntime().exec("taskkill /f /t /IM EXCEL.EXE");
	                                Thread.sleep(1000);
	                            
	                            } catch (Exception ex) {
	                                
	                            }
	            
	                        }
	            
	                    }
	                        
	             //   } 
	                
	            }
	    } catch (Exception e) {
	                e.printStackTrace();

	        }
	            
	    } 
	        
	}
	

}
