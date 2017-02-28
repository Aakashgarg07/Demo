package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuFunc {
WebDriver driver;
@FindBy(xpath="//a[text()='Simple Menu']")
WebElement Simple_Menu;
@FindBy(xpath="//a[text()='Menu With Sub Menu']")
WebElement Menu_With_Sub_Menu;
@FindBy(xpath="//a[text()='Select Menu']")
WebElement Select_Menu;

public MenuFunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickWidgetmenu("Menu");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
	
}

public void simpleMenu()
{
	Simple_Menu.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//li[text()='Addyston']")).click();;

}

public void menuWithSubMenu()
{	driver.switchTo().defaultContent();
	Menu_With_Sub_Menu.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//li[contains(text(),'Adamsville')]")).click();
    driver.findElement(By.xpath("//li[text()='Sub Menu 3']")).click();
	

}

public void selectMenu()
{
	Select_Menu.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]"));
	driver.switchTo().frame(frame);
	WebElement image = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/div/div/table/tbody/tr/td[2]/p/img"));
	Actions act= new Actions(driver);
	act.contextClick(image).sendKeys("i").build().perform();
}
}
