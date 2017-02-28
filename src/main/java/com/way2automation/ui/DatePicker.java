package main.java.com.way2automation.ui;
/*
import java.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import bsh.ParseException;
import main.java.com.way2automation.helper.Helper;


public class DatePicker {
	WebDriver driver;
@FindBy(xpath="//a[text()='Default functionality']")
WebElement Default_functionality;
@FindBy(xpath="//a[text()='Animations']")
WebElement Animations;
@FindBy(xpath="//a[text()='Display month & year']")
WebElement Display_month_year;
@FindBy(xpath="//a[text()='Format date']")
WebElement Format_date;
public DatePicker(WebDriver driver)
{
	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickWidgetmenu("Datepicker");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
	
}

public void defaultFunctionality(LocalDate date) throws ParseException, InterruptedException
{
	
	Default_functionality.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[1]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.id("datepicker")).click();
	LocalDate end  = LocalDate.now();
   Helper.dateSelector(driver,date, end);
	
}

public void animations(LocalDate date,String dropdown) throws InterruptedException
{
	
	Animations.click();
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[2]"));
	driver.switchTo().frame(frame);
	WebElement DDL = driver.findElement(By.id("anim"));
	Helper.selectdropdown(DDL, dropdown);
	driver.findElement(By.id("datepicker")).click();
	LocalDate end  = LocalDate.now();
	 Helper.dateSelector(driver,date, end);
		
}
public void displayMonthYear(LocalDate date)
{
	Display_month_year.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[3]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.id("datepicker")).click();
	WebElement year = driver.findElement(By.xpath("//Select[@class= 'ui-datepicker-year']"));
	String yearstring = ""+ date.getYear();
	Helper.selectdropdown(year, yearstring);
	String monthstring = ""+ (date.getMonthValue() -1);
	WebElement month = driver.findElement(By.xpath("//Select[@class= 'ui-datepicker-month']"));
	Helper.selectdropdownbyvalue(month, monthstring);
	driver.findElement(By.linkText(""+date.getDayOfMonth()+"")).click();
}

public void formatDate(LocalDate date,String text) throws InterruptedException
{
	Format_date.click();	
	WebElement frame = driver.findElement(By.xpath("(//iframe[@class='demo-frame'])[4]"));
	driver.switchTo().frame(frame);
	driver.findElement(By.id("datepicker")).click();
	LocalDate end  = LocalDate.now();
    Helper.dateSelector(driver,date, end);
	WebElement format = driver.findElement(By.id("format"));
	Helper.selectdropdown(format,text);
}
}
*/