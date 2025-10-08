package com.qa.blazedemo.stepdefinitions;

import com.qa.blazedemo.pages.BlazePurchasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class PurchaseStepDef {
    WebDriver driver = DriverHelper.getDriver();
    BlazePurchasePage blazePurchasePage = new BlazePurchasePage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
        driver.get(url);
    }
    @When("User chooses {string} for departure")
    public void user_chooses_for_departure(String departure) {
        blazePurchasePage.choosingDepartureFlight(departure);
    }
    @When("User chooses {string} for destination and clicks Finding Flight button")
    public void user_chooses_for_destination_and_clicks_finding_flight_button(String destination) {
        blazePurchasePage.choosingDestinationAndClickingFindingFlight(destination);
    }
    @Then("User validates the header {string}")
    public void user_validates_the_header(String expectedHeader) {
        blazePurchasePage.validateHeader(expectedHeader);
    }
    @When("User chooses the first flight")
    public void user_chooses_the_first_flight() {
        blazePurchasePage.choosingFlight();
    }
    @When("User provides contact information {string}, {string}, {string}, {string}, {string}")
    public void user_provides_contact_information(String name, String address, String city, String state, String zipcode) {
        blazePurchasePage.userInfoInput(name, address, city, state, zipcode);
    }
    @When("User provides payment information {string}, {string}, {string}, {string}, {string}")
    public void user_provides_payment_information(String cardType, String cardNumber, String month, String year, String nameOnCard) {
        blazePurchasePage.cardInfoInput(cardType, cardNumber, month, year, nameOnCard);
    }
    @When("User selects the Remember Me button and clicks Purchase Flight Button")
    public void user_selectsthe_remember_me_button_and_clicks_purchase_flight_button() {
        blazePurchasePage.clickingRememberMeAndPurchaseFlight();
    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
        blazePurchasePage.validateFinalMessage(expectedMessage);
    }
}
