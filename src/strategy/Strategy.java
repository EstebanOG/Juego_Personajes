package strategy;

import animacion.Personaje;

public abstract class Strategy {
    Personaje personaje;

    public Strategy(Personaje personaje) {
        this.personaje = personaje;
    }
    public abstract void vidaEscudo();
}
