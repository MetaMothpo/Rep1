package CreateTestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class baseClass
{


    public WebDriver driver = null;
    public static  String Url = null;
   public static  String BrowserName = null;
    readProperties readfile = new readProperties();

    @BeforeTest
    void setUp()
    {
        readfile.getProperties();
        if(BrowserName.equalsIgnoreCase("chrome"))
        {

            driver = new ChromeDriver();
            WebDriverManager.chromedriver().driverVersion("108.0.5359.72").setup();
            driver.get(Url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        }
        else if (BrowserName.equalsIgnoreCase("firefox"))
        {driver = new FirefoxDriver();
            WebDriverManager.firefoxdriver().driverVersion("108.0.5359.72").setup();
            driver.get(Url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

        }



    }


}
