package com.test1;

/**
 * 直接指定泛型类型
 * @author angelo
 *
 * @param <OrderEntity>
 */
public class OrderDaoImpl<OrderEntity> extends BaseDao<OrderEntity> implements
		IOrderDao {

}
