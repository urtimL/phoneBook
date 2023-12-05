package com.ait.phonebook.tests;

import com.ait.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTest extends TestBase{

    //precondition: user shoud be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        };
    }

    @Test
    public void registerExistedUserTest() {

        app.getUser().clickOnLoginLink();

        app.getUser().fillLoginRegisterForm(new User()
                .setMail("newMail@mail.com")
                .setPass("12345Qq!"));

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
