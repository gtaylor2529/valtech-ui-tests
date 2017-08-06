package stepdefs;

import cucumber.api.java.en.Then;
import page_objects.ContactPage;

public class ContactPageStepDef {

    @Then("^all of the Valtech offices will be displayed$")
    public void allOfTheValtechOfficesWillBeDisplayed() throws Throwable {
        ContactPage contactPage = new ContactPage();
        contactPage.verifyAmountOfValtechOffices();
    }
}
