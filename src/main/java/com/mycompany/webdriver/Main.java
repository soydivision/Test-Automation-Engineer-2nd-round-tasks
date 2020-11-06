package com.mycompany.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
// paste bin
        WebElement pasteBin = driver.findElement(By.xpath("//*[@id=\"postform-text\"]"));
        pasteBin.sendKeys("Hello from WD");
//  click on expiration
        WebElement element = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[2]/div/span"));
        element.click();
// paste title
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"postform-name\"]"));
        titleElement.sendKeys("helloweb");
        Thread.sleep(2000);
        driver.quit();
    }
}
