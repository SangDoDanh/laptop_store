package com.codegym.model.employee;

import com.codegym.model.location.Location;
import com.codegym.model.orders.Orders;
import com.codegym.model.orders.WarrantyOrdersDetail;
import com.codegym.model.user.Account;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String birthDay;
    private Integer gender;
    private Integer dedicationPoints;
    private String email;
    private String phone;
    private String idCard;
    private Boolean isRemove;

    @OneToMany(mappedBy = "employee")
    private Set<WarrantyOrdersDetail> warrantyOrdersDetails;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToMany(mappedBy = "employee")
    private Set<Orders> orders;

    @OneToMany(mappedBy = "employee")
    private Set<Location> locations;

    public Employee() {
    }

    public Set<WarrantyOrdersDetail> getWarrantyOrdersDetails() {
        return warrantyOrdersDetails;
    }

    public void setWarrantyOrdersDetails(Set<WarrantyOrdersDetail> warrantyOrdersDetails) {
        this.warrantyOrdersDetails = warrantyOrdersDetails;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getDedicationPoints() {
        return dedicationPoints;
    }

    public void setDedicationPoints(Integer dedicationPoints) {
        this.dedicationPoints = dedicationPoints;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Boolean getRemove() {
        return isRemove;
    }

    public void setRemove(Boolean remove) {
        isRemove = remove;
    }
}
