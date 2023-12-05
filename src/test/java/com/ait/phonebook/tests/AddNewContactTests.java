package com.ait.phonebook.tests;

import com.ait.phonebook.models.Contact;
import com.ait.phonebook.models.User;
import com.ait.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setMail("newmail@mail.com")
                .setPass("12345Qq!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addNewContactPositiveTest(Contact contact){
        app.getContact().clickOnAddLink();
        logger.info("Tests run with data " + contact.toString());
        app.getContact().fillContactForm(
                new Contact()
                        .setName("Karll")
                        .setLastName("Marcks")
                        .setPhone("0987654321")
                        .setMail("newem@mail.com")
                        .setAdress("Qwerty")
                        .setDesc("qazxswedc"));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreatedByText("Karll"));
    }



    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }



    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderPositiveTest(
            String Name, String LastName, String Phone, String Mail, String Adress, String Desc
    ){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact()
                        .setName(Name)
                        .setLastName(LastName)
                        .setPhone(Phone)
                        .setMail(Mail)
                        .setAdress(Adress)
                        .setDesc(Desc));
        app.getContact().clickOnSaveButton();
    }



    @Test(dataProvider = "addNewContactFromeCSV", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderCSVPositiveTest(Contact contact){
        logger.info("Tests run with data: " + contact.toString());

        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getPhone()));
    }
}