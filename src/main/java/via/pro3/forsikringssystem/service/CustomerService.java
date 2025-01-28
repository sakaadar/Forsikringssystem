package via.pro3.forsikringssystem.service;

import jakarta.transaction.Transactional;
import via.pro3.forsikringssystem.Model.Customer;
import via.pro3.forsikringssystem.Model.InsurancePolicy;
import via.pro3.forsikringssystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService
{
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private InsurancePolicyService insurancePolicyService;


  @Transactional
  public Customer addCustomer(Customer customer) {
    try {
      // 1️⃣ Gem kunden først
      Customer savedCustomer = customerRepository.save(customer);
      System.out.println("✅ Customer gemt med ID: " + savedCustomer.getId());

      // 2️⃣ Sikr, at policies ikke er null
      if (customer.getPolicies() != null && !customer.getPolicies().isEmpty()) {
        List<InsurancePolicy> updatedPolicies = new ArrayList<>();

        for (InsurancePolicy policy : customer.getPolicies()) {
          policy.setCustomer(savedCustomer); // 🔥 Sæt customer reference

          // 📌 Debugging: Udskriv om customer faktisk bliver sat
          System.out.println("🔍 InsurancePolicy ID: " + policy.getId() +
              " | Customer ID: " + (policy.getCustomer() != null ? policy.getCustomer().getId() : "NULL"));

          updatedPolicies.add(policy);
        }

        // 3️⃣ Gem policies
        List<InsurancePolicy> savedPolicies = insurancePolicyService.savePolicies(updatedPolicies);

        // 4️⃣ Opdater customer med de gemte policies
        savedCustomer.setPolicies(savedPolicies);
        return customerRepository.save(savedCustomer);
      }

      return savedCustomer;
    } catch (Exception e) {
      throw new RuntimeException("Kunne ikke gemme kunden", e);
    }
  }


  public void deleteCustomer(int id)
  {
    try {
      if (customerRepository.existsById(id)) {
        customerRepository.deleteById(id);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
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
