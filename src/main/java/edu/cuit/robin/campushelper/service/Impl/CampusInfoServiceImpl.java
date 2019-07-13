package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.CampusInfoDao;
import edu.cuit.robin.campushelper.model.CampusInfo;
import edu.cuit.robin.campushelper.service.CampusInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:21 2019/5/5
 * @ Description : TODO
 */

@Service
public class CampusInfoServiceImpl implements CampusInfoService {

    @Autowired
    private CampusInfoDao campusInfoDao;

    @Override
    public List<Map<String, Object>> queryAllInfo() {
        return campusInfoDao.queryAllInfo();
    }

    @Override
    public Map<String, Object> queryInfoById(Integer ciId) {
        return campusInfoDao.queryInfoById(ciId);
    }

    @Override
    public List<Map<String, Object>> queryIndexInfo() {
        return campusInfoDao.queryIndexInfo();
    }

    @Override
    public boolean insertCampusInfo(CampusInfo campusInfo) {
        if(campusInfo != null){
            if(campusInfo.getTitle() != null && campusInfo.getTitle() != "") {
                try {
                    int rs = campusInfoDao.insertCampusInfo(campusInfo);
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
    public boolean updateCampusInfo(CampusInfo campusInfo) {
        if(campusInfo.getCiId() != null) {
            try {
                int rs = campusInfoDao.updateCampusInfo(campusInfo);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到Id为" + campusInfo.getCiId() + "记录。");
        }
    }

    @Override
    public boolean deleteCampusInfo(@Param(value = "ciId") Integer ciId) {
        try {
            int rs = campusInfoDao.deleteCampusInfo(ciId);
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
