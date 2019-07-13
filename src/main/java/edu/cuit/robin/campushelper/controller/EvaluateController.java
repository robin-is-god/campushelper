package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.Evaluate;
import edu.cuit.robin.campushelper.service.EvaluateService;
import edu.cuit.robin.campushelper.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 10:38 2019/5/11
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/evaluate")
public class EvaluateController {
    @Autowired
    private EvaluateService evaluateService;

    @Autowired
    private OrderInfoService orderInfoService;


    @RequestMapping(value = "/getGoodEva",method = RequestMethod.GET)
    private Map<String, Object> getGoodEva(Integer gId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + gId);
        List list = evaluateService.queryGoodEva(gId);
        map.put("evaGoodList", list);
        return map;
    }

    @RequestMapping(value = "/addEvaluate",method = RequestMethod.POST)
    private Map<String, Object> addEvaluate(@RequestBody Evaluate evaluate){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + evaluate.toString());
        if(evaluateService.insertEvaluate(evaluate) == true){
            if(orderInfoService.updateOrderEva(evaluate.getOId()) == true) {
                map.put("success", "success");
            } else {
                map.put("success","false");
            }
        } else {
            map.put("success","false");
        }
        return map;
    }


    @RequestMapping(value = "/deleteEvaluate",method = RequestMethod.GET)
    private Map<String, Object> deleteEvaluate(@RequestParam(value = "eId", required = true) Integer eId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + eId);
        map.put("success", orderInfoService.deleteOrderInfo(eId));
        return map;
    }
}
