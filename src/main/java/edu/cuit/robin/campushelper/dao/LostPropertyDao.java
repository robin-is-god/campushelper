package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.LostProperty;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:38 2019/4/14
 * @ Description : TODO
 */

public interface LostPropertyDao {
    List<Map<String,Object>> queryFindOrLost(@Param(value = "findOrLost") boolean findOrLost);

    List<LostProperty> queryIsSolve(@Param(value = "solve") boolean solve);

    List<LostProperty> queryInfoByDate(@Param(value = "date") Date date);

    List<LostProperty> queryInfoByName(@Param(value = "propertyName") String propertyName);

    Map<String,Object> queryInfoByPid(int pId);

    List<LostProperty> queryUserProperty(int userId);

    int insertLostProperty(LostProperty lostPropertyDao);

    int updateLostProperty(@Param(value = "pId") Integer pId, @Param(value = "solve") Boolean solve);

    int deleteLostProperty(@Param(value = "pId") int pId);
}
