package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findAllAddressByTitle(String title);

//        @Query("Select ad from Address as ad Where name =:name")
//        Product findByName(String name);
//
//    @Query("Select ad from Address as ad Where address_id =:id")
//    Address customAddress(int id);

    @Query("Select ad from Address as ad WHERE ad.addressId=:id")
    Address customAddress(int id);

   @Query(value =" Select * from addresses ads Inner Join streets st ON st.street_id =" +
           " ads.street_id join cities ON cities.city_id = st.city_id",nativeQuery = true)
   List<Address> customeCityAddress(String cityName);
    @Query("Select adr from Address as adr")
    Slice<Address> findAllSlice(Pageable pageable);

}
