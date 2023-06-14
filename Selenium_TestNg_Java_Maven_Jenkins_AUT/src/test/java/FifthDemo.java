import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class FifthDemo {

        public static void main(String[] args) throws InterruptedException {
            String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
            String chromeDriverPath = "C:\\software\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            driver.get(url);

            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
           // driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys("2024-06-25");
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
           // Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();//admin
            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();//add

            driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]")).click();//1st drop

            //Thread.sleep(2000);

           // driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")).click();//1st drop

            //Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
            //dropdown.selectByVisibleText("Database Testing");

            //Jadine  Jackie


          //  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")).sendKeys("Jadine  Jackie");

            //div[@class='oxd-select-text-input' and @tabindex='0' and @data-v-67d2aedf='']
//*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]

            driver.findElement(By.xpath("//div[@class='oxd-select-text-input' and @tabindex='0' and text()='Enabled']")).click();


            Thread.sleep(2000);














            driver.quit();


        }
}

