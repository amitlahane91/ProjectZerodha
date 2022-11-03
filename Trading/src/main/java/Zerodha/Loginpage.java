package Zerodha;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	@FindBy (xpath="//input[@type='text']")
	private WebElement userid;
	
	@FindBy (xpath="//input[@type='password']") 
	private WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement loginbutton;
	
	
	public Loginpage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void enterid() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\lahan\\OneDrive\\Documents\\Parameter\\Mydata.xlsx");
		String id = WorkbookFactory.create(file).getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();
		userid.sendKeys(id);
	}
	public void enterpswd() throws EncryptedDocumentException, IOException {
		FileInputStream file1 = new FileInputStream("C:\\Users\\lahan\\OneDrive\\Documents\\Parameter\\Mydata.xlsx");
		String pswd = WorkbookFactory.create(file1).getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		password.sendKeys(pswd);
	}
	public void clicklogin() {
		loginbutton.click();
	}

}
