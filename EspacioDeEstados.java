import java.util.HashMap;
import java.util.Map;

public class EspacioDeEstados {
    private Map<String, Estado> estados;

    public EspacioDeEstados() {
        estados = new HashMap<>();
    }

    public void agregarEstado(String nombre) {
        if (!estados.containsKey(nombre)) {
            estados.put(nombre, new Estado(nombre));
        }
    }

    public void conectarEstados(String nombre1, String nombre2) {
        Estado e1 = estados.get(nombre1);
        Estado e2 = estados.get(nombre2);

        if (e1 != null && e2 != null) {
            e1.agregarVecino(e2);
            e2.agregarVecino(e1);
        }
    }

    public Estado getEstado(String nombre) {
        return estados.get(nombre);
    }
}
