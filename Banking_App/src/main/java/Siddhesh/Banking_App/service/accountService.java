package Siddhesh.Banking_App.service;

import Siddhesh.Banking_App.entity.accounts;
import Siddhesh.Banking_App.repository.accountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class accountService {

    @Autowired
    private accountRepository repository;

    public ResponseEntity<accounts> create(@RequestBody accounts acc){
        repository.save(acc);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public List<accounts> getAllAccounts(){
        return repository.findAll();
    }

    public accounts getAccount(Long id){
        return repository.getReferenceById(id);
    }

    public Double withdraw(Long id, Double amt){
        accounts acc = repository.getReferenceById(id);
        Double curr = acc.getBalance();
        curr -= amt;
        acc.setBalance(curr);
        repository.save(acc);
        return amt;
    }

    public Boolean deposit(Long id, Double amt){
        accounts acc = repository.getReferenceById(id);
        Double curr = acc.getBalance();
        curr += amt;
        acc.setBalance(curr);
        repository.save(acc);
        return true;
    }

    public ResponseEntity<?> delete(Long id) {
        accounts acc = repository.getReferenceById(id);
        repository.delete(acc);
        return ResponseEntity.ok().build();
    }
}
