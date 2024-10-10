package net.javaProject.banking.service;

import net.javaProject.banking.dto.Accountdto;

import java.util.List;

public interface AccountService {
    Accountdto createAccount(Accountdto accountdto);

    Accountdto getAllAccountBYId(Long id);

    Accountdto deposit(Long id, double amount);

    Accountdto withdraw(Long id, double amount);

    List<Accountdto> getAllAccounts();

    void deleteAccount(Long id);
}
