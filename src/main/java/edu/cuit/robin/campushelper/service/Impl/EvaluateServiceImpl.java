package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.EvaluateDao;
import edu.cuit.robin.campushelper.model.Evaluate;
import edu.cuit.robin.campushelper.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 10:30 2019/5/11
 * @ Description : TODO
 */
@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateDao evaluateDao;

    @Override
    public List<Map<String, Object>> queryGoodEva(int gId) {
        return evaluateDao.queryGoodEva(gId);
    }

    @Override
    public boolean insertEvaluate(Evaluate evaluate) {
        if(evaluate.getGId() != null) {
            try {
                //根据当前时间生成订单号
                int rs = evaluateDao.insertEvaluate(evaluate);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败：" + e.getMessage());
            }
        }else {
            throw new RuntimeException("插入评论无商品号。");
        }
    }

    @Override
    public boolean deleteEvaluate(int eId) {
        try {
            int rs = evaluateDao.deleteEvaluate(eId);
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
