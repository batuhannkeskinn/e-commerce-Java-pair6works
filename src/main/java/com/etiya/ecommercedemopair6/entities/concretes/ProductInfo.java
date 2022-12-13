package com.etiya.ecommercedemopair6.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="product_infos")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_info_id")
    private int productInfoId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="size_id")
    private Size size;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;


}
