package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import page_objects.CorePage;

public class SetupStepDef {

    Scenario scenario;

    @Before
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void tearDownBrowser() {
        CorePage corePage = new CorePage();
        corePage.tearDownDriver(scenario);
    }
}
