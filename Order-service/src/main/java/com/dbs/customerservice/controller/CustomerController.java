package com.dbs.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.commons.responsewrapper.ResponseWarapperVO;
import com.dbs.commons.vo.DBS_OrderItemsVO;
import com.dbs.commons.vo.DBS_OrdersVO;
import com.dbs.customerservice.feign.client.OrderItemsClient;

@RequestMapping("/Orders")
@RestController
public class CustomerController {

    @Autowired
    private OrderItemsClient orderItems;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseWarapperVO> getOrdersByOrderId(@PathVariable String id){
        DBS_OrdersVO orderItemsVo = orderItems.getOrderById(id);
        return new ResponseEntity<ResponseWarapperVO>(new ResponseWarapperVO(true, HttpStatus.OK.toString(), orderItemsVo, "Order record(s) retrieved count is 1 "), HttpStatus.OK);
    }
    
    @GetMapping("items/{id}")
    public ResponseEntity<ResponseWarapperVO> getCustomerById(@PathVariable String id){
        List<DBS_OrderItemsVO> ordersItems = orderItems.listOrdersItemsByOrderId(id);
        return new ResponseEntity<ResponseWarapperVO>(new ResponseWarapperVO(true, HttpStatus.OK.toString(), ordersItems, "OrderItem record(s) retrieved count is "+ordersItems.size()), HttpStatus.OK);
    }

}
