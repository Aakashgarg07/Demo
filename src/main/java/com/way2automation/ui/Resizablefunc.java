package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.com.way2automation.ui.Mainmenu;
import main.java.com.way2automation.helper.Helper;

public class Resizablefunc {
WebDriver driver;
	@FindBy(xpath = "//a[text()='Default functionality']")
	private WebElement Default_functionality;
	@FindBy(xpath ="//a[text()='Animate']")
	private WebElement Animat;
	@FindBy(xpath ="//a[text()='Constrain resize area']")
	private WebElement Constrain_resize_area;
	@FindBy(xpath ="//a[text()='Helper']")
	private WebElement Help;
	@FindBy(xpath ="//a[text()='Max/Min size']")
	private WebElement MaxMin_size;
	
	
public	Resizablefunc(WebDriver driver)
	{
		Mainmenu menu = new Mainmenu(driver);
		if(driver==null)
		{System.out.println("Null is in driver");}
		menu.clickInteractionmenu("Resizable");
		this.driver = menu.driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void defaultfunctionality() throws InterruptedException
	{
		Default_functionality.click();
		WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[1]")));
		driver.switchTo().frame(frame);
	    WebElement resize =	driver.findElement(By.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
	    Helper.resizable(driver, resize, 250, 300);
	    
		
	}
	
	public void animate() throws InterruptedException
	{
		Animat.click();
		WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[2]")));
		driver.switchTo().frame(frame);
		WebElement resize =	driver.findElement(By.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Helper.dragAndDropCoordinate(driver, resize, 200, 100);
		
	}
	public void constrainResizeArea() throws InterruptedException
	{
		Constrain_resize_area.click();
		WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[3]")));
		driver.switchTo().frame(frame);
		WebElement resize =	driver.findElement(By.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Helper.dragAndDropCoordinate(driver, resize, 100, 100);
		
	}
	public void Helper() throws InterruptedException
	{
		Help.click();
		WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[4]")));
		driver.switchTo().frame(frame);
		WebElement resize =	driver.findElement(By.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Helper.dragAndDropCoordinate(driver, resize, 300, 100);
		
	}
	
	
	public void maxMin_size() throws InterruptedException
	{
		MaxMin_size.click();
		WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[5]")));
		driver.switchTo().frame(frame);
		WebElement resize =	driver.findElement(By.cssSelector("div[class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
		Helper.dragAndDropCoordinate(driver, resize, 300, 100);
		Helper.dragAndDropCoordinate(driver, resize, 100, 100);
	}

}



