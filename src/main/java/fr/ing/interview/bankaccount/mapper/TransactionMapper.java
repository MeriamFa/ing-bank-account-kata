package fr.ing.interview.bankaccount.mapper;

import fr.ing.interview.bankaccount.generator.model.TransactionDTO;
import fr.ing.interview.bankaccount.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public abstract class TransactionMapper {

    public abstract Transaction dtoToTransaction(TransactionDTO transactionDTO);

    public abstract TransactionDTO tansactionToDto(Transaction transaction);

}
