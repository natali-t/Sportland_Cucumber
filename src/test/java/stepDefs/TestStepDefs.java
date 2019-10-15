package stepDefs;

import baseFunc.BaseFunc;
//import baseFunc.Helpers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoesTest;
import cucumber.api.java.en.*;
import io.cucumber.core.cli.Main;

import java.io.IOException;
import java.util.List;

public class TestStepDefs {
    private BaseFunc baseFunc= new BaseFunc();
    private HomePage homePage;
    private ProductPage productPage;
    private ShoesTest shoesTest;
    private final String url = "sportland.lv";

    @Given("open {url} home page")
    public void open_home_page(String url) {
        baseFunc.openPage("url");
        homePage = new HomePage(baseFunc);
    }

    @When("we choose menu")
    public void clickMenu() {
        homePage.clickMenu();
    }

    @Then("we choose products")
    public void clickProducts() {
        homePage.clickProducts();
        productPage = new ProductPage(baseFunc);
    }

    @And("choose zeni and futbols")
    public void clickZeni() {
        productPage.clickZeniFutbols();
    }

    @And("sort by izpardosana")
    public void clickIzpardosana() {
        productPage.clickIzpardosana();
    }
//
//    @And("select filters:")
//    public void selectFilters() {
//        productPage.clickApaviIekstelpam();
//        productPage.clickAdidas();
//    }

    @And("select filters:")
    public void select_filter(List<String filterNames>) {

    }

    @Then("check sorted products have correct brand name")
    public void checkBrandname() {
        productPage.checkBrandName();
    }

    @And("check all sorted products are on sale")
    public void checkDiscount() {
        productPage.checkDiscount();
    }

    @Then("create and save text and json file with prod. <50EUR")
    public void priceList() throws IOException {
        productPage.priceList();
        baseFunc.quit();
    }













    }
