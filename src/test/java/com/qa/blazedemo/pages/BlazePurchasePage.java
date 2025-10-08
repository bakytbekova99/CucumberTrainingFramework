package com.qa.blazedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazePurchasePage {
    public BlazePurchasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//select[@name='fromPort']")
    WebElement departure;
    @FindBy(xpath = "//select[@name='toPort']")
    WebElement destination;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement findFlightsButton;
    @FindBy(tagName = "h3")
    WebElement header;
    @FindBy(xpath = "//input[@type='submit']")
    List<WebElement> choosingFlightsButton;
    @FindBy(css = "#inputName")
    WebElement name;
    @FindBy(css = "#address")
    WebElement address;
    @FindBy(css = "#city")
    WebElement city;
    @FindBy(css = "#state")
    WebElement state;
    @FindBy(css = "#zipCode")
    WebElement zipcode;
    @FindBy(css = "#cardType")
    WebElement cardType;
    @FindBy(css = "#creditCardNumber")
    WebElement cardNumber;
    @FindBy(css = "#creditCardMonth")
    WebElement creditCardMonth;
    @FindBy(css = "#creditCardYear")
    WebElement creditCardYear;
    @FindBy(css = "#nameOnCard")
    WebElement nameOnCard;
    @FindBy(css = "#rememberMe")
    WebElement rememberMeButton;
    @FindBy(xpath = "//input[@value='Purchase Flight']")
    WebElement purchaseFlightButton;
    @FindBy(xpath = "//h1[.='Thank you for your purchase today!']")
    WebElement thankYouMessage;



    public void choosingDepartureFlight(String departure){
        BrowserUtils.selectBy(this.departure, departure, "text");
    }
    public void choosingDestinationAndClickingFindingFlight(String destination){
        BrowserUtils.selectBy(this.destination, destination, "text");
        findFlightsButton.click();
    }
    public void validateHeader(String expectedHeader){
        Assert.assertEquals(expectedHeader, header.getText());
    }
    public void choosingFlight(){
        choosingFlightsButton.get(0).click();
    }
    public void userInfoInput(String name, String address, String city, String state, String zipcode){
        this.name.sendKeys(name);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipcode.sendKeys(zipcode);
    }
    public void cardInfoInput(String cardType, String cardNumber, String month, String year, String nameOnCard){
        BrowserUtils.selectBy(this.cardType, cardType, "text");
        this.cardNumber.sendKeys(cardNumber);
        this.creditCardMonth.sendKeys(month);
        this.creditCardYear.sendKeys(year);
        this.nameOnCard.sendKeys(nameOnCard);

    }
    public void clickingRememberMeAndPurchaseFlight(){
        rememberMeButton.click();
        purchaseFlightButton.click();
    }
    public void validateFinalMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage, thankYouMessage.getText());
    }
}
