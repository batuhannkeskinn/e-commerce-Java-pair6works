package com.etiya.ecommercedemopair6.repository.abstracts;

import com.etiya.ecommercedemopair6.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
