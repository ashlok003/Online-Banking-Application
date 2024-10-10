package net.javaProject.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // Added for a no-argument constructor
public class Accountdto {
    private long id;
    private String accountHolderName;
    private double balance;
}
