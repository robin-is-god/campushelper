package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.LostPropertyDao;
import edu.cuit.robin.campushelper.model.LostProperty;
import edu.cuit.robin.campushelper.service.LostPorpertyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:43 2019/4/21
 * @ Description : TODO
 */

@Service
@Slf4j
public class LostPropertyServiceImpl implements LostPorpertyService {
    @Autowired
    private LostPropertyDao lostPropertyDao;

    @Override
    public List<Map<String, Object>> queryFindOrLost(@Param(value = "findOrLost") boolean findOrLost) {
        return lostPropertyDao.queryFindOrLost(findOrLost);
    }

    @Override
    public List<LostProperty> queryIsSolve(@Param(value = "solve") boolean is_solve) {
        return lostPropertyDao.queryIsSolve(is_solve);
    }

    @Override
    public List<LostProperty> queryInfoByDate(@Param(value = "date") Date date) {
        return lostPropertyDao.queryInfoByDate(date);
    }

    @Override
    public List<LostProperty> queryInfoByName(@Param(value = "propertyName") String propertyName) {
        return lostPropertyDao.queryInfoByName(propertyName);
    }

    @Override
    public Map<String, Object> queryInfoByPid(Integer pId) {
        return lostPropertyDao.queryInfoByPid(pId);
    }

    @Override
    public List<LostProperty> queryUserProperty(int userId) {
        return lostPropertyDao.queryUserProperty(userId);
    }

    @Override
    @Transactional
    public boolean insertLostProperty(LostProperty lostProperty) {
        if(lostProperty != null){
            if(lostProperty.getPropertyName()!= null && lostProperty.getPropertyName() != "") {
                try {
                    int rs = lostPropertyDao.insertLostProperty(lostProperty);
                    if (rs > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入失败：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("插入物品名称为空。");
            }
        } else {
            throw new RuntimeException("插入物品为空。");
        }
    }

    @Override
    @Transactional
    public boolean updateLostProperty(@Param(value = "pId") Integer pId, @Param(value = "solve") Boolean solve) {
        if(pId != null) {
            try {
                int rs = lostPropertyDao.updateLostProperty(pId,solve);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到失物编号为" + pId + "记录。");
        }
    }

    @Override
    @Transactional
    public boolean deleteLostProperty(@Param(value = "pId") int pId) {
        try {
            int rs = lostPropertyDao.deleteLostProperty(pId);
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
