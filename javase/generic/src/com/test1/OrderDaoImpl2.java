package com.test1;

/**
 * 在类上使用泛型类型
 * @author angelo
 *
 * @param <T>
 */
public class OrderDaoImpl2<T> extends BaseDao<T> implements IOrderDao<T> {

}
