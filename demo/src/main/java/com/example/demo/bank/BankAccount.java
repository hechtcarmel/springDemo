package com.example.demo.bank;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class BankAccount {
    UUID id;
    String name;
    
}
