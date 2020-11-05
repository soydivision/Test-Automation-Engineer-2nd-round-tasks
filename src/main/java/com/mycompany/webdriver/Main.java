package com.mycompany.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
//        driver.get("https://pastebin.com/");
//        driver.manage().window().maximize();
//        driver.findElement(By.xpath("//*[@id=\"postform-text\"]")).sendKeys("Hello from WD");
//        driver.findElement(By.xpath("//*[@id=\"postform-name\"]")).sendKeys("helloweb");
//        WebElement element = driver.findElement(By.id("postform-expiration"));
//        Select select = new Select(element);
//        List<WebElement> list = select.getOptions();
//        for (WebElement webElement : list) {
//            String innerText = webElement.getAttribute("innerText");
//            System.out.println(innerText);
//            if (innerText.equals("10 Minutes")) {
//                element.click();
//            }
//        }
//        driver.quit();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        IndexPage page = new IndexPage();
        page.indexPage(driver);
        page.openIndexPage();
        page.pasteBin("dsjfklsdjf");
        page.pasteBinName("benny   hill");
    }
}
