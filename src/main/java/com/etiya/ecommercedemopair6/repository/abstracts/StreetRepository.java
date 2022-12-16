package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Street;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StreetRepository extends JpaRepository<Street,Integer> {
    boolean existsByStreetName (String streetName);
    @Query("Select st from Street as st")
    Slice<Street> findAllSlice(Pageable pageable);
}
