package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.UserShoppingAddressDao;
import edu.cuit.robin.campushelper.model.UserShoppingAddress;
import edu.cuit.robin.campushelper.service.UserShoppingAddressService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:32 2019/4/27
 * @ Description : TODO
 */

@Service
public class UserShoppingAddressServiceImpl implements UserShoppingAddressService {
    @Autowired
    private UserShoppingAddressDao userShoppingAddressDao;

    @Override
    public List<UserShoppingAddress> queryUserAddress(@Param(value = "userId") Integer userId) {
        return userShoppingAddressDao.queryUserAddress(userId);
    }

    @Override
    public UserShoppingAddress queryAddressByAid(@Param(value = "aId") Integer aId) {
        return userShoppingAddressDao.queryAddressByAid(aId);
    }


    @Override
    public boolean insertUserAddress(UserShoppingAddress address) {
        if(address != null){
            if(address.getAddress() != null && address.getAddress() != "") {
                try {
                    if(address.isDefaulted() == true && address.getUserId() != null) {
                        userShoppingAddressDao.updateAddressDefault(address.getUserId());
                    }
                    int rs = userShoppingAddressDao.insertUserAddress(address);
                    if (rs > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入失败：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("插入地址为空。");
            }
        } else {
            throw new RuntimeException("插入地址数据为空。");
        }
    }

    @Override
    public boolean updateUserAddress(UserShoppingAddress address) {
        if(address.getAId() != null) {
            try {
                if(address.isDefaulted() == true && address.getUserId() != null) {
                    userShoppingAddressDao.updateAddressDefault(address.getUserId());
                }
                int rs = userShoppingAddressDao.updateUserAddress(address);
                if (rs > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("找不到用户地址Id为" + address.getAId() + "记录。");
        }
    }

    @Override
    public boolean deleteUserAddress(@Param(value = "aId") Integer aId) {
        try {
            int rs = userShoppingAddressDao.deleteUserAddress(aId);
            if (rs > 0) {
                return true;
            } else {
                throw new RuntimeException("删除失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("删除失败：" + e.getMessage());
        }
    }
}
