package main.java.com.way2automation.ui;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.helper.Helper;

public class Accordion {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Default functionality']")
	WebElement Default_functionality;
	@FindBy(xpath="//a[text()='Customize icons']")
	WebElement Customize_icons;
	@FindBy(xpath="//a[text()='Fill Space']")
	WebElement Fill_Space;

	public Accordion(WebDriver driver)
	{
		Mainmenu menu = new Mainmenu(driver);
		if(driver==null)
		{System.out.println("Null is in driver");}
		menu.clickWidgetmenu("Accordion");
		this.driver = menu.driver;
		PageFactory.initElements(driver, this);
		
	}
	public void defaultFunctionality(int choice)
	{
		Default_functionality.click();
		WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
		driver.switchTo().frame(frame);
		WebElement src= null;
		if(choice == 1)
		{src = driver.findElement(By.id("ui-id-1"));
		}
		else if(choice == 2)
		{ src = driver.findElement(By.id("ui-id-3"));
		}
		
		else if(choice == 3)	
		{ src = driver.findElement(By.id("ui-id-5"));
		}
		else if(choice == 4)
		{src = driver.findElement(By.id("ui-id-7"));
		}
		src.click();
		driver.switchTo().defaultContent();
	}
	
	public void customizeIcons(int Select,int choice) throws IOException
	{
		
		Customize_icons.click();
		WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
		driver.switchTo().frame(frame);
		WebElement toggel = driver.findElement(By.id("toggle"));
		if(Select== 1)
			{
			toggel.click();
			}
		WebElement src= null;
		if(choice == 1)
		{src = driver.findElement(By.id("ui-id-1"));
		}
		else if(choice == 2)
		{ src = driver.findElement(By.id("ui-id-3"));
		}
		
		else if(choice == 3)	
		{ src = driver.findElement(By.id("ui-id-5"));
		}
		else if(choice == 4)
		{src = driver.findElement(By.id("ui-id-7"));
		}
		src.click();
	
		File srcimg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File tarimg= new File("C:\\Aakash\\Framework_Saphire\\gitpro\\screenshot\\moki.png");
		FileUtils.copyFile(srcimg, tarimg);		
		driver.switchTo().defaultContent();
	}
	
	public void fillSpace(int choice) throws InterruptedException
	{
		Fill_Space.click();
		WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]"));
		driver.switchTo().frame(frame);
		WebElement resize =	driver.findElement(By.cssSelector(".ui-resizable-handle.ui-resizable-se.ui-icon"));;
		Helper.resizable(driver, resize, 943, 358);
		WebElement src= null;
		if(choice == 1)
		{src = driver.findElement(By.id("ui-id-1"));
		}
		else if(choice == 2)
		{ src = driver.findElement(By.id("ui-id-3"));
		}
		
		else if(choice == 3)	
		{ src = driver.findElement(By.id("ui-id-5"));
		}
		else if(choice == 4)
		{src = driver.findElement(By.id("ui-id-7"));
		}
		src.click();
	
		driver.switchTo().defaultContent();
	
	
	}
}
