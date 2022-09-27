package com.udea.GestionFinanciera.Service;

import com.udea.GestionFinanciera.Dto.TransactionDto;
import com.udea.GestionFinanciera.Entity.Transaction;
import com.udea.GestionFinanciera.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImp implements TransactionServiceI {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public String crearTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionDto.toEntity();
        transaction.setCreatedAt(new Date());
        transactionRepository.save(transaction);
        return "Transaction creada exitosamente";
    }

    @Override
    public List<Transaction> consultarTransactionAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction consultarTransactionById(Long id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public String eliminarTransactionById(Long id) {
        transactionRepository.deleteById(id);
        return "Transaction eliminada exitosamente";
    }

}
