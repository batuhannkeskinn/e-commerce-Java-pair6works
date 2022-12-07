package com.etiya.ecommercedemopair6.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "colors")
@Builder
public class Color {

    public Color(String colorName) {
        this.colorName = colorName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="color_id")
    private int colorId;

    @Column(name = "color_name")
    private String colorName;

    @JsonIgnore
    @OneToMany(mappedBy = "color")
    private List<ProductInfo> productInfos;
}
