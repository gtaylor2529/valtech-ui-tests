package page_objects;

public class HomePage extends CorePage {

    public void assertHomePageIsDisplayed() {
        waitForElementToBeVisibleById("wrapper");
    }

    public void assertSectionIsDisplayed(String sectionName) {
        navigateToRootElement();
        buildListByClassName("block-header__heading");
        navigateToListElementByText(sectionName);
        verifyElementHasText(sectionName);
    }
}
