package edu.cuit.robin.campushelper.service.Impl;

import com.github.pagehelper.PageHelper;
import edu.cuit.robin.campushelper.commons.model.PageInfo;
import edu.cuit.robin.campushelper.dao.OrderInfoDao;
import edu.cuit.robin.campushelper.model.OrderInfo;
import edu.cuit.robin.campushelper.service.OrderInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @ Author      : robin.
 * @ Date        : Created in 14:41 2019/5/10
 * @ Description : TODO
 */

@Service
public class OrderInfoServiceImpl implements OrderInfoService{
    @Autowired
    private OrderInfoDao orderInfoDao;


    @Override
    public PageInfo<List<Map<String, Object>>> queryUserOrderByUid(int userId, int page, int rows) {
        PageInfo<List<Map<String, Object>>> info = new PageInfo<>();
        PageHelper.startPage(page, rows);
        com.github.pagehelper.PageInfo<Map<String, Object>> resoult = null;
        List<Map<String, Object>> list = orderInfoDao.queryUserOrderByUid(userId);
        resoult = new com.github.pagehelper.PageInfo<>(list);

        info.setTotal(resoult.getTotal());
        info.setTotalPage(resoult.getPages());
        info.setRows(resoult.getList());
        return info;

    }

    @Override
    public Map<String, Object> queryOrderDetail(int oId) {
        return orderInfoDao.queryOrderDetail(oId);
    }

    @Override
    public PageInfo<List<Map<String,Object>>> queryNotEvaOrder(int userId, int page, int rows) {
        PageInfo <List<Map<String, Object>>> info = new PageInfo<>();
        PageHelper.startPage(page, rows);
        com.github.pagehelper.PageInfo<Map<String, Object>> resoult = null;
        List<Map<String, Object>> list = orderInfoDao.queryNotEvaOrder(userId);
        resoult = new com.github.pagehelper.PageInfo<>(list);

        info.setTotal(resoult.getTotal());
        info.setTotalPage(resoult.getPages());
        info.setRows(resoult.getList());
        return info;
    }


    @Override
    @Transactional
    public OrderInfo insertOrderInfo(OrderInfo orderInfo) {
        if(orderInfo != null) {
            try {
                //根据当前时间生成订单号
                String str = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
                int rannum = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
                String seriaNum = str+rannum;
                orderInfo.setSeriaNum(seriaNum);

                int rs = orderInfoDao.insertOrderInfo(orderInfo);
                if (rs > 0) {
                    return orderInfoDao.queryOrderId(seriaNum);
                } else {
                    throw new RuntimeException("插入失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败：" + e.getMessage());
            }
        }else {
            throw new RuntimeException("插入地址数据为空。");
        }
    }

    @Override
    @Transactional
    public boolean updateOrderEva(int oId) {
        Map map = orderInfoDao.queryOrderDetail(oId);
        if(map != null) {
            try {
                int rs = orderInfoDao.updateOrderEva(oId);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到订单号为" + oId + "的记录。");
        }
    }

    @Override
    @Transactional
    public boolean deleteOrderInfo(int oId) {
        try {
            int rs = orderInfoDao.deleteOrderInfo(oId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("删除失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败：" + e.getMessage());
        }
    }
}
