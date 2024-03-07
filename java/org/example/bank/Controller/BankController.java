package org.example.bank.Controller;

import org.example.bank.Api.ApiMessage;
import org.example.bank.Model.Bank;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank")
public class BankController {
    ArrayList<Bank> customer=new ArrayList<>();
@GetMapping("/get")
    public ArrayList<Bank> getCustomer(){
        return customer;
    }

    @PostMapping("/add")
    public ApiMessage addCustomer(@RequestBody Bank bank){
    customer.add(bank);
    return new ApiMessage("Customer added successfully");
    }
@PutMapping("/update/{index}")
    public ApiMessage updateCustomer(@PathVariable int index,@RequestBody Bank bank){
    customer.set(index,bank);

    return new ApiMessage("Updated");
}

@DeleteMapping("/delete/{index}")
    public ApiMessage deleteCustomer(@PathVariable int index){
    customer.remove(index);
    return new ApiMessage("Data Deleted");
}
@PutMapping("/depo")
    public ApiMessage deposit(@RequestBody int amount ,Bank bank){
        int new_Balance=0;
        if(amount>0){
            new_Balance=amount+bank.getBalance();
        }
        return new ApiMessage("Successfull transiction  "+new_Balance);
    }



//    public int credit(int amount){
//        if(amount>Balance){
//            System.out.printf("The balance is low");
//        }else if(amount<=Balance){
//            Balance=Balance-amount;
////        System.out.println("The updated balance : "+new_Balance);
//        }
//
//        return Balance;
//    }
}
