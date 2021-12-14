import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:/SelfStudy/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.lazada.vn/");

    }

    @Test
    public void searchIphone13() {
        WebElement search = driver.findElement(By.id("q"));
        search.sendKeys("iphone 13 pro max");
        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'SEARCH')]"));
        searchBtn.click();
        WebElement result = driver.findElement(By.xpath("//a[contains(text(), 'Điện thoại Apple iPhone 13 Pro Max 256GB')]"));
        Assert.assertEquals("Điện thoại Apple iPhone 13 Pro Max 256GB (VN/A) - Hàng chính hãng - Màn hình cực lớn, Camera ấn tượng, viên pin sử dụng cả ngày dài", result.getText());
    }

    @AfterTest
    public void teaDown() {
        driver.close();
        driver.quit();
    }

}
