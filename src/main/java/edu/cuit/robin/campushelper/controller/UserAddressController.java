package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.UserShoppingAddress;
import edu.cuit.robin.campushelper.service.UserShoppingAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:40 2019/4/27
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/address")
public class UserAddressController {
    @Autowired
    private UserShoppingAddressService userShoppingAddressService;

    @RequestMapping(value = "/getAddress",method = RequestMethod.GET)
    private Map<String, Object> getAddress(Integer userId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + userId);
        List list = userShoppingAddressService.queryUserAddress(userId);
        map.put("addressList", list);
        return map;
    }

    @RequestMapping(value = "/getAddressByAid",method = RequestMethod.GET)
    private Map<String, Object> getAddressByAid(Integer aId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + aId);
        map.put("success", userShoppingAddressService.queryAddressByAid(aId));
        return map;
    }

    @RequestMapping(value = "/addAddress",method = RequestMethod.POST)
    private Map<String, Object> addAddress(@RequestBody UserShoppingAddress address){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + address.toString());
        map.put("success", userShoppingAddressService.insertUserAddress(address));
        return map;
    }

    @RequestMapping(value = "/updateAddress",method = RequestMethod.POST)
    private Map<String, Object> updateAddress(@RequestBody UserShoppingAddress address){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + address.toString());
        map.put("success", userShoppingAddressService.updateUserAddress(address));
        return map;
    }

    @RequestMapping(value = "/deleteAddress",method = RequestMethod.GET)
    private Map<String, Object> deleteAddress(@RequestParam(value = "aId", required = true) Integer aId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数:" + aId);
        map.put("success", userShoppingAddressService.deleteUserAddress(aId));
        return map;
    }
}
