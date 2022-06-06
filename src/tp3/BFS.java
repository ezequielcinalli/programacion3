package tp3;

import java.util.HashSet;
import java.util.LinkedList;

//Recorrido Breadth-First-Search
public class BFS<T> {
    HashSet<Integer> visitados;
    LinkedList<T> cola;
    Grafo<T> grafo;

    public BFS(Grafo<T> grafo) {
        visitados = new HashSet<Integer>();
        cola = new LinkedList<T>();
        this.grafo = grafo;
    }

    public LinkedList<T> bfs() {
        return cola;
    }
}
