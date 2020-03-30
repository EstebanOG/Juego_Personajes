
package objetosMapa;

import java.awt.geom.Rectangle2D;

public class RectPersonaje {
    private int x,y;
    private final int Ancho = 52;
    private final int Alto = 80;

    public RectPersonaje(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Rectangle2D getRectPersonaje(){
        return new Rectangle2D.Double(x, y, Ancho, Alto);      
    }
}
