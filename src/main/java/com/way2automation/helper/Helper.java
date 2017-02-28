package main.java.com.way2automation.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Helper {

public static void clickListElements(List<WebElement> list,String option)	
{
	int size = list.size(); 
	for(int i=0;i<size;i++)
	{ 
		WebElement li = list.get(i);
		if(li.getText().equals(option))
		{		li.click();
		break;
		}
	}	
}
public static void dragAndDropCoordinate(WebDriver driver, WebElement element,int x,int y) throws InterruptedException
{

	Actions act  = new Actions(driver);
	act.dragAndDropBy(element, x, y).perform();
	Thread.sleep(1000);
}

public static void dragAndDropSourcetarget(WebDriver driver, WebElement src, WebElement tar) throws InterruptedException
{
	Actions act  = new Actions(driver);
	act.dragAndDrop(src, tar).perform();
	Thread.sleep(1000);

}

public static void dragAndDropSourcetarget(WebDriver driver, WebElement src, WebElement tar,WebElement sortable) throws InterruptedException
{
	Actions act  = new Actions(driver);
	act.click(src).clickAndHold().moveToElement(sortable).release(tar).build().perform();
	Thread.sleep(1000);

}

public static void resizable(WebDriver driver, WebElement src, int x, int y) throws InterruptedException
{
	Actions act = new Actions(driver);
    act.clickAndHold(src).moveByOffset(x, y).release().build().perform();
    Thread.sleep(1000);

}

public static void selectable(WebDriver driver, WebElement src, WebElement tar)
{
	
	   Actions act = new Actions(driver) ;  
	   act.clickAndHold(src).moveToElement(tar).release().build().perform();

}
public static void dateSelector(WebDriver driver, LocalDate start,LocalDate end) throws InterruptedException
{
	if(start.isBefore(end))
    { 
		int month =(int) (start.until(end, ChronoUnit.MONTHS));
    for(int i=0;i<month;i++)
     {
    driver.findElement(By.xpath("//span[text()='Prev']")).click();
    
     }
    }
	else if(start.isAfter(end))
    {
		int month =(int) (end.until(start, ChronoUnit.MONTHS));
    for(int i=0;i<month;i++)
     {
    	driver.findElement(By.xpath("//span[text()='Next']")).click();
		}
    }
	
	driver.findElement(By.linkText(""+start.getDayOfMonth()+"")).click();
   
	

}

public static void selectdropdown(WebElement DDL,String text)
{
	
	Select sel = new Select(DDL);
	sel.selectByVisibleText(text);
	
}

public static void selectdropdownbyvalue(WebElement DDl,String value )
{
	Select sel = new Select(DDl);
	sel.selectByValue(value);
		

}
public static void newwindow(WebDriver driver, int page )
{
	Set<String> uids = driver.getWindowHandles();
	Iterator <String> it = uids.iterator();
	String parentid = it.next();
	for(int i=1;i<page;i++)
	{it.next();}
	String childId = it.next();
	driver.switchTo().window(childId);

}

}
