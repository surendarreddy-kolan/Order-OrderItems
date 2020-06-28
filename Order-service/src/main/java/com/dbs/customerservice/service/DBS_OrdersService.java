package com.dbs.customerservice.service;

import java.util.List;

import com.dbs.commons.exception.DBS_RecordNotFoundException;
import com.dbs.commons.vo.DBS_OrdersVO;

public interface DBS_OrdersService {
	
	public DBS_OrdersVO createOrders(DBS_OrdersVO ordersVO) ;
	public DBS_OrdersVO getOrder(Long orderBYId) throws DBS_RecordNotFoundException;
	public List<DBS_OrdersVO> getOrders();
	
}
