package stepDefs;
import baseFunc.BaseFunc;
import baseFunc.Helpers;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.HomePage;
import pages.ProductPage;
import java.io.IOException;
import java.util.List;

public class TestStepDefs {
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private ProductPage productPage;
    private Helpers helpers;
    private final By FILTERS = By.xpath(".//div[@class='spodb-page-content__aside']/div/fieldset");

    @Given("open {string} home page")
    public void open_home_page(String url) {
        baseFunc.openPage(url);
        homePage = new HomePage(baseFunc);
    }

    @When("we choose menu")
    public void click_Menu() {
        homePage.clickMenu();
    }

    @Then("we can choose products")
    public void click_Products() {
        homePage.clickProducts();
        productPage = new ProductPage(baseFunc);
    }

    @Then("can choose zeni and futbols")
    public void click_Zeni() {
        productPage.clickZeniFutbols();
        Assertions.assertFalse(baseFunc.isElementPresent(FILTERS), "Filters are not present");
    }

    @Then("can sort by izpardosana")
    public void click_Izpardosana() {
        productPage.clickIzpardosana();
    }
//
//    @Then("can select filters:")
//    public void select_Filters() {
//        productPage.clickApaviIekstelpam();
//        productPage.clickAdidas();
//    }

    @Then("can select filters:")
    public void select_filter(List<String> filterNames) {
        helpers = new Helpers(baseFunc);
        helpers.selectFilters(filterNames);
    }

    @Then("can check sorted products have correct brand name")
    public void check_Brandname() {
        productPage.checkBrandName();
    }

    @Then("can check all sorted products are on sale")
    public void check_Discount() {
        productPage.checkDiscount();
    }

    @Then("can create and save text and json file with prod. <50EUR")
    public void priceL_ist() throws IOException {
        productPage.priceList();
        baseFunc.quit();
    }
}
