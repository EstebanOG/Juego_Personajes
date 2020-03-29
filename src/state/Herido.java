package state;

import animacion.Personaje;

public class Herido implements Estado{

    @Override
    public void verificarEstado(Personaje personaje) {
        personaje.setDaño(80);
    }
    
}
