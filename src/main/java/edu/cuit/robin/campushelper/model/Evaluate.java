package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 11:42 2019/4/9
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evaluate {
    private Integer oId;

    private Integer eId;

    private Integer gId;

    private Integer userId;

    private float score;

    private String content;

    private Date createTime;

    private String evaPic;
}
