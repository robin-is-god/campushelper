package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.commons.model.PageInfo;
import edu.cuit.robin.campushelper.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 14:40 2019/5/10
 * @ Description : TODO
 */

public interface OrderInfoService {
    PageInfo<List<Map<String,Object>>> queryUserOrderByUid(int userId, int page, int rows);

    Map<String,Object> queryOrderDetail(int oId);

    PageInfo<List<Map<String,Object>>> queryNotEvaOrder(int userId, int page, int rows);

    OrderInfo insertOrderInfo(OrderInfo orderInfo);

    boolean updateOrderEva(int oId);

    boolean deleteOrderInfo(int oId);
}
