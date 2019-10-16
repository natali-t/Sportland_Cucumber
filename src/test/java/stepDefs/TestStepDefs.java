package stepDefs;

import baseFunc.BaseFunc;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoesTest;

import java.io.IOException;

public class TestStepDefs {
    private BaseFunc baseFunc = new BaseFunc();
    private HomePage homePage;
    private ProductPage productPage;
    private ShoesTest shoesTest;

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

//    @Then("can select filters:")
//    public void select_filter(List<String> filterNames) {
//
//    }

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
