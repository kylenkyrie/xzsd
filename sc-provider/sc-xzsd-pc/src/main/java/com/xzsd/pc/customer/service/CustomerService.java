package com.xzsd.pc.customer.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;

    /**
     * demo 查询客户列表（分页）
     * @param customerInfo
     * @return
     * @Author yangmingzhen
     * @Date 2020-04-05
     */
    public AppResponse listCustomer(CustomerInfo customerInfo) {
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        List<CustomerInfo> customerInfoList = customerDao.listCustomerByPage(customerInfo);
        // 包装Page对象
        PageInfo<CustomerInfo> pageData = new PageInfo<CustomerInfo>(customerInfoList);
        return AppResponse.success("查询成功！",pageData);
    }
}
