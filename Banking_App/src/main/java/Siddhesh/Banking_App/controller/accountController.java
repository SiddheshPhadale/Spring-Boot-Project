package Siddhesh.Banking_App.controller;

import Siddhesh.Banking_App.entity.accounts;
import Siddhesh.Banking_App.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class accountController {

    @Autowired
    accountService service ;

    @PutMapping
    public ResponseEntity<accounts> createAccount(@RequestBody accounts acc){
        return service.create(acc);
    }

    @GetMapping
    public List<accounts> getAll(){
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public accounts getAccountById(@PathVariable Long id){
        return service.getAccount(id);
    }

    @PostMapping("/withdraw/{id}/{amt}")
    public Double withdraw(@PathVariable Long id, @PathVariable Double amt){
        return service.withdraw(id, amt);
    }

    @PostMapping("/deposit/{id}/{amt}")
    public Boolean deposiit(@PathVariable Long id, @PathVariable Double amt){
        return service.deposit(id,amt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAcc(@PathVariable Long id){
        return service.delete(id);
    }

}
