package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.Cooperation;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 10:47 2019/4/18
 * @ Description : TODO
 */

public interface CooperationDao {

    List<Map<String,Object>> queryAllCooperation();

    Map<String, Object> queryCooById(int cooId);

    List<Cooperation> queryUserCooInfo(int userId);

    int updateCooInfo(@Param(value = "cooId") Integer cooId, @Param(value = "solve") Boolean solve);

    int insertCooperation(Cooperation cooperation);

    int deleteCooperation(@Param(value = "cooId") int cooId);
}
