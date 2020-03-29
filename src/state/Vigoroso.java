package state;

import animacion.Personaje;

public class Vigoroso implements Estado{

    @Override
    public void verificarEstado(Personaje personaje) {
         personaje.setDaño(50);
    }
    
}
