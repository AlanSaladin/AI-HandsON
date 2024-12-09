import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BusquedaProfundidad extends AlgoritmoBusqueda {
    public BusquedaProfundidad(EspacioDeEstados espacio, Estado inicio, Estado objetivo) {
        super(espacio, inicio, objetivo);
    }

    @Override
    public List<Estado> buscar() {
        Stack<Estado> stack = new Stack<>();
        List<Estado> visitados = new ArrayList<>();
        stack.push(inicio);

        while (!stack.isEmpty()) {
            Estado actual = stack.pop();
            if (!visitados.contains(actual)) {
                visitados.add(actual);

                if (actual.equals(objetivo)) {
                    return visitados;
                }

                for (Estado vecino : actual.getVecinos()) {
                    stack.push(vecino);
                }
            }
        }
        return visitados;
    }
}
