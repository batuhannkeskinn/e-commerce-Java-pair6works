package com.etiya.ecommercedemopair6.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "shipping_companies")
public class ShippingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shipping_company_id")
    private int shippingCompanyId;

    @Column(name="company_name")
    private String companyName;
    @JsonIgnore
    @OneToMany(mappedBy = "shippingCompany")
    private List<Delivery> deliveries;
}