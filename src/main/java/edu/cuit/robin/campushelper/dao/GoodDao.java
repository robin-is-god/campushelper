package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 19:47 2019/4/21
 * @ Description : TODO
 */

public interface GoodDao {
    List<Good> queryAllGood();
    List<Good> queryGoodByType(String goodType);
    List<Good> queryIndexGood();
    List<Good> queryGoodByName(String goodName,String sort,String order);
    List<Good> queryAllType();
    List<Good> queryUserGood(int userId);
    Map<String, Object> queryGoodById(int gId);

    int insertGood(Good good);
    int updateGood(Good good);
    int deleteGood(@Param(value = "gId") Integer gId);
    int upGoodStock(@Param(value = "gId") Integer gId);
}
