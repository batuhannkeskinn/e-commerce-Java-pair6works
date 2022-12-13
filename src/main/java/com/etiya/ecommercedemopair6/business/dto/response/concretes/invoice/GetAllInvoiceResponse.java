package com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInvoiceResponse {
    private int invoiceId;
    private Timestamp invoiceDate;
    private String invoiceNumber;
    private String productName;
    private String firstName;
    private String lastName;
    private int totalPrice;
    private int unitPrice;
    private String supplierName;





}
