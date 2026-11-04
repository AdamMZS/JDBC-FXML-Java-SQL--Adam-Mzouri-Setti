import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    Random random = new Random();
    List<Integer> lista = new ArrayList<>();
    int numero2 = (int)(Math.random()*99)+2;

        for (int i = 0; i <numero2 ; i++) {
        int numero = (int)(Math.random()*99)+2;
        lista.add(numero);
    }
        Nodo nodo=new Nodo(lista);
        System.out.println("Lista original ("+lista.size()+")elementos:"+lista);
    try {
        nodo.start();
        nodo.join();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
        System.out.println("Lista ordenada arbol binario de hebras:"+nodo.getLista());
        System.out.println("Lista aleatoria de 2 a 100 , repartidas en: "+Nodo.getContadorHebras());

    }
}
