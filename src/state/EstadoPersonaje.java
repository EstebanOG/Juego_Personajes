package state;

import animacion.Personaje;

public class EstadoPersonaje {
    
    private Personaje personaje;
    private Estado estadoPersonaje;

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void setEstadoPersonaje(Estado estadoPersonaje) {
        this.estadoPersonaje = estadoPersonaje;
    }
    
    public void verificarEstado(){
        estadoPersonaje.verificarEstado(personaje);
    }
}
