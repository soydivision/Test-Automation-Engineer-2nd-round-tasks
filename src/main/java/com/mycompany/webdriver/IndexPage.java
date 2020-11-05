package com.mycompany.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexPage {
    //    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        driver.get("https://pastebin.com/");
//    }
    private WebDriver driver;

    public void indexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openIndexPage() {
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");
    }

    public void pasteBin(String pasteBin) {
        driver.findElement(By.xpath("//*[@id=\"postform-text\"]")).sendKeys(pasteBin);
    }

    public void pasteBinName(String name) {
        driver.findElement(By.xpath("//*[@id=\"postform-name\"]")).sendKeys(name);
    }
//    public void pasteBinName(String name) {
//        driver.findElement(By.xpath("//*[@id=\"postform-name\"]")).sendKeys(name);
//    }

    public void setExpiration(String expiration) {
        WebElement element = driver.findElement(By.id("postform-expiration"));
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        for (WebElement webElement : list) {
            String innerText = webElement.getAttribute("innerText");
            System.out.println(innerText);
            if (innerText.equals(expiration)) {
                System.out.println(innerText.equals(expiration));
                element.click();
            }
        }
    }

    public void setSyntaxHiglighting(String pasteBin) {
    }
}
