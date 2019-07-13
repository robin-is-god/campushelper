package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.GoodDao;
import edu.cuit.robin.campushelper.model.Good;
import edu.cuit.robin.campushelper.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 20:01 2019/4/21
 * @ Description : TODO
 */

@Service
@Slf4j
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodDao goodDao;

    @Override
    public List<Good> queryAllGood() {
        return goodDao.queryAllGood();
    }

    @Override
    public List<Good> queryGoodByType(String goodType) {
        return goodDao.queryGoodByType(goodType);
    }

    @Override
    public List<Good> queryIndexGood() {
        return goodDao.queryIndexGood();
    }

    @Override
    public List<Good> queryGoodByName(String goodName, String sort, String order) {
        return goodDao.queryGoodByName(goodName, sort, order);
    }

    @Override
    public List<Good> queryAllType() {
        return goodDao.queryAllType();
    }

    @Override
    public List<Good> queryUserGood(Integer userId) {
        return goodDao.queryUserGood(userId);
    }

    @Override
    public Map<String, Object> queryGoodById(Integer gId) { return goodDao.queryGoodById(gId);}


    @Override
    @Transactional
    public boolean insertGood(Good good) {
        if(good != null){
            if(good.getGoodName() != null && good.getGoodName() !="") {
                try {
                    int rs = goodDao.insertGood(good);
                    if (rs > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入失败：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("插入商品名为空。");
            }
        } else {
            throw new RuntimeException("插入失败，商品名出错。");
        }
    }

    @Override
    @Transactional
    public boolean updateGood(Good good) {
        if(good.getGId() != null) {
            try {
                int rs = goodDao.updateGood(good);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到商品编号为" + good.getGId() + "记录。");
        }
    }

    @Override
    @Transactional
    public boolean deleteGood(Integer gId) {
        try {
            int rs = goodDao.deleteGood(gId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("删除失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败：" + e.getMessage());
        }
    }

    @Override
    public boolean updateGoodStock(Integer gId) {
        try {
            int rs = goodDao.upGoodStock(gId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("更新库存失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("更新库存失败：" + e.getMessage());
        }
    }
}
