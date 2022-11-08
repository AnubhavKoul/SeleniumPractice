package browserspecifics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookiesBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.anubhavkoul.com");
		driver.manage().window().maximize();
		
		/*Deleting cookies*/
		driver.manage().deleteAllCookies();
		/*Delete specific cooki
		driver.manage().deleteCookieNamed("cookiename");
		*/
		/*Even you can add a cookie, parameter accepts cookie object
		 * driver.manage().addCookie(null);
		 * */
		driver.manage().addCookie(null);
		
	}

}
