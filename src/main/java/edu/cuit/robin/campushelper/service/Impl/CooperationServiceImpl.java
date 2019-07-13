package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.CooperationDao;
import edu.cuit.robin.campushelper.model.Cooperation;
import edu.cuit.robin.campushelper.service.CooperationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:26 2019/5/7
 * @ Description : TODO
 */

@Service
public class CooperationServiceImpl implements CooperationService {
    @Autowired
    private CooperationDao cooperationDao;

    @Override
    public List<Map<String,Object>> queryAllCooperation() {
        return cooperationDao.queryAllCooperation();
    }

    @Override
    public Map<String, Object> queryCooById(Integer cooId) {
        return cooperationDao.queryCooById(cooId);
    }

    @Override
    public List<Cooperation> queryUserCooInfo(int userId) {
        return cooperationDao.queryUserCooInfo(userId);
    }

    @Override
    public boolean updateCooInfo(Integer cooId, Boolean solve) {
        if(cooId != null) {
            try {
                int rs = cooperationDao.updateCooInfo(cooId,solve);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到编号为" + cooId + "记录。");
        }
    }

    @Override
    public boolean insertCooperation(Cooperation cooperation) {
        if(cooperation != null){
            if(cooperation.getTitle() != null && cooperation.getTitle() != "") {
                try {
                    int rs = cooperationDao.insertCooperation(cooperation);
                    if (rs > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入失败：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("标题为空。");
            }
        } else {
            throw new RuntimeException("插入标题为空。");
        }
    }

    @Override
    public boolean deleteCooperation(@Param(value = "cooId") int cooId) {
        try {
            int rs = cooperationDao.deleteCooperation(cooId);
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
