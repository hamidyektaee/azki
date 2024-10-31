package azki.com.yektaee.service.transactionlog;

import azki.com.yektaee.entity.TransactionLog;
import azki.com.yektaee.mapper.TransactionLogMapper;
import azki.com.yektaee.model.TransactionLogModel;
import azki.com.yektaee.repository.TransactionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionLogServiceImpl implements TransactionLogService {

    private final TransactionLogMapper transactionLogMapper;

    private final TransactionLogRepository transactionLogRepository;

    @Override
    public void save(TransactionLogModel model) {
        TransactionLog transactionLog = transactionLogMapper.toTransactionLog(model);
        transactionLogRepository.save(transactionLog);
    }
}
