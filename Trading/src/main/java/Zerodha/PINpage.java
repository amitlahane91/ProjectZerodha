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

public class PINpage {
	
	@FindBy (xpath="//input[@label='PIN']")
	private WebElement pin;
	
	@FindBy (xpath="//button[@type='submit']")
	private WebElement continuee;
	
	public PINpage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void enterpin() throws EncryptedDocumentException, IOException {
		FileInputStream file2 = new FileInputStream("C:\\Users\\lahan\\OneDrive\\Documents\\Parameter\\Mydata.xlsx");
		String PIN = WorkbookFactory.create(file2).getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();
		pin.sendKeys(PIN);
	}
	
	public void clickcontinue() {
		continuee.click();
	}

}
