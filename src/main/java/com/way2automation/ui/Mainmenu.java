package main.java.com.way2automation.ui;

import java.util.List;
import main.java.com.way2automation.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mainmenu {
public static WebDriver driver; 
	@FindBy(xpath = "//div[h1[text() = 'Interaction']]/ul[@class = 'boxed_style block']/li")
	List<WebElement> Interactionmenu;
	@FindBy(xpath = "//div[h1[text() = 'Widget']]/ul[@class = 'boxed_style block']/li")
	List<WebElement> Widget;
	@FindBy(xpath = "//div[h1[text() = 'Frames and Windows']]/ul[@class = 'boxed_style block']/li")
	List<WebElement> Frames_and_Windows;
	@FindBy(xpath = "//div[h1[text() = 'Dynamic Elements']]/ul[@class = 'boxed_style block']/li")
	List<WebElement> Dynamic_Elements;
	@FindBy(xpath = "//div[h1[text() = 'Registration']]/ul[@class = 'boxed_style block']/li")
	List<WebElement> Registration;
	@FindBy(xpath = "//div[h1[text() = 'Alert']]/ul[@class = 'boxed_style block']/li")
	List<WebElement> Alert;


	public Mainmenu(WebDriver driver)
	{
		this.driver= driver;	
	PageFactory.initElements(driver, this);
	}

	public void clickInteractionmenu(String option)
	{
		Helper.clickListElements(Interactionmenu, option);		
	}

    public void clickWidgetmenu(String option)
    {
    	Helper.clickListElements(Widget, option); 
    }
	public void clickFrames_and_Windowsmenu(String option)
	{
		Helper.clickListElements(Frames_and_Windows, option);
	}
	public void clickDynamic_Elementsmenu(String option)
	{
			
		Helper.clickListElements(Dynamic_Elements, option);
	}
	public void clickRegistrationmenu(String option)
	{ 
		Helper.clickListElements(Registration, option);
	}
	public void clickAlertmenu(String option)
	{
	
		Helper.clickListElements(Alert, option);
	}
}
