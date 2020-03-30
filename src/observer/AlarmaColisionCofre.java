package observer;

import java.util.ArrayList;

public class AlarmaColisionCofre implements subjectCofre{
    public static ArrayList<colisionCofre> observadoresCofre = new ArrayList<colisionCofre>();
    @Override
    public void attach(colisionCofre observadorCofre) {
        observadoresCofre.add(observadorCofre);
    }

    @Override
    public void dettach(colisionCofre observadorCofre) {
        observadoresCofre.remove(observadorCofre);
    }

    @Override
    public void notifyObserver(){
            for (int i = 0; i < observadoresCofre.size(); i++) {
            observadoresCofre.get(i).update();
        }
    }
    
}
