package observer;

import java.util.ArrayList;

public class AlarmaColisionPocima implements subject{
    public static ArrayList<colisionPocima> observadores = new ArrayList<colisionPocima>();
    @Override
    public void attach(colisionPocima observador) {
        observadores.add(observador);
    }

    @Override
    public void dettach(colisionPocima observador) {
        observadores.remove(observador);
    }

    @Override
    public void notifyObserver() {
        for (int i = 0; i < observadores.size(); i++) {
            observadores.get(i).update();
        }
    }
    
}
