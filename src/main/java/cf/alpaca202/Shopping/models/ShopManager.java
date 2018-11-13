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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "shopmanagers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ShopManager implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="seller_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonIgnore
  private Seller seller;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="shop_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @JsonIgnore
  private Shop shop;

  private String role;

  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  @Column(name = "created_at")
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  @LastModifiedDate
  @Column(name = "updated_at")
  private Date updatedAt;

  public ShopManager() {
  }

  public ShopManager(long id, Seller seller, Shop shop, String role, Date createdAt, Date updatedAt) {
    this.id = id;
    this.seller = seller;
    this.shop = shop;
    this.role = role;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Seller getSeller() {
    return this.seller;
  }

  public void setSeller(Seller seller) {
    this.seller = seller;
  }

  public Shop getShop() {
    return this.shop;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
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