package com.qa.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SmartBearOrderPage {
    public SmartBearOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipcode;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visa;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpess;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;
    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;
    @FindBy(xpath = "//a[.='Process']")
    WebElement processButton;
    @FindBy(tagName = "strong")
    WebElement message;

    public void fillingProductInfo(String product, String quantity){
        BrowserUtils.selectBy(this.product, product, "text");
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }
    public void fillingAddressInfo(String customerName, String street, String city, String zipcode){
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.zipcode.sendKeys(zipcode);
    }
    public void fillingPaymentInfo(String card, String cardNumber, String expireDate){
        if (card.equals("Visa")){
            visa.click();
        } else if (card.equals("MasterCard")){
            masterCard.click();
        } else {
            americanExpess.click();
        }

        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
    }
    public void clickingProcessButtonAndValidatingMessage(String expectedMessage){
        processButton.click();
        Assert.assertEquals(expectedMessage, message.getText());
    }

}
