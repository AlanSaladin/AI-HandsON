import java.util.List;

public abstract class AlgoritmoBusqueda {
    protected EspacioDeEstados espacio;
    protected Estado inicio;
    protected Estado objetivo;

    public AlgoritmoBusqueda(EspacioDeEstados espacio, Estado inicio, Estado objetivo) {
        this.espacio = espacio;
        this.inicio = inicio;
        this.objetivo = objetivo;
    }

    public abstract List<Estado> buscar();
}
