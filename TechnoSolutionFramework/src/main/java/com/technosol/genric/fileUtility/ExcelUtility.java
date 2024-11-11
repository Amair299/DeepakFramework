package com.technosol.genric.fileUtility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * this class contains generic methods to read and write data into excel
 * @author AMAIR
 *
 */
public class ExcelUtility {

	/**
	 * reads data from excel workbook based on provided row and cell
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return specific data:string
	 * @throws Exception
	 */
	public String getDataFromExcel(String sheetName,int row,int cell) throws Exception {
		 FileInputStream fis = new FileInputStream("./testdata/Org.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 XSSFRow r = sheet.getRow(row);
		 String data = r.getCell(cell).getStringCellValue();
		 workbook.close();
		 return data;
	}
	/**
	 * TO find total number of rows in excel workbook
	 * @param sheetName
	 * @return no of rows:int
	 * @throws Exception
	 */
    public int getRowCount(String sheetName) throws Exception {
    	FileInputStream fis = new FileInputStream("./testdata/Org.xlsx");
		 XSSFWorkbook workbook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workbook.getSheet(sheetName);
		 int rows = sheet.getLastRowNum();
		 workbook.close();
		 return rows;
		 
    }
    /**
     * to write data into excel workbook
     * @param sheetName
     * @param row
     * @param cell
     * @param data
     * @throws Exception
     */
    public void setDataIntoExcel(String sheetName,int row,int cell,String data) throws Exception {
    	FileOutputStream fos = new FileOutputStream("./testdata/Org.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        XSSFRow  r = sheet.createRow(row);
        r.createCell(cell).setCellValue(data);
        workbook.write(fos);
        workbook.close();
    }
}
