package tutorialNinjaProj.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Utilities {
	
		
	public static String generatePhoneNumber() {
        Random random = new Random();

        // Generate a random number with 10 digits
        int randomNumber = 1000000000 + random.nextInt(900000000);

        return Integer.toString(randomNumber);
    }
	
	 public static String generateRandomString(int minLength, int maxLength) {
	        Random random = new Random();
	        int length = minLength + random.nextInt(maxLength - minLength + 1);

	        StringBuilder randomString = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            // ASCII values for uppercase letters (A-Z) are 65 to 90
	            char randomChar = (char) (65 + random.nextInt(26));
	            randomString.append(randomChar);
	        }

	        return randomString.toString();
	    }
	 
	
	 public static Object[][] getTestDataFromExcell(String Sheetname) throws IOException 
		{
			
			DataFormatter formater = new DataFormatter();
			FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\TutoialNinjaProj\\src\\main\\java\\tutorialNinjaProj\\Testdata\\Logindata.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(Sheetname);
			
			//get row count
			int rowCount = sheet.getLastRowNum();
			
			//get column count
			int columnCount = sheet.getRow(0).getLastCellNum();
			
			Object data[][] = new Object[rowCount][columnCount];
			for(int i=0;i<rowCount;i++) 
			{
				XSSFRow row = sheet.getRow(i+1);
				for(int j=0;j<columnCount;j++) 
				{
					XSSFCell cell = row.getCell(j);
					CellType cellType = cell.getCellType();
					
					switch(cellType) 
					{
						case STRING:
							data[i][j] = cell.getStringCellValue();
							break;
						case NUMERIC:
							data[i][j] = Integer.toString((int)cell.getNumericCellValue());
							break;
						case BOOLEAN:
							data[i][j] = cell.getBooleanCellValue();
							break;
						
					}
				}
			}
			
			return data;
		}

	 
	 
	 
	 

}
