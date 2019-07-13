package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.CampusInfo;
import edu.cuit.robin.campushelper.service.CampusInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:56 2019/5/5
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/campusinfo")
public class CampusInfoController {
    @Autowired
    private CampusInfoService campusInfoService;

    @RequestMapping(value = "/getAllCampusInfo",method = RequestMethod.GET)
    private Map<String, Object> getAllCampusInfo(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = campusInfoService.queryAllInfo();
        map.put("camInfo", list);
        return map;
    }

    @RequestMapping(value = "/getCampusById",method = RequestMethod.GET)
    private Map<String, Object> getCampusById(Integer ciId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + ciId);
        map.put("camInfo", campusInfoService.queryInfoById(ciId));
        return map;
    }

    @RequestMapping(value = "/getIndexInfo",method = RequestMethod.GET)
    private Map<String, Object> getIndexInfo(){
        Map<String, Object> map = new HashMap<>();
        List list = campusInfoService.queryIndexInfo();
        map.put("infoList", list);
        return map;
    }

    @RequestMapping(value = "/addCampusInfo",method = RequestMethod.POST)
    private Map<String, Object> addAddress(@RequestBody CampusInfo campusInfo){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + campusInfo.toString());
        map.put("success", campusInfoService.insertCampusInfo(campusInfo));
        return map;
    }

    @RequestMapping(value = "/updateCampusInfo",method = RequestMethod.POST)
    private Map<String, Object> updateAddress(@RequestBody CampusInfo campusInfo){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + campusInfo.toString());
        map.put("success", campusInfoService.updateCampusInfo(campusInfo));
        return map;
    }

    @RequestMapping(value = "/deleteCampusInfo",method = RequestMethod.GET)
    private Map<String, Object> deleteAddress(@RequestParam(value = "ciId", required = true) Integer ciId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + ciId);
        map.put("success", campusInfoService.deleteCampusInfo(ciId));
        return map;
    }
}
