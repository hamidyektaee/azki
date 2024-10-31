package azki.com.yektaee.service.transaction;

import azki.com.yektaee.model.TransactionModel;
import org.springframework.transaction.annotation.Transactional;

public interface TransactionService {

    @Transactional
    void transaction(TransactionModel model);

}
