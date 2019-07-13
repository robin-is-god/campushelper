package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.commons.model.PageInfo;
import edu.cuit.robin.campushelper.model.OrderInfo;
import edu.cuit.robin.campushelper.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 14:55 2019/5/10
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/order")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @RequestMapping(value = "/getUserOrder",method = RequestMethod.GET)
    private Map<String, Object> getUserOrder(Integer userId,
                                             @RequestParam(defaultValue="1") int page,
                                             @RequestParam(defaultValue="10") int rows){
        Map<String, Object> map = new HashMap<>();
        PageInfo<List<Map<String, Object>>> result = null;
        log.info("传入参数为:userId: " + userId + "pages:" + page + "rows:" + rows);
        result = orderInfoService.queryUserOrderByUid(userId, page, rows);
        map.put("orderList", result);
        return map;
    }

    @RequestMapping(value = "/getOrderDetail",method = RequestMethod.GET)
    private Map<String, Object> getAddressByAid(Integer oId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + oId);
        map.put("success", orderInfoService.queryOrderDetail(oId));
        return map;
    }

    @RequestMapping(value = "/getNotEvaOrder",method = RequestMethod.GET)
    private Map<String, Object> getNotEvaOrder(Integer userId,
                                                @RequestParam(defaultValue="1") int page,
                                                @RequestParam(defaultValue="10") int rows){
        Map<String, Object> map = new HashMap<>();
        PageInfo<List<Map<String, Object>>> result = null;
        log.info("传入参数为:userId: " + userId + "pages:" + page + "rows:" + rows);
        result = orderInfoService.queryNotEvaOrder(userId, page, rows);
        map.put("notEvaList", result);
        return map;
    }

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    private Map<String, Object> addAddress(@RequestBody OrderInfo orderInfo){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + orderInfo.toString());
        map.put("success", orderInfoService.insertOrderInfo(orderInfo));
        return map;
    }


    @RequestMapping(value = "/deleteOrder",method = RequestMethod.GET)
    private Map<String, Object> deleteAddress(@RequestParam(value = "oId", required = true) Integer oId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + oId);
        map.put("success", orderInfoService.deleteOrderInfo(oId));
        return map;
    }
}
