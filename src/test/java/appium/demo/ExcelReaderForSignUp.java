package appium.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderForSignUp {
	
	static FileInputStream fis = null ;
public FileInputStream getFileInputStream() {
	
	
	String FilePath = System.getProperty("user.dir")+ "/src/test/java/Data/LastUserDataForSignUp.xlsx";
	File srcFile = new File(FilePath);
	try {
		fis = new FileInputStream(srcFile);
	} catch (FileNotFoundException e) {
		
		System.out.println("Test data file not found, terminating process: check file path of test data");
		System.exit(0);
	}
	return fis;

}
public Object [][] getExcelData() throws IOException{
	

fis = getFileInputStream();

XSSFWorkbook wb = new XSSFWorkbook(fis);
XSSFSheet sheet = wb.getSheetAt(0);

int TotalNumberOfRows = (sheet.getLastRowNum()+1);
int TotalNumberOfCols = 10 ;

String [][] ArrayExcelData = new String [TotalNumberOfRows][TotalNumberOfCols];

for (int i = 0; i < TotalNumberOfRows; i++)
{for (int j = 0; j < TotalNumberOfCols; j++) {
	XSSFRow row = sheet.getRow(i);
	ArrayExcelData[i][j] = row.getCell(j).toString();
	
}

	
}

wb.close();
return ArrayExcelData;
}

}
