package starter.math;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.MathWizSteps;
import starter.steps.test;

@RunWith(SerenityRunner.class)
@Narrative(text={"Maths is important."})
public class WhenRunningTestSteps {

    @Steps
    MathWizSteps michael;
    test test;

    @Test
    public void testTest()
    {
        test.given();

        test.when();

        test.then();
    }


    @Test
    public void addingSums() {
        // Given
        michael.startsWith(1);

        // When
        michael.adds(2);

        // Then
        michael.shouldHave(3);

    }
}
