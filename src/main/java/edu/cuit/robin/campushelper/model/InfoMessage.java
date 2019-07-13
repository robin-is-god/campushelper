package edu.cuit.robin.campushelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:15 2019/5/14
 * @ Description : TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoMessage {
    private Integer mId;

    private Integer cooId;

    private Integer aiId;

    private Integer pId;

    private Integer userId;

    private String content;

    private Date createTime;
}
