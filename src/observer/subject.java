package observer;

public interface subject {
    public void attach(colisionPocima observador);
    public void dettach(colisionPocima observador);
    public void notifyObserver();
}
