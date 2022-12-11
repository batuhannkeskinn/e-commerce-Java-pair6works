package com.etiya.ecommercedemopair6.repository.abstracts;
//bu interface in veri erişim katmanı olması için alması gereken extends

import com.etiya.ecommercedemopair6.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    //stock sayısına göre stock alanı gelen int değerlerden fazla olan productlar
    List<Product> findAllProductsByStockGreaterThan(int stock);
    @Query("Select p from Product as p Where p.name =:name")
    Product findByName(String name);

//    @Query(value = "select * from Products Inner join suppliers ON suppliers.suppliers_id = Products.supplier_id",nativeQuery = true)
//    List<Product> findProductBySuppliers(String supplier);

    @Query("select distinct new com.etiya.ecommercedemopair6." +
            "business.dto.response.concretes.product.GetProductResponse(pr.name , pr.stock , pr.unitPrice)" +
            " from Product pr WHERE pr.productId=:productId")
    Product customProductId(int productId);

    @Query("select distinct new com.etiya.ecommercedemopair6." +
            "business.dto.response.concretes.product." +
            "GetProductResponse(pr.name)" +
            "from Product pr WHERE pr.productId=:productId")

    Product customProduct2Id( int productId);
}
