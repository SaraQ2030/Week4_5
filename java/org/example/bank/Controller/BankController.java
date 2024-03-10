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
@PutMapping("/depo/{id}/{amount}")
    public ApiMessage deposit(@PathVariable int id ,@PathVariable int amount) {
    for (Bank c : customer) {
        if (c.getId() == id) {
            if (amount > 0) {
           int new_balance=0;
           new_balance=c.getBalance()+amount;
                c.setBalance(new_balance);
                return new ApiMessage("Successfully transaction the new balance =  " + c.getBalance());
             }
        }
    }
        return new ApiMessage("The customer not found");

}
@PutMapping("with/{id}/{amount}")
public ApiMessage withdraw(@PathVariable int id,@PathVariable int amount){
    for (Bank c:customer){
        if (c.getId()==id){
            if (c.getBalance()>amount){
                int new_balance=0;
                new_balance=c.getBalance()-amount;
                c.setBalance(new_balance);
                return new ApiMessage("Successful withdraw " + c.getBalance());
            }
        }
    }return new ApiMessage("Customer not found ");
}



}
