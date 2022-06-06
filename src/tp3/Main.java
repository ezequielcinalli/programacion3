package tp3;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Se toma como referenia el grafo de la imagen src/tp3/grafo.jpg
        // Se reemplazan las letras de vertices a-e por numeros 1-5
        Grafo<Integer> grafo = new GrafoDirigido<Integer>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);

        grafo.agregarArco(1, 3, 12);
        grafo.agregarArco(1, 4, 60);
        grafo.agregarArco(2, 1, 10);
        grafo.agregarArco(3, 2, 20);
        grafo.agregarArco(3, 4, 32);
        grafo.agregarArco(5, 1, 7);

        System.out.println(grafo.toString());

        // System.out.println("Cantidad de arcos: " + grafo.cantidadArcos());
        // System.out.println("Cantidad de vertices: " + grafo.cantidadVertices());

        // System.out.println("contieneVertice 3: " + grafo.contieneVertice(3));
        // System.out.println("contieneVertice 7: " + grafo.contieneVertice(7));

        // System.out.println("existeArco 3-4: " + grafo.existeArco(3, 4));
        // System.out.println("existeArco 3-1: " + grafo.existeArco(3, 1));

        // System.out.print("obtenerAdyacentes vertice 1: ");
        // Iterator<Integer> iteratorAdyacentesVertice1 = grafo.obtenerAdyacentes(1);
        // while (iteratorAdyacentesVertice1.hasNext()) {
        // System.out.print(iteratorAdyacentesVertice1.next() + "-");
        // }
        // System.out.println();
        // System.out.print("obtenerAdyacentes vertice 5: ");
        // Iterator<Integer> iteratorAdyacentesVertice5 = grafo.obtenerAdyacentes(5);
        // while (iteratorAdyacentesVertice5.hasNext()) {
        // System.out.print(iteratorAdyacentesVertice5.next() + "-");
        // }
        // System.out.println();

        // System.out.println("obtenerArco 1-3: " + grafo.obtenerArco(1, 3));
        // System.out.println("obtenerArco 5-2: " + grafo.obtenerArco(5, 2));

        // System.out.print("obtenerVertices: ");
        // Iterator<Integer> iteratorObtenerVertices = grafo.obtenerVertices();
        // while (iteratorObtenerVertices.hasNext()) {
        // System.out.print(iteratorObtenerVertices.next() + "-");
        // }
        // System.out.println();

        // System.out.print("obtenerArcos: ");
        // Iterator<Arco<Integer>> iteratorObtenerArcos = grafo.obtenerArcos();
        // while (iteratorObtenerArcos.hasNext()) {
        // System.out.print(iteratorObtenerArcos.next());
        // }
        // System.out.println();

        // System.out.print("obtenerArcos vertice 1: ");
        // Iterator<Arco<Integer>> iteratorObtenerArcosVertice = grafo.obtenerArcos(1);
        // while (iteratorObtenerArcosVertice.hasNext()) {
        // System.out.print(iteratorObtenerArcosVertice.next());
        // }
        // System.out.println();

        // grafo.borrarVertice(3);
        // System.out.println("borrarVertice(3): " + grafo);

        // grafo.borrarArco(1, 4);
        // System.out.println("borrarArco(1,4): " + grafo);

        // DFS --------------------------
        // DFS<Integer> dfs = new DFS<Integer>(grafo);
        // for (Integer vertice : dfs.dfs()) {
        // System.out.print(vertice + "-");
        // }

        // BFS<Integer> bfs = new BFS<Integer>(grafo);
        // System.out.print("BFS: ");
        // for (Integer vertice : bfs.bfs()) {
        // System.out.print(vertice + "-");
        // }

        // EncontrarCaminoLargo<Integer> ej4 = new EncontrarCaminoLargo<Integer>(grafo);
        // System.out.print("Ej4: ");
        // Iterator<Integer> it = ej4.getCaminoMasLargo(3, 4).iterator();
        // while (it.hasNext()) {
        // System.out.print(it.next() + "-");
        // }
        // System.out.println();

        // ExisteCamino existeCamino = new ExisteCamino(grafo);
        // System.out.println("Existe camino: " + existeCamino.existeCamino(2, 4));
        // System.out.println();

        // EncontrarCaminoCorto caminoCorto = new EncontrarCaminoCorto(grafo);
        // System.out.print("Camino mas corto: ");
        // Iterator<Integer> it = caminoCorto.caminoMasCorto(5, 4).iterator();
        // while (it.hasNext()) {
        // System.out.print(it.next() + "-");
        // }
        // System.out.println();

        // EncontrarCamino camino = new EncontrarCamino(grafo);
        // System.out.print("Encontrar camino: ");
        // Iterator<Integer> it = camino.encontrarCamino(2, 4).iterator();
        // while (it.hasNext()) {
        // System.out.print(it.next() + "-");
        // }
        // System.out.println();

        // EncontrarCaminos caminos = new EncontrarCaminos(grafo);
        // System.out.println("Encontrar todos los caminos: ");
        // Iterator<ArrayList<Integer>> it = caminos.encontrarCaminos(1, 4).iterator();
        // while (it.hasNext()) {
        // System.out.print("\t");
        // Iterator<Integer> it2 = it.next().iterator();
        // while (it2.hasNext()) {
        // System.out.print(it2.next() + "-");
        // }
        // System.out.println();
        // }
        // System.out.println();

        Ej3<Integer> ej3 = new Ej3<Integer>(grafo);
        System.out.println("Ej3 grafo tiene ciclo: " + ej3.grafoTieneCiclos());

        Ej5 ej5 = new Ej5(grafo);
        System.out.print("Ej5 listado vertices que llegan a destino 4: ");
        for (Integer vertice : ej5.caminoADestino(4)) {
            System.out.print(vertice + " - ");
        }
        System.out.println();
    }
}