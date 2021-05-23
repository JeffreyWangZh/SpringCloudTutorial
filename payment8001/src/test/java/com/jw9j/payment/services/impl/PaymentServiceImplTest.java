package com.jw9j.payment.services.impl;

import com.jw9j.commons.CommonResult;
import com.jw9j.commons.Payment;
import com.jw9j.payment.controllers.PaymentController;
import com.jw9j.payment.dao.PaymentDao;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PaymentServiceImplTest {
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
    public void after()
    {
        System.out.println("测试结束。。。。");
    }

    @Autowired
    private PaymentServiceImpl paymentService;

    @Test
    public void createTest(){
        Payment payment = new Payment(1,"444");
        TestCase.assertEquals(paymentService.create(payment),1);
    }

    @Test
    public void createTestMock(){
        payment = new Payment(3,"444");
        Mockito.when(paymentDao.create(payment)).thenReturn(1);
        int i = paymentDao.create(payment);
        Assert.assertEquals(i,1);

    }

    @Test
    public void getByIdTest(){
        Payment payment = this.paymentService.getPaymentById(1);
        TestCase.assertEquals(payment.getSerial(),"222");
    }
}
