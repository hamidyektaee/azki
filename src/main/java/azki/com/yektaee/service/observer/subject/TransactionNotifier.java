package azki.com.yektaee.service.observer.subject;

import azki.com.yektaee.model.TransactionLogModel;
import azki.com.yektaee.service.observer.obserer.TransactionObserver;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TransactionNotifier implements TransactionSubject {

    List<TransactionObserver> observerList = new ArrayList<>();

    private final TransactionLogModel transactionLogModel;

    @Override
    public void addObserver(TransactionObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(TransactionObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(observer -> observer.update(transactionLogModel));
    }
}
