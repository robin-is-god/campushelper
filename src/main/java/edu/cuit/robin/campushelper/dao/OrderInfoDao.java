package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 14:16 2019/5/10
 * @ Description : TODO
 */

public interface OrderInfoDao {
    List<Map<String,Object>> queryUserOrderByUid(int userId);

    Map<String,Object> queryOrderDetail(int oId);

    List<Map<String,Object>> queryNotEvaOrder(int userId);

    OrderInfo queryOrderId(String seriaNum);

    int updateOrderEva(int oId);

    int insertOrderInfo(OrderInfo orderInfo);

    int deleteOrderInfo(int oId);
}
