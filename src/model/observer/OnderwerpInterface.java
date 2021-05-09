package model.observer;

public interface OnderwerpInterface {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver(Observer observer);
}
