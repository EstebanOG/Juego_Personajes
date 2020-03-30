package colisiones;

import animacion.Personaje;
import chainOfResponsability.Verificar;
import decorator.ElfoDecorator;
import decorator.EnanoDecorator;
import decorator.HumanoDecorator;
import decorator.OrcoDecorator;
import static gui.recreacion.eleccion;
import java.awt.Rectangle;
import objetosMapa.Cofre;
import observer.AlarmaColisionPocima;
import objetosMapa.Pocima;
import observer.AlarmaColisionCofre;

public class EvaluarColisiones {
    public Rectangle rect;
    public Rectangle rectPj;
    public Rectangle rectCofre;
    public Rectangle ataque;
    public boolean colision, colisionCofre;
    private Personaje personaje;
    public Verificar verificar;
    private int i = 1;

    public EvaluarColisiones() {
    }

    public boolean evaluarColisionPocima(Rectangle rect, Rectangle rectPj,  Pocima pocima, Verificar aumentoPorPocima, Personaje personaje){
        colision = rect.intersects(rectPj);
        if(colision){
            if((i%2)!=0){
            //Se usa aumentoPorPocima para evaluar si aumentar escudo o vida por medio de Cadena de responsailidad
            aumentoPorPocima.operacion(personaje.getVida(), personaje.getEscudo(), personaje);
            }
            i+=1;
            AlarmaColisionPocima a = new AlarmaColisionPocima();
            a.attach(pocima);
            a.notifyObserver();
        }
        return colision;
    }
    public void evaluarColisionCofre(Rectangle rectCofre, Rectangle ataque, Cofre cofre){
        colisionCofre = ataque.intersects(rectCofre);
        if(colisionCofre){
            AlarmaColisionCofre b = new AlarmaColisionCofre();
            b.attach(cofre);
            b.notifyObserver();
        }
    }
    
    public Personaje personajeDecorado(Personaje personaje){
        switch (eleccion) {
            case "Orco":
                personaje = new OrcoDecorator(personaje);
                break;
            case "Humano":
                personaje = new HumanoDecorator(personaje);
                break;
            case "Elfo":
                personaje = new ElfoDecorator(personaje);
                break;
            case "Enano":
                personaje = new EnanoDecorator(personaje);
                break;
        }
        return personaje;
    }    
}
