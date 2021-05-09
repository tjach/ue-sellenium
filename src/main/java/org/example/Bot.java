package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bot {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void init_Firefox() {
        System.setProperty("webdriver.gecko.driver","C:/geckodriver-v0.29.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }


    public static void main(String[] args) throws InterruptedException {
        init_Firefox();
        String url="https://www.surveylab.com/lng/pl/pageTag/SurveyCampaign/cId/7fc0e81a2d3f925a4932e4674a4f68d7383657d7/";
        driver.get(url);
        //click on start
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div/main/nav/div/button/span[1]")));
        WebElement start_button = driver.findElement(By.xpath("/html/body/div/div/div/div/main/nav/div/button/span[1]"));
        Thread.sleep(1000);
        start_button.click();
        //Answer question 1
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sl-questions\"]/div[2]/div/div/div[3]/div/div/label[1]/span[2]")));
        Thread.sleep(1000);
        WebElement day1 = driver.findElement(By.xpath("//*[@id=\"sl-questions\"]/div[2]/div/div/div[3]/div/div/label[1]/span[2]"));
        day1.click();
        //Answer question 2
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sl-questions\"]/div[3]/div/div/div[3]/div/div/label[3]/span[2]")));
        Thread.sleep(1000);
        WebElement indian_cousine = driver.findElement(By.xpath("//*[@id=\"sl-questions\"]/div[3]/div/div/div[3]/div/div/label[3]/span[2]"));
        indian_cousine.click();
        //Answer question 3
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"sl-questions\"]/div[4]/div/div/div[3]/div/div/div/textarea")));
        Thread.sleep(1000);
        WebElement remarks = driver.findElement(By.xpath("//*[@id=\"sl-questions\"]/div[4]/div/div/div[3]/div/div/div/textarea"));
        remarks.sendKeys("Brak uwag");
        //Send form
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"sl-navigation\"]/div[2]/button/span[1]")));
        Thread.sleep(1000);
        WebElement sent = driver.findElement(By.xpath("//*[@id=\"sl-navigation\"]/div[2]/button/span[1]"));
        sent.click();
    }
}
