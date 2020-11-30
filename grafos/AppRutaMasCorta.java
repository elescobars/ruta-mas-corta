package grafos;

public class AppRutaMasCorta {

    public static void main(String[] args) throws GrafoException {

        Grafo graph = crearGrafo();

        // Recorrido(a = anchura, p = profundidad, v = viaticos)
        graph.Recorrido('v');

    }

    public static Grafo crearGrafo() {

        // Grafo(dirigido? true/false)
        Grafo graph = new Grafo(true);

        // AddVertice(clave vertice, datos(nombre))
        graph.AddVertice(1, new DatosV("a"));
        graph.AddVertice(2, new DatosV("b"));
        graph.AddVertice(3, new DatosV("c"));
        graph.AddVertice(4, new DatosV("d"));
        graph.AddVertice(5, new DatosV("e"));
        graph.AddVertice(6, new DatosV("f"));
        graph.AddVertice(7, new DatosV("g"));
        graph.AddVertice(8, new DatosV("h"));
        graph.AddVertice(9, new DatosV("i"));
        graph.AddVertice(10, new DatosV("j"));

        // AddArista(clave origen, clave destino, datos(viaticos, tiempo))
        graph.AddArista(1, 2, new DatosA(3, 0));
        graph.AddArista(1, 3, new DatosA(6, 0));
        graph.AddArista(1, 4, new DatosA(4, 0));
        graph.AddArista(2, 5, new DatosA(2, 0));
        graph.AddArista(3, 5, new DatosA(3, 0));
        graph.AddArista(3, 8, new DatosA(1, 0));
        graph.AddArista(3, 6, new DatosA(7, 0));
        graph.AddArista(4, 6, new DatosA(3, 0));
        graph.AddArista(4, 9, new DatosA(6, 0));
        graph.AddArista(5, 7, new DatosA(5, 0));
        graph.AddArista(5, 8, new DatosA(6, 0));
        graph.AddArista(6, 8, new DatosA(8, 0));
        graph.AddArista(6, 9, new DatosA(2, 0));
        graph.AddArista(7, 2, new DatosA(4, 0));
        graph.AddArista(7, 10, new DatosA(2, 0));
        graph.AddArista(8, 10, new DatosA(4, 0));
        graph.AddArista(8, 9, new DatosA(1, 0));
        graph.AddArista(9, 10, new DatosA(3, 0));

        return graph;
    }

}