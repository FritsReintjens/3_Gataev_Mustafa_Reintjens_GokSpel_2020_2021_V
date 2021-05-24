package model.observer;

/**
 * @Author team
 */

public interface Observable {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}
