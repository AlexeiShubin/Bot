package myProgramm.selenium;

import constant.buttons.IButtonLinks;
import constant.links.ILink;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium {
    public static void seleniumBasic(){
        WebDriver driver = null;

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("ChromeDriver запущен.");
        } catch (Exception e) {
            System.out.println("Ошибка запуска ChromeDriver: " + e.getMessage());
            try {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("FirefoxDriver запущен.");
            } catch (Exception ex) {
                System.out.println("Ошибка запуска FirefoxDriver: " + ex.getMessage());
            }
        }
        if (driver != null) {
            driver.manage().window().maximize();
            driver.get(ILink.tennisLink);
            try {
                cookie(driver);
            } catch (NoSuchElementException e) {
                cookie(driver);
            }
        } else {
            System.out.println("Не удалось запустить ни один драйвер.");
        }
    }

    private static void cookie(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(IButtonLinks.cookieButton)));
        cookieButton.click();
    }
}
