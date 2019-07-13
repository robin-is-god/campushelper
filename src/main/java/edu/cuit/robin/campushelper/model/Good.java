package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 18:35 2019/4/7
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    private Integer gId;

    private Integer userId;

    private String goodName;

    private String goodDescription;

    private String goodPic;

    private String goodType;

    private BigDecimal goodPrice;

    private Integer goodStock;

    private Boolean enable;

    private Date createTime;

    private Integer deleted;
}
