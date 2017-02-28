package main.java.com.way2automation.config;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import main.java.com.way2automation.helper.*;

public class TestConfig {
	public static WebDriver driver;
	public static void launch(WebDriver driver) 
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String url = Getdata.fromProperty(".\\TestData\\Config.properties","url");
		driver.get(url);
		driver.findElement(By.xpath("(//div[h1[text() = 'Interaction']]/ul[@class = 'boxed_style block']/li)[1]")).click();
		Helper.newwindow(driver,1);
		driver.findElement(By.linkText("Signin")).click();
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).sendKeys("aakashgarg07");
		driver.findElement(By.xpath("(//input[@name ='password'])[2]")).sendKeys("aakashgarg",Keys.ENTER);
		try
		{Thread.sleep(3000);}
		catch(InterruptedException e)
		{
			System.out.println("got stuck");
			
		}
	}
	@BeforeClass
	public void precondtion()
	{
		String browser_name = Getdata.fromProperty(".\\TestData\\Config.properties","browser");
			if(browser_name.equals("FF"))
		{
			driver = new FirefoxDriver();
			launch(driver);
		}
		else if(browser_name.equals("GC"))
		{   System.setProperty("webdriver.chrome.driver",".\\external_jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			launch(driver);
		}

		if(browser_name.equals("IE"))
		{	System.setProperty("webdriver.ie.driver",".\\external_jars\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			launch(driver);
		}
		
		System.out.println("in before driver addresss in test config" +driver);
	}
	
	@AfterClass
	public void close_browser()
	{System.out.println("In After method");
	{System.out.println("Driver is null"+driver);}
		//driver.quit();
	}
	
		
		}
