package Data;


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
		
		
				public static FileInputStream fis = null ;
	
public  FileInputStream getFileInputStream() {

//	String FilePath =	System.getProperty("user.dir")+ excelFileName;
	//String FilePath =	"C:/Users/LAPTOP/OneDrive/Desktop/LastUserDataNew.xlsx";
String FilePath = System.getProperty("user.dir")+ "/src/test/java/Data/LastUserData11.xlsx";
	//String FilePath = System.getProperty("user.dir")+ "/src/test/java/Data/LastUserDataForSignUp.xlsx";
	
File srcFile = new File (FilePath);

try {
	 fis = new FileInputStream(srcFile);
} catch (FileNotFoundException e) {

System.out.println("Test data file not found, terminating process: check file path of test data");
System.exit(0);	}
return fis;

}




	public Object [][] getExcelData(String sheetName) throws IOException{		
	fis = getFileInputStream();
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheetAt(0);
	//XSSFSheet sheet = wb.getSheet(sheetName);

	int TotalNumberOfRows = (sheet.getLastRowNum()+1);
	int TotalNumberOfCols = sheet.getRow(0).getLastCellNum();


	String [][] ArrayExcelData = new String [TotalNumberOfRows][TotalNumberOfCols];

	for (int i = 0; i < TotalNumberOfRows; i++)
{for (int j = 0; j < TotalNumberOfCols; j++) {
	XSSFRow row = sheet.getRow(i);

	ArrayExcelData[i][j] = row.getCell(j).toString();
	
	}}
wb.close();
	return ArrayExcelData;}
	
	}

//

//		 public static void main(String[] args) {
//			

			
//
//
//		File src =new File("C:\\Users\\LAPTOP\\OneDrive\Desktop\\testdata22.xlsx");
//			
////			String Path = System.getProperty("user.dir")+ "src\\test\\java\\Data\\userdata.xlsx";
////			File srcFile = new File(path);
////			try {
////				fis = new FileInputStream(srcFile);
////			} catch (FileNotFoundException e) {
////				
////				System.out.println("Test data file not found, terminating process: check file path of test data");
////				System.exit(0);	}
////			return fis;
////		
////		try {
////		fis = new FileInputStream(path);
////			workbook = new XSSFWorkbook(fis);
////		sheet = workbook.getSheetAt(0);	
////		fis.close();
////		} catch (FileNotFoundException e) {
////			
////			System.out.println("Test data file not found, terminating process: check file path of test data");
////			System.exit(0);
//		}
	

//		public String path;
//		public FileInputStream fis = null ;
//		static FileOutputStream fileOut = null ;
//		private XSSFWorkbook workbook = null ;
//		private XSSFSheet sheet = null ;
//		private XSSFRow row = null ;
//		private XSSFCell cell = null ;
	



//
//	public Object [][] getExcelData() throws IOException{		
//		
//	fis = getFileInputStream();
//
//	XSSFWorkbook wb = new XSSFWorkbook(fis);
//	XSSFSheet sheet = wb.getSheetAt(0);
//
//	int TotalNumberOfRows = (sheet.getLastRowNum()+1);
//	int TotalNumberOfCols = 3 ;
//	String [][] ArrayExcelData = new String [TotalNumberOfRows][TotalNumberOfCols];
//
//	for (int i = 0; i < TotalNumberOfRows; i++)
//{for (int j = 0; j < TotalNumberOfCols; j++) {
//		XSSFRow row = sheet.getRow(i);
//	ArrayExcelData[i][j] = row.getCell(j).toString();
//		
//	}
//
//		
//	}
//
//	wb.close();
//return ArrayExcelData;
//	
//
//	}
//
//	
//	
//	public int getRowCount(String sheetName) {
//		
//		int index= workbook.getSheetIndex(sheetName);
//		if (index==1)
//			return 0;
//		else {
//			sheet= workbook.getSheetAt(index);
//			int number= sheet.getLastRowNum()+1;
//			return number;
//		}
//	}
//	
	