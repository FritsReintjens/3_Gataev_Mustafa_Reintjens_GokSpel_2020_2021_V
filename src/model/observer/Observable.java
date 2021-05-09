package model.observer;

public interface Observable {
    public void registerObserver();
    public void removeObserver();
    public void notifyObserver();
}
