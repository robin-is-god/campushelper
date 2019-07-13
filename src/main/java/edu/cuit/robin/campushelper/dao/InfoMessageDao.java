package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.InfoMessage;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:19 2019/5/14
 * @ Description : TODO
 */

public interface InfoMessageDao {
    int insertInfoMessage(InfoMessage infoMessage);

    List<Map<String,Object>> queryInfoMessage(InfoMessage infoMessage);

    int deleteInfoByPid(int pId);

    int deleteInfoByAid(int aId);

    int deleteInfoByCid(int cId);
}
