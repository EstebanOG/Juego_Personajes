package objetosMapa;

import observer.colisionCofre;

public class Cofre implements colisionCofre{
    private String imagen = "/assets/cofre.png";
    private int coordenadaX = 0;
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
            this.coordenadaX = 833;
            this.coordenadaY = 300;
            this.posicion = 2;
        }else if(posicion == 2){
            this.coordenadaX = 410;
            this.coordenadaY = 0;
            this.posicion = 3;
        }else if(posicion == 3){
            this.coordenadaX = 410;
            this.coordenadaY = 610;
            this.posicion = 4;
        }else{
            this.coordenadaX = 0;
            this.coordenadaY = 330;
            this.posicion = 1;
        }
            
           
    }
}
