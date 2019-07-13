package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.InfoMessage;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:32 2019/5/14
 * @ Description : TODO
 */

public interface InfoMessageService {
    boolean insertInfoMessage(InfoMessage infoMessage);

    List<Map<String,Object>> queryInfoMessage(InfoMessage infoMessage);

    boolean deleteInfoByPid(Integer pId);

    boolean deleteInfoByAid(Integer aId);

    boolean deleteInfoByCid(Integer cId);
}
