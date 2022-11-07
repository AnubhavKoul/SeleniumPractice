package Screenshot_Demo;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotOfSpecificElement {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		// Add the url you want to navigate
		driver.get("https://www.anubhavkoul.com/");
		driver.manage().window().maximize();
		
		//New implicitly wait syntax, long,timeunits is depricated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000);
		
		WebElement nameTag = driver.findElement(By.xpath("//a[text()='Anubhav Koul']"));
		
		File src = nameTag.getScreenshotAs(OutputType.FILE);
		//FileHandler is a static class. Providing ./foldername - adds the screenshot in the same project where folder is present.
		FileHandler.copy(src, new File("./Screenshots/ElementCapture.png"));
		
		driver.close();

	}

}
