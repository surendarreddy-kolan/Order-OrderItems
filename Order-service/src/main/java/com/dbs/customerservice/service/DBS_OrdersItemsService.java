package com.dbs.customerservice.service;

import java.util.List;

import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.vo.DBS_OrderItemsVO;

public interface DBS_OrdersItemsService {
	
	public DBS_OrderItemsVO createOrderItems(DBS_OrderItemsVO ordersVO) ;
	public DBS_OrderItemsVO geOrderItemsByOrderId(Long orderBYId) throws DBS_RecordNotFoundException;
	public List<DBS_OrderItemsVO> getOrderItemss();
	
}
