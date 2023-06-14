package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver=null;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setSearchUname(String usernames) {
        String loc="//*[@id=\"user-name\"]";
        WebElement ele= this.driver.findElement(By.xpath(loc));
        //driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("usernames");
        ele.sendKeys(usernames);
    }


    public void setSearchPass(String passwords) {
        String loc="//*[@id=\"password\"]";
        WebElement ele= this.driver.findElement(By.xpath(loc));
        ele.sendKeys(passwords);
        // driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("passwords");

    }

    public void clickSearchText() {
        String loc="//*[@id=\"login-button\"]";
        WebElement ele= this.driver.findElement(By.xpath(loc));
        ele.click();

        // driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        // System.out.println("Computer created ");
    }

}
