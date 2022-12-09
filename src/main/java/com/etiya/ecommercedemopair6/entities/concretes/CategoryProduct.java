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
@Table(name="category_product")
public class CategoryProduct {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name ="category_product_id")
   private int categoryProductId;


//category_id


   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;

   //product_id


   @JsonIgnore
   @ManyToOne
   @JoinColumn(name="product_id")
   private Product product;

}
