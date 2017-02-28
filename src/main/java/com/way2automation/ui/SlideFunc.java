package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SlideFunc {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Range slider']")
	WebElement Range_slider;
	
public SlideFunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickWidgetmenu("Slider");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
		
}

public void rangeSlider()
{
	Range_slider.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	WebElement slider= driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all']"));
	Actions act = new Actions(driver);
	act.clickAndHold(slider).sendKeys(Keys.ARROW_RIGHT).build().perform();;
}
}
