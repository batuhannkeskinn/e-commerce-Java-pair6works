package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findAllAddressByTitle(String title);//

    boolean existsAddressByAddressId(int id);

    //    @Query("Select ad from Address as ad Where name =:name")
//    Product findByName(String name);
    @Query("Select ad from Address as ad Where address_id =:id")
    Address customAddress(int id);
//    @Query("SELECT new com.etiya.ecommercedemopair6.entities.concretes.City(c.cityId,c.cityName,c.addresses) FROM Address a JOIN City c ON a.city.cityId=c.cityId WHERE a.addressId=:id" )
//    Address getAllCitiesByAddressId(@Param("id") int id);

}
