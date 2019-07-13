package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.commons.model.PageInfo;
import edu.cuit.robin.campushelper.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:36 2019/4/11
 * @ Description : TODO
 */

public interface UserService {
    /**
     * @Author： robin
     * @Description： //TODO :查询全部用户
     * @Date： 14:20 2019/4/11
     * @Param [page,rows]
     * @return： java.util.List<edu.cuit.robin.campushelper.model.User>
     **/
    PageInfo<List<User>> queryAllUser(int page,int rows);
    
    /**
     * @Author： robin
     * @Description： //TODO :查询全部封禁/启用用户
     * @Date： 14:21 2019/4/11
     * @Param [is_enable,page,rows]
     * @return： java.util.List<edu.cuit.robin.campushelper.model.User>
     **/
    List<User> queryIsEnableUser(Boolean is_enable);

    /**
     * @Author： robin
     * @Description： //TODO :根据昵称模糊查询用户
     * @Date： 14:21 2019/4/11
     * @Param [nickName,page,rows]
     * @return： java.util.List<edu.cuit.robin.campushelper.model.User>
     **/
    PageInfo<List<User>> queryUserByNickName(String nickName, int page, int rows);
    
    /**
     * @Author： robin
     * @Description： //TODO :根据Id查询用户
     * @Date： 14:21 2019/4/11
     * @Param [userId]
     * @return： edu.cuit.robin.campushelper.model.User
     **/
    User queryUserById(Integer uId);

    /**
     * @Author： robin
     * @Description： //TODO :根据用户名查询用户
     * @Date： 14:22 2019/4/11
     * @Param [loginName]
     * @return： edu.cuit.robin.campushelper.model.User
     **/
    User queryUserByLoginName(String loginName);
    
    /**
     * @Author： robin
     * @Description： //TODO :用户登录
     * @Date： 11:00 2019/4/12
     * @Param [loginName, password]
     * @return： boolean
     **/
    User loginUser(String loginName, String password);

    /**
     * @Author： robin
     * @Description： //TODO :添加用户
     * @Date： 14:23 2019/4/11
     * @Param [user]
     * @return： boolean
     **/
    boolean insertUser(User user);
    
    /**
     * @Author： robin
     * @Description： //TODO :更新用户
     * @Date： 14:23 2019/4/11
     * @Param [user]
     * @return： boolean
     **/
    boolean updateUser(@RequestBody User user);
    
    /**
     * @Author： robin
     * @Description： //TODO :删除用户
     * @Date： 14:24 2019/4/11
     * @Param [userId]
     * @return： boolean
     **/
    boolean deleteUser(List idArr);

    boolean setUserEnable(@Param(value = "uId") int uId);

    boolean setUserBan(@Param(value = "uId") int uId);

    boolean setUserCampus(@Param(value = "uId") int uId);

    boolean setUserNormal(@Param(value = "uId") int uId);
    
}
