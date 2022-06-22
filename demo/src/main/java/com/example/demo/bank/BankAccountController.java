package com.example.demo.bank;

import java.util.UUID;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Controller
public class BankAccountController {

	@QueryMapping
  public BankAccount bankAccount(UUID id){
    System.out.println("BBBBBBBBBBBBBBBBB");
    return BankAccount.builder().id(id).name("George").build();
}

  @QueryMapping
  public BankAccount bankAccountPhilip(){
    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    return BankAccount.builder().id(UUID.fromString("9e4e6eda-e290-483c-bf79-799585019698")).name("Philip").build();
}
	
}

