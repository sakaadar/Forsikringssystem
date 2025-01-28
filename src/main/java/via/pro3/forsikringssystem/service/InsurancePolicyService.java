package via.pro3.forsikringssystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import via.pro3.forsikringssystem.Model.InsurancePolicy;
import via.pro3.forsikringssystem.Repository.InsurancePolicyRepository;

import java.util.List;

@Service
public class InsurancePolicyService
{
  @Autowired
  private InsurancePolicyRepository insurancePolicyRepository;

  public InsurancePolicy savePolicy(InsurancePolicy policy)
  {
    return insurancePolicyRepository.save(policy);
  }
  //Gem en liste af policies
  public List<InsurancePolicy> savePolicies(List<InsurancePolicy> policies)
  {
    return insurancePolicyRepository.saveAll(policies);
  }
  // Hent en policy ud fra ID
  public InsurancePolicy getPolicy(int id)
  {
    return insurancePolicyRepository.findById(id).orElse(null);
  }


  // Hent alle policies
public List<InsurancePolicy> getAllPolicies(){
    return insurancePolicyRepository.findAll();
}

  // Slet en policy
public void deletePolicy(int id)
{
  insurancePolicyRepository.deleteById(id);
}
}
