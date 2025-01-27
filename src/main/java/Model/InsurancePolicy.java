package Model;

import jakarta.persistence.*;

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
  @Column(nullable = false)
  private Date startDate;
  @Column(nullable = false)
  private Date endDate;
  @ManyToOne
  @JoinColumn(name="customer_id", nullable=false) // Fremmednøgle til Customer-tabellen
  private Customer customer;

  public InsurancePolicy(int Id, String Type, String details, double Premium,
      Date startDate, Date endDate)
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

  public Date getStartDate()
  {
    return startDate;
  }

  public void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public Date getEndDate()
  {
    return endDate;
  }

  public void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }
}
