package gui;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import objetosMapa.Hilo;

public class Ventana extends JFrame{
    private final int AnchoVentana = 1200;
    private final int AltoVentana = 700;
    private recreacion lamina;
    private Hilo hilo;
    private JLabel titulo;
    private JLabel objetivo;
    private JLabel arriba;
    private JLabel controles;
    private JLabel flechaArriba;
    private JLabel abajo;
    private JLabel flechaAbajo;
    private JLabel izquierda;
    private JLabel flechaIzquierda;
    private JLabel derecha;
    private JLabel flechaDerecha;
    private JLabel atacar;
    private JLabel teclaAtacar;
    Font font = new Font("Agency FB", Font.PLAIN, 24);
    Font font2 = new Font("Agency FB", Font.TRUETYPE_FONT, 20);
    public Ventana(){
        setTitle("Juego");
        setSize(AnchoVentana, AltoVentana);
        setLocationRelativeTo(null);
        setResizable(false);
        

        titulo = new JLabel("Objetivo:");
        titulo.setBounds(930, 10, 200, 100);
        titulo.setFont(font);
        add(titulo);
       
        objetivo = new JLabel("Destruir el mayor número de cofres");
        objetivo.setBounds(930, 40, 300, 100);
        objetivo.setFont(font2);
        add(objetivo);
        
        controles = new JLabel("Controles:");
        controles.setBounds(930, 90, 200, 100);
        controles.setFont(font);
        add(controles);
        
        arriba = new JLabel("Arriba");
        arriba.setBounds(930, 120, 200, 100);
        arriba.setFont(font2);
        add(arriba);
        
        flechaArriba = new JLabel("Flecha arriba");
        flechaArriba.setBounds(1050, 120, 200, 100);
        flechaArriba.setFont(font2);
        add(flechaArriba);
        
        abajo = new JLabel("Abajo");
        abajo.setBounds(930, 160, 200, 100);
        abajo.setFont(font2);
        add(abajo);
        
        flechaAbajo = new JLabel("Flecha abajo");
        flechaAbajo.setBounds(1050, 160, 200, 100);
        flechaAbajo.setFont(font2);
        add(flechaAbajo);
        
        izquierda = new JLabel("Izquierda");
        izquierda.setBounds(930, 200, 200, 100);
        izquierda.setFont(font2);
        add(izquierda);

        flechaIzquierda = new JLabel("Flecha izquierda");
        flechaIzquierda.setBounds(1050, 200, 200, 100);
        flechaIzquierda.setFont(font2);
        add(flechaIzquierda);
        
        derecha = new JLabel("Derecha");
        derecha.setBounds(930, 240, 200, 100);
        derecha.setFont(font2);
        add(derecha);

        flechaDerecha = new JLabel("Flecha derecha");
        flechaDerecha.setBounds(1050, 240, 200, 100);
        flechaDerecha.setFont(font2);
        add(flechaDerecha);
        
        atacar = new JLabel("Ataque");
        atacar.setBounds(930, 280, 200, 100);
        atacar.setFont(font2);
        add(atacar);

        teclaAtacar = new JLabel("Tecla C");
        teclaAtacar.setBounds(1050, 280, 200, 100);
        teclaAtacar.setFont(font2);
        add(teclaAtacar);
        lamina = new recreacion();
        add(lamina);
        hilo = new Hilo(lamina);
        hilo.start();
        
    }
}
