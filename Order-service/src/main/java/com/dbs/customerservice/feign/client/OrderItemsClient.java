package com.dbs.customerservice.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.commons.vo.DBS_OrderItemsVO;
import com.dbs.commons.vo.DBS_OrdersVO;

@FeignClient(name="orderItem-service", url="http://localhost:8090/"/*, configuration = CustomFeignConfig.class*/)
public interface OrderItemsClient {

    @GetMapping("/orderItems")
    List<DBS_OrderItemsVO> listOrders();

    @GetMapping("/order/{id}")
    DBS_OrdersVO getOrderById(@PathVariable(value = "1") String id);

    @PostMapping("/orders")
    DBS_OrderItemsVO create(@RequestBody DBS_OrderItemsVO orderItemsVO);

    @GetMapping("/orders/items/{orderId}")
    List<DBS_OrderItemsVO> listOrdersItemsByOrderId(@PathVariable(value = "1") String id);
}
