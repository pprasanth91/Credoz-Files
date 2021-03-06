package selenium.com.day9;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class Excel_Dataprovider {
	
	public static WebDriver driver;
	public static int iRow,iTotalRow,iCell,iTotalCell,rTotalCell;
	public static String sExcelFile = "./Data/Filpkart_Datadriven.xlsx";
	static int Arrow = 0;
	static int Arrcol = 0;
	
	
	@SuppressWarnings("deprecation")
	@DataProvider(name = "input")
	public static Object[][] ReadExcel()
	{
		// TODO Auto-generated method stub
		String sSheet,sStatus;
		String sSearchTxt,sSearchCat;
		sSheet = "Search";
		Object[][] Obj = null;
		
				try {
					InputStream oFile = new FileInputStream(sExcelFile);
					XSSFWorkbook oExcel = new XSSFWorkbook(oFile);
					XSSFSheet oSheet = oExcel.getSheet(sSheet);
					XSSFRow oRow;
					XSSFCell oCell;
					
					iTotalRow = oSheet.getLastRowNum();
					System.out.println("Total row:"+iTotalRow);
					Arrow=0;
					for(iRow=1;iRow<=iTotalRow;iRow++){
						
						
						oRow = oSheet.getRow(iRow);
						iTotalCell = oRow.getLastCellNum();
						System.out.println("Total cell:"+iTotalCell);
						Obj = new Object[iTotalRow-1][iTotalCell] ;
						//arrayExcelData=new String[iTotalRow][iTotalCell];
								// rTotalCell = oSheet.getRow(0).getLastCellNum();
						// System.out.println(rTotalCell);
						String[] Headers = new String[iTotalCell];
						//Arrcol=0;
						for(iCell=0;iCell<iTotalCell;iCell++)
						{
							//Headers[iCell] = oSheet.getRow(0).getCell(iCell).getStringCellValue();
							//if(Headers[iCell].equals("Status"))
					
							//{
							//oCell = oRow.getCell(iCell);
							//sStatus = oCell.getStringCellValue();
							//if(sStatus.equals("YES"))
							//{
								
								
							 sSearchTxt = oRow.getCell(0).getStringCellValue();
							sSearchCat = oRow.getCell(1).getStringCellValue();
							Obj[iRow-1][iCell] = new Object[][] {{sSearchTxt,sSearchCat}};
							// Obj = new Object[Arrow][Arrcol] ;
							// Obj[Arrow][Arrcol] = oRow.getCell(0).getStringCellValue();
							 
									 //{{sSearchTxt,sSearchCat}}; 
							
							//Arrcol++;
							System.out.println(Obj);
							
							//arrayExcelData[Arrow][Arrcol] = sSearchCat;
							//System.out.println(arrayExcelData[Arrow][Arrcol]);
							 //sSearchTxt[Arrow][Arrcol] = oRow.getCell(0).getStringCellValue();
						// sSearchCat[Arrow][Arrcol] = oRow.getCell(1).getStringCellValue();
									 //new String{{sSearchTxt,sSearchCat}};	
							 
							 
							//return 	arrayExcelData;
							//Search_Product(sSearchTxt,sSearchCat);
							//Get_Match(sSearchTxt);
							//}
							//}
							//Arrow++;
						}
						
						//arrayExcelData = new String[][]{{sSearchTxt,sSearchCat}};
						//Arrow++;
				}
					
					oExcel.close();
					oFile.close();
					//return arrayExcelData;
					
					}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Obj;
				
				
				
			
				
	}
			
	
	
			@BeforeClass
			public static void Page_Info(){
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
				 driver.manage().window().maximize();
				 driver.get("https://www.amazon.in/");
				 driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				 		 
			
			}
			//@DataProvider(name = "input")
			//public Object[][] SearchData() {
			//	Object[][] obj = ReadExcel("./Data/Filpkart_Datadriven.xlsx","Search");
			//	return obj;
			//}
			
			@Test(dataProvider="input")
			public static void Search_Product(String sTxt, String sCat) throws InterruptedException
			{
				WebElement oTextBox,oSearchBtn;
				Select ocat;
				
				
				oTextBox = driver.findElement(By.id("twotabsearchtextbox"));
				oSearchBtn = driver.findElement(By.xpath("(//input[@class='nav-input'])[1]"));
				
				
				
				oTextBox.clear();
				oTextBox.sendKeys(sTxt);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				ocat = new Select(driver.findElement(By.id("searchDropdownBox")));
				
				
				ocat.selectByVisibleText(sCat);
				
				oSearchBtn.click();
				
				Get_Match(sTxt);
				
				
			}
			
			
			//@Test(priority=2)
		public static void Get_Match(String sTxt) throws InterruptedException{
			
			
				
				WebElement oProduct;
				String sVal1,sVal2;
				List<WebElement> oAllproducts;
				
				int iProduct,iTotalproduct;
				Thread.sleep(10000);
				
				oAllproducts = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li"));
				
				iTotalproduct = oAllproducts.size();
				
				System.out.println("Total Product count : " + iTotalproduct );
				
				
				//iExistingRow = Suporting_Lib.Get_Max_RowCount_From_Excel(sExcelFile, sTxt);
				
				for(iProduct=0;iProduct< iTotalproduct;iProduct++)
				{
					oProduct = oAllproducts.get(iProduct);
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					sVal1 = oProduct.findElement(By.xpath("//ul[@id='s-results-list-atf']/li//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")).getText();
					sVal2 = oProduct.findElement(By.xpath("//a[@class='a-link-normal a-text-normal']/span")).getText();
					System.out.println("Product Name is : " + sVal1);
					System.out.println("Product Price is : " + sVal2);
					
							
					//ScrollPageto(oProduct.getLocation().x,oProduct.getLocation().y);
								
					//Suporting_Lib.Write_Cell_Value_To_Excel(sExcelFile,sTxt , iExistingRow+iProduct+1, 0, sVal1);
					//Suporting_Lib.Write_Cell_Value_To_Excel(sExcelFile,sTxt , iExistingRow+iProduct+1, 1, sVal2);
					Write_Cell_Value_To_Excel(sExcelFile,sTxt , iProduct, 0, sVal1);
					Write_Cell_Value_To_Excel(sExcelFile,sTxt , iProduct, 1, sVal2);
					
					
					
				}
				
				
				
				
			}
		//	@AfterSuite
		public static void Write_Cell_Value_To_Excel(String sFile,String sSheet,int iRow,int iCell,String sValue){
			
			InputStream oFile;
			XSSFWorkbook oExcel ;
			XSSFSheet oSheet ;
			XSSFRow oRow ;
			XSSFCell oCell ;
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



