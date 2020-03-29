package com.zty.springcloud.controller;

import com.zty.springcloud.entities.CommonResult;
import com.zty.springcloud.entities.Payment;
import com.zty.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果是：" + result);
        return result > 0 ?
                new CommonResult(200, "插入数据库成功,serverPort" + serverPort, result) :
                new CommonResult(404, "插入数据库失败", null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果是：" + payment.toString());
        return payment != null ?
                new CommonResult(200, "查询成功,serverPort" + serverPort, payment) :
                new CommonResult(404, "没有对应记录，查询的ID：" + id, null);
    }
}
