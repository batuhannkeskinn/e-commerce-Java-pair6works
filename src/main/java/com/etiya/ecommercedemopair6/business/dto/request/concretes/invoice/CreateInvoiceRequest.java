package com.etiya.ecommercedemopair6.business.dto.request.concretes.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {
    private int id;
    private int invoiceNumber;
    private int productId;
    private int orderId;


}
