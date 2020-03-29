package objetosMapa;

import gui.recreacion;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hilo extends Thread{
    recreacion lamina;
    public Hilo(recreacion lamina){
        this.lamina = lamina;
    }
    
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
        }
    }
}
