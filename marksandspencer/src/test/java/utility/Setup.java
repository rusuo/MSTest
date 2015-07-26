package utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
	public static WebDriver driver;

	public static void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	 }
	
	public static void goToHomePage(){
		driver.get(Config.URL);
	}

	 public static void tearDown() {
		 driver.quit();
	 }

}
