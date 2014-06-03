package exemplo.screenshots.junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class JUnitBaseTest
{
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@Rule
	public ScreenshotRule screenshotRule = new ScreenshotRule();
	
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
