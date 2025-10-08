package com.qa.smartbear.stepdefinitions;

import com.qa.smartbear.pages.SmartBearLoginPage;
import com.qa.smartbear.pages.SmartBearMainPage;
import com.qa.smartbear.pages.SmartBearOrderPage;
import com.qa.smartbear.pages.SmartBearViewOrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearOrderCreationStepDef {
    WebDriver driver = DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage = new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage(driver);
    SmartBearViewOrderPage smartBearViewOrderPage = new SmartBearViewOrderPage(driver);

    @Given("User provides username {string} and password {string} and click Login Button")
    public void user_provides_username_and_password_and_click_login_button(String username, String password) throws InterruptedException {
        smartBearLoginPage.login(username, password);
    }
    @When("User clicks Order Button")
    public void user_clicks_order_button() {
        smartBearMainPage.clickingOrderButton();
    }
    @When("User provides {string} and {string} for the Product Information")
    public void user_provides_and_for_the_product_information(String product, String quantity) {
        smartBearOrderPage.fillingProductInfo(product, quantity);
    }
    @When("User provides {string}, {string}, {string}, {string} for the Address Information")
    public void user_provides_for_the_address_information(String customerName, String street, String city, String zipcode) {
        smartBearOrderPage.fillingAddressInfo(customerName, street, city, zipcode);
    }
    @When("User provides {string}, {string}, {string} for the Payment Information")
    public void user_provides_for_the_payment_information(String card, String cardNumber, String expireDate) {
        smartBearOrderPage.fillingPaymentInfo(card, cardNumber, expireDate);
    }
    @Then("User clicks process button and validates {string}")
    public void user_clicks_process_button_and_validates(String expectedMessage) {
        smartBearOrderPage.clickingProcessButtonAndValidatingMessage(expectedMessage);
    }
    @Then("User clicks view all orders button and validates {string}, {string} from the list")
    public void user_clicks_view_all_orders_button_and_validates_from_the_list(String name, String product) {
        smartBearMainPage.clickingViewAllOrdersButton();
        smartBearViewOrderPage.validateNameAndProduct(name, product);
    }

    @Given("User provides username and password and click Login Button")
    public void user_provides_username_and_password_and_click_login_button(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        Map<String, String> loginInformation = dataTable.asMap();
        smartBearLoginPage.login(loginInformation.get("username"),loginInformation.get("password"));

    }
    @When("User provides and quantity for the Product Information")
    public void user_provides_and_quantity_for_the_product_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String > productInformation = dataTable.asMap();
        smartBearOrderPage.fillingProductInfo(productInformation.get("product"), productInformation.get("quantity"));
    }
    @When("User provides customerName, street, state, zipcode for the Address Information")
    public void user_provides_customer_name_street_state_zipcode_for_the_address_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> customerInformation = dataTable.asMap();
        smartBearOrderPage.fillingAddressInfo(customerInformation.get("customerName"),
                customerInformation.get("street"),
                customerInformation.get("state"),
                customerInformation.get("zipcode"));
    }
    @When("User provides card, cardNumber, expireDate for the Payment Information")
    public void user_provides_card_card_number_expire_date_for_the_payment_information(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> paymentInformation = dataTable.asMap();
        smartBearOrderPage.fillingPaymentInfo(paymentInformation.get("card"),
                paymentInformation.get("cardNumber"),
                paymentInformation.get("expireDate"));
    }
    @Then("User clicks process button and validates message")
    public void user_clicks_process_button_and_validates_message(io.cucumber.datatable.DataTable dataTable) {
        List<String> message = dataTable.asList();
        smartBearOrderPage.clickingProcessButtonAndValidatingMessage(message.get(0));
    }
    @Then("User clicks view all orders button and validates customerName, product from the list")
    public void user_clicks_view_all_orders_button_and_validates_customer_name_product_from_the_list(io.cucumber.datatable.DataTable dataTable) {
       smartBearMainPage.clickingViewAllOrdersButton();
        Map<String, String> viewAllOrders = dataTable.asMap();
        smartBearViewOrderPage.validateNameAndProduct(viewAllOrders.get("customerName"),
                viewAllOrders.get("product"));
    }

}
