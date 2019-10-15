package pages;

import baseFunc.BaseFunc;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class ShoesTest {
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private ProductPage productPage;
    private String url = "sportland.lv";

    @Test
    public void checkShoesTest() throws InterruptedException, IOException {
        baseFunc.openPage(url);
        homePage = new HomePage(baseFunc);
        homePage.clickMenu();
        homePage.clickProducts();
        productPage = new ProductPage(baseFunc);
        productPage.clickZeniFutbols();
        productPage.clickIzpardosana();
        productPage.clickApaviIekstelpam();
        productPage.clickAdidas();
        productPage.checkBrandName();
        productPage.checkDiscount();
        productPage.priceList();
        baseFunc.quit();
    }
}
