package Screenshot_Demo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Screenshot_Method2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		// Add the url you want to navigate
		driver.get("https://www.anubhavkoul.com/");
		driver.manage().window().maximize();
		
		//New implicitly wait syntax, long,timeunits is depricated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		
		// no need to cast the drive when instead of webdriver you are creating the object for chrome driver.
		//screenshot capture and saving using file handler, 
		File src = driver.getScreenshotAs(OutputType.FILE);
		//FileHandler is a static class. Providing ./foldername - adds the screenshot in the same project where folder is present.
		FileHandler.copy(src, new File("./Screenshots/SecondCapture.png"));
		driver.close();
	}

}
