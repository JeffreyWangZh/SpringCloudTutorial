package com.jw9j.payment.services.impl;

import com.jw9j.commons.Payment;
import com.jw9j.payment.dao.PaymentDao;
import com.jw9j.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    public PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentDao.getPaymentById(id);
    }
}
