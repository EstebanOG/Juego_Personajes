package objetosMapa;

import observer.colisionCofre;

public class Cofre implements colisionCofre{
    private String imagen = "/assets/Pocion2.png";
    private int coordenadaX = 700;
    private int coordenadaY = 300;
    private int posicion = 1;
    private final int ancho = 60;
    private final int alto = 60;
    
    public String getImagen() {
        return imagen;
    }

    public int getCoordenadaX() {
        return this.coordenadaX;
    }

    public int getCoordenadaY() {
        return this.coordenadaY;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    

    @Override
    public void update() {
        if (posicion == 1){
            this.coordenadaY = 100;
            this.coordenadaX = 100;
            this.posicion = 2;
        }else{
            this.coordenadaY = 500;
            this.coordenadaX = 700;
            this.posicion = 1;
        }        
    }
}
