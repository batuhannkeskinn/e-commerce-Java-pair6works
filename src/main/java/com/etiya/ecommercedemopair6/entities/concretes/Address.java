package com.etiya.ecommercedemopair6.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(name="title")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Customer> customers;

    //street_id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name ="street_id")
    private Street street;
   @JsonIgnore
    //city_id
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @JsonIgnore
    //country_id
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
