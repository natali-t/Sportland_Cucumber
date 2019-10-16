package pages;

import baseFunc.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.lang.ref.PhantomReference;


public class HomePage {
    private BaseFunc baseFunc;
    private final By MENU = By.xpath(".//button[@class='menu-trigger js-toggle-menu']");
    private final By PRODUCTS = By.xpath(".//li[@id='menu-item-2329']/a");
    private final By FOOTER = By.xpath(".//nav[@class='footer-nav']");
    private final By SOCIAL_NETW_ICONS = By.xpath(".//ul[@class='header-social header-social--collapsed']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assertions.assertFalse(baseFunc.isElementPresent(FOOTER), "Footer is not present");
        Assertions.assertFalse(baseFunc.isElementPresent(SOCIAL_NETW_ICONS), "Social network icons are not presented");
    }
    public void clickMenu() {
        baseFunc.getElement(MENU).click();
    }
    public void clickProducts() {
        baseFunc.getElement(PRODUCTS).click();
    }
}
