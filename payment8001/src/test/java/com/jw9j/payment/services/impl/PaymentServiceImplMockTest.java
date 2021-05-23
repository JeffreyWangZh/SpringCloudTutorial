package com.jw9j.payment.services.impl;

import com.jw9j.commons.Payment;
import com.jw9j.payment.dao.PaymentDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;
import static reactor.core.publisher.Mono.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PaymentServiceImplMockTest {
    @Mock
    private PaymentServiceImpl paymentServiceImpl;
    @Mock
    private PaymentDao paymentDao;
    @Mock
    private Payment payment;

    @Before
    public void setupMock(){
        MockitoAnnotations.initMocks(this);
        paymentServiceImpl = new PaymentServiceImpl();
        paymentServiceImpl.paymentDao = paymentDao;

    }
    @After
    public void  after(){
        System.out.println("after the test");
    }
//    @Test
//    public void createAllData(){
//        Payment payment = new Payment(1,"rrr");
//        PaymentServiceImpl paymentServiceMock = mock(PaymentServiceImpl.class);
//        when(paymentServiceMock.create(payment)).thenReturn()
//
//    }
}
