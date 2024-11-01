package azki.com.yektaee.service.observer.subject;

import azki.com.yektaee.model.TransactionLogModel;
import azki.com.yektaee.service.observer.obserer.TransactionObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TransactionNotifier implements TransactionSubject {

    private List<TransactionObserver> observerList = new ArrayList<>();

    private TransactionLogModel transactionLogModel;

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

    public void changeState(TransactionLogModel transactionLogModel) {
        this.transactionLogModel = transactionLogModel;
        notifyObservers();
    }
}
