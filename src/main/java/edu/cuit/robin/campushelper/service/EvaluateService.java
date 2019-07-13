package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.Evaluate;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 10:29 2019/5/11
 * @ Description : TODO
 */

public interface EvaluateService {
    List<Map<String,Object>> queryGoodEva(int gId);

    boolean insertEvaluate(Evaluate evaluate);

    boolean deleteEvaluate(int eId);
}
