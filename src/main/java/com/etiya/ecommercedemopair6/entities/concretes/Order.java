package com.etiya.ecommercedemopair6.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_number")
    private int orderNumber;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "total_price")
    private double totalPrice;

    @CreationTimestamp
    private Timestamp orderDate;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<Delivery> deliveries;

    @JsonProperty
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<Payment> payments;

    @OneToMany(mappedBy = "order")
    private List<Invoice> invoices;
}
