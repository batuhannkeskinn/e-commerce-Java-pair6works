package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.BasketDetail;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BasketDetailRepository extends JpaRepository<BasketDetail, Integer> {
    @Query("Select bd from BasketDetail as bd")
    Slice<BasketDetail> findAllSlice(Pageable pageable);
}
