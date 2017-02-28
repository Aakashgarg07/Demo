package main.java.com.way2automation.ui;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import main.java.com.way2automation.helper.Helper;

public class Registrationfunc {
WebDriver driver;
@FindBy(name="name")
WebElement FirstName;
@FindBy(xpath="(//input[@type = 'text'])[2]")
WebElement Last_Name;
@FindBy(xpath="(//div[@class='radio_wrap'])[1]/label")
List <WebElement> Marital_status;
@FindBy(xpath="(//div[@class='radio_wrap'])[2]/label")
List <WebElement> Hobby;
@FindBy(xpath ="//fieldset/select[@id='']")
WebElement Country;
@FindBy(xpath="(//Select[@id=''])[2]")
WebElement Date_of_Birth_Month;
@FindBy(xpath="(//Select[@id=''])[3]")
WebElement Date_of_Birth_day;
@FindBy(xpath="(//Select[@id=''])[4]")
WebElement Date_of_Birth_year;
@FindBy(name="phone")
WebElement phone;
@FindBy(name="username")
WebElement username;
@FindBy(name="email")
WebElement email;
@FindBy(xpath="//input[@name='']")
WebElement file_upload;
@FindBy(css="textarea[rows='5']")
WebElement About_Yourself;
@FindBy(name="password")
WebElement password;
@FindBy(name="c_password")
WebElement confirm_password;
@FindBy(css = "input[value='submit']")
WebElement submit;

public Registrationfunc(WebDriver driver)
{

	Mainmenu menu = new Mainmenu(driver);
	if(driver==null)
	{System.out.println("Null is in driver");}
	menu.clickRegistrationmenu("Registration");
	this.driver = menu.driver;
	PageFactory.initElements(driver, this);
	
}

public void filling_The_Reqest() throws InterruptedException, IOException
{
	

FirstName.sendKeys("Automation");
Last_Name.sendKeys("Testing");
Helper.clickListElements(Marital_status,"Single");
Helper.clickListElements(Hobby,"Cricket");
Helper.selectdropdown(Country,"India");
Helper.selectdropdown(Date_of_Birth_Month,"1");
Helper.selectdropdown(Date_of_Birth_day,"1");
Helper.selectdropdown(Date_of_Birth_year,"2014");
phone.sendKeys("9108205644");
username.clear();
username.sendKeys("Shaktiman07");
email.clear();
email.sendKeys("Shaktiman07@gmail.com");
Runtime.getRuntime().exec("C:\\Aakash\\Framework_Saphire\\autoupload.exe");
file_upload.click();
Thread.sleep(3000);
About_Yourself.sendKeys("Life is getting boring");
password.sendKeys("shaktiman");
confirm_password.sendKeys("shaktiman");
submit.click();

}
}
