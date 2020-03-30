package colisiones;

import animacion.Personaje;
import chainOfResponsability.Verificar;
import decorator.ElfoDecorator;
import decorator.EnanoDecorator;
import decorator.HumanoDecorator;
import decorator.OrcoDecorator;
import static gui.recreacion.eleccion;
import java.awt.Rectangle;
import observer.AlarmaColisionPocima;
import objetosMapa.Pocima;

public class EvaluarColisiones {
    public Rectangle rect;
    public Rectangle rectPj;
    public boolean colision;
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
    public void evaluarColisionBolas(){
        
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
