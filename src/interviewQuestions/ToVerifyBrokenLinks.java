package interviewQuestions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import graphql.Assert;

/*Currently the code will not work with this url properly. Replace the url and adjust the url finder code to run at your machine*/

public class ToVerifyBrokenLinks {

	public static void main(String[] args) throws Exception, Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");

		ChromeOptions co = new ChromeOptions();
		co.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

		WebDriver driver = new ChromeDriver(co);
		driver.manage().deleteAllCookies();
		
		// Add the url you want to navigate
		driver.get("https://demoqa.com/links");
		driver.manage().window().maximize();

		// get all the links in the div.
		WebElement parentBlock = driver.findElement(By.id("linkWrapper"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(parentBlock));

		List<WebElement> links = parentBlock.findElements(By.tagName("a"));

		for (WebElement w : links) {
			String url = w.getAttribute("href");
			System.out.println(url);

			// Using java classes, we will check the status codes of the links and verify if
			// the links are broken or not.
			// creating connection to the url
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			
			// using HEAD request method to call the links.
			con.setRequestMethod("HEAD");
			
			// hitting the url
			con.connect();
			
			// store the response code by hitting the method.
			int responseCode = con.getResponseCode();
			System.out.println(responseCode);
			if (responseCode > 400) {
				System.out.println("link is broken with code" + responseCode);
				Assert.assertTrue(false);
			}
		}
		driver.close();
	}

}
