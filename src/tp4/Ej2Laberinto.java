public class Ej2Laberinto {
  private Casillero destino;
  private Solucion mejorSolucion;

  public void resolver(Casillero inicio, Casillero fin) {
    destino = fin;
    Estado e = new Estado();
    e.agregarCasillero(inicio);
    back_laberinto(e);
  }

  public void back_laberinto(Estado e){
    if(e.getCasilleroActual() == destino){
      if(mejorSolucion == null || mejorSolucion.getCosto() > e.getCostoCamino()){
        mejorSolucion.agregarCamino(e.getCamino());
        mejorSolucion.agregarCosto(e.getCostoCamino());
      }
    }
    else{
      List<Casillero> vecinos = e.getVecinos();
      for(Casillero c:vecinos){
        if(!e.getCamino().visitado(c)){
          e.agregarCasillero();
          e.marcarVisitado(c);
          e.incrementarCosto(c);
          back_laberinto(e);
          e.eliminarCasillero(c);
          e.desmarcarVisitado(c);
          e.decrementarCosto(c);
        }
    }
  }
}
