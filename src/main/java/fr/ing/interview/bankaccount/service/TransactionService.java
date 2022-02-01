package fr.ing.interview.bankaccount.service;

import fr.ing.interview.bankaccount.generator.model.TransactionDTO;
import fr.ing.interview.bankaccount.model.Account;
import fr.ing.interview.bankaccount.model.TransactionType;

import java.util.List;

public interface TransactionService {
    void save(TransactionDTO transactionDTO, Account account, TransactionType transactionType);
    List<TransactionDTO> diplayTransaction(Account account);
}
