package main.java.com.way2automation.ui;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.helper.Helper;

public class FramesAndWindows {
WebDriver driver;
@FindBy(xpath="//a[text()='Open New Window']")
WebElement Open_New_Window;
@FindBy(xpath="//a[text()='Open Seprate New Window']")
WebElement Open_Seprate_New_Window;
@FindBy(xpath="//a[text()='Frameset']")
WebElement Frameset;
@FindBy(xpath="//a[text()='Open Multiple Windows']")
WebElement Open_Multiple_Windows;

public FramesAndWindows (WebDriver driver)
{
	
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickFrames_and_Windowsmenu("Frames and Windows");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
	
}

public void openNewWindow()
{
	Open_New_Window.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.linkText("New Browser Tab")).click();
	driver.switchTo().defaultContent();
	Helper.newwindow(driver, 2);
	driver.findElement(By.linkText("New Browser Tab")).click();


}

public void openSeprateNewWindow()
{
	Open_Seprate_New_Window.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.linkText("Open New Seprate Window")).click();
	driver.switchTo().defaultContent();
	Helper.newwindow(driver, 2);
	System.out.println(driver.getTitle());
	

}
public void frameset()
{
	Frameset.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.linkText("Open Frameset Window")).click();
	driver.switchTo().defaultContent();
	Helper.newwindow(driver, 2);
	System.out.println(driver.getTitle());
	driver.switchTo().frame("topFrame");
	System.out.println("First frame");
	System.out.println(driver.findElement(By.tagName("p")).getText());
	driver.switchTo().defaultContent();
	System.out.println("Second frame");
	driver.switchTo().frame("contentFrame");
	System.out.println(driver.findElement(By.tagName("p")).getText());
}

public void openMultipleWindows()
{
	Open_Multiple_Windows.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[4]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.linkText("Open multiple pages")).click();
	driver.switchTo().defaultContent();

	Helper.newwindow(driver, 4);
	driver.findElement(By.linkText("Open Window-1")).click();

    Helper.newwindow(driver, 3);
	driver.findElement(By.linkText("Open Window-2")).click();
	Helper.newwindow(driver, 2);
	driver.findElement(By.linkText("Open Window-3")).click();
}


}
