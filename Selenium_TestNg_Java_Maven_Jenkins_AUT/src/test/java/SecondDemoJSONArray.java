// Program to run multiple testcases at  a time using JSON Array

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SecondDemoJSONArray {
        WebDriver driver;

        @BeforeClass
        void setup() {
            // WebDriverManager.chromedriver().setup();
            System.setProperty("webdriver.chrome.driver", "C:\\software\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            //driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        @AfterClass
        void tearDown() {

            driver.close();
        }

        @Test(dataProvider="login")
        void login(String data) throws InterruptedException {
            String users[] = data.split(",");
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(users[0]);
            driver.findElement(By.id("password")).sendKeys(users[1]);
            //Assert.assertTrue(driver.findElement(By.id("login-button").isSelected());
            driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
            //#login-button
            Thread.sleep(10000);

        }

        @DataProvider(name= "login")
        public String[] readJson() throws IOException, ParseException
        {
            JSONParser json=new JSONParser();
            FileReader reader =new FileReader("src/main/resources/LoginTestCases.json");
            Object obj= json.parse(reader);
            JSONObject userloginsJsonobj=(JSONObject) obj;
            JSONArray userloginsArray=(JSONArray) userloginsJsonobj.get("userlogins");

            String arr[]=new String[userloginsArray.size()];

            for(int i=0;i<userloginsArray.size();i++)
            {
                JSONObject users = (JSONObject) userloginsArray.get(i);
                String usernames = (String) users.get("username");
                String pwd= (String) users.get("password");
                arr[i]=usernames+","+pwd;

            }
            return arr;
        }
}
