package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.LostProperty;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:33 2019/4/20
 * @ Description : TODO
 */

public interface LostPorpertyService {
    List<Map<String, Object>> queryFindOrLost(@Param(value = "findOrLost") boolean findOrLost);

    List<LostProperty> queryIsSolve(@Param(value = "solve") boolean solve);

    List<LostProperty> queryInfoByDate(@Param(value = "date") Date date);

    List<LostProperty> queryInfoByName(@Param(value = "propertyName") String propertyName);

    Map<String,Object> queryInfoByPid(Integer pId);

    List<LostProperty> queryUserProperty(int userId);

    boolean insertLostProperty(LostProperty lostPropertyDao);

    boolean updateLostProperty(@Param(value = "pId") Integer pId, @Param(value = "solve") Boolean solve);

    boolean deleteLostProperty(@Param(value = "pId") int pId);
}
