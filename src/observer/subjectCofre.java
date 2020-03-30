package observer;

public interface subjectCofre {
    public void attach(colisionCofre observadorCofre);
    public void dettach(colisionCofre observadorCofre);
    public void notifyObserver();
}
