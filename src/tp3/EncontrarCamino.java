package tp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EncontrarCamino {

    private Grafo<?> grafo;
    HashSet<Integer> visitados;

    public EncontrarCamino(Grafo<?> grafo) {
        this.grafo = grafo;
        visitados = new HashSet<Integer>();
    }

    public ArrayList<Integer> encontrarCamino(int origen, int destino) {

        ArrayList<Integer> camino = new ArrayList<>();

        this.visitados.add(origen);

        if (origen == destino) {
            visitados.remove(origen);
            camino.add(origen);
            return camino;
        }

        Iterator<Integer> iteratorAdyacentes = grafo.obtenerAdyacentes(origen);
        while (iteratorAdyacentes.hasNext()) {
            Integer current = iteratorAdyacentes.next();
            if (!visitados.contains(current)) {
                ArrayList<Integer> caminoAdyacente = new ArrayList<Integer>();
                caminoAdyacente.addAll(encontrarCamino(current, destino));
                if (caminoAdyacente.size() != 0) {
                    camino.add(origen);
                    camino.addAll(caminoAdyacente);
                    return camino;
                }
            }
        }

        visitados.remove(origen);

        return camino;

    }

}
