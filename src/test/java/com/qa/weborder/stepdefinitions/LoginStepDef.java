package com.qa.weborder.stepdefinitions;

import com.qa.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);

    @When("User provides email {string}, password {string} and Click Login Button")
    public void user_provides_email_password_and_click_login_button(String email, String password) throws InterruptedException {
        loginPage.login(email,password);
    }

    @Then("User validates title {string}")
    public void user_validates_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @Then("User validates the message {string} and background-color {string}")
    public void user_validates_the_message_and_background_color(String expectedMessage, String expectedColor) {
        loginPage.errorMessageAndColor(expectedMessage,expectedColor);
    }
}
