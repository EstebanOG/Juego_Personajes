package objetosMapa;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Bola {
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
    
    public void mover(Rectangle limites, boolean colision){
        x += dx;
        y += dy;
        if(colision==true){
            x = 0;
            y = (int)(Math.random()*600);
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
}
