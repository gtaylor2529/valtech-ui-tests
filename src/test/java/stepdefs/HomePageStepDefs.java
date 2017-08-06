package stepdefs;

import cucumber.api.java.en.Then;
import page_objects.HomePage;

public class HomePageStepDefs {

    @Then("^the (.*) section is displayed$")
    public void theSectionIsDisplayed(String sectionName) throws Throwable {
        HomePage homePage = new HomePage();
        homePage.assertSectionIsDisplayed(sectionName);
    }
}
