package cf.alpaca202.Shopping.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "addresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @NotBlank
  private String address;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="accounts_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonIgnore
  private Account account;

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  @Column(name = "created_at")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt;

  public Address() {
  }

  public Address(long id, String address, Account account, Date createdAt, Date updatedAt) {
    this.id = id;
    this.address = address;
    this.account = account;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Account getAccount() {
    return this.account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}