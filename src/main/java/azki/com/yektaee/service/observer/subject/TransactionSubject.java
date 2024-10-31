package azki.com.yektaee.service.observer.subject;

import azki.com.yektaee.service.observer.obserer.TransactionObserver;

public interface TransactionSubject {

    void addObserver(TransactionObserver observer);

    void removeObserver(TransactionObserver observer);

    void notifyObservers();

}
