package grafos;

import java.util.Scanner;

public class AppRutaMasCorta {

    public static Scanner lectura = new Scanner(System.in);

    public static void main(String[] args) throws GrafoException {

        // Inicializa variables
        int claveOrigen = 0;
        int claveDestino = 0;
        String tipoRecorrido = "";

        // Construye el grafo
        Grafo graph = crearGrafo();

        // Muestra los vertices disponibles con claves para seleccionarlos de un menu
        System.out.println("VERTICES Y CLAVES DEL GRAFO");
        graph.imprimirVertices(graph.getLVertices());
        System.out.println("Introduzca la clave del origen :");
        while (claveOrigen > graph.getLVertices().size() || claveOrigen < 1) {
            claveOrigen = lectura.nextInt();
        }
        System.out.println("Introduzca la clave del destino :");
        while (claveDestino > graph.getLVertices().size() || claveDestino < 1) {
            claveDestino = lectura.nextInt();
        }

        // Determina si el nodo de origen solicitado tiene destinos
        if (!graph.getLVertices().get(claveOrigen - 1).getAdyacentes().isEmpty()) {
            System.out.println("Introduzca el tipo de recorrido deseado ('t' tiempo y 'v' para viaticos) :");
            tipoRecorrido = lectura.next();
            System.out.println("-----------------------------");

            switch (tipoRecorrido.charAt(0)) {
                case 't':
                case 'T':
                    graph.mejorRecorridoTiempo(claveOrigen, claveDestino);
                    break;
                case 'v':
                case 'V':
                    graph.mejorRecorridoViaticos(claveOrigen, claveDestino);
                    break;
                default:
                    System.out.println("El tipo de destino no es valido");
                    break;
            }
        } else {
            System.out.println("El vertice origen no tiene destinos disponibles !");
        }
    }

    public static Grafo crearGrafo() {

        // Grafo(dirigido? true/false)
        Grafo graph = new Grafo(true);

        // AddVertice(clave vertice, datos(nombre))
        graph.AddVertice(1, new DatosV("A"));
        graph.AddVertice(2, new DatosV("B"));
        graph.AddVertice(3, new DatosV("C"));
        graph.AddVertice(4, new DatosV("D"));
        graph.AddVertice(5, new DatosV("E"));
        graph.AddVertice(6, new DatosV("F"));
        graph.AddVertice(7, new DatosV("G"));
        graph.AddVertice(8, new DatosV("H"));
        graph.AddVertice(9, new DatosV("I"));
        graph.AddVertice(10, new DatosV("J"));

        // AddArista(clave origen, clave destino, datos(tiempo, viaticos))
        graph.AddArista(1, 2, new DatosA(3, 3));
        graph.AddArista(1, 3, new DatosA(6, 6));
        graph.AddArista(1, 4, new DatosA(4, 4));
        graph.AddArista(2, 5, new DatosA(2, 2));
        graph.AddArista(3, 5, new DatosA(3, 3));
        graph.AddArista(3, 8, new DatosA(1, 1));
        graph.AddArista(3, 6, new DatosA(7, 7));
        graph.AddArista(4, 6, new DatosA(3, 3));
        graph.AddArista(4, 9, new DatosA(6, 6));
        graph.AddArista(5, 7, new DatosA(5, 5));
        graph.AddArista(5, 8, new DatosA(6, 6));
        graph.AddArista(6, 8, new DatosA(8, 8));
        graph.AddArista(6, 9, new DatosA(2, 2));
        graph.AddArista(7, 2, new DatosA(4, 4));
        graph.AddArista(7, 10, new DatosA(2, 2));
        graph.AddArista(8, 10, new DatosA(4, 4));
        graph.AddArista(8, 9, new DatosA(1, 1));
        graph.AddArista(9, 10, new DatosA(3, 3));

        return graph;
    }

}