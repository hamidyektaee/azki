package azki.com.yektaee.service.observer.obserer;

import azki.com.yektaee.model.TransactionLogModel;

public interface TransactionObserver {

    void update(TransactionLogModel model);
}
