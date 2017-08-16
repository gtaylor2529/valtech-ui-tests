package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objects.CorePage;
import page_objects.GenericPage;
import page_objects.HomePage;

public class GenericStepDefs {

    @When("^I go to (.*)$")
    public void iGoTo(String url) throws Throwable {
        CorePage corePage = new CorePage();
        corePage.navigateToUrl(url);
        HomePage homePage = new HomePage();
        homePage.assertHomePageIsDisplayed();
    }

    @Then("^the (.*) header is displayed$")
    public void thePageNameHeaderIsDisplayed(String pageName) throws Throwable {
        GenericPage genericPage = new GenericPage();
        genericPage.assertPageIsDisplayed(pageName);
    }

    @When("^I navigate to the (.*) page$")
    public void iNavigateToThePageNamePage(String pageName) throws Throwable {
        GenericPage genericPage = new GenericPage();
        genericPage.navigateToPage(pageName);
    }

    @When("^I open the contact page$")
    public void iOpenTheContactPage() throws Throwable {
        GenericPage genericPage = new GenericPage();
        genericPage.navigateToContactPage();
    }
}
