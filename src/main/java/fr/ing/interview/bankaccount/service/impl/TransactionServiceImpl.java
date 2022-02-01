package fr.ing.interview.bankaccount.service.impl;

import fr.ing.interview.bankaccount.generator.model.TransactionDTO;
import fr.ing.interview.bankaccount.mapper.TransactionMapper;
import fr.ing.interview.bankaccount.model.Account;
import fr.ing.interview.bankaccount.model.Transaction;
import fr.ing.interview.bankaccount.model.TransactionType;
import fr.ing.interview.bankaccount.repository.TransactionRepository;
import fr.ing.interview.bankaccount.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void save(TransactionDTO transactionDTO, Account account,TransactionType transactionType) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(transactionDTO.getAmount().doubleValue());
        transaction.setDate(LocalDate.now());
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionDTO> diplayTransaction(Account account) {
         return !CollectionUtils.isEmpty(account.getTransactions()) ? account.getTransactions().stream()
                 .map(transactionMapper::tansactionToDto)
                 .collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }


}
