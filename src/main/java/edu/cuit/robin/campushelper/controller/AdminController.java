package edu.cuit.robin.campushelper.controller;

import edu.cuit.robin.campushelper.model.Good;
import edu.cuit.robin.campushelper.model.LostProperty;
import edu.cuit.robin.campushelper.model.OrderInfo;
import edu.cuit.robin.campushelper.model.User;
import edu.cuit.robin.campushelper.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private LostPorpertyService lostPorpertyService;

    @Autowired
    private AroundInfoService aroundInfoService;

    @Autowired
    private CampusInfoService campusInfoService;

    @Autowired
    private CooperationService cooperationService;



    @RequestMapping("/admin-login")
    public String customerLogin(){
            return "admin-login";
    }

    @RequestMapping("/adminLogin")
    public String customerLogin(
            @RequestParam("loginName") String loginName,
            @RequestParam("password") String password,
            Model model, HttpSession session) {

        User user = userService.loginUser(loginName,password);

        log.info(user.toString());

        if(user != null && user.getRId() == 3) {
            session.setAttribute("adminName", user);
            return "admin-index";
        }else {
            return "error_404";
        }

    }

    /**********商品***************************************/

    @RequestMapping(value="/showGoodList")
    public String showCommodityList(Model model) {

        List<Good> goodList = goodService.queryAllGood();

        model.addAttribute("GoodList", goodList);

        log.info(goodList.toString());

        return "showGoodList";

    }

    @GetMapping(value="/deleteGood")
    public String deleteGood(@RequestParam("gId") int gId) {

        log.info("删除商品传入参数：" + gId);

        goodService.deleteGood(gId);

        return "redirect:/admin/showGoodList";

    }


    /******************失物寻物*******************************/

    @RequestMapping(value="/showLostList")
    public String showLPList(Model model) {

        List<Map<String,Object>> list = lostPorpertyService.queryFindOrLost(false);

        model.addAttribute("lostList", list);

        log.info(list.toString());

        return "showLostList";

    }

    @GetMapping(value="/deleteLostProperty")
    public String deleteUnSolveProperty(@RequestParam("pId") int pId) {

        log.info("删除失物寻物传入参数pId：" + pId);

        lostPorpertyService.deleteLostProperty(pId);

        return "redirect:/admin/showLostList";

    }

    @RequestMapping(value="/showFindList")
    public String showFindList(Model model) {

        List<Map<String,Object>> list = lostPorpertyService.queryFindOrLost(true);

        model.addAttribute("findList", list);

        log.info(list.toString());

        return "showFindList";

    }

    @GetMapping(value="/deleteFindList")
    public String deleteFindList(@RequestParam("pId") int pId) {

        log.info("删除失物寻物传入参数pId：" + pId);

        lostPorpertyService.deleteLostProperty(pId);

        return "redirect:/admin/showFindList";

    }

    /*************************互助资讯********************/

    @RequestMapping(value="/showCooperationList")
    public String showCooperationList(Model model) {

        List<Map<String,Object>> list = cooperationService.queryAllCooperation();

        model.addAttribute("cooperationList", list);

        log.info(list.toString());

        return "showCooperationList";

    }

    @GetMapping(value="/deleteCooperation")
    public String deleteCooperation(@RequestParam("cooId") int cooId) {

        log.info("删除失物寻物传入参数pId：" + cooId);

        cooperationService.deleteCooperation(cooId);

        return "redirect:/admin/showCooperationList";

    }

    /****************************周边资讯*****************/

    @RequestMapping(value="/showAroundList")
    public String showAroundList(Model model) {

        List<Map<String,Object>> list = aroundInfoService.queryAllInfo();

        model.addAttribute("aroundList", list);

        log.info(list.toString());

        return "showAroundList";

    }

    @GetMapping(value="/deleteAround")
    public String deleteAround(@RequestParam("aiId") int aiId) {

        log.info("传入参数aiId：" + aiId);

        aroundInfoService.deleteAroundInfo(aiId);

        return "redirect:/admin/showAroundList";

    }

    /**********************校园资讯*****************/

    @RequestMapping(value="/showCampusList")
    public String showCampusList(Model model) {

        List<Map<String,Object>> list = campusInfoService.queryAllInfo();

        model.addAttribute("campusList", list);

        log.info(list.toString());

        return "showCampusList";

    }

    @GetMapping(value="/deleteCampus")
    public String deleteCampus(@RequestParam("cooId") int cooId) {

        log.info("删除失物寻物传入参数pId：" + cooId);

        campusInfoService.deleteCampusInfo(cooId);

        return "redirect:/admin/showCampusList";

    }


    /********************用户*******************/

    @RequestMapping(value="/showNormalUserList")
    public String showNormalUserList(Model model) {

        List<User> list = userService.queryIsEnableUser(true);

        model.addAttribute("normalUserList", list);

        //log.info(list.toString());

        return "showNormalUserList";

    }

    @GetMapping(value="/setUserBan")
    public String setUserBan(@RequestParam("uId") Integer uId) {

        log.info("传入参数：" + uId);

        userService.setUserBan(uId);

        return "redirect:/admin/showNormalUserList";

    }

    @RequestMapping(value="/showBannedUserList")
    public String showBannedUserList(Model model) {

        List<User> list = userService.queryIsEnableUser(false);

        model.addAttribute("bannedUserList", list);

        //log.info(list.toString());

        return "showBannedUserList";

    }

    @GetMapping(value="/setUserEnable")
    public String setUserEnable(@RequestParam("uId") Integer uId) {

        log.info("传入参数：" + uId);

        userService.setUserEnable(uId);

        return "redirect:/admin/showBannedUserList";

    }

    @GetMapping(value="/setUserCampus")
    public String setUserCampus(@RequestParam("uId") Integer uId) {

        log.info("传入参数：" + uId);

        userService.setUserCampus(uId);

        return "redirect:/admin/showNormalUserList";

    }

    @GetMapping(value="/setUserNormal")
    public String setUserNormal(@RequestParam("uId") Integer uId) {

        log.info("传入参数：" + uId);

        userService.setUserNormal(uId);

        return "redirect:/admin/showNormalUserList";

    }
}
