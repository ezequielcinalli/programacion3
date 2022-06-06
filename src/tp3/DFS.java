package tp3;

import java.util.Iterator;
import java.util.LinkedList;

//Recorrido Breadth-First-Search
public class DFS<T> {
    LinkedList<Integer> visitados;
    Grafo<T> grafo;

    public DFS(Grafo<T> grafo) {
        visitados = new LinkedList<Integer>();
        this.grafo = grafo;
    }

    public LinkedList<Integer> dfs() {
        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer current = itVertices.next();
            if (!visitados.contains(current)) {
                dfsVisit(current);
            }
        }
        return visitados;
    }

    public void dfsVisit(Integer vertice) {
        this.visitados.add(vertice);

        Iterator<Integer> iteratorAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (iteratorAdyacentes.hasNext()) {
            Integer next = iteratorAdyacentes.next();
            if (!visitados.contains(next)) {
                dfsVisit(next);
            }
        }
    }

    public void cleanVisitados() {
        this.visitados.clear();
    }

}
