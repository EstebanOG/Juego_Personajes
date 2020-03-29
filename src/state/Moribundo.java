package state;

import animacion.Personaje;

public class Moribundo implements Estado{

    @Override
    public void verificarEstado(Personaje personaje) {
        personaje.setDaño(100);
    }
    
}
