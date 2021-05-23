package com.jw9j.payment.controllers;

import com.jw9j.commons.CommonResult;
import com.jw9j.commons.Payment;
import com.jw9j.payment.PaymentApplication;
import com.jw9j.payment.services.impl.PaymentServiceImpl;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = PaymentApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class PaymentControllerTest {

    @Autowired
    private PaymentController paymentController;

    @Before
    public void init()
    {
        System.out.println("开始测试。。。。");
    }

    @After
    public void after()
    {
        System.out.println("测试结束。。。。");
    }

    @Test
    public void helloTest(){
        TestCase.assertEquals(this.paymentController.hello(),"hello world");
    }


    @Test
    public void createTest(){
        Payment payment = new Payment(2,"ttttt");
        TestCase.assertEquals(this.paymentController.create(payment),new CommonResult(200, "插入数据成功",null));
    }

}
