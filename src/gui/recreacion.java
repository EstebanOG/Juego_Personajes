package gui;

import animacion.*;
import chainOfResponsability.Verificar;
import colisiones.EvaluarColisiones;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import objetosMapa.Hilo;
import objetosMapa.Bola;
import objetosMapa.Cofre;
import observer.AlarmaColisionPocima;
import objetosMapa.Pocima;
import objetosMapa.RectPersonaje;
import state.EstadoPersonaje;
import state.Herido;
import state.Moribundo;
import state.Vigoroso;
import strategy.StrategyNormal;
import strategy.StrategyDecorado;
import strategy.Strategy;

public class recreacion extends JPanel {

    static Personaje personaje;
    public Verificar aumentoPorPocima = new Verificar();//Se crea un objeto de la clase Verificar la cual se encuentra ChainOfResponsability
    Strategy clonarVida; // Objeto de la clase Strategy
    /*Se definen los objetos de las clases que se encargan de verificar el estado del personaje*/
    EstadoPersonaje estadoPersonaje = new EstadoPersonaje();
    Herido personajeHerido = new Herido();
    Moribundo personajeMoribundo = new Moribundo();
    Vigoroso personajeVigoroso = new Vigoroso();
    /*******************************************************************************************/
    EvaluarColisiones evaluarColisiones = new EvaluarColisiones();
    Pocima pocima = new Pocima();
    Cofre cofre = new Cofre();
    Font fuenteVida = new Font("Calibri", 3, 16);// Fuente vida
    Font fuenteEscudo = new Font("Calibri", 3, 16);// Fuente escudo
    Font fuentePuntaje = new Font("Arial", 3, 19);//Fuente puntaje
    static ArrayList<Personaje> personajetemp = new ArrayList<>();
    static ArrayList<Object> arreglo_personajes = new ArrayList<>();
    private final int AnchoVentana = 900;
    private final int AltoVentana = 700;
    //Thread hilo;
    boolean inicio = false;
    BufferedImage bi;
    Image img, fondo, pocion, bolaFuego,cofreImagen;
    Toolkit h = Toolkit.getDefaultToolkit();
    Graphics2D g2d;
    int Incremento = 0;
    int incx = 340;
    int incy = 230;
    boolean arriba = true;
    boolean abajo = true;
    boolean izquierda = true;
    boolean derecha = true;
    boolean ataca = false;
    String[] posicion = {"derecha", "derecha"};
    public static String eleccion;
    public static String poblacion;
    public static boolean clonar = false;
    static Animacion animar = new Animacion();
    int i = 0;
    boolean colision = false;
    boolean colisionPocima = false;
    Rectangle rect = new Rectangle(700, 500, 30, 20);
    Rectangle rectPj = new Rectangle(340, 230, 52, 80);
    Rectangle rectCofre = new Rectangle(0, 300, 60, 60);
    Bola pelota = new Bola(0,0);
    Bola pelotaUno = new Bola(10,600);
    Bola pelotaDos = new Bola(300,10);
    Bola pelotaTres = new Bola(600,10);
    Bola pelotaCuatro = new Bola(10,320);
    RectPersonaje personajeOriginal = new RectPersonaje(340,230);
    Rectangle ataque = new Rectangle(300, 230, 52, 80);
    String Puntaje;
    boolean fin = false;
    boolean entra = true;
    int vida=0;
    public recreacion() {
        fondo = h.getImage(this.getClass().getResource("/assets/map.png"));
        pocion = h.getImage(this.getClass().getResource(pocima.getImagen()));
        bolaFuego = h.getImage(this.getClass().getResource("/assets/BolaFuego.png"));
        cofreImagen = h.getImage(this.getClass().getResource("/assets/cofre.png"));
        bi = new BufferedImage(AnchoVentana, AltoVentana, BufferedImage.TYPE_INT_RGB);
        //img = h.getImage(this.getClass().getResource(personaje.getDerecha()));
        
        inicio = true;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        posicion[0] = posicion[1];
                        posicion[1] = "arriba";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getArriba()));
                        Incremento++;
                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (arriba == true) {
                            incy = incy - 4;
                            if (incy < 20) {
                                incy = incy + 4;
                            }
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        posicion[0] = posicion[1];
                        posicion[1] = "abajo";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getAbajo()));

                        Incremento++;

                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (abajo == true) {
                            incy = incy + 4;
                            if (incy > getHeight() - 40) {
                                incy = incy - 4;
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        posicion[0] = posicion[1];
                        posicion[1] = "derecha";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getDerecha()));
                        Incremento++;
                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (derecha == true) {
                            incx = incx + 4;
                            if (incx > getWidth() - 15) {
                                incx = incx - 10;
                            }
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        posicion[0] = posicion[1];
                        posicion[1] = "izquierda";
                        ataca = false;
                        img = h.getImage(this.getClass().getResource(personaje.getIzquierda()));
                        Incremento++;
                        if (Incremento > 4) {
                            Incremento = 0;
                        }
                        if (izquierda = true) {
                            incx = incx - 4;
                            if (incx < -4) {
                                incx = incx + 4;
                            }
                        }
                        break;
                    case KeyEvent.VK_C:
                        posicion[0] = posicion[1];
                        switch (posicion[1]) {
                            case "arriba":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaArriba()));
                                break;
                            case "abajo":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaAbajo()));
                                break;
                            case "derecha":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaDerecha()));
                                break;
                            case "izquierda":
                                img = h.getImage(this.getClass().getResource(personaje.getAtacaIzquierda()));
                                break;
                        }
                        ataca = true;
                        Incremento = Incremento + 5;
                        if (Incremento > 5) {
                            Incremento = 0;
                        }
                        break;
                    case KeyEvent.VK_Q:
                        //personajetemp.clear();
                        for (i = 0; i < arreglo_personajes.size(); i++) {
                            personajetemp.add((Personaje) arreglo_personajes.get(i));
                            if (arreglo_personajes.size() < 2) {//Se clona el personaje, máximo un clon
                                /*Se utiliza Strategy para evaluar la vida que se le baja a ambos personajes*/
                                /*Si está decorado se le baja 20 de vida al clonar*/
                                /*Si está normal se le baja 40 de vida al clonar*/
                                /*Con la variable entra se evalua si cogio la pocima o no*/
                                if (entra == true) {
                                    clonarVida = new StrategyNormal(personajetemp.get(i));
                                    clonarVida.vidaEscudo();
                                } else {
                                    clonarVida = new StrategyDecorado(personajetemp.get(i));
                                    clonarVida.vidaEscudo();
                                }
                                Personaje personajeClonUno = (Personaje) personajetemp.get(i).clonar();
                                arreglo_personajes.add(personajeClonUno);
                            }
                        }
                        break;

                }
            }
        });
        setFocusable(true);
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(bi, 0, 0, null);
        int mxA, myA, y = 0, aumentoSpriteY;
        vida = personajetemp.get(1).getVida();
        Puntaje = Integer.toString(evaluarColisiones.Score);
        System.out.println(Puntaje);
        g2d = bi.createGraphics();
        g2d.drawImage(fondo, 0, 0, AnchoVentana, AltoVentana, this);
        g2d.setFont(fuentePuntaje);//Fuente del puntaje
        g2d.setColor(Color.BLACK);//Color del puntaje
        g2d.drawString(String.valueOf("Puntaje: " + Puntaje), 750, 50);//Pinta puntaje
        g2d.drawImage(bolaFuego, pelota.getX()-5, pelota.getY()-5, 60,60,this);
        g2d.drawImage(bolaFuego, pelotaUno.getX()-5, pelotaUno.getY()-5, 60,60,this);
        g2d.drawImage(bolaFuego, pelotaDos.getX()-5, pelotaDos.getY()-5, 60,60,this);
        g2d.drawImage(bolaFuego, pelotaTres.getX()-5, pelotaTres.getY()-5, 60,60,this);
        g2d.drawImage(bolaFuego, pelotaCuatro.getX()-5, pelotaCuatro.getY()-5, 60,60,this);
        g2d.drawImage(pocion, pocima.getCoordenadaX(), pocima.getCoordenadaY(), pocima.getAlto(), pocima.getAncho(), this);

