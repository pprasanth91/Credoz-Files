package selenium.com.day5;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Ebay_Datadriven {

public static WebDriver driver;

public static int iRow,iTotalRow,iCell,iTotalCell;
public static String sExcelFile = "./Data/Ebay.xlsx";

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
String sSheet,sSearchTxt;
sSheet = "Search";
Page_Info();	
		try {
			InputStream oFile = new FileInputStream(sExcelFile);
			XSSFWorkbook oExcel = new XSSFWorkbook(oFile);
			XSSFSheet oSheet = oExcel.getSheet(sSheet);
			Row oRow;
			Cell oCell;
			iTotalRow = oSheet.getLastRowNum();
			System.out.println(iTotalRow);
			for(iRow=1;iRow<=iTotalRow;iRow++){
				oRow = oSheet.getRow(iRow);
				iTotalCell = oRow.getLastCellNum();
				System.out.println(iTotalCell);
				for(iCell=0;iCell<iTotalCell;iCell++){
					oCell = oRow.getCell(iCell);
					sSearchTxt = oCell.getStringCellValue();
					
					Search_Product(sSearchTxt,"Mobile Phones");
					Get_Match(sSearchTxt);
				}
				
			}
			oExcel.close();
			oFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void Page_Info(){
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://www.ebay.in/");
		 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		 		 
	}
	
	public static void Search_Product(String sTxt, String sCat)
	{
		WebElement oTextBox,oSearchBtn;
		Select ocat;
		
		
		oTextBox = driver.findElement(By.id("gh-ac"));
		oSearchBtn = driver.findElement(By.id("gh-btn"));
		
		
		
		oTextBox.clear();
		oTextBox.sendKeys(sTxt);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 //Wait wait = new FluentWait(driver);
		//driver.manage().window().setPosition(new Point(0, -1000));//minimize window
		ocat = new Select(driver.findElement(By.id("gh-cat")));
		
		
		ocat.selectByVisibleText(sCat);
		
		oSearchBtn.click();
		
		
		
		
	}
	
	
	
public static void Get_Match(String sTxt) throws InterruptedException{
	
	
		
		WebElement oProduct;
		String sVal1,sVal2;
		List<WebElement> oAllproducts;
		
		int iProduct,iTotalproduct;
		Thread.sleep(10000);
		
		oAllproducts = driver.findElements(By.xpath("//ul[@id='ListViewInner']/li"));
		
		iTotalproduct = oAllproducts.size();
		
		System.out.println("Total Product count : " + iTotalproduct );
		
		
		//iExistingRow = Suporting_Lib.Get_Max_RowCount_From_Excel(sExcelFile, sTxt);
		
		for(iProduct=0;iProduct< iTotalproduct;iProduct++)
		{
			oProduct = oAllproducts.get(iProduct);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			sVal1 = oProduct.findElement(By.className("vip")).getText();
			sVal2 = oProduct.findElement(By.xpath("./ul/li/span")).getText();
			System.out.println("Product Name is : " + sVal1);
			System.out.println("Product Price is : " + sVal2);
			
					
			//ScrollPageto(oProduct.getLocation().x,oProduct.getLocation().y);
						
			//Suporting_Lib.Write_Cell_Value_To_Excel(sExcelFile,sTxt , iExistingRow+iProduct+1, 0, sVal1);
			//Suporting_Lib.Write_Cell_Value_To_Excel(sExcelFile,sTxt , iExistingRow+iProduct+1, 1, sVal2);
			Write_Cell_Value_To_Excel(sExcelFile,sTxt , iProduct, 0, sVal1);
			Write_Cell_Value_To_Excel(sExcelFile,sTxt , iProduct, 1, sVal2);
			
			
			
		}
		
		
		
		
	}

public static void Write_Cell_Value_To_Excel(String sFile,String sSheet,int iRow,int iCell,String sValue){
	
	InputStream oFile;
	XSSFWorkbook oExcel ;
	XSSFSheet oSheet ;
	Row oRow ;
	Cell oCell ;
	 try {

		 oFile = new FileInputStream(sFile);
		 oExcel = new XSSFWorkbook(oFile);
		 
		 
		 oSheet = oExcel.getSheet(sSheet);
		 
		 if(oSheet == null)
		 {
			 oExcel.createSheet(sSheet);
			 oSheet = oExcel.getSheet(sSheet);
		 }
		 
		 		 
		 oRow = oSheet.getRow(iRow);
		 if(oRow == null)
		 {
			 oSheet.createRow(iRow);
			 oRow = oSheet.getRow(iRow);
		 }
		 
		 oCell = oRow.getCell(iCell);
		 
		 if(oCell==null)
		 {
			 oRow.createCell(iCell);
			 oCell= oRow.getCell(iCell);
		 }
		
		 oCell.setCellValue(sValue);
		 
		 
		 OutputStream oFileWrite = new FileOutputStream(sFile);
		 oExcel.write(oFileWrite);
		 oFileWrite.close();
		 
		oExcel.close();
		oFile.close();
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}

