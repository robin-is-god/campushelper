package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.AroundInfo;
import edu.cuit.robin.campushelper.model.LostProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:37 2019/5/6
 * @ Description : TODO
 */

public interface AroundInfoService {
    List<Map<String, Object>> queryInfoByType(@Param(value = "type") String type);

    List<AroundInfo> queryAroundType();

    List<Map<String, Object>> queryAllInfo();

    Map<String,Object> queryAroundById(int aiId);

    List<AroundInfo> queryUserAroundInfo(int userId);

    boolean insertAroundInfo(AroundInfo aroundInfo);

    boolean updateAroundInfo(AroundInfo aroundInfo);

    boolean deleteAroundInfo(@Param(value = "aiId") Integer aiId);
}
