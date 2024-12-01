package myProgramm.selenium;

import constant.buttons.IButtonLinks;
import constant.links.ILink;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium {
    public static void seleniumBasic(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ILink.tennisLink);
        try {
            cookie(driver);
        }catch (NoSuchElementException e){
            cookie(driver);
        }
    }

    private static void cookie(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(IButtonLinks.cookieButton)));
        cookieButton.click();
    }
}
