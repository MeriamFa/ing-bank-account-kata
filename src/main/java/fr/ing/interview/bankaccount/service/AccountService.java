package fr.ing.interview.bankaccount.service;

import fr.ing.interview.bankaccount.model.Account;

public interface AccountService {
    void deposit(String accountId, Double amount);
    Account retrieve(String accountId);
    void withDraw(String accountId, Double amount);
}
