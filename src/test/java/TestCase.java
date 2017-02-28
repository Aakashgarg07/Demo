package test.java;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import main.java.com.way2automation.config.TestConfig;
import main.java.com.way2automation.ui.Accordion;


public class TestCase extends TestConfig {
	@Test
	public void test() throws InterruptedException, ParseException, IOException
	{ 
		LocalDateTime ldt= LocalDateTime.now();
		String ld = ldt.toString().replace(":","_");

		 WebDriver driver = TestConfig.driver;;
		Accordion ac = new Accordion(driver);
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		File srcimg = edriver.getScreenshotAs(OutputType.FILE);
		File tarimg= new File("./screenshot/"+ld + " moki.png");
		FileUtils.copyFile(srcimg, tarimg);
		ac.customizeIcons(1, 1);
		ac.defaultFunctionality(2);
		ac.fillSpace(3);
		
	
				}
}