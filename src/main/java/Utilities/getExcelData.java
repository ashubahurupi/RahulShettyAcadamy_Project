package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getExcelData {
	
	public static String excelData(int row, int col, String filename) throws EncryptedDocumentException, IOException
	{
		// File file=new File("D:\\WorkspaceEclipse2\\DemoAutomation\\src\\main\\resources\\TestData.xlsx");
		File file=new File("D:\\WorkspaceEclipse\\Automation_Project_Sigma\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(file);
		
		String value =WorkbookFactory.create(fis).getSheet(filename).getRow(row).getCell(col).getStringCellValue();
		
		return value;
	
	}
	

}
