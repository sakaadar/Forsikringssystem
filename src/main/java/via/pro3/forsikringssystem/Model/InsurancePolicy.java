package via.pro3.forsikringssystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
public class InsurancePolicy
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;
  @Column(nullable = false)
  private String Type;
  @Column(nullable = false)
  private String details;
  @Column(nullable = false)
  private double Premium;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @Column(name = "start_date", columnDefinition = "DATE")
  private LocalDate startDate;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @Column(name = "end_date", columnDefinition = "DATE")
  private LocalDate endDate;
  @ManyToOne
  @JoinColumn(name="customer_id", nullable=true) // Fremmednøgle til Customer-tabellen
  private Customer customer;

  public InsurancePolicy(int Id, String Type, String details, double Premium,
      LocalDate startDate, LocalDate endDate)
  {
    this.Id = Id;
    this.Type = Type;
    this.details = details;
    this.Premium = Premium;
    this.startDate = startDate;
    this.endDate = endDate;
  }
  public InsurancePolicy()
  {

  }
  public int getId()
  {
    return Id;
  }

  public void setId(int id)
  {
    Id = id;
  }

  public String getType()
  {
    return Type;
  }

  public void setType(String type)
  {
    Type = type;
  }

  public String getDetails()
  {
    return details;
  }

  public void setDetails(String details)
  {
    this.details = details;
  }

  public double getPremium()
  {
    return Premium;
  }

  public void setPremium(double premium)
  {
    Premium = premium;
  }

  public LocalDate getStartDate()
  {
    return startDate;
  }

  public void setStartDate(LocalDate startDate)
  {
    this.startDate = startDate;
  }

  public LocalDate getEndDate()
  {
    return endDate;
  }

  public void setEndDate(LocalDate endDate)
  {
    this.endDate = endDate;
  }
  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

}
