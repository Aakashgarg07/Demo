package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TabsFunc {
WebDriver driver;
@FindBy(xpath="//a[text()='Tabs']")
WebElement Tabs;

public TabsFunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickWidgetmenu("Tabs");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
}

public void tabs()
{
WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
driver.switchTo().frame(frame);
driver.findElement(By.xpath("//a[text()='Tab 2']")).click();
driver.findElement(By.xpath("//a[text()='Tab 1']")).click();
driver.findElement(By.xpath("//a[text()='Tab 3']")).click();
}
}