//        g2d.drawRect(cofre.getCoordenadaX(), cofre.getCoordenadaY(), cofre.getAlto(), cofre.getAncho());
        g2d.draw(rectCofre);
        //g2d.drawImage(pocion, pocima.getCoordenadaX(), pocima.getCoordenadaY(), pocima.getAlto(), pocima.getAncho(), this);
        g2d.drawImage(cofreImagen, cofre.getCoordenadaX(), cofre.getCoordenadaY(), cofre.getAlto(),cofre.getAncho(), this);
        g2d.setColor(Color.red);
        dibujar(g2d);
        actualizar();
        if (1 == arreglo_personajes.size()) {
            aumentoSpriteY = 0;
        } else {
            aumentoSpriteY = 110;
        }
        for (i = 0; i < arreglo_personajes.size(); i++) {
           
            personajetemp.add((Personaje) arreglo_personajes.get(i));
            /*Se verifica el estado del personaje y cambia su daño así:
            Vigoroso(70 puntos de vida o más): Daño 50
            Herido(Más de 20 y menos de 70 puntos de vida): Daño 80
            Moribundo(20 puntos de vida o menos): Daño 100
            */
            estadoPersonaje.setPersonaje(personajetemp.get(i));
            //System.out.println(pocima.getCoordenadaX());
            if(personajetemp.get(i).getVida()>70){
                estadoPersonaje.setEstadoPersonaje(personajeVigoroso);
            }else if(personajetemp.get(i).getVida()>20){
                estadoPersonaje.setEstadoPersonaje(personajeHerido);
            }else{
                estadoPersonaje.setEstadoPersonaje(personajeMoribundo);
            }
            estadoPersonaje.verificarEstado();
            /*************************************/
            if (ataca == true) {
                switch (posicion[0]) {
                    case "arriba":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaArribaX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaArribaY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxArribaUno(), y + incy - personajetemp.get(i).getIncyArribaUno(), personajetemp.get(i).getIncxArribaDos() + incx, personajetemp.get(i).getIncyArribaDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaArribaX(), myA + personajetemp.get(i).getSpriteAtacaArribaY(), this);
                        ataque.setRect(incx,incy-30,23,50);
                        g2d.draw(ataque);
                        evaluarColisiones.evaluarColisionCofre(rectCofre, ataque, cofre);
                        rectCofre.setRect(cofre.getCoordenadaX(),cofre.getCoordenadaY(),cofre.getAlto(),cofre.getAncho());
                        break;
                    case "abajo":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaAbajoX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaAbajoY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxAbajoUno(), y + incy - personajetemp.get(i).getIncyAbajoUno(), personajetemp.get(i).getIncxAbajoDos() + incx, personajetemp.get(i).getIncyAbajoDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaAbajoX(), myA + personajetemp.get(i).getSpriteAtacaAbajoY(), this);
                        ataque.setRect(incx,incy+10,23,50);
                        g2d.draw(ataque);
                        evaluarColisiones.evaluarColisionCofre(rectCofre, ataque, cofre);
                        rectCofre.setRect(cofre.getCoordenadaX(),cofre.getCoordenadaY(),cofre.getAlto(),cofre.getAncho());
                        break;
                    case "derecha":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaDerechaX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaDerechaY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxDerechaUno(), y + incy - personajetemp.get(i).getIncyDerechaUno(), personajetemp.get(i).getIncxDerechaDos() + incx, personajetemp.get(i).getIncyDerechaDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaDerechaX(), myA + personajetemp.get(i).getSpriteAtacaDerechaY(), this);
                        ataque.setRect(incx+15,incy+10,50,23);
                        g2d.draw(ataque);
                        evaluarColisiones.evaluarColisionCofre(rectCofre, ataque, cofre);
                        rectCofre.setRect(cofre.getCoordenadaX(),cofre.getCoordenadaY(),cofre.getAlto(),cofre.getAncho());
                        break;
                    case "izquierda":
                        mxA = (Incremento % personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaIzquierdaX();
                        myA = (Incremento / personajetemp.get(i).getNumSpritesAtaque()) * personajetemp.get(i).getSpriteAtacaIzquierdaY();
                        g2d.drawImage(img, incx - personajetemp.get(i).getIncxIzquierdaUno(), y + incy - personajetemp.get(i).getIncyIzquierdaUno(), personajetemp.get(i).getIncxIzquierdaDos() + incx, personajetemp.get(i).getIncyIzquierdaDos() + incy + y, mxA, myA, mxA + personajetemp.get(i).getSpriteAtacaIzquierdaX(), myA + personajetemp.get(i).getSpriteAtacaIzquierdaY(), this);
                        ataque.setRect(incx-35,incy+10,50,23);
                        g2d.draw(ataque);
                        evaluarColisiones.evaluarColisionCofre(rectCofre, ataque, cofre);
                        rectCofre.setRect(cofre.getCoordenadaX(),cofre.getCoordenadaY(),cofre.getAlto(),cofre.getAncho());
                        break;
                }
            } else {
                mxA = (Incremento % personajetemp.get(i).getNumSpritesMov()) * personajetemp.get(i).getSpriteMoverX();
                myA = (Incremento / personajetemp.get(i).getNumSpritesMov()) * personajetemp.get(i).getSpriteMoverY();
                g2d.drawImage(img, incx - 25, incy - 25 + y, 50 + incx, y + 50 + incy, mxA, myA, mxA + personajetemp.get(i).getSpriteMoverX(), myA + personajetemp.get(i).getSpriteMoverY(), this);
                rectPj.setRect(incx-15, incy-30+y, 52, 78);
                rect.setRect(pocima.getCoordenadaX()+13, pocima.getCoordenadaY()+23, 30, 20);
                
                /*Se evalua la colision de cada personaje mediante la clase EvaluarColisiones
                y si es el caso se decora el personaje*/
                colision = evaluarColisiones.evaluarColisionPocima(rect,rectPj,pocima, aumentoPorPocima, personajetemp.get(i));
                
                if (colision == true) {
                    
                    if (entra == true) {
                       // personaje = evaluarColisiones.personajeDecorado(personaje);
                    }
                    entra = false;
                }
                
            }

            g2d.setFont(fuenteVida);//Fuente del porcentaje de vida
            g2d.setColor(Color.RED);//Color de la vida
            g2d.drawString(String.valueOf(personajetemp.get(i).getVida()) + "%", incx , incy - 30 + y);//Pinta el porcentaje de vida que tiene
            g2d.setFont(fuenteEscudo);//Fuente del porcentaje de escudo
            g2d.setColor(Color.BLUE);//Color del escudo
            g2d.drawString(String.valueOf(personajetemp.get(i).getEscudo()) + "%" , incx , incy - 40 + y);//Pinta el porcentaje de escudo que tiene
            y = y + aumentoSpriteY;
        }
        personajetemp.clear();
        repaint();
        if(vida<=1){
            JOptionPane.showMessageDialog(null,"FIN DEL JUEGO");
            
        }
    }
    public void dibujar(Graphics2D g){
        g.draw(pelota.getPelota());
        g.draw(pelotaUno.getPelota());
        g.draw(pelotaDos.getPelota());
        g.draw(pelotaTres.getPelota());
        g.draw(pelotaCuatro.getPelota());
    }
    public void actualizar(){
        pelota.mover(getBounds(),colision(rectPj, pelota),personaje);
        pelotaUno.mover(getBounds(),colision(rectPj, pelotaUno),personaje);
        pelotaDos.mover(getBounds(),colision(rectPj, pelotaDos),personaje);
        pelotaTres.mover(getBounds(),colision(rectPj, pelotaTres),personaje);
        pelotaCuatro.mover(getBounds(),colision(rectPj, pelotaCuatro),personaje);
    }
    private boolean colision(Rectangle2D r, Bola pelota){
        return pelota.getPelota().intersects(r);
    }
    public static void inicia() {
        arreglo_personajes.clear();
        personajetemp.clear();
        switch (eleccion) {
            case "Elfo":
                animar.SetPersonajeBuilder(new ElfoBuilder());
                break;
            case "Enano":
                animar.SetPersonajeBuilder(new EnanoBuilder());
                break;
            case "Humano":
                animar.SetPersonajeBuilder(new HumanoBuilder());
                break;
            case "Orco":
                animar.SetPersonajeBuilder(new OrcoBuilder());
                break;
        }
        animar.moverse();
        personaje = animar.getPersonaje();
        arreglo_personajes.add(personaje);
        if (poblacion.equals("Población")) {
            Personaje personajeClonUno = (Personaje) personaje.clonar();
            Personaje personajeClonDos = (Personaje) personaje.clonar();
            arreglo_personajes.add(personajeClonUno);
            arreglo_personajes.add(personajeClonDos);
        }
        
        new recreacion().setVisible(true);
    }
}
