package co.com.screenplay.project.tasks;

import java.util.ArrayList;
import java.util.List;

public class Cart{
    private List<String> nombresProductos;

    public Cart() {
        nombresProductos = new ArrayList<>();
    }

    public void agregarProducto(String nombreProducto) {
        nombresProductos.add(nombreProducto);
    }
    public int cantidad(){
        return nombresProductos.size();
    }

    public String getNombresProductos(int i) {
        return nombresProductos.get(i);
    }
}
