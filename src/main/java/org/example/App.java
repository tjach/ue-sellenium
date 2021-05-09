package org.example;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{

    private static WebDriver driver;
    private static WebDriverWait wait;

public static void init_htmlUnitDriver() {
    final BrowserVersion myChrome = new BrowserVersion.BrowserVersionBuilder(BrowserVersion.CHROME)
            .setUserAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
            .build();

    driver = new HtmlUnitDriver(myChrome) {
        @Override
        protected WebClient modifyWebClient(WebClient client) {
            final WebClient webClient = super.modifyWebClient(client);
            // you might customize the client here
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setDownloadImages(false);
            webClient.getOptions().setAppletEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            return webClient;
        }
    };
    wait = new WebDriverWait(driver, 5);
}

public static void init_Firefox() {
        System.setProperty("webdriver.gecko.driver","C:/geckodriver-v0.29.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public static void main( String[] args ) throws InterruptedException {
//        init_Firefox();
        init_htmlUnitDriver();
        String url = "https://www.ue.katowice.pl/uczelnia/aktualnosci/article/tydzien-otwarty-uniwersytetu-ekonomicznego-w-katowicach-relacja.html";
        driver.get(url);
        WebElement e = driver.findElement(By.xpath("//*[@id=\"c9522\"]/div/h1"));
        System.out.println(e.getText());
//
        WebElement heading = driver.findElement(By.className("csc-firstHeader"));
        System.out.println(heading.getText());
//
//        //Click
//        WebElement to_click = driver.findElement(By.linkText("Alfabetyczny spis jednostek"));
//        to_click.click();
//        Thread.sleep(10000);
//        driver.close();
//        System.exit(0);
    }
}
