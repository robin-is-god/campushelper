package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.Evaluate;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:32 2019/5/10
 * @ Description : TODO
 */

public interface EvaluateDao {
    List<Map<String,Object>> queryGoodEva(int gId);

    int insertEvaluate(Evaluate evaluate);

    int deleteEvaluate(int eId);
}
