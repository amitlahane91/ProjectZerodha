package TestZerodha;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Zerodha.Homepage;
import Zerodha.Loginpage;
import Zerodha.Logout;
import Zerodha.PINpage;
import net.bytebuddy.utility.RandomString;

public class ZerodhaTesting {
	WebDriver driver;
	Loginpage log;
	PINpage pinn;
	Homepage home;
	Logout logout;
	
		@BeforeClass
		public void openbrowser() {
		    System.setProperty("webdriver.gecko.driver", "C:\\Users\\lahan\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		    driver.manage().window().maximize();
		    }
		@BeforeMethod
		public void login() throws InterruptedException, EncryptedDocumentException, IOException {
			System.out.println("Before Method");
			driver.get("https://kite.zerodha.com/");
			log = new Loginpage(driver);
			log.enterid();
			log.enterpswd();
			log.clicklogin();
			
			pinn = new PINpage(driver);
			Thread.sleep(3000);
			pinn.enterpin();
			pinn.clickcontinue();
			home = new Homepage(driver);
			logout = new Logout(driver);
		    }
		
		@Test (priority=1)
		public void testorders() throws IOException {
			System.out.println("testorders");
			home.order();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println("Page Title= "+title); 
			
			if(url.equals("https://kite.zerodha.com/orders")&&title.equals("Orders / Kite")) {
				System.out.println("test case pass");
				home.screenshot(driver);
			}
			else {
				System.out.println("test case fail");
			}			
			}
		
		@Test  (priority=2)
		public void testholdings() throws IOException {
			System.out.println("testholdings");
			home.holdings();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println("Page Title= "+title);
			
			/*if(url.equals("https://kite.zerodha.com/holdings")&&title.equals("Holdings / Kite")) {
				System.out.println("test case pass");
				home.screenshot(driver);
			}
			else {
				System.out.println("test case fail");
			}		*/
			Assert.assertEquals(title, "Holdings / Kite");
			System.out.println("test case pass");
		    }
		
		@Test  (priority=3)
		public void testpositions() throws IOException {
			System.out.println("testpositions");
			home.positions();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println("Page Title= "+title);
			
			if(url.equals("https://kite.zerodha.com/positions")&&title.equals("Positions / Kite")) {
				System.out.println("test case pass");
				home.screenshot(driver);
			}
			else {
				System.out.println("test case fail");
			}			
		    }
		
		@Test  (priority=4)
		public void testfunds() throws IOException {
			System.out.println("testfunds");
			home.funds();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println("Page Title= "+title);
			
			if(url.equals("https://kite.zerodha.com/funds")&&title.equals("Funds / Kite")) {
				System.out.println("test case pass"); 
				home.screenshot(driver);
			}
			else {
				System.out.println("test case fail");
			}			
		    }
		
		@Test  (priority=5)
		public void testapps() throws IOException {
			System.out.println("testapps");
			home.apps();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println("Page Title= "+title);
			
			if(url.equals("https://kite.zerodha.com/apps")&&title.equals("Apps / Kite")) {
				System.out.println("test case pass");
				home.screenshot(driver);
			}
			else {
				System.out.println("test case fail");
			}			
		    }
		
	    @AfterMethod
	    public void testlogout() throws InterruptedException {
	    	System.out.println("After Method");
	    	Thread.sleep(2000);
	    	home.profile();
	    	logout.changeuser();
	    	System.out.println();
	    }
	   
	    @AfterClass
	    public void closebrowser() {
	    	driver.close();
	    }
	    
	    
	    

}
