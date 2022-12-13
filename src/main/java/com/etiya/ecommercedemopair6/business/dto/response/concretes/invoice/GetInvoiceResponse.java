package com.etiya.ecommercedemopair6.business.dto.response.concretes.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetInvoiceResponse {
    private int invoiceNumber;

    private Timestamp invoiceDate;
    private String customerName;
    private String productName;
    private int unitPrice;


}
