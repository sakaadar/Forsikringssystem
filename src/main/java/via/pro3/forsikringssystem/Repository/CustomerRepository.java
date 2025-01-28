package via.pro3.forsikringssystem.Repository;

import via.pro3.forsikringssystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface CustomerRepository
    extends JpaRepository<Customer, Integer>
{
  Customer findByEmail(String email);
}
