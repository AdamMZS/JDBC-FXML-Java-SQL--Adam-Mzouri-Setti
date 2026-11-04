import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.MAX_VALUE;

public class Nodo extends Thread{


    private List<Integer> lista;
    private  static AtomicInteger contadorHebras = new AtomicInteger(0);



    public List<Integer> getLista() {
        return lista;
    }

    public Nodo(List<Integer> lista) {
        this.lista = lista;
        contadorHebras.incrementAndGet();
    }
    public Nodo(){

    }
    public static int getContadorHebras() {
        return contadorHebras.get();
    }
    public void añade(List<Integer> desde,List<Integer > hasta) {
        lista.addAll(desde);
        lista.addAll(hasta);
    }
    public void mezcla(List<Integer> desde,List<Integer > hasta){
    lista.clear();
    int i=0;
    int j=0;
    while (i<desde.size() && j<hasta.size()){
        if (desde.get(i)<hasta.get(j)){
            lista.add(desde.get(i));
            i++;
        }else{
            lista.add(hasta.get(j));
            j++;
        }
    }
    while(i<desde.size()){
        lista.add(desde.get(i));
        i++;
    }
    while(j<hasta.size()){
        lista.add(hasta.get(j));
        j++;
    }
    }
    public void run() {

      if (lista.size()<=1){
          return;
      }else {
          int mitad = lista.size() / 2;
            List<Integer> izquierda = new ArrayList<>(lista.subList(0, mitad));
            List<Integer> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));
            Nodo nodo1 = new Nodo(izquierda);
            Nodo nodo2 = new Nodo(derecha);
            try{
                nodo1.start();
                nodo2.start();
                nodo1.join();
                nodo2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            mezcla(izquierda,derecha);
      }

    }
}
