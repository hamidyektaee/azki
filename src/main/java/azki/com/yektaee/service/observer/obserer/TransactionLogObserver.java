package azki.com.yektaee.service.observer.obserer;

import azki.com.yektaee.model.TransactionLogModel;
import azki.com.yektaee.service.transactionlog.TransactionLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionLogObserver implements TransactionObserver {

    private final TransactionLogService transactionLogService;

    public void update(TransactionLogModel model) {
        transactionLogService.save(model);
    }
}
