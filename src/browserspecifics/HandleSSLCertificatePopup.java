package browserspecifics;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSLCertificatePopup {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Git_Repo\\Dependent_jars\\chromedriver.exe");
		
		//ChromeOptions is set to accept insecure certificates. Hence, SSL issue will not be encountered.
		
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);
		
		ChromeDriver driver = new ChromeDriver(co);
		
		// Add the url for website with ssl certificate issue.
		driver.get("https://wrong.host.badssl.com/");
		driver.manage().window().maximize();
		
		//New implicitly wait syntax, long,timeunits is depricated
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.close();

	}

}
