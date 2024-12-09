import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EspacioDeEstados espacio = new EspacioDeEstados();

        // Crear estados
        espacio.agregarEstado("California");
        espacio.agregarEstado("Nevada");
        espacio.agregarEstado("Arizona");
        espacio.agregarEstado("Oregon");

        // Conectar estados
        espacio.conectarEstados("California", "Nevada");
        espacio.conectarEstados("California", "Arizona");
        espacio.conectarEstados("California", "Oregon");
        espacio.conectarEstados("Nevada", "Arizona");

        // Definir inicio y objetivo
        Estado inicio = espacio.getEstado("California");
        Estado objetivo = espacio.getEstado("Nevada");

        // Definir heurísticas (menores valores son mejores)
        Map<String, Integer> heuristica = new HashMap<>();
        heuristica.put("California", 3);
        heuristica.put("Nevada", 1);
        heuristica.put("Arizona", 2);
        heuristica.put("Oregon", 5);

        // Búsqueda en Profundidad
        AlgoritmoBusqueda dfs = new BusquedaProfundidad(espacio, inicio, objetivo);
        System.out.println("DFS: " + dfs.buscar());

        // Búsqueda en Anchura
        AlgoritmoBusqueda bfs = new BusquedaAnchura(espacio, inicio, objetivo);
        System.out.println("BFS: " + bfs.buscar());

        // Hill Climbing
        AlgoritmoBusqueda hillClimbing = new HillClimbing(espacio, inicio, objetivo, heuristica);
        System.out.println("Hill Climbing: " + hillClimbing.buscar());
    }
}
