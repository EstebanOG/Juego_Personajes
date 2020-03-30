package objetosMapa;

import animacion.Personaje;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Bola {
    private String imagen = "/assets/BolaFuego.png";
    private int x;
    private int y;
    private int dx=1, dy=1;
    private final int Ancho = 50;
    private final int Alto = 50;

    public Bola(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Rectangle2D getPelota(){
        return new Rectangle2D.Double(x,y,Ancho,Alto);
    }

    public String getImagen() {
        return imagen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void mover(Rectangle limites, boolean colision, Personaje personaje){
        x += dx;
        y += dy;
        limites.setSize(857, 620);
        if(colision==true){
            x = 0;
            y = (int)(Math.random()*600);
            if(personaje.getEscudo()==0)
                personaje.setVida(personaje.getVida()-20);
            else if(personaje.getEscudo()<=20){
                personaje.setEscudo(0);
            }else{
                personaje.setEscudo(personaje.getEscudo()-20);
            }
        }
        if(x>limites.getMaxX()){
            dx = -dx;
        }
        if (y > limites.getMaxY()) {
            dy = -dy;
        }
        if(x<0){
            dx= -dx;
        }
        if(y<0){
            dy= -dy;
        }
    }
    public void moverDos(Rectangle limites, boolean colision,boolean colisionDos, Personaje personaje, Personaje personajeDos){
        x += dx;
        y += dy;
        limites.setSize(900, 700);
        if (colision == true) {
            x = 0;
            y = (int) (Math.random() * 600);
            if (personaje.getEscudo() == 0) {
                personaje.setVida(personaje.getVida() - 20);
            } else if (personaje.getEscudo() <= 20) {
                personaje.setEscudo(0);
            } else {
                personaje.setEscudo(personaje.getEscudo() - 20);
            }
        }else if (colisionDos == true){
            x = 0;
            y = (int) (Math.random() * 600);
            if (personajeDos.getEscudo() == 0) {
                personajeDos.setVida(personajeDos.getVida() - 20);
            } else if (personajeDos.getEscudo() <= 20) {
                personajeDos.setEscudo(0);
            } else {
                personajeDos.setEscudo(personajeDos.getEscudo() - 20);
            }
        }else{
                
                }
        if (x > limites.getMaxX()) {
            dx = -dx;
        }
        if (y > limites.getMaxY()) {
            dy = -dy;
        }
        if (x < 0) {
            dx = -dx;
        }
        if (y < 0) {
            dy = -dy;
        }
    }
}
