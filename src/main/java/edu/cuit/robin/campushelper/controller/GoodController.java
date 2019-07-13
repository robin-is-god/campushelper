package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.Good;
import edu.cuit.robin.campushelper.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 20:15 2019/4/21
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/getGoodByType",method = RequestMethod.GET)
    private Map<String, Object> getGoodByType(String goodType){
        Map<String, Object> map = new HashMap<>();
        List list = goodService.queryGoodByType(goodType);
        map.put("goodsList", list);
        return map;
    }

    @RequestMapping(value = "/getAllType",method = RequestMethod.GET)
    private Map<String, Object> getAllType(){
        Map<String, Object> map = new HashMap<>();
        List list = goodService.queryAllType();
        map.put("goodsList", list);
        return map;
    }

    @RequestMapping(value = "/getGoodByName",method = RequestMethod.GET)
    private Map<String, Object> getGoodByName(@RequestParam String goodName, @RequestParam String sort, @RequestParam String order){
        Map<String, Object> map = new HashMap<>();
        List list = goodService.queryGoodByName(goodName, sort, order);
        map.put("goodsList", list);
        return map;
    }

    @RequestMapping(value = "/getAllGood",method = RequestMethod.GET)
    private Map<String, Object> getAllGood(){
        Map<String, Object> map = new HashMap<>();
        List list = goodService.queryAllGood();
        map.put("goodsList", list);
        return map;
    }

    @RequestMapping(value = "/getIndexGood",method = RequestMethod.GET)
    private Map<String, Object> getIndexGood(){
        Map<String, Object> map = new HashMap<>();
        List list = goodService.queryIndexGood();
        map.put("goodsList", list);
        return map;
    }

    @RequestMapping(value = "/getGoodById",method = RequestMethod.GET)
    private Map<String, Object> getGoodById(Integer gId){
        Map<String, Object> map = new HashMap<>();
        map.put("good", goodService.queryGoodById(gId));
        return map;
    }

    @RequestMapping(value = "/getUserGood",method = RequestMethod.GET)
    private Map<String, Object> getUserGood(Integer userId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + userId);
        List list = goodService.queryUserGood(userId);
        map.put("goodList",list);
        return map;
    }

    @RequestMapping(value = "/addGood",method = RequestMethod.POST)
    private Map<String, Object> addGood(@RequestBody Good good){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + good.toString());
        map.put("success", goodService.insertGood(good));
        return map;
    }

    @RequestMapping(value = "/updateGood",method = RequestMethod.POST)
    private Map<String, Object> updateGood(@RequestBody Good good){
        Map<String, Object> map = new HashMap<>();
        map.put("success", goodService.updateGood(good));
        return map;
    }

    @RequestMapping(value = "/deleteGood",method = RequestMethod.GET)
    private Map<String, Object> deleteGood(Integer gId){
        Map<String, Object> map = new HashMap<>();
        map.put("success", goodService.deleteGood(gId));
        return map;
    }

    @RequestMapping(value = "/updateGoodStock",method = RequestMethod.GET)
    private Map<String, Object> updateGoodStock(Integer gId){
        Map<String, Object> map = new HashMap<>();
        map.put("success", goodService.updateGoodStock(gId));
        return map;
    }
}
