package co.com.screenplay.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class StorePage extends PageObject {
    public static final Target CATEGORY = Target.the("Categoría específica")
            .located(By.xpath("//a[text()=\"Agradecimientos\"]"));

    public static  Target MENU(String producto) {return Target.the("producto")
            .locatedBy("//a[text()='{0}']").of(producto);}

    public static Target SECTION(String product){return Target.the("menu desplegable")
            .locatedBy("//figure/a[@title='{0}']/following-sibling::div[@class='groups-button clearfix']//div[@class='add-cart tbay-tooltip']").of(product);}

    public static final  Target TITLE =Target.the("Title")
            .locatedBy("//h1[text()='Agradecimientos']");

    public static final  Target CART =Target.the("CART")
            .locatedBy("//span[@class='text-skin cart-icon']");

    public static Target PRODUCT(String product){
        return Target.the("nombre de productos").locatedBy("//div[@class='active-mobile top-cart']//div//div/div//ul//div//a[text()='{0}']").of(product);
    }
}
