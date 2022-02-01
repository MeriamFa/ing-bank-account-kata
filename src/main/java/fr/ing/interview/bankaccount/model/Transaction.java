package fr.ing.interview.bankaccount.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Column(name = "id", updatable = false, nullable = false )
    @Id
    private String id;


    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_TRANSACTION")
    private LocalDate date;


    @Column(name = "TRANSACTION_AMOUNT")
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
