package testpack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Zerodha.Groww;

public class TestGroww {
	
	WebDriver driver;
	  Groww x;
	
	@BeforeClass
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lahan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("before method running");
		driver.get("https://groww.in/");
		
		
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println("test running");
		x = new Groww(driver);
		x.log();
	}
	

}
