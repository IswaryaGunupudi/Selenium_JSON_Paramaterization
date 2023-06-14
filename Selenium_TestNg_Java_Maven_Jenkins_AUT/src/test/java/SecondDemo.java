//Program to run a single testcase from a group of testcases using JSON

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Selenium.HomePage;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SecondDemo {

    WebDriver driver=null;

    @BeforeMethod
    public void setUp() throws IOException, ParseException {
        // String url = "https://computer-database.gatling.io/";
        String chromeDriverPath = "C:\\software\\chromedriver_win32\\chromedriver.exe";
        String loginDataPath = "src/main/resources/UrlLink.json";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        FileReader fr = new FileReader(loginDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        String url = (String) jsonObject.get("url");
        System.out.println(url);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchUsernamePassword() throws InterruptedException, IOException, ParseException {
        //try{
        String searchComputerDataPath = "src/main/resources/LogInData.json";
        FileReader fr = new FileReader(searchComputerDataPath);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject tc = (JSONObject) jsonObject.get("TestCase01");
        String username = (String) tc.get("username");
        String password = (String) tc.get("password");
        System.out.println(username);
        System.out.println(password);
        HomePage hp = new HomePage(driver);
        hp.setSearchUname(username);
        hp.setSearchPass(password);
        hp.clickSearchText();
        Thread.sleep(5000);

    }

}


