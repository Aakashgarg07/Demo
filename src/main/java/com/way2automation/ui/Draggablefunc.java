package main.java.com.way2automation.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.config.TestConfig;
import main.java.com.way2automation.helper.Helper;
import main.java.com.way2automation.ui.Mainmenu;

public class Draggablefunc{
	WebDriver driver;
@FindBy(xpath = "//a[text() = 'Default functionality']")
private WebElement Default_func;
@FindBy(xpath = "//a[text() = 'Constrain movement']")
private WebElement Constrain_move; 
@FindBy(xpath = "//a[text() = 'Cursor style']")
private WebElement Cursor_st;
@FindBy(xpath = "//a[text() = 'Events']")
private WebElement Event; 
@FindBy(xpath = "//a[text() = 'Draggable + Sortable']")
private WebElement Draggablesortable; 

Draggablefunc(WebDriver driver)
{		
Mainmenu menu = new Mainmenu(driver);
if(driver==null)
{System.out.println("Null is in driver");}
menu.clickInteractionmenu("Draggable");
this.driver = driver;
PageFactory.initElements(driver, this);
}


public  void defaultFunctionality(WebDriver driver) throws InterruptedException
{
	Default_func.click();
WebElement frame = driver.findElement((By.xpath("(//iframe[@class = 'demo-frame'])[1]")));
driver.switchTo().frame(frame);
WebElement drag = driver.findElement(By.id("draggable"));
Helper.dragAndDropCoordinate(driver, drag, 40, 100);
}


public  void constrainMovement(WebDriver driver, String choice ) throws InterruptedException  
{
	Constrain_move.click();
	WebElement frame = driver.findElement((By.xpath("(//iframe[@class = 'demo-frame'])[2]")));
	driver.switchTo().frame(frame);
	switch(choice)
	{
	
	case "First":	
	{
	WebElement drag1 = driver.findElement(By.id("draggable"));
	WebElement drag2 = driver.findElement(By.id("draggable2"));
	Helper.dragAndDropCoordinate(driver, drag1, 0, 200);
	Helper.dragAndDropCoordinate(driver, drag2, 200, 0);
	}

	case "Second" :
		
	{
	WebElement drag1 = driver.findElement(By.id("draggable3"));
	WebElement drag2  = driver.findElement(By.id("draggable5"));
	Helper.dragAndDropCoordinate(driver, drag1, 100, 200);
	Helper.dragAndDropCoordinate(driver, drag2, 0, -400);
	}

	case "Both":
	{
		WebElement drag1 = driver.findElement(By.id("draggable"));
		WebElement drag2 = driver.findElement(By.id("draggable2"));
		Helper.dragAndDropCoordinate(driver, drag1, 0, 200);
		Helper.dragAndDropCoordinate(driver, drag2, 200, 0);
		WebElement drag3 = driver.findElement(By.id("draggable3"));
		WebElement drag4  = driver.findElement(By.id("draggable5"));
		Helper.dragAndDropCoordinate(driver, drag3, 100, 200);
		Helper.dragAndDropCoordinate(driver, drag4, 0, -400);

	}	
	default :
	{ System.out.println("Enter the following choices First or Second or Both");}

	
	}
}



public  void cursorStyle(WebDriver driver) throws InterruptedException
{
Cursor_st.click();
WebElement frame = driver.findElement((By.xpath("(//iframe[@class = 'demo-frame'])[3]")));
driver.switchTo().frame(frame);
WebElement drag1 = driver.findElement(By.id("draggable"));
WebElement drag2  = driver.findElement(By.id("draggable2"));
WebElement drag3  = driver.findElement(By.id("draggable3"));
Helper.dragAndDropCoordinate(driver, drag1, 200, 200);
Helper.dragAndDropCoordinate(driver, drag2, 100, 100);
Helper.dragAndDropCoordinate(driver, drag3, 300, 300);
}



public  void events(WebDriver driver) throws InterruptedException
{
	Event.click();
WebElement frame = driver.findElement((By.xpath("(//iframe[@class = 'demo-frame'])[4]")));
driver.switchTo().frame(frame);
WebElement drag1 = driver.findElement(By.id("event-start"));
int t=0;
for(int i=0; i<10;i++)
{ t= t+10;
Helper.dragAndDropCoordinate(driver, drag1, (10+t), (110-t));
System.out.println("iteration"+i);
}
}



public  void draggableSortable(WebDriver driver) throws InterruptedException
{
	Draggablesortable.click();
WebElement frame = driver.findElement((By.xpath("(//iframe[@class = 'demo-frame'])[5]")));
driver.switchTo().frame(frame);
WebElement target = driver.findElement(By.id("draggable"));
System.out.println("Before for loop");
WebElement sortable = driver.findElement(By.xpath("//li[text()='Item 1']"));
for(int i=5;i>=1;i--)
{
WebElement source = driver.findElement(By.xpath("//li[text()='Item " +i +"']"));
System.out.println(target);
Helper.dragAndDropSourcetarget(driver, source,target,sortable);
System.out.println("iteration"+i);

}
System.out.println("after for loop");
}

}
