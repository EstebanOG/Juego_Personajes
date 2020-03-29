package chainOfResponsability;

import animacion.Personaje;

public abstract class Handler {

    Handler successor;

    public abstract void handlerRequest(int vida, int escudo, Personaje per);

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
