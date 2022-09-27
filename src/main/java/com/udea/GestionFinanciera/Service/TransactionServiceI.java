package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.TransactionDto;
import com.udea.GestionFinanciera.Entity.Transaction;

import java.util.List;

public interface TransactionServiceI {

    public String crearTransaction(TransactionDto transactionDto);
    public List<Transaction> consultarTransactionAll();
    public Transaction consultarTransactionById(Long id);
    public String eliminarTransactionById(Long id);

}
