package via.pro3.forsikringssystem.Controller;

import via.pro3.forsikringssystem.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import via.pro3.forsikringssystem.service.CustomerService;
import via.pro3.forsikringssystem.service.InsurancePolicyService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping public Customer createCustomer(@RequestBody Customer customer)
  {

   return customerService.addCustomer(customer);
  }

  @GetMapping public List<Customer> getAllCustomers()
  {
    return customerService.getAllCustomers();
  }
  @GetMapping("/id")
  public Customer getCustomerById(@PathVariable int id)
  {
    return customerService.getCustomerbyId(id);

  }
  @DeleteMapping("/id")
  public void deleteCustomer(@PathVariable int id)
  {
    customerService.deleteCustomer(id);
  }
}
