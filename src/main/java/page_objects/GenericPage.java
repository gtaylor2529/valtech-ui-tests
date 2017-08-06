package page_objects;

public class GenericPage extends CorePage {

    public void assertPageIsDisplayed(String pageName) {
        waitForElementToBeVisibleById("wrapper");
        navigateToRootElement();
        navigateToElementByClassName("page-header");
        navigateToElementByTagName("h1");
        verifyElementHasText(pageName);
    }

    public void navigateToPage(String pageName) {
        navigateToRootElement();
        if (checkForElementToBeVisibleById("menu-toggle-button")) {
            navigateToElementById("menu-toggle-button");
            click();
            waitForElementToBeVisibleById("navigationMenuWrapper");
        }
        navigateToRootElement();
        navigateToElementById("navigationMenuWrapper");
        buildListByTagName("a");
        navigateToListElementByText(pageName);
        click();
    }

    public ContactPage navigateToContactPage() {
        navigateToRootElement();
        navigateToElementById("contacticon");
        click();
        return new ContactPage();
    }
}
