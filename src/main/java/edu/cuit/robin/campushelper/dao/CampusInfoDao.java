package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.CampusInfo;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 10:15 2019/4/18
 * @ Description : TODO
 */

public interface CampusInfoDao {
    List<Map<String,Object>> queryAllInfo();

    Map<String,Object> queryInfoById(Integer ciId);

    List<Map<String,Object>> queryIndexInfo();

    int insertCampusInfo(CampusInfo campusInfo);

    int updateCampusInfo(CampusInfo campusInfo);

    int deleteCampusInfo(Integer ciId);
}
