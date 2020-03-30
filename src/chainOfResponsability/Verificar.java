package chainOfResponsability;

import animacion.Personaje;

public class Verificar {
    Handler manejadores[];

    public void operacion(int vida, int escudo, Personaje per) {
        manejadores = new Handler[2];
        manejadores[1] = new HandlerEscudo();
        manejadores[0] = new HandlerVida();
        for (int i = 0; i < manejadores.length - 1; i++) {
            manejadores[i].setSuccessor(manejadores[i + 1]);;
        }
        manejadores[0].handlerRequest(vida, escudo, per);
    }
}
