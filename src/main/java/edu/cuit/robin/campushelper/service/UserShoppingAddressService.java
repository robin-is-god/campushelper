package edu.cuit.robin.campushelper.service;

import edu.cuit.robin.campushelper.model.UserShoppingAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:31 2019/4/27
 * @ Description : TODO
 */

public interface UserShoppingAddressService {
    List<UserShoppingAddress> queryUserAddress(@Param(value = "userId") Integer userId);
    UserShoppingAddress queryAddressByAid(@Param(value = "aId") Integer aId);

    boolean insertUserAddress(UserShoppingAddress address);
    boolean updateUserAddress(UserShoppingAddress address);
    boolean deleteUserAddress(@Param(value = "aId") Integer aId);
}
