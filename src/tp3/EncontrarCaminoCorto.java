package tp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EncontrarCaminoCorto {

    private Grafo<?> grafo;
    HashSet<Integer> visitados;

    public EncontrarCaminoCorto(Grafo<?> grafo) {
        this.grafo = grafo;
        visitados = new HashSet<Integer>();
    }

    public ArrayList<Integer> caminoMasCorto(int origen, int destino) {

        ArrayList<Integer> caminoMasCorto = new ArrayList<>();

        this.visitados.add(origen);

        if (origen == destino) {
            visitados.remove(origen);
            caminoMasCorto.add(origen);
            return caminoMasCorto;
        }

        Iterator<Integer> iteratorAdyacentes = grafo.obtenerAdyacentes(origen);
        while (iteratorAdyacentes.hasNext()) {
            Integer current = iteratorAdyacentes.next();
            if (!visitados.contains(current)) {
                ArrayList<Integer> camino = new ArrayList<Integer>();
                camino.addAll(caminoMasCorto(current, destino));
                int sizeMasCorto = caminoMasCorto.size() == 0 ? Integer.MAX_VALUE : caminoMasCorto.size();
                if (camino.size() + 1 < sizeMasCorto) {
                    caminoMasCorto.clear();
                    caminoMasCorto.add(origen);
                    caminoMasCorto.addAll(camino);
                }
            }
        }

        visitados.remove(origen);

        return caminoMasCorto;

    }

}
