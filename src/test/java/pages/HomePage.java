package pages;

import baseFunc.BaseFunc;
import org.openqa.selenium.By;


public class HomePage {
    private BaseFunc baseFunc;
    private final By MENU = By.xpath(".//button[@class='menu-trigger js-toggle-menu']");
    private final By PRODUCTS = By.xpath(".//li[@id='menu-item-2329']/a");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }
    public void clickMenu() {
        baseFunc.getElement(MENU).click();
    }
    public void clickProducts() {
        baseFunc.getElement(PRODUCTS).click();
    }
}
