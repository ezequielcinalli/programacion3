import javax.crypto.interfaces.DHKey;

public class Ej4ParticionConjuntos {
  // estado inicial: C = {1,2,3,4,5,6}

  // 2ndo estado: C2.1 = {1,2,3}, {4,5,6}
  // 2ndo estado: C2.2 = {1,2,4}, {3,5,6}
  // 2ndo estado: C2.3 = {1,2,5}, {3,4,6}
  // 2ndo estado: C2.4 = {1,2,6}, {3,4,5}
  // ...................................

  // estado final = S {x,x,x},{y,y,y}

  Solucion solucion;

  public void resolver(Conjunto c) {

    this.conjunto = c;
    Estado e = new Estado();
    e.agregarOrigen();
    back_conjunto(e);
  }

  // Estado contiene el conjunto de numeros y 2 subconjuntos
  public bool back_particion(Estado e) {
    if (e.getConjuntoNumeros().size() == 0) {
      if (e.sumaIgualSubconjuntos()) {
        this.solucion.setConjunto1(e.getConjunto1());
        this.solucion.setConjunto2(e.getConjunto2());
        return true;
      }
    } else {
      Integer numero = e.getProximoNumero(); // Retorna el primer numero y lo borra del conjunto
      for (Conjunto c : e.getSubconjuntos()) {
        if (!e.poda(numero)) { // Hace....
          c.agregar(numero);
          boolean resultado = back_particion(e);
          if (resultado)
            return true;
          c.eliminar(numero);
        }
      }
    }
  }

}