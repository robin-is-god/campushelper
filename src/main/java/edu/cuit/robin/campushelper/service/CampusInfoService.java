package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.CampusInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:19 2019/5/5
 * @ Description : TODO
 */

public interface CampusInfoService {
    List<Map<String,Object>> queryAllInfo();

    Map<String,Object> queryInfoById(Integer ciId);

    List<Map<String,Object>> queryIndexInfo();

    boolean insertCampusInfo(CampusInfo campusInfo);

    boolean updateCampusInfo(CampusInfo campusInfo);

    boolean deleteCampusInfo(@Param(value = "ciId") Integer ciId);
}
