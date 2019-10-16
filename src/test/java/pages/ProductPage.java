package pages;

import baseFunc.BaseFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductPage {
    private BaseFunc baseFunc;
    private final By ZENI = By.xpath(".//li[@id='wp-megamenu-item-84252']");
    private final By APAVI_FUTBOLS = By.xpath(".//a[@href='/produkti/?sort=recent&gender=boys&category=football-footwear']");
    private final By IZPARDOSANA =  By.xpath(".//select//option[@value='offer']");
    private final By APAVI_IEKSTELPAM = By.xpath(".//li//label[contains(text(), 'Futbola apavi iekštelpām')]");
    private final By ADIDAS_CHB = By.xpath(".//label[@for='87'][contains(text(), 'adidas')]");
    private final By ADIDAS_NAME = By.xpath(".//p[@class='spodb-product-card__title']");
    private final By DISCOUNT = By.xpath(".//p[@class='spodb-product-card__percentage']/span[@data-v-ba7fc466]");
//    private final By DISCOUNTED_PRICE = By.xpath(".//p[@class='spodb-product-card__new-price']");
    private final By FULL_PROD_NAME = By.xpath(".//a[@class='spodb-product-card']");

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void clickZeniFutbols() {
        baseFunc.waitUntilVisible(ZENI);
        baseFunc.getElement(ZENI).click();
        baseFunc.waitUntilVisible(APAVI_FUTBOLS);
        baseFunc.getElement(APAVI_FUTBOLS).click();
    }

    public void clickIzpardosana() {
        baseFunc.getElement(IZPARDOSANA).click();
    }

    public void clickApaviIekstelpam() {
        baseFunc.waitUntilVisible(APAVI_IEKSTELPAM);
        baseFunc.getElement(APAVI_IEKSTELPAM).click();
    }

    public void clickAdidas() {
        baseFunc.getElement(ADIDAS_CHB).click();
        baseFunc.waitOnJavascript();
        baseFunc.waitUntilVisible(ADIDAS_NAME);
        baseFunc.isElementPresent(ADIDAS_NAME);
    }

    public void checkBrandName()  {
        baseFunc.isElementPresent(ADIDAS_NAME);
        baseFunc.waitUntilVisible(ADIDAS_NAME);
        baseFunc.verifyBrandName(ADIDAS_NAME, "ADIDAS");
    }

    public void checkDiscount() {
        baseFunc.isElementPresent(DISCOUNT);
        baseFunc.verifySaleProducts(DISCOUNT);
    }

        public void priceList() throws IOException {
//        List<WebElement> prices = baseFunc.getAllElements(DISCOUNTED_PRICE);
            List<WebElement> allSelectedProducts = baseFunc.getAllElements(FULL_PROD_NAME);
            List<String> under50list = new ArrayList<>();
            HashMap<String, List<String>> under50hashMap = new HashMap<>();
            for (int i = 0; i < allSelectedProducts.size(); i++) {
                String fullProductDetails = allSelectedProducts.get(i).getText();
                String priceText = fullProductDetails.substring(fullProductDetails.lastIndexOf("\n"));
                String itemName = fullProductDetails.substring(0, fullProductDetails.indexOf("\n"));
                String onlyPrice = priceText.substring(1, priceText.length() - 1);
                double price = Double.parseDouble(onlyPrice);
                if (price < 50) {
                    under50list.add(fullProductDetails);

                    ArrayList<String> jsonArrayList = new ArrayList<String>();
                    for(String item : fullProductDetails.split("\n")) {
                        jsonArrayList.add(item);
                    }
                    under50hashMap.put(itemName, jsonArrayList);
                }
            }
            baseFunc.listToFile("txt_output", under50list);
            baseFunc.arrayToJsonFile("json_output", under50hashMap);

            }
        }



