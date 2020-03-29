package com.zty.springcloud.dao;

import com.zty.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Deacription TODO
 * @Author zhangtianyi
 * @Date 2020/3/25 17:23
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
