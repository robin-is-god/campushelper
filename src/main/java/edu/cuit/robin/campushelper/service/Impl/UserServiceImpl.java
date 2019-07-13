package edu.cuit.robin.campushelper.service.Impl;

import com.github.pagehelper.PageHelper;
import edu.cuit.robin.campushelper.commons.model.PageInfo;
import edu.cuit.robin.campushelper.dao.UserDao;
import edu.cuit.robin.campushelper.model.User;
import edu.cuit.robin.campushelper.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 13:02 2019/4/11
 * @ Description : TODO
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<List<User>> queryAllUser(int page, int rows) {
        PageInfo <List<User>> info = new PageInfo<>();
        PageHelper.startPage(page,rows);
        com.github.pagehelper.PageInfo<User> resoult = null;
        List<User> userList = userDao.queryAllUser();
        resoult = new com.github.pagehelper.PageInfo<>(userList);

        info.setTotal(resoult.getTotal());
        info.setRows(resoult.getList());
        return info;
    }

    @Override
    public List<User> queryIsEnableUser(Boolean is_enable) {
//        PageInfo <List<User>> info = new PageInfo<>();
//        PageHelper.startPage(page, rows);
//        com.github.pagehelper.PageInfo<User> resoult = null;
//        List<User> userList = userDao.queryIsEnableUser(is_enable);
//        resoult = new com.github.pagehelper.PageInfo<>(userList);
//
//        info.setTotal(resoult.getTotal());
//        info.setRows(resoult.getList());
//        return info;
        return userDao.queryIsEnableUser(is_enable);
    }

    @Override
    public PageInfo<List<User>> queryUserByNickName(String nickName, int page, int rows) {
        PageInfo <List<User>> info = new PageInfo<>();
        PageHelper.startPage(page, rows);
        com.github.pagehelper.PageInfo<User> resoult = null;
        List<User> userList = userDao.queryUserByNickName(nickName);
        resoult = new com.github.pagehelper.PageInfo<>(userList);

        info.setTotal(resoult.getTotal());
        info.setRows(resoult.getList());
        return info;
    }

    @Override
    public User queryUserById(Integer uId) {
        return userDao.queryUserById(uId);
    }

    @Override
    public User queryUserByLoginName(String loginName) {
        return userDao.queryUserByLoginName(loginName);
    }

    @Override
    public User loginUser(String loginName, String password) {
        return userDao.loginUser(loginName, password);
    }


    @Override
    @Transactional
    public boolean insertUser(User user) {
        User searchUser = new User();
        searchUser = userDao.queryUserByLoginName(user.getLoginName());
        if(searchUser == null){
            if(user.getLoginName() != null && user.getLoginName() != "") {
                try {
                    int rs = userDao.insertUser(user);
                    if (rs > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入失败：" + e.getMessage());
                }
             } else {
                throw new RuntimeException("插入用户名为空。");
            }
        } else {
            throw new RuntimeException("插入用户名已存在。");
        }
    }

    @Override
    public boolean updateUser(@RequestBody User user) {
        if(user.getUId() != null) {
            try {
                int rs = userDao.updateUser(user);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到用户Id为" + user.getLoginName() + "记录。");
        }
    }

    @Override
    public boolean deleteUser(List idArr) {
        try {
            int rs = userDao.deleteUser(idArr);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("删除失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败：" + e.getMessage());
        }
    }

    @Override
    public boolean setUserEnable(@Param(value = "uId") int uId) {
        try {
            int rs = userDao.setUserEnable(uId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("启用失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("启用失败：" + e.getMessage());
        }
    }

    @Override
    public boolean setUserBan(@Param(value = "uId") int uId) {
        try {
            int rs = userDao.setUserBan(uId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("封禁失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("封禁失败：" + e.getMessage());
        }
    }

    @Override
    public boolean setUserCampus(int uId) {
        try {
            int rs = userDao.setUserCampus(uId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("设置校园用户失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("设置校园用户失败：" + e.getMessage());
        }
    }

    @Override
    public boolean setUserNormal(int uId) {
        try {
            int rs = userDao.setUserNormal(uId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("设置校园用户成功！");
            }
        } catch (Exception e) {
            throw new RuntimeException("设置校园用户成功：" + e.getMessage());
        }
    }
}
