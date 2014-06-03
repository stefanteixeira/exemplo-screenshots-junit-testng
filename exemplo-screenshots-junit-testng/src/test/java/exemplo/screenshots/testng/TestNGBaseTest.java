package exemplo.screenshots.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public abstract class TestNGBaseTest
{
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp()
	{
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterClass
	public static void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}
