package com.jw9j.payment.controllers;

import com.jw9j.commons.CommonResult;
import com.jw9j.commons.Payment;
import com.jw9j.payment.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
//    @Autowired
//    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult create(Payment payment)
    {
        int result= paymentService.create(payment);

        log.info("插入数据的ID:\t" + payment.getId());
        if(result > 0){
            return new CommonResult(200,"插入数据成功，serverport:" ,result);
        }else{
            return new CommonResult(200,"插入数据失败",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询成功");
        if(payment!=null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(400,"tt",null);
        }
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
