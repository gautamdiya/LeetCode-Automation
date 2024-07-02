package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("leetcode")) {
            System.out.println("URL contains leetcode");
        } else {
            System.out.println("Url is incorrect" + currentUrl);
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");
        WebElement questionLink = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questionLink.click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("problemset")) {
            System.out.println("URL contains problemset");
        } else {
            System.out.println("Url is incorrect" + currentUrl);
        }
        Thread.sleep(5000);
        List<WebElement> titleDetails = driver.findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
        for (int i = 1; i < 6; i++) {
            String title = titleDetails.get(i).getText();
            System.out.println("Title=" + title );
        }
        String firstQuestionTitle = titleDetails.get(1).getText();
            if(firstQuestionTitle.contains("Two Sum")){
                System.out.println("First problem is two sum");
            }else{
                System.out.println("first problem is not two sum");
            }
        System.out.println("end Test case: testCase02");
    }
    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");
        WebElement questionLink = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questionLink.click();
        Thread.sleep(2000);
        WebElement towsumLink = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        towsumLink.click();
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("two-sum")) {
            System.out.println("URL contains two sum");
        } else {
            System.out.println("Url is incorrect" + currentUrl);
        }
        System.out.println("end Test case: testCase03");
    }
    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");
        WebElement questionLink = driver.findElement(By.xpath("//p[text()='View Questions ']"));
        questionLink.click();
        Thread.sleep(2000);
        WebElement towsumLink = driver.findElement(By.xpath("//a[@href='/problems/two-sum']"));
        towsumLink.click();
        Thread.sleep(5000);
        WebElement submissionLink = driver.findElement(By.xpath("//div[@class='normal absolute left-0 top-0 whitespace-nowrap font-normal' and text()='Submissions']"));
        submissionLink.click();
        Thread.sleep(3000);
        WebElement regOrSignInButton=driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
        if (regOrSignInButton.getText().equals("Register or Sign In")) {
            System.out.println("Register or Sign In is displayed");
        } else {
            System.out.println("Register or Sign In is not displayed" );
        }
        System.out.println("end Test case: testCase04");
    }
}
