package net.javaProject.banking.controller;


import net.javaProject.banking.dto.Accountdto;
import net.javaProject.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    // Add account rest API
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
       return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }
    // Get account rest API
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountbyId(@PathVariable Long id){
        Accountdto accountdto = accountService.getAllAccountBYId(id);
        return ResponseEntity.ok(accountdto);
    }
    // Deposit Rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        Accountdto accountdto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountdto);
    }
    // withDraw Rest API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        Accountdto accountdto = accountService.withdraw(id, amount);
        return  ResponseEntity.ok(accountdto);
    }

    // Get all accounts Rest API
    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccounts(){
        List<Accountdto> accounts =  accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete account Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is deleted successfully");
    }
}
