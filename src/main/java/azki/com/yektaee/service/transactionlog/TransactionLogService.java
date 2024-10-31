package azki.com.yektaee.service.transactionlog;

import azki.com.yektaee.model.TransactionLogModel;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionLogService {

    void save(TransactionLogModel model);

}
