package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Product;
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
//
//    @Query("SELECT ad FROM Address ad JOIN  ad.street.city.cityName =:cityName")
//    List<Address> customeCityAddress(String cityName);

}
