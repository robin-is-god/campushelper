package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uId;

    private String loginName;

    private String password;

    private String payPass;

    private Integer rId;

    private Boolean sex;

    private String nickName;

    private String phone;

    private String mail;

    private String picturePath;

    private String address;
    
    private String remark;
    
    private Boolean enable;
    
}
