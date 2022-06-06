package tp3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EncontrarCaminos {

    private Grafo<?> grafo;
    HashSet<Integer> visitados;

    public EncontrarCaminos(Grafo<?> grafo) {
        this.grafo = grafo;
        visitados = new HashSet<Integer>();
    }

    public ArrayList<ArrayList<Integer>> encontrarCaminos(int origen, int destino) {

        ArrayList<ArrayList<Integer>> caminos = new ArrayList<ArrayList<Integer>>();

        visitados.add(origen);

        if (origen == destino) {
            ArrayList<Integer> camino = new ArrayList<>();
            camino.add(origen);
            caminos.add(camino);
            visitados.remove(origen);
            return caminos;
        } else {
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(origen);
            while (adyacentes.hasNext()) {
                Integer current = adyacentes.next();
                if (!visitados.contains(current)) {
                    for (ArrayList<Integer> camino : encontrarCaminos(current, destino)) {
                        ArrayList<Integer> caminoAux = new ArrayList<Integer>();
                        caminoAux.add(origen);
                        caminoAux.addAll(camino);
                        caminos.add(caminoAux);
                    }
                }
            }
        }

        visitados.remove(origen);

        return caminos;
    }

}
