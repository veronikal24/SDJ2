package Assignment3_final.client.common;

public interface Subject {
    void attachObserver( Observer observer );

    void detachObserver( Observer observer);

    void notifyObservers();
}
