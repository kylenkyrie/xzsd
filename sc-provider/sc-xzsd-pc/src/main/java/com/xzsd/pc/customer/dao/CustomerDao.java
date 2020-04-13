package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @ClassName CustomerDao
 * @Description customer
 * @Author yangmingzhen
 * @Date 2020-04-05
 */
@Mapper
public interface CustomerDao {

    /**
     * 获取所有客户信息
     * @param customerInfo 用户信息
     * @return 所有客户信息
     */
    List<CustomerInfo> listCustomerByPage(CustomerInfo customerInfo);
}
