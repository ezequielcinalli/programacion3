package tp3;

import java.util.HashMap;
import java.util.Iterator;

//Recorrido Breadth-First-Search
public class Ej3<T> {
    private Grafo<T> grafo;
    private HashMap<Integer, String> colores;

    public Ej3(Grafo<T> grafo) {
        this.grafo = grafo;
        this.colores = new HashMap<>();
    }

    public boolean grafoTieneCiclos() {
        Iterator<Integer> it = this.grafo.obtenerVertices();
        while (it.hasNext()) {
            int verticeId = it.next();
            this.colores.put(verticeId, "blanco");
        }

        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer current = itVertices.next();
            if (this.colores.get(current).equals("blanco")) {
                boolean tieneCiclo = dfsVisit(current);
                if (tieneCiclo) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsVisit(Integer vertice) {
        this.colores.put(vertice, "amarillo");

        Iterator<Integer> iteratorAdyacentes = grafo.obtenerAdyacentes(vertice);
        while (iteratorAdyacentes.hasNext()) {
            Integer next = iteratorAdyacentes.next();
            if (this.colores.get(next).equals("blanco")) {
                if (dfsVisit(next))
                    return true;
            } else if (this.colores.get(next).equals("amarillo")) {
                return true;
            }
        }

        this.colores.put(vertice, "negro");

        return false;
    }

}
