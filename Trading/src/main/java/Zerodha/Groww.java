package Zerodha;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groww {
	
	@FindBy (xpath="(//div[@class='absolute-center btn51ParentDimension'])[1]")
	private WebElement register;
	
	public Groww(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void log() {
		register.click();
	}

}
