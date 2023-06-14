import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FourthDemo {
        public static void main(String[] args) throws InterruptedException
        {
            String url = "https://computer-database.gatling.io/";
            String chromeDriverPath = "C:\\software\\chromedriver_win32\\chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            driver.get(url);



            String locator_update = "//a[@id='add']";     //xpath of that button
            WebElement eleAddComputerButton = driver.findElement(By.xpath(locator_update)); //finding that button
            eleAddComputerButton.click();

            driver.findElement(By.xpath("//input[@id='name']")).sendKeys("HP1000");
            driver.findElement(By.xpath("//input[@id='introduced']")).sendKeys("2023-10-02");
            driver.findElement(By.xpath("//input[@id='discontinued']")).sendKeys("2024-06-25");
            driver.findElement(By.xpath("//input[@value='Create this computer']")).click();
            Thread.sleep(5000);

            System.out.println("Computer created Succesfully ");

            driver.get("http://computer-database.gatling.io/computers/381");
            driver.findElement(By.xpath("//input[@value=\"Delete this computer\"]")).click();
            Thread.sleep(3000);
            System.out.println("Computer Deleted");
            driver.quit();
        }
}