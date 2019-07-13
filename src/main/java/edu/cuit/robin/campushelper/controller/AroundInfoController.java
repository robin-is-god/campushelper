package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.AroundInfo;
import edu.cuit.robin.campushelper.service.AroundInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:41 2019/5/6
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/aroundInfo")
public class AroundInfoController {
    @Autowired
    private AroundInfoService aroundInfoService;

    @RequestMapping(value = "/getAllAroundInfo",method = RequestMethod.GET)
    private Map<String, Object> getAllAroundInfo(@Param(value = "type") String type){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = aroundInfoService.queryInfoByType(type);
        map.put("aroundList", list);
        return map;
    }

    @RequestMapping(value = "/getAroundType",method = RequestMethod.GET)
    private Map<String, Object> getAroundType(){
        Map<String, Object> map = new HashMap<>();
        map.put("typeList", aroundInfoService.queryAroundType());
        return map;
    }

    @RequestMapping(value = "/getAroundById",method = RequestMethod.GET)
    private Map<String, Object> getAroundById(Integer aiId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + aiId);
        map.put("success", aroundInfoService.queryAroundById(aiId));
        return map;
    }

    @RequestMapping(value = "/getUserAroundInfo",method = RequestMethod.GET)
    private Map<String, Object> getUserAroundInfo(Integer userId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + userId);
        List list = aroundInfoService.queryUserAroundInfo(userId);
        map.put("aroundList",list);
        return map;
    }

    @RequestMapping(value = "/addAroundInfo",method = RequestMethod.POST)
    private Map<String, Object> addAddress(@RequestBody AroundInfo aroundInfo){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + aroundInfo.toString());
        map.put("success", aroundInfoService.insertAroundInfo(aroundInfo));
        return map;
    }

    @RequestMapping(value = "/updateAroundInfo",method = RequestMethod.POST)
    private Map<String, Object> updateAddress(@RequestBody AroundInfo aroundInfo){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + aroundInfo.toString());
        map.put("success", aroundInfoService.updateAroundInfo(aroundInfo));
        return map;
    }

    @RequestMapping(value = "/deleteAroundInfo",method = RequestMethod.GET)
    private Map<String, Object> deleteAddress(@RequestParam(value = "aiId", required = true) Integer aiId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + aiId);
        map.put("success", aroundInfoService.deleteAroundInfo(aiId));
        return map;
    }
}
