package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitButton {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Starts With']")
	WebElement Starts_With;
	@FindBy(xpath="//a[text()='Ends With']")
	WebElement Ends_With;
	@FindBy(xpath="//a[text()='Complete id Dynamic']")
	WebElement Complete_id_Dynamic;

	public SubmitButton(WebDriver driver)
	{
		Mainmenu menu = new Mainmenu(driver);
		if(driver==null)
		{System.out.println("Null is in driver");}
		menu.clickDynamic_Elementsmenu("Submit Button Clicked");
		this.driver = menu.driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
public void startsWith()
{
	Starts_With.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//input[@type ='text']")).sendKeys("checking dyanmic");
	driver.findElement(By.id("submit")).submit();
}
public void endsWith()
{
	Ends_With.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//input[@type ='text']")).sendKeys("checking dyanmic");
	driver.findElement(By.id("1111")).submit();
}

public void completeIdDynamic()
{
	Complete_id_Dynamic.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//input[@type ='text']")).sendKeys("checking dyanmic");
	driver.findElement(By.id("1111")).submit();
}

}


