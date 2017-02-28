package main.java.com.way2automation.ui;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertFunc {
	WebDriver driver;
@FindBy(xpath="//a[text()='Simple Alert']")
WebElement Simple_Alert;
@FindBy(xpath="//a[text()='Input Alert']")
WebElement Input_Alert;

public AlertFunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickAlertmenu("Alert");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
		

}

public void inputAlert()
{
	Input_Alert.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
WebElement ale =driver.findElement(By.tagName("button"));
ale.click();
Alert alt = driver.switchTo().alert();
alt.sendKeys("happy life");
alt.accept();
}

public void simpleAlert()
{
	Simple_Alert.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
WebElement ale =driver.findElement(By.tagName("button"));
ale.click();
Alert alt = driver.switchTo().alert();
alt.accept();
}

}
