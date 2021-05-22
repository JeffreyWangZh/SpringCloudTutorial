package com.jw9j.payment.services;

import com.jw9j.commons.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") int id);

}
