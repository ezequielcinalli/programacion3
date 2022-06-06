package tp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EncontrarCaminoLargo<T> {
    HashSet<Integer> visitados;
    Grafo<T> grafo;

    public EncontrarCaminoLargo(Grafo<T> grafo) {
        visitados = new HashSet<Integer>();
        this.grafo = grafo;
    }

    public ArrayList<Integer> getCaminoMasLargo(Integer origen, Integer destino) {
        ArrayList<Integer> caminoMasLargo = new ArrayList<Integer>();

        this.visitados.add(origen);

        if (origen == destino) {
            visitados.remove(origen);
            caminoMasLargo.add(origen);
            return caminoMasLargo;
        }

        Iterator<Integer> iteratorAdyacentes = grafo.obtenerAdyacentes(origen);
        while (iteratorAdyacentes.hasNext()) {
            Integer current = iteratorAdyacentes.next();
            if (!visitados.contains(current)) {
                ArrayList<Integer> camino = new ArrayList<Integer>();
                camino.addAll(getCaminoMasLargo(current, destino));
                if (camino.size() + 1 > caminoMasLargo.size()) {
                    caminoMasLargo.clear();
                    caminoMasLargo.add(origen);
                    caminoMasLargo.addAll(camino);
                }
            }
        }

        visitados.remove(origen);

        return caminoMasLargo;
    }

}