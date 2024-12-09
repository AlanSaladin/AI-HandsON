import java.util.ArrayList;
import java.util.List;

public class Estado {
    private String nombre;
    private List<Estado> vecinos;

    public Estado(String nombre) {
        this.nombre = nombre;
        this.vecinos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estado> getVecinos() {
        return vecinos;
    }

    public void agregarVecino(Estado vecino) {
        vecinos.add(vecino);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
