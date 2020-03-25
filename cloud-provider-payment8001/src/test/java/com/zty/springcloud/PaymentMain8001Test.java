package com.zty.springcloud;

import com.zty.springcloud.controller.PaymentController;
import com.zty.springcloud.entities.CommonResult;
import com.zty.springcloud.entities.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentMain8001Test {
    @Autowired
    PaymentController paymentController;

    @Test
    public void test(){
        Payment payment = new Payment(2L, "23213");
        CommonResult commonResult = paymentController.create(payment);
        System.out.println(commonResult);
    }
}
