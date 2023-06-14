import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.By.xpath;

public class ThirdDemo {
    WebDriver driver = null;

        @DataProvider(name = "data-set")
        public static Object[][] DataSet() {
            Object[][] obj = {
                    {"Iswarya","iswaryagunupudi129@gmail.com","Renu@1234"},
                    {"Madhurya","madhuryagunuputi01@gmail.com","Ishu@1234"},
                    {"tanuja","tanujakondepati1@gmail.com","tanu@1234"},
                    {"rahul","rahulgunupudi00@gmail.com","rahu@1234"},

            };
            return obj;
        }

        @BeforeMethod
        public void setUp() throws InterruptedException
        {
            String url = "https://letcode.in/test";
            String chromeDriverPath = "C:\\software\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            driver.get(url);
            Thread.sleep(2000);
            String signUpUrl ="https://letcode.in/signup";
            driver.get(signUpUrl);
        }

        @AfterMethod
        public void tearDown() throws InterruptedException
        {
            Thread.sleep(2000);
            driver.quit();
            System.out.println("New Account Created");
        }

        @Test(dataProvider = "data-set")
        public void search(String username, String email, String password)
        {
            // WebDriver driver = null;
            driver.findElement(xpath("//*[@id=\"name\"]")).sendKeys(username);
            driver.findElement(xpath("//*[@id=\"email\"]")).sendKeys(email);
            driver.findElement(xpath("//*[@id=\"pass\"]")).sendKeys(password);
            String signUpButton = "/html/body/app-root/app-signup/div/div/div/div/form/div[5]/p/button";
            driver.findElement(By.xpath(signUpButton)).click();
        }
}
