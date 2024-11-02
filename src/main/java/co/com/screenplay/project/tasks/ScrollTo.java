package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollTo implements Task {
    private final Target element;

    public ScrollTo(Target element) {
        this.element = element;
    }

    @Override
    @Step("{0} hace scroll hasta el elemento #element")
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.resolveFor(actor));
    }

    public static ScrollTo element(Target element) {
        return new ScrollTo(element);
    }
}