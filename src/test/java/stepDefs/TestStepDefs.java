package stepDefs;

import baseFunc.BaseFunc;
//import baseFunc.Helpers;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;
import pages.ShoesTest;
import cucumber.api.java.en.*;

public class TestStepDefs {
    private BaseFunc baseFunc= new BaseFunc();
    private HomePage homePage;
    private ProductPage productPage;
    private ShoesTest shoesTest;
    private final String url = "sportland.lv";

    @Given("open {string} home page")
    public void open_home_page(String url) {
        baseFunc.openPage("url");
        homePage = new HomePage(baseFunc);
    }







    }
