package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutoComplete {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Default functionality']")
	WebElement Default_functionality;
	@FindBy(xpath="//a[text()='Multiple Values']")
	WebElement Multiple_Values;
	@FindBy(xpath="//a[text()='Categories']")
	WebElement Categories;

public AutoComplete(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickWidgetmenu("Autocomplete");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
		
}


public void defaultFunctionality()
{
	Default_functionality.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	WebElement auto = driver.findElement(By.id("tags"));
	auto.sendKeys("a");
	auto.sendKeys(Keys.DOWN,Keys.ENTER);
	
}

public void multipleValues()
{	Multiple_Values.click();
	String[] a = {"py","ja","Ru"};
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	for(String st : a)
	{
		WebElement auto = driver.findElement(By.id("tags"));
		auto.sendKeys(st);
		auto.sendKeys(Keys.DOWN,Keys.ENTER);
		
		
	}

}

public void categories()
{	Categories.click();
	String[] a = {"py","ja","Ru"};
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]"));
	driver.switchTo().frame(frame);
	
		WebElement auto = driver.findElement(By.id("search"));
		auto.sendKeys("johnson");
		auto.sendKeys(Keys.DOWN,Keys.ENTER);
		
		
	
}
}