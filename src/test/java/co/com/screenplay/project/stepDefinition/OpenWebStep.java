package co.com.screenplay.project.stepDefinition;

import co.com.screenplay.project.tasks.Cart;
import co.com.screenplay.project.tasks.NavigateBack;
import co.com.screenplay.project.tasks.ScrollTo;
import co.com.screenplay.project.ui.StorePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static co.com.screenplay.project.ui.StorePage.CATEGORY;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OpenWebStep {
    Cart cart = new Cart();

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @When("El usuario navega a la categoría {string}")
    public void NavigateToCategory(String string) {
        try {
            theActorInTheSpotlight().attemptsTo(
                    Click.on(CATEGORY)
            );
        }catch (Exception e){
            System.out.println("Error e: "+e);
        }
    }


    @When("El usuario selecciona el producto {string} de la lista y hace clic en agregar al carrito")
    public void userSelectProduct(String product) {
        try {
            cart.agregarProducto(product);

            Actor usuario = OnStage.theActorInTheSpotlight();

            usuario.attemptsTo(
                    ScrollTo.element(StorePage.TITLE),
                    MoveMouse.to(StorePage.MENU(product))
            );

            usuario.attemptsTo(
                    Click.on(StorePage.SECTION(product)));

            usuario.attemptsTo(
                    NavigateBack.toPreviousPage()
            );
        }catch (Exception e){
            System.out.println("Error e: "+e);
        }
    }

    @Then("El usuario verifica que el carro tiene los productos seleccionados")
    public void validateProductsOnShoppingCart() throws Exception {
        Actor usuario = OnStage.theActorInTheSpotlight();

        usuario.attemptsTo(
                Click.on(StorePage.CART));


        for (int i=0; i < cart.cantidad() ; i++){
            String producto = cart.getNombresProductos(i);
            if (!StorePage.PRODUCT(producto).resolveFor(usuario).isEnabled()) {
                throw new Exception("El producto: " + producto + " no está en el carrito");
            }else {
                System.out.println(producto);
            }
        }
    }
    
}
