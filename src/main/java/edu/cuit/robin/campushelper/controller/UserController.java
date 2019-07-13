package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.commons.model.PageInfo;
import edu.cuit.robin.campushelper.model.User;
import edu.cuit.robin.campushelper.model.WxLoginInfo;
import edu.cuit.robin.campushelper.model.WxUser;
import edu.cuit.robin.campushelper.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 13:22 2019/4/11
 * @ Description : TODO
 */

@RestController
@Slf4j
@RequestMapping("/campushelper/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private WxMaService wxService;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    private PageInfo<List<User>> getAllUser(@RequestParam(defaultValue="1") int page,
                                            @RequestParam(defaultValue="10") int rows) {
        PageInfo<List<User>> result = null;
        log.info("传入参数为:pages:" + page + "rows:" + rows);
        result = userService.queryAllUser(page, rows);
        return result;
    }

//    @RequestMapping(value = "/getAllEnableUser", method = RequestMethod.GET)
//    private PageInfo<List<User>> getAllEnableUser(@RequestParam(defaultValue = "1") boolean enable,
//                                                  @RequestParam(defaultValue="1") int page,
//                                                  @RequestParam(defaultValue="10") int rows) {
//        PageInfo<List<User>> result = null;
//        log.info("传入参数为:enable: " + enable + "pages:" + page + "rows:" + rows);
//        result = userService.queryIsEnableUser(enable, page, rows);
//        return result;
//    }

    @RequestMapping(value = "/getAllUserByNickName", method = RequestMethod.GET)
    private PageInfo<List<User>> getAllUserByNickName(@RequestParam (name = "nickName", required = true) String nickName,
                                                      @RequestParam (name = "page", required = true) int page,
                                                      @RequestParam (name = "rows", required = true) int rows) {
        PageInfo<List<User>> result = null;
        log.info("传入参数为:nickName: " + nickName + "pages:" + page + "rows:" + rows);
        result = userService.queryUserByNickName(nickName, page, rows);
        return result;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + user.toString());
        if(userService.insertUser(user) == true){
            map.put("success", userService.queryUserByLoginName(user.getLoginName()));
        } else {
            map.put("success", userService.queryUserByLoginName(user.getLoginName()));
        }
        return map;
    }

    @RequestMapping(value = "/getUserByUid",method = RequestMethod.GET)
    private Map<String, Object> getUserByUid(Integer uId){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数为: uId:" + uId);
        User user = userService.queryUserById(uId);
        map.put("userInfo", user);
        return map;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private Map<String, Object> login(String loginName, String password){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数为: loginName:" + loginName + ",   password:" + password);
        User user = userService.loginUser(loginName, password);
        map.put("userInfo", user);
        return map;
    }

    @RequestMapping(value = "/loginwx",method = RequestMethod.POST)
    public Map<String,Object> loginByWeixin(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request) {
        log.info("传入参数WxLoginUser" + wxLoginInfo.toString());
        Map<String,Object> map = new HashMap<>();
        String code = wxLoginInfo.getCode();
        WxUser userInfo = wxLoginInfo.getUserInfo();
        if (code == null || userInfo == null) {
            map.put("userInfo","false");
            return map;
        }

        String sessionKey = null;
        String openId = null;
        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sessionKey == null || openId == null) {
            map.put("userInfo","false");
            return map;
        }

        User user = userService.queryUserByLoginName(openId);
        if (user == null) {
            user = new User();
            user.setLoginName(openId);
            user.setPassword(openId);
            user.setPicturePath(userInfo.getAvatarUrl());
            user.setNickName(userInfo.getNickName());
            user.setSex(userInfo.getGender() == 0?true:false);

            userService.insertUser(user);
        } else {
            User updateUser = new User();
            updateUser.setUId(user.getUId());
            updateUser.setLoginName(openId);
            updateUser.setPassword(openId);
            updateUser.setPicturePath(userInfo.getAvatarUrl());
            updateUser.setNickName(userInfo.getNickName());
            updateUser.setSex(userInfo.getGender() == 0?true:false);
            userService.updateUser(updateUser);
        }

        map.put("userInfo",userService.loginUser(openId, openId));
        return map;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    private Map<String, Object> updateAddress(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        log.info("传入参数：" + user.toString());
        map.put("success", userService.updateUser(user));
        return map;
    }
}
