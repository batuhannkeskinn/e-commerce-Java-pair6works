package com.etiya.ecommercedemopair6.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private  String phoneNumber;

    @Column(name="birth_day")
    private Date birthDay;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Basket> baskets;
    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    //addres_id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
