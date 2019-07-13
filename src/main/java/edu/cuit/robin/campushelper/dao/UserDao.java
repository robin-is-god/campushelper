package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:53 2019/4/9
 * @ Description : TODO
 */

public interface UserDao {
    /**
     * @Author： robin
     * @Description： //TODO 查询全部用户
     * @Date： 12:07 2019/4/9
     * @Param []
     * @return： java.util.List<edu.cuit.robin.campushelper.model.User>
     **/
    List<User> queryAllUser();
    
    /**
     * @Author： robin
     * @Description： //TODO : 查询全部封禁/启用用户
     * @Date： 11:16 2019/4/11
     * @Param [is_enable]
     * @return： java.util.List<edu.cuit.robin.campushelper.model.User>
     **/
    List<User> queryIsEnableUser(Boolean is_enable);
    
    /**
     * @Author： robin
     * @Description： //TODO :根据昵称模糊查询用户
     * @Date： 14:19 2019/4/11
     * @Param [nickName]
     * @return： java.util.List<edu.cuit.robin.campushelper.model.User>
     **/
    List<User> queryUserByNickName(String nickName);

    /**
     * @Author： robin
     * @Description： //TODO 根据Id查询用户
     * @Date： 12:07 2019/4/9
     * @Param [userId]
     * @return： edu.cuit.robin.campushelper.model.User
     **/
    User queryUserById(Integer uId);

    /**
     * @Author： robin
     * @Description： //TODO 根据用户名查询用户
     * @Date： 12:06 2019/4/9
     * @Param [loginName]
     * @return： edu.cuit.robin.campushelper.model.User
     **/
    User queryUserByLoginName(String loginName);
    
    /**
     * @Author： robin
     * @Description： //TODO :用户登录查询
     * @Date： 10:52 2019/4/12
     * @Param [loginName, password]
     * @return： int
     **/
    User loginUser(String loginName, String password);

    /**
     * @Author： robin
     * @Description： //TODO 添加用户
     * @Date： 12:09 2019/4/9
     * @Param [user]
     * @return： int
     **/
    int insertUser(User user);
    
    /**
     * @Author： robin
     * @Description： //TODO 更新用户
     * @Date： 12:09 2019/4/9
     * @Param [user]
     * @return： int
     **/
    int updateUser(@RequestBody User user);
    
    /**
     * @Author： robin
     * @Description： //TODO 删除用户
     * @Date： 12:09 2019/4/9
     * @Param [userId]
     * @return： int
     **/
    int deleteUser(List idArr);

    int setUserEnable(@Param(value = "uId") int uId);

    int setUserBan(@Param(value = "uId") int uId);

    int setUserCampus(@Param(value = "uId") int uId);

    int setUserNormal(@Param(value = "uId") int uId);
}
