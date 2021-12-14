import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/V4/");

    }

    @Test
    public void TC_01() {
        driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr368139");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Yjamujy");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//marquee")).getText(), "Welcome To Manager's Page of Guru99 Bank");
    }

    @AfterTest
    public void TeaDown() {
        driver.quit();

    }

}
