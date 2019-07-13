package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.AroundInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 10:15 2019/4/18
 * @ Description : TODO
 */

public interface AroundInfoDao {

    List<Map<String, Object>> queryInfoByType(@Param(value = "type") String type);

    List<Map<String, Object>> queryAllInfo();

    List<AroundInfo> queryAroundType();

    Map<String,Object> queryAroundById(int aiId);

    List<AroundInfo> queryUserAroundInfo(int userId);

    int insertAroundInfo(AroundInfo aroundInfo);

    int updateAroundInfo(AroundInfo aroundInfo);

    int deleteAroundInfo(@Param(value = "aiId") int aiId);
}
