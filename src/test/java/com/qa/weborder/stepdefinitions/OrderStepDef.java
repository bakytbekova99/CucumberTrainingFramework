package com.qa.weborder.stepdefinitions;

import com.qa.weborder.pages.WebOrderOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class OrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderOrderPage orderPage=new WebOrderOrderPage(driver);

    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() {
        orderPage.clickGroupOrderBoxAndNextButton();
    }
    @When("User sends the word {string} for note to the Invitees Section")
    public void user_sends_the_word_for_note_to_the_invitees_section(String word) {
        orderPage.providingInviteesWord(word);
    }
    @When("User sends e-mail address which are {string} and {string} to the invite list")
    public void user_sends_e_mail_address_which_are_and_to_the_invite_list(String firstEmail, String secondEmail) {
        orderPage.providingInviteListEmail(firstEmail,secondEmail);
    }
    @When("User chooses delivery address {string} and validates the address {string}")
    public void user_chooses_delivery_address_and_validates_the_address(String location, String address) {
        orderPage.chooseAndValidateDeliveryAddress(location,address);
    }
    @When("User clicks the create group order button")
    public void user_clicks_the_create_group_order_button() throws InterruptedException {
        orderPage.clickCreateGroupOrderButton();
    }
    @Then("User validates the header of the page {string}")
    public void user_validates_the_header_of_the_page(String expectedHeader) {
        orderPage.validateHeaderOfThePage(expectedHeader);
    }
    @Then("User validates the word {string} from description")
    public void user_validates_the_word_from_description(String word) {
        orderPage.validateWordFromDescription(word);
    }
}
