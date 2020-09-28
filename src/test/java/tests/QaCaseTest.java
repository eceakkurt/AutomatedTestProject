package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class QaCaseTest extends BaseTest {

    @Given("^Start Driver and Browser$")
    public void startDriverAndBrowser() {
        setup();
    }

    @And("^Navigate To Url$")
    public void navigateToUrl() {
        homePage.goToUrl();
    }

    @And("^Click Sign In$")
    public void clickSignIn() {
        homePage.clickSignIn();
    }

    @And("^Email Write$")
    public void emailWrite() {
        loginPage.writeEmail();
    }

    @And("^Click Create An Account$")
    public void clickCreateAnAccount() {
        loginPage.clickCreateAccount();
    }

    @And("^Fill Personal Information Form$")
    public void fillPersonalInformationForm() {
        registerPage.fillForm();
    }

    @And("^Click Register$")
    public void clickRegister() {
        registerPage.clickRegister();
    }

    @And("^Check Account$")
    public void checkAccount() {
        homePage.checkAccount();
    }

    @And("Click Dresses")
    public void clickDresses() {
        homePage.clickSummerDresses();
    }

    @And("Click Add To Cart")
    public void clickAddToCart() {
        homePage.addToCartDress(0, 700);
    }

    @And("Click Continue Shopping")
    public void clickContinueShopping() {
        homePage.clickContinueShopping();
    }

    @And("Search Text")
    public void searchText() {
        homePage.searchText();
    }

    @And("Add To Cart")
    public void addToCart() {
        homePage.addToCartDress(2, 500);
        homePage.clickContinueShopping();
    }

    @And("Click Cart Checkout")
    public void clickCartCheckout() {
        homePage.goCart();
    }

    @And("Check Cart")
    public void checkCart() {
        cartPage.checkProduct();
    }

    @And("Process Address")
    public void processAddress() {
        cartPage.address();
    }

    @And("Process Shipping")
    public void processShipping() {
        cartPage.shipping();
    }

    @And("Process Payment")
    public void processPayment() {
        cartPage.payment();
    }

    @And("Check Order")
    public void checkOrder() {
        cartPage.order();
    }

    @Then("Close Driver and Browser")
    public void closeDriverAndBrowser() {
        teardown();
    }
}
