package gui;

import javax.swing.JFrame;
import objetosMapa.Hilo;

public class Ventana extends JFrame{
    private final int AnchoVentana = 900;
    private final int AltoVentana = 700;
    private recreacion lamina;
    private Hilo hilo;
    public Ventana(){
        setTitle("Juego");
        setSize(AnchoVentana, AltoVentana);
        setLocationRelativeTo(null);
        setResizable(false);
        lamina = new recreacion();
        add(lamina);
        hilo = new Hilo(lamina);
        hilo.start();
    }
}
