package testcase;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExel {

	public static String[][] readData() throws IOException // step 3 converting main methd to normal methd
	{
		
		//Step 1: Locate the workbook (setup the path) 
		XSSFWorkbook wb = new XSSFWorkbook("./data/testleaf.xlsx"); // ./ represents project path
		
		//Step 2: get into worksheet
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowCount = ws.getLastRowNum();
		
		//Step 3: get into row
		short cellCount = ws.getRow(0).getLastCellNum();
		
		//Step to integrate read excel to data provider
			// step 1 creating 2 D array
				String[][] data = new String[rowCount][cellCount];
				
		//to print all the datas from 1st col
		for (int i = 1; i <= rowCount; i++) // to change the value of 3 incase the rows are extended need to use methd 'getlastrownum'
		 {
			for (int j = 0; j < cellCount; j++) //// to change the value of 4 incase the rows are extended need to use methd 'getlastrownum'
		{
			
			
			// making it a single line of code
			
			String text = ws.getRow(i).getCell(j).getStringCellValue();
			System.out.println(text);
			data[i-1][j]=text;  // i-1 bcz in for loop i starts from 1 // this is to save data from excel // step 2 
			
			//Step 3: get into row
			//XSSFRow row = ws.getRow(i);
			//short cellCount = row.getLastCellNum();
			//Step 4: Get into cell
		//	XSSFCell cell = row.getCell(0);
		
			//Step 5: Getting Data
			//String text = cell.getStringCellValue();
			//System.out.println(text);
			
		}
		}
				
		//Last step - closing the workboook
		wb.close();
		
		return data; // step 4 to return data and change the void to strign
	
	}

}
