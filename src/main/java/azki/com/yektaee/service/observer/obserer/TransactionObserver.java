package azki.com.yektaee.service.observer.obserer;

import azki.com.yektaee.model.TransactionLogModel;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionObserver {

    @Transactional
    public void update(TransactionLogModel model);
}
