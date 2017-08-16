package page_objects;

import cucumber.api.Scenario;
import driver.Properties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CorePage {

    private WebDriver driver;
    private WebElement element = null;
    private List<WebElement> elements;
    private int explicitWaitTime = 20;

    public CorePage() {
        this.driver = Properties.getDriver();
    }

    public void navigateToUrl(String url) {
        this.driver = Properties.setDriver();
        this.driver.get(url);
    }

    public void tearDownDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/jpeg");
        }
        this.driver.close();
    }

    public void navigateToRootElement() {
        this.element = this.driver.findElement(By.xpath("/html/body"));
    }

    public void navigateToElementById(String id) {
        boolean elementFound;
        try {
            this.element = this.element.findElement(By.id(id));
            elementFound = true;
        } catch (Exception e) {
            elementFound = false;
            System.out.println("Element not found - id: " + id);
        }
        assertThat(elementFound).isTrue();
    }

    public void navigateToElementByClassName(String className) {
        boolean elementFound;
        try {
            this.element = this.element.findElement(By.className(className));
            elementFound = true;
        } catch (Exception e) {
            elementFound = false;
            System.out.println("Element not found - className: " + className);
        }
        assertThat(elementFound).isTrue();
    }

    public void navigateToElementByTagName(String tagName) {
        boolean elementFound;
        try {
            this.element = this.element.findElement(By.tagName(tagName));
            elementFound = true;
        } catch (Exception e) {
            elementFound = false;
            System.out.println("Element not found - tagName: " + tagName);
        }
        assertThat(elementFound).isTrue();
    }

    public void click() {
        boolean elementClicked;
        try {
            this.element.click();
            elementClicked = true;
        } catch (Exception e) {
            elementClicked = false;
            System.out.println("Element could not be clicked");
        }
        assertThat(elementClicked).isTrue();
    }

    public void waitForElementToBeVisibleById(String id) {
        boolean elementFound;
        try {
            new WebDriverWait(this.driver, (long) explicitWaitTime).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
            elementFound = true;
        } catch (Exception e) {
            elementFound = false;
            System.out.println("Element not visible - id: " + id);
        }
        assertThat(elementFound).isTrue();
    }

    public boolean checkForElementToBeVisibleById(String id) {
        boolean elementFound = true;
        try {
            new WebDriverWait(this.driver, (long) 5).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        } catch (Exception e) {
            elementFound = false;
            System.out.println("Element not visible - id: " + id);
        }
        return elementFound;
    }

    public void buildListByClassName(String className) {
        this.elements = this.element.findElements(By.className(className));
    }

    public void buildListByTagName(String tagName) {
        this.elements = this.element.findElements(By.tagName(tagName));
    }

    public String getListSize() {
        return String.valueOf(this.elements.size());
    }

    public void navigateToListElementByText(String text) {
        boolean elementFound = false;
        Iterator elementList = this.elements.iterator();
        while (elementList.hasNext()) {
            WebElement element = (WebElement) elementList.next();
            if (element.getText().toLowerCase().equals(text.toLowerCase())) {
                this.element = element;
                elementFound = true;
                break;
            } else {
                elementFound = false;
                System.out.println("List element not found this time - text: " + text);
            }
        }
        assertThat(elementFound).isTrue();
    }

    public void verifyElementHasText(String text) {
        assertThat(this.element.getText()).isEqualToIgnoringCase(text);
    }
}
