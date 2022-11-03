package Zerodha;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.utility.RandomString;

public class Homepage {
	
	@FindBy (xpath="//a[@href='/orders']")
	private WebElement orders;
	
	@FindBy (xpath="//span[text()='Holdings']")
	private WebElement holdings;
	
	@FindBy (xpath="//span[text()='Positions']")
	private WebElement positions;
	
	@FindBy (xpath="//span[text()='Funds']")
	private WebElement funds;
	
	@FindBy (xpath="//span[text()='Apps']")
	private WebElement apps;
	
	@FindBy (xpath="//span[@class='user-id']")
	private WebElement profilename;
	
	@FindBy (xpath="//a[@target='_self']")
	private WebElement logout;
	
	public Homepage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void screenshot(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String functions = RandomString.make();
		File dest = new File("C:\\Users\\lahan\\OneDrive\\Pictures\\Screenshots\\Homepage"+functions+".jpg");
		FileHandler.copy(source, dest);
	}
	public void order() {
		orders.click();
	}
	public void holdings() {
		holdings.click();
	}
	public void positions() {
		positions.click();
	}
	public void funds() {
		funds.click();
	}
	public void apps() {
		apps.click();
	}
	public void profile() throws InterruptedException {
		profilename.click();
		Thread.sleep(2000);
		logout.click();
	}

}
