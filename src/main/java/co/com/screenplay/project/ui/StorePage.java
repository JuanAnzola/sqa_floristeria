package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI extends PageObject {
    public static final Target IMG_MAIN= Target.the("Imagen Principal")
            .located(By.xpath ("//div[@class=\"mobile-logo\"]//img[@alt=\"Floristería Mundo Flor\"]"));
}
