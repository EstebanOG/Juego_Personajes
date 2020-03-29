package strategy;

import animacion.Personaje;

public class StrategyDecorado extends Strategy{

    public StrategyDecorado(Personaje personaje) {
        super(personaje);
    }

    @Override
    public void vidaEscudo() {
        personaje.setVida(personaje.getVida()-20);
    }
    
}
