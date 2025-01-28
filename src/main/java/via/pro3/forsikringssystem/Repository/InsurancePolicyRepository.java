package via.pro3.forsikringssystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import via.pro3.forsikringssystem.Model.InsurancePolicy;

@Repository public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer>
{
}
