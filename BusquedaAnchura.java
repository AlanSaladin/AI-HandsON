import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BusquedaAnchura extends AlgoritmoBusqueda {
    public BusquedaAnchura(EspacioDeEstados espacio, Estado inicio, Estado objetivo) {
        super(espacio, inicio, objetivo);
    }

    @Override
    public List<Estado> buscar() {
        Queue<Estado> queue = new LinkedList<>();
        List<Estado> visitados = new ArrayList<>();
        queue.add(inicio);

        while (!queue.isEmpty()) {
            Estado actual = queue.poll();
            if (!visitados.contains(actual)) {
                visitados.add(actual);

                if (actual.equals(objetivo)) {
                    return visitados;
                }

                for (Estado vecino : actual.getVecinos()) {
                    queue.add(vecino);
                }
            }
        }
        return visitados;
    }
}
