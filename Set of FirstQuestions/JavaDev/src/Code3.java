import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Code3 {
   public static void main(String[] args) throws Exception {
	   int n;
	   String finalValue;
	   System.out.println("Enter the Total Number of Dynamic values to be generated in Excel File");
	   Scanner sc=new Scanner(System.in);
	   n=sc.nextInt();

      XSSFWorkbook workbook = new XSSFWorkbook();
      
      XSSFSheet spreadsheet = workbook.createSheet( " Dynamic6DigitInfo ");

      XSSFRow row;
      
      Map < String, Object[] > dynamicnumberinfo = new TreeMap < String, Object[] >();
      for(int i=1;i<=n;i++) {
    	  Random rnd = new Random();
          int number = rnd.nextInt(999999);
          finalValue =String.format("%06d", number);
    	  dynamicnumberinfo.put( Integer.toString(i), new Object[] {
    		         finalValue });  
      }

      //Iterate over data and write to sheet
      Set < String > keyid = dynamicnumberinfo.keySet();
      int rowid = 0;
      
      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = dynamicnumberinfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      
      FileOutputStream out = new FileOutputStream(
         new File("C:/Users/v-amit/Desktop/Dynamic6DigitInfo.xlsx"));
      
      workbook.write(out);
      out.close();
      System.out.println("Dynamic6DigitInfo.xlsx written successfully");
   }
}