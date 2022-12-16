package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Address;
import com.etiya.ecommercedemopair6.entities.concretes.Size;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SizeRepository extends JpaRepository<Size,Integer> {
    boolean existsByNumber(String number);
    @Query("Select si from Size as si")
    Slice<Size> findAllSlice(Pageable pageable);
}
