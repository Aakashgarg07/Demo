package main.java.com.way2automation.ui;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.helper.Helper;
import main.java.com.way2automation.ui.Mainmenu;

public class Selectablefunc {
	WebDriver driver;
	@FindBy(xpath = "//a[text()='Default functionality']")
	WebElement Default_functionality;
	@FindBy(xpath = "//a[text()='Display as grid']")
	WebElement Display_as_grid;
	@FindBy(xpath = "//a[text()='Serialize']")
	WebElement Serializ;

public Selectablefunc(WebDriver driver)
{
	
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickInteractionmenu("Selectable");
	PageFactory.initElements(driver, this);
	this.driver = menu.driver;
	
}

public void defaultFunctionality(int beg, int end) throws InterruptedException
{
	
	Default_functionality.click();
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[1]")));
	driver.switchTo().frame(frame);
     WebElement src = driver.findElement(By.xpath("//li[text()='Item " + beg +"']"));
     WebElement tar = driver.findElement(By.xpath("//li[text()='Item " + end +"']")); 
     Helper.selectable(driver, src, tar);


}

public void displayAsGrid(int beg, int end)
{
	Display_as_grid.click();	
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[2]")));
	driver.switchTo().frame(frame);
	WebElement src = driver.findElement(By.xpath("//li[text()='" + beg+ "']"));
    WebElement tar = driver.findElement(By.xpath("//li[text()='" + end+ "']")); 
    Helper.selectable(driver, src, tar);

}

public void Serialize(int beg, int end)
{
	Serializ.click();	
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[3]")));
	driver.switchTo().frame(frame);
	WebElement src = driver.findElement(By.xpath("//li[text()='Item " + beg +"']"));
    WebElement tar = driver.findElement(By.xpath("//li[text()='Item " + end +"']")); 
    Helper.selectable(driver, src, tar);

}

}
