package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CustomerService;

@RestController @RequestMapping("/api/customers") public class CustomerController
{
  @Autowired
  private CustomerService customerService;

}
