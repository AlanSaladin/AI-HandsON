import java.util.*;

public class HillClimbing extends AlgoritmoBusqueda {
    private Map<String, Integer> heuristica;

    public HillClimbing(EspacioDeEstados espacio, Estado inicio, Estado objetivo, Map<String, Integer> heuristica) {
        super(espacio, inicio, objetivo);
        this.heuristica = heuristica;
    }

    @Override
    public List<Estado> buscar() {
        List<Estado> camino = new ArrayList<>();
        Estado actual = inicio;

        while (!actual.equals(objetivo)) {
            camino.add(actual);

            // Obtener vecinos y calcular heurística
            Estado mejorVecino = null;
            int mejorHeuristica = Integer.MAX_VALUE;

            for (Estado vecino : actual.getVecinos()) {
                int h = heuristica.getOrDefault(vecino.getNombre(), Integer.MAX_VALUE);
                if (h < mejorHeuristica) {
                    mejorHeuristica = h;
                    mejorVecino = vecino;
                }
            }

            // Si no hay mejora, detener
            if (mejorVecino == null || mejorHeuristica >= heuristica.getOrDefault(actual.getNombre(), Integer.MAX_VALUE)) {
                break;
            }

            actual = mejorVecino;
        }

        if (actual.equals(objetivo)) {
            camino.add(actual);
        }

        return camino;
    }
}
