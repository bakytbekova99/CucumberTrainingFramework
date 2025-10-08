package com.qa.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderOrderPage {
    public WebOrderOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderBox;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#ConfirmAddressID")
    WebElement myLocation;

    @FindBy(css = "#addressPreview")
    WebElement address;

    @FindBy(css = "#InviteNote")
    WebElement inviteesNote;

    @FindBy(css = "#InviteList")
    WebElement inviteList;

    @FindBy(id = "createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//p[1]")
    WebElement description;

    public void clickGroupOrderBoxAndNextButton(){
        groupOrderBox.click();
        nextButton.click();
    }

    public void providingInviteesWord(String word){
        inviteesNote.sendKeys(word);
    }

    public void providingInviteListEmail(String firstEmail,String secondEmail){
        inviteList.sendKeys(firstEmail +" , " + secondEmail);
    }

    public void chooseAndValidateDeliveryAddress(String location,String expectedAddress){
        BrowserUtils.selectBy(myLocation,location,"text");
        Assert.assertTrue(address.getText().contains(expectedAddress));
    }

    public void clickCreateGroupOrderButton() throws InterruptedException {
        createGroupOrderButton.click();
        Thread.sleep(2000);
    }

    public void validateHeaderOfThePage(String expectedHeader){
        Assert.assertEquals(expectedHeader,header.getText());
    }

    public void validateWordFromDescription(String expectedWord){
        Assert.assertTrue(description.getText().contains(expectedWord));
    }
}
