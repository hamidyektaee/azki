package azki.com.yektaee.mapper;


import azki.com.yektaee.entity.Transaction;
import azki.com.yektaee.enums.FinancialType;
import azki.com.yektaee.model.AccountModel;
import azki.com.yektaee.model.TransactionModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(source = "accountModel", target = "account")
    @Mapping(source = "financialType", target = "financialType")
    Transaction toTransaction(TransactionModel transactionModel, AccountModel accountModel, FinancialType financialType);

    TransactionModel toTransactionModel(Transaction transaction);

}
