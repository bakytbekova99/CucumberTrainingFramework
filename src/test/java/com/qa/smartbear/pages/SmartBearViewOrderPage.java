package com.qa.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearViewOrderPage {
    public SmartBearViewOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]")
    WebElement name;
    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[3]")
    WebElement product;

    public void validateNameAndProduct(String name, String product){
        Assert.assertEquals(name, this.name.getText());
        Assert.assertEquals(product, this.product.getText());
    }

}
