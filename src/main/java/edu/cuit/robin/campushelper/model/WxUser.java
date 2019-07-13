package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author      : robin.
 * @ Date        : Created in 22:18 2019/5/8
 * @ Description : TODO
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WxUser {
    private String nickName;

    private String avatarUrl;

    private String country;

    private String province;

    private String city;

    private String language;

    private Byte gender;
}
