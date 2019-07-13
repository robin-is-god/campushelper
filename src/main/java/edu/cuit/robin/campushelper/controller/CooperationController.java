package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.Cooperation;
import edu.cuit.robin.campushelper.service.CooperationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:28 2019/5/7
 * @ Description : TODO
 */


@RestController
@Slf4j
@RequestMapping("/campushelper/cooperation")
public class CooperationController {
    @Autowired
    private CooperationService cooperationService;

    @RequestMapping(value = "/getAllCooInfo",method = RequestMethod.GET)
    private Map<String, Object> getAllCooInfo(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = cooperationService.queryAllCooperation();
        map.put("cooInfoList", list);
        return map;
    }

    @RequestMapping(value = "/getCooById",method = RequestMethod.GET)
    private Map<String, Object> getCooById(Integer cooId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + cooId);
        map.put("success", cooperationService.queryCooById(cooId));
        return map;
    }

    @RequestMapping(value = "/getUserCooInfo",method = RequestMethod.GET)
    private Map<String, Object> getUserCooInfo(Integer userId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + userId);
        List list = cooperationService.queryUserCooInfo(userId);
        map.put("cooList",list);
        return map;
    }

    @RequestMapping(value = "/addCooInfo",method = RequestMethod.POST)
    private Map<String, Object> addCooInfo(@RequestBody Cooperation cooperation){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + cooperation.toString());
        map.put("success", cooperationService.insertCooperation(cooperation));
        return map;
    }

    @RequestMapping(value = "/updateCooInfo",method = RequestMethod.GET)
    private Map<String, Object> updateAddress(@Param(value = "cooId") int cooId, @Param(value = "solve") Boolean solve){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数pId：" + cooId +"   solve:" + solve);
        map.put("success", cooperationService.updateCooInfo(cooId,solve));
        return map;
    }

    @RequestMapping(value = "/deleteCooInfo",method = RequestMethod.GET)
    private Map<String, Object> deleteCooInfo(@RequestParam(value = "cooId", required = true) Integer cooId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + cooId);
        map.put("success", cooperationService.deleteCooperation(cooId));
        return map;
    }
}
