package azki.com.yektaee.mapper;

import azki.com.yektaee.entity.Transaction;
import azki.com.yektaee.entity.TransactionLog;
import azki.com.yektaee.model.TransactionLogModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionLogMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "accountNumber", source = "transaction.account.accountNumber")
    TransactionLogModel toTransactionLogModel(Transaction transaction);

    TransactionLog toTransactionLog(TransactionLogModel model);

}
