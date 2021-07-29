import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyTestDemo {
	
	static RemoteWebDriver driver;
	
	@Before
	public void setup() throws MalformedURLException{
		System.out.println("Running Test in docker Container <<Chrome>>");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
							cap.setPlatform(Platform.LINUX);
							cap.setVersion("");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/webdriver/chromedriver.exe");
		//driver = new ChromeDriver();
	}
	
//	@org.junit.Test
//	public void navigationTest() throws Exception{
//		//MyScreenRecorder.startRecording("navigationTest");
//		
//		driver.get("http://www.google.com");
//		driver.navigate().to("http://www.facebook.com");
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().back();
//		
//		//MyScreenRecorder.stopRecording();
//	}
	
	@org.junit.Test
	public void navigation_FeatureTest() throws Exception{
		//MyScreenRecorder.startRecording("navigation_FeatureTest");
		
		driver.get("http://www.amazon.com");
		driver.navigate().to("http://www.rediff.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();

		
		//MyScreenRecorder.stopRecording();
	}
	
	
	
	@After
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
