package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TooltipFunc {
WebDriver driver;
@FindBy(xpath="//a[text()='Default functionality']")
WebElement Default_functionality;
@FindBy(xpath="//a[text()='custom animation demo']")
WebElement custom_animation_demo;

public TooltipFunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickWidgetmenu("Tooltip");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
}

public void defaultFunctionality() throws InterruptedException
{
	Default_functionality.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText("Tooltips"))).perform();
	Thread.sleep(1000);
	act.moveToElement(driver.findElement(By.linkText("ThemeRoller"))).perform();
	Thread.sleep(1000);
	act.moveToElement(driver.findElement(By.id("age"))).perform();
	Thread.sleep(1000);
}

public void customAnimationDemo() throws InterruptedException
{
	
	custom_animation_demo.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText("show"))).click().perform();
	Thread.sleep(2000);
	act.moveToElement(driver.findElement(By.linkText("hide"))).click().perform();
	Thread.sleep(3000);
	act.moveToElement(driver.findElement(By.linkText("open event"))).perform();
	Thread.sleep(3000);


	
	
	}


}
