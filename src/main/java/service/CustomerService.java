package service;

import Model.Customer;
import Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
  @Autowired
  private CustomerRepository customerRepository;

  public Customer addCustomer(Customer customer)
  {
    try
    {
      return customerRepository.save(customer);
    }
    catch(Exception e)
    {
      System.out.println(e);
      return null;
    }
  }
  public void deleteCustomer(int id)
  {
    try {
      if (customerRepository.existsById(id)) {
        customerRepository.deleteById(id);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage()); // Eller brug logger
    }
  }

  public List<Customer> getAllCustomers()
  {
    return customerRepository.findAll();
  }
  public Customer getCustomerbyId(int id)
  {
    return customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));
  }
}
