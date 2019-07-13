package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.Cooperation;
import edu.cuit.robin.campushelper.model.LostProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:25 2019/5/7
 * @ Description : TODO
 */

public interface CooperationService {
    List<Map<String,Object>> queryAllCooperation();

    Map<String, Object> queryCooById(Integer cooId);

    List<Cooperation> queryUserCooInfo(int userId);

    boolean updateCooInfo(@Param(value = "cooId") Integer cooId, @Param(value = "solve") Boolean solve);

    boolean insertCooperation(Cooperation cooperation);

    boolean deleteCooperation(@Param(value = "cooId") int cooId);
}
