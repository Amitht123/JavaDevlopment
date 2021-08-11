import java.io.*;
import org.apache.poi.ss.usermodel.*;

import java.util.Iterator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class Code4 {
	
	
	public static void main(String args[]) throws Exception 
	{
		String source = "C:/Users/v-amit/Desktop/updated_amith_resume.xlsx";
		String destincation = "C:/Users/v-amit/Desktop/Dynamic6DigitInfo.pdf";
		codeForConversion(source,destincation);
		
	}
    
    public static void codeForConversion(String source,String destination) throws Exception{
    	Workbook workBook = WorkbookFactory.create(new File(source));

        Sheet sheet = workBook.getSheetAt(0);

        short availableColumns = sheet.getRow(0).getLastCellNum();

        Iterator<Row> rowIterator = sheet.iterator();

        Document pdf = new Document();
        PdfWriter.getInstance(pdf, new FileOutputStream(destination));
        pdf.open();

        PdfPTable my_table = new PdfPTable(availableColumns);

        PdfPCell table_cell = null;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {
                    default:
                        try {
                            table_cell = new PdfPCell(new Phrase(cell.getStringCellValue()));
                        } catch (IllegalStateException illegalStateException) {
                            //TODO: Need to handle exceptions for different type too
                            if (illegalStateException.getMessage().equals("Cannot get a STRING value from a NUMERIC cell")) {
                                table_cell = new PdfPCell(new Phrase(String.valueOf(cell.getNumericCellValue())));
                            }
                        }

                        my_table.addCell(table_cell);
                        break;
                }
            }
        }
        pdf.add(my_table);
        pdf.close();
        workBook.close();
        System.out.print("Converted!");
    }
}