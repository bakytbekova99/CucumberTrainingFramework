package com.qa.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderLoginPage {
    public WebOrderLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy(xpath = "//div[contains(text(),'Sign in Failed')]")
    WebElement message;

    public void login(String email,String password) throws InterruptedException {
        this.email.clear();
        this.email.sendKeys(email);
        this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();
        Thread.sleep(5000);
    }

    public void errorMessageAndColor(String expectedMessage,String expectedColor){
        Assert.assertEquals(expectedMessage,message.getText());
        Assert.assertEquals(expectedColor,message.getCssValue("background-color"));
    }
}
