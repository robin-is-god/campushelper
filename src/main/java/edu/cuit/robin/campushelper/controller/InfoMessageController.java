package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.InfoMessage;
import edu.cuit.robin.campushelper.model.LostProperty;
import edu.cuit.robin.campushelper.service.InfoMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:36 2019/5/14
 * @ Description : TODO
 */
@RestController
@Slf4j
@RequestMapping("/campushelper/infomessage")
public class InfoMessageController {
    @Autowired
    private InfoMessageService infoMessageService;

    @RequestMapping(value = "/addInfoMessage",method = RequestMethod.POST)
    private Map<String, Object> addInfoMessage(@RequestBody InfoMessage infoMessage){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + infoMessage.toString());
        map.put("success", infoMessageService.insertInfoMessage(infoMessage));
        return map;
    }

    @RequestMapping(value = "/getMessage",method = RequestMethod.POST)
    private Map<String, Object> getMessage(@RequestBody InfoMessage infoMessage){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + infoMessage);
        List list = infoMessageService.queryInfoMessage(infoMessage);
        map.put("msgList", list);
        return map;
    }
}
