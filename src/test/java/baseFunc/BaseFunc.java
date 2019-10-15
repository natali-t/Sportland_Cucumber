package baseFunc;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.HashMap;
import java.util.List;

public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private FileWriter writer;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "/Users/natali/Development/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(driver.findElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public List<WebElement> getAllElements(By locator) {
        Assertions.assertFalse(driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public boolean isElementPresent(By locator) {
        return getAllElements(locator).isEmpty();
    }

//    public void stupidTimeout(){
//        for (int x = 0; x< 100000; x++){
//            int y = 5;
//            y++;
//        }
//    }

    public void waitForElements(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitOnJavascript() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String javaScript = "(function watcher(ms){var start=new Date().getTime();var end = start;while(end<start+ms){end=new Date().getTime();};return 'complete';})(5000);return 'success';";
        wait.until(ExpectedConditions.jsReturnsValue(javaScript));
    }

    public void waitLoad() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements());
    }

    public void verifyBrandName(By locator, String brandname) {
        List<WebElement> brandList = getAllElements(locator);
        for (int i = 0; i < brandList.size(); i++) {
//            System.out.println(i);
//            System.out.println(brandname);
//            System.out.println(brandList.get(i).getText());
            Assertions.assertTrue(brandList.get(i).getText().contains(brandname), "Brandname does not match");
        }
    }

    public void verifySaleProducts(By locator) {
        List<WebElement> salesProdList = getAllElements(locator);
        for (int i = 0; i < salesProdList.size(); i++) {
//            System.out.println(i);
//            System.out.println(salesProdList.get(i).getText());
            Assertions.assertTrue(salesProdList.get(i).getText().contains("%"), "Product is not on sale");
        }
    }

    public void listToFile(String name, List<String> list) throws IOException {
        writer = new FileWriter(name + ".txt");
        for (String str : list) {
            writer.write(str + System.getProperty("line.separator"));
        }
        writer.close();
    }

    public void arrayToJsonFile(String name, HashMap<String, List<String>> articles) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        writer = new FileWriter(name + ".json");
        writer.write(mapper.writeValueAsString(articles));
        writer.close();
    }

    public void quit() {
        driver.quit();
    }
}
