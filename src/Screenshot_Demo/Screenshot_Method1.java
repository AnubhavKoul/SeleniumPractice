package Screenshot_Demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtilsCopyToFileTestCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot_Method1 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Add the url you want to navigate
		driver.get("https://www.anubhavkoul.com/");
		driver.manage().window().maximize();
		
		//New implicitly wait syntax, long,timeunits is depricated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		
		//TakesScreenshot - Interface.Code to take screenshot and in next line to copy that screenshot as a file at the destination.
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/FirstBasicCapture.png"));

		driver.close();
	}

}
