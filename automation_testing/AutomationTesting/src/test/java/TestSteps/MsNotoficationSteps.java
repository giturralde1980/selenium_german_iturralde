package TestSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MsNotoficationSteps {
    @Given("a precondition1")
    public void setUp()
    {
        System.out.println("given");
    }

    @When("an event happens1")
    public void secondCondition()
    {
        System.out.println("when");

    }

    @Then("a testable outcome is achieved1")
    public void secondConditio()
    {
        System.out.println("then");

    }
}
