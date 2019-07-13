package edu.cuit.robin.campushelper.dao;

import edu.cuit.robin.campushelper.model.UserShoppingAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:03 2019/4/14
 * @ Description : TODO
 */

public interface UserShoppingAddressDao {
    List<UserShoppingAddress> queryUserAddress(@Param(value = "userId") int userId);
    UserShoppingAddress queryAddressByAid(@Param(value = "aId") int aId);
    void updateAddressDefault(@Param(value = "userId") int UserId);

    int insertUserAddress(UserShoppingAddress address);
    int updateUserAddress(UserShoppingAddress address);
    int deleteUserAddress(@Param(value = "aId") int aId);
}
