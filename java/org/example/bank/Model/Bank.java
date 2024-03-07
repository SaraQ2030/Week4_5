package org.example.bank.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bank {
    private int id;
    private String userName;
    private int balance;
}
