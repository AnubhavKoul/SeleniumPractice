package browserspecifics;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BlockBrowserPopups {
// Block the pop ups that comes up while navigating to some websites for location stating to allow the location settings
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		ChromeDriver driver = new ChromeDriver(co);

		// Add the url for website with the browser location pop ups.
		driver.get("https://wrong.host.badssl.com/");
		driver.manage().window().maximize();

		// New implicitly wait syntax, long,timeunits is depricated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
