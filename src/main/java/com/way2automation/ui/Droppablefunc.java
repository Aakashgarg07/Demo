package main.java.com.way2automation.ui;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.com.way2automation.config.TestConfig;
import main.java.com.way2automation.helper.Helper;
import main.java.com.way2automation.ui.Mainmenu;

public class Droppablefunc{
WebDriver driver;
@FindBy(xpath = "//a[text()='Default functionality']")
private WebElement Default_func;
@FindBy(xpath = "//a[text()='Accept']")
private WebElement Accept_text;
@FindBy(xpath = "//a[text()='Prevent propagation']")
private WebElement Prevent_propagation;
@FindBy(xpath = "//a[text()='Revert draggable Position']")
private WebElement Revert_draggable_Position;
@FindBy(xpath = "//a[text()='Shopping cart demo']")
private WebElement Shopping_cart_demo;

public Droppablefunc(WebDriver driver)
 { 
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickInteractionmenu("Droppable");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
	
 }

public void defaultFunctionality() throws InterruptedException
{
	Default_func.click();
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[1]")));
	driver.switchTo().frame(frame);
	WebElement src = driver.findElement(By.id("draggable"));
	WebElement tar = driver.findElement(By.id("droppable"));
	Helper.dragAndDropSourcetarget(driver, src, tar);
	
}

public void accept() throws InterruptedException
{
	Accept_text.click();	
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[2]")));
	driver.switchTo().frame(frame);
	System.out.println("Enter the choice");
	System.out.println("Enter 1. for I'm draggable but can't be dropped");
	System.out.println("Enter 2. for Drag me to my target ");
	Scanner in = new Scanner(System.in);
	int choice = in.nextInt();
	WebElement tar = driver.findElement(By.id("droppable"));
	
switch(choice)
{
case 1 :
{
	WebElement src1 = driver.findElement(By.id("draggable-nonvalid"));
	Helper.dragAndDropSourcetarget(driver, src1, tar);
	
}

case 2:
{
	WebElement src2 = driver.findElement(By.id("draggable"));
	Helper.dragAndDropSourcetarget(driver, src2, tar);

}

default : System.out.println("Enter the valid choice ");
}


}
public void preventPropagation() throws InterruptedException
{
	Prevent_propagation.click();
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[3]")));
	driver.switchTo().frame(frame);
	System.out.println("Enter the choice");
	System.out.println("Enter 1. for outer loop not greedy");
	System.out.println("Enter 2. for inner loop not greedy");
	System.out.println("Enter 3. for outer loop greedy");
	System.out.println("Enter 4. for inner loop greedy");
	Scanner in = new Scanner(System.in);
	int choice = in.nextInt();

	Thread.sleep(2000);
	
	switch(choice)
	{
	case 1: 
	{ // outer loop not greedy
		WebElement src = driver.findElement(By.id("draggable"));
		Helper.dragAndDropCoordinate(driver, src,146, 0);
		break;
	}
	
	case 2: 
	{ //inner loop not greedy
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement tar = driver.findElement(By.id("droppable-inner"));
		Helper.dragAndDropSourcetarget(driver, src, tar);
		break;
	}
	case 3: 
	{	//outer loop greedy
		WebElement src = driver.findElement(By.id("draggable"));
		Helper.dragAndDropCoordinate(driver, src, 414, 0);
		break;
	}
	case 4: 
	{// inner loop greedy
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement tar = driver.findElement(By.id("droppable2-inner"));
		Helper.dragAndDropSourcetarget(driver, src, tar);
		break;
	}
	
	default : System.out.println("Enter valid choice");
	
	}
}

public void revertDraggablePosition() throws InterruptedException
{
	Revert_draggable_Position.click();
	WebElement frame = driver.findElement(By.xpath(("(//iframe[@class='demo-frame'])[4]")));
	driver.switchTo().frame(frame);
	System.out.println("Enter the choice");
	System.out.println("Enter 1. for I revert when I'm dropped");
	System.out.println("Enter 2. for I revert when I'm not dropped ");
	Scanner in = new Scanner(System.in);
	int choice = in.nextInt();
	WebElement tar = driver.findElement(By.id("droppable"));
	
switch(choice)
{
case 1 :
{
	WebElement src1 = driver.findElement(By.id("draggable"));
	Helper.dragAndDropSourcetarget(driver, src1, tar);
	
}

case 2:
{
	WebElement src2 = driver.findElement(By.id("draggable2"));
	Helper.dragAndDropSourcetarget(driver, src2, tar);

}

default : System.out.println("Enter the valid choice ");
}
}

public void shoppingCartDemo() throws InterruptedException
{
int i=1;
	Shopping_cart_demo.click();
	WebElement frame = driver.findElement(By.cssSelector("iframe[src='droppable/default5.html']"));
	driver.switchTo().frame(frame);
	List <WebElement> src = driver.findElements(By.xpath("//div[@id='ui-id-2']/ul/li"));
	
	Actions act = new Actions(driver);
	for(WebElement ele : src)
	{
		WebElement tar = driver.findElement(By.xpath("//ol[@class ='ui-droppable ui-sortable']"));
		System.out.println(ele.getText());
		++i;
	//	act.dragAndDropBy(ele, 541, 116);
		Helper.dragAndDropSourcetarget(driver, ele, tar);
		Thread.sleep(1000);
	}
	
	
}
	
}


