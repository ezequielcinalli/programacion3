package tp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ej5 {
    Grafo<?> grafo;
    HashSet<Integer> visitados;
    ArrayList<Integer> verticesSolucion;

    public Ej5(Grafo<?> grafo) {
        this.grafo = grafo;
        this.visitados = new HashSet<Integer>();
        this.verticesSolucion = new ArrayList<Integer>();
    }

    public ArrayList<Integer> caminoADestino(Integer destino) {

        Iterator<Integer> itVertices = grafo.obtenerVertices();
        while (itVertices.hasNext()) {
            Integer current = itVertices.next();
            if (!this.visitados.contains(current)) {
                existeCamino(current, destino);
            }
        }

        return verticesSolucion;
    }

    public boolean existeCamino(Integer origen, Integer destino) {
        this.visitados.add(origen);

        if (origen == destino) {
            this.verticesSolucion.add(origen);
            return true;
        }

        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(origen);
        while (adyacentes.hasNext()) {
            Integer current = adyacentes.next();
            if (!this.visitados.contains(current)) {
                if (existeCamino(current, destino)) {
                    this.verticesSolucion.add(origen);
                    return true;
                }
            } else if (this.verticesSolucion.contains(current)) {
                this.verticesSolucion.add(origen);
                return true;
            }
        }

        return false;
    }
}
