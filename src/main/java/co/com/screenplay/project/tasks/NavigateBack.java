package co.com.screenplay.project.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.WebDriver;


public class NavigateBack implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = Serenity.getDriver();
        driver.navigate().back();
    }

    public static NavigateBack toPreviousPage() {
        return new NavigateBack();
    }
}