package page_objects;

public class ContactPage extends CorePage {

    public ContactPage() {
        waitForElementToBeVisibleById("contactbox");
    }

    public void verifyAmountOfValtechOffices() {
        navigateToRootElement();
        navigateToElementById("contactbox");
        buildListByTagName("li");
        System.out.println("Total number of Valtech offices: " + getListSize());
    }
}
