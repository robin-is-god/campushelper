package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 23:16 2019/4/8
 * @ Description : TODO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserShoppingAddress {
    private Integer aId;

    private Integer userId;

    private String name;

    private String address;

    private String phone;

    private Date createTime;

    private boolean defaulted;

    private String remark;

    private Integer deleted;

}
