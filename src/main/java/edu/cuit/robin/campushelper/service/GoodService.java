package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 20:00 2019/4/21
 * @ Description : TODO
 */

public interface GoodService {
    List<Good> queryAllGood();
    List<Good> queryGoodByType(String goodType);
    List<Good> queryIndexGood();
    List<Good> queryGoodByName(String goodName, String sort, String order);
    List<Good> queryAllType();
    List<Good> queryUserGood(Integer userId);
    Map<String, Object> queryGoodById(Integer gId);

    boolean insertGood(Good good);
    boolean updateGood(Good good);
    boolean deleteGood(@Param(value = "gId") Integer gId);
    boolean updateGoodStock(@Param(value = "gId") Integer gId);
}
