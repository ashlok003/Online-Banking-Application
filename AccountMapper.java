package net.javaProject.banking.mapper;

import net.javaProject.banking.dto.Accountdto;
import net.javaProject.banking.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(Accountdto accountdto) {
        if (accountdto == null) {
            return null; // Handle null input gracefully
        }
        return new Account(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );
    }

    public static Accountdto mapToAccountdto(Account account) {
        if (account == null) {
            return null; // Handle null input gracefully
        }
        return new Accountdto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
