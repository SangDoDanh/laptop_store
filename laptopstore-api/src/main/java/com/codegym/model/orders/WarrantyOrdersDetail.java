package com.codegym.model.orders;

import com.codegym.model.employee.Employee;

import javax.persistence.*;

@Entity
public class WarrantyOrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isRemove;

    @ManyToOne
    @JoinColumn(name = "orders_detail_id", referencedColumnName = "id")
    private OrdersDetail ordersDetail;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;
    private String warrantyInfo;
    private String startDay;
    private String endDay;

    public WarrantyOrdersDetail() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getWarrantyInfo() {
        return warrantyInfo;
    }

    public void setWarrantyInfo(String warrantyInfo) {
        this.warrantyInfo = warrantyInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRemove() {
        return isRemove;
    }

    public void setRemove(Boolean remove) {
        isRemove = remove;
    }

    public OrdersDetail getOrdersDetail() {
        return ordersDetail;
    }

    public void setOrdersDetail(OrdersDetail ordersDetail) {
        this.ordersDetail = ordersDetail;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }
}
