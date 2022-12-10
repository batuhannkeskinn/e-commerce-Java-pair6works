package com.etiya.ecommercedemopair6.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int productId;


    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "stock")
    private int stock;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CategoryProduct> categoryProductList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;


    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


}
