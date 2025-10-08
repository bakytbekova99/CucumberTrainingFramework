package com.qa.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearMainPage {
    public SmartBearMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='Order']")
    WebElement orderButton;
    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrdersButton;
    @FindBy(xpath = "//a[.='View all products']")
    WebElement viewAllProductsButton;

    public void clickingOrderButton(){
        orderButton.click();
    }
    public void clickingViewAllOrdersButton(){
        viewAllOrdersButton.click();
    }
}
