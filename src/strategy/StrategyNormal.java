package strategy;

import animacion.Personaje;

public class StrategyNormal extends Strategy{

    public StrategyNormal(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void vidaEscudo() {
        personaje.setVida(personaje.getVida()-40);
    }
    
}
