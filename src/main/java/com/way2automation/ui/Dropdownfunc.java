package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.helper.Helper;

public class Dropdownfunc {
WebDriver driver;
@FindBy(xpath = "//a[text()='Select Country']")
WebElement Select_Country;
@FindBy(xpath = "//a[text()='Enter Country']")
WebElement Enter_Country;

public Dropdownfunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickDynamic_Elementsmenu("Dropdown");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
	
}

public void selectCountry()
{
	Select_Country.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	WebElement sel = driver.findElement(By.tagName("Select"));
	Helper.selectdropdown(sel, "India");


}

public void enterCountry()
{
	Enter_Country.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	WebElement sel = driver.findElement(By.xpath("//input[@class ='custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left ui-autocomplete-input']"));
	sel.clear();
	sel.sendKeys("India",Keys.TAB);

}

}
