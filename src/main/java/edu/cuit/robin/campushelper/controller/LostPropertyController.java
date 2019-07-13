package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.LostProperty;
import edu.cuit.robin.campushelper.service.LostPorpertyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 21:25 2019/4/25
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/lostProperty")
public class LostPropertyController {
    @Autowired
    private LostPorpertyService lostPorpertyService;

    @RequestMapping(value = "/getLPByFindOrLost",method = RequestMethod.GET)
    private Map<String, Object> getLPByFindOrLost(boolean findOrLost){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + findOrLost);
        List list = lostPorpertyService.queryFindOrLost(findOrLost);
        map.put("propertyList", list);
        return map;
    }

    @RequestMapping(value = "/getUserPropery",method = RequestMethod.GET)
    private Map<String, Object> getUserPropery(Integer userId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + userId);
        List list = lostPorpertyService.queryUserProperty(userId);
        map.put("propertyList",list);
        return map;
    }

    @RequestMapping(value = "/getLPById",method = RequestMethod.GET)
    private Map<String, Object> getLPById(Integer pId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + pId);
        map.put("success", lostPorpertyService.queryInfoByPid(pId));
        return map;
    }

    @RequestMapping(value = "/addProperty",method = RequestMethod.POST)
    private Map<String, Object> addProperty(@RequestBody LostProperty lostProperty){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + lostProperty.toString());
        map.put("success", lostPorpertyService.insertLostProperty(lostProperty));
        return map;
    }

    @RequestMapping(value = "/updateProperty",method = RequestMethod.GET)
    private Map<String, Object> updateAddress(@Param(value = "pId") int pId, @Param(value = "solve") Boolean solve){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数pId：" + pId +"   solve:" + solve);
        map.put("success", lostPorpertyService.updateLostProperty(pId,solve));
        return map;
    }

    @RequestMapping(value = "/deleteProperty",method = RequestMethod.GET)
    private Map<String, Object> deleteAddress(@RequestParam(value = "pId", required = true) Integer pId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + pId);
        map.put("success", lostPorpertyService.deleteLostProperty(pId));
        return map;
    }
}
