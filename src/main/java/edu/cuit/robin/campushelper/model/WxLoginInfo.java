package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:00 2019/5/8
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WxLoginInfo {
    private String code;
    private WxUser userInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public WxUser getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(WxUser userInfo) {
        this.userInfo = userInfo;
    }
}
