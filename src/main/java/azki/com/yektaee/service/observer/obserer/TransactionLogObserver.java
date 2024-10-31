package azki.com.yektaee.service.observer.obserer;

import azki.com.yektaee.model.TransactionLogModel;
import azki.com.yektaee.service.transactionlog.TransactionLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class TransactionLogObserver implements TransactionObserver {

    private final TransactionLogService transactionLogService;

    @Transactional
    @Override
    public void update(TransactionLogModel model) {
        transactionLogService.save(model);
    }
}
