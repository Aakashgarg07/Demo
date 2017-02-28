package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.helper.Helper;
import main.java.com.way2automation.ui.Mainmenu;

public class Sortablefunc {
	WebDriver driver;
@FindBy(xpath = "//a[text()= 'Default functionality']")
WebElement Default_functionality;
@FindBy(xpath = "//a[text()= 'Connect Lists']")
WebElement Connect_Lists;
@FindBy(xpath = "//a[text()= 'Display as grid']")
WebElement Display_as_grid;
@FindBy(xpath = "//a[text() = 'Portlets']")
WebElement Portlet;

public Sortablefunc(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickInteractionmenu("Sortable");
	PageFactory.initElements(driver, this);
	this.driver = menu.driver;	

}

public void defaultFunctionality() throws InterruptedException
{
	Default_functionality.click();	
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[1]")));
	driver.switchTo().frame(frame);
    WebElement tar = driver.findElement(By.xpath("//li[text()='Item 1']"));
		for(int i=7;i>1;i--)
	{	
		WebElement src = driver.findElement(By.xpath("//li[text()='Item " +i +"']"));
		Helper.selectable(driver, src, tar);
		
		
	}
}
public void connectLists(WebDriver driver) throws InterruptedException
{
	Connect_Lists.click();	
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[2]")));
	driver.switchTo().frame(frame);
	 WebElement tar1= driver.findElement(By.xpath("//ul[@id='sortable1']/li[text()='Item " + 5 +"']"));
	   WebElement tar2= driver.findElement(By.xpath("//ul[@id='sortable2']/li[text()='Item " + 5 +"']"));
	   
	for(int i=1;i<=5;i++)
	{	
    WebElement src1= driver.findElement(By.xpath("//ul[@id='sortable1']/li[text()='Item " + i +"']"));
    WebElement src2= driver.findElement(By.xpath("//ul[@id='sortable2']/li[text()='Item " + i +"']"));
    Helper.selectable(driver,src1, tar2);
    Helper.selectable(driver, src2,tar1 );
	}
}

public void displayAsGrid(WebDriver driver) throws InterruptedException
{
	Display_as_grid.click();	
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[3]")));
	driver.switchTo().frame(frame);
	WebElement tar = driver.findElement(By.xpath("//li[text()='1']"));
	for(int i=12;i>=1;i--)
{
		WebElement src = driver.findElement(By.xpath("//li[text()='" +i +"']"));
		Helper.dragAndDropSourcetarget(driver, src, tar);
		
	}
	
}


}
