package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.AroundInfoDao;
import edu.cuit.robin.campushelper.model.AroundInfo;
import edu.cuit.robin.campushelper.service.AroundInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:38 2019/5/6
 * @ Description : TODO
 */

@Service
public class AroundInfoServiceImpl implements AroundInfoService {
    @Autowired
    private AroundInfoDao aroundInfoDao;

    @Override
    public List<Map<String, Object>> queryInfoByType(@Param(value = "type") String type) {
        return aroundInfoDao.queryInfoByType(type);
    }

    @Override
    public List<AroundInfo> queryAroundType() {
        return aroundInfoDao.queryAroundType();
    }

    @Override
    public List<Map<String, Object>> queryAllInfo() {
        return aroundInfoDao.queryAllInfo();
    }

    @Override
    public Map<String, Object> queryAroundById(int aiId) {
        return aroundInfoDao.queryAroundById(aiId);
    }

    @Override
    public List<AroundInfo> queryUserAroundInfo(int userId) {
        return aroundInfoDao.queryUserAroundInfo(userId);
    }

    @Override
    @Transactional
    public boolean insertAroundInfo(AroundInfo aroundInfo) {
        if(aroundInfo != null){
            if(aroundInfo.getTitle() != null && aroundInfo.getTitle() != "") {
                try {
                    int rs = aroundInfoDao.insertAroundInfo(aroundInfo);
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
    @Transactional
    public boolean updateAroundInfo(AroundInfo aroundInfo) {
        if(aroundInfo.getAiId() != null) {
            try {
                int rs = aroundInfoDao.updateAroundInfo(aroundInfo);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到Id为" + aroundInfo.getAiId() + "记录。");
        }
    }

    @Override
    @Transactional
    public boolean deleteAroundInfo(@Param(value = "aiId") Integer aiId) {
        try {
            int rs = aroundInfoDao.deleteAroundInfo(aiId);
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
