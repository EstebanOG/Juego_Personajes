package chainOfResponsability;

import animacion.Personaje;

public class HandlerVida extends Handler {

    @Override
    public void handlerRequest(int vida, int escudo, Personaje per) {
        System.out.println(vida);
        if (vida < 100 && vida > 49) {
            vida = 100;
            per.setVida(vida);
        }   
        else if (vida < 50) {
            vida += 50;
            per.setVida(vida);
        }else {
            successor.handlerRequest(vida, escudo, per);
        }
    }

}
